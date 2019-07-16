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
import com.xjd.a360fastloan.databinding.ActivityProductInfoBinding;
import com.xjd.a360fastloan.model.home.OrderModel;
import com.xjd.a360fastloan.model.home.ProdectInfoModel;

public class ProductInfoActivity extends BaseActivity<BasePresenter, ActivityProductInfoBinding> {

    private int mId = 0;
    private ProdectInfoModel mProdectInfoModel = null;

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
                addOrders();
            }
        });
    }

    private void addOrders() {
        if (mProdectInfoModel == null) {
            showToast("数据有误！");
            return;
        }
        Api.getApi().addOrders(mProdectInfoModel.getId() + "")
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<OrderModel>(this, true) {
                    @Override
                    public void onSuccess(OrderModel orderModel) {
                        startActivity(new Intent(aty, OrderPayActivity.class).putExtra("id", orderModel.getOrder_id()).putExtra("price", mProdectInfoModel.getPrice()));
                        finish();
                    }

                    @Override
                    public void onFail(String errMsg) {

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
                        mProdectInfoModel = infoModel;
                        int percent = 0;
                        try {
                            percent = (int) (Double.valueOf(infoModel.getRebate()) * 100);
                        } catch (Exception rx) {
                        }
                        mBinding.tvPrecent.setText(percent + "");
                        mBinding.tvMoney.setText(infoModel.getMax() + "");
                        mBinding.tvDay.setText(TextUtils.isEmpty(infoModel.getCycle()) ? "0" : infoModel.getCycle().replace("天", ""));
                        mBinding.tvContent.setText("举例：借款15000元，期限为15天，6个月之后一次性自 动扣款或手动扣款 \n最快一天放款 \n日利率：0.01% \n还款方式：1.银行代扣；2.主动还款 \n服务费：" + infoModel.getPrice() + "元");
                        mBinding.tvContentRemark.setText("借款之前扣除服务费" + infoModel.getPrice() + "元");
                        mBinding.tvPrice.setText("服务费：" + infoModel.getPrice() + "借币");
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }
}
