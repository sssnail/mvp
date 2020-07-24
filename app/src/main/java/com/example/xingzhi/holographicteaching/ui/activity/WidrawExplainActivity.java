package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityWidrawExplainBinding;

public class WidrawExplainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityWidrawExplainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_widraw_explain);
        binding.titleLayout.tvTitle.setText("提现说明");
        binding.tvToWithdraw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_to_withdraw:
                startActivity(new Intent(WidrawExplainActivity.this, WithdrawBindActivity.class));
                break;
            case R.id.rl_history:
                startActivity(new Intent(WidrawExplainActivity.this, WdHistoryActivity.class));
                break;
            case R.id.rl_bill:
                startActivity(new Intent(WidrawExplainActivity.this, AccountBillActivity.class));
                break;
        }
    }
}
