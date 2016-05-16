package com.example.pangxiezi.single.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.api.ApiConstant;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.bean.PageEntity;
import com.example.pangxiezi.single.presenter.impl.PagePresenterImpl;
import com.example.pangxiezi.single.ui.adapter.DateRecAdapter;
import com.example.pangxiezi.single.ui.adapter.DateRecyclerPageAdapter;
import com.example.pangxiezi.single.view.PageView;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DateActivity extends BaseActivity implements PageView, AdapterView.OnItemClickListener, DateRecAdapter.onClickChildListener {

    @Bind(R.id.mylist_date)
    RecyclerViewPager listView;
    private PagePresenterImpl presenter;
    private DateRecAdapter adapter;
    private List<PageDataEntity> datas = new ArrayList<PageDataEntity>();
    private DateRecyclerPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initData();
        initView();
    }

    private void initView() {
        adapter = new DateRecAdapter(datas,this,listView);
        adapter.setOnonClickChildListener(this);
        listView.setLayoutManager(new LinearLayoutManager(this));
        pageAdapter = new DateRecyclerPageAdapter(listView,adapter);
        listView.setAdapter(pageAdapter);

    }

    private void initData() {
        presenter = new PagePresenterImpl(1,4,0,0,this);
        presenter.getEntityData();
    }

    @Override
    public void getData(PageEntity entity) {
        datas.addAll(entity.getDatas());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void shoeError() {
        Toast.makeText(this,"网络有问题",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,WebActivity.class);
        intent.putExtra(ApiConstant.DefaultKey.HTML_KEY,datas.get(position).getHtml5());
        startActivity(intent);
    }


    @Override
    public void clickChildListener(View v, int position, PageDataEntity entity) {
        Intent intent = new Intent(this,WebActivity.class);
        intent.putExtra(ApiConstant.DefaultKey.HTML_KEY,entity.getHtml5());
        startActivity(intent);
    }
}
