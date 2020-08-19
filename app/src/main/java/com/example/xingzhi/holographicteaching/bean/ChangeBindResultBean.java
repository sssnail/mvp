package com.example.xingzhi.holographicteaching.bean;

public class ChangeBindResultBean extends BaseResultBean {

    private static ChangeBindResultBean instance;
    private ChangeBindData data;


    public synchronized static ChangeBindResultBean getInstance() {
        if (instance == null) {
            instance = new ChangeBindResultBean();
        }
        return instance;
    }

    public ChangeBindData getData() {
        return data;
    }

    public void setData(ChangeBindData data) {
        this.data = data;
    }

    public static class ChangeBindData {
        /**
         * "token": "e27bdfe23b2c0f76e1472e39176f58af"
         * "user_name": "18088888888",
         * "mobile": "18088888888"
         */
        private String token;
        private String user_name;
        private String mobile;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
