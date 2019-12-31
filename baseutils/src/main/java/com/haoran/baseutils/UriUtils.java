package com.haoran.baseutils;

import android.net.Uri;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;

/**
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class UriUtils {

    public static Uri getFileUri(File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(Utils.getAppContext(), Utils.getAppContext().getPackageName() + ".file.path.share", file);
        }
        return Uri.fromFile(file);
    }
}
