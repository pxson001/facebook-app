package com.facebook.ads.internal.util;

import android.support.annotation.NonNull;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class C1992p implements ThreadFactory {
    public final AtomicLong f14360a = new AtomicLong();
    private int f14361b = Thread.currentThread().getPriority();

    public Thread newThread(@NonNull Runnable runnable) {
        Runnable runnable2 = runnable;
        Thread a = ThreadInitDetour.a(null, runnable2, String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f14360a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())}), 0, 910869600);
        a.setPriority(this.f14361b);
        return a;
    }
}
