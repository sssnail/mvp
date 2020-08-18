//package com.example.xingzhi.holographicteaching.presenter;
//
//import com.example.xingzhi.holographicteaching.base.BasePresenter;
//import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
//import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
//import com.example.xingzhi.holographicteaching.net.ApiCallback;
//import com.example.xingzhi.holographicteaching.view.UserView;
//
//public class RegistPresenter extends BasePresenter<UserView> {
//    public RegistPresenter(UserView view) {
//        attachView(view);
//    }
//
//    public void loadDataByRegist(String user_name, String code, String password,  String invite_code) {
//        mvpView.showLoading();
//        addSubscription(apiStores.RegistRequest(user_name, code, password,invite_code),
//                new ApiCallback<LoginResultBean>() {
//                    @Override
//                    public void onSuccess(LoginResultBean bean) {
//                        mvpView.getUserModelSuccess(bean);
//                    }
//
//                    @Override
//                    public void onFailure(String msg) {
//                        mvpView.getUserModelFail(msg);
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        mvpView.hideLoading();
//                    }
//
//                });
//    }
//    public void sendRegistSMS(String mobile, String type) {
//        mvpView.showLoading();
//        addSubscription(apiStores.SendMsmRequest(mobile, type),
//                new ApiCallback<BaseResultBean>() {
//                    @Override
//                    public void onSuccess(BaseResultBean bean) {
//                        mvpView.sendSMSSuccess(bean);
//                    }
//
//                    @Override
//                    public void onFailure(String msg) {
//                        mvpView.sendSMSFail(msg);
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        mvpView.hideLoading();
//                    }
//
//                });
//    }
//
//}
