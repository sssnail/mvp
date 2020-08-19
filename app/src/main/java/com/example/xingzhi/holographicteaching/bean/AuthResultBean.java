package com.example.xingzhi.holographicteaching.bean;

public class AuthResultBean extends BaseResultBean {

    private AuthData data;

    public AuthData getData() {
        return data;
    }

    public void setData(AuthData data) {
        this.data = data;
    }

    public static class AuthData {
        /**
         * "real_name": "**豆",
         " idcard": "**** **** **** **11 11"
         */
        private String real_name;
        private String idcard;

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
