package com.haoran.baseutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.RequiresPermission;


/**
 * 网络相关处理类
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class NetUtils {
    public static final int TYPE_NONE = -1;
    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_WIFI = 1;

    /**
     * 判断是否有网络
     *
     * @return 返回值
     */
    @RequiresPermission(value = "android.permission.ACCESS_NETWORK_STATE")
    public static boolean isConnected() {
        if (Utils.getAppContext() != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null) {
                    return networkInfo.isConnected();
                }
            }
        }
        return false;
    }


    /**
     * 获取网络状态
     *
     * @return one of TYPE_NONE, TYPE_MOBILE, TYPE_WIFI
     * @permission android.permission.ACCESS_NETWORK_STATE
     */
    public static final int getNetWorkStates() {
        if (Utils.getAppContext() != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            @SuppressLint("MissingPermission") NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return TYPE_NONE;//没网
            }

            int type = activeNetworkInfo.getType();
            switch (type) {
                case ConnectivityManager.TYPE_MOBILE:
                    return TYPE_MOBILE;//移动数据
                case ConnectivityManager.TYPE_WIFI:
                    return TYPE_WIFI;//WIFI
                default:
                    break;
            }
        }
        return TYPE_NONE;
    }

}
