package com.facebook.commerce.publishing.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.commerce.publishing.analytics.CommercePublishingAnalytics.CommercePublishingAnalyticsEvent;
import com.facebook.commerce.publishing.analytics.CommercePublishingAnalytics.CommercePublishingAnalyticsKey;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: UK */
public class CommercePublishingLogger {
    private static volatile CommercePublishingLogger f23839b;
    public final AnalyticsLogger f23840a;

    public static com.facebook.commerce.publishing.analytics.CommercePublishingLogger m25842a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23839b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.commerce.publishing.analytics.CommercePublishingLogger.class;
        monitor-enter(r1);
        r0 = f23839b;	 Catch:{ all -> 0x003a }
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
        r0 = m25844b(r0);	 Catch:{ all -> 0x0035 }
        f23839b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23839b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.commerce.publishing.analytics.CommercePublishingLogger.a(com.facebook.inject.InjectorLike):com.facebook.commerce.publishing.analytics.CommercePublishingLogger");
    }

    private static CommercePublishingLogger m25844b(InjectorLike injectorLike) {
        return new CommercePublishingLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CommercePublishingLogger(AnalyticsLogger analyticsLogger) {
        this.f23840a = analyticsLogger;
    }

    public final void m25845a(CommercePublishingAnalyticsEvent commercePublishingAnalyticsEvent, String str) {
        this.f23840a.a(m25843b(commercePublishingAnalyticsEvent, str));
    }

    public static HoneyClientEvent m25843b(CommercePublishingAnalyticsEvent commercePublishingAnalyticsEvent, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(commercePublishingAnalyticsEvent.value);
        honeyClientEvent.b(CommercePublishingAnalyticsKey.SELLER_PROFILE_ID.value, str);
        return honeyClientEvent;
    }
}
