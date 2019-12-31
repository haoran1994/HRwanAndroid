package com.haoran.baseutils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import com.haoran.baseutils.bitmap.BitmapUtils;

import java.io.File;


/**
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class ShareUtils {

    public static void shareBitmap(Context context, Bitmap bitmap) {
        File file = BitmapUtils.saveBitmapToCache(bitmap);
        bitmap.recycle();
        if (file == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, UriUtils.getFileUri(file));
        intent = Intent.createChooser(intent, "");
        context.startActivity(intent);
    }
}
