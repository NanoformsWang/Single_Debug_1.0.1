package com.example.pangxiezi.single.service;


import com.example.pangxiezi.single.bean.PageEntity;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public interface Service {

    /**
     * 首页
     * @param map
     * @return
     */
    @POST("/?c=Api&a=getList")
    Call<PageEntity> getHomeEntity(@QueryMap Map<String,String> map);




}
