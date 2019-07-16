package com.xjd.a360fastloan.ui.mine;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.databinding.ActivityAddJobBinding;

import java.util.Calendar;

public class AddJobActivity extends BaseActivity<BasePresenter, ActivityAddJobBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_job;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("工作信息");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addJob();
            }
        });
        mBinding.tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(aty,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                mBinding.tvTime.setText(year + "-" + monthOfYear + "-" + dayOfMonth );
                            }
                        }, calendar.get(Calendar.YEAR), calendar
                        .get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
    }

    private void addJob() {

        String type = mBinding.etType.getText().toString().trim();
        String name = mBinding.etName.getText().toString().trim();
        String address = mBinding.etAddress.getText().toString().trim();
        String phone = mBinding.etPhone.getText().toString().trim();
        String income = mBinding.etIncome.getText().toString().trim();
        String time = mBinding.tvTime.getText().toString().trim();
        if (TextUtils.isEmpty(type) ||
                TextUtils.isEmpty(name) ||
                TextUtils.isEmpty(address) ||
                TextUtils.isEmpty(phone) ||
                TextUtils.isEmpty(income) ||
                TextUtils.isEmpty(time)) {
            showToast("请完善信息!");
            return;
        }
        Api.getApi().addJob(type, name, address, phone, income, time)
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
