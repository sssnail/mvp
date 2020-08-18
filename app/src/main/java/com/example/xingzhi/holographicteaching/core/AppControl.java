package com.example.xingzhi.holographicteaching.core;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.xingzhi.holographicteaching.utils.Utils;


public class AppControl {
    public static final String PRFS_USER_TOKEN = "prfs_user_token";

    protected static String mUserToken = "";

    public static void saveUserToken(String userToken) {
        if (!TextUtils.isEmpty(userToken)) {
            mUserToken = userToken;
            Utils.getMMKV().encode(PRFS_USER_TOKEN, mUserToken);
        }
    }

    public static String getUserToken() {
        return mUserToken;
    }

    public static boolean isLogin() {
        return !TextUtils.isEmpty(getUserToken());
    }

    public static void clearLogin() {
        mUserToken = null;
        Utils.getMMKV().removeValueForKey(PRFS_USER_TOKEN);
    }

}
