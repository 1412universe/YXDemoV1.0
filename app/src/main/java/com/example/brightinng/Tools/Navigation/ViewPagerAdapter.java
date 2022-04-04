package com.example.brightinng.Tools.Navigation;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Integer> mImageIds;


    public ViewPagerAdapter(Context context, List<Integer> imageIds) {
        this.mContext = context;
        this.mImageIds = imageIds;
    }

    @Override
    public int getCount() {
        return this.mImageIds.size();
    }


    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ImageView image = new ImageView(mContext);
        image.setImageResource(mImageIds.get(position));
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setPadding(200, 80, 200, 80);
        ((ViewPager)container).addView(image);
        return image;
    }


}
