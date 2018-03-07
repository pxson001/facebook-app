package com.facebook.proxygen.utils;

import com.facebook.proxygen.utils.GLogHandler.GLogSeverity;

/* compiled from: publishPostParams */
public class GLogHelper {
    private static native void log(int i, String str);

    public static native void vlog(int i, String str);

    public static void log(GLogSeverity gLogSeverity, String str) {
        log(gLogSeverity.ordinal(), str);
    }
}
