package com.xjd.a360fastloan.ui.home;

import android.view.View;

import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;
import com.lm.lib_common.base.BaseNetListener;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.databinding.FragmentHomeBinding;

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
                startActivity(AddIdCardActivity.class);
            }
        });

    }


}
