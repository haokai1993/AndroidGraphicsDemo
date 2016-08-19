package com.zlsam.learngraphics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zlsam.learngraphics.patheffect.TestPathEffectActivity;

public class MainActivity extends Activity {

    private Button mTestPathEffectBtn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();
    }

    private void initViews() {
        // Instance
        mTestPathEffectBtn = (Button) findViewById(R.id.btn_test_path_effect);

        mTestPathEffectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestPathEffectActivity.class);
                startActivity(intent);
            }
        });
    }
}
