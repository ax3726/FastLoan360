package com.xjd.a360fastloan.common;



/**
 * Created by lm on 2019/6/17
 * 缓存统一处理服务类
 */

public class CacheService {

    private static CacheService mCacheService = null;

    private CacheService() {

    }

    public static CacheService getIntance() {
        if (mCacheService == null) {
            return new CacheService();
        }
        return mCacheService;
    }

  /*  *//**
     * 读取用户信息
     *
     * @return
     *//*
    public UserInfoModel getUserInfo() {
        return (UserInfoModel) CacheUtils.getInstance().loadCache(Constant.USER_INFO);
    }

    *//**
     * 缓存用户信息
     *
     * @param userInfo
     *//*
    public void setUserInfo(UserInfoModel userInfo) {
        CacheUtils.getInstance().saveCache(Constant.USER_INFO, userInfo);
    }*/

}
