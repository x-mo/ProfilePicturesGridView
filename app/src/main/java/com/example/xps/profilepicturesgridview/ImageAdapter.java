package com.example.xps.profilepicturesgridview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mThumbPaths;
    int c = 0;

    public ImageAdapter(Context c, String[] mThumbPaths) {
        mContext = c;
        this.mThumbPaths = mThumbPaths;
    }

    @Override
    public int getCount() {
        return mThumbPaths.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbPaths[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        } else {
            imageView = (ImageView) convertView;

        }
//https://graph.facebook.com/100001143923761/picture
        //Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
        Log.e("IMGS", position + " ");


        Picasso.with(mContext).load("https://graph.facebook.com/" + getItem(position) + "/picture").into(imageView);

        //if ((position+1) == getCount()) notifyDataSetChanged();
        //Picasso.with(mContext).load("http://image.tmdb.org/t/p/w185/" + mThumbPaths[position]).into(imageView);

        return imageView;
    }

}
