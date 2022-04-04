package com.example.brightinng.Tools.banner;

import static com.example.brightinng.Tools.banner.MyAdapter1.getActivity;

import android.content.Context;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import com.example.brightinng.Main_Activity;
import com.example.brightinng.R;
import com.example.brightinng.RealityApply.RealityMain_Activity;
import com.example.brightinng.Main_Activity.*;
import com.example.brightinng.Train.Train_Activity;

public class MyAdapter extends PagerAdapter{

    private int[] mData;
    private Context mContext;
    public  static int signal = -1;

    public MyAdapter(Context ctx, int[] data) {
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
                switch (position){
                    case 0:
                        Intent intentRea = new Intent(getActivity(), RealityMain_Activity.class);
                        getActivity().startActivity(intentRea);
                        break;
                    case 1:
                        Intent intentTra = new Intent(getActivity(), Train_Activity.class);
                        getActivity().startActivity(intentTra);
                        break;
                    case 2:
                        Toast.makeText(getActivity(),"相关功能正在完善中，敬请期待",Toast.LENGTH_SHORT).show();
                        break;
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
