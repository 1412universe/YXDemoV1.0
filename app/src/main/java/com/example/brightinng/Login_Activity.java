package com.example.brightinng;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brightinng.Navigation.Navigation_1;
import com.example.brightinng.Tools.SQL.connect;
import java.sql.SQLException;
import java.util.Objects;

public class Login_Activity extends AppCompatActivity {
    private String password_receive;
    public static int conn_on=0;//用于判断连接是否成功

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        Button LoginBtn = findViewById(R.id.LoginBtn);
        LoginBtn.setText("登录");
        LoginBtn.setTypeface(Typeface.createFromAsset(getAssets(), "font/main_font.otf"));

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                switch (conn_on)//根据返回值判断网络连接是否成功
                {
                    case 1: Toast.makeText(Login_Activity.this,"网络连接成功",Toast.LENGTH_SHORT).show(); break;
                    case 2:Toast.makeText(Login_Activity.this,"网络连接失败",Toast.LENGTH_SHORT).show(); break;
                }
                return false;
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                try {
                    connect.getConnection("yxzh");//执行连接测试
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(msg);//跳转到handler1
            }
        }).start();


        LoginBtn.setOnClickListener(view -> {

            EditText mEtLoginactivityUsername = findViewById(R.id.Usr_Text);
            EditText mEtLoginactivityPassword = findViewById(R.id.PassWord_Text);
            String username = mEtLoginactivityUsername.getText().toString().trim();
            String password = mEtLoginactivityPassword.getText().toString().trim();


                    if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {

                        new Thread(() -> {
                            try {
                                password_receive = connect.querycol(username.trim());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }).start();


                        Handler handler1;
                        handler1 = new Handler();
                        handler1.postDelayed(() -> {
                            if (password.equals(password_receive)) {

                                Toast.makeText(Login_Activity.this, "登陆成功", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(Login_Activity.this, Navigation_1.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login_Activity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                            }
                        }, 300);

                    } else {

                        Toast.makeText(Login_Activity.this, "昵称和密码不能为空", Toast.LENGTH_SHORT).show();

                    }

        });

        Button RegisterBtn = findViewById(R.id.RegisterBtn);
        RegisterBtn.setText("注册");
        RegisterBtn.setTypeface(Typeface.createFromAsset(getAssets(),"font/main_font.otf"));

    }

    public void onClickNext(View view) {

            //跳转到注册界面
            Intent intent1 = new Intent(this, Register_Activity.class);
            startActivity(intent1);
            finish();


    }
}