package com.xjd.a360fastloan.ui.mine;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BaseNetListener;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.common.Api;
import com.xjd.a360fastloan.common.MyApplication;
import com.xjd.a360fastloan.databinding.ActivityBankcardBinding;
import com.xjd.a360fastloan.model.main.UserInfoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankcardActivity extends BaseActivity<BasePresenter, ActivityBankcardBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_bankcard;
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
        mTitleBarLayout.setTitle("银行卡信息");
    }

    private Myadapter                 myadapter;
    private List<Map<String, Object>> mydata;

    @Override
    protected void initData() {
        super.initData();


        mydata = new ArrayList<Map<String, Object>>();



        myadapter = new Myadapter(mydata);
        mBinding.banklist.setAdapter(myadapter);
        mBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(AddBankCardActivity.class);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserInfo();
    }

    private void getUserInfo() {
        Api.getApi().getUserInfo()
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<UserInfoModel>(this, true) {
                    @Override
                    public void onSuccess(UserInfoModel userInfoModel) {
                        MyApplication.getInstance().setUserInfo(userInfoModel);
                        mydata.clear();
                        if (userInfoModel != null && userInfoModel.getCard() != null) {
                            for (int i = 0; i < MyApplication.getInstance().getUserInfo().getCard().size(); i++) {
                                String              maskNumber = MyApplication.getInstance().getUserInfo().getCard().get(i).getNumber().substring(MyApplication.getInstance().getUserInfo().getCard().get(i).getNumber().length() - 4, MyApplication.getInstance().getUserInfo().getCard().get(i).getNumber().length());
                                Map<String, Object> hashMap    = new HashMap<String, Object>();
                                hashMap.put("tv1", MyApplication.getInstance().getUserInfo().getCard().get(i).getName());
                                hashMap.put("tv6", maskNumber);
                                hashMap.put("img", MyApplication.getInstance().getUserInfo().getCard().get(i).getLogo());
                                hashMap.put("tv3", MyApplication.getInstance().getUserInfo().getCard().get(i).getType());
                                mydata.add(hashMap);
                            }
                        }
                        myadapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
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
            Myholder myholder;
            if (convertView == null) {
                myholder = new Myholder();
                convertView = LayoutInflater.from(BankcardActivity.this).inflate(R.layout.selectbanklistviewlay, null);
                myholder.img = (ImageView) convertView.findViewById(R.id.bankpicture);
                myholder.tv1 = (TextView) convertView.findViewById(R.id.bankname);
                myholder.tv2 = (TextView) convertView.findViewById(R.id.bank_account_ids);
                myholder.tv3 = (TextView) convertView.findViewById(R.id.bank_card_type);
                myholder.tv4 = (TextView) convertView.findViewById(R.id.tv4);
                myholder.tv5 = (TextView) convertView.findViewById(R.id.bankuniq);
                myholder.tv6 = (TextView) convertView.findViewById(R.id.num);
                myholder.background_color = (ImageView) convertView.findViewById(R.id.background_color);
                convertView.setTag(myholder);
            } else {
                myholder = (Myholder) convertView.getTag();
            }


            myholder.tv1.setText(data.get(position).get("tv1").toString());

            myholder.background_color.setBackgroundColor(Color.parseColor("#9070F9"));
            Glide.with(BankcardActivity.this).load(data.get(position).get("img").toString()).into(myholder.img);
//            myholder.tv2.setText(data.get(position).get("tv2").toString());
            myholder.tv3.setText(data.get(position).get("tv3").toString());
//            myholder.tv4.setText(data.get(position).get("tv4").toString());
//            myholder.tv5.setText(data.get(position).get("tv5").toString());
            myholder.tv6.setText(data.get(position).get("tv6").toString());
            return convertView;
        }

        class Myholder {
            ImageView img;
            ImageView background_color;
            TextView  tv1;
            TextView  tv2;
            TextView  tv3;
            TextView  tv4;
            TextView  tv5;
            TextView  tv6;
        }

    }
}
