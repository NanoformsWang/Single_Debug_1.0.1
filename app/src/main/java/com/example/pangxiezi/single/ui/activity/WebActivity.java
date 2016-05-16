package com.example.pangxiezi.single.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.api.ApiConstant;


import butterknife.Bind;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {
    @Bind(R.id.webView_web)
    WebView webView;
    private String url ="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        initData();
        initView();
    }

    private void initData() {
        if(getIntent() != null){
            url = getIntent().getStringExtra(ApiConstant.DefaultKey.HTML_KEY);
        }
    }

    private void initView() {
        if(!TextUtils.isEmpty(url)) {
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放
            webView.getSettings().setLoadWithOverviewMode(true);//将图片调整到适合webview的大小
            webView.getSettings().setJavaScriptEnabled(true);  //支持js
            webView.getSettings().setDomStorageEnabled(true);
            webView.loadUrl(url);
        }
        else
            Toast.makeText(this,"url为空",Toast.LENGTH_SHORT).show();

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {//使按下回退键时回到上一个页面而不是推出整个程序
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
