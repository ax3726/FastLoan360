package com.xjd.a360fastloan.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityJobInformationBinding;

public class JobInformationActivity extends BaseActivity<BasePresenter,ActivityJobInformationBinding> {



    @Override
    protected int getLayoutId() {
        return R.layout.activity_job_information;
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
        mTitleBarLayout.setTitle("基本信息");
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
