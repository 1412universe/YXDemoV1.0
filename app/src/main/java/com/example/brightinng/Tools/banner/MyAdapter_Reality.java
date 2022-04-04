package com.example.brightinng.Tools.banner;

import static com.example.brightinng.Tools.banner.MyAdapter1.getActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.viewpager.widget.PagerAdapter;

import com.example.brightinng.R;
import com.example.brightinng.RealityApply.character.by.Characterby;
import com.example.brightinng.RealityApply.character.fl.Characterfl;
import com.example.brightinng.RealityApply.character.fx.Characterfx;
import com.example.brightinng.RealityApply.character.gui.Charactergui;
import com.example.brightinng.RealityApply.character.hui.Characterhui;
import com.example.brightinng.RealityApply.character.jian.Characterjian;
import com.example.brightinng.RealityApply.character.jwz.Characterjwz;
import com.example.brightinng.RealityApply.character.lsq.Characterlsq;
import com.example.brightinng.RealityApply.character.lx.Characterlx;
import com.example.brightinng.RealityApply.character.sn.Charactersn;
import com.example.brightinng.RealityApply.character.xz.Characterxz;
import com.example.brightinng.RealityApply.character.yy.Characteryy;
import com.example.brightinng.RealityApply.character.zf.Characterzf;
import com.example.brightinng.RealityApply.character.zzw.Characterzzw;


public class MyAdapter_Reality extends PagerAdapter{

    private int[] mData;
    private Context mContext;
    public  static int signal = -1;

    public MyAdapter_Reality(Context ctx, int[] data) {
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
                switch (position) {
                    case 0:
                        Intent intent_fl = new Intent(getActivity(), Characterfl.class);
                        getActivity().startActivity(intent_fl);
                        getActivity().finish();
                        break;
                    case 1:
                        Intent intent_zzf = new Intent(getActivity(), Characterzzw.class);
                        getActivity().startActivity(intent_zzf);
                        getActivity().finish();
                        break;
                    case 2:
                        Intent intent_by = new Intent(getActivity(), Characterby.class);
                        getActivity().startActivity(intent_by);
                        getActivity().finish();
                        break;
                    case 3:
                        Intent intent_lx = new Intent(getActivity(), Characterlx.class);
                        getActivity().startActivity(intent_lx);
                        getActivity().finish();
                        break;
                    case 4:
                        Intent intent_sn = new Intent(getActivity(), Charactersn.class);
                        getActivity().startActivity(intent_sn);
                        getActivity().finish();
                        break;
                    case 5:
                        Intent intent_hui = new Intent(getActivity(), Characterhui.class);
                        getActivity().startActivity(intent_hui);
                        getActivity().finish();
                        break;
                    case 6:
                        Intent intent_zf = new Intent(getActivity(), Characterzf.class);
                        getActivity().startActivity(intent_zf);
                        getActivity().finish();
                        break;
                    case 7:
                        Intent intent_xz = new Intent(getActivity(), Characterxz.class);
                        getActivity().startActivity(intent_xz);
                        getActivity().finish();
                        break;
                    case 8:
                        Intent intent_zwz = new Intent(getActivity(), Characterjwz.class);
                        getActivity().startActivity(intent_zwz);
                        getActivity().finish();
                        break;
                    case 9:
                        Intent intent_fx = new Intent(getActivity(), Characterfx.class);
                        getActivity().startActivity(intent_fx);
                        getActivity().finish();
                        break;
                    case 10:
                        Intent intent_yy = new Intent(getActivity(), Characteryy.class);
                        getActivity().startActivity(intent_yy);
                        getActivity().finish();
                        break;
                    case 11:
                        Intent intent_lsq = new Intent(getActivity(), Characterlsq.class);
                        getActivity().startActivity(intent_lsq);
                        getActivity().finish();
                        break;
                    case 12:
                        Intent intent_jian = new Intent(getActivity(), Characterjian.class);
                        getActivity().startActivity(intent_jian);
                        getActivity().finish();
                        break;
                    case 13:
                        Intent intent_gui = new Intent(getActivity(), Charactergui.class);
                        getActivity().startActivity(intent_gui);
                        getActivity().finish();
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
