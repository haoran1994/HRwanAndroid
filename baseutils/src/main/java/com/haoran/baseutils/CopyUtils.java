package com.haoran.baseutils;

import android.content.ClipboardManager;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * 复制到粘贴板
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class CopyUtils {

    public static void copyText(@NonNull String text) {
        ClipboardManager clipboardManager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            clipboardManager = (ClipboardManager) Utils.getAppContext().getSystemService(Context.CLIPBOARD_SERVICE);
        }
        clipboardManager.setText(text);
    }

    public static void copyText(@NonNull TextView textView) {
        copyText(textView.getText().toString());
    }
}
