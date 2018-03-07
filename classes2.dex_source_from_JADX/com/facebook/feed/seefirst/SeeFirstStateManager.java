package com.facebook.feed.seefirst;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbSeeFirstClearRequest;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: offers_claim */
public class SeeFirstStateManager {
    private static volatile SeeFirstStateManager f11551b;
    private final FeedDbMutationService f11552a;

    public static com.facebook.feed.seefirst.SeeFirstStateManager m16868a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11551b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.seefirst.SeeFirstStateManager.class;
        monitor-enter(r1);
        r0 = f11551b;	 Catch:{ all -> 0x003a }
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
        r0 = m16871b(r0);	 Catch:{ all -> 0x0035 }
        f11551b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11551b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.seefirst.SeeFirstStateManager.a(com.facebook.inject.InjectorLike):com.facebook.feed.seefirst.SeeFirstStateManager");
    }

    private static SeeFirstStateManager m16871b(InjectorLike injectorLike) {
        return new SeeFirstStateManager(FeedDbMutationService.m9091a(injectorLike));
    }

    @Inject
    public SeeFirstStateManager(FeedDbMutationService feedDbMutationService) {
        this.f11552a = feedDbMutationService;
    }

    public static boolean m16870a(GraphQLStory graphQLStory) {
        if (graphQLStory.ah() && PropertyHelper.m21308j(graphQLStory)) {
            ImmutableList at = graphQLStory.at();
            int size = at.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                if (((GraphQLActor) at.get(i)).an() == GraphQLSecondarySubscribeStatus.SEE_FIRST) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i++;
                i2 = i3;
            }
            if (i2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final void m16872a(boolean z, FetchPortion fetchPortion, int i, FetchFeedResult fetchFeedResult, FeedUnitCollection feedUnitCollection) {
        if (fetchFeedResult != null && fetchFeedResult.m22439d() != null && fetchFeedResult.m22439d().size() > 0 && z && i > 0 && fetchFeedResult.freshness == DataFreshnessResult.FROM_SERVER && fetchPortion == FetchPortion.CHUNKED_INITIAL) {
            Iterator it = feedUnitCollection.iterator();
            while (it.hasNext()) {
                m16869a((GraphQLFeedUnitEdge) it.next(), feedUnitCollection, false);
            }
            if (fetchFeedResult.f15756a != null) {
                this.f11552a.m9112a(new FeedDbSeeFirstClearRequest(fetchFeedResult.f15756a.f5786d));
            }
            ImmutableList d = fetchFeedResult.m22439d();
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) d.get(i2);
                FeedUnit c = graphQLFeedUnitEdge.mo2540c();
                if ((c instanceof GraphQLStory) && ((GraphQLStory) c).ah()) {
                    m16869a(graphQLFeedUnitEdge, feedUnitCollection, true);
                }
            }
        }
    }

    private static void m16869a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, FeedUnitCollection feedUnitCollection, boolean z) {
        if (graphQLFeedUnitEdge.mo2540c() instanceof GraphQLStory) {
            FeedUnit feedUnit = (GraphQLStory) graphQLFeedUnitEdge.mo2540c();
            if (PropertyHelper.m21308j(feedUnit) != z) {
                PropertyHelper.m21301e(feedUnit, z);
                feedUnitCollection.f5627a.mo1379a(feedUnit);
            }
        }
    }
}
