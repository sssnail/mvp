package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.databinding.ItemNewGameCardBinding;


public class HomeNewGameAdapter extends BaseBindingAdapter<DetailNoticeBean.DetailCardBean, ItemNewGameCardBinding> {

    ItemNewGameCardBinding binding;

    public HomeNewGameAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_new_game_card;
    }

    @Override
    protected void onBindItem(ItemNewGameCardBinding cardBinding, final DetailNoticeBean.DetailCardBean item, final int position) {
        binding = cardBinding;
        binding.setBean(item);
//        Glide.with(context).load(item.getImageUrl()).into(binding.ivCard);
        binding.executePendingBindings();
    }

}
