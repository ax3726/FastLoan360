package com.xjd.a360fastloan.ui.home;


import android.content.Intent;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Link;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityCreditAssessBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;
import com.xjd.a360fastloan.ui.common.WebViewActivity;


public class CreditAssessActivity extends BaseActivity<BasePresenter, ActivityCreditAssessBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_credit_assess;
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
        mBinding.llyLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBinding.tvLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SmartRecommendActivity.class);
            }
        });
        mBinding.tvAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(aty, WebViewActivity.class).putExtra("url", Link.AGREE_ASSESSMENT));
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        int Min = 760;

        int Max = 800;

        int result = Min + (int) (Math.random() * ((Max - Min) + 1));

        mBinding.tvNum.setText(String.valueOf(result));
        UserInfoModel userInfo = MyApplication.getInstance().getUserInfo();
        if (userInfo != null && userInfo.getProduct() != null) {
            mBinding.tvPrice.setText("服务费：" + userInfo.getProduct().getPrice() + "借币");
        }
    }
}
