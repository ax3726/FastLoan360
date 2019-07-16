package com.xjd.a360fastloan.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityOrderPayBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;
import com.xjd.a360fastloan.ui.mine.AddBankCardActivity;
import com.xjd.a360fastloan.ui.mine.OrderActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderPayActivity extends BaseActivity<BasePresenter, ActivityOrderPayBinding> {

    private String mId = "";
    private String price = "";
    private List<UserInfoModel.CardBean> mDataList = new ArrayList<>();
    private CommonAdapter<UserInfoModel.CardBean> mAdapter;
    private boolean is = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_pay;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("支付方式");
    }

    @Override
    protected void initData() {
        super.initData();
        mId = getIntent().getStringExtra("id");
        price = getIntent().getStringExtra("price");
        is = getIntent().getBooleanExtra("is", false);
        mBinding.tvPrice.setText("需支付：" + price + "元");

        mAdapter = new CommonAdapter<UserInfoModel.CardBean>(aty, R.layout.item_bank_list, mDataList) {
            @Override
            protected void convert(ViewHolder holder, UserInfoModel.CardBean item, int position) {
                holder.setText(R.id.tv_bank, !TextUtils.isEmpty(item.getNumber()) && item.getNumber().length() >= 4
                        ? item.getName() + "(" + item.getNumber().substring(item.getNumber().length() - 4, item.getNumber().length()) + ")" : item.getName())
                        .setImageurl(R.id.img, item.getLogo(), 0)
                        .setSelect(R.id.img_select, item.isIs_select())

                        .setOnClickListener(R.id.rly_item, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                for (UserInfoModel.CardBean item : mDataList) {
                                    item.setIs_select(false);
                                }
                                mDataList.get(position).setIs_select(true);
                                notifyDataSetChanged();
                            }
                        });
                View view_line = holder.getView(R.id.view_line);
                view_line.setVisibility(position == mDataList.size() - 1 ? View.INVISIBLE : View.VISIBLE);
            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setNestedScrollingEnabled(false);
        mBinding.rcBody.setAdapter(mAdapter);
    }

    private void getUserInfo() {
        Api.getApi().getUserInfo()
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<UserInfoModel>(this, true) {
                    @Override
                    public void onSuccess(UserInfoModel userInfoModel) {
                        MyApplication.getInstance().setUserInfo(userInfoModel);
                        mDataList.clear();
                        if (userInfoModel.getCard() != null && userInfoModel.getCard().size() > 0) {
                            mDataList.addAll(userInfoModel.getCard());
                            mDataList.get(0).setIs_select(true);
                        }
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }


    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddBankCardActivity.class);
            }
        });
        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoModel.CardBean choose = null;
                for (UserInfoModel.CardBean item : mDataList) {
                    if (item.isIs_select()) {
                        choose = item;
                        break;
                    }
                }
                if (choose != null) {
                    pay(choose.getId() + "");
                } else {
                    showToast("请选择银行卡！");
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserInfo();
    }

    private void pay(String card_id) {
        Api.getApi().pay(is ? "recharges" : "orders", mId, card_id)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<String>(this, true) {
                    @Override
                    public void onSuccess(String s) {
                        showToast("支付成功!");
                        if (!is) {
                            startActivity(OrderActivity.class);
                        }
                        finish();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });

    }

}
