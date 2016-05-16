package com.example.pangxiezi.single.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.utils.FrescoHelper;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_base);
    }
}
