package com.zlsam.learngraphics.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.zlsam.learngraphics.R;
import java.util.Date;

/**
 * Created by zhanglong on 16/4/25.
 */
public class TestBitmapApiPerformanceActivity extends Activity {
    private static final String TAG = "TestBitmapPerformances";
    private Bitmap mSourceBitmap;
    private ImageView mCopiedImage;
    private ImageView mSourceImage;
    private Button mCopyWithSetPixelBtn;
    private Button mCopyWithSetPixelsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_bitmap_api_performance);
        mCopiedImage = (ImageView) findViewById(R.id.img_target_bitmap);
        mSourceImage = (ImageView) findViewById(R.id.img_source_bitmap);
        mSourceBitmap = ((BitmapDrawable) mSourceImage.getDrawable()).getBitmap();
        mCopyWithSetPixelBtn = (Button) findViewById(R.id.btn_copy_with_setPixel);
        mCopyWithSetPixelBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                copyWithSetPixelAndShow(mSourceBitmap);
            }

        });

        mCopyWithSetPixelsBtn = (Button) findViewById(R.id.btn_copy_with_setPixels);
        mCopyWithSetPixelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyWithSetPixelsAndShow(mSourceBitmap);
            }
        });
    }

    private void copyWithSetPixelAndShow(final Bitmap sourceBitmap) {
        new AsyncTask<Bitmap, Integer, Bitmap>() {
            private long mStartTime = 0;

            @Override
            protected Bitmap doInBackground(Bitmap... bitmaps) {
                Bitmap targetBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
                mStartTime = new Date().getTime();
                for (int y = 0; y < 500; y++) {
                    for (int x = 0; x < 500; x++) {
                        targetBitmap.setPixel(x, y, bitmaps[0].getPixel(x, y));
                    }
                }
                return targetBitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                long time = new Date().getTime() - mStartTime;
                Log.d(TAG, "copyWithSetPixel: " + time + "ms.");
                Toast.makeText(TestBitmapApiPerformanceActivity.this, time + "ms.", Toast.LENGTH_SHORT).show();
                super.onPostExecute(bitmap);
                mCopiedImage.setImageBitmap(bitmap);
            }
        }.execute(sourceBitmap);
    }

    private void copyWithSetPixelsAndShow(final Bitmap sourceBitmap) {
        new AsyncTask<Bitmap, Integer, Bitmap>() {
            private long mStartTime = 0;

            @Override
            protected Bitmap doInBackground(Bitmap... bitmaps) {
                Bitmap targetBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
                mStartTime = new Date().getTime();
                int[] pixels = new int[500 * 500];
                bitmaps[0].getPixels(pixels, 0, 500, 0, 0, 500, 500);
                targetBitmap.setPixels(pixels, 0, 500, 0, 0, 500, 500);
                return targetBitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                long time = new Date().getTime() - mStartTime;
                Log.d(TAG, "copyWithSetPixels: " + time + "ms.");
                Toast.makeText(TestBitmapApiPerformanceActivity.this, time + "ms.", Toast.LENGTH_SHORT).show();
                super.onPostExecute(bitmap);
                mCopiedImage.setImageBitmap(bitmap);
            }
        }.execute(sourceBitmap);
    }

    private void copyWithBufferAndShow(final Bitmap sourceBitmap) {
        new AsyncTask<Bitmap, Integer, Bitmap>() {
            private long mStartTime = 0;

            @Override
            protected Bitmap doInBackground(Bitmap... bitmaps) {
                Bitmap targetBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
                mStartTime = new Date().getTime();
                int[] pixels = new int[500 * 500];
                bitmaps[0].getPixels(pixels, 0, 500, 0, 0, 500, 500);
                targetBitmap.setPixels(pixels, 0, 500, 0, 0, 500, 500);
                return targetBitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                long time = new Date().getTime() - mStartTime;
                Log.d(TAG, "copyWithSetPixels: " + time + "ms.");
                Toast.makeText(TestBitmapApiPerformanceActivity.this, time + "ms.", Toast.LENGTH_SHORT).show();
                super.onPostExecute(bitmap);
                mCopiedImage.setImageBitmap(bitmap);
            }
        }.execute(sourceBitmap);
    }
}
