package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpActivity;
import com.example.xingzhi.holographicteaching.bean.AuthResultBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityAuthenticBinding;
import com.example.xingzhi.holographicteaching.presenter.AuthPresenter;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.AuthView;

public class AuthenticActivity extends MvpActivity<AuthPresenter> implements AuthView, View.OnClickListener {

    private ActivityAuthenticBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_authentic);
        binding.titleLayout.tvTitle.setText("实名认证");
        binding.btConfirm.setOnClickListener(this);
    }

    @Override
    protected AuthPresenter createPresenter() {
        return new AuthPresenter(this);
    }

    @Override
    public void authSuccess(AuthResultBean bean) {
        if (bean.getCode() != Utils.SUCCESS_CODE ){
            toastShow(bean.getMsg());
            return;
        }
    }

    @Override
    public void authFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_confirm:
                mvpPresenter.auth(binding.etName.getText().toString(), binding.etId.getText().toString());
                break;
        }
    }
}
