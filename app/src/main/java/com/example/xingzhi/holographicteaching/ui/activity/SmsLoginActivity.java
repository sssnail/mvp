package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpActivity;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.core.AppControl;
import com.example.xingzhi.holographicteaching.databinding.ActivitySmsLoginBinding;
import com.example.xingzhi.holographicteaching.presenter.LoginPresenter;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.ActivityStackManager;
import com.example.xingzhi.holographicteaching.view.UserView;

public class SmsLoginActivity extends MvpActivity<LoginPresenter> implements UserView {

    private Handler handler;
    private ActivitySmsLoginBinding binding;
    private ActivityStackManager activityStackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sms_login);
        binding.setClickEvent(new SmsLoginClickEvent());
        binding.titleLayout.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsLoginActivity.this.finish();
            }
        });
        activityStackManager = ActivityStackManager.getInstance(this);
        activityStackManager.addBackupView(SmsLoginActivity.this);
        Utils.setInputEtShowIconListener(binding.etMobile, binding.ivCancel);
        new Utils.TextChangedListener2(binding.etMobile, binding.etCode, binding.button);
        handler = new Handler();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void getUserModelSuccess(LoginResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        LoginResultBean.getInstance().setData(bean.getData());
        AppControl.saveUserToken(bean.getData().getToken());
        activityStackManager.finishAllActivities();
    }

    @Override
    public void getUserModelFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    @Override
    public void sendSMSSuccess(BaseResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        Utils.startCodeTime(SmsLoginActivity.this, binding.getCode, handler, 60);
    }

    @Override
    public void sendSMSFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    public class SmsLoginClickEvent{
        public void LoginOnClick(View view){
            mvpPresenter.loadDataBySmsLogin(binding.etMobile.getText().toString(), binding.etCode.getText().toString());
        }
        public void getCodeOnClick(View view){
            mvpPresenter.sendLoginSMS(binding.etMobile.getText().toString(), Utils.SMS_LOGIN);
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
