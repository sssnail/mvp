package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.MyProfitAdapter;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.databinding.ActivityMyProfitBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyProfitActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMyProfitBinding binding;
    private MyProfitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_profit);
        binding.titleLayout.tvTitle.setText("我的收益");
        binding.ivEdit.setOnClickListener(this);

        adapter = new MyProfitAdapter(this);
        binding.rvProfit.setAdapter(adapter);
        for (int i = 0; i < 3; i++) {
            adapter.getItems().add(new ItemListModel.ItemListBean( "胜者为王", "4.5折", "全方位体验一个不一样的...", "传奇", "传奇9服", 0, Utils.getLabels()));
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_edit:
                startActivity(new Intent(MyProfitActivity.this, ChooseDateActivity.class));
                break;
        }
    }
}
