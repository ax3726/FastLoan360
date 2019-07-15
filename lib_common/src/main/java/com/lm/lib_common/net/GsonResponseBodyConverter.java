package com.lm.lib_common.net;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.lm.lib_common.model.ErrorBean;
import com.lm.lib_common.net.ex.ResultException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by lm on 2017/11/22.
 * Description：自定义gson转换器
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    public Class<T> getRealType() {
        // 获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        return (Class<T>) pt.getActualTypeArguments()[0];
    }


    @Override
    public T convert(ResponseBody value) throws IOException {

        String response = value.string();
        Log.e("msg", "response" + response);
        try {

            if (response.length()>0&&response.substring(0, 1).equals("[")) {
               return gson.fromJson(response, this.type);
            }

            ErrorBean errorBean = gson.fromJson(response, ErrorBean.class);
            if (errorBean != null && !TextUtils.isEmpty(errorBean.getMessage())) {//登录失效
                throw new ResultException(errorBean.getCode(), errorBean.getMessage());
            }

            return gson.fromJson(response, this.type);


            //ResultResponse 只解析code字段进行约定异常处理
          /*  ResultResponse resultResponse = gson.fromJson(response, ResultResponse.class);
            if (resultResponse.getReturnCode()==1) {
                return gson.fromJson(response, type);
            }

            else if (resultResponse.getStatus()==404) {
                throw new ApiException(ResponseCodeEnum.NODATA);
            }

            else {
                BaseBean baseBean = gson.fromJson(response, BaseBean.class);
                throw new ResultException(baseBean.getReturnCode(), baseBean.getReturnMessage());
            }*/
        } finally {
            value.close();
        }
    }
}
