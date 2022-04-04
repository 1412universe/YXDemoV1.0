package com.example.brightinng;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import  com.example.brightinng.Tools.SQL.connect;

import com.example.brightinng.Tools.SQL.DBOpenHelper;

import java.sql.SQLException;
import java.util.Objects;

/**
 * 此类 implements View.OnClickListener 之后，
 * 就可以把onClick事件写到onCreate()方法之外
 * 这样，onCreate()方法中的代码就不会显得很冗余
 */
public class Register_Activity extends AppCompatActivity implements OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        @SuppressLint("CutPasteId") Button mBtRegisteractivityRegister = findViewById(R.id.bt_registeractivity_register);
        mBtRegisteractivityRegister.setTextColor(Color.parseColor("#e9ecef"));

        @SuppressLint("CutPasteId") Button RegisterBtn = findViewById(R.id.bt_registeractivity_register);
        RegisterBtn.setText("注册");
        RegisterBtn.setTypeface(Typeface.createFromAsset(getAssets(), "font/main_font.otf"));

        new DBOpenHelper(this);

        CheckBox  AgreeBtn = findViewById(R.id.cb_agree);
        AgreeBtn.setText("我同意以上协议");
        AgreeBtn.setTextSize(12);
        AgreeBtn.setTextColor(Color.parseColor("#36b4c9"));


    }

    public void onClickNext(View view) {
        //注册按钮
        //获取用户输入的用户名、密码、验证码
        EditText mEtRegisteractivityUsername = this.findViewById(R.id.et_registeractivity_username);
        EditText mEtRegisteractivityPassword1 = this.findViewById(R.id.et_registeractivity_password1);
        EditText mEtRegisteractivityPassword2 = this.findViewById(R.id.et_registeractivity_password2);

        String username = mEtRegisteractivityUsername.getText().toString().trim();
        String password2 = mEtRegisteractivityPassword2.getText().toString().trim();
        String password1 = mEtRegisteractivityPassword1.getText().toString().trim();

        CheckBox  AgreeBtn = findViewById(R.id.cb_agree);
        if (AgreeBtn.isChecked()) {

            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2)) {
                if (password1.equals(password2)) {
                    //将用户名和密码加入到数据库中
                    new Thread(() -> {
                        try {
                            connect.insertIntoData(username, password1);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }).start();
                    Toast.makeText(this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                    //跳转到登陆界面
                    Intent intent1 = new Intent(this, Login_Activity.class);
                    startActivity(intent1);
                    finish();

                } else {
                    Toast.makeText(this, "两次密码不一致,注册失败", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
            }
        } else {

            Toast.makeText(this, "请勾选用户协议", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
    }
}