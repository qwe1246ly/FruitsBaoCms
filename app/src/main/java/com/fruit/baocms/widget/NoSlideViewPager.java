package com.fruit.baocms.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoSlideViewPager extends ViewPager {
	private boolean isCanScroll = false;

	public NoSlideViewPager(Context paramContext) {
		super(paramContext);
	}

	public NoSlideViewPager(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
		if (this.isCanScroll)
			return super.onInterceptTouchEvent(paramMotionEvent);
		return false;
	}

	public boolean onTouchEvent(MotionEvent paramMotionEvent) {
		if (this.isCanScroll)
			return super.onTouchEvent(paramMotionEvent);
		return false;
	}

	public void scrollTo(int paramInt1, int paramInt2) {
		super.scrollTo(paramInt1, paramInt2);
	}

	public void setCurrentItem(int paramInt) {
		super.setCurrentItem(paramInt);
	}

	public void setCurrentItem(int paramInt, boolean paramBoolean) {
		super.setCurrentItem(paramInt, paramBoolean);
	}

	public void setScanScroll(boolean paramBoolean) {
		this.isCanScroll = paramBoolean;
	}
}