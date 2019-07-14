package com.xjd.a360fastloan.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAboutBinding;

public class AboutActivity extends BaseActivity<BasePresenter,ActivityAboutBinding> {

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
       mTitleBarLayout.setTitle("关于我们");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
