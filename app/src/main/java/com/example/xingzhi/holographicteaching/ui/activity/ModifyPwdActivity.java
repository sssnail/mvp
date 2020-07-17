package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityModifyPwdBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;

public class ModifyPwdActivity extends AppCompatActivity {

    private ActivityModifyPwdBinding binding;
    private boolean showPwd;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_modify_pwd);
        binding.setClickEvent(new ModifyPwdClickEvent());
        binding.titleLayout.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModifyPwdActivity.this.finish();
            }
        });
        handler = new Handler();

    }

    public class ModifyPwdClickEvent{
        public void ivPwdOnClick(View view){
            showPwd = !showPwd;
            Utils.setInputPwdStatus(showPwd, binding.etNewpwd, binding.ivPwd);
        }

        public void getCodeOnClick(View view){
            Utils.startCodeTime(ModifyPwdActivity.this, binding.getCode, handler, 60);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) handler.removeCallbacksAndMessages(null);
    }
}
