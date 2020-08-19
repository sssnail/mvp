package com.example.xingzhi.holographicteaching.view;

import com.example.xingzhi.holographicteaching.bean.RankingHotResultBean;

/**
 * @explain 视图层示例
 */
public interface RankingHotView extends BaseView {

    void getRankingHotSuccess(RankingHotResultBean bean);

    void getRankingHotFail(String msg);

}
