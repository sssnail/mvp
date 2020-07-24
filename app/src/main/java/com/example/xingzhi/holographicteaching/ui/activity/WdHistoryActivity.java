package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.WdHistoryAdapter;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityWdHistoryBinding;

public class WdHistoryActivity extends AppCompatActivity {

    private ActivityWdHistoryBinding binding;
    private WdHistoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wd_history);
        binding.titleLayout.tvTitle.setText("提现历史");
        adapter = new WdHistoryAdapter(this);
        binding.rvWdHistory.setAdapter(adapter);
        for (int i = 0; i < 3; i++) {
            adapter.getItems().add(new MsgListBean.ItemListBean( true, "系统消息", "8小时前", "您于2020年7月7日提现的奖励金¥5789元已到账，请注意查收！"));
        }
    }
}
