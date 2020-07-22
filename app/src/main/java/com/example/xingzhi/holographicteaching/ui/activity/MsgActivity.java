package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.MsgCenterAdapter;
import com.example.xingzhi.holographicteaching.databinding.ActivityMsgBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;

public class MsgActivity extends AppCompatActivity {
    private ActivityMsgBinding binding;
    private MsgCenterAdapter msgCenterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_msg);
        binding.setMsgClickEvent(new MsgClickEvent());
        msgCenterAdapter = new MsgCenterAdapter(this);
        binding.msgList.setAdapter(msgCenterAdapter);

        for (int i = 0; i < 3; i++) {
            msgCenterAdapter.getItems().add(new MsgListBean.ItemListBean( true, "系统消息", "8小时前", "您于2020年7月7日提现的奖励金¥5789元已到账，请注意查收！"));
        }
        msgCenterAdapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                Toast.makeText(MsgActivity.this, String.valueOf(i).concat("点击了"), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class MsgClickEvent{
        public void manageOnClick(View view){
            msgCenterAdapter.showFootView();
        }
        public void backOnClick(View view){
            MsgActivity.this.finish();
        }
    }

}
