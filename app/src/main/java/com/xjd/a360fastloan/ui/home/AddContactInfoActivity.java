package com.xjd.a360fastloan.ui.home;

import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAddContactInfoBinding;

public class AddContactInfoActivity extends BaseActivity<BasePresenter, ActivityAddContactInfoBinding> {



    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_contact_info;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
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

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AffirmBankActivity.class);
            }
        });
    }
}
