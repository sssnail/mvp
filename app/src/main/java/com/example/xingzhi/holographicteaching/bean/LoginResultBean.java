package com.example.xingzhi.holographicteaching.bean;

import android.app.Activity;

import com.example.xingzhi.holographicteaching.view.ActivityStackManager;

public class LoginResultBean extends BaseResultBean {

    private static LoginResultBean instance;
    private LoginData data;

    public synchronized static LoginResultBean getInstance() {
        if (instance == null) {
            instance = new LoginResultBean();
        }
        return instance;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }

    public static class LoginData{
        /**
         "user_id": 94839908,
         "user_name": "18016027699",
         "user_key": "qW68kr",
         "nickname": "test",
         "avatar": "http://dev.yebimg.8688sdk.com/yeb/avatar.png",
         "mobile": "18016027699",
         "coin": 0,
         "vip": 1,
         "vip_menu": 0,
         "is_auth": 0,
         "token": "d6e904c9-0737-4c87-af5f-19bad4b03f55"
         */
        private int user_id;
        private String user_name;
        private String user_key;
        private String nickname;
        private String avatar;
        private String mobile;
        private int coin;
        private int vip;
        private int vip_menu;
        private int is_auth;
        private String token;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_key() {
            return user_key;
        }

        public void setUser_key(String user_key) {
            this.user_key = user_key;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getVip() {
            return vip;
        }

        public void setVip(int vip) {
            this.vip = vip;
        }

        public int getVip_menu() {
            return vip_menu;
        }

        public void setVip_menu(int vip_menu) {
            this.vip_menu = vip_menu;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
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

        public int getIs_auth() {
            return is_auth;
        }

        public void setIs_auth(int is_auth) {
            this.is_auth = is_auth;
        }
    }
}
