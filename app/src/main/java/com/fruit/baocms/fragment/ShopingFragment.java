package com.fruit.baocms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fruit.baocms.R;

/**
 * Created by Administrator on 2016/8/25.
 */
public class ShopingFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shoping,null);
        initView(view);
        return view;

    }

    private void initView(View view) {
    }


}
