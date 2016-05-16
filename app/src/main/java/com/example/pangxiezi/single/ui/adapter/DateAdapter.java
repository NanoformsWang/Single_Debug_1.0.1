package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.bean.PageDataEntity;

import com.example.pangxiezi.single.utils.PicassoUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pangxiezi on 2016/3/17.
 */
public class DateAdapter extends AppBaseAdapter<PageDataEntity> {
    private List<PageDataEntity> datas;
    private Context context;
    private ListView listView;
    private int height;

    public DateAdapter(Context context, List<PageDataEntity> datas , ListView listView) {
        super(datas, context);
        this.context = context;
        this.datas = datas;
        this.listView = listView;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_date,parent,false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }

        vh = (ViewHolder) convertView.getTag();
        vh.img.setImageURI(Uri.parse(datas.get(position).getThumbnail()));
        height = convertView.getHeight();
        return convertView;
    }
    private class ViewHolder{
        private SimpleDraweeView img;
        public ViewHolder(View itemView) {
            img = (SimpleDraweeView) itemView.findViewById(R.id.simpleView_item_date);
        }
    }
    public int getHeight(){
            return height;
    }


}
