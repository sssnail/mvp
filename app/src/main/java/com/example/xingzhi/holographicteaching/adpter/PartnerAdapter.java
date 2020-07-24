package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.databinding.ItemCenterFootprintBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemPartnerBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class PartnerAdapter extends BaseBindingAdapter<ItemListModel.ItemListBean, ItemPartnerBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemPartnerBinding binding;
    private ItemListener itemListener;

    public PartnerAdapter(Context context) {
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
        return  R.layout.item_partner;
    }

    @Override
    protected void onBindItem(ItemPartnerBinding binding, final ItemListModel.ItemListBean item, final int position) {
        binding = binding;
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
