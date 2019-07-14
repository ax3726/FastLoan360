package com.xjd.a360fastloan.ui.mian;

import android.text.TextUtils;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.utils.SharedPreferencesUtils;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.Constant;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityLoginBinding;
import com.xjd.a360fastloan.model.main.LoginModel;

public class LoginActivity extends BaseActivity<BasePresenter, ActivityLoginBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isTitleBar() {
        return false;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        mBinding.tvCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = mBinding.etPhone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    showToast("号码不能为空!");
                    return;
                }
                getCode(phone);
            }
        });
    }
    private void getCode(String phone)
    {
        Api.getApi().getCode(phone)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<String>(this,true) {
                    @Override
                    public void onSuccess(String s) {
                        showToast("发送成功!");
                    }

                    @Override
                    public void onFail(String errMsg) {
                        showToast("哈哈"+errMsg);
                    }
                });
    }
    private void login()
    {
        String phone = mBinding.etPhone.getText().toString();
        String code = mBinding.etCode.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            showToast("号码不能为空!");
            return;
        }

        if (TextUtils.isEmpty(code)) {
            showToast("验证码不能为空!");
            return;
        }
        Api.getApi().login(phone,code)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<LoginModel>(this,true) {
                    @Override
                    public void onSuccess(LoginModel model) {
                        SharedPreferencesUtils.setParam(aty,Constant.TOKEN_TYPE,model.getToken_type());
                        SharedPreferencesUtils.setParam(aty,Constant.ACCESS_TOKEN,model.getAccess_token());
                        MyApplication.getInstance().setToken_type(model.getToken_type());
                        MyApplication.getInstance().setAccess_token(model.getAccess_token());
                        startActivity(MainActivity.class);
                        finish();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }
}
