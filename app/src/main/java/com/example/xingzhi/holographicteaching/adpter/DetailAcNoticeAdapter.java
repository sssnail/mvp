package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.databinding.ItemAcNoticeBinding;
import com.example.xingzhi.holographicteaching.databinding.ItemCenterFootprintBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;


public class DetailAcNoticeAdapter extends BaseBindingAdapter<DetailNoticeBean.AcNoticeBean, ItemAcNoticeBinding> {

    ItemAcNoticeBinding binding;
    private ItemListener itemListener;

    public DetailAcNoticeAdapter(Context context) {
        super(context);
        this.context = context;
    }
    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return  R.layout.item_ac_notice;
    }

    @Override
    protected void onBindItem(ItemAcNoticeBinding acNoticeBinding, final DetailNoticeBean.AcNoticeBean item, final int position) {
        binding = acNoticeBinding;
        binding.setBean(item);
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
