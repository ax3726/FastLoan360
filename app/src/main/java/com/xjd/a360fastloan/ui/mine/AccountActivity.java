package com.xjd.a360fastloan.ui.mine;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.utils.GridViewAdapter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.Link;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityAccountBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;
import com.xjd.a360fastloan.model.mine.RechargesBean;
import com.xjd.a360fastloan.ui.common.WebViewActivity;

import java.util.ArrayList;

public class AccountActivity extends BaseActivity<BasePresenter, ActivityAccountBinding> {


    private ArrayList mList;
    private GridViewAdapter mAdapter;
    private String money = "";
    private String card_id = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return false;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(aty, WebViewActivity.class).putExtra("url", Link.AGREE_WITH_HOLD));
            }
        });
        mBinding.llyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.imgCheck.setSelected(!mBinding.imgCheck.isSelected());
            }
        });
        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean selected = mBinding.imgCheck.isSelected();
                if (!selected) {
                    showToast("请接受协议!");
                    return;
                }
                if (TextUtils.isEmpty(card_id)) {
                    showToast("暂无银行卡!");
                    return;
                }
                if (money.length() > 0) {
                    Api.getApi().getRecharges(money)
                            .compose(callbackOnIOToMainThread())
                            .subscribe(new BaseNetListener<RechargesBean>(AccountActivity.this, true) {
                                @Override
                                public void onSuccess(RechargesBean userInfoModel) {
                                    pay(userInfoModel.getRecharge_id(), card_id);
                                }

                                @Override
                                public void onFail(String errMsg) {

                                }
                            });
                } else {
                    showToast("请选择充值余额");
                }
            }
        });
    }

    private void getUserInfo() {
        Api.getApi().getUserInfo()
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<UserInfoModel>(this, true) {
                    @Override
                    public void onSuccess(UserInfoModel userInfoModel) {
                        MyApplication.getInstance().setUserInfo(userInfoModel);
                        if (userInfoModel.getCard() != null && userInfoModel.getCard().size() > 0) {
                            card_id = userInfoModel.getCard().get(0).getId() + "";
                        }

                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

    private void pay(String recharge_id, String card_id) {
        Api.getApi().pay("recharges", recharge_id, card_id)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<String>(this, true) {
                    @Override
                    public void onSuccess(String s) {
                        showToast("支付成功!");
                        finish();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });

    }

    @Override
    protected void initData() {
        super.initData();
        mBinding.llyHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getUserInfo();
        mList = new ArrayList<>();
        mList.add("5");
        mList.add("10");
        mList.add("20");
        mList.add("50");
        mList.add("100");
        mList.add("200");
        mList.add("500");
        mList.add("800");
        mList.add("1000");
        mBinding.tvAccount.setText(MyApplication.getInstance().getUserInfo().getBalance());
        mAdapter = new GridViewAdapter(AccountActivity.this, mList);
        GridView gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(mAdapter);

        //gridView的点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //把点击的position传递到adapter里面去
                mAdapter.changeState(position);

                TextView textView = (TextView) view.findViewById(R.id.tv);
                money = textView.getText().toString();
            }
        });


    }
}
