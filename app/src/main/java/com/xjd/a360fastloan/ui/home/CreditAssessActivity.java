package com.xjd.a360fastloan.ui.home;


import android.view.View;


import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityCreditAssessBinding;



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
    }

}
