package com.example.xingzhi.holographicteaching.bean;

import android.service.autofill.UserData;

import java.util.List;

public class VipIndexResultBean extends BaseResultBean {

    private VipIndexData data;

    public VipIndexData getData() {
        return data;
    }

    public void setData(VipIndexData data) {
        this.data = data;
    }

    public static class VipIndexData {
        /**
         "user": { },
         "thrift": 0,
         "friend": 1,
         "vip_friend": 0,
         "today_friend": 0,
         "today_vip_friend": 0,
         "today_income": 0,
         "money_income": 0,
         "total_income": 0,
         "interest": { }
         }
         */
        private userData user;
        private int thrift;
        private int friend;
        private int vip_friend;
        private int today_friend;
        private int today_vip_friend;
        private int today_income;
        private int money_income;
        private int total_income;
        private List<InterestData> interest;

        public userData getUser() {
            return user;
        }

        public void setUser(userData user) {
            this.user = user;
        }

        public int getThrift() {
            return thrift;
        }

        public void setThrift(int thrift) {
            this.thrift = thrift;
        }

        public int getFriend() {
            return friend;
        }

        public void setFriend(int friend) {
            this.friend = friend;
        }

        public int getVip_friend() {
            return vip_friend;
        }

        public void setVip_friend(int vip_friend) {
            this.vip_friend = vip_friend;
        }

        public int getToday_friend() {
            return today_friend;
        }

        public void setToday_friend(int today_friend) {
            this.today_friend = today_friend;
        }

        public int getToday_vip_friend() {
            return today_vip_friend;
        }

        public void setToday_vip_friend(int today_vip_friend) {
            this.today_vip_friend = today_vip_friend;
        }

        public int getToday_income() {
            return today_income;
        }

        public void setToday_income(int today_income) {
            this.today_income = today_income;
        }

        public int getMoney_income() {
            return money_income;
        }

        public void setMoney_income(int money_income) {
            this.money_income = money_income;
        }

        public int getTotal_income() {
            return total_income;
        }

        public void setTotal_income(int total_income) {
            this.total_income = total_income;
        }

        public List<InterestData> getInterest() {
            return interest;
        }

        public void setInterest(List<InterestData> interest) {
            this.interest = interest;
        }

        public static class userData{
            /**
             "uid": 94839908,
             "user_key": "qW68kr",
             "avatar": "http://dev.yebimg.8688sdk.com/yeb/avatar.png",
             "nickname": "test",
             "vip": 1,
             "amount": 0
             */
            private int uid;
            private String user_key;
            private String avatar;
            private String nickname;
            private int vip;
            private int amount;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getUser_key() {
                return user_key;
            }

            public void setUser_key(String user_key) {
                this.user_key = user_key;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getVip() {
                return vip;
            }

            public void setVip(int vip) {
                this.vip = vip;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }
        }

        public static class InterestData{
            /**
             * "app_type": [{}, {}],
             * "invite_rate": "40%",
             * "p_rate": "10%",
             * "g_rate": "20%"
             */
            private List<AppTypeData> app_type;
            private String invite_rate;
            private String p_rate;
            private String g_rate;

            public List<AppTypeData> getApp_type() {
                return app_type;
            }

            public void setApp_type(List<AppTypeData> app_type) {
                this.app_type = app_type;
            }

            public String getInvite_rate() {
                return invite_rate;
            }

            public void setInvite_rate(String invite_rate) {
                this.invite_rate = invite_rate;
            }

            public String getP_rate() {
                return p_rate;
            }

            public void setP_rate(String p_rate) {
                this.p_rate = p_rate;
            }

            public String getG_rate() {
                return g_rate;
            }

            public void setG_rate(String g_rate) {
                this.g_rate = g_rate;
            }

            public static class AppTypeData{
                /**
                 *  "name": "A类",
                 *  "rate": "60%",
                 *  "rebate": "4.0折"
                 */
                private String name;
                private String rate;
                private String rebate;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getRate() {
                    return rate;
                }

                public void setRate(String rate) {
                    this.rate = rate;
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
}
