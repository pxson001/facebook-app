package com.facebook.react.bridge;

import android.os.Handler;
import android.os.Looper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;

/* compiled from: gif_picker_giphy_returned_error */
public class UiThreadUtil {
    @Nullable
    private static Handler f11549a;

    public static boolean m13553a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void m13554b() {
        SoftAssertions.m13551a(m13553a(), "Expected to run on UI thread!");
    }

    public static void m13552a(Runnable runnable) {
        synchronized (UiThreadUtil.class) {
            if (f11549a == null) {
                f11549a = new Handler(Looper.getMainLooper());
            }
        }
        HandlerDetour.a(f11549a, runnable, 1865100480);
    }
}
