package com.xjd.a360fastloan.ui.mian;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.model.LoginEvent;
import com.lm.lib_common.utils.DoubleClickExitHelper;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityMainBinding;
import com.xjd.a360fastloan.ui.home.HomeFragment;
import com.xjd.a360fastloan.ui.mine.MineFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<BasePresenter, ActivityMainBinding> {

    private HomeFragment mHomeFragment;

    private MineFragment mMineFragment;
    private FragmentManager mFm;
    private FragmentTransaction mTransaction;
    private List<Fragment> mFragments = new ArrayList<>();
    private DoubleClickExitHelper mDoubleClickExit;//

    @Override
    protected boolean isTitleBar() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        mBinding.rgButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        if (currentFragmentPosition != 0) {
                            changeFragment(0);
                        }
                        break;
                    case R.id.rb_mine:
                        if (currentFragmentPosition != 1) {
                            changeFragment(1);
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mDoubleClickExit = new DoubleClickExitHelper(this);
        initFragment();
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mMineFragment = new MineFragment();
        mFragments.add(mHomeFragment);
        mFragments.add(mMineFragment);
        mFm = getSupportFragmentManager();
        mTransaction = mFm.beginTransaction();
        mTransaction.add(R.id.fly_body, mFragments.get(0), "index_0");
        mTransaction.show(mFragments.get(0));
        mTransaction.commitAllowingStateLoss();
    }

    private int currentFragmentPosition = 0;

    public void changeFragment(final int position) {
        mFm = getSupportFragmentManager();
        mTransaction = mFm.beginTransaction();
        if (mFragments.get(position) != null) {
            if (position != currentFragmentPosition) {
                mTransaction.hide(mFragments.get(currentFragmentPosition));
                if (!mFragments.get(position).isAdded()) {
                    mTransaction.add(R.id.fly_body, mFragments.get(position), "index_" + position);
                }
                mTransaction.show(mFragments.get(position));
                mTransaction.commitAllowingStateLoss();
            }
            currentFragmentPosition = position;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return mDoubleClickExit.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
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
