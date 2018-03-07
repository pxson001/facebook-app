package com.facebook.instantshopping.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SharedImageMessageAdapter has 0 images */
public class InstantShoppingAnalyticsLogger {
    private static volatile InstantShoppingAnalyticsLogger f23524h;
    public Map<LoggingParams, Long> f23525a;
    public QeAccessor f23526b;
    private final AnalyticsLogger f23527c;
    public Map<String, Object> f23528d = new HashMap();
    public Map<String, Object> f23529e;
    public JsonNode f23530f;
    public Clock f23531g;

    public static com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger m24853a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23524h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f23524h;	 Catch:{ all -> 0x003a }
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
        r0 = m24855b(r0);	 Catch:{ all -> 0x0035 }
        f23524h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23524h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger");
    }

    private static InstantShoppingAnalyticsLogger m24855b(InjectorLike injectorLike) {
        return new InstantShoppingAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InstantShoppingAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock, QeAccessor qeAccessor) {
        this.f23527c = analyticsLogger;
        this.f23531g = clock;
        this.f23525a = new HashMap();
        this.f23526b = qeAccessor;
    }

    public final void m24858a(@Nullable String str) {
        m24854a(str, null, true);
    }

    public final void m24859a(@Nullable String str, @Nullable Map<String, Object> map) {
        m24854a(str, map, true);
    }

    private void m24854a(@Nullable String str, @Nullable Map<String, Object> map, boolean z) {
        if (!StringUtil.a(str)) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
            honeyClientEvent.c = "instant_shopping";
            honeyClientEvent.b(z);
            honeyClientEvent.a(this.f23528d);
            if (this.f23529e != null) {
                honeyClientEvent.a(this.f23529e);
            }
            if (this.f23530f != null) {
                honeyClientEvent.a("tracking", this.f23530f);
            }
            if (map != null) {
                honeyClientEvent.a(map);
            }
            this.f23527c.a(honeyClientEvent);
        }
    }

    public final void m24857a(final LoggingParams loggingParams, @Nullable final Map<String, Object> map) {
        m24859a("instant_shopping_element_click", new HashMap<String, Object>() {
        });
    }

    public final void m24856a(LoggingParams loggingParams) {
        Object obj;
        if (this.f23525a.containsKey(loggingParams)) {
            if (this.f23531g.a() - ((Long) this.f23525a.get(loggingParams)).longValue() < ((long) this.f23526b.a(ExperimentsForInstantShoppingAbtestModule.g, 60)) * 1000) {
                obj = 1;
                if (obj != null) {
                    this.f23525a.put(loggingParams, Long.valueOf(this.f23531g.a()));
                    Map hashMap = new HashMap();
                    hashMap.put("element_type", loggingParams.f23578a);
                    hashMap.put("logging_token", loggingParams.f23579b);
                    m24854a("instant_shopping_element_impression", hashMap, false);
                }
            }
        }
        obj = null;
        if (obj != null) {
            this.f23525a.put(loggingParams, Long.valueOf(this.f23531g.a()));
            Map hashMap2 = new HashMap();
            hashMap2.put("element_type", loggingParams.f23578a);
            hashMap2.put("logging_token", loggingParams.f23579b);
            m24854a("instant_shopping_element_impression", hashMap2, false);
        }
    }
}
