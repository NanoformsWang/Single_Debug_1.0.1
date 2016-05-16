package com.example.pangxiezi.single.utils;

import java.util.HashMap;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public class ParamsMap extends HashMap<String, String> {
    public ParamsMap() {
    }

    public String put(String key, String value) {
        return super.put(key, value);
    }

    public void put(String key, int value) {
        super.put(key, value + "");
    }
}
