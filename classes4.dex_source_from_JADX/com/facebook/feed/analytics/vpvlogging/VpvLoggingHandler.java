package com.facebook.feed.analytics.vpvlogging;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.analytics.AnalyticsBeaconGenerator;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.db.AnalyticsDbProperties;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.Looper_ForNonUiThreadMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@VisibleForTesting
/* compiled from: promotions */
public class VpvLoggingHandler extends Handler {
    private static volatile VpvLoggingHandler f4084e;
    private final AnalyticsLogger f4085a;
    public final Provider<Boolean> f4086b;
    public final Lazy<AnalyticsBeaconGenerator> f4087c;
    public int f4088d = -1;

    public static com.facebook.feed.analytics.vpvlogging.VpvLoggingHandler m4618a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4084e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.analytics.vpvlogging.VpvLoggingHandler.class;
        monitor-enter(r1);
        r0 = f4084e;	 Catch:{ all -> 0x003a }
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
        r0 = m4619b(r0);	 Catch:{ all -> 0x0035 }
        f4084e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4084e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.analytics.vpvlogging.VpvLoggingHandler.a(com.facebook.inject.InjectorLike):com.facebook.feed.analytics.vpvlogging.VpvLoggingHandler");
    }

    private static VpvLoggingHandler m4619b(InjectorLike injectorLike) {
        return new VpvLoggingHandler(Looper_ForNonUiThreadMethodAutoProvider.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3885), IdBasedSingletonScopeProvider.b(injectorLike, 117));
    }

    @Inject
    public VpvLoggingHandler(Looper looper, AnalyticsLogger analyticsLogger, Provider<Boolean> provider, Lazy<AnalyticsBeaconGenerator> lazy) {
        super(looper);
        this.f4085a = analyticsLogger;
        this.f4086b = provider;
        this.f4087c = lazy;
    }

    public void handleMessage(Message message) {
        HoneyClientEvent honeyClientEvent;
        Object obj = null;
        switch (message.what) {
            case 1:
                honeyClientEvent = (HoneyClientEvent) message.obj;
                break;
            case 2:
                honeyClientEvent = (HoneyClientEvent) message.obj;
                obj = 1;
                break;
            default:
                throw new IllegalArgumentException("Unknown what=" + message.what);
        }
        if (((Boolean) this.f4086b.get()).booleanValue()) {
            this.f4088d++;
            if (this.f4088d % 11 == 0) {
                AnalyticsBeaconGenerator analyticsBeaconGenerator = (AnalyticsBeaconGenerator) this.f4087c.get();
                int i = 0;
                analyticsBeaconGenerator.f1027c = analyticsBeaconGenerator.f1029e.m8549a(AnalyticsDbProperties.f1039i, 0);
                if (analyticsBeaconGenerator.f1027c != Integer.MAX_VALUE) {
                    i = analyticsBeaconGenerator.f1027c + 1;
                }
                analyticsBeaconGenerator.f1027c = i;
                analyticsBeaconGenerator.f1029e.m8556b(AnalyticsDbProperties.f1039i, analyticsBeaconGenerator.f1027c);
                honeyClientEvent.a("seq_id", analyticsBeaconGenerator.f1027c);
            }
        }
        if (obj != null) {
            this.f4085a.d(honeyClientEvent);
        } else {
            this.f4085a.c(honeyClientEvent);
        }
    }

    public final void m4620a(HoneyClientEvent honeyClientEvent) {
        sendMessage(obtainMessage(1, honeyClientEvent));
    }

    public final void m4621b(HoneyClientEvent honeyClientEvent) {
        sendMessage(obtainMessage(2, honeyClientEvent));
    }
}
