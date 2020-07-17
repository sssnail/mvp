package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityForgetPwdBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;

public class ForgetPwdActivity extends AppCompatActivity {

    private ActivityForgetPwdBinding binding;
    private Handler handler;
    private boolean showPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forget_pwd);
        binding.titleLayout.tvTitle.setText("忘记密码");
        binding.titleLayout.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgetPwdActivity.this.finish();
            }
        });
        binding.setClickEvent(new ForgetPwdClickEvent());
        Utils.setInputEtShowIconListener(binding.etMobile, binding.ivCancel);
        Utils.setInputEtShowIconListener(binding.etPwd, binding.ivPwd);
        new Utils.TextChangedListener3(binding.etMobile, binding.etCode, binding.etCode, binding.button);
        handler = new Handler();
    }

    public class ForgetPwdClickEvent{

        public void getCodeOnClick(View view){
            Utils.startCodeTime(ForgetPwdActivity.this, binding.getCode, handler, 60);
        }
        public void cancelOnClick(View view){
            binding.etMobile.setText(null);
        }

        public void ivPwdOnClick(View view){
            showPwd = !showPwd;
            Utils.setInputPwdStatus(showPwd, binding.etPwd, binding.ivPwd);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) handler.removeCallbacksAndMessages(null);
    }
}
