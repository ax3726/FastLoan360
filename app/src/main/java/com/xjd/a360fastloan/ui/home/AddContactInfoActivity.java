package com.xjd.a360fastloan.ui.home;

import android.text.TextUtils;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.databinding.ActivityAddContactInfoBinding;

import cn.qqtheme.framework.picker.OptionPicker;

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
                addRelation();
            }
        });
        mBinding.tvRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"亲属", "配偶", "同事", "同学"};
                OptionPicker picker = new OptionPicker(aty, strings);
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvRelation.setText(s);
                    }
                });
                picker.show();
            }
        });
    }

    private void addRelation() {
        String relation = mBinding.tvRelation.getText().toString().trim();
        String name = mBinding.etName.getText().toString().trim();
        String phone = mBinding.etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(relation)) {
            showToast("请选择关系!");
            return;
        }
        if (TextUtils.isEmpty(name)) {
            showToast("请输入姓名!");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            showToast("请输入手机号!");
            return;
        }
        Api.getApi().addRelation(name, phone, relation)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<String>(this, true) {
                    @Override
                    public void onSuccess(String idCardModel) {
                        showToast("添加成功!");
                        finish();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }
}
