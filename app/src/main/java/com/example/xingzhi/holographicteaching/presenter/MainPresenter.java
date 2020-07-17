package com.example.xingzhi.holographicteaching.presenter;


import com.example.xingzhi.holographicteaching.base.BasePresenter;
import com.example.xingzhi.holographicteaching.modle.MainModel;
import com.example.xingzhi.holographicteaching.net.ApiCallback;
import com.example.xingzhi.holographicteaching.view.MainView;

/**
 * @explain 数据业务逻辑示例
 * @author JC.
 * @creat time 2019/10/30 15:34.
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }

    public void loadDataByRetrofitRxjava(String cityId) {
        mvpView.showLoading();
        addSubscription(apiStores.LoginRequest(cityId),
                new ApiCallback<MainModel>() {
                    @Override
                    public void onSuccess(MainModel model) {
                        mvpView.getMainModelSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getMainModelFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

}
