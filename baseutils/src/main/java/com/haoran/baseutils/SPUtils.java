package com.haoran.baseutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

/**
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class SPUtils {

    private final SharedPreferences sp;

    private static class SPHolder{
        private static final SharedPreferences INSTANCE = PreferenceManager.getDefaultSharedPreferences(Utils.getAppContext());
    }

    private SPUtils(@NonNull String name) {
        sp = getSharedPreferences(name);
    }

    private SPUtils() {
        sp = getDefaultSharedPreferences();
    }

    public static SPUtils newInstance(String name) {
        return new SPUtils(name);
    }

    public static SPUtils getInstance() {
        return new SPUtils();
    }

    private static SharedPreferences getSharedPreferences(@NonNull String name) {
        return Utils.getAppContext().getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    private static SharedPreferences getDefaultSharedPreferences() {
        return SPHolder.INSTANCE;
    }

    private SharedPreferences.Editor getEditor() {
        return sp.edit();
    }

    public SPUtils clear() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            getEditor().clear().apply();
        }
        return this;
    }

    public SPUtils remove(String keyword){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            getEditor().remove(keyword).apply();
        }
        return this;
    }

    public <T> SPUtils save(String keyword, T value) {
        SharedPreferences.Editor editor = getEditor();
        if (value == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.remove(keyword).apply();
            }
        } else if (value instanceof String) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.putString(keyword, (String) value).apply();
            }
        } else if (value instanceof Integer) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.putInt(keyword, (Integer) value).apply();
            }
        } else if (value instanceof Boolean) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.putBoolean(keyword, (Boolean) value).apply();
            }
        } else if (value instanceof Long) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.putLong(keyword, (Long) value).apply();
            }
        } else if (value instanceof Float) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.putFloat(keyword, (Float) value).apply();
            }
        }
        return this;
    }

    public <T> T get(String keyword, T defValue) {
        T value;
        if (defValue instanceof String) {
            String s = sp.getString(keyword, (String) defValue);
            value = (T) s;
        } else if (defValue instanceof Integer) {
            Integer i = sp.getInt(keyword, (Integer) defValue);
            value = (T) i;
        } else if (defValue instanceof Long) {
            Long l = sp.getLong(keyword, (Long) defValue);
            value = (T) l;
        } else if (defValue instanceof Float) {
            Float f = sp.getFloat(keyword, (Float) defValue);
            value = (T) f;
        } else if (defValue instanceof Boolean) {
            Boolean b = sp.getBoolean(keyword, (Boolean) defValue);
            value = (T) b;
        } else {
            value = defValue;
        }
        return value;
    }


}
