package com.example.xingzhi.holographicteaching.bean;

import java.util.List;

public class OpenRecordBean {


    /**
     * code : 1000
     * data : [ {"dateTitle":"xxx","itemListBeans":[{},{},{}]},{"dateTitle":"xxx","itemListBeans":[{},{},{}]} ]}]
     * message : 成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * dateTitle : xxx
         * itemListBeans : [{}，{}，{}]
         */

        private int type;
        private String dateTitle;
        private List<ItemListModel.ItemListBean> itemListBeans;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDateTitle() {
            return dateTitle;
        }

        public void setDateTitle(String dateTitle) {
            this.dateTitle = dateTitle;
        }

        public List<ItemListModel.ItemListBean> getItemListBeans() {
            return itemListBeans;
        }

        public void setItemListBeans(List<ItemListModel.ItemListBean> itemListBeans) {
            this.itemListBeans = itemListBeans;
        }
    }
}
