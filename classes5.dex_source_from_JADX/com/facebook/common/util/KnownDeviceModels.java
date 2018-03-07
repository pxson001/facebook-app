package com.facebook.common.util;

import android.os.Build;

/* compiled from: share_preview_icon_image */
public class KnownDeviceModels {
    public static boolean m3902a(String str) {
        return Build.MODEL.contentEquals(str);
    }

    public static boolean m3903a(String... strArr) {
        for (String a : strArr) {
            if (m3902a(a)) {
                return true;
            }
        }
        return false;
    }
}
