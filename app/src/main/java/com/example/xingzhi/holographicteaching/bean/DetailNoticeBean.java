package com.example.xingzhi.holographicteaching.bean;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class DetailNoticeBean extends ViewModel {

    public final List<AcNoticeBean> itemListBeans;

    public DetailNoticeBean(List<AcNoticeBean> acNoticeBeans) {
        this.itemListBeans = acNoticeBeans;
    }

    public List<AcNoticeBean> getItemListBeans() {
        return itemListBeans;
    }

    public static class AcNoticeBean {
        private int type;
        private String title;
        private String timeValid;

        public AcNoticeBean(int type, String title, String timeValid) {
            this.type = type;
            this.title = title;
            this.timeValid = timeValid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTimeValid() {
            return timeValid;
        }

        public void setTimeValid(String timeValid) {
            this.timeValid = timeValid;
        }
    }



}
