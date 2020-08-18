package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpActivity;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityModifyPwdBinding;
import com.example.xingzhi.holographicteaching.presenter.ModifiedPwdPresenter;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.ModifiedPwdView;

public class ModifyPwdActivity extends MvpActivity<ModifiedPwdPresenter> implements ModifiedPwdView {

    private ActivityModifyPwdBinding binding;
    private boolean showPwd;
    private Handler handler;
    private LoginResultBean.LoginData loginData;
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
        loginData = LoginResultBean.getInstance().getData();
        binding.tvMobile.setText(loginData.getMobile());
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
        toastShow(bean.getMsg());
        ModifyPwdActivity.this.finish();
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
        Utils.startCodeTime(ModifyPwdActivity.this, binding.getCode, handler, 60);
    }

    @Override
    public void sendSMSFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    public class ModifyPwdClickEvent{
        public void ivPwdOnClick(View view){
            showPwd = !showPwd;
            Utils.setInputPwdStatus(showPwd, binding.etNewpwd, binding.ivPwd);
        }

        public void getCodeOnClick(View view){
            mvpPresenter.sendSMS(loginData.getMobile(), Utils.SMS_PWD);
        }
        public void commitOnClick(View view){
            mvpPresenter.PwdModified(binding.getCode.getText().toString(), binding.etNewpwd.getText().toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) handler.removeCallbacksAndMessages(null);
    }
}
