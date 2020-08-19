package com.example.xingzhi.holographicteaching.presenter;

import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.bean.VipIndexResultBean;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.VipIndexView;

public class VipIndexPresenter extends BasePresenter<VipIndexView> {
    public VipIndexPresenter(VipIndexView view) {
        attachView(view);
    }

    public void getVipIndex() {
        mvpView.showLoading();
        addSubscription(apiStores.VipIndexRequest(),
                new ApiCallback<VipIndexResultBean>() {
                    @Override
                    public void onSuccess(VipIndexResultBean bean) {
                        mvpView.getVipIndexSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getVipIndexFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }
}
