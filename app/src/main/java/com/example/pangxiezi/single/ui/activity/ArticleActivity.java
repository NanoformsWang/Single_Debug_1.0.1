package com.example.pangxiezi.single.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.bean.PageEntity;
import com.example.pangxiezi.single.presenter.PagePresenter;
import com.example.pangxiezi.single.presenter.impl.PagePresenterImpl;
import com.example.pangxiezi.single.ui.adapter.ArticleAdapter;
import com.example.pangxiezi.single.ui.widget.DividerItemDecoration;
import com.example.pangxiezi.single.view.PageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by COSCO on 2016/3/17.
 */
public class ArticleActivity extends BaseActivity implements PageView, SwipeRefreshLayout.OnRefreshListener, ArticleAdapter.OnChildClickListener {

    private static final String URL = "URL";

    @Bind(R.id.article_swipe)
    SwipeRefreshLayout articleSwipe;
    @Bind(R.id.article_recycler)
    RecyclerView articleRecycler;

    private boolean isRefresh = false;

    private PagePresenterImpl pagePresenter;

    private int page = 1;
    private int paget_id = 0;
    private int create_time = 0;
    private int model = 1;

    private ArticleAdapter adapter;
    private List<PageDataEntity> pageDataEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        pagePresenter = new PagePresenterImpl(page, model, paget_id, create_time, this);

        articleSwipe.setColorSchemeResources(R.color.swiprefreshColor1, R.color.swiprefreshColor2, R.color.swiprefreshColor3, R.color.swiprefreshColor4);
        articleSwipe.setOnRefreshListener(this);
        adapter = new ArticleAdapter(this, pageDataEntities);
        articleRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        articleRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        articleRecycler.setAdapter(adapter);
        pagePresenter.getEntityData();
        adapter.setOnChildClickListener(this);
        articleRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isRefresh) {
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                    int position = recyclerView.getChildAdapterPosition(childAt);
                    if (adapter.getItemCount() - position < 5) {
                        isRefresh = true;
                        pagePresenter.toMoreData(++page, model,
                                Integer.parseInt(pageDataEntities.get(pageDataEntities.size() - 1).getId()),
                                Integer.parseInt(pageDataEntities.get(pageDataEntities.size() - 1).getCreate_time()));
                        pagePresenter.getEntityData();
                    }
                }
            }
        });
    }

    @Override
    public void onChildClick(View child, int positon, String url) {
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(URL, url);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        pagePresenter.getEntityData();
        isRefresh = false;
    }

    @Override
    public void getData(PageEntity entity) {
        //pageDataEntities = entity.getDatas();
        pageDataEntities.addAll(entity.getDatas());
        if (!isRefresh) {
            articleSwipe.setRefreshing(isRefresh);
            adapter.notifyDataSetChanged();
        }
        isRefresh = true;

    }

    @Override
    public void shoeError() {
        Toast.makeText(this, "网络加载错误......", Toast.LENGTH_LONG).show();
    }


}
