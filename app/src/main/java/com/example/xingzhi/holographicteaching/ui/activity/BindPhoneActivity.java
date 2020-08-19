package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpActivity;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.ChangeBindResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityBindPhoneBinding;
import com.example.xingzhi.holographicteaching.presenter.ChangeBindPresenter;
import com.example.xingzhi.holographicteaching.presenter.ModifiedPwdPresenter;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.ChangeBindMobileView;
import com.example.xingzhi.holographicteaching.view.ModifiedPwdView;


public class BindPhoneActivity extends MvpActivity<ChangeBindPresenter> implements ChangeBindMobileView, View.OnClickListener {

    private ActivityBindPhoneBinding binding ;
    private Handler handler;
    private LoginResultBean.LoginData loginData;
    private String changeToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_phone);
        handler = new Handler();
        loginData = LoginResultBean.getInstance().getData();
        binding.titleLayout.ivBack.setOnClickListener(this);
        binding.titleLayout.tvTitle.setText(getString(R.string.identify));
        binding.getCode.setOnClickListener(this);
        binding.btNext.setOnClickListener(this);
        binding.btBindCode.setOnClickListener(this);
        binding.btConfirm.setOnClickListener(this);
        String string = getString(R.string.identify_notice, String.valueOf(loginData.getMobile()));
        binding.tvNotice.setText(Html.fromHtml(string));
    }

    @Override
    protected ChangeBindPresenter createPresenter() {
        return new ChangeBindPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                BindPhoneActivity.this.finish();
                break;
            case R.id.get_code:
                mvpPresenter.sendSMS(loginData.getMobile(), Utils.SMS_CHANGE);
                break;
            case R.id.bt_next:
                mvpPresenter.verifyChange(Integer.parseInt(binding.etCode.getText().toString()));
                break;
            case R.id.bt_bind_code:
                mvpPresenter.sendBindSMS(binding.etMobile.getText().toString(), Utils.SMS_BIND);
                break;
            case R.id.bt_confirm:
                mvpPresenter.bindMobileRequest(binding.etMobile.getText().toString(), Integer.parseInt(binding.etBindCode.getText().toString()), changeToken);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void changeMobileSuccess(ChangeBindResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        changeToken = bean.getData().getToken();
        binding.llDisband.setVisibility(View.GONE);
        binding.llBand.setVisibility(View.VISIBLE);
    }

    @Override
    public void changeMobileFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    @Override
    public void sendSmsSuccess(ChangeBindResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        Utils.startCodeTime(BindPhoneActivity.this, binding.getCode, handler, 60);
    }

    @Override
    public void sendBindSmsSuccess(BaseResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        Utils.startCodeTime(BindPhoneActivity.this, binding.btBindCode, handler, 60);
    }

    @Override
    public void sendSmsFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    @Override
    public void sendBindSmsFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    @Override
    public void bindMobileSuccess(ChangeBindResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
        loginData.setMobile(bean.getData().getMobile());
        BindPhoneActivity.this.finish();
    }

    @Override
    public void bindMobileFail(String msg) {
        toastShow(getString(R.string.net_error));
    }
}
