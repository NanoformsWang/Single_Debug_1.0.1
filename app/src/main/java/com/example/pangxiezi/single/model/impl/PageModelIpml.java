package com.example.pangxiezi.single.model.impl;

import com.example.pangxiezi.single.api.ApiConstant;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.bean.PageEntity;
import com.example.pangxiezi.single.model.BaseModel;
import com.example.pangxiezi.single.model.PageModel;
import com.example.pangxiezi.single.utils.ParamsMap;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public class PageModelIpml extends BaseModel implements PageModel {
   public PageModelIpml() {
    }
    @Override
    public void getHomeData(int page,int page_id,int create_time,int model,Callback<PageEntity> callback ) {
        ParamsMap map = new ParamsMap();
        map.put(ApiConstant.DefaultKey.P_KEY,page);
        map.put(ApiConstant.DefaultKey.MODEL_KEY,model);
        map.put(ApiConstant.DefaultKey.CREATE_TIME_KEY,create_time);
        map.put(ApiConstant.DefaultKey.PAGE_ID_KEY,page_id);
        Call<PageEntity> call = service.getHomeEntity(map);
        call.enqueue(callback);
    }
}
