package com.example.pangxiezi.single.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pangxiezi.single.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by COSCO on 2016/3/17.
 */
public class DetailActivity extends BaseActivity implements View.OnClickListener {

    private static final String URL = "URL";


    @Bind(R.id.detail_web)
    WebView detailWeb;
    @Bind(R.id.detail_back)
    ImageButton detailBack;
    @Bind(R.id.detail_favorite)
    ImageButton detailFavorite;
    @Bind(R.id.detail_write)
    ImageButton detailWrite;
    @Bind(R.id.detail_share)
    ImageButton detailShare;
//    @Bind(R.id.detail_toolbar)
//    Toolbar detailToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String url = getIntent().getStringExtra(URL);

//        setSupportActionBar(detailToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        detailWeb.loadUrl(url);
//        detailWeb.setWebViewClient(new WebViewClient());

//        initView(String url);

        initView(url);
        initEvent();


    }

    private void initEvent() {
        detailBack.setOnClickListener(this);
        detailFavorite.setOnClickListener(this);
        detailWrite.setOnClickListener(this);
        detailShare.setOnClickListener(this);
    }

    private void initView(String url) {
        detailWeb.loadUrl(url);
        detailWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        detailWeb.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放
        detailWeb.getSettings().setLoadWithOverviewMode(true);//将图片调整到适合webview的大小
        detailWeb.getSettings().setJavaScriptEnabled(true);  //支持js
    }

    //    private void initView(String url) {
//        init(url);
//    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {//使按下回退键时回到上一个页面而不是推出整个程序
        if ((keyCode == KeyEvent.KEYCODE_BACK) && detailWeb.canGoBack()) {
            detailWeb.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_back:
                finish();
                break;
            case R.id.detail_favorite:
                Toast.makeText(this, "收藏一下吧...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.detail_write:
                Toast.makeText(this, "点评一下吧...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.detail_share:

                break;
        }
    }
}