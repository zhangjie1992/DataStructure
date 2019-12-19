package lanchong.iloveu.diy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DiyView extends View {

    private Paint mPaint;
    //绘制时控制文本绘制的范围
    private Rect mBound;
    private String mText = "aaaa";

    public DiyView(Context context) {
        super(context);
        init();
    }

    public DiyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DiyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBound = new Rect();

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(60);

        mPaint.getTextBounds(mText, 0, mText.length(), mBound);

        postInvalidate();

        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        log(widthMeasureSpec, false);
        log(heightMeasureSpec, true);

        float textWidth = mPaint.measureText(mText);

        setMeasuredDimension(MeasureSpec.makeMeasureSpec((int) textWidth, MeasureSpec.getMode(widthMeasureSpec)),heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(mText, 0, getHeight() / 2 + mBound.height() / 2, mPaint);
    }




    private void log(int spec, boolean h) {
        int mode = MeasureSpec.getMode(spec);
        int size = MeasureSpec.getSize(spec);

        String mod = mode == MeasureSpec.AT_MOST ? "AT_MOST" : mode == MeasureSpec.EXACTLY ? "EXACTLY" : "UNSPECIFIED";


        Log.e("zjzjzj", (h ? "hhhh" : "") + "mod:" + mod + " size:" + size);

    }
}
