package lanchong.iloveu.datastructure.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;

public class C extends TextView {
    public C(Context context) {
        super(context);
    }

    public C(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("C","dispatchTouchEvent:"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("C","onTouchEvent:"+event.getAction());
        return true;
    }

}
