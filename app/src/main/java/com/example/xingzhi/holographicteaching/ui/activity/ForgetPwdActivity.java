package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpActivity;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityForgetPwdBinding;
import com.example.xingzhi.holographicteaching.presenter.ModifiedPwdPresenter;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.ModifiedPwdView;

public class ForgetPwdActivity extends MvpActivity<ModifiedPwdPresenter> implements ModifiedPwdView {

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
        new Utils.TextChangedListener3(binding.etMobile, binding.etCode, binding.etPwd, binding.button);
        Utils.TextChangedListener3.setCheck(true);
        handler = new Handler();
    }

    @Override
    protected ModifiedPwdPresenter createPresenter() {
        return new ModifiedPwdPresenter(this);
    }

    @Override
    public void ModifiedPwdSuccess(BaseResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        ForgetPwdActivity.this.finish();
    }

    @Override
    public void ModifiedPwdFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    @Override
    public void sendSMSSuccess(BaseResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        Utils.startCodeTime(ForgetPwdActivity.this, binding.getCode, handler, 60);
    }

    @Override
    public void sendSMSFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    public class ForgetPwdClickEvent{

        public void buttonOnClick(View view){
            mvpPresenter.forgotPwdModified(binding.etMobile.getText().toString(), binding.etPwd.getText().toString(), binding.etCode.getText().toString());
        }
        public void getCodeOnClick(View view){
            mvpPresenter.sendSMS(binding.etMobile.getText().toString(), Utils.SMS_IFFORGOT);
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
