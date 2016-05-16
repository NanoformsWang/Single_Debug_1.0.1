package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.utils.PicassoUtil;

import java.util.List;

/**
 * Created by pangxiezi on 2016/3/16.
 */
public class MusicAdapter  extends RecyclerView.Adapter<MusicAdapter.MusicAdapterViewHolder> implements View.OnClickListener {
    private Context context;
    private List<PageDataEntity> datas;
    private LayoutInflater inflater;
    private AdapterChildClickListener listener;
    private RecyclerView recyclerView;
    public MusicAdapter(Context context, List<PageDataEntity> datas, RecyclerView recyclerView) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
        this.recyclerView = recyclerView;
    }
    public void setAdapterChildClickListener( AdapterChildClickListener listener){
        this.listener = listener;
    }
    @Override
    public MusicAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycle,parent,false);
        view.setOnClickListener(this);
        return new MusicAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicAdapterViewHolder holder, int position) {
       PicassoUtil.loadImage(context,datas.get(position).getThumbnail(),holder.img,R.mipmap.holdplace);
        holder.textTitle.setText(datas.get(position).getTitle());
        holder.textType.setText(datas.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            int position = recyclerView.getChildAdapterPosition(v);
            listener.ChildClickListener(v ,position,datas.get(position));
        }
    }

    public static class MusicAdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView textTitle,textType;

        public MusicAdapterViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_recycle);
            textTitle= (TextView) itemView.findViewById(R.id.content_item_recycle);
            textType = (TextView) itemView.findViewById(R.id.type_item_recycle);
        }
    }
    public interface AdapterChildClickListener{
        public void ChildClickListener(View v, int position, PageDataEntity entity);
    }
}
