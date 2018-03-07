package com.facebook.sync.connection;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.sync.SyncDbHandler;
import com.facebook.sync.analytics.FullRefreshReason;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feedback_add_streaming_reaction */
public class SyncErrorRecoveryHandler {
    private static volatile SyncErrorRecoveryHandler f14485b;
    private final Clock f14486a;

    public static com.facebook.sync.connection.SyncErrorRecoveryHandler m18367a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14485b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.connection.SyncErrorRecoveryHandler.class;
        monitor-enter(r1);
        r0 = f14485b;	 Catch:{ all -> 0x003a }
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
        r0 = m18369b(r0);	 Catch:{ all -> 0x0035 }
        f14485b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14485b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.connection.SyncErrorRecoveryHandler.a(com.facebook.inject.InjectorLike):com.facebook.sync.connection.SyncErrorRecoveryHandler");
    }

    private static SyncErrorRecoveryHandler m18369b(InjectorLike injectorLike) {
        return new SyncErrorRecoveryHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SyncErrorRecoveryHandler(Clock clock) {
        this.f14486a = clock;
    }

    public final boolean m18371b(SyncDbHandler<?, ?> syncDbHandler) {
        long d = syncDbHandler.m18326d();
        return d != -1 && d + 300000 > this.f14486a.a();
    }

    public final long m18372c(SyncDbHandler<?, ?> syncDbHandler) {
        long a = this.f14486a.a() - syncDbHandler.m18326d();
        if (a > 300000) {
            return 0;
        }
        return (300000 - a) + 10;
    }

    public static void m18368a(SyncDbHandler<?, ?> syncDbHandler, FullRefreshReason fullRefreshReason) {
        syncDbHandler.m18322a(true, fullRefreshReason);
    }

    public final void m18373d(SyncDbHandler<?, ?> syncDbHandler) {
        syncDbHandler.m18323b(this.f14486a.a());
        syncDbHandler.m18322a(false, FullRefreshReason.f14431g);
    }

    public static void m18370e(SyncDbHandler<?, ?> syncDbHandler) {
        long a = syncDbHandler.m18318a();
        if (a != -1) {
            syncDbHandler.m18321a(a + 1);
        }
    }
}
