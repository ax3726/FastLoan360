package com.xjd.a360fastloan.ui.mine;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityBaiseInformationBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;

public class BaiseInformationActivity extends BaseActivity<BasePresenter, ActivityBaiseInformationBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_baise_information;
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

        UserInfoModel userInfo = MyApplication.getInstance().getUserInfo();
        if (userInfo != null && userInfo.getInfo() != null) {
            mBinding.tv01.setText(userInfo.getInfo().getName());
            mBinding.tv02.setText(userInfo.getInfo().getSex());
            mBinding.tv03.setText(userInfo.getInfo().getId_card());
            mBinding.tv04.setText(userInfo.getInfo().getEducation());
            mBinding.tv05.setText(userInfo.getInfo().getMarriage());
        }
    }
}
