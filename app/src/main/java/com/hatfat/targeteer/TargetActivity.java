package com.hatfat.targeteer;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hatfat.agl.app.AglActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TargetActivity extends AglActivity {

    @Bind(R.id.activity_target_start_button) Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.base_layout_content_view);
        View ourView = getLayoutInflater().inflate(R.layout.activity_target, container, false);
        container.addView(ourView);

        ButterKnife.bind(this);

        stop();
    }

    @OnClick(R.id.activity_target_start_button) void startPressed() {
        start();
    }

    @Override public void onBackPressed() {
        if (aglSurfaceView.getScene() instanceof TargetScene) {
            stop();
        }
        else {
            super.onBackPressed();
        }
    }

    private void start() {
        startButton.setVisibility(View.GONE);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        TargetScene targetScene = new TargetScene(getApplicationContext());
        targetScene.setDisplayMetrics(metrics);
        aglSurfaceView.setScene(targetScene);
    }

    private void stop() {
        startButton.setVisibility(View.VISIBLE);

        MenuScene menuScene = new MenuScene(getApplicationContext());
        aglSurfaceView.setScene(menuScene);
    }
}
