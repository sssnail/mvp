package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityBindPhoneBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;


public class BindPhoneActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityBindPhoneBinding binding ;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_phone);
        handler = new Handler();
        binding.titleLayout.ivBack.setOnClickListener(this);
        binding.getCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                BindPhoneActivity.this.finish();
                break;
            case R.id.get_code:
                Utils.startCodeTime(BindPhoneActivity.this, binding.getCode, handler, 60);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) handler.removeCallbacksAndMessages(null);
    }
}
