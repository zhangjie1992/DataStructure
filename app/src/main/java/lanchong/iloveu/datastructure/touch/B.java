package lanchong.iloveu.datastructure.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class B extends FrameLayout {
    public B(Context context) {
        super(context);
    }

    public B(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public B(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("B","dispatchTouchEvent:"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("B","onInterceptTouchEvent:"+ev.getAction());
        if (ev.getAction()==MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("B","onTouchEvent:"+event.getAction());
        return super.onTouchEvent(event);
    }

}
