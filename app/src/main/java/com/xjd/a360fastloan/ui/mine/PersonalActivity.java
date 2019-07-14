package com.xjd.a360fastloan.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityPersonalBinding;
import com.xjd.a360fastloan.ui.home.AddContactInfoActivity;
import com.xjd.a360fastloan.ui.home.AddIdCardActivity;

public class PersonalActivity extends BaseActivity<BasePresenter,ActivityPersonalBinding> {



    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("个人信息");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvJiben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddIdCardActivity.class);
            }
        });
        mBinding.tvLianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddContactInfoActivity.class);
            }
        });
        mBinding.tvBankcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddBankCardActivity.class);
            }
        });
    }
}
