package com.facebook.http.observer;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: unbinding */
public class ConnectionQualityTraceLogger {
    private static volatile ConnectionQualityTraceLogger f2006f;
    private final Lazy<AppStateManager> f2007a;
    public final Random f2008b = new Random();
    public AtomicReference<String[]> f2009c = new AtomicReference();
    public AtomicInteger f2010d = new AtomicInteger(1337);
    public AtomicInteger f2011e = new AtomicInteger(0);

    public static com.facebook.http.observer.ConnectionQualityTraceLogger m4087a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2006f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.observer.ConnectionQualityTraceLogger.class;
        monitor-enter(r1);
        r0 = f2006f;	 Catch:{ all -> 0x003a }
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
        r0 = m4088b(r0);	 Catch:{ all -> 0x0035 }
        f2006f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2006f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.observer.ConnectionQualityTraceLogger.a(com.facebook.inject.InjectorLike):com.facebook.http.observer.ConnectionQualityTraceLogger");
    }

    private static ConnectionQualityTraceLogger m4088b(InjectorLike injectorLike) {
        return new ConnectionQualityTraceLogger(IdBasedSingletonScopeProvider.m1810b(injectorLike, 476));
    }

    @Inject
    public ConnectionQualityTraceLogger(Lazy<AppStateManager> lazy) {
        this.f2007a = lazy;
    }

    public final void m4092a(double d, double d2) {
        int c = m4089c();
        if (c >= 0) {
            ((String[]) this.f2009c.get())[c] = StringFormatUtil.formatStrLocaleSafe("[%d,%d,%.0f,%.1f]", Long.valueOf(m4090d()), Integer.valueOf(1), Double.valueOf(d), Double.valueOf(d2));
            this.f2011e.decrementAndGet();
        }
    }

    public final void m4094a(String str, ConnectionQuality connectionQuality) {
        int c = m4089c();
        if (c >= 0) {
            ((String[]) this.f2009c.get())[c] = StringFormatUtil.formatStrLocaleSafe("[%d,%d,%s,%s]", Long.valueOf(m4090d()), Integer.valueOf(2), str, connectionQuality.toString());
            this.f2011e.decrementAndGet();
        }
    }

    public final void m4093a(long j, long j2) {
        int c = m4089c();
        if (c >= 0) {
            ((String[]) this.f2009c.get())[c] = StringFormatUtil.formatStrLocaleSafe("[%d,%d,%d,%d]", Long.valueOf(m4090d()), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2));
            this.f2011e.decrementAndGet();
        }
    }

    public final void m4091a(double d) {
        int c = m4089c();
        if (c >= 0) {
            ((String[]) this.f2009c.get())[c] = StringFormatUtil.formatStrLocaleSafe("[%d,%d,%.0f]", Long.valueOf(m4090d()), Integer.valueOf(4), Double.valueOf(d));
            this.f2011e.decrementAndGet();
        }
    }

    private int m4089c() {
        if (this.f2010d.get() > HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            return -1;
        }
        this.f2011e.incrementAndGet();
        int andIncrement = this.f2010d.getAndIncrement();
        if (andIncrement < HTTPTransportCallback.BODY_BYTES_RECEIVED) {
            return andIncrement;
        }
        this.f2010d.compareAndSet(andIncrement + 1, 1337);
        this.f2011e.decrementAndGet();
        return -1;
    }

    private long m4090d() {
        return ((AppStateManager) this.f2007a.get()).m2258d();
    }
}
