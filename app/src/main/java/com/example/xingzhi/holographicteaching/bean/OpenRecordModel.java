package com.example.xingzhi.holographicteaching.bean;

import java.util.ArrayList;
import java.util.List;

import static com.example.xingzhi.holographicteaching.utils.Utils.getLabels;

public class OpenRecordModel {
    public OpenRecordModel() {

    }

    public List<Object> getData() {
        //模拟一组数据
        OpenRecordBean bean = new OpenRecordBean();
        bean.setCode(1000);
        bean.setMessage("成功");
        bean.setData(getDateBeans());
        return sortData(bean);
    }

    /**
     * 重新整理数据
     *
     * @param bean
     */
    private List<Object> sortData(OpenRecordBean bean) {
        List<OpenRecordBean.DataBean> arrays = bean.getData();
        List<Object> arrays_obj = new ArrayList<>();
        for (OpenRecordBean.DataBean array : arrays) {
            List<ItemListModel.ItemListBean> logs = array.getItemListBeans();
            arrays_obj.add(array.getDateTitle());
            if (logs != null && logs.size() > 0) {
                arrays_obj.addAll(logs);
            }
        }
        return arrays_obj;
    }

    private List<OpenRecordBean.DataBean> getDateBeans() {
        List<OpenRecordBean.DataBean> dataBeans = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
        //精品推荐
            OpenRecordBean.DataBean data1 = new OpenRecordBean.DataBean();
            data1.setType(1);
            data1.setDateTitle("精品推荐");
            data1.setItemListBeans(getLogLists(1));
            //热门游戏
            OpenRecordBean.DataBean data2 = new OpenRecordBean.DataBean();
            data2.setType(2);
            data2.setDateTitle("精品推荐");
            data2.setItemListBeans(getLogLists(1));
            //新游预告
            OpenRecordBean.DataBean data3 = new OpenRecordBean.DataBean();
            data3.setType(3);
            data3.setDateTitle("新游预告");
            data3.setItemListBeans(getLogLists(1));
            //传奇
            OpenRecordBean.DataBean data4 = new OpenRecordBean.DataBean();
            data4.setType(4);
            data4.setDateTitle("传奇");
            data4.setItemListBeans(getLogLists(1));
            //卡牌
            OpenRecordBean.DataBean data5 = new OpenRecordBean.DataBean();
            data5.setType(5);
            data5.setDateTitle("卡牌");
            data5.setItemListBeans(getLogLists(1));
            //三国
            OpenRecordBean.DataBean data6 = new OpenRecordBean.DataBean();
            data6.setType(6);
            data6.setDateTitle("三国");
            data6.setItemListBeans(getLogLists(1));
            //RPG
            OpenRecordBean.DataBean data7 = new OpenRecordBean.DataBean();
            data7.setType(7);
            data7.setDateTitle("RPG");
            data7.setItemListBeans(getLogLists(1));
            //热门类型
            OpenRecordBean.DataBean data8 = new OpenRecordBean.DataBean();
            data8.setType(8);
            data8.setDateTitle("热门类型");
            data8.setItemListBeans(getLogLists(1));

            dataBeans.add(data1);
            dataBeans.add(data2);
            dataBeans.add(data3);
            dataBeans.add(data4);
            dataBeans.add(data5);
            dataBeans.add(data6);
            dataBeans.add(data7);
            dataBeans.add(data8);
//        }
        return dataBeans;
    }

    private List<ItemListModel.ItemListBean> getLogLists(int size) {
        List<ItemListModel.ItemListBean> logs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ItemListModel.ItemListBean logDOListBean = new ItemListModel.ItemListBean( "烈焰主宰", "4.5折", "全方位体验一个不一样的...", "传奇", "传奇9服", 0, getLabels());
            logs.add(logDOListBean);
        }
        return logs;
    }


}
