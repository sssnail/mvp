package com.example.xingzhi.holographicteaching.presenter;

import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.bean.HotKeyResultBean;
import com.example.xingzhi.holographicteaching.bean.RankingHotResultBean;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.HotKeywordView;
import com.example.xingzhi.holographicteaching.view.RankingHotView;

public class RankingHotPresenter extends BasePresenter<RankingHotView> {
    public RankingHotPresenter(RankingHotView view) {
        attachView(view);
    }

    public void getRankingHotKey() {
        mvpView.showLoading();
        addSubscription(apiStores.RankingHotRequest(),
                new ApiCallback<RankingHotResultBean>() {
                    @Override
                    public void onSuccess(RankingHotResultBean bean) {
                        mvpView.getRankingHotSuccess(bean);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getRankingHotFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }
}
