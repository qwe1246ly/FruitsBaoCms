package com.fruit.baocms.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fruit.baocms.fragment.AlarmFragment;
import com.fruit.baocms.fragment.HomeFragment;
import com.fruit.baocms.fragment.MineFragment;
import com.fruit.baocms.fragment.ShopingFragment;


public class MainPagerAdapter extends FragmentPagerAdapter {

	private static int TCOUNT = 4;

	public MainPagerAdapter(FragmentManager paramFragmentManager) {
		super(paramFragmentManager);
	}

	public int getCount() {
		return TCOUNT;
	}

	public Fragment getItem(int paramInt) {
		if (paramInt == 0) {
			return new HomeFragment();
		} else if (paramInt == 1) {
			return new AlarmFragment();
		} else if (paramInt == 2) {
			return new ShopingFragment();
		} else if (paramInt == 3) {
			return new MineFragment();
		}
		return null;
	}

}
