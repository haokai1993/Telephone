package com.phone.telephone.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private SparseArray<View> mViews;
    protected int mPosition;
    private View mConvertView;
    private Context context;

    public View getConvertView() {
        return mConvertView;
    }

    public ViewHolder(Context context, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        this.context = context;
        mConvertView = LayoutInflater.from(context).inflate(layoutId, null);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position; // 注意：这句代码是必须的，否则复用的时候position会出错
            return holder;
        }
    }

    public <T extends View> T getViewById(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = getConvertView().findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public ViewHolder setText(int viewId, String text) {
        TextView textView = getViewById(viewId);
        textView.setText(text);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView imageView = getViewById(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = getViewById(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public ViewHolder setImg(int viewId, String url) {
        ImageView imageView = getViewById(viewId);
        imageView.setImageURI(Uri.parse(url));
        return this;
    }

    public ViewHolder setImgOnClick(int viewId, View.OnClickListener onClickListener) {
        ImageView imageView = getViewById(viewId);
        imageView.setOnClickListener(onClickListener);
        return this;
    }
}
