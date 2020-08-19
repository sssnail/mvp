package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.HotKeyResultBean;

/**
 * @explain 视图层示例
 */
public interface HotKeywordView extends BaseView {

    void getHotKeySuccess(HotKeyResultBean bean);

    void getHotKeyFail(String msg);

}
