package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @version V1.0
 * @description:
 * @title: Sybl
 * @package com.qf.sybl.adapter
 * @author: zhangwei
 * @date: 2016-03-04 下午5:40
 */
public abstract class AppBaseAdapter<T> extends BaseAdapter {

    public List<T> list;
    public Context context;
    public LayoutInflater inflater;

    public AppBaseAdapter(List<T> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position, convertView, parent);
    }

    public abstract View getItemView(int position, View convertView, ViewGroup parent);


}
