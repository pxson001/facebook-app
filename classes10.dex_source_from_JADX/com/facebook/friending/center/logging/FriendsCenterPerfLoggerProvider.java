package com.facebook.friending.center.logging;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;

/* compiled from: age_seconds */
public class FriendsCenterPerfLoggerProvider extends AbstractAssistedProvider<FriendsCenterPerfLogger> {
    public final FriendsCenterPerfLogger m20168a(String str, Integer num, String str2) {
        return new FriendsCenterPerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(this), str, num, str2);
    }
}
