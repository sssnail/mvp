package com.example.xingzhi.holographicteaching.adpter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.xingzhi.holographicteaching.R;


public class ViewHolderTitle extends RecyclerView.ViewHolder {
     TextView mOpenRecordDateTv;
    public ViewHolderTitle(View itemView) {
        super(itemView);
        mOpenRecordDateTv = (TextView) itemView.findViewById(R.id.open_record_date_tv);

    }
}
