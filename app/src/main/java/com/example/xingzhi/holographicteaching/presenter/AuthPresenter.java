package com.example.xingzhi.holographicteaching.presenter;

import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.bean.AuthResultBean;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.AuthView;

public class AuthPresenter extends BasePresenter<AuthView> {
    public AuthPresenter(AuthView view) {
        attachView(view);
    }

    public void auth(String realName, String id) {
        mvpView.showLoading();
        addSubscription(apiStores.AuthRequest(realName, id),
                new ApiCallback<AuthResultBean>() {
                    @Override
                    public void onSuccess(AuthResultBean bean) {
                        mvpView.authSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.authFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }
}
