package com.fruit.baocms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fruit.baocms.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class OptionAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;

    int[] images;
    String[] option;

    public OptionAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setOption(String[] option) {
        this.option = option;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return option == null?0:option.length;
    }

    @Override
    public Object getItem(int i) {
        return option[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.adapter_option, null);
            holder.mPicIv = (ImageView) view.findViewById(R.id.image);
            holder.mTitleTv = (TextView) view.findViewById(R.id.title);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mPicIv.setImageResource(images[i]);;
        holder.mTitleTv.setText(option[i]);
        return view;
    }

    private final class ViewHolder {
        private TextView mTitleTv;
        ImageView mPicIv;
    }
}
