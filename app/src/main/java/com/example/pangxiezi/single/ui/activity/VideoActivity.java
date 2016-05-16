package com.example.pangxiezi.single.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.api.ApiConstant;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.bean.PageEntity;
import com.example.pangxiezi.single.presenter.impl.PagePresenterImpl;
import com.example.pangxiezi.single.ui.adapter.VideoAdapter;
import com.example.pangxiezi.single.view.PageView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends BaseActivity implements PageView, AdapterView.OnItemClickListener {


    List<PageDataEntity> list = new ArrayList<>();
    Context context;
    VideoAdapter adapter;
    PagePresenterImpl presenter;
    PullToRefreshListView pulltolist;
    int pageDefault = 1;
    int page_idDefault = 0;
    int create_timeDefault = 0;
    int modelDefault = 2;
    int page = 1;
    int num = 0;
    boolean isRefresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        pulltolist = (PullToRefreshListView) findViewById(R.id.pulllist);
        init();
        context = this;
    }

    private void init() {
        initData();
        initView();
    }

    private void initView() {
        pulltolist.setMode(PullToRefreshBase.Mode.BOTH);
        adapter = new VideoAdapter(list, this);
        pulltolist.setAdapter(adapter);
        pulltolist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                presenter.toMoreData(pageDefault, modelDefault,
                        page_idDefault, create_timeDefault);
                presenter.getEntityData();
                isRefresh = true;
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (list.size() > 0) {
                    presenter.toMoreData(++page, modelDefault,
                            Integer.parseInt(list.get(list.size() - 1).getId()), Integer.parseInt(list.get(list.size() - 1).getCreate_time()));
                    presenter.getEntityData();
                } else
                    return;
            }
        });
        pulltolist.setOnItemClickListener(this);

    }

    private void initData() {
        presenter = new PagePresenterImpl(pageDefault, modelDefault, page_idDefault, create_timeDefault, this);
        presenter.getEntityData();

    }

    @Override
    public void getData(PageEntity entity) {
        if (isRefresh) {
            list.clear();
        }
        list.addAll(entity.getDatas());
        adapter.notifyDataSetChanged();
        pulltolist.onRefreshComplete();
        isRefresh = false;
//        if(num == entity.getDatas().size())
//            Toast.makeText(this,"没有更多了",Toast.LENGTH_SHORT).show();
        num = entity.getDatas().size();
    }

    @Override
    public void shoeError() {
//        Toast.makeText(this,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra(ApiConstant.DefaultKey.HTML_KEY, list.get(position).getHtml5());
        startActivity(intent);
    }
}
