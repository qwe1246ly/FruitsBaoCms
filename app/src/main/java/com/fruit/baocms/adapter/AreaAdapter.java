package com.fruit.baocms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fruit.baocms.R;

/**
 * Created by Administrator on 2016/8/26.
 */
public class AreaAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    String[] infos;
    public int curPosition = 0;

    public AreaAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setInfos(String[] infos) {
        this.infos = infos;
    }

    @Override
    public int getCount() {
        return infos==null?0:infos.length;
    }

    @Override
    public Object getItem(int i) {
        return infos[i];
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
            view = mInflater.inflate(R.layout.adapter_area, null);
            holder.mNameTv = (TextView)view.findViewById(R.id.area_name);
            holder.mColor = (View)view.findViewById(R.id.area_view);
            holder.mBackgroundColor= (LinearLayout)view.findViewById(R.id.area_ll);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mNameTv.setText(infos[i]);
        if (i == curPosition) {
            holder.mNameTv.setTextColor(context.getResources().getColor(
                    R.color.theme_color));
            holder.mColor.setBackgroundResource(R.color.theme_color);
            holder.mBackgroundColor.setBackgroundResource(R.color.white);
        } else {
            holder.mNameTv.setTextColor(context.getResources().getColor(
                    R.color.black));
            holder.mColor.setBackgroundResource(0);
            holder.mBackgroundColor.setBackgroundResource(0);
        }
        return view;
    }

    private final class ViewHolder {
        private TextView mNameTv;
        private View mColor;
        private LinearLayout mBackgroundColor;
    }
}
