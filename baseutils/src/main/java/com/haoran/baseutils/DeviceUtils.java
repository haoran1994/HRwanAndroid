package com.haoran.baseutils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;

/**
 * 获取设备序列号
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class DeviceUtils {

    @SuppressLint("HardwareIds")
    public static String getAndroidId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            return Settings.Secure.getString(Utils.getAppContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return "";
    }

    public static String getSerial(){
        return android.os.Build.SERIAL;
    }

}
