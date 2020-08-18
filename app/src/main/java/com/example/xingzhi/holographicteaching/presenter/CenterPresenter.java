package com.example.xingzhi.holographicteaching.presenter;

import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.CenterResultBean;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.CenterView;
import com.example.xingzhi.holographicteaching.view.ModifiedPwdView;

public class CenterPresenter extends BasePresenter<CenterView> {
    public CenterPresenter(CenterView view) {
        attachView(view);
    }

    //个人中心用户基本信息 需要登录
    public void getCenterData() {
        mvpView.showLoading();
        addSubscription(apiStores.CenterRequest(),
                new ApiCallback<CenterResultBean>() {
                    @Override
                    public void onSuccess(CenterResultBean bean) {
                        mvpView.getCenterSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getCenterFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }


}
