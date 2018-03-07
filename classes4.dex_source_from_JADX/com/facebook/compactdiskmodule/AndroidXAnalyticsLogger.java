package com.facebook.compactdiskmodule;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.compactdisk.XAnalyticsLogger;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: mem_is_low */
public class AndroidXAnalyticsLogger implements XAnalyticsLogger {
    private static final Class<XAnalyticsLogger> f8161a = XAnalyticsLogger.class;
    private static volatile AndroidXAnalyticsLogger f8162d;
    private final AnalyticsLogger f8163b;
    private final ObjectMapper f8164c;

    public static com.facebook.compactdiskmodule.AndroidXAnalyticsLogger m8429a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8162d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.compactdiskmodule.AndroidXAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f8162d;	 Catch:{ all -> 0x003a }
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
        r0 = m8430b(r0);	 Catch:{ all -> 0x0035 }
        f8162d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8162d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.compactdiskmodule.AndroidXAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.compactdiskmodule.AndroidXAnalyticsLogger");
    }

    private static AndroidXAnalyticsLogger m8430b(InjectorLike injectorLike) {
        return new AndroidXAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    AndroidXAnalyticsLogger(AnalyticsLogger analyticsLogger, ObjectMapper objectMapper) {
        this.f8163b = analyticsLogger;
        this.f8164c = objectMapper;
    }

    @DoNotStrip
    public void logEvent(String str, String str2, String str3, String str4) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.g(str2);
        try {
            Iterator H = this.f8164c.a(str3).H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                honeyClientEvent.a((String) entry.getKey(), (JsonNode) entry.getValue());
            }
            this.f8163b.a(honeyClientEvent);
        } catch (Throwable e) {
            BLog.b(f8161a, "Could not deserialize JSON", e);
        }
    }
}
