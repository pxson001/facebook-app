package com.facebook.common.executors;

import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.systrace.Systrace;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: reactors_profile_image_size */
class LoggingRunnable implements ProvidesName, Runnable {
    private static final AtomicInteger f7970a = new AtomicInteger(0);
    private final Runnable f7971b;
    private final String f7972c;
    private final String f7973d;
    private final int f7974e;
    private final StatsCollector f7975f;

    public static Runnable m12548a(Runnable runnable, BackgroundWorkLogger backgroundWorkLogger, String str) {
        if (!backgroundWorkLogger.mo231a()) {
            return runnable;
        }
        int addAndGet = f7970a.addAndGet(1);
        Systrace.d(128, str, addAndGet);
        return new LoggingRunnable(runnable, backgroundWorkLogger, str, addAndGet);
    }

    private LoggingRunnable(Runnable runnable, BackgroundWorkLogger backgroundWorkLogger, String str, int i) {
        this.f7971b = runnable;
        this.f7972c = LoggingUtils.a(runnable);
        this.f7975f = backgroundWorkLogger.mo229a(str, this.f7972c);
        this.f7973d = str;
        this.f7974e = i;
    }

    public void run() {
        boolean z = true;
        z = false;
        boolean z2 = this.f7975f != null;
        if (z2) {
            this.f7975f.mo2832a();
        }
        try {
            Systrace.e(128, this.f7973d, this.f7974e);
            this.f7971b.run();
        } finally {
            if (z2) {
                this.f7975f.mo2833a(z);
            }
        }
    }

    public final String mo502a() {
        return this.f7972c;
    }
}
