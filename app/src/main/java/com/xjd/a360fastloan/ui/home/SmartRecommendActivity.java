package com.xjd.a360fastloan.ui.home;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.Link;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivitySmartRecommendBinding;
import com.xjd.a360fastloan.model.home.ProductListModel;
import com.xjd.a360fastloan.model.main.UserInfoModel;
import com.xjd.a360fastloan.ui.common.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

public class SmartRecommendActivity extends BaseActivity<BasePresenter, ActivitySmartRecommendBinding> {


    private List<ProductListModel> mDataList = new ArrayList<>();
    private CommonAdapter<ProductListModel> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_smart_recommend;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("智能推荐");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductListModel choose = null;
                for (ProductListModel item : mDataList) {
                    if (item.isIs_select()) {
                        choose = item;
                        break;
                    }
                }
                if (choose != null) {
                    boolean selected = mBinding.imgCheck.isSelected();
                    if (!selected) {
                        showToast("请接受协议!");
                        return;
                    }
                    startActivity(new Intent(aty, ProductInfoActivity.class).putExtra("id", choose.getId()));
                } else {
                    showToast("请选择产品！");
                }


            }
        });
        mBinding.llyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.imgCheck.setSelected(!mBinding.imgCheck.isSelected());
            }
        });
        mBinding.tvAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(aty, WebViewActivity.class).putExtra("url", Link.AGREE_ASSESSMENT));
            }
        });
        mBinding.tvContent.setText("1. 速贷种类每次只可选择一件产品\n2. 推荐产品年化率10%-35%\n3. 放款失败我们将服务费以借币的形式退还到您的钱包\n4.以上产品均为第三方提供");
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

    @Override
    protected void initData() {
        super.initData();
        getProducts();
        UserInfoModel userInfo = MyApplication.getInstance().getUserInfo();
        if (userInfo != null && userInfo.getProduct() != null) {
            mBinding.tvPrice.setText("服务费：" + userInfo.getProduct().getPrice() + "借币");
        }
        mAdapter = new CommonAdapter<ProductListModel>(aty, R.layout.item_recommend_layout, mDataList) {
            @Override
            protected void convert(ViewHolder holder, ProductListModel item, int position) {
                holder.setText(R.id.tv_day, "期限周期" + item.getCycle())
                        .setImageurl(R.id.img, item.getIconsrc(), 0)
                        .setText(R.id.tv_money_count, item.getMax() + "元")
                        .setText(R.id.tv_money, "￥" + item.getPrice())
                        .setText(R.id.tv_money_old, "￥" + (item.getPrice() + 100))
                        .setSelect(R.id.img_select, item.isIs_select())
                        .setOnClickListener(R.id.rly_item, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                for (ProductListModel item : mDataList) {
                                    item.setIs_select(false);
                                }
                                mDataList.get(position).setIs_select(true);
                                notifyDataSetChanged();
                            }
                        })
                ;
                TextView tv_money_old = holder.getView(R.id.tv_money_old);
                tv_money_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setNestedScrollingEnabled(false);
        mBinding.rcBody.setAdapter(mAdapter);
    }
}
