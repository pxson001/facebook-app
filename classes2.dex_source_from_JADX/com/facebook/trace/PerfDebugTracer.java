package com.facebook.trace;

import com.facebook.common.executors.DefaultHandlerExecutorServiceFactory;
import com.facebook.common.executors.HandlerListeningExecutorServiceImpl;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.quicklog.QuickEvent;
import com.facebook.quicklog.QuickEventListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: uploader required */
public class PerfDebugTracer implements QuickEventListener {
    private static final Class<?> f1587a = PerfDebugTracer.class;
    private static volatile PerfDebugTracer f1588o;
    public final AtomicReference<State> f1589b = new AtomicReference(State.WAIT);
    public final Lazy<DebugTracer> f1590c;
    private final Lazy<DebugTraceUtils> f1591d;
    public final Lazy<DebugTraceRetryData> f1592e;
    private final Lazy<DebugTraceUploader> f1593f;
    public final Lazy<DefaultHandlerExecutorServiceFactory> f1594g;
    public final StopTraceRunnable f1595h = new StopTraceRunnable(this);
    private String f1596i;
    private int f1597j = Integer.MIN_VALUE;
    private String f1598k;
    public String f1599l;
    public long f1600m;
    public HandlerListeningExecutorServiceImpl f1601n;

    /* compiled from: uploader required */
    class StopTraceRunnable implements Runnable {
        final /* synthetic */ PerfDebugTracer f1602a;

        public StopTraceRunnable(PerfDebugTracer perfDebugTracer) {
            this.f1602a = perfDebugTracer;
        }

        public void run() {
            this.f1602a.m3212a();
        }
    }

    /* compiled from: uploader required */
    public enum State {
        WAIT,
        READY,
        TRACING,
        DONE
    }

    public static com.facebook.trace.PerfDebugTracer m3203a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1588o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.trace.PerfDebugTracer.class;
        monitor-enter(r1);
        r0 = f1588o;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3207b(r0);	 Catch:{ all -> 0x0035 }
        f1588o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1588o;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.trace.PerfDebugTracer.a(com.facebook.inject.InjectorLike):com.facebook.trace.PerfDebugTracer");
    }

    private static PerfDebugTracer m3207b(InjectorLike injectorLike) {
        return new PerfDebugTracer(IdBasedSingletonScopeProvider.m1810b(injectorLike, 11435), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3519), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3518), IdBasedSingletonScopeProvider.m1810b(injectorLike, 518), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3517));
    }

    public final void mo490b(QuickEvent quickEvent) {
        mo489a(quickEvent);
    }

    public final void mo493e(QuickEvent quickEvent) {
    }

    @Inject
    public PerfDebugTracer(Lazy<DebugTracer> lazy, Lazy<DebugTraceUtils> lazy2, Lazy<DebugTraceUploader> lazy3, Lazy<DefaultHandlerExecutorServiceFactory> lazy4, Lazy<DebugTraceRetryData> lazy5) {
        this.f1590c = lazy;
        this.f1591d = lazy2;
        this.f1593f = lazy3;
        this.f1594g = lazy4;
        this.f1592e = lazy5;
    }

    public final boolean m3213a(String str, int i, String str2, int i2, long j, int i3, int i4) {
        if (str == null && (i == Integer.MIN_VALUE || str2 == null)) {
            throw new IllegalArgumentException("Error: passed in null for markerNAme and (null for quicklogEvent or 0 for markerID");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("Error: passed in a non-positive trace file size");
        } else if (j <= 0) {
            throw new IllegalArgumentException("Error: passed in a non-positive maximum trace time");
        } else if (!TraceType.a(i4)) {
            throw new IllegalArgumentException("Error: passed in an invalid trace type for trace configuration");
        } else if (i4 == 0 && i3 <= 0) {
            throw new IllegalArgumentException("Error: passed in a non-positive value for sampling interval time");
        } else if (!this.f1589b.compareAndSet(State.WAIT, State.READY)) {
            return false;
        } else {
            this.f1596i = str;
            this.f1597j = i;
            this.f1598k = str2;
            this.f1600m = j;
            DebugTracer debugTracer = (DebugTracer) this.f1590c.get();
            debugTracer.c = i2;
            debugTracer.d = i3;
            debugTracer.e = i4;
            return true;
        }
    }

    public final void mo489a(QuickEvent quickEvent) {
        m3205a(quickEvent.f465g, null);
    }

    public final void mo491c(QuickEvent quickEvent) {
        m3204a(quickEvent.f465g);
    }

    public final void mo492d(QuickEvent quickEvent) {
        m3208b(quickEvent.f465g);
    }

    private boolean m3205a(int i, String str) {
        if (m3209b(i, str)) {
            Object obj;
            if (((DebugTraceRetryData) this.f1592e.get()).b() >= 3) {
                obj = null;
            } else if (this.f1589b.compareAndSet(State.READY, State.TRACING)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                boolean z;
                DebugTraceUtils debugTraceUtils = (DebugTraceUtils) this.f1591d.get();
                String str2 = this.f1598k;
                String c = debugTraceUtils.d.m2365c();
                if (c == null) {
                    c = null;
                } else {
                    c = c + "/" + debugTraceUtils.f.mo211a() + "_" + str2 + ".trace";
                }
                this.f1599l = c;
                if (((DebugTracer) this.f1590c.get()).a(this.f1599l)) {
                    if (this.f1601n == null) {
                        this.f1601n = (HandlerListeningExecutorServiceImpl) ((DefaultHandlerExecutorServiceFactory) this.f1594g.get()).m32066a("StopTraceRunnable", ThreadPriority.URGENT, false);
                    }
                    this.f1601n.mo310a(this.f1595h, this.f1600m, TimeUnit.MILLISECONDS);
                    DebugTraceRetryData debugTraceRetryData = (DebugTraceRetryData) this.f1592e.get();
                    debugTraceRetryData.a.edit().putInt("DebugTraceRetryKey", debugTraceRetryData.b() + 1).commit();
                    z = true;
                } else {
                    this.f1589b.set(State.READY);
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    private boolean m3204a(int i) {
        if (m3209b(i, null) && m3210d()) {
            return m3206a(true);
        }
        return false;
    }

    private boolean m3208b(int i) {
        if (m3209b(i, null) && m3210d()) {
            return m3206a(false);
        }
        return false;
    }

    public final boolean m3212a() {
        if (this.f1589b.compareAndSet(State.TRACING, State.DONE)) {
            return m3206a(false);
        }
        return false;
    }

    private boolean m3206a(boolean z) {
        ((DebugTracer) this.f1590c.get()).a();
        HandlerDetour.a(this.f1601n.f966a, this.f1595h);
        if (z) {
            ((DebugTraceRetryData) this.f1592e.get()).a.edit().putBoolean("DebugTraceFinishedKey", true).commit();
            ((DebugTraceUploader) this.f1593f.get()).a();
        } else {
            DebugTraceUtils debugTraceUtils = (DebugTraceUtils) this.f1591d.get();
            File file = new File(this.f1599l);
            if (!file.delete()) {
                debugTraceUtils.g.a(file);
                BLog.a(DebugTraceUtils.a, "Error: failed to delete traceFile %s", new Object[]{file.getName()});
            }
        }
        if (this.f1589b.compareAndSet(State.DONE, State.WAIT)) {
            return true;
        }
        BLog.b(f1587a, "PerfDebugTracer state should be DONE, but isn't in internalStopTrace()");
        return false;
    }

    private boolean m3210d() {
        if (this.f1589b.compareAndSet(State.TRACING, State.DONE)) {
            return true;
        }
        return false;
    }

    private boolean m3209b(int i, @Nullable String str) {
        boolean z;
        if (str == null || str.equals(this.f1596i)) {
            z = true;
        } else {
            z = false;
        }
        return i == this.f1597j && this.f1598k != null && z;
    }

    public final void m3214b() {
        this.f1589b.compareAndSet(State.READY, State.WAIT);
    }
}
