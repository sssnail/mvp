package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.ItemGiftGetBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemMsgBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class GameGiftGetAdapter extends BaseBindingAdapter<MsgListBean.ItemListBean, ItemGiftGetBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemGiftGetBinding binding;
    private ItemListener itemListener;

    public GameGiftGetAdapter(Context context) {
        super(context);
        this.context = context;
    }
    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }

//    public void showFootView(){
//        binding.itemFootview.llItemFoot.setVisibility(View.VISIBLE);
//    }


    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_gift_get;
    }

    @Override
    protected void onBindItem(ItemGiftGetBinding binding, final MsgListBean.ItemListBean item, final int position) {
        binding = binding;
        binding.executePendingBindings();
        if (itemListener != null){
            binding.relative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.itemClick(position);
                }
            });
        }
    }

}
