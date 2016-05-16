package com.example.pangxiezi.single.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.bean.PageEntity;
import com.example.pangxiezi.single.presenter.PagePresenter;
import com.example.pangxiezi.single.presenter.impl.PagePresenterImpl;
import com.example.pangxiezi.single.ui.adapter.HomeAdapter;
import com.example.pangxiezi.single.ui.adapter.HomeRecyclerPageAdapter;
import com.example.pangxiezi.single.ui.widget.GestureListener;
import com.example.pangxiezi.single.view.PageView;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements PageView, View.OnClickListener, HomeAdapter.OnChildClickListener {

    private static final String URL = "URL";
    @Bind(R.id.main_swipe)
    SwipeRefreshLayout mainSwipe;

    private HomeRecyclerPageAdapter pageAdapter;
    @Bind(R.id.main_recycler)
    RecyclerViewPager recycler;
    private HomeAdapter adapter;
    private List<PageDataEntity> pageDataEntities = new ArrayList<>();

    private PagePresenter pagePresenter;
    private int page, model, paget_Id, create_time;


    @Bind(R.id.ment_ibtn)
    ImageButton mentIbtn;
    @Bind(R.id.user_ibtn)
    ImageButton userIbtn;
    @Bind(R.id.main_layout)
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initEvent();

    }

    private void initData() {
        pagePresenter = new PagePresenterImpl(page, model, paget_Id, create_time, this);
        pagePresenter.getEntityData();

        adapter = new HomeAdapter(this, pageDataEntities, recycler);
        adapter.setOnChildClickListener(this);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        pageAdapter = new HomeRecyclerPageAdapter(recycler, adapter);
        recycler.setAdapter(pageAdapter);
    }

    private void initEvent() {
        mentIbtn.setOnClickListener(this);
        userIbtn.setOnClickListener(this);
        mainLayout.setLongClickable(true);
        mainLayout.setOnTouchListener(new MyGestureListener(this));
    }

    @Override
    public void getData(PageEntity entity) {
//        pageDataEntities = entity.getDatas();
////        adapter.notifyDataSetChanged();
//        adapter = new HomeAdapter(this, pageDataEntities);
//        recycler.setAdapter(adapter);
//        adapter.setOnChildClickListener(this);
        pageDataEntities.addAll(entity.getDatas());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ment_ibtn:
                startActivity(new Intent(this, MenuActivity.class));
                overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);
                break;
            case R.id.user_ibtn:
                startActivity(new Intent(this, UserActivity.class));
                overridePendingTransition(R.anim.in_from_right, R.anim.out_from_left);
                break;
        }
    }

    @Override
    public void onChildClick(View child, int positon, String url) {
//        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(URL, url);
        startActivity(intent);
    }

    /**
     * 继承GestureListener，重写left和right方法
     */
    private class MyGestureListener extends GestureListener {
        public MyGestureListener(Context context) {
            super(context);
        }

        @Override
        public boolean left() {
            Log.e("test", "向左滑");
            startActivity(new Intent(MainActivity.this, UserActivity.class));
            overridePendingTransition(R.anim.in_from_right, R.anim.out_from_left);
            return super.left();
        }

        @Override
        public boolean right() {
            Log.e("test", "向右滑");
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
            overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);
            return super.right();
        }
    }

    @Override
    public void shoeError() {
        Toast.makeText(this, "网络连接错误......", Toast.LENGTH_LONG).show();
    }


}
