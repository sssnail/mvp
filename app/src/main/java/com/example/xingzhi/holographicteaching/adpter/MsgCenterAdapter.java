package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ItemMsgBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;


public class MsgCenterAdapter extends BaseBindingAdapter<MsgListBean.ItemListBean, ItemMsgBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemMsgBinding binding;
    private ItemListener itemListener;

    public MsgCenterAdapter(Context context) {
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
        return  R.layout.item_msg;
    }

    @Override
    protected void onBindItem(ItemMsgBinding itemMsgBinding, final MsgListBean.ItemListBean item, final int position) {
        binding = itemMsgBinding;
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
