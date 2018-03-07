package com.facebook.quicklog.driver.analytics1;

import com.facebook.localstats.LocalStatsLoggerImpl;

/* compiled from: preview_disk_uri */
public class DefaultStatsLogger {
    private final LocalStatsLoggerImpl f4245a;

    public DefaultStatsLogger(LocalStatsLoggerImpl localStatsLoggerImpl) {
        this.f4245a = localStatsLoggerImpl;
    }

    public final void m4777a(int i, short s, long j) {
        this.f4245a.a(i, s, j);
    }
}
