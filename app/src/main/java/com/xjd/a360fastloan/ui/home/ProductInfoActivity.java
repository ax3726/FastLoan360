package com.xjd.a360fastloan.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.databinding.ActivityProductInfoBinding;
import com.xjd.a360fastloan.model.home.ProdectInfoModel;
import com.xjd.a360fastloan.ui.mian.MainActivity;

import java.text.DecimalFormat;

public class ProductInfoActivity extends BaseActivity<BasePresenter, ActivityProductInfoBinding> {

    private int mId = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_info;
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
    protected void initEvent() {
        super.initEvent();
        mBinding.llyLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBinding.tvLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(MainActivity.class);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mId = getIntent().getIntExtra("id", 0);
        getProductInfo();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
       // mBinding.tvContent.setText("举例：借款15000元，期限为15天，6个月之后一次性自 动扣款或手动扣款 \n最快一天放款 \n日利率：0.01% \n还款方式：1.银行代扣；2.主动还款 \n服务费：138元");
    }

    private void getProductInfo() {
        Api.getApi().getProductInfo(String.valueOf(mId))
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<ProdectInfoModel>(this, true) {
                    @Override
                    public void onSuccess(ProdectInfoModel infoModel) {
                        DecimalFormat df = new DecimalFormat("000.00%");
                        mBinding.tvPrecent.setText(df.format(infoModel.getRebate()));
                        mBinding.tvMoney.setText(infoModel.getMax());
                        mBinding.tvDay.setText(TextUtils.isEmpty(infoModel.getCycle()) ? "0" : infoModel.getCycle().replace("天", ""));
                        mBinding.tvContent.setText("举例：借款15000元，期限为15天，6个月之后一次性自 动扣款或手动扣款 \n最快一天放款 \n日利率：0.01% \n还款方式：1.银行代扣；2.主动还款 \n服务费：" + infoModel.getPrice() + "元");
                        mBinding.tvContentRemark.setText("借款之前扣除服务费" + infoModel.getPrice() + "元");
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }
}
