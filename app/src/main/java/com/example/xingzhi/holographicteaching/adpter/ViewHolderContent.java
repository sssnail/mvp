package com.example.xingzhi.holographicteaching.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.utils.Utils;


public class ViewHolderContent extends RecyclerView.ViewHolder {
    TextView itemNumber, itemContent, itemDiscount, itemInstall;
    RelativeLayout relativeLayout;
    LinearLayout llLabels;
    public ViewHolderContent(View view) {
        super(view);
        itemNumber = (TextView) view.findViewById(R.id.item_number);
        itemContent = (TextView) view.findViewById(R.id.item_content);
        itemDiscount = (TextView) view.findViewById(R.id.item_discount);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relative);
        itemInstall = (TextView) view.findViewById(R.id.item_install);
        llLabels = (LinearLayout) view.findViewById(R.id.ll_labels);
    }
}
