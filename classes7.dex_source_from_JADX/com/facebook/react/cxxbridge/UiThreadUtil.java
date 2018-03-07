package com.facebook.react.cxxbridge;

import android.os.Looper;

/* compiled from: gif_picker_giphy_returned_error */
public class UiThreadUtil {
    private static boolean m13678b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void m13677a() {
        SoftAssertions.m13676a(m13678b(), "Expected to run on UI thread!");
    }
}
