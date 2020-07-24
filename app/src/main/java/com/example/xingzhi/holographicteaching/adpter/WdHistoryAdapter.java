package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.ItemMsgBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemWdHistoryBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class WdHistoryAdapter extends BaseBindingAdapter<MsgListBean.ItemListBean, ItemWdHistoryBinding> {
    private static Context context;
    ItemWdHistoryBinding binding;
    private ItemListener itemListener;

    public WdHistoryAdapter(Context context) {
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
        return  R.layout.item_wd_history;
    }

    @Override
    protected void onBindItem(ItemWdHistoryBinding binding, final MsgListBean.ItemListBean item, final int position) {
        binding = binding;
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
