package com.example.brightinng.Train.Model;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.brightinng.R;
import com.example.brightinng.Train.Peak.Peak_Activity;

public class Model_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        //设置当前窗体为全屏显示
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        this.getSupportActionBar().hide();
    }

    public void onClickNext(View view){
        if(view.getId()==R.id.button6){
            Button button6 = findViewById(R.id.button2);
            button6.setBackgroundResource(R.drawable.logo);
        }
        if (view.getId()==R.id.button8){
            Button button8 = findViewById(R.id.button3);
            button8.setBackgroundResource(R.drawable.logo);
        }
        if(view.getId()==R.id.evaluate){
            AlertDialog.Builder builder =new AlertDialog.Builder(Model_Activity.this);
            builder.setMessage("您的模型评估分数为：99分");
            builder.setPositiveButton("退出",null).show();
        }
    }
}