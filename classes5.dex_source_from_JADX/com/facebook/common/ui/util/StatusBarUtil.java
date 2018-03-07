package com.facebook.common.ui.util;

import android.os.Build.VERSION;
import android.view.Window;

/* compiled from: shouldRefetchBroadcastId */
public class StatusBarUtil {
    public static void m3876a(Window window, int i) {
        if (VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(i);
        }
    }
}
