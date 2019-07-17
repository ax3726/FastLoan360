package com.xjd.a360fastloan.ui.mine;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.databinding.ActivityOrderBinding;
import com.xjd.a360fastloan.model.home.ProductListModel;
import com.xjd.a360fastloan.model.mine.OrdersBean;
import com.xjd.a360fastloan.ui.home.ProductInfoActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity<BasePresenter, ActivityOrderBinding> {
    private List<ProductListModel> mDataList = new ArrayList<>();
    private CommonAdapter<ProductListModel> mAdapter;
    private List<OrdersBean> mDataListOrder = new ArrayList<>();
    private CommonAdapter<OrdersBean> mAdapterOrder;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
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
        mTitleBarLayout.setTitle("订单列表");
    }


    @Override
    protected void initData() {
        super.initData();


        getOrders();
        getProducts();

        //更多产品列表
        mAdapterOrder = new CommonAdapter<OrdersBean>(aty, R.layout.item_orderlistviewlay, mDataListOrder) {
            @Override
            protected void convert(ViewHolder holder, OrdersBean productListModel, int position) {
                holder.setText(R.id.tv_01, mDataListOrder.get(position).getProduct().getName())
                        .setImageurl(R.id.image_01, mDataListOrder.get(position).getProduct().getIconsrc(), 0)
                        .setText(R.id.tv_02,  "额度" + mDataListOrder.get(position).getProduct().getMax() + "元")
                        .setText(R.id.tv_04, "周期" +mDataListOrder.get(position).getProduct().getCycle())
                        .setText(R.id.tv_03, "￥" +mDataListOrder.get(position).getProduct().getPrice())
                        .setText(R.id.tv_05, "￥" + (Double.valueOf(productListModel.getProduct().getPrice()) + 100));
                TextView tv_money_old = holder.getView(R.id.tv_05);
                tv_money_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

          holder.getView(R.id.rly_item).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent=new Intent(OrderActivity.this,AuditActivity.class);
                  intent.putExtra("tv_01",mDataListOrder.get(position).getProduct().getName());
                  intent.putExtra("image_01",mDataListOrder.get(position).getProduct().getIconsrc());
                  intent.putExtra("tv_02","额度" + mDataListOrder.get(position).getProduct().getMax() + "元");
                  intent.putExtra("tv_04","周期" +mDataListOrder.get(position).getProduct().getCycle());
                  intent.putExtra("tv_03","￥" +mDataListOrder.get(position).getProduct().getPrice());
                  intent.putExtra("tv_05","￥" + (Double.valueOf(productListModel.getProduct().getPrice()) + 100));
                 startActivity(intent);
              }
          });

            }

        };
        mBinding.rcOrder.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcOrder.setNestedScrollingEnabled(false);
        mBinding.rcOrder.setAdapter(mAdapterOrder);
        mBinding.rcOrder.setNestedScrollingEnabled(false);

        //更多产品列表
        mAdapter = new CommonAdapter<ProductListModel>(aty, R.layout.selectorderlistviewlay, mDataList) {
            @Override
            protected void convert(ViewHolder holder, ProductListModel productListModel, int position) {

                int percent = 0;
                try {
                    percent = (int) (Double.valueOf(productListModel.getRebate()) * 100);
                } catch (Exception rx) {
                }
                ProgressBar progressBar = holder.getView(R.id.progressbar);
                progressBar.setProgress(98);
                holder.setText(R.id.tv_01, mDataList.get(position).getName())
                        .setImageurl(R.id.image_01, mDataList.get(position).getIconsrc(), 0)
                        .setText(R.id.tv_02, mDataList.get(position).getMin() + "-" + mDataList.get(position).getMax() + "元")
                        .setText(R.id.tv_04, percent + "%")
                        .setText(R.id.tv_06, mDataList.get(position).getV_click() + "申请");

                holder.getView(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(aty, ProductInfoActivity.class).putExtra("id", productListModel.getId()));
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
                            mBinding.viewLine.setVisibility(View.VISIBLE);
                            mDataList.addAll(list);
                        }
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });

    }

    private void getOrders() {
        Api.getApi().getOrders()
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<List<OrdersBean>>(this, true) {
                    @Override
                    public void onSuccess(List<OrdersBean> list) {
                        mDataListOrder.clear();
                        if (list != null && list.size() > 0) {
                            mDataListOrder.addAll(list);
                        }
                        mAdapterOrder.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });

    }

}
