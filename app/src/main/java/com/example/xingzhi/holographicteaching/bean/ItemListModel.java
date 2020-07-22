package com.example.xingzhi.holographicteaching.bean;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class ItemListModel extends ViewModel {

    public final List<ItemListBean> itemListBeans;

    public ItemListModel(List<ItemListBean> itemListBeans) {
        this.itemListBeans = itemListBeans;
    }

    public List<ItemListBean> getItemListBeans() {
        return itemListBeans;
    }

    public static class ItemListBean{
        private String title;
        private String discount;
        private String content;
        private String intro;
        private String footprint;
        private int type;

        public ItemListBean(String title, String discount, String content, String intro, String footprint, int type) {
            this.title = title;
            this.discount = discount;
            this.content = content;
            this.intro = intro;
            this.footprint = footprint;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getFootprint() {
            return footprint;
        }

        public void setFootprint(String footprint) {
            this.footprint = footprint;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }



}
