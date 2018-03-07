package com.facebook.components;

import android.os.Looper;

/* compiled from: geofenceStartTimestampMs */
public class ThreadUtils {
    private ThreadUtils() {
    }

    public static boolean m30578a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void m30579b() {
        if (ComponentsConstants.f22748a && !m30578a()) {
            throw new IllegalStateException("This should run on the main thread.");
        }
    }
}
