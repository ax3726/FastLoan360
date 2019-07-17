package com.xjd.a360fastloan.common;


import com.lm.lib_common.model.BaseBean;
import com.xjd.a360fastloan.model.home.BankModel;
import com.xjd.a360fastloan.model.home.IdCardModel;
import com.xjd.a360fastloan.model.home.OrderModel;
import com.xjd.a360fastloan.model.home.ProdectInfoModel;
import com.xjd.a360fastloan.model.home.ProductListModel;
import com.xjd.a360fastloan.model.main.LoginModel;
import com.xjd.a360fastloan.model.main.UserInfoModel;
import com.xjd.a360fastloan.model.mine.OrdersBean;
import com.xjd.a360fastloan.model.mine.RechargesBean;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by lm on 2019/6/17
 * Description:
 */

public interface ApiService {
    @POST("selectUserInfo.shtml")
        //获取用户信息
    Flowable<BaseBean> search(@Query("phone") String query, @Query("token") String token);

    //下载文件
    @Streaming
    @GET
    Flowable<ResponseBody> download(@Url String url);

    // 上传图片
    @Multipart
    @POST("upload")
    Flowable<BaseBean> getLoginRegisterImage(@Query("name") String name,
                                             @Query("gender") String gender,
                                             @Part MultipartBody.Part file);


    //获取验证码
    @POST("api/sms/send")
    Flowable<String> getCode(@Query("mobile") String mobile);

    //登录
    @POST("api/users/login")
    Flowable<LoginModel> login(@Query("mobile") String mobile, @Query("code") String code);

    //产品列表
    @GET("api/products")
    Flowable<List<ProductListModel>> getProducts();

    //产品详情
    @GET("api/products/{id}")
    Flowable<ProdectInfoModel> getProductInfo(@Path("id") String id);

    //验证身份证或银行卡信息
    @GET("api/users/check")
    Flowable<IdCardModel> checkId_card(@Query("type") String type, @Query("info") String info);

    //验证身份证或银行卡信息
    @GET("api/users/check")
    Flowable<BankModel> checkBank(@Query("type") String type, @Query("info") String info);

    /**
     * 下单
     *
     * @param product_id
     * @return
     */
    @POST("api/orders")
    Flowable<OrderModel> addOrders(@Query("product_id") String product_id);

    //获取当前用户信息
    @GET("api/users")
    Flowable<UserInfoModel> getUserInfo();

    /**
     * 添加银行卡信息
     *
     * @return
     */
    @POST("api/users/card")
    Flowable<String> addCard(@Query("number") String number,
                             @Query("mobile") String mobile,
                             @Query("type") String type,
                             @Query("code") String code,
                             @Query("date") String date);

    /**
     * 添加银行卡信息
     *
     * @return
     */
    @POST("api/pay")
    Flowable<String> pay(@Query("pay_type") String pay_type,
                         @Query("pay_id") String pay_id,
                         @Query("card_id") String card_id);

    //添加个人信息
    @POST("api/users/info")
    Flowable<String> addUserInfo(@Query("name") String name,
                                 @Query("sex") String sex,
                                 @Query("id_card") String id_card,
                                 @Query("address") String address,
                                 @Query("education") String education,
                                 @Query("marriage") String marriage,
                                 @Query("number") String number,
                                 @Query("mobile") String mobile,
                                 @Query("type") String type,
                                 @Query("date") String date,
                                 @Query("code") String code
    );

    //充值
    @POST("api/recharges")
    Flowable<RechargesBean> getRecharges(@Query("amount") String amount);


    //反馈
    @POST("api/feedback")
    Flowable<String> getFeedback(@Query("content") String content,@Query("contact") String contact);

    //产品列表
    @GET("api/orders")
    Flowable<List<OrdersBean>> getOrders();

    //关联关系
    @POST("api/users/relation")
    Flowable<String> addRelation(@Query("name") String name, @Query("mobile") String mobile, @Query("relation") String relation);

    //工作信息
    @POST("api/users/job")
    Flowable<String> addJob(@Query("type") String type,
                            @Query("name") String name,
                            @Query("address") String address,
                            @Query("phone") String phone,
                            @Query("income") String income,
                            @Query("intime") String intime);

}
