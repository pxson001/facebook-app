package com.facebook.iorg.fb4acommon;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.zero.interfaces.ZeroAnalyticsEventShim;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TOPIC */
public class IorgFb4aAnalyticsLogger {
    private static volatile IorgFb4aAnalyticsLogger f13912b;
    private final AnalyticsLogger f13913a;

    public static com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger m23281a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13912b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f13912b;	 Catch:{ all -> 0x003a }
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
        r0 = m23282b(r0);	 Catch:{ all -> 0x0035 }
        f13912b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13912b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger");
    }

    private static IorgFb4aAnalyticsLogger m23282b(InjectorLike injectorLike) {
        return new IorgFb4aAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public IorgFb4aAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f13913a = analyticsLogger;
    }

    public final void m23285a(ZeroAnalyticsEventShim zeroAnalyticsEventShim, Map<String, String> map) {
        HoneyClientEventFast a = this.f13913a.a(zeroAnalyticsEventShim.f13892n, true);
        if (a.a()) {
            a.a(map);
            a.b();
        }
    }

    public final void m23283a(ZeroAnalyticsEventShim zeroAnalyticsEventShim) {
        m23285a(zeroAnalyticsEventShim, new HashMap());
    }

    public final void m23284a(ZeroAnalyticsEventShim zeroAnalyticsEventShim, String str, String str2, String str3, Map<String, String> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(zeroAnalyticsEventShim.f13892n);
        honeyClientEvent.d = str;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = str2;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = str3;
        honeyClientEvent = honeyClientEvent.a(map);
        if (zeroAnalyticsEventShim.f13893o != null) {
            honeyClientEvent.c = zeroAnalyticsEventShim.f13893o;
        }
        this.f13913a.a(honeyClientEvent);
    }
}
