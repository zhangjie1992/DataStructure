package lanchong.iloveu.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class A extends FrameLayout {
    public A(Context context) {
        super(context);
    }

    public A(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public A(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("A","dispatchTouchEvent:"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("A","onInterceptTouchEvent:"+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("A","onTouchEvent:"+event.getAction());
        return super.onTouchEvent(event);
    }

}
