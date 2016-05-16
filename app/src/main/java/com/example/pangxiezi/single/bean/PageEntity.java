package com.example.pangxiezi.single.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public class PageEntity implements Serializable {

    @SerializedName("status")
    private String status;
    @SerializedName("msg")
    private String msg;
    @SerializedName("code")
    private int code;
    private ArrayList<PageDataEntity> datas;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<PageDataEntity> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<PageDataEntity> datas) {
        this.datas = datas;
    }
}
