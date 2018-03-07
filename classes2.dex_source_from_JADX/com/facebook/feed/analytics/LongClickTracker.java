package com.facebook.feed.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.util.concurrent.AtomicDouble;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetch_to_ui_time */
public class LongClickTracker {
    private static volatile LongClickTracker f9200k;
    private volatile Date f9201a;
    private volatile AtomicDouble f9202b;
    private volatile AtomicDouble f9203c;
    private volatile JsonNode f9204d;
    private volatile String f9205e;
    private volatile Map<String, ?> f9206f;
    public final AnalyticsLogger f9207g;
    private final NewsFeedAnalyticsEventBuilder f9208h;
    private final ExecutorService f9209i;
    private volatile LastCall f9210j = LastCall.RESUME;

    /* compiled from: prefetch_to_ui_time */
    enum LastCall {
        RESUME,
        LINK
    }

    public static com.facebook.feed.analytics.LongClickTracker m14087a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9200k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.analytics.LongClickTracker.class;
        monitor-enter(r1);
        r0 = f9200k;	 Catch:{ all -> 0x003a }
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
        r0 = m14088b(r0);	 Catch:{ all -> 0x0035 }
        f9200k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9200k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.analytics.LongClickTracker.a(com.facebook.inject.InjectorLike):com.facebook.feed.analytics.LongClickTracker");
    }

    private static LongClickTracker m14088b(InjectorLike injectorLike) {
        return new LongClickTracker(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), C0055x2995691a.m1881a(injectorLike));
    }

    @Inject
    public LongClickTracker(AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, ExecutorService executorService) {
        this.f9207g = analyticsLogger;
        this.f9208h = newsFeedAnalyticsEventBuilder;
        this.f9209i = executorService;
        this.f9202b = new AtomicDouble();
        this.f9203c = new AtomicDouble();
    }

    public final void m14089a() {
        if (this.f9210j != LastCall.RESUME) {
            Date date = this.f9201a;
            double doubleValue = this.f9202b.doubleValue();
            ExecutorDetour.a(this.f9209i, new 1(this, date, this.f9203c.doubleValue(), doubleValue, this.f9205e, this.f9204d, this.f9206f), -275228184);
            this.f9210j = LastCall.RESUME;
        }
    }

    public final void m14090a(JsonNode jsonNode, String str) {
        this.f9201a = new Date();
        this.f9204d = jsonNode;
        this.f9205e = str;
        this.f9202b.m14129a(0.0d);
        this.f9203c.m14129a(0.0d);
        this.f9210j = LastCall.LINK;
        this.f9206f = null;
    }

    public final void m14091a(@Nullable String str, double d, double d2, Map<String, ?> map) {
        this.f9205e = str;
        this.f9201a = null;
        this.f9202b.m14129a(d / 1000.0d);
        this.f9203c.m14129a(d2);
        this.f9210j = LastCall.LINK;
        this.f9206f = map;
    }
}
