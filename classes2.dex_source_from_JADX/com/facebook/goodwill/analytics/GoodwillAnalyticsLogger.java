package com.facebook.goodwill.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pending_thread_key */
public class GoodwillAnalyticsLogger {
    private static volatile GoodwillAnalyticsLogger f10254c;
    public final AnalyticsLogger f10255a;
    private final BaseFbBroadcastManager f10256b;

    public static com.facebook.goodwill.analytics.GoodwillAnalyticsLogger m15340a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10254c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.goodwill.analytics.GoodwillAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f10254c;	 Catch:{ all -> 0x003a }
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
        r0 = m15341b(r0);	 Catch:{ all -> 0x0035 }
        f10254c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10254c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodwill.analytics.GoodwillAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.goodwill.analytics.GoodwillAnalyticsLogger");
    }

    private static GoodwillAnalyticsLogger m15341b(InjectorLike injectorLike) {
        return new GoodwillAnalyticsLogger(LocalFbBroadcastManager.m2946a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public GoodwillAnalyticsLogger(BaseFbBroadcastManager baseFbBroadcastManager, AnalyticsLogger analyticsLogger) {
        this.f10256b = baseFbBroadcastManager;
        this.f10255a = analyticsLogger;
    }

    public final void m15343a(Events events) {
        AnalyticsLogger analyticsLogger = this.f10255a;
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(events.name);
        honeyClientEvent.f3099c = "goodwill";
        analyticsLogger.mo526a(honeyClientEvent);
    }

    public final void m15344a(SubscriptionSource subscriptionSource, boolean z) {
        String str;
        AnalyticsLogger analyticsLogger = this.f10255a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Events.THROWBACK_CHANGED_NOTIFICATION_SUBSCRIPTION.name);
        honeyClientEvent.f3099c = "goodwill";
        HoneyClientEvent b = honeyClientEvent.m5090b("subscribe_source", subscriptionSource.name);
        String str2 = "new_subscription_status";
        if (z) {
            str = "subscribed_all";
        } else {
            str = "unsubscribed";
        }
        analyticsLogger.mo526a(b.m5090b(str2, str));
    }

    public final void m15345a(String str, String str2, Events events) {
        AnalyticsLogger analyticsLogger = this.f10255a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(events.name);
        honeyClientEvent.f3099c = "goodwill";
        analyticsLogger.mo526a(honeyClientEvent.m5090b("campaign_id", str).m5090b("source", str2));
    }

    public final SelfRegistrableReceiverImpl m15342a(String str, String str2, String str3, String str4, String str5, String str6) {
        return this.f10256b.m2951a().mo506a("com.facebook.STREAM_PUBLISH_COMPLETE", new 1(this, str3, str, str2, str4, str5, str6)).mo503a();
    }

    public final void m15346b(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Events.GOODWILL_VIDEO_SHARE_COMPOSER_OPENED.name);
        honeyClientEvent.f3099c = "goodwill";
        this.f10255a.mo526a(honeyClientEvent.m5090b("campaign_id", str).m5090b("source", str2).m5090b("direct_source", str3));
    }
}
