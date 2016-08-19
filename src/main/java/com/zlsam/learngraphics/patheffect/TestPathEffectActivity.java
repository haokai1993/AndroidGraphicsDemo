package com.zlsam.learngraphics.patheffect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.zlsam.learngraphics.R;

/**
 * Created by zhanglong on 16/8/15.
 */
public class TestPathEffectActivity extends Activity {

    private Button mTestCornerPathEffectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_test_path_effect);
        initViews();
    }

    private void initViews() {
        // Instances
        mTestCornerPathEffectBtn = (Button) findViewById(R.id.btn_test_corner_path_effect);

        // Corner path effect
        mTestCornerPathEffectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestPathEffectActivity.this, TestCornerPathEffectActivity.class);
                startActivity(intent);
            }
        });
    }
}
