package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.GameGiftGetAdapter;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.AcGameGiftGetBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;

public class GameGiftGetActivity extends AppCompatActivity {

    private AcGameGiftGetBinding binding;
    private GameGiftGetAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.ac_game_gift_get);
        binding.titleLayout.tvTitle.setText("游戏礼包领取");
        adapter = new GameGiftGetAdapter(this);
        binding.giftList.setAdapter(adapter);for (int i = 0; i < 3; i++) {
            adapter.getItems().add(new MsgListBean.ItemListBean( true, "系统消息", "8小时前", "您于2020年7月7日提现的奖励金¥5789元已到账，请注意查收！"));
        }
        adapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                startActivity(new Intent(GameGiftGetActivity.this, GameGiftActivity.class));
            }
        });
    }
}
