package com.xjd.a360fastloan.ui.mine;

import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.databinding.ActivityProposalBinding;

public class ProposalActivity extends BaseActivity<BasePresenter, ActivityProposalBinding> {

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("意见反馈");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_proposal;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();

        mBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mBinding.etContent.getText().toString();
                String contact = mBinding.etContent.getText().toString();
                if (content.isEmpty()) {
                    showToast("建议内容不能为空");
                    return;
                }

                if (contact.isEmpty()) {
                    showToast("联系电话不能为空");
                    return;
                }
                Api.getApi().getFeedback(content, contact)
                        .compose(callbackOnIOToMainThread())
                        .subscribe(new BaseNetListener<String>(ProposalActivity.this, true) {
                            @Override
                            public void onSuccess(String userInfoModel) {
                                showToast("提交成功");
                                finish();
                            }

                            @Override
                            public void onFail(String errMsg) {

                            }
                        });
            }
        });
    }
}
