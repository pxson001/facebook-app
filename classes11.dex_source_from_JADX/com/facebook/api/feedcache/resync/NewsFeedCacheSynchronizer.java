package com.facebook.api.feedcache.resync;

import android.content.Context;
import android.net.Uri;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.resync.analytics.NewsFeedCacheSyncAnalyticLogger;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdates;
import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesModels.SingleNodeQueryModel;
import com.facebook.api.prefetch.GraphQLPrefetchPriority;
import com.facebook.api.prefetch.GraphQLPrefetcher;
import com.facebook.api.prefetch.GraphQLPrefetcherProvider;
import com.facebook.api.ufiservices.FeedbackBackgroundSyncPolicy;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.photos.FeedImagesCacheStateSynchronizer;
import com.facebook.feed.photos.FeedImagesCacheStateSynchronizer.1;
import com.facebook.feed.photos.FeedImagesCacheStateSynchronizer.2;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.instantarticles.fetcher.InstantArticlesFetcher;
import com.facebook.photos.adaptiveimagequality.base.ImageQuality;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: memory */
public class NewsFeedCacheSynchronizer {
    private static volatile NewsFeedCacheSynchronizer f5459m;
    public final Lazy<GraphQLQueryExecutor> f5460a;
    public final ExecutorService f5461b;
    public final Lazy<DbFeedHomeStoriesHandler> f5462c;
    public final NewsFeedCacheSyncScheduler f5463d;
    public final GraphQLPrefetcher f5464e;
    private final FeedbackBackgroundSyncPolicy f5465f;
    public final NewsFeedCacheSyncAnalyticLogger f5466g;
    public final Lazy<FeedImagesCacheStateSynchronizer> f5467h;
    public final Lazy<NewsFeedCacheSynchonizerHelper> f5468i;
    public final AsyncFeedXConfigReader f5469j;
    public final Lazy<InstantArticlesFetcher> f5470k;
    public final Context f5471l;

    @VisibleForTesting
    /* compiled from: memory */
    public class SyncRunnable implements Runnable {
        public final /* synthetic */ NewsFeedCacheSynchronizer f5457a;
        public final HoneyClientEventFast f5458b;

        /* compiled from: memory */
        public class CacheSyncGraphQLObserver implements RequestObserver<GraphQLResult<SingleNodeQueryModel>> {
            public final /* synthetic */ SyncRunnable f5448a;
            private final Map<String, GraphQLFeedUnitEdge> f5449b;
            private final Builder<String> f5450c = ImmutableList.builder();
            private final Builder<String> f5451d = ImmutableList.builder();
            private final Builder<String> f5452e = ImmutableList.builder();
            private final Builder<GraphQLStory> f5453f = ImmutableList.builder();
            public final Builder<String> f5454g = ImmutableList.builder();
            private final Builder<String> f5455h = ImmutableList.builder();
            private int f5456i;

            public final void m6671a(Object obj) {
                Object obj2;
                SingleNodeQueryModel singleNodeQueryModel = (SingleNodeQueryModel) ((GraphQLResult) obj).e;
                if (singleNodeQueryModel != null) {
                    GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) this.f5449b.get(singleNodeQueryModel.l());
                    if (graphQLFeedUnitEdge != null) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLFeedUnitEdge.c();
                        if (singleNodeQueryModel.j() != null || graphQLStory.L() == null) {
                            String str = (String) graphQLStory.w_().b(3);
                            GraphQLFeedback l = graphQLStory.l();
                            if (l != null) {
                                NewsFeedCacheSynchonizerHelper newsFeedCacheSynchonizerHelper = (NewsFeedCacheSynchonizerHelper) this.f5448a.f5457a.f5468i.get();
                                if (!(newsFeedCacheSynchonizerHelper.f5445f.d(newsFeedCacheSynchonizerHelper.f5446g.a(l.z_()).a((long) newsFeedCacheSynchonizerHelper.f5446g.b()).a(GraphQLCachePolicy.b)) && singleNodeQueryModel.k().a().a() == GraphQLHelper.f(l))) {
                                    this.f5454g.c(l.z_());
                                }
                            }
                            this.f5451d.c(graphQLFeedUnitEdge.b());
                            this.f5452e.c(str);
                            this.f5453f.c(NewsFeedCacheSyncDataUtils.m6647a(graphQLStory, singleNodeQueryModel));
                            if (singleNodeQueryModel.o()) {
                                this.f5450c.c(DedupableUtil.a(graphQLFeedUnitEdge));
                            }
                            if (StringUtil.a(PropertyHelper.c(graphQLFeedUnitEdge), "0")) {
                                String str2;
                                GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                                if (o == null || o.z() == null || o.z().dB() == null) {
                                    str2 = null;
                                } else {
                                    str2 = o.z().dB().m();
                                }
                                String str3 = str2;
                                if (str3 != null) {
                                    this.f5455h.c(str3);
                                }
                            }
                            obj2 = null;
                            if (obj2 != null) {
                                this.f5449b.remove(singleNodeQueryModel.l());
                            }
                        }
                        obj2 = 1;
                        if (obj2 != null) {
                            this.f5449b.remove(singleNodeQueryModel.l());
                        }
                    }
                }
                int i = 1;
                if (obj2 != null) {
                    this.f5449b.remove(singleNodeQueryModel.l());
                }
            }

            public CacheSyncGraphQLObserver(SyncRunnable syncRunnable, Map<String, GraphQLFeedUnitEdge> map) {
                this.f5448a = syncRunnable;
                this.f5449b = map;
                this.f5456i = this.f5449b.size();
            }

            public final void m6670a() {
                ImmutableList b = this.f5453f.b();
                int a = ((DbFeedHomeStoriesHandler) this.f5448a.f5457a.f5462c.get()).a(this.f5451d.b(), this.f5452e.b(), b);
                int a2 = ((DbFeedHomeStoriesHandler) this.f5448a.f5457a.f5462c.get()).a(this.f5450c.b(), FeedType.b);
                int size = this.f5449b.size();
                Integer.valueOf(a);
                Integer.valueOf(size);
                Integer.valueOf(a2);
                this.f5448a.f5457a.f5466g.m6679a(this.f5448a.f5458b, this.f5456i, a, size, a2);
                if (this.f5448a.f5457a.f5469j.b(false)) {
                    ImmutableList b2 = this.f5454g.b();
                    if (!b2.isEmpty()) {
                        int size2 = b2.size();
                        for (int i = 0; i < size2; i++) {
                            this.f5448a.f5457a.f5464e.a(GraphQLPrefetchPriority.HIGH, (String) b2.get(i));
                        }
                    }
                }
                m6666a(b);
                m6667c();
                m6668d();
                m6669e();
            }

            public final void m6672a(Throwable th) {
                BLog.c("NewsFeedCacheSynchronizer", "Received onFailure for graphql fetch", th);
                this.f5448a.f5457a.f5463d.b();
                this.f5448a.f5457a.f5466g.m6681a(this.f5448a.f5458b, th.getMessage());
            }

            private void m6667c() {
                if (this.f5448a.f5457a.f5469j.d(false)) {
                    NewsFeedCacheSynchonizerHelper newsFeedCacheSynchonizerHelper = (NewsFeedCacheSynchonizerHelper) this.f5448a.f5457a.f5468i.get();
                    newsFeedCacheSynchonizerHelper.f5444e.a(newsFeedCacheSynchonizerHelper.f5440a.a("ranking_weight"));
                }
            }

            private void m6668d() {
                if (this.f5448a.f5457a.f5469j.e(false)) {
                    NewsFeedCacheSynchonizerHelper newsFeedCacheSynchonizerHelper = (NewsFeedCacheSynchonizerHelper) this.f5448a.f5457a.f5468i.get();
                    ImmutableList a = newsFeedCacheSynchonizerHelper.f5442c.a(FeedType.b, TimeUnit.HOURS.toMillis((long) newsFeedCacheSynchonizerHelper.f5441b.i()));
                    int size = a.size();
                    int i = 0;
                    int i2 = 0;
                    while (i < size) {
                        int i3;
                        ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) a.get(i);
                        if (clientFeedUnitEdge.z() == 0) {
                            newsFeedCacheSynchonizerHelper.f5443d.a(clientFeedUnitEdge.c());
                            i3 = i2 + 1;
                        } else {
                            i3 = i2;
                        }
                        if (i3 >= 10) {
                            break;
                        }
                        i++;
                        i2 = i3;
                    }
                    newsFeedCacheSynchonizerHelper.f5443d.a(ImageQuality.OFF);
                }
            }

            private void m6666a(ImmutableList<GraphQLStory> immutableList) {
                if (this.f5448a.f5457a.f5469j.c(false)) {
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        ListenableFuture a;
                        FeedImagesCacheStateSynchronizer feedImagesCacheStateSynchronizer = (FeedImagesCacheStateSynchronizer) this.f5448a.f5457a.f5467h.get();
                        String g = ((GraphQLStory) immutableList.get(i)).g();
                        Preconditions.checkNotNull(g);
                        feedImagesCacheStateSynchronizer.d.b();
                        Set a2 = feedImagesCacheStateSynchronizer.a.s.a(g);
                        if (a2 == null || a2.isEmpty()) {
                            a = Futures.a(null);
                        } else {
                            Iterable arrayList = new ArrayList(a2.size());
                            List<String> arrayList2 = new ArrayList(a2.size());
                            arrayList2.addAll(a2);
                            for (String parse : arrayList2) {
                                arrayList.add(DataSourceToFutureAdapter.a(feedImagesCacheStateSynchronizer.b.c(Uri.parse(parse))));
                            }
                            a = Futures.a(Futures.a(arrayList), new 2(feedImagesCacheStateSynchronizer, arrayList2), feedImagesCacheStateSynchronizer.c);
                        }
                        Futures.a(a, new 1(feedImagesCacheStateSynchronizer, g), feedImagesCacheStateSynchronizer.c);
                    }
                }
            }

            private void m6669e() {
                if (this.f5448a.f5457a.f5469j.f(false)) {
                    ImmutableList b = this.f5455h.b();
                    if (!b.isEmpty()) {
                        int size = b.size();
                        for (int i = 0; i < size; i++) {
                            ((InstantArticlesFetcher) this.f5448a.f5457a.f5470k.get()).a(this.f5448a.f5457a.f5471l, (String) b.get(i));
                        }
                    }
                }
            }
        }

        public SyncRunnable(NewsFeedCacheSynchronizer newsFeedCacheSynchronizer, HoneyClientEventFast honeyClientEventFast) {
            this.f5457a = newsFeedCacheSynchronizer;
            this.f5458b = honeyClientEventFast;
        }

        public void run() {
            try {
                Map a = ((NewsFeedCacheSynchonizerHelper) this.f5457a.f5468i.get()).m6664a();
                if (a == null || a.isEmpty()) {
                    this.f5457a.f5466g.m6681a(this.f5458b, "no_cache_found");
                    return;
                }
                CacheSyncGraphQLObserver cacheSyncGraphQLObserver = new CacheSyncGraphQLObserver(this, a);
                GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("NewsFeedCacheSynchronizer");
                List arrayList = new ArrayList(a.size());
                for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : a.values()) {
                    arrayList.add(graphQLBatchRequest.a(GraphQLRequest.a(FetchCachedStoryUpdates.a()).a(new GraphQlQueryParamSet().a("story_id", ((GraphQLStory) graphQLFeedUnitEdge.c()).c()).a("seconds_back", Long.valueOf(259200)).a("dedup_key", DedupableUtil.a(graphQLFeedUnitEdge)))));
                }
                RequestObservable.a(arrayList).a(this.f5457a.f5461b).a(cacheSyncGraphQLObserver);
                ((GraphQLQueryExecutor) this.f5457a.f5460a.get()).a(graphQLBatchRequest);
            } catch (Exception e) {
                this.f5457a.f5466g.m6681a(this.f5458b, e.getMessage());
            }
        }
    }

    public static com.facebook.api.feedcache.resync.NewsFeedCacheSynchronizer m6673a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5459m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.resync.NewsFeedCacheSynchronizer.class;
        monitor-enter(r1);
        r0 = f5459m;	 Catch:{ all -> 0x003a }
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
        r0 = m6674b(r0);	 Catch:{ all -> 0x0035 }
        f5459m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5459m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.resync.NewsFeedCacheSynchronizer.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.resync.NewsFeedCacheSynchronizer");
    }

    private static NewsFeedCacheSynchronizer m6674b(InjectorLike injectorLike) {
        return new NewsFeedCacheSynchronizer(IdBasedLazy.a(injectorLike, 2164), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 232), NewsFeedCacheSyncScheduler.a(injectorLike), FeedbackBackgroundSyncPolicy.b(injectorLike), (GraphQLPrefetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLPrefetcherProvider.class), NewsFeedCacheSyncAnalyticLogger.m6678b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5881), IdBasedLazy.a(injectorLike, 4809), AsyncFeedXConfigReader.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2341), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public NewsFeedCacheSynchronizer(Lazy<GraphQLQueryExecutor> lazy, ExecutorService executorService, Lazy<DbFeedHomeStoriesHandler> lazy2, NewsFeedCacheSyncScheduler newsFeedCacheSyncScheduler, FeedbackBackgroundSyncPolicy feedbackBackgroundSyncPolicy, GraphQLPrefetcherProvider graphQLPrefetcherProvider, NewsFeedCacheSyncAnalyticLogger newsFeedCacheSyncAnalyticLogger, Lazy<FeedImagesCacheStateSynchronizer> lazy3, Lazy<NewsFeedCacheSynchonizerHelper> lazy4, AsyncFeedXConfigReader asyncFeedXConfigReader, Lazy<InstantArticlesFetcher> lazy5, Context context) {
        this.f5460a = lazy;
        this.f5461b = executorService;
        this.f5462c = lazy2;
        this.f5463d = newsFeedCacheSyncScheduler;
        this.f5465f = feedbackBackgroundSyncPolicy;
        this.f5464e = graphQLPrefetcherProvider.a(this.f5465f);
        this.f5466g = newsFeedCacheSyncAnalyticLogger;
        this.f5467h = lazy3;
        this.f5468i = lazy4;
        this.f5469j = asyncFeedXConfigReader;
        this.f5470k = lazy5;
        this.f5471l = context;
    }

    public final void m6675a() {
        this.f5463d.a(new SyncRunnable(this, this.f5466g.f5473b.a("android_async_feed_cache_sync", false)));
    }

    public final void m6676b() {
        this.f5463d.b();
    }
}
