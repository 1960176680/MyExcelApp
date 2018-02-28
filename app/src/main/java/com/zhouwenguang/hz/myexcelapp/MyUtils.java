package com.zhouwenguang.hz.myexcelapp;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2018-02-28.
 */

public class MyUtils {

    /**
     * 获得存储文件
     *
     * @param
     * @param
     * @return
     */
    public static File getCacheFile(Context context, String name) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {

//            cachePath = context.getExternalCacheDir().getPath();
//            cachePath = Environment.getExternalStorageDirectory();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
//        return new File(cachePath + File.separator + name);
        return Environment.getExternalStorageDirectory();
    }
}
