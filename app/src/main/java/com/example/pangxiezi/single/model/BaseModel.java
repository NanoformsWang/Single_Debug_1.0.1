package com.example.pangxiezi.single.model;



import com.example.pangxiezi.single.api.ApiConstant;
import com.example.pangxiezi.single.service.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public class BaseModel {
    public Service service;

    public BaseModel() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.Url.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(Service.class);
        }

}
