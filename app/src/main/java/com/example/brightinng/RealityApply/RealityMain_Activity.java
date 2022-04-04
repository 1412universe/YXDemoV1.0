package com.example.brightinng.RealityApply;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.brightinng.Main_Activity;
import com.example.brightinng.R;
import com.example.brightinng.Tools.banner.MyAdapter;
import com.example.brightinng.Tools.banner.MyAdapter_Reality;
import com.example.brightinng.Tools.banner.ZoomOutPageTransformer;

import java.util.Objects;

public class RealityMain_Activity extends AppCompatActivity {
    private ViewPager mViewPager;

    //向导界面的图片
    private final int[] mPics = new int[]{R.drawable.fl, R.drawable.zjw, R.drawable.by, R.drawable.lx, R.drawable.sn, R.drawable.hui, R.drawable.zf, R.drawable.xz, R.drawable.jwz, R.drawable.fx, R.drawable.yy, R.drawable.lsq, R.drawable.jian, R.drawable.gui};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reality_main);
        //设置当前窗体为全屏显示
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        initView();

    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        LinearLayout ll_layout = (LinearLayout) findViewById(R.id.ll_layout);

        //设置适配器
        mViewPager.setAdapter(new MyAdapter_Reality(this, mPics));
        mViewPager.setPageMargin(20);
        mViewPager.setOffscreenPageLimit(mPics.length);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());//设置画廊模式

        //左右都有图
        mViewPager.setCurrentItem(1);

        //viewPager左右两边滑动无效的处理
        ll_layout.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });

    }

    public void onClickNext(View view) {
        int i = MyAdapter.signal;
        if(view.getId()==R.id.exitBtn){
            Intent intent_main = new Intent(this, Main_Activity.class);
            startActivity(intent_main);
            finish();
        }

    }
}

