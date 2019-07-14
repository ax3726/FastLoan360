package com.xjd.a360fastloan.ui.mine;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderActivity extends BaseActivity<BasePresenter, ActivityOrderBinding> {
    private List<String>          mDataList = new ArrayList<>();
    private CommonAdapter<String> mAdapter;

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

        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mAdapter = new CommonAdapter<String>(aty, R.layout.selectorderlistviewlay, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {


            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setNestedScrollingEnabled(false);
        mBinding.rcBody.setAdapter(mAdapter);
        mBinding.rcBody.setNestedScrollingEnabled(false);
        mBinding.rlyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AuditActivity.class);
            }
        });
    }


}
