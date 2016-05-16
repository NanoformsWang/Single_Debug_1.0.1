package com.example.pangxiezi.single.model;

import com.example.pangxiezi.single.bean.PageEntity;

import retrofit2.Callback;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public interface PageModel {
    void getHomeData(int page,int page_id,int create_time,int model,Callback<PageEntity> callback);
}
