package com.xjd.a360fastloan.ui.mine;

import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityPersonalBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;
import com.xjd.a360fastloan.ui.home.AddContactInfoActivity;
import com.xjd.a360fastloan.ui.home.AddIdCardActivity;

public class PersonalActivity extends BaseActivity<BasePresenter, ActivityPersonalBinding> {
    private UserInfoModel mUserInfoModel = null;

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
                if (mUserInfoModel == null) {
                    return;
                }
                if (mBinding.tvJiben.isSelected()) {
                    startActivity(AddIdCardActivity.class);
                } else {
                    startActivity(BaiseInformationActivity.class);
                }

            }
        });
        mBinding.tvGongzuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUserInfoModel == null) {
                    return;
                }
                if (mBinding.tvJiben.isSelected()) {
                    startActivity(AddIdCardActivity.class);
                } else {
                    if (mBinding.tvGongzuo.isSelected()) {
                        startActivity(AddJobActivity.class);
                    } else {
                        startActivity(JobActivity.class);
                    }
                }
            }
        });
        mBinding.tvLianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUserInfoModel == null) {
                    return;
                }
                if (mBinding.tvJiben.isSelected()) {
                    startActivity(AddIdCardActivity.class);
                } else {
                    if (mBinding.tvLianxi.isSelected()) {
                        startActivity(AddContactInfoActivity.class);
                    } else {
                        startActivity(LinkmanActivity.class);
                    }
                }
            }
        });
        mBinding.tvBankcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUserInfoModel == null) {
                    return;
                }
                if (mBinding.tvJiben.isSelected()) {
                    startActivity(AddIdCardActivity.class);
                } else {
                    if (mBinding.tvBankcard.isSelected()) {
                        startActivity(AddBankCardActivity.class);
                    } else {//英航卡列表
                        startActivity(BankcardActivity.class);
                    }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserInfo();
    }


    private void getUserInfo() {
        Api.getApi().getUserInfo()
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<UserInfoModel>(this, true) {
                    @Override
                    public void onSuccess(UserInfoModel userInfoModel) {
                        MyApplication.getInstance().setUserInfo(userInfoModel);
                        mUserInfoModel = userInfoModel;
                        mBinding.tvJiben.setText(userInfoModel.getInfo() != null ? "已认证" : "未认证");
                        mBinding.tvJiben.setSelected(userInfoModel.getInfo() == null);

                        mBinding.tvGongzuo.setText(userInfoModel.getJob() != null ? "已完成" : "未完成");
                        mBinding.tvGongzuo.setSelected(userInfoModel.getJob() == null);

                        mBinding.tvLianxi.setText(userInfoModel.getRelation() != null && userInfoModel.getRelation().size() > 0 ? "已完成" : "未完成");
                        mBinding.tvLianxi.setSelected(userInfoModel.getRelation() == null || userInfoModel.getRelation().size() == 0);

                        mBinding.tvBankcard.setText(userInfoModel.getCard() != null && userInfoModel.getCard().size() > 0 ? "已完成" : "未完成");
                        mBinding.tvBankcard.setSelected(userInfoModel.getCard() == null || userInfoModel.getCard().size() == 0);

                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

}
