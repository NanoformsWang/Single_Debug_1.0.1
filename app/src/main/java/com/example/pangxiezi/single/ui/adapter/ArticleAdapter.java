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
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by COSCO on 2016/3/17.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> implements View.OnClickListener {

    private Context context;
    private List<PageDataEntity> pageDataEntities;

    private RecyclerView recyclerView;
    private OnChildClickListener listener;

    public void setOnChildClickListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    public ArticleAdapter(Context context, List<PageDataEntity> pageDataEntities) {
        this.context = context;
        this.pageDataEntities = pageDataEntities;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        view.setOnClickListener(this);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
//        Picasso picasso = Picasso.with(context);
//        picasso.setIndicatorsEnabled(true);
//        picasso.load(pageDataEntities.get(position).getThumbnail())
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(holder.articleImg);
        holder.articleImg.setImageURI(Uri.parse(pageDataEntities.get(position).getThumbnail()));
        holder.articleTitle.setText(pageDataEntities.get(position).getTitle());
        holder.articleAuthor.setText(pageDataEntities.get(position).getAuthor());

    }

    @Override
    public int getItemCount() {
        return pageDataEntities != null ? pageDataEntities.size() : 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onClick(View v) {
        if (recyclerView != null) {
            int position = recyclerView.getChildAdapterPosition(v);
            listener.onChildClick(v, position, pageDataEntities.get(position).getHtml5());
        }
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView articleImg;
        private final TextView articleTitle;
        private final TextView articleAuthor;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            articleImg = ((SimpleDraweeView) itemView.findViewById(R.id.article_img));
            articleTitle = ((TextView) itemView.findViewById(R.id.article_title_txt));
            articleAuthor = ((TextView) itemView.findViewById(R.id.article_author_txt));
        }
    }

    public interface OnChildClickListener {
        void onChildClick(View child, int positon, String url);
    }
}
