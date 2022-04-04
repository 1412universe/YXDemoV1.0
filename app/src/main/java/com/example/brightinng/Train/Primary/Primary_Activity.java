package com.example.brightinng.Train.Primary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brightinng.R;
import com.example.brightinng.Tools.banner.MyAdapter1;
import com.example.brightinng.Tools.banner.ZoomOutPageTransformer;
import com.example.brightinng.Train.Train_Activity;

public class Primary_Activity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);

        //设置当前窗体为全屏显示
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        this.getSupportActionBar().hide();


        Button btn = findViewById(R.id.btn);
        btn.setText("解析");
        btn.setTypeface(Typeface.createFromAsset(getAssets(), "font/main_font.otf"));



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog();
            }
        });
        initView();
    }

    private ViewPager mViewPager;
    private LinearLayout ll_layout;

    //向导界面的图片
    private int[] mPics = new int[]{ R.drawable.primary1, R.drawable.primary2,R.drawable.primary3,R.drawable.primary4,R.drawable.primary5,R.drawable.primary6,R.drawable.primary7,R.drawable.primary8,R.drawable.primary9};


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_layout = (LinearLayout) findViewById(R.id.ll_layout);

        //设置适配器
        mViewPager.setAdapter(new MyAdapter1(this, mPics));
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

    /**
     * 自定义弹窗
     */
    public  void showMyDialog() {
        LayoutInflater mLayoutInflater = LayoutInflater.from(Primary_Activity.this);
        LinearLayout mDialog = (LinearLayout) mLayoutInflater.inflate(R.layout.dialog_layout, null);

        final Dialog dialog = new AlertDialog.Builder(Primary_Activity.this).create();
        dialog.show();
        dialog.getWindow().setContentView(mDialog);
        mDialog.findViewById(R.id.exitBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    public void setDialogSize(Dialog dg){
        Window dialogWindow = dg.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
//显示的坐标
        lp.x = 50;
        lp.y = 50;
        int width = 500;
        int height = 500;
//dialog的大小
        lp.width = width;
        lp.height = height;


        dialogWindow.setAttributes(lp);


    }
    public void onClickNext(View view) {
        if (view.getId() == R.id.ReturnBtn) {
            Intent intent_main = new Intent(this, Train_Activity.class);
            startActivity(intent_main);
            finish();
        }

    }
}
