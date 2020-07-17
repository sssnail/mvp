package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivitySmsLoginBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;

public class SmsLoginActivity extends AppCompatActivity {

    private Handler handler;
    private ActivitySmsLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sms_login);
        Utils.setInputEtShowIconListener(binding.etMobile, binding.ivCancel);
        new Utils.TextChangedListener2(binding.etMobile, binding.etCode, binding.button);
        handler = new Handler();
    }

    public class SmsLoginClickEvent{

        public void getCodeOnClick(View view){
            Utils.startCodeTime(SmsLoginActivity.this, binding.getCode, handler, 60);
        }
        public void cancelOnClick(View view){
            binding.etMobile.setText(null);
        }

        public void toRegisteOnClick(View view){
            startActivity(new Intent(SmsLoginActivity.this, RegistActivity.class));
        }
        public void toLoginOnClick(View view){
            startActivity(new Intent(SmsLoginActivity.this, LoginActivity.class));
        }
        public void toForgetPwdOnClick(View view){
            startActivity(new Intent(SmsLoginActivity.this, ForgetPwdActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) handler.removeCallbacksAndMessages(null);
    }
}
