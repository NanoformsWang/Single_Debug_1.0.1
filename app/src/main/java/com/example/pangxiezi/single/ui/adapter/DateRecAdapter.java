package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by pangxiezi on 2016/3/19.
 */
public class DateRecAdapter  extends RecyclerView.Adapter<DateRecAdapter.RecViewHolder> implements View.OnClickListener {
        private List<PageDataEntity> datas;
        private Context context;
        private LayoutInflater inflater;
        private onClickChildListener listener;
        private RecyclerView recyclerView;

        public DateRecAdapter(List<PageDataEntity> datas, Context context,RecyclerView recyclerView) {
            this.datas = datas;
            this.context = context;
            this.recyclerView = recyclerView;
            inflater = LayoutInflater.from(context);
        }
        public void setOnonClickChildListener(onClickChildListener  listener){
            this.listener = listener;
        }

    @Override
        public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_date,parent,false);
            view.setOnClickListener(this);
            return new RecViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecViewHolder holder, int position) {
            holder.img.setImageURI(Uri.parse(datas.get(position).getThumbnail()));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }



    public class RecViewHolder extends RecyclerView.ViewHolder{
            private SimpleDraweeView img;

            public RecViewHolder(View itemView) {
                super(itemView);
                img = (SimpleDraweeView) itemView.findViewById(R.id.simpleView_item_date);
            }
        }

    @Override
    public void onClick(View v) {
        if(listener != null){
            int position = recyclerView.getChildAdapterPosition(v);
            listener.clickChildListener(v,position,datas.get(position));
        }
    }
    public interface   onClickChildListener{
     public void clickChildListener(View v,int position,PageDataEntity entity);
    }

}
