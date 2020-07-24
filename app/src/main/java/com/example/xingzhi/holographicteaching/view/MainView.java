package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.MainModel;

/**
 * @explain 视图层示例
 */
public interface MainView extends BaseView {

    void getMainModelSuccess(MainModel model);

    void getMainModelFail(String msg);

}
