package com.example.brightinng.RealityApply.character.fl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.brightinng.R;
import com.example.brightinng.RealityApply.RealityMain_Activity;

public class  Characterfl extends AppCompatActivity {

    private LinearLayout mylinearlayout;
    public int logo = 0;


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characterfl);


        //设置当前窗体为全屏显示
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        //去除顶部系统边框
        this.getSupportActionBar().hide();

        mylinearlayout = findViewById(R.id.fl);

        Button jianjie = findViewById(R.id.flbutton);
        Button fenxi = findViewById(R.id.flbutton2);
        Button tubiao = findViewById(R.id.flbutton3);
        Button daoru = findViewById(R.id.flbutton4);


        jianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo = 0;

                mylinearlayout.removeAllViews();

                ImageView jianjie = new ImageView(Characterfl.this);
                jianjie.setImageResource(R.drawable.train_fanlijieshao);


                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                        dip2px(Characterfl.this, 434),
                        dip2px(Characterfl.this, 204)
                );


                p.setMargins(dip2px(Characterfl.this, 10),
                        dip2px(Characterfl.this, 10),
                        dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 0));

                mylinearlayout.addView(jianjie, p);

            }
        });

        fenxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo = 0;


            }
        });

        tubiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mylinearlayout.removeAllViews();

                Button button1 = new Button(Characterfl.this);
                button1.setBackgroundResource(R.drawable.train_zuo);
                Button button2 = new Button(Characterfl.this);
                button2.setBackgroundResource(R.drawable.train_you);
                final ImageView tubiao = new ImageView(Characterfl.this);
                tubiao.setImageResource(R.drawable.train_zhongjuxing);   //设置照片
                LinearLayout ll = new LinearLayout(Characterfl.this);
                ll.setBackgroundResource(R.drawable.train_zhongjuxing);


                LinearLayout.LayoutParams b1 = new LinearLayout.LayoutParams(
                        dip2px(Characterfl.this, 50),
                        dip2px(Characterfl.this, 50)

                );


                LinearLayout.LayoutParams b2 = new LinearLayout.LayoutParams(
                        dip2px(Characterfl.this, 50),
                        dip2px(Characterfl.this, 50)

                );
                b1.setMargins(dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 70),
                        dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 0));

                b2.setMargins(dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 70),
                        dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 0));


                mylinearlayout.addView(button1, b1);


                LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(
                        dip2px(Characterfl.this, 350),
                        dip2px(Characterfl.this, 200)


                );


                l.setMargins(dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 10),
                        dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 0));

                LinearLayout.LayoutParams tubiaol = new LinearLayout.LayoutParams(
                        dip2px(Characterfl.this, 299),
                        dip2px(Characterfl.this, 160)


                );


                tubiaol.setMargins(dip2px(Characterfl.this, 25),
                        dip2px(Characterfl.this, 20),
                        dip2px(Characterfl.this, 0),
                        dip2px(Characterfl.this, 0));


                mylinearlayout.addView(ll, l);


                mylinearlayout.addView(button2, b2);
                ll.addView(tubiao, tubiaol);


                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        logo += 1;

                        if (logo % 6 == 0) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (logo % 6 == 1) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (logo % 6 == 2) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (logo % 6 == 3) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (logo % 6 == 4) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (logo % 6 == 5) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);

                        }
                    }
                });


                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        logo  = logo - 1;

                        if (Math.abs(logo % 6) == 0) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (Math.abs(logo % 6) == 1) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (Math.abs(logo % 6) == 2) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (Math.abs(logo % 6) == 3) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (Math.abs(logo % 6) == 4) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);
                        } else if (Math.abs(logo % 6) == 5) {
                            tubiao.setImageResource(R.drawable.train_zhongjuxing);

                        }
                    }
                });


            }
        });

        daoru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logo = 0;


            }
        });
    }
    public void onClickNext(View view) {
        if (view.getId() == R.id.imageButton) {
            Intent intent_main = new Intent(this, RealityMain_Activity.class);
            startActivity(intent_main);
            finish();
        }

    }
}