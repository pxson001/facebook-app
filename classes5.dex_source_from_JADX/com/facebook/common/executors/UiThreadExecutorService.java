package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;

/* compiled from: spring_cleaning_hovercard */
public class UiThreadExecutorService extends HandlerExecutorServiceImpl {
    private static UiThreadExecutorService f2585a = null;

    private UiThreadExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadExecutorService m3692b() {
        if (f2585a == null) {
            f2585a = new UiThreadExecutorService();
        }
        return f2585a;
    }
}
