package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityMineCenterBinding;

public class MineCenterActivity extends AppCompatActivity {

    private ActivityMineCenterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mine_center);
        binding.setClickEvent(new MineCenterClickEvent());
        binding.titleLayout.tvTitle.setText("个人中心");
        binding.titleLayout.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MineCenterActivity.this.finish();
            }
        });

    }

    public class MineCenterClickEvent{
        public void toBindPhoneOnClick(View view){
            Intent intent = new Intent(MineCenterActivity.this, BindPhoneActivity.class);
            startActivity(intent);
        }
        public void toModifyPwdOnClick(View view){
            Intent intent = new Intent(MineCenterActivity.this, ModifyPwdActivity.class);
            startActivity(intent);
        }
    }
}
