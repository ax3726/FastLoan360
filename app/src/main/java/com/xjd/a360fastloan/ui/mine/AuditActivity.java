package com.xjd.a360fastloan.ui.mine;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityAuditBinding;
import com.xjd.a360fastloan.databinding.ActivityOrderBinding;
import com.xjd.a360fastloan.model.home.ProductListModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuditActivity extends BaseActivity<BasePresenter,ActivityAuditBinding> {

    private List<ProductListModel>          mDataList = new ArrayList<>();
    private CommonAdapter<ProductListModel> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_audit;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("审核流程");
    }



    @Override
    protected void initData() {
        super.initData();



        mBinding.tv01.setText(MyApplication.getInstance().getUserInfo().getProduct().getName().toString());
        mBinding.tv02.setText("额度"+MyApplication.getInstance().getUserInfo().getProduct().getMax()+"元");
        mBinding.tv04.setText("周期"+MyApplication.getInstance().getUserInfo().getProduct().getCycle());
        mBinding.tv03.setText("¥  "+MyApplication.getInstance().getUserInfo().getProduct().getPrice());

        Glide.with(this).load(MyApplication.getInstance().getUserInfo().getProduct().getIconsrc()).into(mBinding.image01);
        getProducts();
        mAdapter = new CommonAdapter<ProductListModel>(aty, R.layout.selectorderlistviewlay, mDataList) {
            @Override
            protected void convert(ViewHolder holder, ProductListModel productListModel, int position) {
                DecimalFormat df = new DecimalFormat("000.00%");

                holder.setText(R.id.tv_01,mDataList.get(position).getName())
                        .setImageurl(R.id.image_01,mDataList.get(position).getIconsrc(),0)
                        .setText(R.id.tv_02,mDataList.get(position).getMin()+"-"+mDataList.get(position).getMax()+"元")
                        .setText(R.id.tv_04,mDataList.get(position).getRebate()+"%")
                        .setText(R.id.tv_06,mDataList.get(position).getV_click()+"万申请");

                holder.getView(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(DrawbackActivity.class);
                    }
                });
            }

        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setNestedScrollingEnabled(false);
        mBinding.rcBody.setAdapter(mAdapter);
        mBinding.rcBody.setNestedScrollingEnabled(false);

    }


    private void getProducts() {
        Api.getApi().getProducts()
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<List<ProductListModel>>(this, true) {
                    @Override
                    public void onSuccess(List<ProductListModel> list) {
                        mDataList.clear();
                        if (list != null && list.size() > 0) {
                            mDataList.addAll(list);
                        }
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });

    }
}
