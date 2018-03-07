package com.facebook.fbreact.fb4a;

import com.facebook.fbreact.eventsperf.EventsPerfLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: extra_viewer_context */
public class Fb4aReactPerfFlagListener {
    public final EventsPerfLogger f7317a;
    public final QuickPerformanceLogger f7318b;

    public static Fb4aReactPerfFlagListener m8512a(InjectorLike injectorLike) {
        return new Fb4aReactPerfFlagListener(EventsPerfLogger.m8493a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public Fb4aReactPerfFlagListener(EventsPerfLogger eventsPerfLogger, QuickPerformanceLogger quickPerformanceLogger) {
        this.f7317a = eventsPerfLogger;
        this.f7318b = quickPerformanceLogger;
    }
}
