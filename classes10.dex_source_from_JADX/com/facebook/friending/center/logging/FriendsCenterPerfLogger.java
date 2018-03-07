package com.facebook.friending.center.logging;

import com.facebook.inject.Assisted;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import javax.inject.Inject;

/* compiled from: agent_quick_replies */
public class FriendsCenterPerfLogger {
    private final PerformanceLogger f19989a;
    private final String f19990b;
    private final int f19991c;
    private final String f19992d;

    @Inject
    public FriendsCenterPerfLogger(PerformanceLogger performanceLogger, @Assisted String str, @Assisted Integer num, @Assisted String str2) {
        this.f19989a = performanceLogger;
        this.f19990b = str;
        this.f19991c = num.intValue();
        this.f19992d = str2;
    }

    public final void m20165a(boolean z) {
        PerformanceLogger performanceLogger = this.f19989a;
        MarkerConfig a = new MarkerConfig(this.f19991c, this.f19992d).a(new String[]{this.f19990b});
        a.n = z;
        performanceLogger.a(a.b(), true);
    }

    public final void m20164a() {
        this.f19989a.c(this.f19991c, this.f19992d);
    }

    public final void m20166b() {
        this.f19989a.f(this.f19991c, this.f19992d);
    }

    public final void m20167c() {
        this.f19989a.a(this.f19991c, this.f19992d);
    }
}
