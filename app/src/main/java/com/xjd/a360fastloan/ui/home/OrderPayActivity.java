package com.xjd.a360fastloan.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityOrderPayBinding;
import com.xjd.a360fastloan.ui.mine.AddBankCardActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderPayActivity extends BaseActivity<BasePresenter, ActivityOrderPayBinding> {

    private String mId="";
    private List<String> mDataList=new ArrayList<>();
    private CommonAdapter<String> mAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_pay;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("支付方式");
    }

    @Override
    protected void initData() {
        super.initData();
        mId=getIntent().getStringExtra("id");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mAdapter = new CommonAdapter<String>(aty, R.layout.item_bank_list, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String item, int position) {
               /* holder.setText(R.id.tv_day, "期限周期" + item.getCycle())
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
                tv_money_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);*/
            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setNestedScrollingEnabled(false);
        mBinding.rcBody.setAdapter(mAdapter);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddBankCardActivity.class);
            }
        });
    }
}
