package com.xjd.a360fastloan.ui.mine;


import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityLinkmainBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;

public class LinkmanActivity extends BaseActivity<BasePresenter, ActivityLinkmainBinding> {


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
        UserInfoModel userInfo = MyApplication.getInstance().getUserInfo();
        if (userInfo != null && userInfo.getRelation() != null) {
            if (userInfo.getRelation().size() > 0) {
                UserInfoModel.RelationBean relationBean = userInfo.getRelation().get(0);
                mBinding.tv01.setText(relationBean.getRelation());
                mBinding.tv02.setText(relationBean.getMobile());
                mBinding.tv03.setText(relationBean.getName());
            }
        }
    }
}


