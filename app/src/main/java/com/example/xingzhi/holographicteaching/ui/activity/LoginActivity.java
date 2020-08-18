package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpActivity;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.core.AppControl;
import com.example.xingzhi.holographicteaching.databinding.ActivityLoginBinding;
import com.example.xingzhi.holographicteaching.presenter.LoginPresenter;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.ActivityStackManager;
import com.example.xingzhi.holographicteaching.view.UserView;


public class LoginActivity extends MvpActivity<LoginPresenter> implements UserView {

    ActivityLoginBinding binding;
    private boolean showPwd;
    private ActivityStackManager activityStackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setClickEvent(new LoginClickEvent());
        activityStackManager = ActivityStackManager.getInstance(this);
        activityStackManager.addBackupView(LoginActivity.this);
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
    public void sendSMSSuccess(BaseResultBean model) {

    }

    @Override
    public void sendSMSFail(String msg) {

    }

    public class LoginClickEvent{
        public void loginOnClick(View view){
            mvpPresenter.loadDataByLogin(binding.etMobile.getText().toString(), binding.etPwd.getText().toString());
        }
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
