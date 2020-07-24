package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.databinding.ItemPartnerBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemPartnerOrderBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class PartnerOrderAdapter extends BaseBindingAdapter<ItemListModel.ItemListBean, ItemPartnerOrderBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemPartnerOrderBinding binding;
    private ItemListener itemListener;

    public PartnerOrderAdapter(Context context) {
        super(context);
        this.context = context;
    }
    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }

    public void showFootView(){
        binding.itemFootview.llItemFoot.setVisibility(View.VISIBLE);

    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_partner_order;
    }

    @Override
    protected void onBindItem(ItemPartnerOrderBinding binding, final ItemListModel.ItemListBean item, final int position) {
        binding = binding;
//        binding.setBean(item);
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
