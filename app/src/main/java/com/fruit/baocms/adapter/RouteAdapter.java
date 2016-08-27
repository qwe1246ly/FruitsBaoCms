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
public class RouteAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater mInflater;
    String[] infos;

    public RouteAdapter(Context context) {
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
            view = mInflater.inflate(R.layout.adapter_route, null);
            holder.mNameTv = (TextView)view.findViewById(R.id.route_name);
            holder.mDetailTv = (TextView)view.findViewById(R.id.route_detail);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mNameTv.setText(infos[i]);

        return view;
    }

    private final class ViewHolder {
        private TextView mNameTv,mDetailTv;
    }
}
