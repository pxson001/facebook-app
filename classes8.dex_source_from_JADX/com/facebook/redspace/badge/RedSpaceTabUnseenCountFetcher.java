package com.facebook.redspace.badge;

import android.support.annotation.Nullable;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.util.RedSpaceBadgeCountManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.analytics.logger.RedSpaceTimeLogger;
import com.facebook.redspace.badge.event.RedSpaceBadgingEventBus;
import com.facebook.redspace.badge.event.RedSpaceBadgingEventSubscriber;
import com.facebook.redspace.badge.event.SeenStoryStoreUpdatedEvent;
import com.facebook.redspace.data.cache.RedSpaceMemoryFriendsCache;
import com.facebook.redspace.fetcher.RedSpaceBatchFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceTabBadgeWithFriendsResult;
import com.facebook.redspace.fetcher.RedSpaceRequests;
import com.facebook.redspace.fetcher.RedSpaceRequests.ExportedParam;
import com.facebook.redspace.fragment.RedSpaceHomeFragment.2;
import com.facebook.redspace.protocol.RedSpaceFeedFragments.RedSpaceUnreadFriendsQueryString;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.RedspaceModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceUnreadFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceUnreadFriendsQueryModel.RedspaceModel.FriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceUnreadFriendsQueryModel.RedspaceModel.FriendsModel.ApproximateCountModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceUnreadFriendsQueryModel.RedspaceModel.FriendsModel.NodesModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceUnreadFriendsQueryModel.RedspaceModel.FriendsModel.NodesModel.NodesRedspaceModel.StoriesModel.StoriesNodesModel;
import com.facebook.redspace.subscription.SubscriptionHolder;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Iterator;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unable to complete MediaStore query */
public class RedSpaceTabUnseenCountFetcher implements IHaveUserData, RedSpaceBadgeCountManager {
    private static volatile RedSpaceTabUnseenCountFetcher f21273r;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbErrorReporter> f21274a = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceBatchFetcher> f21275b = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceRequests> f21276c = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceBatchRequests> f21277d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceBadgingEventBus> f21278e = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceOptimisticBadgeStore> f21279f = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceMemoryFriendsCache> f21280g = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<QeAccessor> f21281h = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceLogger> f21282i = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> f21283j = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AppStateManager> f21284k = UltralightRuntime.b;
    @Inject
    private Provider<RedSpaceTimeLogger> f21285l;
    @Inject
    private JewelCounters f21286m;
    public final SubscriptionHolder<UnseenCountChangedListener> f21287n = new SubscriptionHolder();
    private final SeenStoryStoreUpdatedSubscriber f21288o = new SeenStoryStoreUpdatedSubscriber(this);
    public ApproximateCountModel f21289p;
    public long f21290q;

    /* compiled from: Unable to complete MediaStore query */
    public class SeenStoryStoreUpdatedSubscriber extends RedSpaceBadgingEventSubscriber<SeenStoryStoreUpdatedEvent> {
        final /* synthetic */ RedSpaceTabUnseenCountFetcher f21272a;

        public SeenStoryStoreUpdatedSubscriber(RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher) {
            this.f21272a = redSpaceTabUnseenCountFetcher;
        }

        public final void m24886b(FbEvent fbEvent) {
            if (this.f21272a.f21289p != null) {
                RedSpaceTabUnseenCountFetcher.m24889a(this.f21272a, this.f21272a.m24897e());
            }
        }

        public final Class<SeenStoryStoreUpdatedEvent> m24885a() {
            return SeenStoryStoreUpdatedEvent.class;
        }
    }

    public static com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher m24887a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21273r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher.class;
        monitor-enter(r1);
        r0 = f21273r;	 Catch:{ all -> 0x003a }
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
        r0 = m24890b(r0);	 Catch:{ all -> 0x0035 }
        f21273r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21273r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher.a(com.facebook.inject.InjectorLike):com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher");
    }

    private static RedSpaceTabUnseenCountFetcher m24890b(InjectorLike injectorLike) {
        RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher = new RedSpaceTabUnseenCountFetcher();
        redSpaceTabUnseenCountFetcher.m24888a(IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 10184), IdBasedLazy.a(injectorLike, 10187), IdBasedLazy.a(injectorLike, 10185), IdBasedSingletonScopeProvider.b(injectorLike, 3267), IdBasedSingletonScopeProvider.b(injectorLike, 3265), IdBasedSingletonScopeProvider.b(injectorLike, 10179), IdBasedSingletonScopeProvider.b(injectorLike, 3219), IdBasedSingletonScopeProvider.b(injectorLike, 10162), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedSingletonScopeProvider.b(injectorLike, 476), IdBasedProvider.a(injectorLike, 10163), JewelCounters.a(injectorLike));
        return redSpaceTabUnseenCountFetcher;
    }

    public static void m24889a(RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher, int i) {
        if (i != redSpaceTabUnseenCountFetcher.f21286m.a(Jewel.REDSPACE)) {
            HoneyClientEventFast a = ((RedSpaceLogger) redSpaceTabUnseenCountFetcher.f21282i.get()).f21265b.a("badge_invalidation", false);
            if (a.a()) {
                a.a("redspace_performance");
                a.a("badge_count", i);
                a.b();
            }
        }
        redSpaceTabUnseenCountFetcher.f21286m.a(Jewel.REDSPACE, Math.max(0, i));
    }

    public final void m24891a() {
        ((RedSpaceBadgingEventBus) this.f21278e.get()).a(this.f21288o);
    }

    public final void m24894b() {
        ((RedSpaceBadgingEventBus) this.f21278e.get()).b(this.f21288o);
    }

    public final void m24895c() {
        GraphQLRequest a = GraphQLRequest.a(new RedSpaceUnreadFriendsQueryString());
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("redspace_tab_badge");
        GraphQLRequest a2 = ((RedSpaceRequests) this.f21276c.get()).m24950a("top", Boolean.valueOf(true), null, null, null, null, null, null, null, null);
        RequestObservable a3 = ((RedSpaceBatchRequests) this.f21277d.get()).m24939a(graphQLBatchRequest, a, a2, ((RedSpaceRequests) this.f21276c.get()).m24949a("top", new ExportedParam(a2.a("has_more_friends", BatchQueryFanOutStyle.FIRST, FallbackStyle.ALLOW))));
        final RedSpaceTimeLogger redSpaceTimeLogger = (RedSpaceTimeLogger) this.f21285l.get();
        redSpaceTimeLogger.m24880a();
        ((RedSpaceBatchFetcher) this.f21275b.get()).m24924a(graphQLBatchRequest, a3, new FutureCallback<RedSpaceTabBadgeWithFriendsResult>(this) {
            final /* synthetic */ RedSpaceTabUnseenCountFetcher f21271b;

            public void onSuccess(@Nullable Object obj) {
                RedSpaceTabBadgeWithFriendsResult redSpaceTabBadgeWithFriendsResult = (RedSpaceTabBadgeWithFriendsResult) obj;
                if (redSpaceTabBadgeWithFriendsResult == null || redSpaceTabBadgeWithFriendsResult.mo1159a() == null || redSpaceTabBadgeWithFriendsResult.mo1159a().e == null || ((RedSpaceUnreadFriendsQueryModel) redSpaceTabBadgeWithFriendsResult.mo1159a().e).a() == null || ((RedSpaceUnreadFriendsQueryModel) redSpaceTabBadgeWithFriendsResult.mo1159a().e).a().a() == null || ((RedSpaceUnreadFriendsQueryModel) redSpaceTabBadgeWithFriendsResult.mo1159a().e).a().a().a() == null) {
                    onFailure(new IllegalArgumentException("Illegal result format for unseen batch request. " + redSpaceTabBadgeWithFriendsResult));
                    return;
                }
                this.f21271b.f21289p = ((RedSpaceUnreadFriendsQueryModel) redSpaceTabBadgeWithFriendsResult.mo1159a().e).a().a().a();
                this.f21271b.m24893a(((RedSpaceUnreadFriendsQueryModel) redSpaceTabBadgeWithFriendsResult.mo1159a().e).a().a());
                int e = this.f21271b.m24897e();
                this.f21271b.f21290q = ((Clock) this.f21271b.f21283j.get()).a();
                RedSpaceLogger redSpaceLogger = (RedSpaceLogger) this.f21271b.f21282i.get();
                long e2 = ((AppStateManager) this.f21271b.f21284k.get()).e();
                HoneyClientEventFast a = redSpaceLogger.f21265b.a("badge_load", false);
                if (a.a()) {
                    a.a("redspace_performance");
                    a.a("badge_count", e);
                    a.a("elapsed_time_ms", e2);
                    a.b();
                }
                RedSpaceTabUnseenCountFetcher.m24889a(this.f21271b, e);
                this.f21271b.m24892a(redSpaceTabBadgeWithFriendsResult.mo1160b(), redSpaceTabBadgeWithFriendsResult.m24933c());
                if (e > 0) {
                    Iterator it = this.f21271b.f21287n.iterator();
                    while (it.hasNext()) {
                        2 2 = (2) it.next();
                        if (2 != null) {
                            if (!2.a.D()) {
                                2.a.az.g();
                                2.a.aA.g();
                                AdapterDetour.a(2.a.aS, 217101382);
                            }
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                ((RedSpaceLogger) this.f21271b.f21282i.get()).m24879c(th, redSpaceTimeLogger.m24881b());
            }
        });
    }

    @VisibleForTesting
    final void m24893a(FriendsModel friendsModel) {
        ((RedSpaceOptimisticBadgeStore) this.f21279f.get()).c();
        ImmutableList j = friendsModel.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) j.get(i);
            if (!(nodesModel == null || nodesModel.k() == null || nodesModel.k().a() == null)) {
                String j2 = nodesModel.j();
                ImmutableList a = nodesModel.k().a().a();
                int size2 = a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    StoriesNodesModel storiesNodesModel = (StoriesNodesModel) a.get(i2);
                    if (storiesNodesModel != null) {
                        String j3;
                        String k = storiesNodesModel.k();
                        if (storiesNodesModel.j() != null) {
                            j3 = storiesNodesModel.j().j();
                        } else {
                            j3 = null;
                        }
                        ((RedSpaceOptimisticBadgeStore) this.f21279f.get()).a(j2, k, j3);
                    }
                }
            }
        }
    }

    public final void m24896d() {
        this.f21286m.a(Jewel.REDSPACE, 0);
        ((RedSpaceOptimisticBadgeStore) this.f21279f.get()).b();
        this.f21289p = null;
    }

    public final int m24897e() {
        if (this.f21289p == null || (!this.f21289p.j() && ((QeAccessor) this.f21281h.get()).a(ExperimentsForRedSpaceExperimentsModule.c, true))) {
            return ((RedSpaceOptimisticBadgeStore) this.f21279f.get()).i;
        }
        if (this.f21289p.j()) {
            return this.f21289p.a() + 1;
        }
        return this.f21289p.a();
    }

    @VisibleForTesting
    final void m24892a(GraphQLResult<RedSpaceFriendsQueryModel> graphQLResult, GraphQLResult<RedSpaceFriendsOverflowCountQueryModel> graphQLResult2) {
        RedspaceModel.FriendsModel a = ((RedSpaceFriendsQueryModel) graphQLResult.e).j().a();
        ((RedSpaceMemoryFriendsCache) this.f21280g.get()).m24913a(a.a(), "top", true);
        ((RedSpaceMemoryFriendsCache) this.f21280g.get()).m24912a(a.j(), "top");
        if (!(graphQLResult2 == null || ((RedSpaceFriendsOverflowCountQueryModel) graphQLResult2.e).a() == null)) {
            ((RedSpaceMemoryFriendsCache) this.f21280g.get()).m24911a(((RedSpaceFriendsOverflowCountQueryModel) graphQLResult2.e).a().a(), "top");
        }
        if (!(((RedSpaceFriendsQueryModel) graphQLResult.e).a() == null || ((RedSpaceFriendsQueryModel) graphQLResult.e).a().a() == null)) {
            ((RedSpaceMemoryFriendsCache) this.f21280g.get()).f21301d = ((RedSpaceFriendsQueryModel) graphQLResult.e).a().a().a();
        }
        ((RedSpaceMemoryFriendsCache) this.f21280g.get()).m24914a("others");
    }

    public void clearUserData() {
        ((RedSpaceBatchFetcher) this.f21275b.get()).m24923a();
        m24896d();
    }

    final ApproximateCountModel m24898f() {
        return this.f21289p;
    }

    final long m24899g() {
        return this.f21290q;
    }

    public final long m24900h() {
        return ((RedSpaceMemoryFriendsCache) this.f21280g.get()).m24918e("top");
    }

    final long m24901i() {
        return ((RedSpaceMemoryFriendsCache) this.f21280g.get()).m24918e("others");
    }

    private void m24888a(com.facebook.inject.Lazy<FbErrorReporter> lazy, com.facebook.inject.Lazy<RedSpaceBatchFetcher> lazy2, com.facebook.inject.Lazy<RedSpaceRequests> lazy3, com.facebook.inject.Lazy<RedSpaceBatchRequests> lazy4, com.facebook.inject.Lazy<RedSpaceBadgingEventBus> lazy5, com.facebook.inject.Lazy<RedSpaceOptimisticBadgeStore> lazy6, com.facebook.inject.Lazy<RedSpaceMemoryFriendsCache> lazy7, com.facebook.inject.Lazy<QeAccessor> lazy8, com.facebook.inject.Lazy<RedSpaceLogger> lazy9, com.facebook.inject.Lazy<Clock> lazy10, com.facebook.inject.Lazy<AppStateManager> lazy11, Provider<RedSpaceTimeLogger> provider, JewelCounters jewelCounters) {
        this.f21274a = lazy;
        this.f21275b = lazy2;
        this.f21276c = lazy3;
        this.f21277d = lazy4;
        this.f21278e = lazy5;
        this.f21279f = lazy6;
        this.f21280g = lazy7;
        this.f21281h = lazy8;
        this.f21282i = lazy9;
        this.f21283j = lazy10;
        this.f21284k = lazy11;
        this.f21285l = provider;
        this.f21286m = jewelCounters;
    }
}
