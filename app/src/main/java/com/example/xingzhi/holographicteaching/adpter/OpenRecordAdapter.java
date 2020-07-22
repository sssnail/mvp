package com.example.xingzhi.holographicteaching.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.listener.ItemListener;

import java.util.List;



public class OpenRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int ITEM_TITLE = 1;
    private int ITEM_CONTENT = 2;
    private List<Object> objects;
    private ItemListener itemListener;

    /**
     * 传入数据
     * @param objects
     */
    public void setDate(List<Object> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(ItemListener listener){
        this.itemListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        if (viewType == ITEM_TITLE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.open_record_title, parent, false);
            holder = new ViewHolderTitle(view);
        } else if (viewType == ITEM_CONTENT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_center_footprint, parent, false);
            holder = new ViewHolderContent(view);

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        if (holder instanceof ViewHolderTitle) {
            String title = (String) objects.get(position);
            ((ViewHolderTitle) holder).mOpenRecordDateTv.setText(title);
        }else if (holder instanceof ViewHolderContent) {
//            OpenRecordBean.DataBean.LogDOListBean bean = (OpenRecordBean.DataBean.LogDOListBean) objects.get(position);
            ItemListModel.ItemListBean bean = (ItemListModel.ItemListBean) objects.get(position);

            ((ViewHolderContent) holder).itemNumber.setText(bean.getTitle());
            ((ViewHolderContent) holder).itemContent.setText(String.valueOf(bean.getContent()));

            if (itemListener != null){
                ((ViewHolderContent) holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemListener.itemClick(position);
                    }
                });
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (objects.get(position) instanceof String) {
            return ITEM_TITLE;
        } else if (objects.get(position) instanceof ItemListModel.ItemListBean) {
            return ITEM_CONTENT;
        }
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        return objects == null ? 0 : objects.size();
    }

}

