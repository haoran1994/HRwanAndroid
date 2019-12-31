package com.haoran.baseutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.haoran.baseutils.coder.MD5Coder;

import java.util.UUID;


/**
 * 获取设备号
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class DeviceIdUtils {

    private static final String KEY_ID = "id";
    private static final String SP_NAME = "device_id";

    @SuppressLint("HardwareIds")
    @NonNull
    public static String getId() {
        synchronized (DeviceIdUtils.class) {
            SharedPreferences sp = Utils.getAppContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
            String deviceId = sp.getString(KEY_ID, null);
            if (!TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
            String id = DeviceUtils.getAndroidId() + DeviceUtils.getSerial();
            if (TextUtils.isEmpty(id)) {
                id = UUID.randomUUID().toString();
            }
            deviceId = MD5Coder.encode(id);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                sp.edit().putString(KEY_ID, deviceId).apply();
            }
            return deviceId;
        }
    }
}
