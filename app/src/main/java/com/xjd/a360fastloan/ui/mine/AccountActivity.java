package com.xjd.a360fastloan.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.BaseBean;
import com.lm.lib_common.utils.GridViewAdapter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityAccountBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;
import com.xjd.a360fastloan.model.mine.RechargesBean;
import com.xjd.a360fastloan.ui.mian.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AccountActivity extends BaseActivity<BasePresenter,ActivityAccountBinding> {


    private ArrayList mList;
    private GridViewAdapter mAdapter;
    private String money="";
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
    protected void initData() {
        super.initData();
        mBinding.llyHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
        GridView gridView=(GridView) findViewById(R.id.gridView);

        gridView.setAdapter(mAdapter);

        //gridView的点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //把点击的position传递到adapter里面去
                mAdapter.changeState(position);

                TextView textView = (TextView) view.findViewById(R.id.tv);
                money=textView.getText().toString();
                showToast(""+position);
            }
        });

        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money.length()>0)
                {
                    Api.getApi().getRecharges(money)
                            .compose(callbackOnIOToMainThread())
                            .subscribe(new BaseNetListener<RechargesBean>(AccountActivity.this, false) {
                                @Override
                                public void onSuccess(RechargesBean userInfoModel) {

                                }

                                @Override
                                public void onFail(String errMsg) {

                                }
                            });
                }else
                    {
                        showToast("请选择充值余额");
                    }
            }
        });

    }
}
