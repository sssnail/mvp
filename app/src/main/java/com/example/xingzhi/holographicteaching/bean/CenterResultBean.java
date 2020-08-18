package com.example.xingzhi.holographicteaching.bean;

public class CenterResultBean extends BaseResultBean {

    private static CenterResultBean instance;
    private CenterData data;


    public synchronized static CenterResultBean getInstance() {
        if (instance == null) {
            instance = new CenterResultBean();
        }
        return instance;
    }

    public CenterData getData() {
        return data;
    }

    public void setData(CenterData data) {
        this.data = data;
    }

    public static class CenterData {
        /**
         "uid": 94839908,
         "nickname": "yeb7699",
         "avatar": "http://dev.yebimg.8688sdk.com/avatar.jpg",
         "coin": 0,
         "auth": 0,
         "idcard": "**** **** **** **11 11",
         "real_name": "**豆"
         */
        private int uid;
        private String nickname;
        private String avatar;
        private int coin;
        private int auth;
        private String idcard;
        private String real_name;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getAuth() {
            return auth;
        }

        public void setAuth(int auth) {
            this.auth = auth;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }
    }
}
