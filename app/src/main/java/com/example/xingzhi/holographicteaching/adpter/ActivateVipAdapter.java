package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.ItemMsgBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemVipLevelBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class ActivateVipAdapter extends BaseBindingAdapter<MsgListBean.ItemListBean, ItemVipLevelBinding> {
    private static Context context;
    ItemVipLevelBinding binding;
    private ItemListener itemListener;

    public ActivateVipAdapter(Context context) {
        super(context);
        this.context = context;
    }
    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }



    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_vip_level;
    }

    @Override
    protected void onBindItem(ItemVipLevelBinding binding, final MsgListBean.ItemListBean item, final int position) {
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
