package com.example.xingzhi.holographicteaching.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ActivityStackManager {
    private static final String TAG = ActivityStackManager.class.getSimpleName();
    private static List<Activity> uiStackList = Collections.synchronizedList(new ArrayList<Activity>());
    private static List<Activity> backupViewUi = new ArrayList<Activity>();
    private static ActivityStackManager instance;
    private Activity mActivity;

    public synchronized static ActivityStackManager getInstance(Activity activity) {
        if (instance == null) {
            instance = new ActivityStackManager(activity);
        }
        return instance;
    }

    private ActivityStackManager(Activity activity) {
        this.mActivity = activity;
    }

    public void finishAllActivities() {
        for (Activity activity : backupViewUi) {
            if (activity != null){
                activity.finish();
            }
        }
        clear();
    }

    public static boolean isLastView() {
        return uiStackList.size() == 1;
    }

    public void addBackupView(Activity activity) {
        backupViewUi.add(activity);
    }

    public void clear() {
        uiStackList.clear();
        backupViewUi.clear();
        instance = null;
    }

    public void removeTopView() {
        if (uiStackList.size() > 1) {
            int index = uiStackList.size() - 1;
            Activity activity = uiStackList.get(index);
            removeView(activity);
        } else {//没有了
            if (mActivity != null) {
                mActivity.finish();
            }
        }
    }

    /**
     * 移除view显示最上面一个view,没有view则关闭页面
     *
     */
    public void removeView(Activity activity) {
        uiStackList.remove(activity);
    }
}
