package com.example.brightinng.Tools.banner;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import com.example.brightinng.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class MyAdapter1 extends PagerAdapter{

    private int[] mData;
    private Context mContext;
    public  static int signal = 0;


    public static Activity getActivity() {
        Class activityThreadClass = null;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
            Object activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
            Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
            activitiesField.setAccessible(true);
            Map activities = (Map) activitiesField.get(activityThread);
            for (Object activityRecord : activities.values()) {
                Class activityRecordClass = activityRecord.getClass();
                Field pausedField = activityRecordClass.getDeclaredField("paused");
                pausedField.setAccessible(true);
                if (!pausedField.getBoolean(activityRecord)) {
                    Field activityField = activityRecordClass.getDeclaredField("activity");
                    activityField.setAccessible(true);
                    Activity activity = (Activity) activityField.get(activityRecord);
                    return activity;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MyAdapter1(Context ctx, int[] data) {
        this.mContext = ctx;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.length;// 返回数据的个数
    }


    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {//子View显示
        View view = View.inflate(container.getContext(), R.layout.item, null);
        ImageView imageView = view.findViewById(R.id.iv_icon);
        imageView.setImageResource(mData[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signal = position;
                Toast.makeText(mContext," "+signal,Toast.LENGTH_SHORT).show();
                if(position == 0){
                    // TODO Auto-generated method stub
                    new AlertDialog.Builder(getActivity()).setTitle("入门一")//设置对话框标题
                            .setMessage("机器学习是关于构建可以从数据中学习的系统，学习意味着在一定的性能指标下，在某些任务上会变得越来越好")//设置显示的内容
                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮
                                @Override
                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                                    // TODO Auto-generated method stub
                                }
                            }).show();//在按键响应事件中显示此对话
                }else if (position ==  1){
                    new AlertDialog.Builder(getActivity()).setTitle("入门二")//设置对话框标题

                            .setMessage("回归和分类")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话

                }else if (position == 2){
                    new AlertDialog.Builder(getActivity()).setTitle("入门三")//设置对话框标题

                            .setMessage("如果我们想要机器人在各种位置的地形中学习行走，则强化学习可能会表现最好，因为这通常是强化学习要解决的典型问题，也可以将强化学习问题表示为有监督学习或半监督学习问题但这种情况下不是很自然的数据想法")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话

                }else if (position == 3){
                    new AlertDialog.Builder(getActivity()).setTitle("入门四")//设置对话框标题

                            .setMessage("如果你不知道如何定义组，则可以使用聚类算法（无监督学习）将客户划分为相似客户集群，但是如果你知道你想要拥有哪些组，那么可以将每个组的许多实例提供给分类算法（有监督学习）并将所有客户分类到这些组中")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话

                }else if (position == 4){
                    new AlertDialog.Builder(getActivity()).setTitle("入门五")//设置对话框标题

                            .setMessage("与批量学习系统相反，在线学习系统能够进行增量学习，这使得他能够快速适应不断变化的数据和自动系统，并能够处理大量数据")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话

                }else if (position == 5){
                    new AlertDialog.Builder(getActivity()).setTitle("入门六")//设置对话框标题

                            .setMessage("核外算法可以处理，无法容纳在计算机内存中的大量数据，核外学习算法将数据分成小批量，并使用在线学习技术从这些小批量数据中学习")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话


                }else if (position == 6){
                    new AlertDialog.Builder(getActivity()).setTitle("入门七")//设置对话框标题

                            .setMessage("基于实例的学习系统，努力通过死记硬背来学习训练数据，然后当给定一个新的实例时，它将使用相似性度量来查找最相似的实例，并利用它们来进行预测")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话




                }else if (position == 7){
                    new AlertDialog.Builder(getActivity()).setTitle("入门八")//设置对话框标题

                            .setMessage("机器学习中的一些主要挑战是数据的缺乏，数据质量差，数据的代表性不足，信息量不足，模型过于简单，而欠拟合训练数据以及模型过于复杂，而过拟合数据")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话

                }else if (position == 8){
                    new AlertDialog.Builder(getActivity()).setTitle("入门九")//设置对话框标题

                            .setMessage("聚类，可视化，降维和关联规则学习")//设置显示的内容

                            .setPositiveButton("退出",new DialogInterface.OnClickListener() {//添加确定按钮



                                @Override

                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                    // TODO Auto-generated method stub

                                }

                            }).show();//在按键响应事件中显示此对话

                }
            }
        });

        container.addView(view);//添加到父控件
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;// 过滤和缓存的作用
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);//从viewpager中移除掉
    }


}

