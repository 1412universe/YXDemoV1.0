package com.example.brightinng;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class SplashScreen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        setContentView(R.layout.activity_splash_screen_);
        VideoView videoView=findViewById(R.id.video_view);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 横屏


        String uri = "android.resource://" + getPackageName() + "/" + R.raw.start;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();

        Handler handler;
        handler = new Handler();
        handler.postDelayed(() -> {
            //从闪屏界面跳转到首界面
            Intent intent = new Intent(SplashScreen_Activity.this, Login_Activity.class);
            startActivity(intent);
            finish();
        }, 9800);//延迟9.8S后发送handler信息

    }
}
