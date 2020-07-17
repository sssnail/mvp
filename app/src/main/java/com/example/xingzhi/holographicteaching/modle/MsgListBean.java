package com.example.xingzhi.holographicteaching.modle;

import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * Explain
 * Created on 2020/7/14 13:56.
 */
public class MsgListBean extends ViewModel {

    public final List<ItemListBean> itemListBeans;

    public MsgListBean(List<ItemListBean> itemListBeans) {
        this.itemListBeans = itemListBeans;
    }

    public List<ItemListBean> getItemListBeans() {
        return itemListBeans;
    }

    public static class ItemListBean{

        private boolean flag;
        private String title;
        private String time;
        private String content;

        public ItemListBean(boolean flag, String title, String time, String content) {
            this.flag = flag;
            this.title = title;
            this.title = title;
            this.content = content;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }



}
