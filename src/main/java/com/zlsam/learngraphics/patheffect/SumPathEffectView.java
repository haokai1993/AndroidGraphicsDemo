package com.zlsam.learngraphics.patheffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhanglong on 16/8/18.
 */
public class SumPathEffectView extends View {

    private int mCornerRadius = 0;
    private float mSolidLength = 1F;
    private float mVirtualLength = 1F;
    private float mPhase = 0;
    private Path mPath;
    private Paint mPaint;

    public SumPathEffectView(Context context) {
        this(context, null);
    }

    public SumPathEffectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SumPathEffectView(Context context, AttributeSet attrs, int defStyleAttr) {
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
            mPaint.setPathEffect(new SumPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase), new CornerPathEffect(mCornerRadius)));
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
        mPaint.setPathEffect(new SumPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase), new CornerPathEffect(mCornerRadius)));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    public void setCornerRadius(int radius) {
        mCornerRadius = radius;
        mPaint.setPathEffect(new SumPathEffect(new DashPathEffect(new float[]{mSolidLength, mVirtualLength}, mPhase), new CornerPathEffect(mCornerRadius)));
        invalidate();
    }

    public int getCornerRadius() {
        return mCornerRadius;
    }

    public void setSolidLength(float length) {
        mSolidLength = length;
        mPaint.setPathEffect(new SumPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase), new CornerPathEffect(mCornerRadius)));
        invalidate();
    }

    public float getSolidLength() {
        return mSolidLength;
    }

    public void setVirtualLength(float length) {
        mVirtualLength = length;
        mPaint.setPathEffect(new SumPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase), new CornerPathEffect(mCornerRadius)));
        invalidate();
    }

    public float getVirtualLength() {
        return mVirtualLength;
    }

    public void setPhase(float phase) {
        mPhase = phase;
        mPaint.setPathEffect(new SumPathEffect(new DashPathEffect(new float[] {mSolidLength, mVirtualLength}, mPhase), new CornerPathEffect(mCornerRadius)));
        invalidate();
    }

    public float getPhase() {
        return mPhase;
    }
}
