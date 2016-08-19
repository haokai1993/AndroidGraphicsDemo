package com.zlsam.learngraphics.shader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import com.zlsam.learngraphics.R;

/**
 * Created by zhanglong on 16/5/3.
 */
public class TestBitmapShaderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_bitmap_shader);

        // Instances
        ImageView sourceImg = (ImageView) findViewById(R.id.img_source);
        final Bitmap sourceBitmap = ((BitmapDrawable) sourceImg.getDrawable()).getBitmap();
        final Spinner xSpinner = (Spinner) findViewById(R.id.spinner_tile_mode_x);
        final Spinner ySpinner = (Spinner) findViewById(R.id.spinner_tile_mode_y);
        final ImageView targetImg = (ImageView) findViewById(R.id.img_target);
        Button shadeBtn = (Button) findViewById(R.id.btn_shade);

        // Init
        shadeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint paint = new Paint();
                paint.setShader(new BitmapShader(sourceBitmap, string2TileMode((String) xSpinner.getSelectedItem()), string2TileMode((String) ySpinner.getSelectedItem())));
                Bitmap targetBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(targetBitmap);
                canvas.drawPaint(paint);
                targetImg.setImageBitmap(targetBitmap);
            }
        });
    }

    private Shader.TileMode string2TileMode(String modeStr) {
        switch (modeStr) {
            case "CLAMP":
                return Shader.TileMode.CLAMP;
//                break;
            case "REPEAT":
                return Shader.TileMode.REPEAT;
//                break;
            case "MIRROR":
                return Shader.TileMode.MIRROR;
//                break;
            default:
                return Shader.TileMode.CLAMP;
//                break;
        }
    }
}
