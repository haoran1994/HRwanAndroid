package com.haoran.baseutils;

import android.text.TextUtils;

/**
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class DebugUtils {

    public static boolean isDebug() {
        return BuildConfig.DEBUG && TextUtils.equals(BuildConfig.BUILD_TYPE, "debug");
    }

}
