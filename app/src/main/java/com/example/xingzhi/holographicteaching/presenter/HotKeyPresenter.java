package com.example.xingzhi.holographicteaching.presenter;

import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.bean.AuthResultBean;
import com.example.xingzhi.holographicteaching.bean.HotKeyResultBean;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.AuthView;
import com.example.xingzhi.holographicteaching.view.HotKeywordView;

public class HotKeyPresenter extends BasePresenter<HotKeywordView> {
    public HotKeyPresenter(HotKeywordView view) {
        attachView(view);
    }

    public void getHotKey(String realName, String id) {
        mvpView.showLoading();
        addSubscription(apiStores.HotKeywordRequest(),
                new ApiCallback<HotKeyResultBean>() {
                    @Override
                    public void onSuccess(HotKeyResultBean bean) {
                        mvpView.getHotKeySuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getHotKeyFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }
}
