package com.example.pangxiezi.single.presenter.impl;

import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.bean.PageEntity;
import com.example.pangxiezi.single.model.ModelFactory;
import com.example.pangxiezi.single.presenter.PagePresenter;
import com.example.pangxiezi.single.view.PageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public class PagePresenterImpl implements PagePresenter {
    private int page,page_id,create_time,model;
    private PageView view;

    public PagePresenterImpl(int page,int model, int page_id, int create_time, PageView view) {
        this.page = page;
        this.page_id = page_id;
        this.create_time = create_time;
        this.model = model;
        this.view = view;
    }
    public void toMoreData(int page,int model, int page_id, int create_time){
        this.page = page;
        this.page_id = page_id;
        this.create_time = create_time;
        this.model = model;
    }
    @Override
    public void getEntityData() {
        ModelFactory.newInstance().getHomepageModelImpl().getHomeData(page, page_id, create_time, model, new Callback<PageEntity>() {
            @Override
            public void onResponse(Call<PageEntity> call, Response<PageEntity> response) {
                view.getData(response.body());
            }

            @Override
            public void onFailure(Call<PageEntity> call, Throwable t) {
                view.shoeError();
            }
        });
    }
}
