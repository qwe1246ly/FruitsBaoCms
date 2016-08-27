package com.fruit.baocms.fragment;

import android.content.Intent;
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
import com.fruit.baocms.activity.LocationActivity;
import com.fruit.baocms.activity.SearchActivity;
import com.fruit.baocms.adapter.HotSaleAdapter;
import com.fruit.baocms.adapter.OptionAdapter;
import com.fruit.baocms.adapter.SeckillAdapter;
import com.fruit.baocms.widget.CycleViewPager;
import com.fruit.baocms.widget.GridViewForScrollView;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by Administrator on 2016/8/25.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    LinearLayout mLocationLl;
    TextView mLocationTv,mRouteTv;
    RelativeLayout mSearchRl;
    ImageView mMenuIv,mSeckillIv,mFirstIv,mSecondIv,mThirdIv;
    private CycleViewPager cycleViewPager;
    GridViewForScrollView mOptionGv,mSeckillGv,mHotSaleGv;
    CountdownView mCountDownCv;

    OptionAdapter optionAdapter;
    SeckillAdapter seckillAdapter;
    HotSaleAdapter hotSaleAdapter;

    int[] images = new int[]{R.mipmap.icon_option_alarm,R.mipmap.icon_option_price,R.mipmap.icon_option_seckill,R.mipmap.icon_option_book};
    String[] option = new String[]{"限时抢购","天天特价","整点秒杀","洗浴预约"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        mLocationLl = (LinearLayout) view.findViewById(R.id.home_location_ll);
        mLocationTv = (TextView) view.findViewById(R.id.home_location_tv);
        mRouteTv = (TextView) view.findViewById(R.id.home_route_tv);
        mSearchRl = (RelativeLayout) view.findViewById(R.id.home_search_rl);
        mMenuIv = (ImageView) view.findViewById(R.id.home_menu_iv);
        cycleViewPager = (CycleViewPager) getActivity().getFragmentManager()
                .findFragmentById(R.id.home_fragment_cycle_viewpager);
        mOptionGv = (GridViewForScrollView) view.findViewById(R.id.home_option_gv);
        mCountDownCv = (CountdownView) view.findViewById(R.id.home_countdown);
        mSeckillIv = (ImageView) view.findViewById(R.id.icon_seckill_iv);
        mFirstIv = (ImageView) view.findViewById(R.id.icon_first_iv);
        mSecondIv = (ImageView) view.findViewById(R.id.icon_second_iv);
        mThirdIv = (ImageView) view.findViewById(R.id.icon_third_iv);
        mSeckillGv = (GridViewForScrollView) view.findViewById(R.id.home_seckill_gv);
        mHotSaleGv = (GridViewForScrollView) view.findViewById(R.id.home_hotsale_gv);

        optionAdapter = new OptionAdapter(getActivity());
        optionAdapter.setImages(images);
        optionAdapter.setOption(option);
        mOptionGv.setAdapter(optionAdapter);

        seckillAdapter = new SeckillAdapter(getActivity());
        mSeckillGv.setAdapter(seckillAdapter);

        hotSaleAdapter = new HotSaleAdapter(getActivity());
        mHotSaleGv.setAdapter(hotSaleAdapter);

        mLocationLl.setOnClickListener(this);
        mSearchRl.setOnClickListener(this);
        mMenuIv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.home_location_ll:
                intent.setClass(getActivity(),LocationActivity.class);
                startActivity(intent);
                break;
            case R.id.home_search_rl:
                intent.setClass(getActivity(),SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.home_menu_iv:

                break;
            default:
                break;
        }



    }
}
