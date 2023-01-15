package com.dtmchu.instargramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onResume() {
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        AnimationDrawable anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }
    @Override
    protected void onPause() {
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        AnimationDrawable anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
}