package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class ViewpagerAdapter extends PagerAdapter {
    Context context;
    List<String> list;
    List<View> viewList;
    public ViewpagerAdapter(Context context, List<View> list) {
        this.context=context;
        this.viewList=list;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View imageView = viewList.get(position);
//        ImageView imageView=new ImageView(context);
//        imageView.setMaxHeight(500);
//        imageView.setMaxWidth(200);
//        Glide.with(context).load(list.get(position%list.size())).into(imageView);
        container.addView(imageView);
        return container;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
