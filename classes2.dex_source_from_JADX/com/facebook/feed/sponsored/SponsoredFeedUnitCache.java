package com.facebook.feed.sponsored;

import com.facebook.api.feed.data.FeedUnitData;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_messenger_promotion_blocked_by_viewer */
public class SponsoredFeedUnitCache {
    public static Comparator<FeedEdgeCacheEntry> f19004a = new C07541();
    public static Comparator<FeedEdgeCacheEntry> f19005b = new C07552();
    private static volatile SponsoredFeedUnitCache f19006h;
    private final FeedUnitDataController f19007c;
    private final Clock f19008d;
    public final GatekeeperStoreImpl f19009e;
    private final XConfigReader f19010f;
    public final List<FeedEdgeCacheEntry> f19011g = Lists.m1296a();

    /* compiled from: is_messenger_promotion_blocked_by_viewer */
    final class C07541 implements Comparator<FeedEdgeCacheEntry> {
        C07541() {
        }

        public final int compare(Object obj, Object obj2) {
            return (int) (((FeedEdgeCacheEntry) obj2).d - ((FeedEdgeCacheEntry) obj).d);
        }
    }

    /* compiled from: is_messenger_promotion_blocked_by_viewer */
    final class C07552 implements Comparator<FeedEdgeCacheEntry> {
        C07552() {
        }

        public final int compare(Object obj, Object obj2) {
            FeedEdgeCacheEntry feedEdgeCacheEntry = (FeedEdgeCacheEntry) obj;
            FeedEdgeCacheEntry feedEdgeCacheEntry2 = (FeedEdgeCacheEntry) obj2;
            if (feedEdgeCacheEntry.d() instanceof ScrollableItemListFeedUnit) {
                return 1;
            }
            if (feedEdgeCacheEntry2.d() instanceof ScrollableItemListFeedUnit) {
                return -1;
            }
            return SponsoredFeedUnitCache.f19004a.compare(feedEdgeCacheEntry, feedEdgeCacheEntry2);
        }
    }

    public static com.facebook.feed.sponsored.SponsoredFeedUnitCache m26733a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19006h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.sponsored.SponsoredFeedUnitCache.class;
        monitor-enter(r1);
        r0 = f19006h;	 Catch:{ all -> 0x003a }
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
        r0 = m26734b(r0);	 Catch:{ all -> 0x0035 }
        f19006h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19006h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.sponsored.SponsoredFeedUnitCache.a(com.facebook.inject.InjectorLike):com.facebook.feed.sponsored.SponsoredFeedUnitCache");
    }

    private static SponsoredFeedUnitCache m26734b(InjectorLike injectorLike) {
        return new SponsoredFeedUnitCache(FeedUnitDataController.m14175a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public SponsoredFeedUnitCache(FeedUnitDataController feedUnitDataController, Clock clock, GatekeeperStoreImpl gatekeeperStoreImpl, XConfigReader xConfigReader) {
        this.f19007c = feedUnitDataController;
        this.f19008d = clock;
        this.f19009e = gatekeeperStoreImpl;
        this.f19010f = xConfigReader;
    }

    public final int m26737a() {
        return this.f19011g.size();
    }

    public final Iterator<FeedEdgeCacheEntry> m26741b() {
        return this.f19011g.iterator();
    }

    public final boolean m26739a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return m26735c(graphQLFeedUnitEdge) != null;
    }

    private boolean m26736f() {
        return this.f19009e.m2189a(545, false);
    }

    public final boolean m26740a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i) {
        if (!this.f19009e.m2189a(541, false)) {
            if ((!this.f19011g.isEmpty() ? 1 : null) != null) {
                return false;
            }
        }
        if (this.f19011g.size() >= this.f19010f.m2683a(SponsoredFeedValidationXConfig.c, 1)) {
            return false;
        }
        if (m26736f()) {
            FeedUnitData a = this.f19007c.m14177a(graphQLFeedUnitEdge.mo2540c());
            if (a != null && a.m27201f()) {
                return false;
            }
        }
        this.f19011g.add(new FeedEdgeCacheEntry(this, graphQLFeedUnitEdge, i, this.f19008d.mo211a()));
        return true;
    }

    public final void m26742b(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        FeedEdgeCacheEntry c = m26735c(graphQLFeedUnitEdge);
        if (c != null) {
            this.f19011g.remove(c);
        }
    }

    public final void m26743c() {
        this.f19011g.clear();
    }

    public final void m26738a(List<GraphQLFeedUnitEdge> list) {
        TracerDetour.a("SponsoredFeedUnitCache.onFeedUnitsAdded", 231259492);
        try {
            if (m26736f()) {
                for (GraphQLFeedUnitEdge b : list) {
                    m26742b(b);
                }
            }
            TracerDetour.a(-2097043332);
        } catch (Throwable th) {
            TracerDetour.a(1152791607);
        }
    }

    private FeedEdgeCacheEntry m26735c(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        for (FeedEdgeCacheEntry feedEdgeCacheEntry : this.f19011g) {
            if (DedupableUtil.m23084a(feedEdgeCacheEntry.b).equals(DedupableUtil.m23084a(graphQLFeedUnitEdge))) {
                return feedEdgeCacheEntry;
            }
        }
        return null;
    }
}
