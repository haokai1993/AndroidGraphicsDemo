package com.zlsam.learngraphics.patheffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhanglong on 16/8/18.
 */
public class PathDashPathEffectView extends View {

    private Path mPath;
    private Paint mPaint;

    public PathDashPathEffectView(Context context) {
        this(context, null);
    }

    public PathDashPathEffectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathDashPathEffectView(Context context, AttributeSet attrs, int defStyleAttr) {
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

            Path path = new Path();
            path.addOval(new RectF(0, 0, 10, 20), Path.Direction.CCW);
            mPaint.setPathEffect(new PathDashPathEffect(path, 20, 0, PathDashPathEffect.Style.ROTATE));
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
        Path path = new Path();
        path.addOval(new RectF(0, 0, 10, 20), Path.Direction.CCW);
        mPaint.setPathEffect(new PathDashPathEffect(path, 20, 0, PathDashPathEffect.Style.ROTATE));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }
}
