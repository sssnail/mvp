package com.example.xingzhi.holographicteaching.view;
import com.example.xingzhi.holographicteaching.bean.VipIndexResultBean;

/**
 * @explain 视图层示例
 */
public interface VipIndexView extends BaseView {

    void getVipIndexSuccess(VipIndexResultBean bean);

    void getVipIndexFail(String msg);

}
