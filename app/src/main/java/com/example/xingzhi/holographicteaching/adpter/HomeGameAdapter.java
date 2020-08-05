package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.databinding.ItemCenterFootprintBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemHomeGameBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.utils.Utils;


public class HomeGameAdapter extends BaseBindingAdapter<ItemListModel.ItemListBean, ItemHomeGameBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemHomeGameBinding binding;
    private ItemListener itemListener;

    public HomeGameAdapter(Context context) {
        super(context);
        this.context = context;
    }
    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }

    public void showFootView(){
        binding.llItemFoot.llItemFoot.setVisibility(View.VISIBLE);

    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_home_game;
    }

    @Override
    protected void onBindItem(ItemHomeGameBinding binding, final ItemListModel.ItemListBean item, final int position) {
        binding = binding;
        binding.setBean(item);
        Utils.createTvLabels(context, binding.llLabels, item.getLabels());
//        binding.ivRanking.setVisibility(View.VISIBLE);
        if (itemListener != null){
            binding.itemNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.itemClick(position);
                }
            });
        }
    }

}
