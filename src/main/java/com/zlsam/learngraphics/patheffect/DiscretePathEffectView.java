package com.zlsam.learngraphics.patheffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhanglong on 16/8/18.
 */
public class DiscretePathEffectView extends View {

    private float mSegmentLength = 1.0F;
    private float mDeviation = 1.0F;
    private Path mPath;
    private Paint mPaint;

    public DiscretePathEffectView(Context context) {
        this(context, null);
    }

    public DiscretePathEffectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiscretePathEffectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            // Init path
            mPath = new Path();
            mPath.moveTo(10, 100);
            mPath.lineTo(60, 10);
            mPath.lineTo(120, 190);
            mPath.lineTo(180, 40);
            mPath.lineTo(240, 160);
            mPath.lineTo(300, 10);
            mPath.lineTo(360, 190);
            mPath.lineTo(420, 40);
            mPath.lineTo(480, 160);

            // Init paint
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(2);
            mPaint.setColor(Color.CYAN);
            mPaint.setPathEffect(new DiscretePathEffect(mSegmentLength, mDeviation));
            return;
        }

        // Init path
        mPath = new Path();
        mPath.moveTo(10, 100);
        mPath.lineTo(60, 10);
        mPath.lineTo(120, 190);
        mPath.lineTo(180, 40);
        mPath.lineTo(240, 160);
        mPath.lineTo(300, 10);
        mPath.lineTo(360, 190);
        mPath.lineTo(420, 40);
        mPath.lineTo(480, 160);

        // Init paint
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.CYAN);
        mPaint.setPathEffect(new DiscretePathEffect(mSegmentLength, mDeviation));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    public void setSegmentLength(float length) {
        mSegmentLength = length;
        mPaint.setPathEffect(new DiscretePathEffect(mSegmentLength, mDeviation));
        invalidate();
    }

    public float getSegmentLength() {
        return mSegmentLength;
    }

    public void setDeviation(float deviation) {
        mDeviation = deviation;
        mPaint.setPathEffect(new DiscretePathEffect(mSegmentLength, mDeviation));
        invalidate();
    }

    public float getDeviation() {
        return mDeviation;
    }
}
