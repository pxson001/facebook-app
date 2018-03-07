package com.facebook.common.util;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/* compiled from: share_story */
public class DeviceUtil {
    public static boolean m3897a(PackageManager packageManager, String str) {
        try {
            packageManager.getPackageInfo(str, 128);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
