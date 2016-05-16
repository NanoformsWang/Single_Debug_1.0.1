package com.example.pangxiezi.single.ui.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.api.ApiConstant;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.bean.PageEntity;
import com.example.pangxiezi.single.presenter.impl.PagePresenterImpl;
import com.example.pangxiezi.single.ui.adapter.MusicAdapter;
import com.example.pangxiezi.single.view.PageView;

import java.util.ArrayList;
import java.util.List;

public class MusicActivity extends BaseActivity implements PageView, SwipeRefreshLayout.OnRefreshListener, MusicAdapter.AdapterChildClickListener {

    RecyclerView recylist ;
    SwipeRefreshLayout swipeRefreshLayout;
    private List<PageDataEntity> datas = new ArrayList<>();
    private PagePresenterImpl presenter;
    private MusicAdapter adapter;
    private int num = 0;
    private boolean isRefresh = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        init();
    }

    private void init() {
         initData();
        initView();
    }
    private void initData() {
        presenter = new PagePresenterImpl(1,3,0,0,this);

    }
    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiprefresh_music);
        recylist = (RecyclerView) findViewById(R.id.reclist_music);
        swipeRefreshLayout.setColorSchemeResources(R.color.swiprefreshColor1, R.color.swiprefreshColor2, R.color.swiprefreshColor3, R.color.swiprefreshColor4);
        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new MusicAdapter(this, datas,recylist);
        recylist.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        recylist.setAdapter(adapter);
        presenter.getEntityData();
        adapter.setAdapterChildClickListener(this);
    }
    @Override
    public void getData(PageEntity entity) {
        datas.addAll(entity.getDatas());
        if(!isRefresh) {
            swipeRefreshLayout.setRefreshing(isRefresh);
            adapter.notifyDataSetChanged();
        }
        isRefresh = true;
    }

    @Override
    public void shoeError() {

    }

    @Override
    public void onRefresh() {
        num = datas.size();
        presenter.getEntityData();
        isRefresh = false;
    }


    @Override
    public void ChildClickListener(View v, int position, PageDataEntity entity) {
        Intent intent = new Intent(this,WebActivity.class);
        intent.putExtra(ApiConstant.DefaultKey.HTML_KEY,entity.getHtml5());
        startActivity(intent);
    }
}
