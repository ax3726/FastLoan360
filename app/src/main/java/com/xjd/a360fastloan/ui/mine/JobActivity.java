package com.xjd.a360fastloan.ui.mine;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityJobBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;

public class JobActivity extends BaseActivity<BasePresenter, ActivityJobBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_job;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("工作信息");
    }

    @Override
    protected void initData() {
        super.initData();
        UserInfoModel userInfo = MyApplication.getInstance().getUserInfo();
        if (userInfo != null && userInfo.getJob() != null) {
            mBinding.tv1.setText(userInfo.getJob().getType());
            mBinding.tv2.setText(userInfo.getJob().getName());
            mBinding.tv3.setText(userInfo.getJob().getAddress());
            mBinding.tv4.setText(userInfo.getJob().getPhone());
            mBinding.tv5.setText(userInfo.getJob().getIncome());
            mBinding.tv6.setText(userInfo.getJob().getIntime());
        }
    }
}
