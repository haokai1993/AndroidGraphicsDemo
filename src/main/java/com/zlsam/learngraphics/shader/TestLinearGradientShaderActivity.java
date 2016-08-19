package com.zlsam.learngraphics.shader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zlsam.learngraphics.R;

/**
 * Created by zhanglong on 16/5/4.
 */
public class TestLinearGradientShaderActivity extends Activity {

    private EditText mStartAlphaColorEdit;
    private EditText mStartRedColorEdit;
    private EditText mStartGreenColorEdit;
    private EditText mStartBlueColorEdit;
    private EditText mEndAlphaColorEdit;
    private EditText mEndRedColorEdit;
    private EditText mEndGreenColorEdit;
    private EditText mEndBlueColorEdit;
    private EditText mStartPointX;
    private EditText mStartPointY;
    private EditText mEndPointX;
    private EditText mEndPointY;
    private Button mDraw;
    private ImageView mTargetImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_linear_gradient_shader);
        initViews();
    }

    private void initViews() {
        // Instances
        mStartAlphaColorEdit = (EditText) findViewById(R.id.edit_start_color_a);
        mStartRedColorEdit = (EditText) findViewById(R.id.edit_start_color_r);
        mStartGreenColorEdit = (EditText) findViewById(R.id.edit_start_color_g);
        mStartBlueColorEdit = (EditText) findViewById(R.id.edit_start_color_b);
        mEndAlphaColorEdit = (EditText) findViewById(R.id.edit_end_color_a);
        mEndRedColorEdit = (EditText) findViewById(R.id.edit_end_color_r);
        mEndGreenColorEdit = (EditText) findViewById(R.id.edit_end_color_g);
        mEndBlueColorEdit = (EditText) findViewById(R.id.edit_end_color_b);
        mStartPointX = (EditText) findViewById(R.id.edit_start_point_x_percentage);
        mStartPointY = (EditText) findViewById(R.id.edit_start_point_y_percentage);
        mEndPointX = (EditText) findViewById(R.id.edit_end_point_x_percentage);
        mEndPointY = (EditText) findViewById(R.id.edit_end_point_y_percentage);
        mDraw = (Button) findViewById(R.id.btn_draw);
        mTargetImg = (ImageView) findViewById(R.id.img_target);

        // Init draw
        mDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int startAlphaColor = Integer.parseInt(mStartAlphaColorEdit.getText().toString());
                int startRedColor = Integer.parseInt(mStartRedColorEdit.getText().toString());
                int startGreenColor = Integer.parseInt(mStartGreenColorEdit.getText().toString());
                int startBlueColor = Integer.parseInt(mStartBlueColorEdit.getText().toString());
                int endAlphaColor = Integer.parseInt(mEndAlphaColorEdit.getText().toString());
                int endRedColor = Integer.parseInt(mEndRedColorEdit.getText().toString());
                int endGreenColor = Integer.parseInt(mEndGreenColorEdit.getText().toString());
                int endBlueColor = Integer.parseInt(mEndBlueColorEdit.getText().toString());
                LinearGradient gradient = new LinearGradient(getResources().getDisplayMetrics().widthPixels * Integer.parseInt(mStartPointX.getText().toString()) / 100.0F,
                        (float) getResources().getDisplayMetrics().heightPixels * Integer.parseInt(mStartPointY.getText().toString()) / 100.0F,
                        (float) getResources().getDisplayMetrics().heightPixels * Integer.parseInt(mEndPointX.getText().toString()) / 100.0F,
                        (float) getResources().getDisplayMetrics().heightPixels * Integer.parseInt(mEndPointY.getText().toString()) / 100.0F,
                        startAlphaColor << 24 | startRedColor << 16 | startGreenColor << 8 | startBlueColor,
                        endAlphaColor << 24 | endRedColor << 16 | endGreenColor << 8 | endBlueColor,
                        Shader.TileMode.CLAMP);
                Paint paint = new Paint();
                paint.setShader(gradient);
                Bitmap targetBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(targetBitmap);
                canvas.drawPaint(paint);
                mTargetImg.setImageBitmap(targetBitmap);
            }
        });
    }
}
