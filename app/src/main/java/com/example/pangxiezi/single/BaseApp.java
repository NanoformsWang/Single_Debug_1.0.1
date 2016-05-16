package com.example.pangxiezi.single;

import android.app.Application;

import com.example.pangxiezi.single.utils.FrescoHelper;

import cn.smssdk.SMSSDK;


public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FrescoHelper.getInstance().init(this);
        SMSSDK.initSDK(this, "10a126d83db00", "bc57385111a736369a3b9a8dc4b4593f");
    }
}
