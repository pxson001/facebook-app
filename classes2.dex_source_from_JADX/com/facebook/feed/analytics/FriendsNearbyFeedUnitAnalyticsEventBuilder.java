package com.facebook.feed.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Singleton;

@Singleton
/* compiled from: invalid_file */
public class FriendsNearbyFeedUnitAnalyticsEventBuilder {
    private static volatile FriendsNearbyFeedUnitAnalyticsEventBuilder f19538a;

    public static com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder m27223a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19538a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder.class;
        monitor-enter(r1);
        r0 = f19538a;	 Catch:{ all -> 0x0039 }
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
        r0 = m27222a();	 Catch:{ all -> 0x0034 }
        f19538a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f19538a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder.a(com.facebook.inject.InjectorLike):com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder");
    }

    private static FriendsNearbyFeedUnitAnalyticsEventBuilder m27222a() {
        return new FriendsNearbyFeedUnitAnalyticsEventBuilder();
    }

    public static HoneyClientEvent m27221a(FriendsNearbyEvent friendsNearbyEvent, JsonNode jsonNode) {
        if (jsonNode == null || jsonNode.mo712e() == 0) {
            return null;
        }
        HoneyClientEvent a = new HoneyClientEvent(friendsNearbyEvent.mName).m5085a("tracking", jsonNode);
        a.f3099c = "native_newsfeed";
        return a;
    }
}
