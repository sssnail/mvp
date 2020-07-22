package com.example.xingzhi.holographicteaching.adpter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.xingzhi.holographicteaching.R;


public class ViewHolderContent extends RecyclerView.ViewHolder {
    TextView itemNumber, itemContent;
    RelativeLayout relativeLayout;
    public ViewHolderContent(View view) {
        super(view);
        itemNumber = (TextView) view.findViewById(R.id.item_number);
        itemContent = (TextView) view.findViewById(R.id.item_content);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relative);
    }
}
