package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityRegistBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.AgreementTextView;

public class RegistActivity extends AppCompatActivity {
    private ActivityRegistBinding binding;
    private boolean showPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_regist);
        binding.setClickEvent(new RegistOnClick());
        binding.titleLayout.tvTitle.setText("注册");
        new Utils.TextChangedListener3(binding.etMobile, binding.etPwd, binding.etInviteCode, binding.button);
        Utils.TextChangedListener3.setCheck(true);
        binding.titleLayout.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistActivity.this.finish();
            }
        });
        binding.tvAgreement.setAgreementClickListener(new AgreementTextView.OnAgreementClickListener() {
            @Override
            public void clickListener(String tag, String clickText, boolean isCheck) {
                Toast.makeText(RegistActivity.this, clickText, Toast.LENGTH_SHORT).show();
            }
        });
        Utils.setInputEtShowIconListener(binding.etMobile, binding.ivCancel);
        Utils.setInputEtShowIconListener(binding.etPwd, binding.ivPwd);

    }

    public class RegistOnClick{
        public void toLoginOnClick(View view){
            startActivity(new Intent(RegistActivity.this, LoginActivity.class));
        }
        public void cancelOnClick(View view){
            binding.etMobile.setText(null);
        }
        public void ivPwdOnClick(View view){
            showPwd = !showPwd;
            Utils.setInputPwdStatus(showPwd, binding.etPwd, binding.ivPwd);
        }
        public void checkBoxOnClick(CompoundButton buttonView, boolean isChecked){
            Utils.TextChangedListener3.setCheck(isChecked);
            if ( TextUtils.isEmpty(binding.etMobile.getText().toString()) ||
                TextUtils.isEmpty(binding.etPwd.getText().toString()) ||
                 TextUtils.isEmpty(binding.etInviteCode.getText().toString()) ){
                return;
            }
            binding.button.setEnabled(isChecked);
        }
    }
}
