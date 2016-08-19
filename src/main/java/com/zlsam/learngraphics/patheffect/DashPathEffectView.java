package com.zlsam.learngraphics.patheffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhanglong on 16/8/18.
 */
public class DashPathEffectView extends View {

    private float mSolidLength = 1F;
    private float mVirtualLength = 1F;
    private float mPhase = 0;
    private Path mPath;
    private Paint mPaint;


    public DashPathEffectView(Context context) {
        this(context, null);
    }

    public DashPathEffectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DashPathEffectView(Context context, AttributeSet attrs, int defStyleAttr) {
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
            mPaint.setPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase));
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
        mPaint.setPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    public void setSolidLength(float length) {
        mSolidLength = length;
        mPaint.setPathEffect(new DashPathEffect(new float[]{mSolidLength, mVirtualLength}, mPhase));
        invalidate();
    }

    public float getSolidLength() {
        return mSolidLength;
    }

    public void setVirtualLength(float length) {
        mVirtualLength = length;
        mPaint.setPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase));
        invalidate();
    }

    public float getVirtualLength() {
        return mVirtualLength;
    }

    public void setPhase(float phase) {
        mPhase = phase;
        mPaint.setPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase));
        invalidate();
    }

    public float getPhase() {
        return mPhase;
    }

}
