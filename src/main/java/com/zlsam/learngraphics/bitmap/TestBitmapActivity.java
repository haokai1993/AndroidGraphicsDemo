package com.zlsam.learngraphics.bitmap;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import android.widget.ImageView;
import android.graphics.Bitmap;
import com.zlsam.learngraphics.R;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;

public class TestBitmapActivity extends Activity {

    private Bitmap mSourceBitmap;
    private ImageView mCroppedImage;
    private ImageView mSourceImage;
    private Button mCropingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_bitmap);
        mCroppedImage = (ImageView) findViewById(R.id.img_target_bitmap);
        mSourceImage = (ImageView) findViewById(R.id.img_source_bitmap);
        mSourceBitmap = ((BitmapDrawable) mSourceImage.getDrawable()).getBitmap();
        mCropingBtn = (Button) findViewById(R.id.btn_crop);
        mCropingBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                int startX = mSourceBitmap.getWidth() / 2 - 199;
                int startY = mSourceBitmap.getHeight() / 2 - 199;
                cropAndShow(startX, startY, 200, 200, mSourceBitmap);
            }

        });
    }

    private void cropAndShow(final int startX, final int startY, final int width, final int height, final Bitmap sourceBitmap) {
        new AsyncTask<Bitmap, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Bitmap... bitmaps) {
                Bitmap sourceBitmap = bitmaps[0];
                Bitmap targetBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                int[] lineColors = new int[width * height];
                sourceBitmap.getPixels(lineColors, 0, width, startX, startY, width, height);
                targetBitmap.setPixels(lineColors, 0, width, 0, 0, width, height);
                return targetBitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                mCroppedImage.setImageBitmap(bitmap);
            }
        }.execute(mSourceBitmap);
    }
}