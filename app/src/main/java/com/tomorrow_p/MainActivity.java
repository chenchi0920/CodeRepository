package com.tomorrow_p;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tomorrow_p.common.encrypt.EncryptTestActivity;
import com.tomorrow_p.draw.DrawOutlineActivity;
import com.tomorrow_p.setupwizard.DefaultActivity;
import com.tomorrow_p.view.FlowButton;
import com.tomorrow_p.view.FlowLayout;

public class MainActivity extends AppCompatActivity {

    private FlowLayout mFlowLayout;
    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);
        mFlowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        mFlowLayout.addView(new FlowButton(this, "EncryptTestActivity", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, EncryptTestActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "开机向导", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, DefaultActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "手势", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, com.tomorrow_p.gesture.MainActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Draw Face", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, DrawOutlineActivity.class));
            }
        }));


        ImmersiveMode();
    }

    private void ImmersiveMode() {
//        transparentStatusBar();
        transparentNavigationBar();
//        hideStatusAndNavigationBar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void hideStatusAndNavigationBar() {
        View decorView = getWindow().getDecorView();    //获取当前界面的DecorView
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;  // 设置全屏(隐藏导航栏)
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;  // 设置全屏(隐藏状态栏)
        decorView.setSystemUiVisibility(option);
    }

    private void transparentStatusBar() {   // 设置全屏(透明状态栏)
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void transparentNavigationBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {    // 沉浸式模式
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }
}
