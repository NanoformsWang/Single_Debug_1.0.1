package com.example.pangxiezi.single.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public class PicassoUtil {
    public static void loadImage(Context context, String ImgUrl, ImageView img,int placeholderImg)
    {
        Picasso picasso = Picasso.with(context);
        picasso .setIndicatorsEnabled(true);
        picasso.load(ImgUrl).placeholder(placeholderImg).into(img);
    }
}
