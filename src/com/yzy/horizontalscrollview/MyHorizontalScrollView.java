
package com.yzy.horizontalscrollview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class MyHorizontalScrollView extends HorizontalScrollView {  
  
  
    public MyHorizontalScrollView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
  
    /** 
     * 滑动事件(让滑动的速度变为原来的1/2) 
     */  
    @Override  
    public void fling(int velocityY) {  
        super.fling(velocityY / 2);  
    }  
  
}

