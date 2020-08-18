package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;

/**
 * @explain 视图层示例
 */
public interface ModifiedPwdView extends BaseView {

    void ModifiedPwdSuccess(BaseResultBean bean);

    void ModifiedPwdFail(String msg);

    void sendSMSSuccess(BaseResultBean bean);

    void sendSMSFail(String msg);

}
