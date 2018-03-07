package com.facebook.messaging.business.promotion.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.common.analytics.BusinessMessageImpressionLogger;
import com.facebook.messaging.business.promotion.config.AdsImpressionLoggingXConfig;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.xconfig.core.XConfigReader;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: msg_box */
public class AdsImpressionLogger implements BusinessMessageImpressionLogger {
    private static volatile AdsImpressionLogger f9042f;
    private final MonotonicClock f9043a;
    private final AnalyticsLogger f9044b;
    private final Map<String, Long> f9045c = new HashMap();
    private final XConfigReader f9046d;
    private final long f9047e = (((long) this.f9046d.a(AdsImpressionLoggingXConfig.c, 60)) * 1000);

    public static com.facebook.messaging.business.promotion.analytics.AdsImpressionLogger m9349a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9042f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.business.promotion.analytics.AdsImpressionLogger.class;
        monitor-enter(r1);
        r0 = f9042f;	 Catch:{ all -> 0x003a }
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
        r0 = m9353b(r0);	 Catch:{ all -> 0x0035 }
        f9042f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9042f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.promotion.analytics.AdsImpressionLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.business.promotion.analytics.AdsImpressionLogger");
    }

    private static AdsImpressionLogger m9353b(InjectorLike injectorLike) {
        return new AdsImpressionLogger((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public AdsImpressionLogger(MonotonicClock monotonicClock, AnalyticsLogger analyticsLogger, XConfigReader xConfigReader) {
        this.f9043a = monotonicClock;
        this.f9044b = analyticsLogger;
        this.f9046d = xConfigReader;
    }

    public final void mo317a(ThreadSummary threadSummary) {
        m9350a(threadSummary, "thread_list" + threadSummary.a.i(), "messenger_ads_message_seen_inbox");
    }

    public final void mo318b(ThreadSummary threadSummary) {
        m9350a(threadSummary, "message_request" + threadSummary.a.i(), "messenger_ads_message_seen_request");
    }

    public final void mo316a(Message message) {
        if (message.M && m9351a("thread_message_view" + message.a)) {
            this.f9044b.d(m9352b("messenger_ads_message_seen_thread").a("page_id", message.b.i()).b("message_id", message.a));
        }
    }

    private boolean m9351a(String str) {
        Long valueOf = Long.valueOf(this.f9043a.now());
        if (this.f9045c.get(str) != null && Math.abs(((Long) this.f9045c.get(str)).longValue() - valueOf.longValue()) < this.f9047e) {
            return false;
        }
        this.f9045c.put(str, valueOf);
        return true;
    }

    private static HoneyClientEvent m9352b(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "messenger_ads";
        return honeyClientEvent;
    }

    private void m9350a(ThreadSummary threadSummary, String str, String str2) {
        if (threadSummary.K && m9351a(str)) {
            this.f9044b.d(m9352b(str2).a("page_id", threadSummary.a.i()).a("timestamp", threadSummary.k));
        }
    }
}
