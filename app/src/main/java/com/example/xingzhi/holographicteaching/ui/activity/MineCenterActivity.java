package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityMineCenterBinding;

public class MineCenterActivity extends AppCompatActivity {

    private ActivityMineCenterBinding binding;
    private LoginResultBean.LoginData loginData;
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
        loginData = LoginResultBean.getInstance().getData();
        binding.tvMobile.setText(loginData.getMobile());
        Glide.with(MineCenterActivity.this).load(loginData.getAvatar()).apply(RequestOptions.circleCropTransform()).into(binding.ivPortrait);
        binding.tvNickname.setText(loginData.getNickname());

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
        public void toAuthenticOnClick(View view){
            Intent intent = new Intent(MineCenterActivity.this, AuthenticActivity.class);
            startActivity(intent);
        }
    }
}
