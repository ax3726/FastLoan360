package com.xjd.a360fastloan.ui.home;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.utils.dialog.MyItemDialogListener;
import com.lm.lib_common.utils.dialog.StytledDialog;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.databinding.ActivityAddIdCardBinding;
import com.xjd.a360fastloan.model.home.IdCardModel;
import com.xjd.a360fastloan.ui.common.PhotoActivity;
import com.xjd.a360fastloan.widget.dialog.BackDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.picker.OptionPicker;

public class AddIdCardActivity extends PhotoActivity<BasePresenter, ActivityAddIdCardBinding> {

    private int mType = 0;//0 正面 1 反面

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_id_card;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("基本信息");
        mTitleBarLayout.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackDialog backDialog = new BackDialog(aty, new BackDialog.BackDialogListener() {
                    @Override
                    public void onback() {
                        finish();
                    }
                });
                backDialog.show();
            }
        });

    }

    private void check() {
        String no = mBinding.etIdcardNo.getText().toString().trim();
        if (TextUtils.isEmpty(no)) {
            return;
        }
        Api.getApi().checkId_card("id_card", no)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<IdCardModel>(this, true) {
                    @Override
                    public void onSuccess(IdCardModel idCardModel) {
                        String name      = mBinding.etName.getText().toString().trim();
                        String no        = mBinding.etIdcardNo.getText().toString().trim();
                        String address   = mBinding.etAddress.getText().toString().trim();
                        String education = mBinding.tvEducation.getText().toString().trim();
                        String sex       = mBinding.tvSex.getText().toString().trim();
                        String marriage  = mBinding.tvState.getText().toString().trim();
                        education = "本科";
                        marriage = "未婚";
                        startActivity(new Intent(aty, AffirmBankActivity.class)
                                .putExtra("name", name)
                                .putExtra("id_card", no)
                                .putExtra("address", address)
                                .putExtra("sex", sex)
                                .putExtra("education", education)
                                .putExtra("marriage", marriage));
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[]     strings = {"男", "女"};
                OptionPicker picker  = new OptionPicker(aty, strings);
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvSex.setText(s);
                    }
                });
                picker.show();
            }
        });
        mBinding.tvEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[]     strings = {"小学", "初中", "高中", "大专", "本科", "硕士", "博士"};
                OptionPicker picker  = new OptionPicker(aty, strings);
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvEducation.setText(s);
                    }
                });
                picker.show();
            }
        });
        mBinding.tvState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[]     strings = {"已婚", "未婚"};
                OptionPicker picker  = new OptionPicker(aty, strings);
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvState.setText(s);
                    }
                });
                picker.show();
            }
        });


        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        mBinding.flyJust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> strings = new ArrayList<>();
                strings.add("拍照");
                strings.add("从相册选择");
                StytledDialog.showBottomItemDialog(aty, strings, "安全退出", true, true, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(String text, int position) {
                        mType = 0;
                        switch (position) {
                            case 0:
                                doPhoto();
                                break;
                            case 1:
                                pickphoto();
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
        mBinding.flyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> strings = new ArrayList<>();
                strings.add("拍照");
                strings.add("从相册选择");
                StytledDialog.showBottomItemDialog(aty, strings, "安全退出", true, true, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(String text, int position) {
                        mType = 1;
                        switch (position) {
                            case 0:
                                doPhoto();
                                break;
                            case 1:
                                pickphoto();
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
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            BackDialog backDialog = new BackDialog(aty, new BackDialog.BackDialogListener() {
                @Override
                public void onback() {
                    finish();
                }
            });
            backDialog.show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            if (mType == 0) {
                Glide.with(aty).load(file).into(mBinding.imgJust);
            } else {
                Glide.with(aty).load(file).into(mBinding.imgBack);
            }
        }
    }

    @Override
    public void photoFaild() {

    }
}
