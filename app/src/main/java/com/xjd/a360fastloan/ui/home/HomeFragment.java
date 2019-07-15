package com.xjd.a360fastloan.ui.home;

import android.content.Intent;
import android.view.View;

import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.FragmentHomeBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;

/**
 * @author ：LiMing
 * @date ：2019-06-17
 * @desc ：
 */
public class HomeFragment extends BaseFragment<BaseFragmentPresenter, FragmentHomeBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setLeftShow(false);
        mTitleBarLayout.setLineShow(false);
        mTitleBarLayout.setTitle("360极速借");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfoModel userInfo = MyApplication.getInstance().getUserInfo();
                if (userInfo != null && userInfo.getInfo() != null && userInfo.getProduct() != null) {
                    startActivity(new Intent(aty, ProductInfoActivity.class).putExtra("id", userInfo.getProduct().getId()));
                } else {
                    startActivity(AddIdCardActivity.class);
                }

            }
        });

    }


}
