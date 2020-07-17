package com.example.xingzhi.holographicteaching.adpter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;


import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.ui.fragment.HomeFragment;

import java.util.List;

/**
 * Created by hackware on 2016/9/10.
 */

public class ExamplePagerAdapter extends PagerAdapter {
    private List<String> mDataList;
    private HomeFragment fragment;

    public ExamplePagerAdapter(HomeFragment fragment, List<String> dataList) {
        this.fragment = fragment;
        this.mDataList = dataList;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        TextView view = new TextView(container.getContext());
//        view.setText(mDataList.get(position));
//        view.setGravity(Gravity.CENTER);
//        view.setTextColor(Color.BLACK);
//        view.setTextSize(24);
//        container.addView(view);

        View view = View.inflate(container.getContext(), R.layout.viewpager_layout, null);
        TextView tv1 = view.findViewById(R.id.tv_1);
        TextView tv2 = view.findViewById(R.id.tv_2);
        TextView tv3 = view.findViewById(R.id.tv_3);

        tv1.setText(mDataList.get(position));
        tv2.setText(mDataList.get(position));
        tv3.setText(mDataList.get(position));
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        TextView textView = (TextView) object;
        String text = textView.getText().toString();
        int index = mDataList.indexOf(text);
        if (index >= 0) {
            return index;
        }
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position);
    }
}
