package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by COSCO on 2016/3/17.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> implements View.OnClickListener {

    private Context context;
    private List<PageDataEntity> pageDataEntities;

    private RecyclerViewPager recyclerView;
    private OnChildClickListener listener;

    public void setOnChildClickListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    public HomeAdapter(Context context, List<PageDataEntity> pageDataEntities, RecyclerViewPager recyclerView) {
        this.context = context;
        this.pageDataEntities = pageDataEntities;
        this.recyclerView = recyclerView;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        view.setOnClickListener(this);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
//        Picasso picasso = Picasso.with(context);
//        picasso.setIndicatorsEnabled(true);
//        picasso.load(pageDataEntities.get(position).getThumbnail())
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(holder.homeImg);
        holder.homeImg.setImageURI(Uri.parse(pageDataEntities.get(position).getThumbnail()));
        holder.homeCategoryTxt.setText( pageDataEntities.get(position).getCategory());
        holder.homeTitleTxt.setText(pageDataEntities.get(position).getTitle());
        holder.homeExcerptTxt.setText(pageDataEntities.get(position).getExcerpt());
        holder.homeAuthorTxt.setText(pageDataEntities.get(position).getAuthor());
        holder.homeCommentTxt.setText(pageDataEntities.get(position).getComment());
        holder.homeGoodTxt.setText(pageDataEntities.get(position).getGood());
        holder.homeReadTxt.setText(pageDataEntities.get(position).getView());
    }

    @Override
    public int getItemCount() {
        return pageDataEntities != null ? pageDataEntities.size() : 0;
    }

//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//        this.recyclerView = recyclerView;
//    }

    @Override
    public void onClick(View v) {
        if (recyclerView != null) {
            int position = recyclerView.getChildAdapterPosition(v);
            listener.onChildClick(v, position, pageDataEntities.get(position).getHtml5());
        }
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView homeImg;
        private final TextView homeCategoryTxt;
        private final TextView homeTitleTxt;
        private final TextView homeExcerptTxt;
        private final TextView homeAuthorTxt;
        private final TextView homeCommentTxt;
        private final TextView homeGoodTxt;
        private final TextView homeReadTxt;

        public HomeViewHolder(View itemView) {
            super(itemView);
            homeImg = ((SimpleDraweeView) itemView.findViewById(R.id.home_img));
            homeCategoryTxt = ((TextView) itemView.findViewById(R.id.home_category_txt));
            homeTitleTxt = ((TextView) itemView.findViewById(R.id.home_title_txt));
            homeExcerptTxt = ((TextView) itemView.findViewById(R.id.home_excerpt_txt));
            homeAuthorTxt = ((TextView) itemView.findViewById(R.id.home_author_txt));
            homeCommentTxt = ((TextView) itemView.findViewById(R.id.home_comment_txt));
            homeGoodTxt = ((TextView) itemView.findViewById(R.id.home_good_txt));
            homeReadTxt = ((TextView) itemView.findViewById(R.id.home_read_txt));
        }
    }

    public interface OnChildClickListener {
        void onChildClick(View child, int positon, String url);
    }

}
