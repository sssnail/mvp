package com.example.xingzhi.holographicteaching.bean;

import java.util.List;

public class HotKeyResultBean extends BaseResultBean {

    private List<HotKeyData> data;

    public List<HotKeyData> getData() {
        return data;
    }

    public void setData(List<HotKeyData> data) {
        this.data = data;
    }

    public static class HotKeyData {
        /**{"keyword": "","count": 250},
         */
        private String keyword;
        private int count;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
