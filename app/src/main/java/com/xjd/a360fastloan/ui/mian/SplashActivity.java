package com.xjd.a360fastloan.ui.mian;

import android.text.TextUtils;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.LoginEvent;
import com.lm.lib_common.utils.SharedPreferencesUtils;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.Constant;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivitySplashBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SplashActivity extends BaseActivity<BasePresenter, ActivitySplashBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return false;
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        String token_type   = (String) SharedPreferencesUtils.getParam(aty, Constant.TOKEN_TYPE, "");
        String access_token = (String) SharedPreferencesUtils.getParam(aty, Constant.ACCESS_TOKEN, "");
        if (!TextUtils.isEmpty(token_type) && !TextUtils.isEmpty(access_token)) {
            MyApplication.getInstance().setToken_type(token_type);
            MyApplication.getInstance().setAccess_token(access_token);
            getUserInfo();

        } else {
            toLogin();
        }

    }

    private void getUserInfo() {
        Api.getApi().getUserInfo()
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<UserInfoModel>(this, false) {
                    @Override
                    public void onSuccess(UserInfoModel userInfoModel) {
                        MyApplication.getInstance().setUserInfo(userInfoModel);
                        toMain();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

    /**
     * 跳转登录
     */
    private void toLogin() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(LoginActivity.class);

                finish();

            }
        }.start();
    }

    /**
     * 跳转主页面
     */
    private void toMain() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(MainActivity.class);

                finish();

            }
        }.start();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void toLogin(LoginEvent event) {
        startActivity(LoginActivity.class);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
