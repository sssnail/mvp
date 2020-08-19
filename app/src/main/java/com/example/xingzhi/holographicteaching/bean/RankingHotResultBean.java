package com.example.xingzhi.holographicteaching.bean;

import java.util.List;

public class RankingHotResultBean extends BaseResultBean {

    private List<RankingHotData> data;

    public List<RankingHotData> getData() {
        return data;
    }

    public void setData(List<RankingHotData> data) {
        this.data = data;
    }

    public static class RankingHotData {
        /**
         "currentPage": 1,
         "hasMorePage": false,
         "lastPage": 1,
         "onFirstPage": true,
         "perPage": 20,
         "total": 1,
         "items": [ {} ],
         "count": 1,
         "firstItem": 1,
         "lastItem": 1,
         "nextPageUrl": null,
         "previousPageUrl": null
         */
        private int currentPage;
        private boolean hasMorePage;
        private int lastPage;
        private boolean onFirstPage;
        private int perPage;
        private int total;
        private List<RankingItem> items;
        private int count;
        private int firstItem;
        private int lastItem;
        private String nextPageUrl;
        private String previousPageUrl;

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public boolean isHasMorePage() {
            return hasMorePage;
        }

        public void setHasMorePage(boolean hasMorePage) {
            this.hasMorePage = hasMorePage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isOnFirstPage() {
            return onFirstPage;
        }

        public void setOnFirstPage(boolean onFirstPage) {
            this.onFirstPage = onFirstPage;
        }

        public int getPerPage() {
            return perPage;
        }

        public void setPerPage(int perPage) {
            this.perPage = perPage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RankingItem> getItems() {
            return items;
        }

        public void setItems(List<RankingItem> items) {
            this.items = items;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFirstItem() {
            return firstItem;
        }

        public void setFirstItem(int firstItem) {
            this.firstItem = firstItem;
        }

        public int getLastItem() {
            return lastItem;
        }

        public void setLastItem(int lastItem) {
            this.lastItem = lastItem;
        }

        public String getNextPageUrl() {
            return nextPageUrl;
        }

        public void setNextPageUrl(String nextPageUrl) {
            this.nextPageUrl = nextPageUrl;
        }

        public String getPreviousPageUrl() {
            return previousPageUrl;
        }

        public void setPreviousPageUrl(String previousPageUrl) {
            this.previousPageUrl = previousPageUrl;
        }

        public static class RankingItem {
            /**
             * "id": 1,
             * "name": "测试游戏2",
             * "slogan": "",
             * "icon": "http://xx.com/img/app/icon/6243e6a1-897e-4ad0-9ca7-2eaec6b8d15d.png",
             * "tags": "一刀999,成龙大哥,现金红包",
             * "app_type_id": 2,
             * "hot_val": 0,
             * "rebate": "9.0折"
             */
            private int id;
            private String name;
            private String slogan;
            private String icon;
            private String tags;
            private int app_type_id;
            private int hot_val;
            private String rebate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public int getApp_type_id() {
                return app_type_id;
            }

            public void setApp_type_id(int app_type_id) {
                this.app_type_id = app_type_id;
            }

            public int getHot_val() {
                return hot_val;
            }

            public void setHot_val(int hot_val) {
                this.hot_val = hot_val;
            }

            public String getRebate() {
                return rebate;
            }

            public void setRebate(String rebate) {
                this.rebate = rebate;
            }
        }

    }
}
