package com.fruit.baocms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fruit.baocms.R;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by Administrator on 2016/8/25.
 */
public class SeckillAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;

    int[] images;
    String[] option;

    public SeckillAdapter(Context context) {
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
        return 2;
     //   return option == null?0:option.length;
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
            view = mInflater.inflate(R.layout.adapter_seckill, null);
            holder.mPicIv = (ImageView) view.findViewById(R.id.seckill_pic_iv);
            holder.mNameTv = (TextView) view.findViewById(R.id.seckill_name_tv);
            holder.mCountdownCv = (CountdownView) view.findViewById(R.id.seckill_countdown);
            holder.mPriceTv = (TextView) view.findViewById(R.id.seckill_price_tv);
            holder.mOldPriceTv = (TextView) view.findViewById(R.id.seckill_old_price_tv);
            holder.mExtendTv = (TextView) view.findViewById(R.id.seckill_extend_tv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
//        holder.mPicIv.setImageResource(images[i]);;
//        holder.mTitleTv.setText(option[i]);
        return view;
    }

    private final class ViewHolder {
        private TextView mNameTv,mPriceTv,mOldPriceTv,mExtendTv;
        private ImageView mPicIv;
        private CountdownView mCountdownCv;
    }
}

