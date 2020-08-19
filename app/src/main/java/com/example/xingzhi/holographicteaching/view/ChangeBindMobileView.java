package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.ChangeBindResultBean;

/**
 * @explain 视图层示例
 */
public interface ChangeBindMobileView extends BaseView {

    void changeMobileSuccess(ChangeBindResultBean bean);

    void changeMobileFail(String msg);

    void sendSmsSuccess(ChangeBindResultBean bean);

    void sendBindSmsSuccess(BaseResultBean bean);

    void sendSmsFail(String msg);

    void sendBindSmsFail(String msg);

    void bindMobileSuccess(ChangeBindResultBean bean);

    void bindMobileFail(String msg);

}
