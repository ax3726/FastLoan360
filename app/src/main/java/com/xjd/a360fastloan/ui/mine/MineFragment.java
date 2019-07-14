package com.xjd.a360fastloan.ui.mine;

import android.view.View;

import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;
import com.lm.lib_common.utils.dialog.MyItemDialogListener;
import com.lm.lib_common.utils.dialog.StytledDialog;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.FragmentMineBinding;
import com.xjd.a360fastloan.ui.mian.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：LiMing
 * @date ：2019-06-17
 * @desc ：
 */
public class MineFragment extends BaseFragment<BaseFragmentPresenter, FragmentMineBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        mBinding.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> strings = new ArrayList<>();
                strings.add("拍照");
                strings.add("从相册选择");
                StytledDialog.showBottomItemDialog(getActivity(), strings, "安全退出", true, true, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(String text, int position) {
                        showToast(text + position);
                        switch (position) {
                            case 0:
//                                doPhoto();
                                break;
                            case 1:
//                                pickphoto();
                                break;
                        }
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("onItemClick");
                    }
                });
            }
        });
        mBinding.tv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PersonalActivity.class);
            }
        });
        mBinding.tv02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AccountActivity.class);
            }

        });
        mBinding.tv03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(OrderActivity.class);
            }
        });
        mBinding.tv05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ProposalActivity.class);
            }
        });
        mBinding.tv06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AboutActivity.class);
            }
        });
        mBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoginActivity.class);
            }
        });
    }


//    @Override
//    public void photoSuccess(String path, File file, int... queue) {
//        if (!TextUtils.isEmpty(path)) {
////            if (mType == 0) {
////                Glide.with(aty).load(file).into(mBinding.imgJust);
////            } else {
////                Glide.with(aty).load(file).into(mBinding.imgBack);
////            }
//        }
//    }
//
//    @Override
//    public void photoFaild() {
//
//    }
}
