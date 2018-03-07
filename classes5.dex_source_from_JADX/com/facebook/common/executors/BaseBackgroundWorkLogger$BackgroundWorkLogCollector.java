package com.facebook.common.executors;

import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;

/* compiled from: start_time_sentence */
class BaseBackgroundWorkLogger$BackgroundWorkLogCollector implements StatsCollector {
    private final String f2544a;
    private final Object f2545b;
    private final MultiplexBackgroundWorkObserver f2546c;
    private long f2547d = -1;

    public BaseBackgroundWorkLogger$BackgroundWorkLogCollector(MultiplexBackgroundWorkObserver multiplexBackgroundWorkObserver, String str, Object obj) {
        this.f2546c = multiplexBackgroundWorkObserver;
        this.f2544a = str;
        this.f2545b = obj;
    }

    public final void m3667a() {
        this.f2547d = this.f2546c.a.now();
    }

    public final void m3668a(boolean z) {
        this.f2546c.a(this.f2547d, this.f2544a, this.f2545b);
    }
}
