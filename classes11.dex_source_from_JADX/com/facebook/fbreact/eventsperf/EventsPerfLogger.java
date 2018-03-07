package com.facebook.fbreact.eventsperf;

import com.facebook.common.logging.FLog;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: f83b8f451988308a64c914ba764fa6d1 */
public class EventsPerfLogger {
    private static volatile EventsPerfLogger f7279d;
    public final MonotonicClock f7280a;
    public final QuickPerformanceLogger f7281b;
    public final QeManager f7282c;

    public static com.facebook.fbreact.eventsperf.EventsPerfLogger m8493a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7279d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.eventsperf.EventsPerfLogger.class;
        monitor-enter(r1);
        r0 = f7279d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8497b(r0);	 Catch:{ all -> 0x0035 }
        f7279d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7279d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.eventsperf.EventsPerfLogger.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.eventsperf.EventsPerfLogger");
    }

    private static EventsPerfLogger m8497b(InjectorLike injectorLike) {
        return new EventsPerfLogger((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), (QeManager) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventsPerfLogger(MonotonicClock monotonicClock, QuickPerformanceLogger quickPerformanceLogger, QeManager qeManager) {
        this.f7280a = monotonicClock;
        this.f7281b = quickPerformanceLogger;
        this.f7282c = qeManager;
    }

    public final void m8500a(long j, long j2) {
        if (m8499d()) {
            this.f7281b.markerStart(393247, 0, j2);
            if (j != 0) {
                this.f7281b.b(393240, "bridgeStartupTime", String.valueOf(j2 - j));
            }
        }
    }

    public final void m8502c() {
        if (this.f7281b.d(393247, 0) != 0) {
            this.f7281b.b(393247, (short) 2);
            this.f7281b.b(393240, "bridgeStartupType", "cold");
        } else {
            this.f7281b.b(393240, "bridgeStartupType", "warm");
        }
        m8495a(this.f7280a.now(), 393244, "nativeTimeAfterJS");
        this.f7281b.b(393240, (short) 2);
    }

    public final void m8501a(ReadableMap readableMap) {
        this.f7281b.b(393240, "tag", readableMap.hasKey("tag") ? readableMap.getString("tag") : "None");
        ReadableMap b = readableMap.b("extras");
        Object obj = (b.hasKey("fetchedFromCache") && b.getBoolean("fetchedFromCache")) ? 1 : null;
        this.f7281b.b(393240, "cacheFetch", obj != null ? "true" : "false");
        if (b.hasKey("bytecodeCacheStats")) {
            QuickPerformanceLogger quickPerformanceLogger = this.f7281b;
            ReadableMap b2 = b.b("bytecodeCacheStats");
            quickPerformanceLogger.b(393240, "bytecode_cache_size_on_start", String.valueOf(b2.getDouble("size_on_start")));
            quickPerformanceLogger.b(393240, "bytecode_cache_current_size", String.valueOf(b2.getDouble("current_size")));
            quickPerformanceLogger.b(393240, "bytecode_cache_commits", String.valueOf(b2.getDouble("commits")));
            quickPerformanceLogger.b(393240, "bytecode_cache_drops", String.valueOf(b2.getDouble("drops")));
            quickPerformanceLogger.b(393240, "bytecode_cache_writes", String.valueOf(b2.getDouble("writes")));
            quickPerformanceLogger.b(393240, "bytecode_cache_reads", String.valueOf(b2.getDouble("reads")));
            quickPerformanceLogger.b(393240, "bytecode_cache_read_only", String.valueOf(b2.getBoolean("read_only")));
        }
        this.f7281b.b(393240, "qe_group", this.f7282c.b(Authority.EFFECTIVE, "fb4a_react_events"));
        m8498c(readableMap.b("timespans"));
    }

    private boolean m8499d() {
        return this.f7281b.d(393240, 0) != 0;
    }

    private void m8498c(ReadableMap readableMap) {
        if (readableMap.hasKey("fetchRelayQuery")) {
            m8496a(readableMap, "fetchRelayQuery", 393245);
        }
        if (readableMap.hasKey("fetchRelayCache")) {
            m8496a(readableMap, "fetchRelayCache", 393246);
        }
        ReadableMapKeySetIterator a = readableMap.a();
        while (a.hasNextKey()) {
            long j;
            long j2;
            String nextKey = a.nextKey();
            ReadableMap b = readableMap.b(nextKey);
            long j3 = b.hasKey("startTime") ? (long) b.getDouble("startTime") : -1;
            if (b.hasKey("endTime")) {
                j = (long) b.getDouble("endTime");
            } else {
                j = -1;
            }
            if (b.hasKey("totalTime")) {
                j2 = (long) b.getDouble("totalTime");
            } else {
                j2 = -1;
            }
            int i = -1;
            if ("JSAppRequireTime".equals(nextKey)) {
                i = 393242;
                if (j3 != -1) {
                    m8495a(j3, 393241, "nativeTimeBeforeJS");
                }
            } else if ("JSTime".equals(nextKey)) {
                i = 393243;
                if (j != -1) {
                    this.f7281b.markerStart(393244, 0, j);
                }
            } else if (!("fetchRelayQuery".equals(nextKey) || "fetchRelayCache".equals(nextKey))) {
                FLog.a("React", "Unknown event logged: " + nextKey);
            }
            m8494a(i, j3, j, j2, nextKey);
        }
    }

    private void m8496a(ReadableMap readableMap, String str, int i) {
        long j;
        long j2;
        ReadableMap b = readableMap.b(str);
        long j3 = b.hasKey("startTime") ? (long) b.getDouble("startTime") : -1;
        if (b.hasKey("endTime")) {
            j = (long) b.getDouble("endTime");
        } else {
            j = -1;
        }
        if (b.hasKey("totalTime")) {
            j2 = (long) b.getDouble("totalTime");
        } else {
            j2 = -1;
        }
        m8494a(i, j3, j, j2, str);
    }

    private void m8494a(int i, long j, long j2, long j3, String str) {
        if (i == -1) {
            return;
        }
        if (j != -1 && j2 != -1) {
            this.f7281b.markerStart(i, 0, j);
            this.f7281b.markerEnd(i, 0, (short) 2, j2);
            this.f7281b.b(393240, str, String.valueOf(j2 - j));
        } else if (j3 != -1) {
            this.f7281b.a(i, (short) 2, (int) j3);
            this.f7281b.b(393240, str, String.valueOf(j3));
        } else {
            FLog.a("React", "Marker " + str + " has incomplete data " + j + ", " + j2 + ", " + j3);
        }
    }

    private void m8495a(long j, int i, String str) {
        long d = this.f7281b.d(i, 0);
        if (d != 0) {
            this.f7281b.b(393240, str, String.valueOf(j - d));
        }
        this.f7281b.a(i, (short) 2, j);
    }
}
