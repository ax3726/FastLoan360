package com.xjd.a360fastloan.ui.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAuditBinding;
import com.xjd.a360fastloan.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuditActivity extends BaseActivity<BasePresenter,ActivityAuditBinding> {



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

    private Myadapter myadapter;
    private List<Map<String, Object>> mydata;

    @Override
    protected void initData() {
        super.initData();


        mydata = new ArrayList<Map<String, Object>>();
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("tv1", "秒借款");
        mydata.add(hashMap);
        Map<String, Object> hashMap2 = new HashMap<String, Object>();
        hashMap2.put("tv1", "借东风");
        mydata.add(hashMap2);
        Map<String, Object> hashMap3 = new HashMap<String, Object>();
        hashMap3.put("tv1", "借东风");
        mydata.add(hashMap3);
        Map<String, Object> hashMap4 = new HashMap<String, Object>();
        hashMap4.put("tv1", "借东风");
        mydata.add(hashMap4);
        myadapter = new Myadapter(mydata);
        mBinding.banklist.setAdapter(myadapter);


    }

    public class Myadapter extends BaseAdapter {
        List<Map<String, Object>> data;

        public Myadapter(List<Map<String, Object>> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          Myadapter.Myholder myholder;
            if (convertView == null) {
                myholder = new Myadapter.Myholder();
                convertView = LayoutInflater.from(AuditActivity.this).inflate(R.layout.selectorderlistviewlay, null);
                myholder.img = (ImageView) convertView.findViewById(R.id.image_01);
                myholder.tv1 = (TextView) convertView.findViewById(R.id.tv_01);
                convertView.setTag(myholder);
            } else {
                myholder = (Myadapter.Myholder) convertView.getTag();
            }




            myholder.tv1.setText(data.get(position).get("tv1").toString());
            return convertView;
        }

        class Myholder {
            ImageView img;
            TextView tv1;

        }

    }
}
