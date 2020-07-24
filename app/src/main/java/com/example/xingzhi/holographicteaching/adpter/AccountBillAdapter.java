package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.ItemAccountBillBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemVipLevelBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class AccountBillAdapter extends BaseBindingAdapter<MsgListBean.ItemListBean, ItemAccountBillBinding> {
    private static Context context;
    ItemAccountBillBinding binding;
    private ItemListener itemListener;

    public AccountBillAdapter(Context context) {
        super(context);
        this.context = context;
    }
    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }



    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_account_bill;
    }

    @Override
    protected void onBindItem(ItemAccountBillBinding binding, final MsgListBean.ItemListBean item, final int position) {
        binding = binding;
//        binding.setBean(item);
        binding.executePendingBindings();

    }

}
