package com.xjd.a360fastloan.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.Link;
import com.xjd.a360fastloan.databinding.ActivityAffirmBankBinding;
import com.xjd.a360fastloan.model.home.BankModel;
import com.xjd.a360fastloan.model.main.BindModel;
import com.xjd.a360fastloan.ui.common.WebViewActivity;
import com.xjd.a360fastloan.widget.CountDownTextView;
import com.xjd.a360fastloan.widget.SoftKeyBoardListener;

public class AffirmBankActivity extends BaseActivity<BasePresenter, ActivityAffirmBankBinding> {

    private String name;
    private String id_card;
    private String address;
    private String sex;
    private String education;
    private String marriage;
    private String bank_type   = "";
    private String unique_code = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_bank;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("银行卡信息");
    }

    @Override
    protected void initData() {
        super.initData();
        name = getIntent().getStringExtra("name");
        id_card = getIntent().getStringExtra("id_card");
        address = getIntent().getStringExtra("address");
        sex = getIntent().getStringExtra("sex");
        education = getIntent().getStringExtra("education");
        marriage = getIntent().getStringExtra("marriage");
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mBinding.tvName.setText(name);
        mBinding.tvIdcard.setText(id_card);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.llyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.imgCheck.setSelected(!mBinding.imgCheck.isSelected());
            }
        });
        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean selected = mBinding.imgCheck.isSelected();
                if (!selected) {
                    showToast("请接受协议!");
                    return;
                }
                if (TextUtils.isEmpty(bank_type)) {
                    showToast("银行卡信息有误!");
                }

                addReUserInfo(bank_type);

            }
        });

        mBinding.tvCode.setNormalText("获取验证码")
                .setCountDownText("重新获取(", ")")
                .setCloseKeepCountDown(true)//关闭页面保持倒计时开关
                .setCountDownClickable(true)//倒计时期间点击事件是否生效开关
                .setShowFormatTime(true)//是否格式化时间
                .setOnCountDownFinishListener(new CountDownTextView.OnCountDownFinishListener() {
                    @Override
                    public void onFinish() {
                    }
                })
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean selected = mBinding.imgCheck.isSelected();
                        if (!selected) {
                            showToast("请接受协议!");
                            return;
                        }
                        if (TextUtils.isEmpty(bank_type)) {
                            showToast("银行卡信息有误!");
                        }

                        addUserInfo(bank_type);

                    }
                });


        mBinding.tvAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(aty, WebViewActivity.class).putExtra("url", Link.AGREE_WITH_HOLD));
            }
        });
        mBinding.etPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // 此处为得到焦点时的处理内容
                } else {
                    // 此处为失去焦点时的处理内容
                    check();
                }
            }
        });


    }

    private void check() {
        String bank = mBinding.etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(bank)) {
            showToast("银行卡信息不能为空!");
            return;
        }

        Api.getApi().checkBank("bank_card", bank)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<BankModel>(this, true) {
                    @Override
                    public void onSuccess(BankModel bankModel) {
                        bank_type = bankModel.getCardType();
                        mBinding.viewXin.setVisibility(View.VISIBLE);
                        mBinding.rlyBank.setVisibility(View.VISIBLE);
                        if ("CC".equals(bankModel.getCardType())) {
                            mBinding.rlyXin.setVisibility(View.VISIBLE);
                        }
                        mBinding.tvIdcardHint.setText(bankModel.getCardTypeName());
                        loadImag(bankModel.getBankImg(), mBinding.imgBank, 0);

                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

    private void addUserInfo(String type) {
        String bank       = mBinding.etPhone.getText().toString().trim();
        String bank_phone = mBinding.etBankPhone.getText().toString().trim();
        String bank_date  = mBinding.etBankDate.getText().toString().trim();
        String bank_bei   = mBinding.etBankBei.getText().toString().trim();
        if (TextUtils.isEmpty(bank)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        if (TextUtils.isEmpty(bank_phone)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        if (bank_type.equals("CC")) {
            if (TextUtils.isEmpty(bank_date)) {
                showToast("信用卡信息不能为空!");
                return;
            }
            if (TextUtils.isEmpty(bank_bei)) {
                showToast("信用卡信息不能为空!");
                return;
            }

        }
        Api.getApi().addUserInfo(name, sex, id_card, address, education, marriage, bank, bank_phone, type, bank_date, bank_bei)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<BindModel>(this, true) {
                    @Override
                    public void onSuccess(BindModel infoModel) {
                        showToast("发送成功!");
                        unique_code = infoModel.getUnique_code();
                        mBinding.tvCode.startCountDown(59);
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });

    }

    private void addReUserInfo(String type) {
        String bank       = mBinding.etPhone.getText().toString().trim();
        String bank_phone = mBinding.etBankPhone.getText().toString().trim();
        String bank_date  = mBinding.etBankDate.getText().toString().trim();
        String bank_bei   = mBinding.etBankBei.getText().toString().trim();
        String code       = mBinding.etCode.getText().toString().trim();
        if (TextUtils.isEmpty(bank)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        if (TextUtils.isEmpty(bank_phone)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        if (bank_type.equals("CC")) {
            if (TextUtils.isEmpty(bank_date)) {
                showToast("信用卡信息不能为空!");
                return;
            }
            if (TextUtils.isEmpty(bank_bei)) {
                showToast("信用卡信息不能为空!");
                return;
            }

        }
        if (TextUtils.isEmpty(bank_phone)) {
            showToast("验证码不能为空!");
            return;
        }
        Api.getApi().addReUserInfo(name, sex, id_card, address, education, marriage, bank, bank_phone, type, bank_date, bank_bei, unique_code, code)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<String>(this, true) {
                    @Override
                    public void onSuccess(String infoModel) {
                        showToast("提交成功!");
                        startActivity(CreditAssessActivity.class);
                        finish();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }


}
