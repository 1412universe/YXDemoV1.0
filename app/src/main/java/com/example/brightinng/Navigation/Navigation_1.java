package com.example.brightinng.Navigation;


import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brightinng.R;
import com.example.brightinng.Tools.Navigation.Msg;
import com.example.brightinng.Tools.Navigation.MsgAdapter;
import com.example.brightinng.Tools.Navigation.NbButton;

import java.util.ArrayList;
import java.util.List;


public class Navigation_1 extends AppCompatActivity {

    private List<Msg> mMsgList = new ArrayList<>();
    private EditText inputText;
    private NbButton send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter mMsgAdapter;
    public int number = 0;
    private RelativeLayout rlContent;
    private Handler handler, handler1;
    private Animator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation1);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //去掉系统状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //依据id配置相应控件

        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        rlContent = findViewById(R.id.rl_content);


        LinearLayoutManager layoutManager = new LinearLayoutManager(Navigation_1.this);
        msgRecyclerView.setLayoutManager(layoutManager);
        mMsgAdapter = new MsgAdapter(mMsgList);
        msgRecyclerView.setAdapter(mMsgAdapter);

        Msg msg1 = new Msg("您好，欢迎来到云曦Smarter，我是您的语音助手——云曦 ", Msg.TYPE_RECEIVED);
        mMsgList.add(msg1);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Msg msg4 = new Msg("您是否感到与时代脱节? 是否想拥有更高质量的生活? 让我来帮助您实现它吧！", Msg.TYPE_RECEIVED);
                mMsgList.add(msg4);

            }
        }, 200);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number += 1;

                if (number == 1) {

                    Msg msg = new Msg(" 好的", 1);
                    mMsgList.add(msg);
                    //当有新消息时，通知列表有新数据加入，刷新RecyclerView中的显示
                    mMsgAdapter.notifyItemInserted(mMsgList.size() - 1);
                    //将显示的数据定位到最后一行，保证一定能看到最后发出的一行数据
                    msgRecyclerView.scrollToPosition(mMsgList.size() - 1);


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Msg msg3 = new Msg("云曦Smarter，是一款智能化大数据分析平台 ", 0);
                            mMsgList.add(msg3);

                            //当有新消息时，通知列表有新数据加入，刷新RecyclerView中的显示
                            mMsgAdapter.notifyItemInserted(mMsgList.size() - 1);
                            //将显示的数据定位到最后一行，保证一定能看到最后发出的一行数据
                            msgRecyclerView.scrollToPosition(mMsgList.size() - 1);

                            //要延时的程序
                        }
                    }, 800); //800为毫秒单位


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Msg msg5 = new Msg("在这里您可以轻松地将大数据和人工智能等前沿技术应用到您的生活中，改善并提高您的生活质量 ", 0);
                            mMsgList.add(msg5);

                            //当有新消息时，通知列表有新数据加入，刷新RecyclerView中的显示
                            mMsgAdapter.notifyItemInserted(mMsgList.size() - 1);
                            //将显示的数据定位到最后一行，保证一定能看到最后发出的一行数据
                            msgRecyclerView.scrollToPosition(mMsgList.size() - 1);

                        }
                    }, 1000);


                } else if (number == 2) {


                    Msg msg2 = new Msg("开始体验", 1);
                    mMsgList.add(msg2);

                    //当有新消息时，通知列表有新数据加入，刷新RecyclerView中的显示
                    mMsgAdapter.notifyItemInserted(mMsgList.size() - 1);
                    //将显示的数据定位到最后一行，保证一定能看到最后发出的一行数据
                    msgRecyclerView.scrollToPosition(mMsgList.size() - 1);


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                            Msg msg4 = new Msg("This is Tom", Msg.TYPE_RECEIVED);
//                            mMsgList.add(msg4);
//                            //当有新消息时，通知列表有新数据加入，刷新RecyclerView中的显示
//                            mMsgAdapter.notifyItemInserted(mMsgList.size() - 1);
//                            //将显示的数据定位到最后一行，保证一定能看到最后发出的一行数据
//                            msgRecyclerView.scrollToPosition(mMsgList.size() - 1);
                            send.setText("让我们开始吧");

                            //要延时的程序
                        }
                    }, 700); //800为毫秒单位


                } else if (number == 3) {

                    handler1 = new Handler();
                    send.startAnim();

                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //跳转
                            gotoNew();
                        }
                    }, 750);

                }

            }
        });
    }


    //创建消息数据
    private void initMsgs() {
        Msg msg1 = new Msg("Hello Guys", Msg.TYPE_RECEIVED);
        mMsgList.add(msg1);
        Msg msg2 = new Msg("Who is that", Msg.TYPE_SENT);
        mMsgList.add(msg2);
        Msg msg3 = new Msg("This is Tom", Msg.TYPE_RECEIVED);
        mMsgList.add(msg3);
    }

    private void gotoNew() {

        send.gotoNew();

        final Intent intent = new Intent(this, Navigation_2.class);

        int xc = (send.getLeft() + send.getRight()) / 2;
        int yc = (send.getTop() + send.getBottom()) / 2;
        animator = ViewAnimationUtils.createCircularReveal(rlContent, xc, yc, 0, 1111);
        animator.setDuration(300);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);

                    }
                }, 200);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
        rlContent.getBackground().setAlpha(255);
    }

    @Override
    protected void onStop() {
        super.onStop();
        animator.cancel();
        send.regainBackground();
    }

}

