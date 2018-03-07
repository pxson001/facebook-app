package com.facebook.placetips.pulsarcore;

import com.facebook.graphql.calls.PulsarScanInputPulsarScan;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: The caret nux tooltip is shown on a non-story feed unit. */
public class PulsarSpecificAnalyticsLogger {
    private static volatile PulsarSpecificAnalyticsLogger f10679c;
    public final Lazy<PlaceTipsAnalyticsLogger> f10680a;
    private final Lazy<ObjectMapper> f10681b;

    public static com.facebook.placetips.pulsarcore.PulsarSpecificAnalyticsLogger m11190a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10679c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.pulsarcore.PulsarSpecificAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f10679c;	 Catch:{ all -> 0x003a }
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
        r0 = m11191b(r0);	 Catch:{ all -> 0x0035 }
        f10679c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10679c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.pulsarcore.PulsarSpecificAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.placetips.pulsarcore.PulsarSpecificAnalyticsLogger");
    }

    private static PulsarSpecificAnalyticsLogger m11191b(InjectorLike injectorLike) {
        return new PulsarSpecificAnalyticsLogger(IdBasedSingletonScopeProvider.b(injectorLike, 3007), IdBasedSingletonScopeProvider.b(injectorLike, 572));
    }

    @Inject
    public PulsarSpecificAnalyticsLogger(Lazy<PlaceTipsAnalyticsLogger> lazy, Lazy<ObjectMapper> lazy2) {
        this.f10680a = lazy;
        this.f10681b = lazy2;
    }

    public final void m11192a(PulsarScanInputPulsarScan pulsarScanInputPulsarScan) {
        try {
            ((PlaceTipsAnalyticsLogger) this.f10680a.get()).b(((ObjectMapper) this.f10681b.get()).a(pulsarScanInputPulsarScan), PresenceSourceType.BLE);
        } catch (JsonProcessingException e) {
            throw Throwables.propagate(e);
        }
    }
}
