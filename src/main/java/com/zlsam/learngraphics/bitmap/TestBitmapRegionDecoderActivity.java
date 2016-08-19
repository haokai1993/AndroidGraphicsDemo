package com.zlsam.learngraphics.bitmap;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.zlsam.learngraphics.R;
import java.io.IOException;

/**
 * BitmapRegionDecoder可用于图片的矩形剪裁.
 * Created by zhanglong on 16/4/13.
 */
public class TestBitmapRegionDecoderActivity extends Activity {
    private ImageView mSourceImage;
    private ImageView mTargetImage;
    private Button mRegionDecodeBtn;
    private Activity mActivityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_bitmap_region_decoder);
        mActivityContext = this;

        // Instances
        mSourceImage = (ImageView) findViewById(R.id.img_source);
        mTargetImage = (ImageView) findViewById(R.id.img_target);
        mRegionDecodeBtn = (Button) findViewById(R.id.btn_region_decode);

        // Init
        try {
            mSourceImage.setImageBitmap(BitmapFactory.decodeStream(this.getAssets().open("img/test_img1.jpg")));
        } catch (IOException e) {
            Toast.makeText(mActivityContext, "Failed to open the image in assets.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return;
        }
        mRegionDecodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rect rect = new Rect(0, 0, 300, 300);
                try {
                    mTargetImage.setImageBitmap(BitmapRegionDecoder.newInstance(mActivityContext.getAssets().open("img/test_img1.jpg"), true).decodeRegion(rect, null));
                } catch (IOException e) {
                    Toast.makeText(mActivityContext, "Failed to open the image in assets.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
