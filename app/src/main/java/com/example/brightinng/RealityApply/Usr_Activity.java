package com.example.brightinng.RealityApply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.brightinng.Main_Activity;
import com.example.brightinng.R;
import com.example.brightinng.Tools.banner.MyAdapter;
import com.example.brightinng.Tools.banner.ZoomOutPageTransformer;

public class Usr_Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout ll_layout;

    //向导界面的图片
    private int[] mPics = new int[]{R.drawable.usr1, R.drawable.usr2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usr);

        //设置当前窗体为全屏显示
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        this.getSupportActionBar().hide();

        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_layout = (LinearLayout) findViewById(R.id.ll_layout);

        //设置适配器
        mViewPager.setAdapter(new MyAdapter(this, mPics));
        mViewPager.setPageMargin(20);
        mViewPager.setOffscreenPageLimit(mPics.length);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());//设置画廊模式

        //左右都有图
        mViewPager.setCurrentItem(1);

        //viewPager左右两边滑动无效的处理
        ll_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });

    }
    public void onClickNext(View view) {
        if (view.getId() == R.id.usr_exitBtn) {
            Intent intent_main = new Intent(this, Main_Activity.class);
            startActivity(intent_main);
            finish();
        }

    }
}