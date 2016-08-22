package com.yzy.horizontalscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ListView;

public class MListView extends ListView {


	    private int startX;
		private int startY;
		private boolean isMoving = false;
		private long starTime;
		private int pos;
		private View startDragView;
		private int left;
		private int top;
		private int right;
		private int bottom;
		private int width;

		public MListView(Context context) {
		super(context);
		init();
	}

		public MListView(Context context, AttributeSet attrs, int defStyleAttr) {
			super(context, attrs, defStyleAttr);
			init();
		}

		public MListView(Context context, AttributeSet attrs) {
			super(context, attrs);
			init();
		}

		@Override
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2
	                , MeasureSpec.AT_MOST);
	        super.onMeasure(widthMeasureSpec, expandSpec);
	    }
		private void init() {
		}

//@Override
//public boolean dispatchTouchEvent(MotionEvent event) {
//
//	
//	switch (event.getAction()) {
//	case MotionEvent.ACTION_DOWN:
//		startX = (int) event.getX();
//		startY = (int) event.getY();
//		pos = pointToPosition(startX,startY);
//		isMoving = false;
//		if (pos==ListView.INVALID_POSITION) {
//			return false;
//		}
//		starTime = System.currentTimeMillis();
//		startDragView = getChildAt(pos - getFirstVisiblePosition());
//		left = startDragView.getLeft();
//		top = startDragView.getTop();
//		right = startDragView.getRight();
//		bottom = startDragView.getBottom();
//		break;
//	case MotionEvent.ACTION_MOVE:
//		int moveX = (int) event.getX();
//		int moveY = (int) event.getY();
//		int dY = moveY-startY;
//		int dX = moveX-startX;
//		if (Math.abs(dY)<10&&Math.abs(dX)<10&&!isMoving ) {
//			if (System.currentTimeMillis()-starTime>=1000) {
//				 isMoving = true;
//				 requestDisallowInterceptTouchEvent(true);
//			}
//			
//		}else if(isMoving){
//			 startDragView.layout(0, top+dY, 0, bottom+dY);
//		}else{
//			return false;
//		}
//		break;
//	case MotionEvent.ACTION_UP:
//		if (isMoving) {
//			isMoving = false;
//			return true;
//		}
//		return false;
//
//	default:
//		break;
//	}
//
//return super.dispatchTouchEvent(event);
}
		
		
		
		
		
		
		
		
