package com.facebook.ufiservices.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: id = ? */
public class UFIServicesAnalyticsEventBuilder {
    private static volatile UFIServicesAnalyticsEventBuilder f20626a;

    public static com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder m28369a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f20626a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder.class;
        monitor-enter(r1);
        r0 = f20626a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m28368a();	 Catch:{ all -> 0x0034 }
        f20626a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f20626a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder.a(com.facebook.inject.InjectorLike):com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder");
    }

    private static UFIServicesAnalyticsEventBuilder m28368a() {
        return new UFIServicesAnalyticsEventBuilder();
    }

    public static HoneyClientEvent m28367a(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable JsonNode jsonNode, String str4) {
        if ((str == null && str2 == null && str3 == null) || str4 == null) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent("open_flyout").mo699b(z).m5090b("photo_id", str).m5090b("feedback_id", str2).m5090b("legacy_api_post_id", str3).m5085a("tracking", jsonNode);
        a.f3099c = str4;
        return a;
    }
}
