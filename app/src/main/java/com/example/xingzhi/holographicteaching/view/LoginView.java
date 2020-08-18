package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.LoginResultBean;

/**
 * @explain 视图层示例
 */
public interface LoginView extends BaseView {

    void getLoginModelSuccess(LoginResultBean bean);

    void getLoginModelFail(String msg);

}
