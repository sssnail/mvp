package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.ItemGiftGetBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemOpenServiceBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class OpenServiceAdapter extends BaseBindingAdapter<MsgListBean.ItemListBean, ItemOpenServiceBinding> {
    private static Context context;
    private boolean showFootView;
    public int total; //总数
    ItemOpenServiceBinding binding;
    private ItemListener itemListener;

    public OpenServiceAdapter(Context context) {
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
        return  R.layout.item_open_service;
    }

    @Override
    protected void onBindItem(ItemOpenServiceBinding binding, final MsgListBean.ItemListBean item, final int position) {
        binding = binding;
        binding.executePendingBindings();
    }

}
