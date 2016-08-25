package com.yzy.horizontalscrollview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {

	private static final long ANIM_TIME = 200;
	private int x;
	private int y;
	private int top;
	private int bottom;
	private int left;
	private int right;

	public MyScrollView(Context context) {
		super(context);
		initView();
	}

	public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	private int scrollY;

	private int height;
	private int scrollViewMeasuredHeight;
	// private Runnable run = new Runnable() {
	//
	// @Override
	// public void run() {
	//
	// layout(left, top, right, bottom);
	// handler.postDelayed(run, 20);
	// }
	// };
	// private Handler handler = new Handler();
	private boolean isTop = true;
	private ValueAnimator anim;
	private boolean isIn = false;
	private boolean isRelease;

	private void initView() {
		addOnLayoutChangeListener(new OnLayoutChangeListener() {

			@Override
			public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop,
					int oldRight, int oldBottom) {
				if (scrollViewMeasuredHeight != getChildAt(0).getMeasuredHeight()) {
					scrollViewMeasuredHeight = getChildAt(0).getMeasuredHeight();
					post(new Runnable() {
						public void run() {
							height = getHeight();
						}
					});
				}
			}
		});
		post(new Runnable() {

			@Override
			public void run() {
				left = getLeft();
				top = getTop();
				bottom = getBottom();
				right = getRight();
				height = getHeight();
				scrollViewMeasuredHeight = getChildAt(0).getMeasuredHeight();
			}
		});
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x = (int) ev.getX();
			y = (int) ev.getY();
			isIn = false;
			isRelease = false;
			break;
		case MotionEvent.ACTION_UP:
			isRelease = false;
			if (isIn) {

				TranslateAnimation anim = new TranslateAnimation(0, 0, getTop(), top);

				anim.setDuration(ANIM_TIME);

				startAnimation(anim);
				layout(left, top, right, bottom);
				isIn = false;
				return true;
			}
			break;
		case MotionEvent.ACTION_MOVE:
			int x3 = (int) ev.getX();
			int y3 = (int) ev.getY();
			int dY = y - y3;
			int dx = x - x3;
			if (Math.abs(dx)>20) {
				isRelease = true;
			}
			if (!isIn&&isRelease) {
				return super.dispatchTouchEvent(ev);
			}
			scrollY = getScrollY();
			if (Math.abs(dY) > Math.abs(dx) && Math.abs(dx)<5&& dY < 0 && scrollY == 0) {
				layout(left, top - dY / 2, right, bottom - dY / 2);
				isIn = true;
				return true;
			}
			if (Math.abs(dY) > Math.abs(dx)&& Math.abs(dx)<5 && dY > 0 && (scrollY + height) == scrollViewMeasuredHeight) {
				layout(left, top - dY / 2, right, bottom - dY / 2);
				isIn = true;
				return true;
			}
			if (isIn) {
				layout(left, top - dY / 2, right, bottom - dY / 2);
				return true;
			}
			break;
		default:
			break;
		}

		return super.dispatchTouchEvent(ev);
	}

}
