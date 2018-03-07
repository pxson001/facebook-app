package com.facebook.video.server;

import com.facebook.common.executors.C0061x63d21d68;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: offline_mode */
public class TimeoutStreamHelper {
    private static volatile TimeoutStreamHelper f11415g;
    private final ScheduledExecutorService f11416a;
    public final QeAccessor f11417b;
    public final MonotonicClock f11418c;
    private final MonitoringRunnable f11419d = new MonitoringRunnable(this);
    @GuardedBy("this")
    public final List<TimeoutOutputStream> f11420e = new ArrayList();
    @GuardedBy("this")
    private ScheduledFuture<?> f11421f;

    /* compiled from: offline_mode */
    class MonitoringRunnable implements Runnable {
        final /* synthetic */ TimeoutStreamHelper f11422a;
        private int f11423b;

        public MonitoringRunnable(TimeoutStreamHelper timeoutStreamHelper) {
            this.f11422a = timeoutStreamHelper;
        }

        public void run() {
            int a = this.f11422a.f11417b.mo572a(ExperimentsForVideoServerModule.b, 10000);
            synchronized (this.f11422a) {
                m16719a();
                for (TimeoutOutputStream a2 : this.f11422a.f11420e) {
                    a2.a((long) a);
                }
            }
        }

        private void m16719a() {
            if (this.f11422a.f11420e.isEmpty()) {
                int i = this.f11423b;
                this.f11423b = i + 1;
                if (i > 10) {
                    TimeoutStreamHelper.m16716b(this.f11422a);
                    return;
                }
                return;
            }
            this.f11423b = 0;
        }
    }

    public static com.facebook.video.server.TimeoutStreamHelper m16713a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11415g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.server.TimeoutStreamHelper.class;
        monitor-enter(r1);
        r0 = f11415g;	 Catch:{ all -> 0x003a }
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
        r0 = m16715b(r0);	 Catch:{ all -> 0x0035 }
        f11415g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11415g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.TimeoutStreamHelper.a(com.facebook.inject.InjectorLike):com.facebook.video.server.TimeoutStreamHelper");
    }

    private static TimeoutStreamHelper m16715b(InjectorLike injectorLike) {
        return new TimeoutStreamHelper(C0061x63d21d68.m2106b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public TimeoutStreamHelper(ScheduledExecutorService scheduledExecutorService, QeAccessor qeAccessor, MonotonicClock monotonicClock) {
        this.f11416a = scheduledExecutorService;
        this.f11417b = qeAccessor;
        this.f11418c = monotonicClock;
    }

    public final synchronized OutputStream m16717a(OutputStream outputStream) {
        if (this.f11417b.mo596a(ExperimentsForVideoServerModule.a, false)) {
            TimeoutOutputStream timeoutOutputStream = new TimeoutOutputStream(this, outputStream);
            this.f11420e.add(timeoutOutputStream);
            m16714a();
            outputStream = timeoutOutputStream;
        }
        return outputStream;
    }

    public final synchronized void m16718b(OutputStream outputStream) {
        this.f11420e.remove(outputStream);
    }

    private synchronized void m16714a() {
        if (this.f11421f == null && !this.f11420e.isEmpty()) {
            this.f11421f = this.f11416a.scheduleAtFixedRate(this.f11419d, 1000, 1000, TimeUnit.MILLISECONDS);
        }
    }

    public static synchronized void m16716b(TimeoutStreamHelper timeoutStreamHelper) {
        synchronized (timeoutStreamHelper) {
            if (timeoutStreamHelper.f11420e.isEmpty() && timeoutStreamHelper.f11421f != null) {
                timeoutStreamHelper.f11421f.cancel(false);
                timeoutStreamHelper.f11421f = null;
            }
        }
    }
}
