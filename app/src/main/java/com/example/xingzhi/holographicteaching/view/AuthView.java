package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.AuthResultBean;

/**
 * @explain 视图层示例
 */
public interface AuthView extends BaseView {

    void authSuccess(AuthResultBean bean);

    void authFail(String msg);

}
