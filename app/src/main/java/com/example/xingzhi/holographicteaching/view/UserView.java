package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;

/**
 * @explain 视图层示例
 */
public interface UserView extends BaseView {

    void getUserModelSuccess(LoginResultBean bean);

    void getUserModelFail(String msg);

    void sendSMSSuccess(BaseResultBean bean);

    void sendSMSFail(String msg);

}
