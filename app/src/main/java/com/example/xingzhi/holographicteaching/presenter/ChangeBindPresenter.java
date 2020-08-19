package com.example.xingzhi.holographicteaching.presenter;

import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.CenterResultBean;
import com.example.xingzhi.holographicteaching.bean.ChangeBindResultBean;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.ChangeBindMobileView;

public class ChangeBindPresenter extends BasePresenter<ChangeBindMobileView> {
    public ChangeBindPresenter(ChangeBindMobileView view) {
        attachView(view);
    }

    //个人中心用户基本信息 需要登录
    public void verifyChange(int code) {
        mvpView.showLoading();
        addSubscription(apiStores.VerifyChangeRequest(code),
                new ApiCallback<ChangeBindResultBean>() {
                    @Override
                    public void onSuccess(ChangeBindResultBean bean) {
                        mvpView.changeMobileSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.changeMobileFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }


    public void sendSMS(String mobile, String type) {
        mvpView.showLoading();
        addSubscription(apiStores.SendBindMsmRequest(mobile, type),
                new ApiCallback<ChangeBindResultBean>() {
                    @Override
                    public void onSuccess(ChangeBindResultBean bean) {
                        mvpView.sendSmsSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.sendSmsFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }
    public void sendBindSMS(String mobile, String type) {
        mvpView.showLoading();
        addSubscription(apiStores.SendMsmRequest(mobile, type),
                new ApiCallback<BaseResultBean>() {
                    @Override
                    public void onSuccess(BaseResultBean bean) {
                        mvpView.sendBindSmsSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.sendBindSmsFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

    public void bindMobileRequest(String mobile,int code, String token) {
        mvpView.showLoading();
        addSubscription(apiStores.BindMobileRequest(mobile, code, token),
                new ApiCallback<ChangeBindResultBean>() {
                    @Override
                    public void onSuccess(ChangeBindResultBean bean) {
                        mvpView.bindMobileSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.bindMobileFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }


}
