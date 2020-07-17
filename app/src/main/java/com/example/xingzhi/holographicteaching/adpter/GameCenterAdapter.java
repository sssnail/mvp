package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;


import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ItemCenterFootprintBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.modle.ItemListModel;


public class GameCenterAdapter extends BaseBindingAdapter<ItemListModel.ItemListBean, ItemCenterFootprintBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemCenterFootprintBinding binding;
    private ItemListener itemListener;

    public GameCenterAdapter(Context context) {
        super(context);
        this.context = context;
    }
    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }

    public void showFootView(){
        binding.llItemFoot.setVisibility(View.VISIBLE);

    }


    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_center_footprint;
    }

    @Override
    protected void onBindItem(ItemCenterFootprintBinding footprintBinding, final ItemListModel.ItemListBean item, final int position) {
        binding = footprintBinding;
        binding.setBean(item);
        binding.executePendingBindings();
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
