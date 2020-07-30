package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.databinding.ItemCenterFootprintBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemMyProfitBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.utils.Utils;


public class MyProfitAdapter extends BaseBindingAdapter<ItemListModel.ItemListBean, ItemMyProfitBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemMyProfitBinding binding;

    public MyProfitAdapter(Context context) {
        super(context);
        this.context = context;
    }

    public void showFootView(){
        binding.llItemFoot.llItemFoot.setVisibility(View.VISIBLE);

    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_my_profit;
    }

    @Override
    protected void onBindItem(ItemMyProfitBinding footprintBinding, final ItemListModel.ItemListBean item, final int position) {
        binding = footprintBinding;
//        binding.setBean(item);
        binding.executePendingBindings();
    }

}
