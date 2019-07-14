package com.xjd.a360fastloan.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAddBankCardBinding;

public class AddBankCardActivity extends BaseActivity<BasePresenter,ActivityAddBankCardBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_bank_card;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("添加银行卡");
    }
}
