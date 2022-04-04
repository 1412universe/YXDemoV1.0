package com.example.brightinng.Train.Peak;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.brightinng.R;

public class Peak_Activity extends AppCompatActivity {
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peak);
        Button button =(Button) findViewById(R.id.SubmitBtn);
        rg =(RadioGroup) findViewById(R.id.rg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i= 0;i<rg.getChildCount();i++){
                    RadioButton radioButton= (RadioButton) rg.getChildAt(i);
                    if(radioButton.isChecked()){
                        if(radioButton.getText().equals("A:Marniv Lee Minsky")){
                            Toast.makeText(Peak_Activity.this,"回答正确，请点击下一关", Toast.LENGTH_SHORT).show();
                        }else{
                            AlertDialog.Builder builder =new AlertDialog.Builder(Peak_Activity.this);
                            builder.setMessage("回答错误，请重新作答");
                            builder.setPositiveButton("确定",null).show();
                        }
                        break;
                    }
                }

            }
        });
        //设置当前窗体为全屏显示
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        this.getSupportActionBar().hide();

        Button AnalysisBtn = findViewById(R.id.SubmitBtn);
        AnalysisBtn.setText("评测");
        AnalysisBtn.setTypeface(Typeface.createFromAsset(getAssets(), "font/main_font.otf"));

        Button NextBtn = findViewById(R.id.NextBtn);
        NextBtn.setText("下一关");
        NextBtn.setTypeface(Typeface.createFromAsset(getAssets(), "font/main_font.otf"));

        Button LastBtn = findViewById(R.id.LastBtn);
        LastBtn.setText("上一关");
        LastBtn.setTypeface(Typeface.createFromAsset(getAssets(), "font/main_font.otf"));
    }

}