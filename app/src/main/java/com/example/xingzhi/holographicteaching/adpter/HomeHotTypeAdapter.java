package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.databinding.ItemHotTypeBinding;


public class HomeHotTypeAdapter extends BaseBindingAdapter<DetailNoticeBean.DetailCardBean, ItemHotTypeBinding> {

    ItemHotTypeBinding binding;

    public HomeHotTypeAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_hot_type;
    }

    @Override
    protected void onBindItem(ItemHotTypeBinding binding, final DetailNoticeBean.DetailCardBean item, final int position) {
        binding = binding;
//        binding.setBean(item);
        binding.executePendingBindings();
    }

}
