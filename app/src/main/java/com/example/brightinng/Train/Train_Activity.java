package com.example.brightinng.Train;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.brightinng.Main_Activity;
import com.example.brightinng.R;
import com.example.brightinng.Train.Model.Model_Activity;
import com.example.brightinng.Train.Peak.Peak_Activity;
import com.example.brightinng.Train.Primary.Primary_Activity;

public class Train_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        setContentView(R.layout.activity_train);
        //设置当前窗体为全屏显示
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        this.getSupportActionBar().hide();
    }

    public void onClickNext(View view) {
        if (view.getId() == R.id.PrimaryBtn) { //判断是否为UsrBtn的点击事件
            Intent intent = new Intent(Train_Activity.this, Primary_Activity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.ModelBtn) { //判断是否为ModelBtn的点击事件
            Intent intent = new Intent(Train_Activity.this, Model_Activity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.PeakBtn) { //判断是否为PeakBtn的点击事件
            Intent intent = new Intent(Train_Activity.this, Peak_Activity.class);
            startActivity(intent);
        } else if(view.getId() == R.id.train_exitBtn){
            Intent intent_main = new Intent(Train_Activity.this, Main_Activity.class);
            startActivity(intent_main);
        }
    }

}