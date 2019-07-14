package com.xjd.a360fastloan.ui.mine;



import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityLinkmainBinding;

public class LinkmanActivity extends BaseActivity<BasePresenter,ActivityLinkmainBinding> {



    @Override
    protected int getLayoutId() {
        return R.layout.activity_linkmain;
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
        mTitleBarLayout.setTitle("联系人信息");
    }

    @Override
    protected void initData() {
        super.initData();
    }
}


