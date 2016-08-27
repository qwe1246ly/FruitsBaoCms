package com.fruit.baocms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fruit.baocms.R;
import com.fruit.baocms.adapter.HotSaleAdapter;
import com.fruit.baocms.widget.CycleViewPager;
import com.fruit.baocms.widget.GridViewForScrollView;

/**
 * Created by Administrator on 2016/8/25.
 */
public class AlarmFragment extends Fragment {

    private LinearLayout mLocationLl;
    private TextView mLocationTv,mRouteTv;
    private RelativeLayout mSearchRl;
    ImageView mMenuIv;
    private CycleViewPager cycleViewPager;
    private GridViewForScrollView mHotSaleGv;

    HotSaleAdapter hotSaleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm,null);
        initView(view);
        return view;

    }

    private void initView(View view) {



        mLocationLl = (LinearLayout) view.findViewById(R.id.alarm_location_ll);
        mLocationTv = (TextView) view.findViewById(R.id.alarm_location_tv);
        mRouteTv = (TextView) view.findViewById(R.id.alarm_route_tv);
        mSearchRl = (RelativeLayout) view.findViewById(R.id.alarm_search_rl);
        mMenuIv = (ImageView) view.findViewById(R.id.alarm_menu_iv);
        cycleViewPager = (CycleViewPager) getActivity().getFragmentManager()
                .findFragmentById(R.id.alarm_fragment_cycle_viewpager);
        mHotSaleGv = (GridViewForScrollView) view.findViewById(R.id.alarm_hotsale_gv);


        hotSaleAdapter = new HotSaleAdapter(getActivity());
        mHotSaleGv.setAdapter(hotSaleAdapter);

    }

}
