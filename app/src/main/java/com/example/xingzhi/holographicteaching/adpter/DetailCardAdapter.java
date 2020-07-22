package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.databinding.ItemAcNoticeBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemDetailCardBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class DetailCardAdapter extends BaseBindingAdapter<DetailNoticeBean.DetailCardBean, ItemDetailCardBinding> {

    ItemDetailCardBinding binding;

    public DetailCardAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_detail_card;
    }

    @Override
    protected void onBindItem(ItemDetailCardBinding cardBinding, final DetailNoticeBean.DetailCardBean item, final int position) {
        binding = cardBinding;
        binding.setBean(item);
        Glide.with(context).load(item.getImageUrl()).into(binding.ivCard);
        binding.executePendingBindings();
    }

}
