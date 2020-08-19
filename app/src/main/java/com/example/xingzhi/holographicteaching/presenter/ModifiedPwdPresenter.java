package com.example.xingzhi.holographicteaching.presenter;

import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.ModifiedPwdView;
import com.example.xingzhi.holographicteaching.view.UserView;

public class ModifiedPwdPresenter extends BasePresenter<ModifiedPwdView> {
    public ModifiedPwdPresenter(ModifiedPwdView view) {
        attachView(view);
    }

    public void forgotPwdModified(String mobile, String password, String code) {
        mvpView.showLoading();
        addSubscription(apiStores.ForgotPwdRequest(mobile, password, code),
                new ApiCallback<BaseResultBean>() {
                    @Override
                    public void onSuccess(BaseResultBean bean) {
                        mvpView.ModifiedPwdSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.ModifiedPwdFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

    public void PwdModified(int code, String password) {
        mvpView.showLoading();
        addSubscription(apiStores.ResetPwdRequest(code, password),
                new ApiCallback<BaseResultBean>() {
                    @Override
                    public void onSuccess(BaseResultBean bean) {
                        mvpView.ModifiedPwdSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.ModifiedPwdFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

    public void sendSMS(String mobile, String type) {
        mvpView.showLoading();
        addSubscription(apiStores.SendMsmRequest(mobile, type),
                new ApiCallback<BaseResultBean>() {
                    @Override
                    public void onSuccess(BaseResultBean bean) {
                        mvpView.sendSMSSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.sendSMSFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

}
