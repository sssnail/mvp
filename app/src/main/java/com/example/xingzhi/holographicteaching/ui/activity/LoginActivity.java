package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityLoginBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;


public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private boolean showPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setClickEvent(new LoginClickEvent());
        new Utils.TextChangedListener2(binding.etMobile, binding.etPwd, binding.button);
        Utils.setInputEtShowIconListener(binding.etMobile, binding.ivCancel);
        Utils.setInputEtShowIconListener(binding.etPwd, binding.ivPwd);
        binding.titleLayout.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
    }

    public class LoginClickEvent{
        public void toRegisteOnClick(View view){
            startActivity(new Intent(LoginActivity.this, RegistActivity.class));
        }
        public void toSmsLoginOnClick(View view){
            startActivity(new Intent(LoginActivity.this, SmsLoginActivity.class));
        }
        public void toForgetPwdOnClick(View view){
            startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
        }

        public void ivPwdOnClick(View view){
            showPwd = !showPwd;
            Utils.setInputPwdStatus(showPwd, binding.etPwd, binding.ivPwd);
        }

        public void cancelOnClick(View view){
            binding.etMobile.setText(null);
        }

    }
}
