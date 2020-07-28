package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.databinding.ItemRecomCardBinding;


public class GameCardAdapter extends BaseBindingAdapter<DetailNoticeBean.DetailCardBean, ItemRecomCardBinding> {

    ItemRecomCardBinding binding;

    public GameCardAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_recom_card;
    }

    @Override
    protected void onBindItem(ItemRecomCardBinding cardBinding, final DetailNoticeBean.DetailCardBean item, final int position) {
        binding = cardBinding;
        binding.setBean(item);
//        Glide.with(context).load(item.getImageUrl()).into(binding.ivCard);
        binding.executePendingBindings();
    }

}
