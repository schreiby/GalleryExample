package com.example.ettie.galleryexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by Ettie on 6/15/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Integer[] imageIdArr = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
    Context context;
    int itemBackground;

    public ImageAdapter(Context context) {
        this.context = context;

        //set style
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.Gallery1);
        itemBackground = typedArray.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
        typedArray.recycle();
    }

    @Override
    public int getCount() {
        return imageIdArr.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null) {
            imageView = new ImageView(context);
            imageView.setImageResource(imageIdArr[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(180, 150));
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setBackgroundResource(itemBackground);
        return imageView;
    }
}