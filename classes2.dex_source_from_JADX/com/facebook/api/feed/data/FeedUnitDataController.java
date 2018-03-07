package com.facebook.api.feed.data;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetch_failed */
public class FeedUnitDataController {
    private static volatile FeedUnitDataController f9239b;
    private final Map<String, FeedUnitData> f9240a = Maps.m838c();

    public static com.facebook.api.feed.data.FeedUnitDataController m14175a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9239b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.api.feed.data.FeedUnitDataController.class;
        monitor-enter(r1);
        r0 = f9239b;	 Catch:{ all -> 0x0039 }
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
        r0 = m14174a();	 Catch:{ all -> 0x0034 }
        f9239b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f9239b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.data.FeedUnitDataController.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.data.FeedUnitDataController");
    }

    private static FeedUnitDataController m14174a() {
        return new FeedUnitDataController();
    }

    public final synchronized FeedUnitData m14177a(FeedUnit feedUnit) {
        Preconditions.checkNotNull(feedUnit);
        return m14173a(m14176b(feedUnit));
    }

    private FeedUnitData m14173a(String str) {
        FeedUnitData feedUnitData = (FeedUnitData) this.f9240a.get(str);
        if (feedUnitData != null) {
            return feedUnitData;
        }
        feedUnitData = new FeedUnitData();
        this.f9240a.put(str, feedUnitData);
        return feedUnitData;
    }

    public final synchronized FeedUnitData m14178a(GraphQLStorySet graphQLStorySet) {
        Preconditions.checkNotNull(graphQLStorySet);
        return m14173a(graphQLStorySet.mo2507g());
    }

    private static String m14176b(FeedUnit feedUnit) {
        String g = feedUnit.mo2507g();
        if (g == null) {
            return null;
        }
        if (!(feedUnit instanceof ScrollableItemListFeedUnit) || (!(feedUnit instanceof GraphQLStorySet) && ((ScrollableItemListFeedUnit) feedUnit).ac_() == 0)) {
            return g;
        }
        return g + ":" + ((ScrollableItemListFeedUnit) feedUnit).ac_();
    }
}
