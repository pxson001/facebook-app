package com.facebook.messaging.camerautil;

import android.os.Environment;
import android.os.StatFs;

/* compiled from: messenger_save_video_start */
public class MenuHelper {
    private static final Class<?> f9687a = MenuHelper.class;

    public static int m10278a() {
        try {
            if (!ImageManager.m10274a()) {
                return -1;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().toString());
            return (int) ((((float) statFs.getAvailableBlocks()) * ((float) statFs.getBlockSize())) / 1500000.0f);
        } catch (Exception e) {
            return -2;
        }
    }
}
