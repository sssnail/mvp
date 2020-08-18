package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.CenterResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;

/**
 * @explain 视图层示例
 */
public interface CenterView extends BaseView {

    void getCenterSuccess(CenterResultBean bean);

    void getCenterFail(String msg);

}
