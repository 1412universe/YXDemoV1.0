package com.example.brightinng.Navigation;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.brightinng.Main_Activity;
import com.example.brightinng.R;
import com.example.brightinng.RealityApply.Usr_Activity;
import com.example.brightinng.Tools.Navigation.DepthPageTransformer;
import com.example.brightinng.Tools.Navigation.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * https://stackoverflow.com/questions/56114430/android-viewpager2-setpagemargin-unresolved
 */
public class Navigation_2 extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter mVpAdapter;
    private TextView mtextview;
    private TextToSpeech tts;
    private int signal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //去掉系统状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mViewPager = this.findViewById(R.id.viewpager);


        List<Integer> imageIds = new ArrayList<Integer>();
        imageIds.add(R.drawable.navigation_1);
        imageIds.add(R.drawable.navigation_2);
        imageIds.add(R.drawable.navigation_3);


        mVpAdapter = new ViewPagerAdapter(this, imageIds);
        mViewPager.setOffscreenPageLimit(3);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 把当前显示的position传递出去


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setAdapter(mVpAdapter);
        //  这个值主要负责两边控件与中间控件的距离

        mViewPager.setPageMargin(-320);
        mViewPager.setPageTransformer(false, new DepthPageTransformer());

        Button button1 = findViewById(R.id.RobotBtn);

        Button button = findViewById(R.id.MainButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (signal==0){
                        signal=1;
                        button1.setBackgroundResource(R.drawable.robot2);
                        button.setBackgroundColor(Color.parseColor("#00000000"));
                        tts=new TextToSpeech(Navigation_2.this, new TextToSpeech.OnInitListener() {//实例化自带语音对象
                            @Override
                            public void onInit(int i) {
                                if(i==TextToSpeech.SUCCESS){//设置语音
                                    tts.setPitch(1.1f);
                                    //tts.setLanguage(Locale.CHINESE);//中文
                                    tts.speak("你好啊，我是云曦，欢迎来到云曦Smarter,让我来帮你使用我们的软件吧!   " +
                                            "首先，如图所示，您当前位于入门导航界面，在这里，我们将带您了解并使用我们的软件   " +
                                            "待导航结束后，您将进入我们的主界面，即核心模块界面，   在这里，您可根据实际情况进行选择和使用其中的核心功能   " +
                                            "那么，接下来，请右滑，让我为您进行进一步的讲解吧!          " +
                                            "当前，您看到的是我们App的使用流程，我们包括实战、训练和商城三个模块。   " +
                                            "其中，在实战界面您可根据需要，选择相关的人物，他们将指引您将大数据、人工智能等技术直接应用到您的生活，为您的生活带来新的质跃  " +
                                            "当然，如果您想要对其中的知识进行深刻的了解和使用，请进入我们的训练界面，在这里，您将系统的学习到相关的知识，同时，我们提供模型训练平台，让您在学习的同时，进行实践  " +
                                            "接下来，是我们的商城，您可在此购买相关的模型道具，以及您可将您在模型训练平台中制作的模型上架到此处，我们将为您销售，给您带来一笔价值不菲的额外收入   " +
                                            "最后，请右滑，让我来为您进行最后一步的讲解吧！  " +
                                            "您现在所看到的是我们的训练界面，您可在其中进行知识与实践的探索！  您的导航到此结束，请点击下方按钮开始使用吧！",TextToSpeech.QUEUE_FLUSH,null);//播报“今天温度36.3℃”
                                }
                                button.setText("开始体验");
                            }
                        });
                }else if(signal==1){
                    Intent intent = new Intent(Navigation_2.this, Main_Activity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }

}