package com.zlsam.learngraphics.patheffect;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.zlsam.learngraphics.R;

/**
 * Created by zhanglong on 16/8/15.
 */
public class TestCornerPathEffectActivity extends Activity {

    private SeekBar mRadiusSeekBar;
    private CornerPathEffectView mCornerPathEffectView;

    // Dash path effect
    private SeekBar mSolidLengthSeekBar;
    private SeekBar mVirtualLengthSeekBar;
    private SeekBar mPahseSeekBar;
    private DashPathEffectView mDashPathEffectView;

    // Discrete path effect
    private SeekBar mSegmentLengthSeekBar;
    private SeekBar mDeviationSeekBar;
    private DiscretePathEffectView mDiscretePathEffectView;

    // Compose path effect
    private SeekBar mComposeRadiusSeekBar;
    private SeekBar mComposeSolidLengthSeekBar;
    private SeekBar mComposeVirtualLengthSeekBar;
    private SeekBar mComposePhaseSeekBar;
    private ComposePathEffectView mComposePathEffectView;

    // Sum path effect
    private SeekBar mSumRadiusSeekBar;
    private SeekBar mSumSolidLengthSeekBar;
    private SeekBar mSumVirtualLengthSeekBar;
    private SeekBar mSumPhaseSeekBar;
    private SumPathEffectView mSumPathEffectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_test_corner_path_effect);
        initViews();
    }

    private void initViews() {
        // Instances
        mRadiusSeekBar = (SeekBar) findViewById(R.id.seekbar_corner_path_effect);
        mCornerPathEffectView = (CornerPathEffectView) findViewById(R.id.corner_path_effect_view);
        mSolidLengthSeekBar = (SeekBar) findViewById(R.id.seekbar_dash_path_effect_solid_length);
        mVirtualLengthSeekBar = (SeekBar) findViewById(R.id.seekbar_dash_path_effect_virtual_length);
        mPahseSeekBar = (SeekBar) findViewById(R.id.seekbar_dash_path_effect_phase);
        mDashPathEffectView = (DashPathEffectView) findViewById(R.id.dash_path_effect_view);
        mSegmentLengthSeekBar = (SeekBar) findViewById(R.id.seekbar_discrete_path_effect_segment_length);
        mDeviationSeekBar = (SeekBar) findViewById(R.id.seekbar_discrete_path_effect_deviation);
        mDiscretePathEffectView = (DiscretePathEffectView) findViewById(R.id.discrete_path_effect_view);
        mComposeRadiusSeekBar = (SeekBar) findViewById(R.id.seekbar_compose_path_effect_radius);
        mComposeSolidLengthSeekBar = (SeekBar) findViewById(R.id.seekbar_compose_path_effect_solid_length);
        mComposeVirtualLengthSeekBar = (SeekBar) findViewById(R.id.seekbar_compose_path_effect_virtual_length);
        mComposePhaseSeekBar = (SeekBar) findViewById(R.id.seekbar_compose_path_effect_phase);
        mComposePathEffectView = (ComposePathEffectView) findViewById(R.id.compose_path_effect_view);
        mSumRadiusSeekBar = (SeekBar) findViewById(R.id.seekbar_sum_path_effect_radius);
        mSumSolidLengthSeekBar = (SeekBar) findViewById(R.id.seekbar_sum_path_effect_solid_length);
        mSumVirtualLengthSeekBar = (SeekBar) findViewById(R.id.seekbar_sum_path_effect_virtual_length);
        mSumPhaseSeekBar = (SeekBar) findViewById(R.id.seekbar_sum_path_effect_phase);
        mSumPathEffectView = (SumPathEffectView) findViewById(R.id.sum_path_effect_view);

        mRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCornerPathEffectView.setCornerRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "radius: " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        // Init dash path effect
        mSolidLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDashPathEffectView.setSolidLength(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        mVirtualLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDashPathEffectView.setVirtualLength(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        mPahseSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDashPathEffectView.setPhase(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        // Discrete path effect
        mSegmentLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDiscretePathEffectView.setSegmentLength(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        mDeviationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDiscretePathEffectView.setDeviation(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        // Compose path effect
        mComposeRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mComposePathEffectView.setCornerRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        mComposeSolidLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mComposePathEffectView.setSolidLength(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        mComposeVirtualLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mComposePathEffectView.setVirtualLength(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        mComposePhaseSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mComposePathEffectView.setPhase(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        // Sum path effect
        mSumRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSumPathEffectView.setCornerRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        mSumSolidLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSumPathEffectView.setSolidLength(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        mSumVirtualLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSumPathEffectView.setVirtualLength(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress() + 1, Toast.LENGTH_SHORT).show();
            }
        });

        mSumPhaseSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSumPathEffectView.setPhase(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(TestCornerPathEffectActivity.this, "" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

    }



 }
