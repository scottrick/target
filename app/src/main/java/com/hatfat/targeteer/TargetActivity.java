package com.hatfat.targeteer;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hatfat.agl.app.AglActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TargetActivity extends AglActivity implements View.OnTouchListener {

    @Bind(R.id.activity_target_start_button) Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        aglSurfaceView.setOnTouchListener(this);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.base_layout_content_view);
        View ourView = getLayoutInflater().inflate(R.layout.activity_target, container, false);
        container.addView(ourView);

        ButterKnife.bind(this);

        stop();
    }

    @OnClick(R.id.activity_target_start_button) void startPressed() {
        start();
    }

    private void start() {
        startButton.setVisibility(View.GONE);

        TargetScene targetScene = new TargetScene(getApplicationContext());
        aglSurfaceView.setScene(targetScene);
    }

    private void stop() {
        startButton.setVisibility(View.VISIBLE);

        MenuScene menuScene = new MenuScene(getApplicationContext());
        aglSurfaceView.setScene(menuScene);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
