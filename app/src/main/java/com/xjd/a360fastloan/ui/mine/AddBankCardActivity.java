package com.xjd.a360fastloan.ui.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.Link;
import com.xjd.a360fastloan.databinding.ActivityAddBankCardBinding;
import com.xjd.a360fastloan.model.home.BankModel;
import com.xjd.a360fastloan.ui.common.WebViewActivity;

public class AddBankCardActivity extends BaseActivity<BasePresenter, ActivityAddBankCardBinding> {


    private String mCardType = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_bank_card;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("添加银行卡");
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
                addCard();
            }
        });
        mBinding.tvAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(aty, WebViewActivity.class).putExtra("url", Link.AGREE_WITH_HOLD));
            }
        });
        mBinding.tvCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
    }

    private void check() {
        String bank       = mBinding.etPhone.getText().toString().trim();
        String bank_phone = mBinding.etBankPhone.getText().toString().trim();
        if (TextUtils.isEmpty(bank)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        if (TextUtils.isEmpty(bank_phone)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        Api.getApi().checkBank("bank_card", bank)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<BankModel>(this, true) {
                    @Override
                    public void onSuccess(BankModel bankModel) {
                        mBinding.viewXin.setVisibility(View.VISIBLE);
                        mBinding.rlyBank.setVisibility(View.VISIBLE);
                        if ("CC".equals(bankModel.getCardType())) {
                            mBinding.rlyXin.setVisibility(View.VISIBLE);
                        }
                        mBinding.tvIdcardHint.setText(bankModel.getCardTypeName());
                        loadImag(bankModel.getBankImg(), mBinding.imgBank, 0);

                        mCardType = bankModel.getCardType();

                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }


    private void addCard() {
        boolean selected   = mBinding.imgCheck.isSelected();
        String  bank       = mBinding.etPhone.getText().toString().trim();
        String  bank_phone = mBinding.etBankPhone.getText().toString().trim();
        String  bank_date  = mBinding.etBankDate.getText().toString().trim();
        String  bank_bei   = mBinding.etBankBei.getText().toString().trim();
        if (TextUtils.isEmpty(mCardType)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        if (TextUtils.isEmpty(bank)) {
            showToast("银行卡信息不能为空!");
            return;
        }
        if (TextUtils.isEmpty(bank_phone)) {
            showToast("银行卡信息不能为空!");
            return;
        }

        if (mCardType.equals("CC")) {
            if (TextUtils.isEmpty(bank_date)) {
                showToast("信用卡信息不能为空!");
                return;
            }
            if (TextUtils.isEmpty(bank_bei)) {
                showToast("信用卡信息不能为空!");
                return;
            }

        }
        if (!selected) {
            showToast("请接受协议!");
            return;
        }
        Api.getApi().addCard(bank, bank_phone, mCardType, bank_bei, bank_date)
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<String>(this, true) {
                    @Override
                    public void onSuccess(String s) {
                        showToast("添加成功!");
                        finish();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }
}
