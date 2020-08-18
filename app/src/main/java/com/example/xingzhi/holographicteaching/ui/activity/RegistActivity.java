package com.example.xingzhi.holographicteaching.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpActivity;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityRegistBinding;
import com.example.xingzhi.holographicteaching.presenter.LoginPresenter;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.ActivityStackManager;
import com.example.xingzhi.holographicteaching.view.AgreementTextView;
import com.example.xingzhi.holographicteaching.view.UserView;

public class RegistActivity extends MvpActivity<LoginPresenter> implements UserView {
    private ActivityRegistBinding binding;
    private boolean showPwd;
    private Handler handler;
    private ActivityStackManager activityStackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStackManager = ActivityStackManager.getInstance(this);
        activityStackManager.addBackupView(RegistActivity.this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_regist);
        handler = new Handler();
        binding.setClickEvent(new RegistOnClick());
        binding.titleLayout.tvTitle.setText("注册");
        new Utils.TextChangedListener4(binding.etMobile, binding.etCode, binding.etPwd, binding.etInviteCode, binding.button);
        Utils.TextChangedListener4.setCheck(true);
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
    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void getUserModelSuccess(LoginResultBean bean) {
        //接口成功回调
        dataSuccess(bean);
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
        Utils.startCodeTime(RegistActivity.this, binding.getCode, handler, 60);
    }

    @Override
    public void sendSMSFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    private void dataSuccess(LoginResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ) {
            toastShow(bean.getMsg());
            return;
        }
        activityStackManager.finishAllActivities();
    }

    public class RegistOnClick{
        public void toLoginOnClick(View view){
            activityStackManager.removeTopView();
            startActivity(new Intent(RegistActivity.this, LoginActivity.class));
        }
        public void RegistOnClick(View view){
            mvpPresenter.loadDataByRegist(binding.etMobile.getText().toString(), binding.etCode.getText().toString(), binding.etPwd.getText().toString(), binding.etInviteCode.getText().toString());
        }
        public void getCodeOnClick(View view){
            mvpPresenter.sendLoginSMS(binding.etMobile.getText().toString(), Utils.SMS_REG);
        }
        public void cancelOnClick(View view){
            binding.etMobile.setText(null);
        }
        public void ivPwdOnClick(View view){
            showPwd = !showPwd;
            Utils.setInputPwdStatus(showPwd, binding.etPwd, binding.ivPwd);
        }
        public void checkBoxOnClick(CompoundButton buttonView, boolean isChecked){
            Utils.TextChangedListener4.setCheck(isChecked);
            if ( TextUtils.isEmpty(binding.etMobile.getText().toString()) ||
                TextUtils.isEmpty(binding.etPwd.getText().toString()) ||
                 TextUtils.isEmpty(binding.etInviteCode.getText().toString()) ){
                return;
            }
            binding.button.setEnabled(isChecked);
        }
    }

    @Override
    protected void onDestroy() {
        if (handler != null) handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
