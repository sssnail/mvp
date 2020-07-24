package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.ActivateVipAdapter;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityActivateVipBinding;

public class ActivateVipActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityActivateVipBinding binding;
    private ActivateVipAdapter activateVipAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_activate_vip);
        binding.titleLayout.tvTitle.setText("激活会员");
        binding.titleLayout.ivBack.setOnClickListener(this);
        binding.tvAcCode.setOnClickListener(this);
        binding.tvImmediate.setOnClickListener(this);
        activateVipAdapter = new ActivateVipAdapter(this);
        binding.rvVipLevel.setAdapter(activateVipAdapter);
        for (int i = 0; i < 3; i++) {
            activateVipAdapter.getItems().add(new MsgListBean.ItemListBean( true, "系统消息", "8小时前", "您于2020年7月7日提现的奖励金¥5789元已到账，请注意查收！"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.title:
                ActivateVipActivity.this.finish();
            break;
            case  R.id.tv_ac_code:
                startActivity(new Intent(ActivateVipActivity.this, ActivateCodeActivity.class));
            break;
            case  R.id.tv_immediate:
                startActivity(new Intent(ActivateVipActivity.this, ActivateCodeActivity.class));
                break;
        }
    }
}
