package com.example.pangxiezi.single.ui.adapter;

import android.support.v7.widget.RecyclerView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPagerAdapter;

/**
 * Created by COSCO on 2016/3/20.
 */
public class HomeRecyclerPageAdapter extends RecyclerViewPagerAdapter<HomeAdapter.HomeViewHolder> {
    public HomeRecyclerPageAdapter(RecyclerViewPager viewPager, RecyclerView.Adapter<HomeAdapter.HomeViewHolder> adapter) {
        super(viewPager, adapter);
    }
}
