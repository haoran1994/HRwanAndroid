package com.haoran.baseutils;

import android.view.KeyEvent;

/**
 * 双击退出
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class DoubleBackUtils {

    private static final long DOUBLE_BACK_PRESSED_TIME = 500;
    private static long LAST_BACK_PRESSED_TIME = 0;

    /**
     * 在{@link android.app.Activity#onKeyDown(int, KeyEvent)}中调用
     * 如果返回true，则表示双击操作成功，应该调用返回操作，及 return super.onKeyDown(keyCode, event);
     * 如果返回false，则表示双击操作失败，应该拦截本次点击操作事件，及 return false;
     */
    public static boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                long nowBackPressedTime = System.currentTimeMillis();
                if ((nowBackPressedTime - LAST_BACK_PRESSED_TIME) > DOUBLE_BACK_PRESSED_TIME) {
                    LAST_BACK_PRESSED_TIME = nowBackPressedTime;
                    return false;
                }
            }
        }
        return true;
    }
}
