package com.fruit.baocms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.fruit.baocms.R;
import com.fruit.baocms.utils.Global;
import com.fruit.baocms.utils.Utils;

import java.util.List;

/**
 * Created by Administrator on 2016/1/22.
 */
public class FunctionListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    String[] infos;
    int[] images;
    int type;
   List<String> tips;

    public FunctionListAdapter(Context context, String[] infos) {
        this.context = context;
        this.infos = infos;
        mInflater = LayoutInflater.from(context);
    }

    public void setTips(List<String> tips) {
        this.tips = tips;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getCount() {
        return infos == null ? 0 : infos.length;
    }

    @Override
    public Object getItem(int position) {
        return infos[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.adapter_functionlist, null);
            holder.mTips = (TextView) convertView.findViewById(R.id.function_txt);
            holder.mPics = (ImageView) convertView.findViewById(R.id.function_pic);
            holder.mNumber = (TextView) convertView.findViewById(R.id.function_num);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTips.setText(infos[position]);
        holder.mPics.setImageResource(images[position]);

        if(type==1){
            holder.mNumber.setVisibility(View.VISIBLE);
            if(!Utils.isEmpty(Global.token)){
                holder.mNumber.setText(tips.get(position));
            }
        }else{
            holder.mNumber.setVisibility(View.GONE);
        }
        return convertView;
    }

    private final class ViewHolder {
        private TextView mTips,mNumber;
        private ImageView mPics;
    }
}