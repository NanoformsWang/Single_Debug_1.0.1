package com.example.pangxiezi.single.ui.adapter;

import android.support.v7.widget.RecyclerView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPagerAdapter;

/**
 * Created by pangxiezi on 2016/3/19.
 */
public class DateRecyclerPageAdapter extends RecyclerViewPagerAdapter<DateRecAdapter.RecViewHolder> {
    public DateRecyclerPageAdapter(RecyclerViewPager viewPager, RecyclerView.Adapter<DateRecAdapter.RecViewHolder> adapter) {
        super(viewPager, adapter);
    }
}
