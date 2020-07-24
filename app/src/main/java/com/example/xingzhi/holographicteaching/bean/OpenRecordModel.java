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
        for (int i = 0; i < 6; i++) {
            OpenRecordBean.DataBean dataBean = new OpenRecordBean.DataBean();
            dataBean.setDateTitle("精品推荐");
            dataBean.setItemListBeans(getLogLists(i+1));
            dataBeans.add(dataBean);
        }
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
