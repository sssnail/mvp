package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.MainModel;

/**
 * @explain 视图层示例
 * @author JC.
 * @creat time 2019/10/30 15:24.
 */
public interface MainView extends BaseView {

    void getMainModelSuccess(MainModel model);

    void getMainModelFail(String msg);

}
