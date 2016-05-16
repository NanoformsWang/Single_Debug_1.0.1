package com.example.pangxiezi.single.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.bean.PageDataEntity;
import com.example.pangxiezi.single.utils.PicassoUtil;

import java.util.List;

/**
 * @version V1.0
 * @description:
 * @title: Sybl
 * @package com.qf.sybl.adapter
 * @author: zhangwei
 * @date: 2016-03-04 下午4:31
 */
public class VideoAdapter extends AppBaseAdapter<PageDataEntity> {

    public VideoAdapter(List<PageDataEntity> list, Context context) {
        super(list, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_recycle, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);

        }
           vh = (ViewHolder) convertView.getTag();
            vh.textType.setText(list.get(position).getAuthor());
            vh.textContent.setText(list.get(position).getTitle());
            PicassoUtil.loadImage(context,list.get(position).getThumbnail(),vh.img,R.mipmap.holdplace);

        return convertView;
    }

    public static class ViewHolder {
        private TextView textContent,textType;
        private ImageView img;

        public ViewHolder(View itemView) {
            img = (ImageView) itemView.findViewById(R.id.img_item_recycle);
            textContent = (TextView) itemView.findViewById(R.id.content_item_recycle);
            textType = (TextView) itemView.findViewById(R.id.type_item_recycle);
        }
    }


}
