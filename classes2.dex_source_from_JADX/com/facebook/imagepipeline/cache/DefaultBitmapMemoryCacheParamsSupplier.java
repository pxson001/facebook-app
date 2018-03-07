package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import com.facebook.common.internal.Supplier;

/* compiled from: orca_visibility_updates */
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public final ActivityManager f10832a;

    public final Object mo2058a() {
        int min = Math.min(this.f10832a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (min < 33554432) {
            min = 4194304;
        } else if (min < 67108864) {
            min = 6291456;
        } else if (VERSION.SDK_INT < 11) {
            min = 8388608;
        } else {
            min /= 4;
        }
        return new MemoryCacheParams(min, 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        this.f10832a = activityManager;
    }
}
