package com.facebook.debug.fps;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.NamedRunnable;

/* compiled from: _UNIQUE_NAME_ */
public class TouchDelayLogger$TouchDelayRunnable extends NamedRunnable {
    final /* synthetic */ TouchDelayLogger f11788c;
    private final long f11789d;

    public TouchDelayLogger$TouchDelayRunnable(TouchDelayLogger touchDelayLogger, long j) {
        this.f11788c = touchDelayLogger;
        super(TouchDelayLogger$TouchDelayRunnable.class, "TouchDelayRunnable");
        this.f11789d = j;
    }

    public void run() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("feed_touch_perf");
        honeyClientEvent.b("action", this.f11788c.d);
        honeyClientEvent.a("touch_delay", this.f11789d);
        this.f11788c.c.a(honeyClientEvent);
    }
}
