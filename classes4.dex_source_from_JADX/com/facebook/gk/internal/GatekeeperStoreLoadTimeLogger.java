package com.facebook.gk.internal;

import com.facebook.common.init.INeedInit;
import com.facebook.gk.storelogger.TraceGatekeeperStoreLogger;
import com.facebook.quicklog.QuickPerformanceLogger;
import javax.inject.Inject;

/* compiled from: is_upgrade */
public class GatekeeperStoreLoadTimeLogger implements INeedInit {
    private QuickPerformanceLogger f9780a;
    private TraceGatekeeperStoreLogger f9781b;

    @Inject
    public GatekeeperStoreLoadTimeLogger(QuickPerformanceLogger quickPerformanceLogger, TraceGatekeeperStoreLogger traceGatekeeperStoreLogger) {
        this.f9780a = quickPerformanceLogger;
        this.f9781b = traceGatekeeperStoreLogger;
    }

    public void init() {
        if (this.f9781b != null) {
            this.f9780a.b(7340035, 1000);
            QuickPerformanceLogger quickPerformanceLogger = this.f9780a;
            TraceGatekeeperStoreLogger traceGatekeeperStoreLogger = this.f9781b;
            quickPerformanceLogger.a(7340035, (short) 2, (int) (traceGatekeeperStoreLogger.c - traceGatekeeperStoreLogger.b));
        }
    }
}
