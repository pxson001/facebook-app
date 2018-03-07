package com.facebook.sync.connection;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: frameIndex is not positive */
public class SyncConnectionStateManager {
    private static volatile SyncConnectionStateManager f11436f;
    private final ChannelConnectivityTracker f11437a;
    private final Clock f11438b;
    @GuardedBy("this")
    private final Map<QueueKey, Long> f11439c = new HashMap();
    @GuardedBy("this")
    private final Map<QueueKey, Long> f11440d = new HashMap();
    @GuardedBy("this")
    private final Map<QueueKey, Boolean> f11441e = new HashMap();

    public static com.facebook.sync.connection.SyncConnectionStateManager m11887a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11436f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.connection.SyncConnectionStateManager.class;
        monitor-enter(r1);
        r0 = f11436f;	 Catch:{ all -> 0x003a }
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
        r0 = m11888b(r0);	 Catch:{ all -> 0x0035 }
        f11436f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11436f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.connection.SyncConnectionStateManager.a(com.facebook.inject.InjectorLike):com.facebook.sync.connection.SyncConnectionStateManager");
    }

    private static SyncConnectionStateManager m11888b(InjectorLike injectorLike) {
        return new SyncConnectionStateManager(ChannelConnectivityTracker.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SyncConnectionStateManager(ChannelConnectivityTracker channelConnectivityTracker, Clock clock) {
        this.f11437a = channelConnectivityTracker;
        this.f11438b = clock;
    }

    public final synchronized boolean m11893a(QueueKey queueKey) {
        boolean z;
        long d = m11889d(queueKey);
        z = this.f11437a.e() && !m11890e(queueKey) && this.f11437a.c() < d && this.f11438b.a() < d + 1200000;
        return z;
    }

    public final boolean m11892a() {
        return this.f11437a.e();
    }

    public final synchronized void m11891a(QueueKey queueKey, long j) {
        this.f11439c.put(queueKey, Long.valueOf(j));
        this.f11441e.remove(queueKey);
    }

    public final synchronized boolean m11894b(QueueKey queueKey) {
        boolean z;
        Long l = (Long) this.f11440d.get(queueKey);
        if (l == null) {
            z = false;
        } else if (this.f11438b.a() > l.longValue() + 60000) {
            this.f11440d.remove(queueKey);
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized void m11895c(QueueKey queueKey) {
        this.f11441e.put(queueKey, Boolean.TRUE);
    }

    private synchronized long m11889d(QueueKey queueKey) {
        Long l;
        l = (Long) this.f11439c.get(queueKey);
        return l == null ? -1 : l.longValue();
    }

    private synchronized boolean m11890e(QueueKey queueKey) {
        return Boolean.TRUE.equals(this.f11441e.get(queueKey));
    }
}
