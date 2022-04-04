package com.example.brightinng;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.brightinng.Friend.Friend_Activity;
import com.example.brightinng.RealityApply.RealityMain_Activity;
import com.example.brightinng.RealityApply.Usr_Activity;
import com.example.brightinng.Tools.banner.MyAdapter;
import com.example.brightinng.Tools.banner.ZoomOutPageTransformer;
import com.example.brightinng.Train.Train_Activity;

import java.util.Objects;


public class Main_Activity extends AppCompatActivity {

    private ViewPager mViewPager;

    private final int[] mPics = new int[]{ R.drawable.applybtn, R.drawable.trainbtn,R.drawable.storebtn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        //设置当前窗体为全屏显示
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        initView();



    }


    //按钮点击事件
    public void onClickNext(View view) {
        if(view.getId()==R.id.UsrBtn){ //判断是否为UsrBtn的点击事件
            Intent intent = new Intent(Main_Activity.this, Usr_Activity.class);
            startActivity(intent);
            finish();
        }else if(view.getId()==R.id.FriendBtn){ //判断是否为StoreBtn的点击事件
            Intent intent = new Intent(Main_Activity.this, Friend_Activity.class);
            startActivity(intent);
            finish();
        }
    }



    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        mViewPager = findViewById(R.id.viewPager);
        LinearLayout ll_layout = findViewById(R.id.ll_layout);

        //设置适配器
        mViewPager.setAdapter(new MyAdapter(this, mPics));
        mViewPager.setPageMargin(20);
        mViewPager.setOffscreenPageLimit(mPics.length);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());//设置画廊模式

        //左右都有图
        mViewPager.setCurrentItem(1);

        //viewPager左右两边滑动无效的处理
        ll_layout.setOnTouchListener((view, motionEvent) -> mViewPager.dispatchTouchEvent(motionEvent));

    }

}
