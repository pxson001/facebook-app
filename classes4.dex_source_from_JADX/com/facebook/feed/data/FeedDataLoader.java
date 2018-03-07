package com.facebook.feed.data;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.FetchFeedResultCount;
import com.facebook.api.feed.data.FetchFeedDirection;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feed.data.ViewPortShift;
import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feed.xconfig.NewsFeedXConfig;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.DiskCacheReadException;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstartup.AppStartupTracker;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.bugreporter.FeedLoadingDebugInfo;
import com.facebook.feed.data.FeedDataLoaderReranker.2;
import com.facebook.feed.data.typemanager.PreferredFeedTypeManager;
import com.facebook.feed.loader.AutoRefreshScheduler;
import com.facebook.feed.loader.AutoRefreshScheduler.RefreshSchedulerCallback;
import com.facebook.feed.loader.AutoRefreshSchedulerProvider;
import com.facebook.feed.loader.EmptyFeedTracker;
import com.facebook.feed.loader.EndOfCachedFeedState;
import com.facebook.feed.loader.FeedDataLoaderHelper;
import com.facebook.feed.loader.FeedDataLoaderInitializationParams;
import com.facebook.feed.loader.FeedLoaderParams;
import com.facebook.feed.loader.FetchFeedParamsGenerator;
import com.facebook.feed.loader.HeadLoaderStatus;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.feed.loader.InitializationStatus;
import com.facebook.feed.loader.InitializationStatus.Type;
import com.facebook.feed.loader.LoadIntentHint;
import com.facebook.feed.loader.OnlineFeedGapConditionCheck;
import com.facebook.feed.loader.StoryRankingTimeTracker;
import com.facebook.feed.loader.StoryRankingTimeTracker.HitPreviouslyRankedStoriesListener;
import com.facebook.feed.loader.TailLoaderStatus;
import com.facebook.feed.logging.CacheStateLogger;
import com.facebook.feed.logging.RerankingEventsLogger;
import com.facebook.feed.logging.RerankingEventsLogger.FetchStats;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.feed.logging.viewport.RecentVpvs;
import com.facebook.feed.model.FetchResultState;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.protocol.FeedReliabilityLogger;
import com.facebook.feed.pulltorefresh.PullToRefreshLogger;
import com.facebook.feed.sponsored.SponsoredFeedUnitValidator;
import com.facebook.feed.ui.imageloader.AsyncFeedImagePrefetcher;
import com.facebook.feed.ui.imageloader.FeedImagePreloader;
import com.facebook.feed.ui.imageloader.FeedImagePreloaderProvider;
import com.facebook.feed.util.composer.OfflinePostLoader;
import com.facebook.feed.util.composer.OfflinePostLoader.Listener;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.RequestSubscriber;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFindFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLFindGroupsFeedUnit;
import com.facebook.graphql.model.GraphQLFindPagesFeedUnit;
import com.facebook.graphql.model.GraphQLNoContentFeedUnit;
import com.facebook.graphql.model.GraphQLNoContentGoodFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.http.protocol.UDPPrimingHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefetch.feed.scheduler.NewsFeedPrefetcher;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@NotThreadSafe
/* compiled from: webrtc_voip_call */
public class FeedDataLoader extends BaseFeedDataLoader implements IFeedDataLoader, HitPreviouslyRankedStoriesListener {
    private static final CallerContext f108D = CallerContext.a(FeedDataLoader.class, "native_newsfeed");
    public static final String f109E = FeedDataLoader.class.getSimpleName();
    @VisibleForTesting
    protected ListenableScheduledFuture f110A;
    @VisibleForTesting
    protected FetchFeedCause f111B;
    public int f112C = 0;
    private final DefaultBlueServiceOperationFactory f113F;
    private final DefaultAndroidThreadUtil f114G;
    private final AutoRefreshScheduler f115H;
    private final DefaultAppChoreographer f116I;
    private final AbstractFbErrorReporter f117J;
    private final Lazy<Boolean> f118K;
    public final Lazy<ExecutorService> f119L;
    private final Lazy<FeedLoadingDebugInfo> f120M;
    public final Lazy<SponsoredFeedUnitValidator> f121N;
    private final boolean f122O;
    private final FbSharedPreferences f123P;
    private final Lazy<TriState> f124Q;
    private final Lazy<TriState> f125R;
    private final Lazy<User> f126S;
    private final Provider<Boolean> f127T;
    private final Lazy<OfflinePostLoader> f128U;
    public final AppStartupTracker f129V;
    private final Lazy<PreferredFeedTypeManager> f130W;
    private final FeedReliabilityLogger f131X;
    private final MissedStoryBumpInfoChecker f132Y;
    private final FeedFetcher f133Z;
    public final Lazy<UDPPrimingHelper> aa;
    public final FeedDataLoaderReranker ab;
    private final AsyncFeedXConfigReader ac;
    private final Lazy<NewsFeedPrefetcher> ad;
    public final AnalyticsLogger ae;
    private final OnlineFeedGapConditionCheck af;
    private final ListeningScheduledExecutorService ag;
    public final QeAccessor ah;
    public final Clock ai;
    public final EndOfCachedFeedState aj;
    private final EmptyFeedTracker ak;
    private final Lazy<CacheStateLogger> al;
    private final PullToRefreshLogger am;
    public final RecentVpvs an;
    public final FeedDataLoaderHelper ao;
    public final RerankingEventsLogger ap;
    public final FeedImagePreloaderProvider aq;
    public final Lazy<AsyncFeedImagePrefetcher> ar;
    public FeedImagePreloader as;
    public long at = 0;
    public long au = 0;
    public RerankingStatus av;
    public SkipTailGapStatus aw;
    public StoryRankingTimeTracker ax;
    @VisibleForTesting
    protected RequestSubscriber<FetchFeedResult> f134p;
    @VisibleForTesting
    protected RequestSubscriber<FetchFeedResult> f135q;
    @VisibleForTesting
    protected FutureAndCallbackHolder<OperationResult> f136r;
    @VisibleForTesting
    protected RequestSubscriber<FetchFeedResult> f137s;
    @VisibleForTesting
    protected RequestSubscriber<FetchFeedResult> f138t;
    @VisibleForTesting
    public HeadLoaderStatus f139u;
    @VisibleForTesting
    public TailLoaderStatus f140v;
    protected boolean f141w = false;
    protected boolean f142x = false;
    protected boolean f143y = false;
    @VisibleForTesting
    protected boolean f144z = false;

    /* compiled from: webrtc_voip_call */
    class FeedDataLoaderRefreshCallback implements RefreshSchedulerCallback {
        final /* synthetic */ FeedDataLoader f173a;

        public FeedDataLoaderRefreshCallback(FeedDataLoader feedDataLoader) {
            this.f173a = feedDataLoader;
        }

        public final void m205a() {
            if (!((FbNetworkManager) this.f173a.d.get()).d()) {
                return;
            }
            if (this.f173a.ah.a(ExperimentsForNewsFeedAbTestModule.d, false)) {
                this.f173a.m167a(FetchFeedCause.POLLING);
            } else {
                this.f173a.m173f();
            }
        }

        public final long m206b() {
            this.f173a.z();
            if (PerfTestConfigBase.a()) {
                this.f173a.z();
                if (PerfTestConfigBase.e != 0) {
                    this.f173a.z();
                    return PerfTestConfigBase.e;
                }
            }
            if (!this.f173a.ah.a(ExperimentsForNewsFeedAbTestModule.S, false) || this.f173a.ax == null || this.f173a.ax.d() || this.f173a.ax.c()) {
                return this.f173a.ah.a(ExperimentsForNewsFeedAbTestModule.j, 540000);
            }
            return this.f173a.ah.a(ExperimentsForNewsFeedAbTestModule.Q, 540000);
        }

        public final long m207c() {
            return this.f173a.ah.a(ExperimentsForNewsFeedAbTestModule.P, 0);
        }

        public final long m208d() {
            return this.f173a.ah.a(ExperimentsForNewsFeedAbTestModule.R, 540000);
        }
    }

    /* compiled from: webrtc_voip_call */
    public enum RerankingStatus {
        NOT_SCHEDULED,
        SCHEDULED,
        INSTANT_RERANKED,
        SCHEDULED_RERANKED
    }

    /* compiled from: webrtc_voip_call */
    public enum SkipTailGapStatus {
        NOT_SCHEDULED,
        SCHEDULED,
        FINISHED_WITH_DATA,
        FINISHED_WITH_DATA_AT_LEAST_ONCE,
        FINISHED_WITH_NO_DATA;

        public final boolean finishedWithDataOnce() {
            return this == FINISHED_WITH_DATA || this == FINISHED_WITH_DATA_AT_LEAST_ONCE;
        }

        public final boolean canSchedule() {
            return this == NOT_SCHEDULED || this == FINISHED_WITH_DATA;
        }

        public final boolean finishNetworkTailFetch() {
            return this == FINISHED_WITH_DATA;
        }
    }

    /* compiled from: webrtc_voip_call */
    public class C00371 {
        public final /* synthetic */ FeedDataLoader f395a;

        C00371(FeedDataLoader feedDataLoader) {
            this.f395a = feedDataLoader;
        }
    }

    /* compiled from: webrtc_voip_call */
    /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] f456b = new int[FetchResultState.values().length];

        static {
            try {
                f456b[FetchResultState.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f456b[FetchResultState.CANCELLATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f456b[FetchResultState.EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f456b[FetchResultState.SERVICE_EXCEPTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f455a = new int[FetchFeedDirection.values().length];
            try {
                f455a[FetchFeedDirection.AFTER.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f455a[FetchFeedDirection.BEFORE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: webrtc_voip_call */
    class C03334 implements Listener {
        final /* synthetic */ FeedDataLoader f7021a;

        C03334(FeedDataLoader feedDataLoader) {
            this.f7021a = feedDataLoader;
        }

        public final void mo589a() {
            this.f7021a.m.a();
        }

        public final void mo591b() {
            this.f7021a.m.c();
        }

        public final boolean mo590a(long j, GraphQLStory graphQLStory) {
            return this.f7021a.ao.a(this.f7021a.n, j, graphQLStory);
        }
    }

    private void m135a(com.facebook.api.feed.FetchFeedResult r15, com.facebook.api.feed.data.FetchFeedDirection r16, boolean r17, long r18) {
        /* JADX: method processing error */
/*
Error: java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:463)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
*/
        /*
        r14 = this;
        r2 = "FeedDataLoader.onFetchFeedSuccess";
        r3 = 1749750200; // 0x684b11b8 float:3.835869E24 double:8.644914626E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r3);
        r2 = r15.g();	 Catch:{ all -> 0x00db }
        r6 = r2.h();	 Catch:{ all -> 0x00db }
        if (r17 != 0) goto L_0x001b;	 Catch:{ all -> 0x00db }
    L_0x0012:
        r2 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.RERANK;	 Catch:{ all -> 0x00db }
        if (r6 == r2) goto L_0x001b;	 Catch:{ all -> 0x00db }
    L_0x0016:
        r0 = r16;	 Catch:{ all -> 0x00db }
        m140a(r14, r0);	 Catch:{ all -> 0x00db }
    L_0x001b:
        r2 = com.facebook.api.feed.data.FetchFeedDirection.BEFORE;	 Catch:{ all -> 0x00db }
        r0 = r16;	 Catch:{ all -> 0x00db }
        if (r0 != r2) goto L_0x0028;	 Catch:{ all -> 0x00db }
    L_0x0021:
        r2 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.RERANK;	 Catch:{ all -> 0x00db }
        if (r6 == r2) goto L_0x0028;	 Catch:{ all -> 0x00db }
    L_0x0025:
        m120O(r14);	 Catch:{ all -> 0x00db }
    L_0x0028:
        r5 = com.facebook.api.feed.data.FetchPortion.FULL;	 Catch:{ all -> 0x00db }
        r2 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.RERANK;	 Catch:{ all -> 0x00db }
        if (r6 != r2) goto L_0x00e3;	 Catch:{ all -> 0x00db }
    L_0x002e:
        r2 = com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event.PTR_RERANKING_COMPLETE;	 Catch:{ all -> 0x00db }
        r14.a(r2);	 Catch:{ all -> 0x00db }
        r2 = m149a(r15);	 Catch:{ all -> 0x00db }
        if (r2 == 0) goto L_0x00c2;	 Catch:{ all -> 0x00db }
    L_0x0039:
        r2 = com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event.PTR_RERANKING_NO_RESULTS;	 Catch:{ all -> 0x00db }
        r14.a(r2);	 Catch:{ all -> 0x00db }
    L_0x003e:
        r9 = r15.a();	 Catch:{ all -> 0x00db }
        r2 = com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event.DATA_LOADED;	 Catch:{ all -> 0x00db }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00db }
        r4 = "Direction: ";	 Catch:{ all -> 0x00db }
        r3.<init>(r4);	 Catch:{ all -> 0x00db }
        r0 = r16;	 Catch:{ all -> 0x00db }
        r3 = r3.append(r0);	 Catch:{ all -> 0x00db }
        r4 = " Size:";	 Catch:{ all -> 0x00db }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00db }
        r4 = r15.c();	 Catch:{ all -> 0x00db }
        r4 = r4.k();	 Catch:{ all -> 0x00db }
        r4 = r4.size();	 Catch:{ all -> 0x00db }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00db }
        r3 = r3.toString();	 Catch:{ all -> 0x00db }
        r14.a(r2, r3);	 Catch:{ all -> 0x00db }
        r2 = com.facebook.api.feed.data.FetchFeedDirection.BEFORE;	 Catch:{ all -> 0x00db }
        r0 = r16;	 Catch:{ all -> 0x00db }
        if (r0 != r2) goto L_0x00a6;	 Catch:{ all -> 0x00db }
    L_0x0074:
        r2 = r15.d();	 Catch:{ all -> 0x00db }
        r3 = r2.size();	 Catch:{ all -> 0x00db }
        r2 = r14.am;	 Catch:{ all -> 0x00db }
        r2.a(r3);	 Catch:{ all -> 0x00db }
        r2 = r14.f132Y;	 Catch:{ all -> 0x00db }
        r4 = r14.b;	 Catch:{ all -> 0x00db }
        r7 = r14.am;	 Catch:{ all -> 0x00db }
        r10 = r7.c();	 Catch:{ all -> 0x00db }
        r2 = r2.m186a(r15, r4, r10);	 Catch:{ all -> 0x00db }
        r4 = r14.am;	 Catch:{ all -> 0x00db }
        r4.a(r2);	 Catch:{ all -> 0x00db }
        r2 = r14.am;	 Catch:{ all -> 0x00db }
        r2.e();	 Catch:{ all -> 0x00db }
        r2 = r14.al;	 Catch:{ all -> 0x00db }
        r2 = r2.get();	 Catch:{ all -> 0x00db }
        r2 = (com.facebook.feed.logging.CacheStateLogger) r2;	 Catch:{ all -> 0x00db }
        r4 = r14.n;	 Catch:{ all -> 0x00db }
        r2.m754a(r4, r3);	 Catch:{ all -> 0x00db }
    L_0x00a6:
        r3 = r15.d();	 Catch:{ all -> 0x00db }
        if (r3 == 0) goto L_0x00b2;	 Catch:{ all -> 0x00db }
    L_0x00ac:
        r2 = r15.e();	 Catch:{ all -> 0x00db }
        if (r2 != 0) goto L_0x00f8;	 Catch:{ all -> 0x00db }
    L_0x00b2:
        r2 = com.facebook.fbservice.results.DataFreshnessResult.FROM_SERVER;	 Catch:{ all -> 0x00db }
        if (r9 != r2) goto L_0x00bb;	 Catch:{ all -> 0x00db }
    L_0x00b6:
        r2 = r14.f131X;	 Catch:{ all -> 0x00db }
        r2.a(r15);	 Catch:{ all -> 0x00db }
    L_0x00bb:
        r2 = -736453062; // 0xffffffffd41a9e3a float:-2.65631826E12 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2);
    L_0x00c1:
        return;
    L_0x00c2:
        r2 = r14.b;	 Catch:{  }
        r2.m();	 Catch:{  }
        m119N(r14);	 Catch:{  }
        r2 = r14.f135q;	 Catch:{  }
        if (r2 == 0) goto L_0x00d6;	 Catch:{  }
    L_0x00ce:
        r2 = r14.f135q;	 Catch:{  }
        r2.c();	 Catch:{  }
        r2 = 0;	 Catch:{  }
        r14.f135q = r2;	 Catch:{  }
    L_0x00d6:
        m123T(r14);	 Catch:{  }
        goto L_0x003e;
    L_0x00db:
        r2 = move-exception;
        r3 = -1139094528; // 0xffffffffbc1acc00 float:-0.009448051 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);
        throw r2;
    L_0x00e3:
        r2 = com.facebook.api.feed.data.FetchFeedDirection.BEFORE;	 Catch:{  }
        r0 = r16;	 Catch:{  }
        if (r0 != r2) goto L_0x003e;	 Catch:{  }
    L_0x00e9:
        r2 = r14.f139u;	 Catch:{  }
        r5 = r2.i();	 Catch:{  }
        r2 = r14.f139u;	 Catch:{  }
        r3 = com.facebook.api.feed.data.FetchPortion.CHUNKED_REMAINDER;	 Catch:{  }
        r2.a(r3);	 Catch:{  }
        goto L_0x003e;	 Catch:{  }
    L_0x00f8:
        r2 = r15.d();	 Catch:{  }
        r2 = r2.isEmpty();	 Catch:{  }
        if (r2 == 0) goto L_0x0235;	 Catch:{  }
    L_0x0102:
        r2 = r14.ak;	 Catch:{  }
        r0 = r16;	 Catch:{  }
        r2.m202a(r0);	 Catch:{  }
        r2 = com.facebook.fbservice.results.DataFreshnessResult.FROM_SERVER;	 Catch:{  }
        if (r9 != r2) goto L_0x0122;	 Catch:{  }
    L_0x010d:
        r2 = r15.g();	 Catch:{  }
        r2 = r2.c();	 Catch:{  }
        if (r2 != 0) goto L_0x0122;	 Catch:{  }
    L_0x0117:
        r2 = com.facebook.api.feed.data.FetchFeedDirection.AFTER;	 Catch:{  }
        r0 = r16;	 Catch:{  }
        if (r0 != r2) goto L_0x0122;	 Catch:{  }
    L_0x011d:
        r2 = r14.f131X;	 Catch:{  }
        r2.b(r15);	 Catch:{  }
    L_0x0122:
        r2 = com.facebook.api.feed.data.FetchFeedDirection.BEFORE;	 Catch:{  }
        r0 = r16;	 Catch:{  }
        if (r0 != r2) goto L_0x023c;	 Catch:{  }
    L_0x0128:
        r2 = 1;	 Catch:{  }
        r12 = r2;	 Catch:{  }
    L_0x012a:
        r2 = 0;	 Catch:{  }
        r4 = r14.f144z;	 Catch:{  }
        if (r4 == 0) goto L_0x0240;	 Catch:{  }
    L_0x012f:
        r4 = r3.size();	 Catch:{  }
        r14.m130a(r4);	 Catch:{  }
    L_0x0136:
        r11 = 0;	 Catch:{  }
        if (r12 == 0) goto L_0x0145;	 Catch:{  }
    L_0x0139:
        if (r2 != 0) goto L_0x0145;	 Catch:{  }
    L_0x013b:
        r2 = com.facebook.fbservice.results.DataFreshnessResult.FROM_SERVER;	 Catch:{  }
        if (r9 != r2) goto L_0x0145;	 Catch:{  }
    L_0x013f:
        r2 = r14.b;	 Catch:{  }
        r11 = r2.a(r3);	 Catch:{  }
    L_0x0145:
        r2 = r14.m;	 Catch:{  }
        r2.a();	 Catch:{  }
        r2 = 0;	 Catch:{  }
        if (r12 == 0) goto L_0x0155;	 Catch:{  }
    L_0x014d:
        r4 = r14.b;	 Catch:{  }
        r4 = r4.r();	 Catch:{  }
        if (r4 != 0) goto L_0x0293;	 Catch:{  }
    L_0x0155:
        r4 = r15.e();	 Catch:{  }
        r4 = r4.b();	 Catch:{  }
        if (r4 != 0) goto L_0x0293;	 Catch:{  }
    L_0x015f:
        r4 = r15.g();	 Catch:{  }
        r4 = r4.c();	 Catch:{  }
        if (r4 != 0) goto L_0x0293;	 Catch:{  }
    L_0x0169:
        r4 = r15.a();	 Catch:{  }
        r7 = com.facebook.fbservice.results.DataFreshnessResult.FROM_SERVER;	 Catch:{  }
        if (r4 != r7) goto L_0x0293;	 Catch:{  }
    L_0x0171:
        r2 = r14.c;	 Catch:{  }
        r4 = r2.c();	 Catch:{  }
        r2 = r14.c;	 Catch:{  }
        r2.a();	 Catch:{  }
        r2 = r14.m122Q();	 Catch:{  }
        if (r4 != 0) goto L_0x018f;	 Catch:{  }
    L_0x0182:
        r4 = r14.c;	 Catch:{  }
        r4 = r4.c();	 Catch:{  }
        if (r4 == 0) goto L_0x018f;	 Catch:{  }
    L_0x018a:
        r4 = r14.f131X;	 Catch:{  }
        r4.b(r15);	 Catch:{  }
    L_0x018f:
        r4 = r2;	 Catch:{  }
    L_0x0190:
        r2 = 0;	 Catch:{  }
        if (r12 == 0) goto L_0x0290;	 Catch:{  }
    L_0x0193:
        r2 = r14.m158c(r6);	 Catch:{  }
        if (r2 != 0) goto L_0x01a7;	 Catch:{  }
    L_0x0199:
        r2 = r14.m159d(r6);	 Catch:{  }
        if (r2 != 0) goto L_0x01a7;	 Catch:{  }
    L_0x019f:
        r2 = r14.a;	 Catch:{  }
        r2 = r2.u();	 Catch:{  }
        if (r2 == 0) goto L_0x0256;	 Catch:{  }
    L_0x01a7:
        r2 = 1;	 Catch:{  }
    L_0x01a8:
        r8 = r2;	 Catch:{  }
    L_0x01a9:
        r2 = r14.f111B;	 Catch:{  }
        r10 = r2.isAutoRefresh();	 Catch:{  }
        r2 = r15.c();	 Catch:{  }
        r2 = r2.k();	 Catch:{  }
        r2 = r2.isEmpty();	 Catch:{  }
        if (r2 != 0) goto L_0x01c7;	 Catch:{  }
    L_0x01bd:
        r2 = r15.c();	 Catch:{  }
        r2 = r2.m();	 Catch:{  }
        r14.f143y = r2;	 Catch:{  }
    L_0x01c7:
        if (r12 == 0) goto L_0x025e;	 Catch:{  }
    L_0x01c9:
        r2 = com.facebook.fbservice.results.DataFreshnessResult.FROM_SERVER;	 Catch:{  }
        if (r9 != r2) goto L_0x0259;	 Catch:{  }
    L_0x01cd:
        r7 = 1;	 Catch:{  }
    L_0x01ce:
        r2 = r3.isEmpty();	 Catch:{  }
        if (r2 != 0) goto L_0x01db;	 Catch:{  }
    L_0x01d4:
        if (r7 == 0) goto L_0x01db;	 Catch:{  }
    L_0x01d6:
        r2 = r14.b;	 Catch:{  }
        r2.e();	 Catch:{  }
    L_0x01db:
        r2 = r14.b;	 Catch:{  }
        r4 = r15.e();	 Catch:{  }
        if (r7 == 0) goto L_0x025c;	 Catch:{  }
    L_0x01e3:
        if (r10 != 0) goto L_0x01e7;	 Catch:{  }
    L_0x01e5:
        if (r8 == 0) goto L_0x025c;	 Catch:{  }
    L_0x01e7:
        r6 = 1;	 Catch:{  }
    L_0x01e8:
        r2.a(r3, r4, r5, r6, r7);	 Catch:{  }
        r2 = r14.ab;	 Catch:{  }
        r2 = r2.h();	 Catch:{  }
        if (r2 == 0) goto L_0x01fc;	 Catch:{  }
    L_0x01f3:
        if (r7 == 0) goto L_0x01fc;	 Catch:{  }
    L_0x01f5:
        if (r10 != 0) goto L_0x01f9;	 Catch:{  }
    L_0x01f7:
        if (r8 == 0) goto L_0x01fc;	 Catch:{  }
    L_0x01f9:
        r14.m155b(r3);	 Catch:{  }
    L_0x01fc:
        r2 = com.facebook.fbservice.results.DataFreshnessResult.FROM_CACHE_UP_TO_DATE;	 Catch:{  }
        if (r9 == r2) goto L_0x0204;	 Catch:{  }
    L_0x0200:
        r2 = com.facebook.fbservice.results.DataFreshnessResult.FROM_SERVER;	 Catch:{  }
        if (r9 != r2) goto L_0x020e;	 Catch:{  }
    L_0x0204:
        r2 = r14.f115H;	 Catch:{  }
        r0 = r18;	 Catch:{  }
        r2.c(r0);	 Catch:{  }
        r14.m146a(r3);	 Catch:{  }
    L_0x020e:
        r14.m137a(r15, r9);	 Catch:{  }
        r14.m136a(r15, r5);	 Catch:{  }
        if (r8 == 0) goto L_0x028d;	 Catch:{  }
    L_0x0216:
        r2 = r14.ab;	 Catch:{  }
        r2 = r2.i();	 Catch:{  }
        if (r2 == 0) goto L_0x028d;	 Catch:{  }
    L_0x021e:
        r13 = com.facebook.api.feed.data.ViewPortShift.Avoid;	 Catch:{  }
    L_0x0220:
        r9 = com.facebook.feed.model.FetchResultState.SUCCESS;	 Catch:{  }
        r10 = 0;	 Catch:{  }
        r6 = r14;	 Catch:{  }
        r7 = r12;	 Catch:{  }
        r8 = r15;	 Catch:{  }
        r12 = r5;	 Catch:{  }
        r6.m147a(r7, r8, r9, r10, r11, r12, r13);	 Catch:{  }
        r14.x();	 Catch:{  }
        r2 = -233089881; // 0xfffffffff21b54a7 float:-3.076641E30 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2);
        goto L_0x00c1;
    L_0x0235:
        r2 = r14.ak;	 Catch:{  }
        r2.m201a();	 Catch:{  }
        goto L_0x0122;	 Catch:{  }
    L_0x023c:
        r2 = 0;	 Catch:{  }
        r12 = r2;	 Catch:{  }
        goto L_0x012a;	 Catch:{  }
    L_0x0240:
        if (r12 == 0) goto L_0x0136;	 Catch:{  }
    L_0x0242:
        r4 = r14.ak;	 Catch:{  }
        r4 = r4.m203b();	 Catch:{  }
        if (r4 == 0) goto L_0x0136;	 Catch:{  }
    L_0x024a:
        r4 = r14.n;	 Catch:{  }
        r4 = r14.m129a(r3, r4);	 Catch:{  }
        if (r3 == r4) goto L_0x0136;	 Catch:{  }
    L_0x0252:
        r2 = 1;	 Catch:{  }
        r3 = r4;	 Catch:{  }
        goto L_0x0136;	 Catch:{  }
    L_0x0256:
        r2 = 0;	 Catch:{  }
        goto L_0x01a8;	 Catch:{  }
    L_0x0259:
        r7 = 0;	 Catch:{  }
        goto L_0x01ce;	 Catch:{  }
    L_0x025c:
        r6 = 0;	 Catch:{  }
        goto L_0x01e8;	 Catch:{  }
    L_0x025e:
        r2 = r14.aw;	 Catch:{  }
        r2 = r2.finishedWithDataOnce();	 Catch:{  }
        if (r2 == 0) goto L_0x027a;	 Catch:{  }
    L_0x0266:
        r2 = com.facebook.feed.loader.OnlineFeedGapConditionCheck.m198b();	 Catch:{  }
        if (r2 == 0) goto L_0x027a;	 Catch:{  }
    L_0x026c:
        r2 = r14.af;	 Catch:{  }
        r2 = r2.m199d();	 Catch:{  }
        if (r2 == 0) goto L_0x027a;	 Catch:{  }
    L_0x0274:
        r2 = r14.b;	 Catch:{  }
        r2.b(r3);	 Catch:{  }
        goto L_0x020e;	 Catch:{  }
    L_0x027a:
        if (r4 == 0) goto L_0x0283;	 Catch:{  }
    L_0x027c:
        r2 = r14.m156c(r3);	 Catch:{  }
        if (r3 == r2) goto L_0x0283;	 Catch:{  }
    L_0x0282:
        r3 = r2;	 Catch:{  }
    L_0x0283:
        r2 = r14.b;	 Catch:{  }
        r4 = r15.e();	 Catch:{  }
        r2.a(r3, r4);	 Catch:{  }
        goto L_0x020e;	 Catch:{  }
    L_0x028d:
        r13 = com.facebook.api.feed.data.ViewPortShift.Perform;	 Catch:{  }
        goto L_0x0220;
    L_0x0290:
        r8 = r2;
        goto L_0x01a9;
    L_0x0293:
        r4 = r2;
        goto L_0x0190;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.FeedDataLoader.a(com.facebook.api.feed.FetchFeedResult, com.facebook.api.feed.data.FetchFeedDirection, boolean, long):void");
    }

    public static FeedDataLoader m152b(InjectorLike injectorLike) {
        return new FeedDataLoader((Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), DefaultAppChoreographer.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (AutoRefreshSchedulerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoRefreshSchedulerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 1721), IdBasedLazy.a(injectorLike, 3987), IdBasedSingletonScopeProvider.b(injectorLike, 3841), IdBasedSingletonScopeProvider.b(injectorLike, 5838), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 673), IdBasedLazy.a(injectorLike, 674), IdBasedLazy.a(injectorLike, 3595), IdBasedLazy.a(injectorLike, 1755), IdBasedSingletonScopeProvider.b(injectorLike, 1423), PullToRefreshLogger.a(injectorLike), NewsFeedEventLogger.a(injectorLike), AppStartupTracker.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 1321), FeedReliabilityLogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FeedDataLoaderHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 3888), MissedStoryBumpInfoChecker.m184a(injectorLike), RecentVpvs.a(injectorLike), EndOfCachedFeedState.m187a(injectorLike), FeedFetcher.m189a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2290), FeedDataLoaderReranker.a(injectorLike), AsyncFeedXConfigReader.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3071), OnlineFeedGapConditionCheck.m196a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), EmptyFeedTracker.m200a(injectorLike), RerankingEventsLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6084), (FeedImagePreloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedImagePreloaderProvider.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @VisibleForTesting
    protected final void m163a(FetchFeedParams fetchFeedParams, boolean z, SettableFuture<FetchFeedResult> settableFuture) {
        FetchFeedParamsBuilder a = new FetchFeedParamsBuilder().a(fetchFeedParams).a(FetchFeedCause.SKIP_TAIL_GAP);
        a.a = DataFreshnessParam.DO_NOT_CHECK_SERVER;
        a = a;
        a.p = true;
        FetchFeedParams q = a.q();
        DataFreshnessParam dataFreshnessParam = DataFreshnessParam.DO_NOT_CHECK_SERVER;
        this.f138t = m127a(dataFreshnessParam, z, q, (SettableFuture) settableFuture);
        this.f133Z.m190a(new FeedLoaderParams(q, dataFreshnessParam, this.o.b(), this.f138t, this.n.g.A + "_after", this.ai.a()));
    }

    @Inject
    public FeedDataLoader(Context context, BlueServiceOperationFactory blueServiceOperationFactory, AndroidThreadUtil androidThreadUtil, AppChoreographer appChoreographer, FbErrorReporter fbErrorReporter, AutoRefreshSchedulerProvider autoRefreshSchedulerProvider, Lazy<SponsoredFeedUnitValidator> lazy, Lazy<Boolean> lazy2, Lazy<ExecutorService> lazy3, Lazy<FeedLoadingDebugInfo> lazy4, Boolean bool, FbSharedPreferences fbSharedPreferences, Lazy<TriState> lazy5, Lazy<TriState> lazy6, Lazy<User> lazy7, Lazy<OfflinePostLoader> lazy8, Lazy<CacheStateLogger> lazy9, PullToRefreshLogger pullToRefreshLogger, NewsFeedEventLogger newsFeedEventLogger, AppStartupTracker appStartupTracker, Lazy<PreferredFeedTypeManager> lazy10, FeedReliabilityLogger feedReliabilityLogger, QeAccessor qeAccessor, FeedDataLoaderHelper feedDataLoaderHelper, Provider<Boolean> provider, MissedStoryBumpInfoChecker missedStoryBumpInfoChecker, RecentVpvs recentVpvs, EndOfCachedFeedState endOfCachedFeedState, FeedFetcher feedFetcher, Lazy<UDPPrimingHelper> lazy11, FeedDataLoaderReranker feedDataLoaderReranker, AsyncFeedXConfigReader asyncFeedXConfigReader, Lazy<NewsFeedPrefetcher> lazy12, OnlineFeedGapConditionCheck onlineFeedGapConditionCheck, ListeningScheduledExecutorService listeningScheduledExecutorService, EmptyFeedTracker emptyFeedTracker, RerankingEventsLogger rerankingEventsLogger, Lazy<AsyncFeedImagePrefetcher> lazy13, FeedImagePreloaderProvider feedImagePreloaderProvider, AnalyticsLogger analyticsLogger, Clock clock) {
        super(context);
        this.f113F = blueServiceOperationFactory;
        this.f114G = androidThreadUtil;
        this.f116I = appChoreographer;
        this.f117J = fbErrorReporter;
        this.f121N = lazy;
        this.ah = qeAccessor;
        this.ad = lazy12;
        this.ae = analyticsLogger;
        this.ai = clock;
        this.f115H = autoRefreshSchedulerProvider.a(new FeedDataLoaderRefreshCallback(this));
        this.f127T = provider;
        this.f118K = lazy2;
        this.f119L = lazy3;
        this.f120M = lazy4;
        this.f122O = bool.booleanValue();
        this.f123P = fbSharedPreferences;
        this.f124Q = lazy5;
        this.f125R = lazy6;
        this.f126S = lazy7;
        this.f128U = lazy8;
        this.aj = endOfCachedFeedState;
        this.ak = emptyFeedTracker;
        this.f132Y = missedStoryBumpInfoChecker;
        this.f114G.a();
        this.f139u = new HeadLoaderStatus(newsFeedEventLogger);
        this.f140v = new TailLoaderStatus(newsFeedEventLogger);
        this.al = lazy9;
        this.am = pullToRefreshLogger;
        this.f129V = appStartupTracker;
        this.f130W = lazy10;
        this.f131X = feedReliabilityLogger;
        this.ao = feedDataLoaderHelper;
        this.an = recentVpvs;
        this.at = this.f123P.a(FeedPrefKeys.e, 0);
        this.f115H.c(this.at);
        this.f133Z = feedFetcher;
        this.aa = lazy11;
        this.ab = feedDataLoaderReranker;
        this.ac = asyncFeedXConfigReader;
        this.af = onlineFeedGapConditionCheck;
        this.ag = listeningScheduledExecutorService;
        this.ap = rerankingEventsLogger;
        this.f111B = FetchFeedCause.UNKNOWN;
        this.aq = feedImagePreloaderProvider;
        this.ar = lazy13;
        this.f.a(f108D);
    }

    private int m112E() {
        NewsFeedXConfigReader newsFeedXConfigReader = this.a;
        if (newsFeedXConfigReader.c == -1) {
            newsFeedXConfigReader.c = newsFeedXConfigReader.a.a(NewsFeedXConfig.d, 10);
        }
        return newsFeedXConfigReader.c;
    }

    private int m113F() {
        NewsFeedXConfigReader newsFeedXConfigReader = this.a;
        if (newsFeedXConfigReader.s == -1) {
            newsFeedXConfigReader.s = newsFeedXConfigReader.a.a(NewsFeedXConfig.B, 10);
        }
        return newsFeedXConfigReader.s;
    }

    private int m114G() {
        NewsFeedXConfigReader newsFeedXConfigReader = this.a;
        if (newsFeedXConfigReader.d == -1) {
            newsFeedXConfigReader.d = newsFeedXConfigReader.a.a(NewsFeedXConfig.e, 10);
        }
        return newsFeedXConfigReader.d;
    }

    private boolean m115H() {
        if (y() && !this.f143y && !this.g.g() && this.f134p == null) {
            return true;
        }
        return false;
    }

    protected final boolean m166a(long j) {
        if (!m115H()) {
            return false;
        }
        if (!this.ah.a(ExperimentsForNewsFeedAbTestModule.S, false) || this.ax == null || this.ax.d() || !this.ax.c()) {
            return this.f115H.b(j);
        }
        return this.f115H.a(j, this.ax.b());
    }

    public final boolean m171d() {
        return m166a(this.ai.a());
    }

    public final boolean m172e() {
        if (!this.ah.a(ExperimentsForNewsFeedAbTestModule.d, false)) {
            return m171d();
        }
        if (!m115H()) {
            return false;
        }
        Object obj;
        AutoRefreshScheduler autoRefreshScheduler = this.f115H;
        if (autoRefreshScheduler.b.b() - (this.ai.a() - autoRefreshScheduler.c) <= 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            m171d();
            return false;
        } else if (!((FbNetworkManager) this.d.get()).d()) {
            return false;
        } else {
            m167a(FetchFeedCause.WARM_START);
            return true;
        }
    }

    public final void m173f() {
        m167a(FetchFeedCause.AUTO_REFRESH);
    }

    public final boolean m174g() {
        if (this.f141w) {
            return false;
        }
        if (m118M() || this.ab.e()) {
            return m116I();
        }
        if (!((FbNetworkManager) this.d.get()).d()) {
            return false;
        }
        m167a(FetchFeedCause.INITIALIZATION);
        this.f141w = true;
        return true;
    }

    private boolean m116I() {
        this.av = RerankingStatus.NOT_SCHEDULED;
        this.aw = SkipTailGapStatus.NOT_SCHEDULED;
        FeedDataLoaderReranker feedDataLoaderReranker = this.ab;
        if (1 != 0) {
            this.f129V.a.z = true;
        }
        m117J();
        if (this.g.a() || this.g.g()) {
            return false;
        }
        this.g.b();
        if (m118M() || !((FbNetworkManager) this.d.get()).d()) {
            m154b(this, true);
            this.f129V.a.f();
        } else if (!this.f141w) {
            m167a(FetchFeedCause.INITIALIZATION);
        }
        if (!m118M() && this.f139u.e() && (this.f139u.c == null || this.f139u.c.f193g)) {
            this.f142x = true;
        } else {
            m161C();
        }
        return true;
    }

    public final boolean m168a(FeedDataLoaderInitializationParams feedDataLoaderInitializationParams) {
        if (feedDataLoaderInitializationParams == null) {
            return m116I();
        }
        m117J();
        if (this.g.a() || this.g.g()) {
            return false;
        }
        this.g.b();
        int i = feedDataLoaderInitializationParams.a;
        if (i <= 0) {
            i = m113F();
        }
        m131a(i, DataFreshnessParam.STALE_DATA_OKAY, FetchFeedCause.INITIALIZATION, true);
        return true;
    }

    public final void m176k() {
        m183w();
    }

    protected final void m161C() {
        FetchFeedCause fetchFeedCause = FetchFeedCause.INITIALIZATION;
        if (this.ab.e()) {
            a(Event.COLD_START_RERANKING_START);
            fetchFeedCause = FetchFeedCause.INITIALIZATION_RERANK;
        }
        m162a(DataFreshnessParam.DO_NOT_CHECK_SERVER, fetchFeedCause, m118M());
    }

    private void m117J() {
        if (!this.b.n()) {
            this.b.p = new C00371(this);
        }
    }

    public final boolean m175h() {
        if (this.f139u.e()) {
            return false;
        }
        a(Event.WARM_START_RERANKING_START);
        m167a(FetchFeedCause.RERANK);
        return true;
    }

    protected final void m183w() {
        this.f139u.b();
        this.f140v.a();
        InitializationStatus initializationStatus = this.g;
        if (initializationStatus.a != Type.INITIALIZED) {
            initializationStatus.a = Type.NOT_INITIALIZED;
        }
        this.f115H.a();
        if (this.f134p != null) {
            this.f134p.c();
            this.f134p = null;
        }
        if (this.f135q != null) {
            this.f135q.c();
            this.f135q = null;
        }
        if (this.f136r != null) {
            this.f136r.a(false);
            this.f136r = null;
        }
        if (this.f138t != null) {
            this.f138t.c();
            this.f138t = null;
        }
        if (this.f110A != null) {
            this.f110A.cancel(false);
            this.f110A = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m167a(com.facebook.api.feed.FetchFeedParams.FetchFeedCause r12) {
        /*
        r11 = this;
        r4 = 1;
        r0 = r12.isManual();
        if (r0 == 0) goto L_0x000e;
    L_0x0007:
        r0 = r11.b;
        r9 = r0.j;
        r9.a();
    L_0x000e:
        r0 = r11.aj;
        r9 = 0;
        r0.f148b = r9;
        r0.f149c = r9;
        r0 = r11.c;
        r0.d();
        r0 = r11.am;
        r1 = r12.isManual();
        r0.a = r1;
        r0 = r12.isManual();
        if (r0 == 0) goto L_0x004e;
    L_0x0028:
        r0 = r11.f127T;
        r0 = r0.get();
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r0 = r11.am;
        r0 = r0.f();
        if (r0 == 0) goto L_0x0040;
    L_0x003e:
        r12 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.BACK_TO_BACK_PTR;
    L_0x0040:
        r0 = r11.am;
        r9 = r0.b;
        r0.e = r9;
        r9 = r0.m;
        r9 = r9.a();
        r0.b = r9;
    L_0x004e:
        r6 = r12;
        r0 = r11.am;
        r9 = r0.c;
        r0.f = r9;
        r9 = r0.m;
        r9 = r9.a();
        r0.c = r9;
        r0 = r11.f139u;
        r0 = r0.e();
        if (r0 != 0) goto L_0x0120;
    L_0x0065:
        r7 = r4;
    L_0x0066:
        if (r7 == 0) goto L_0x0129;
    L_0x0068:
        r0 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.RERANK;
        if (r6 == r0) goto L_0x0129;
    L_0x006c:
        r0 = r11.m;
        r0.a(r6);
        r11.f111B = r6;
        r8 = r11.m124U();
        r0 = r11.b;
        r2 = r0.j();
        r3 = r11.m112E();
        r0 = r11.f;
        r1 = r11.l();
        r5 = com.facebook.fbservice.service.DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        r0 = r0.a(r1, r2, r3, r4, r5, r6);
        r1 = com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event.HEAD_FETCH;
        r2 = new java.lang.StringBuilder;
        r3 = "Freshness:";
        r2.<init>(r3);
        r3 = com.facebook.fbservice.service.DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        r2 = r2.append(r3);
        r3 = " Manual: ";
        r2 = r2.append(r3);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r11.a(r1, r2);
        r1 = com.facebook.fbservice.service.DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        r0 = r11.m126a(r0, r1, r8, r6);
        r1 = r6.isAutoRefresh();
        if (r1 != 0) goto L_0x0123;
    L_0x00b9:
        r1 = r11.f139u;
        r1.c();
    L_0x00be:
        r1 = r11.f139u;
        r1.c = r0;
    L_0x00c2:
        if (r7 != 0) goto L_0x00d5;
    L_0x00c4:
        r0 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.INITIALIZATION;
        if (r6 != r0) goto L_0x00cd;
    L_0x00c8:
        r0 = r11.m;
        r0.a(r6);
    L_0x00cd:
        r0 = r6.isManual();
        if (r0 == 0) goto L_0x00d5;
    L_0x00d3:
        r11.f111B = r6;
    L_0x00d5:
        r0 = r6.needsReranking();
        if (r0 != 0) goto L_0x00ed;
    L_0x00db:
        r9 = r11.b;
        r9 = r9.t();
        if (r9 <= 0) goto L_0x013a;
    L_0x00e3:
        r9 = r6.needsEmptyReranking();
        if (r9 == 0) goto L_0x013a;
    L_0x00e9:
        r9 = 1;
    L_0x00ea:
        r0 = r9;
        if (r0 == 0) goto L_0x0138;
    L_0x00ed:
        r0 = r11.ab;
        r0 = r0.d();
        if (r0 == 0) goto L_0x0138;
    L_0x00f5:
        r0 = r11.f137s;
        if (r0 != 0) goto L_0x0138;
    L_0x00f9:
        r0 = com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event.PTR_RERANKING_SCHEDULED;
        r11.a(r0);
        r0 = com.facebook.feed.data.FeedDataLoader.RerankingStatus.SCHEDULED;
        r11.av = r0;
        r0 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.RERANK;
        if (r6 != r0) goto L_0x012f;
    L_0x0106:
        r0 = 0;
    L_0x0108:
        r2 = r11.m112E();
        r11.m132a(r0, r2, r6);
        r0 = com.facebook.api.feed.FetchFeedParams.FetchFeedCause.RERANK;
        if (r6 != r0) goto L_0x0138;
    L_0x0113:
        r0 = r11.f139u;
        r0.b();
        r0 = r11.f139u;
        r0.c();
        r11.f111B = r6;
    L_0x011f:
        return r4;
    L_0x0120:
        r7 = 0;
        goto L_0x0066;
    L_0x0123:
        r1 = r11.f139u;
        r1.d();
        goto L_0x00be;
    L_0x0129:
        r0 = com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event.HEAD_FETCH_ALREADY_HAPPENING;
        r11.a(r0);
        goto L_0x00c2;
    L_0x012f:
        r0 = r11.ac;
        r1 = 5;
        r0 = r0.c(r1);
        r0 = (long) r0;
        goto L_0x0108;
    L_0x0138:
        r4 = r7;
        goto L_0x011f;
    L_0x013a:
        r9 = 0;
        goto L_0x00ea;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.FeedDataLoader.a(com.facebook.api.feed.FetchFeedParams$FetchFeedCause):boolean");
    }

    private void m132a(long j, int i, FetchFeedCause fetchFeedCause) {
        if (this.f137s != null) {
            this.f137s.c();
            this.f137s = null;
        }
        m133a(FetchFeedParamsGenerator.a(l(), i, FetchFeedCause.RERANK, u()), j, fetchFeedCause);
    }

    private void m133a(FetchFeedParams fetchFeedParams, long j, FetchFeedCause fetchFeedCause) {
        this.au = 0;
        this.f137s = new 2(this, j);
        if (fetchFeedCause.needsReranking()) {
            FeedDataLoaderReranker feedDataLoaderReranker = this.ab;
            feedDataLoaderReranker.g.set(feedDataLoaderReranker.b.a(new 2(feedDataLoaderReranker, this.f137s, fetchFeedParams), j, TimeUnit.SECONDS));
        } else if (fetchFeedCause.needsEmptyReranking()) {
            this.ab.b(fetchFeedParams, this.f137s, j);
        }
    }

    private FeedLoaderParams m126a(FetchFeedParams fetchFeedParams, DataFreshnessParam dataFreshnessParam, boolean z, FetchFeedCause fetchFeedCause) {
        final SettableFuture f = SettableFuture.f();
        this.au = 0;
        final FetchFeedParams fetchFeedParams2 = fetchFeedParams;
        final FetchFeedCause fetchFeedCause2 = fetchFeedCause;
        final boolean z2 = z;
        final DataFreshnessParam dataFreshnessParam2 = dataFreshnessParam;
        this.f134p = new RequestSubscriber<FetchFeedResult>(this) {
            final /* synthetic */ FeedDataLoader f179f;
            private int f180g = 0;
            private boolean f181h = false;
            private boolean f182i = false;
            private final int f183j;
            private final FetchFeedCause f184k;
            private final long f185l;
            private long f186m;

            public final void m211a(Object obj) {
                FetchFeedResult fetchFeedResult = (FetchFeedResult) obj;
                this.f181h = true;
                this.f179f.a(Event.HEAD_FETCH_CHUNKED_SUCCEED, "Freshness:" + dataFreshnessParam2);
                if (this.f180g == 0) {
                    this.f186m = this.f179f.ai.a() - this.f185l;
                }
                this.f180g += fetchFeedResult.d().size();
                this.f182i = fetchFeedResult.c;
                this.f179f.m135a(fetchFeedResult, FetchFeedDirection.BEFORE, true, this.f179f.ai.a());
            }

            public final void m210a() {
                FetchFeedResultCount fetchFeedResultCount = new FetchFeedResultCount(fetchFeedParams2, this.f180g);
                LoadIntentHint loadIntentHint = (this.f179f.b.d() && this.f179f.ab.i()) ? LoadIntentHint.ShowNewStoryPill : LoadIntentHint.AvoidNewStoryPill;
                this.f179f.m.a(this.f180g, loadIntentHint);
                this.f181h = false;
                m209a(true);
                FeedDataLoader.m143a(this.f179f, z2, fetchFeedResultCount);
                FutureDetour.a(f, fetchFeedResultCount, -722288738);
                if (fetchFeedParams2.f == FetchFeedCause.INITIALIZATION && this.f179f.ab.e()) {
                    this.f179f.f129V.a.j();
                }
                if (this.f180g < 3 && fetchFeedParams2.f == FetchFeedCause.INITIALIZATION && this.f179f.f142x) {
                    this.f179f.m161C();
                } else if (this.f180g == 0 && (fetchFeedParams2.f == FetchFeedCause.INITIALIZATION || fetchFeedParams2.f == FetchFeedCause.INITIALIZATION_RERANK)) {
                    HoneyClientEventFast a = this.f179f.ae.a("android_no_available_stories", false);
                    if (a.a()) {
                        a.b();
                    }
                }
                if (z2 && this.f180g == 0) {
                    this.f179f.m162a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, FetchFeedCause.AUTO_REFRESH, false);
                }
                if (!this.f182i) {
                    RecentVpvs recentVpvs = this.f179f.an;
                    ImmutableList immutableList = fetchFeedParams2.i;
                    if (immutableList != null) {
                        int size = immutableList.size();
                        for (int i = 0; i < size; i++) {
                            recentVpvs.b.b((String) immutableList.get(i));
                        }
                    }
                }
            }

            public final void m212a(Throwable th) {
                m209a(false);
                this.f179f.a(Event.HEAD_FETCH_FAILED, "Freshness:" + dataFreshnessParam2 + " Error: " + th.getMessage());
                if (this.f181h) {
                    m210a();
                } else if ((this.f179f.av == RerankingStatus.SCHEDULED_RERANKED && this.f179f.ab.d()) || FeedDataLoader.m151a(this.f179f, this.f183j, fetchFeedParams2.f)) {
                    this.f179f.f139u.b();
                } else {
                    FeedDataLoader.m141a(this.f179f, th, FetchFeedDirection.BEFORE);
                    FeedDataLoader.m154b(this.f179f, z2);
                    f.a(th);
                }
            }

            private void m209a(boolean z) {
                if (this.f184k.isManual()) {
                    long a = this.f179f.ai.a() - this.f185l;
                    if (this.f186m == 0) {
                        this.f186m = a;
                    }
                    FetchFeedCause fetchFeedCause = this.f184k;
                    long j = this.f186m;
                    long j2 = this.f179f.au;
                    FeedDataLoaderReranker feedDataLoaderReranker = this.f179f.ab;
                    this.f179f.ap.a(new FetchStats(fetchFeedCause, a, j, j2, z, true));
                }
            }
        };
        this.f116I.a(f);
        FeedLoaderParams feedLoaderParams = new FeedLoaderParams(fetchFeedParams, dataFreshnessParam, this.o.b(), this.f134p, this.n.g.A + "_before", this.ai.a());
        this.f133Z.m190a(feedLoaderParams);
        return feedLoaderParams;
    }

    public static void m143a(FeedDataLoader feedDataLoader, boolean z, FetchFeedResultCount fetchFeedResultCount) {
        TracerDetour.a("FeedDataLoader.loadBeforeDataSuccess", 156501867);
        try {
            m157c(feedDataLoader, true);
            m140a(feedDataLoader, FetchFeedDirection.BEFORE);
            m154b(feedDataLoader, z);
            long a = feedDataLoader.ai.a();
            feedDataLoader.m153b(a);
            feedDataLoader.m166a(a);
            feedDataLoader.m138a(fetchFeedResultCount);
        } finally {
            TracerDetour.a(-1860071857);
        }
    }

    private void m138a(FetchFeedResultCount fetchFeedResultCount) {
        if (this.av != RerankingStatus.SCHEDULED_RERANKED && this.ab.d() && fetchFeedResultCount != null && fetchFeedResultCount.f7019a == 0) {
            FetchFeedParams fetchFeedParams = fetchFeedResultCount.f7020b;
            if (this.f111B.isManual()) {
                a(Event.NO_NETWORK_DATA_PTR_RERANKING_START);
                m133a(FetchFeedParamsGenerator.a(l(), fetchFeedParams.c, FetchFeedCause.RERANK, u()), 0, fetchFeedParams.f);
                this.f139u.c();
            }
        }
    }

    public static boolean m151a(FeedDataLoader feedDataLoader, int i, FetchFeedCause fetchFeedCause) {
        if (feedDataLoader.av == RerankingStatus.SCHEDULED_RERANKED || !feedDataLoader.ab.d() || !feedDataLoader.f111B.isManual() || feedDataLoader.b.v()) {
            return false;
        }
        m120O(feedDataLoader);
        feedDataLoader.a(Event.ON_FAILURE_PTR_RERANKING_START);
        feedDataLoader.m133a(FetchFeedParamsGenerator.a(feedDataLoader.l(), i, FetchFeedCause.RERANK, feedDataLoader.u()), 0, fetchFeedCause);
        return true;
    }

    private void m153b(long j) {
        this.f123P.edit().a(FeedPrefKeys.e, j).commit();
        int h = this.a.h();
        if (((UDPPrimingHelper) this.aa.get()).a()) {
            ExecutorDetour.a((ExecutorService) this.f119L.get(), new 9(this, j, h), -390495936);
        }
        this.at = j;
        if (!this.ah.a(ExperimentsForNewsFeedAbTestModule.c, false)) {
            ((NewsFeedPrefetcher) this.ad.get()).m7401a();
        }
    }

    private boolean m118M() {
        if (this.f123P.a(FeedPrefKeys.g, false) || !m124U() || !FeedType.b.equals(this.n)) {
            return false;
        }
        z();
        if (PerfTestConfigBase.a() || this.ab.e()) {
            return false;
        }
        return this.ai.a() < this.at + ((long) this.a.h());
    }

    public static void m154b(FeedDataLoader feedDataLoader, boolean z) {
        if (z) {
            Listener c03334 = new C03334(feedDataLoader);
            if (feedDataLoader.f126S.get() != null) {
                ((OfflinePostLoader) feedDataLoader.f128U.get()).m7302a(c03334, feedDataLoader.b.d);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.api.feed.data.FetchRequestState m162a(com.facebook.fbservice.service.DataFreshnessParam r7, com.facebook.api.feed.FetchFeedParams.FetchFeedCause r8, boolean r9) {
        /*
        r6 = this;
        r0 = com.facebook.fbservice.service.DataFreshnessParam.DO_NOT_CHECK_SERVER;
        if (r7 == r0) goto L_0x0025;
    L_0x0004:
        r0 = r6.c;
        r2 = r0.b;
        if (r2 == 0) goto L_0x001d;
    L_0x000a:
        r2 = r0.a;
        r2 = r2.a();
        r4 = r0.c;
        r2 = r2 - r4;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x001d;
    L_0x001a:
        r0.d();
    L_0x001d:
        r2 = r0.b;
        r0 = r2;
        if (r0 == 0) goto L_0x0025;
    L_0x0022:
        r0 = com.facebook.api.feed.data.FetchRequestState.END_OF_FEED;
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = com.facebook.fbservice.service.DataFreshnessParam.DO_NOT_CHECK_SERVER;
        if (r7 != r0) goto L_0x003b;
    L_0x0029:
        r0 = r6.aj;
        r2 = r0.f147a;
        r2 = r2.d();
        if (r2 != 0) goto L_0x005e;
    L_0x0033:
        r2 = r0.f149c;
    L_0x0035:
        r0 = r2;
        if (r0 == 0) goto L_0x003b;
    L_0x0038:
        r0 = com.facebook.api.feed.data.FetchRequestState.END_OF_CACHED_FEED;
        goto L_0x0024;
    L_0x003b:
        r2 = 0;
        r3 = r6.f140v;
        r3 = r3.c();
        if (r3 == 0) goto L_0x0061;
    L_0x0044:
        r0 = r2;
        if (r0 != 0) goto L_0x004a;
    L_0x0047:
        r0 = com.facebook.api.feed.data.FetchRequestState.ALREADY_SCHEDULED;
        goto L_0x0024;
    L_0x004a:
        r0 = r6.m114G();
        r1 = r8.isInitialization();
        if (r1 == 0) goto L_0x0058;
    L_0x0054:
        r0 = r6.m113F();
    L_0x0058:
        r6.m131a(r0, r7, r8, r9);
        r0 = com.facebook.api.feed.data.FetchRequestState.SUCCESS;
        goto L_0x0024;
    L_0x005e:
        r2 = r0.f148b;
        goto L_0x0035;
    L_0x0061:
        r3 = com.facebook.fbservice.service.DataFreshnessParam.DO_NOT_CHECK_SERVER;
        if (r7 == r3) goto L_0x0071;
    L_0x0065:
        r3 = r6.f139u;
        r4 = r3.a;
        r5 = com.facebook.feed.loader.HeadLoaderStatus.Type.LOADING_FOR_UI;
        if (r4 == r5) goto L_0x0073;
    L_0x006d:
        r4 = 1;
    L_0x006e:
        r3 = r4;
        if (r3 == 0) goto L_0x0044;
    L_0x0071:
        r2 = 1;
        goto L_0x0044;
    L_0x0073:
        r4 = 0;
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.FeedDataLoader.a(com.facebook.fbservice.service.DataFreshnessParam, com.facebook.api.feed.FetchFeedParams$FetchFeedCause, boolean):com.facebook.api.feed.data.FetchRequestState");
    }

    private void m131a(int i, DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause, boolean z) {
        FetchFeedParams a = this.f.a(l(), this.b.r(), i, true, dataFreshnessParam, fetchFeedCause, z, true, u());
        a(Event.TAIL_FETCH, "Freshness:" + dataFreshnessParam);
        SettableFuture f = SettableFuture.f();
        RequestSubscriber a2 = m127a(dataFreshnessParam, z, a, f);
        m164a(SkipTailGapStatus.NOT_SCHEDULED);
        m144a(a2, a, dataFreshnessParam, f);
        this.f140v.b();
    }

    public final void m170b(DataFreshnessParam dataFreshnessParam, FetchFeedCause fetchFeedCause, boolean z) {
        if (m150a(dataFreshnessParam)) {
            FetchFeedParams a = this.f.a(l(), this.b.r(), m114G(), true, dataFreshnessParam, fetchFeedCause, z, true, u());
            m119N(this);
            m134a(a, z);
            a(Event.TAIL_FETCH_SKIP_GAP_SCHEDULED);
            this.aw = SkipTailGapStatus.SCHEDULED;
        }
    }

    public final void m179r() {
        if (this.c.b) {
            this.c.d();
        }
    }

    public final int m180s() {
        return this.a.m();
    }

    public final void m165a(StoryRankingTimeTracker storyRankingTimeTracker) {
        this.ax = storyRankingTimeTracker;
    }

    private boolean m150a(DataFreshnessParam dataFreshnessParam) {
        if (dataFreshnessParam != DataFreshnessParam.DO_NOT_CHECK_SERVER) {
            Object obj = (1 == 0 || !this.af.f167a.d()) ? null : 1;
            if (obj != null && this.aw.canSchedule()) {
                return true;
            }
        }
        return false;
    }

    public static void m119N(FeedDataLoader feedDataLoader) {
        if (feedDataLoader.f138t != null) {
            feedDataLoader.f138t.c();
            feedDataLoader.f138t = null;
        }
        if (feedDataLoader.f110A != null) {
            feedDataLoader.f110A.cancel(true);
            feedDataLoader.f110A = null;
        }
        feedDataLoader.a(Event.SKIP_TAIL_GAP_FUTURE_CLEARED);
    }

    private void m134a(final FetchFeedParams fetchFeedParams, final boolean z) {
        this.f110A = this.ag.a(new Runnable(this) {
            final /* synthetic */ FeedDataLoader f2856c;

            public void run() {
                this.f2856c.m163a(fetchFeedParams, z, SettableFuture.f());
            }
        }, (long) this.af.f168b.g(5), TimeUnit.SECONDS);
    }

    private RequestSubscriber<FetchFeedResult> m127a(DataFreshnessParam dataFreshnessParam, boolean z, FetchFeedParams fetchFeedParams, SettableFuture<FetchFeedResult> settableFuture) {
        final SettableFuture<FetchFeedResult> settableFuture2 = settableFuture;
        final FetchFeedParams fetchFeedParams2 = fetchFeedParams;
        final DataFreshnessParam dataFreshnessParam2 = dataFreshnessParam;
        final boolean z2 = z;
        return new RequestSubscriber<FetchFeedResult>(this) {
            final /* synthetic */ FeedDataLoader f400e;
            private int f401f = 0;

            public final void m681a(Object obj) {
                FetchFeedResult fetchFeedResult = (FetchFeedResult) obj;
                this.f401f += fetchFeedResult.d().size();
                if ((!this.f400e.g.g() || this.f400e.f139u.c == null || !this.f400e.f139u.c.f193g) && !FeedDataLoader.m121P(this.f400e)) {
                    if (!(fetchFeedParams2 == null || fetchFeedParams2.f != FetchFeedCause.INITIALIZATION_RERANK || fetchFeedResult.d().isEmpty() || this.f400e.f142x)) {
                        if (StringUtil.a(((GraphQLFeedUnitEdge) fetchFeedResult.d().get(0)).j(), "0")) {
                            this.f400e.f129V.a.g();
                        } else {
                            this.f400e.f129V.a.h();
                        }
                    }
                    this.f400e.m135a(fetchFeedResult, FetchFeedDirection.AFTER, true, this.f400e.ai.a());
                }
            }

            public final void m680a() {
                TracerDetour.a("FeedDataLoader.loadAfterDataSuccess", -596916051);
                try {
                    FutureDetour.a(settableFuture2, null, -1090647138);
                    if (fetchFeedParams2 != null && fetchFeedParams2.h() == FetchFeedCause.INITIALIZATION_RERANK && this.f401f == 0 && !this.f400e.f142x) {
                        this.f400e.f129V.i();
                    }
                    long a = this.f400e.ai.a();
                    if (fetchFeedParams2.h() == FetchFeedCause.SKIP_TAIL_GAP || dataFreshnessParam2 != DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                        FeedDataLoader.m119N(this.f400e);
                    }
                    if (FeedDataLoader.m121P(this.f400e)) {
                        FeedDataLoader.m140a(this.f400e, FetchFeedDirection.AFTER);
                        FeedDataLoader.m123T(this.f400e);
                        this.f400e.a(Event.TAIL_FETCH_BACKGROUND_SUCCEED);
                        this.f400e.f112C = 0;
                        return;
                    }
                    if (dataFreshnessParam2 == DataFreshnessParam.DO_NOT_CHECK_SERVER && this.f401f == 0) {
                        this.f400e.aj.m188a(fetchFeedParams2.n());
                    }
                    if (m679a(this.f401f)) {
                        m682a(new UnsupportedOperationException("Too many tail fetches returned empty results, aborting."));
                        TracerDetour.a(-733400131);
                        return;
                    }
                    this.f400e.a(Event.TAIL_FETCH_SUCCEED, "Freshness:" + dataFreshnessParam2);
                    this.f400e.af;
                    if (!OnlineFeedGapConditionCheck.m198b() || fetchFeedParams2.h() != FetchFeedCause.SKIP_TAIL_GAP) {
                        FeedDataLoader.m123T(this.f400e);
                    } else if (this.f401f == 0) {
                        this.f400e.a(Event.TAIL_FETCH_SKIP_FINISHED_WITH_NO_RESULTS);
                        if (this.f400e.aw.finishedWithDataOnce()) {
                            this.f400e.m164a(SkipTailGapStatus.FINISHED_WITH_DATA_AT_LEAST_ONCE);
                        } else {
                            this.f400e.m164a(SkipTailGapStatus.FINISHED_WITH_NO_DATA);
                        }
                        TracerDetour.a(-1909241963);
                        return;
                    } else {
                        this.f400e.a(Event.TAIL_FETCH_SKIP_FINISHED_WITH_RESULTS);
                        this.f400e.m164a(SkipTailGapStatus.FINISHED_WITH_DATA);
                    }
                    if (z2 && dataFreshnessParam2 == DataFreshnessParam.DO_NOT_CHECK_SERVER && this.f401f == 0) {
                        this.f400e.m173f();
                    } else {
                        this.f400e.m166a(a);
                    }
                    TracerDetour.a(143181069);
                } finally {
                    TracerDetour.a(-1664003376);
                }
            }

            private boolean m679a(int i) {
                if (i > 0) {
                    this.f400e.f112C = 0;
                    return false;
                }
                FeedDataLoader feedDataLoader = this.f400e;
                feedDataLoader.f112C++;
                HoneyClientEventFast a = this.f400e.ae.a("feed_fetch_no_results_tail", false);
                if (a.a()) {
                    a.a("freshness", dataFreshnessParam2.toString());
                    a.b();
                }
                int i2 = this.f400e.f112C;
                NewsFeedXConfigReader newsFeedXConfigReader = this.f400e.a;
                if (newsFeedXConfigReader.F == -1) {
                    newsFeedXConfigReader.F = newsFeedXConfigReader.a.a(NewsFeedXConfig.x, 10);
                }
                if (i2 < newsFeedXConfigReader.F || !this.f400e.q.a(767, false)) {
                    return false;
                }
                return true;
            }

            public final void m682a(Throwable th) {
                this.f400e.f112C = 0;
                this.f400e.a(Event.TAIL_FETCH_FAILED, "Freshness:" + dataFreshnessParam2 + " Error: " + th.getMessage());
                FeedDataLoader.m141a(this.f400e, th, FetchFeedDirection.AFTER);
                settableFuture2.a(th);
            }
        };
    }

    private void m144a(RequestSubscriber<FetchFeedResult> requestSubscriber, FetchFeedParams fetchFeedParams, DataFreshnessParam dataFreshnessParam, SettableFuture settableFuture) {
        this.f135q = requestSubscriber;
        this.f133Z.m190a(new FeedLoaderParams(fetchFeedParams, dataFreshnessParam, this.o.b(), this.f135q, this.n.g.A + "_after", this.ai.a()));
        this.f116I.a(settableFuture);
    }

    public static void m120O(FeedDataLoader feedDataLoader) {
        FeedDataLoaderReranker feedDataLoaderReranker = feedDataLoader.ab;
        ListenableScheduledFuture listenableScheduledFuture = (ListenableScheduledFuture) feedDataLoaderReranker.g.getAndSet(null);
        if (listenableScheduledFuture != null) {
            listenableScheduledFuture.cancel(true);
        }
        listenableScheduledFuture = (ListenableScheduledFuture) feedDataLoaderReranker.h.getAndSet(null);
        if (listenableScheduledFuture != null) {
            listenableScheduledFuture.cancel(true);
        }
        if (feedDataLoader.f137s != null) {
            feedDataLoader.f137s.c();
            feedDataLoader.f137s = null;
        }
    }

    private void m146a(List<GraphQLFeedUnitEdge> list) {
        if (this.ah.a(ExperimentsForNewsFeedAbTestModule.S, false) && this.ax != null) {
            long j = 0;
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : list) {
                long max;
                if (graphQLFeedUnitEdge.c() instanceof GraphQLStory) {
                    max = Math.max(((GraphQLStory) graphQLFeedUnitEdge.c()).aZ(), j);
                } else {
                    max = j;
                }
                j = max;
            }
            if (j > 0) {
                this.ax.a(j);
            }
        }
    }

    private static boolean m149a(FetchFeedResult fetchFeedResult) {
        return fetchFeedResult == null || fetchFeedResult.freshness == DataFreshnessResult.NO_DATA || fetchFeedResult.d().isEmpty();
    }

    private boolean m158c(FetchFeedCause fetchFeedCause) {
        if (this.b.t() != 0 && fetchFeedCause.isManual() && this.av == RerankingStatus.SCHEDULED_RERANKED) {
            return true;
        }
        return false;
    }

    private boolean m159d(FetchFeedCause fetchFeedCause) {
        if (this.b.t() == 0) {
            return false;
        }
        if ((fetchFeedCause == FetchFeedCause.INITIALIZATION || fetchFeedCause.isAutoRefresh()) && this.ab.i()) {
            return true;
        }
        return false;
    }

    private void m155b(List<GraphQLFeedUnitEdge> list) {
        ImmutableList b;
        int h = this.ac.h(2);
        Builder builder = new Builder();
        if (h <= 0) {
            b = builder.b();
        } else if (h >= list.size()) {
            b = builder.b(list).b();
        } else {
            b = builder.b(list.subList(0, h)).b();
        }
        this.f116I.a("NewsFeed Staged Feed Image Fetch", new 7(this, b), Priority.APPLICATION_LOADED_LOW_PRIORITY, ThreadType.BACKGROUND);
    }

    public static boolean m121P(FeedDataLoader feedDataLoader) {
        if (1 == 0) {
            return false;
        }
        if (1 == 0 || !feedDataLoader.af.m199d()) {
            return feedDataLoader.aw.finishNetworkTailFetch();
        }
        return false;
    }

    private void m137a(FetchFeedResult fetchFeedResult, DataFreshnessResult dataFreshnessResult) {
        TracerDetour.a("FeedDataLoader.fetchFeedPostProcess", -72311605);
        try {
            if (dataFreshnessResult == DataFreshnessResult.FROM_SERVER) {
                this.f131X.a(fetchFeedResult.g(), fetchFeedResult.i());
            }
            TracerDetour.a(-1810432657);
        } catch (Throwable th) {
            TracerDetour.a(-1227938128);
        }
    }

    private void m136a(FetchFeedResult fetchFeedResult, FetchPortion fetchPortion) {
        TracerDetour.a("FeedDataLoader.processSponsoredFeedUnitValidations", -1678063240);
        try {
            ImmutableList d = fetchFeedResult.d();
            if (!(fetchFeedResult.e() == null || d == null)) {
                ((SponsoredFeedUnitValidator) this.f121N.get()).a(this.b, d, fetchFeedResult.a() == DataFreshnessResult.FROM_SERVER, fetchPortion);
            }
            TracerDetour.a(-1359322478);
        } catch (Throwable th) {
            TracerDetour.a(431913176);
        }
    }

    public static void m141a(FeedDataLoader feedDataLoader, Throwable th, FetchFeedDirection fetchFeedDirection) {
        m140a(feedDataLoader, fetchFeedDirection);
        boolean z = fetchFeedDirection == FetchFeedDirection.BEFORE;
        if (z) {
            if (feedDataLoader.av == RerankingStatus.SCHEDULED_RERANKED) {
                feedDataLoader.f139u.b();
            } else {
                feedDataLoader.f139u.g();
            }
            feedDataLoader.am.a(-1);
            feedDataLoader.am.a(new Pair(Integer.valueOf(-1), Integer.valueOf(-1)));
            feedDataLoader.am.e();
            ((CacheStateLogger) feedDataLoader.al.get()).m754a(feedDataLoader.n, -1);
        } else {
            m123T(feedDataLoader);
        }
        ErrorCode a = ErrorCodeUtil.m10889a(th);
        if (a == ErrorCode.OUT_OF_MEMORY) {
            throw new OutOfMemoryError("Intentional feed out of memory crash");
        }
        String a2 = feedDataLoader.m128a(th, z);
        FetchResultState fetchResultState = a == ErrorCode.CANCELLED ? FetchResultState.CANCELLATION : FetchResultState.SERVICE_EXCEPTION;
        feedDataLoader.m145a(th, z, fetchResultState);
        if (a != ErrorCode.CANCELLED) {
            long a3 = feedDataLoader.ai.a();
            feedDataLoader.f115H.c = a3;
            feedDataLoader.m166a(a3);
        }
        feedDataLoader.m147a(z, null, fetchResultState, a2, -1, FetchPortion.FULL, ViewPortShift.Perform);
    }

    private void m145a(Throwable th, boolean z, FetchResultState fetchResultState) {
        if (th instanceof DiskCacheReadException) {
            m148a(z, fetchResultState);
        } else if (th instanceof GraphQLException) {
            GraphQLError graphQLError = ((GraphQLException) th).error;
            if (graphQLError != null && graphQLError.code == 1675011) {
                m148a(z, fetchResultState);
            }
        }
    }

    private String m128a(Throwable th, boolean z) {
        String simpleName;
        ErrorCode a = ErrorCodeUtil.m10889a(th);
        if (a == ErrorCode.OTHER) {
            simpleName = th.getClass().getSimpleName();
        } else {
            simpleName = a.toString();
        }
        String stackTraceAsString = Throwables.getStackTraceAsString(th);
        if (a != ErrorCode.CANCELLED) {
            String str = "time=" + this.ai.a() + " " + simpleName + " " + stackTraceAsString;
            if (z) {
                ((FeedLoadingDebugInfo) this.f120M.get()).a.c("LastNewerLoadFailure", str);
            } else {
                ((FeedLoadingDebugInfo) this.f120M.get()).a.c("LastOlderLoadFailure", str);
            }
        }
        if (((FbNetworkManager) this.d.get()).d() && ((Boolean) this.f118K.get()).booleanValue() && !((ExecutorService) this.f119L.get()).isShutdown() && a != ErrorCode.CANCELLED) {
            this.f117J.a("Feed_Loading_Error_" + simpleName, stackTraceAsString, th);
        }
        return simpleName;
    }

    private void m148a(boolean z, FetchResultState fetchResultState) {
        OperationFuture c = BlueServiceOperationFactoryDetour.a(this.f113F, "feed_clear_cache", new Bundle(), f108D, 2051883890).c();
        8 8 = new 8(this, z, fetchResultState);
        this.f136r = new FutureAndCallbackHolder(c, 8);
        this.f114G.a(c, 8);
    }

    public static void m140a(FeedDataLoader feedDataLoader, FetchFeedDirection fetchFeedDirection) {
        switch (fetchFeedDirection) {
            case AFTER:
                if (feedDataLoader.f135q != null) {
                    feedDataLoader.f135q.c();
                }
                feedDataLoader.f135q = null;
                return;
            case BEFORE:
                if (feedDataLoader.f134p != null) {
                    feedDataLoader.f134p.c();
                }
                feedDataLoader.f134p = null;
                return;
            default:
                return;
        }
    }

    private void m130a(int i) {
        if (i > 0) {
            this.f144z = false;
            this.b.m();
        }
    }

    private List<GraphQLFeedUnitEdge> m129a(List<GraphQLFeedUnitEdge> list, FeedType feedType) {
        if (!list.isEmpty() || !this.b.v()) {
            return list;
        }
        FeedUnit graphQLFindPagesFeedUnit;
        String str;
        this.f144z = true;
        String str2 = "synthetic_cursor";
        if (!this.f122O && feedType.g.equals(Name.h)) {
            graphQLFindPagesFeedUnit = new GraphQLFindPagesFeedUnit();
            str = "findpages_feed_unit";
        } else if (feedType.g.equals(Name.c)) {
            graphQLFindPagesFeedUnit = new GraphQLNoContentGoodFriendsFeedUnit();
            str = "nocontent_good_friends_feed_unit";
        } else if (!this.f122O && ((TriState) this.f124Q.get()).asBoolean(false)) {
            graphQLFindPagesFeedUnit = new GraphQLFindFriendsFeedUnit();
            str = "findfriends_feed_unit";
        } else if (this.f122O && ((TriState) this.f125R.get()).asBoolean(false)) {
            graphQLFindPagesFeedUnit = new GraphQLFindGroupsFeedUnit();
            str = "findgroups_feed_unit";
        } else {
            graphQLFindPagesFeedUnit = new GraphQLNoContentFeedUnit();
            str = "nocontent_feed_unit";
        }
        GraphQLFeedUnitEdge.Builder builder = new GraphQLFeedUnitEdge.Builder();
        builder.i = graphQLFindPagesFeedUnit;
        GraphQLFeedUnitEdge.Builder builder2 = builder;
        builder2.f = str;
        GraphQLFeedUnitEdge.Builder builder3 = builder2;
        builder3.k = FeedEdgeComparator.b;
        builder3 = builder3;
        builder3.e = str2;
        return ImmutableList.of(builder3.a());
    }

    private List<GraphQLFeedUnitEdge> m156c(List<GraphQLFeedUnitEdge> list) {
        if (!this.c.b || this.n.g.equals(Name.k) || this.n.g.equals(Name.c)) {
            return list;
        }
        GraphQLFindFriendsFeedUnit graphQLFindFriendsFeedUnit = new GraphQLFindFriendsFeedUnit();
        Builder builder = new Builder();
        GraphQLFeedUnitEdge.Builder builder2 = new GraphQLFeedUnitEdge.Builder();
        builder2.i = graphQLFindFriendsFeedUnit;
        GraphQLFeedUnitEdge.Builder builder3 = builder2;
        builder3.f = "findfriends_feed_unit";
        builder3 = builder3;
        builder3.k = FeedEdgeComparator.c;
        builder3 = builder3;
        builder3.e = "synthetic_cursor";
        return builder.c(builder3.a()).b(list).b();
    }

    private boolean m122Q() {
        return this.ah.a(ExperimentsForNewsFeedAbTestModule.i, false);
    }

    public static void m157c(FeedDataLoader feedDataLoader, boolean z) {
        feedDataLoader.c.d();
        if (z) {
            feedDataLoader.f139u.b();
        } else {
            feedDataLoader.f139u.f();
        }
        InitializationStatus initializationStatus = feedDataLoader.g;
        if (initializationStatus.a == Type.INITIAL_TAIL_LOAD_COMPLETE) {
            initializationStatus.a = Type.INITIALIZED;
        }
        if (initializationStatus.a != Type.INITIALIZED) {
            initializationStatus.a = Type.INITIAL_HEAD_LOAD_COMPLETE;
        }
    }

    public final boolean m177o() {
        return this.f139u.e();
    }

    public final boolean m178p() {
        return m177o() || this.f140v.c();
    }

    @VisibleForTesting
    protected final void m164a(SkipTailGapStatus skipTailGapStatus) {
        this.aw = skipTailGapStatus;
    }

    public static void m123T(FeedDataLoader feedDataLoader) {
        feedDataLoader.f140v.a();
        InitializationStatus initializationStatus = feedDataLoader.g;
        if (initializationStatus.a == Type.INITIAL_HEAD_LOAD_COMPLETE) {
            initializationStatus.a = Type.INITIALIZED;
        }
        if (initializationStatus.a != Type.INITIALIZED) {
            initializationStatus.a = Type.INITIAL_TAIL_LOAD_COMPLETE;
        }
    }

    private boolean m124U() {
        return this.b.j() == null;
    }

    private void m147a(boolean z, FetchFeedResult fetchFeedResult, FetchResultState fetchResultState, @Nullable String str, int i, FetchPortion fetchPortion, ViewPortShift viewPortShift) {
        boolean c;
        TracerDetour.a("FeedDataLoader.onLoadingComplete", 2123454144);
        if (z) {
            try {
                c = this.f140v.c();
            } catch (Throwable th) {
                TracerDetour.a(57263842);
            }
        } else {
            c = m177o();
        }
        if (((PreferredFeedTypeManager) this.f130W.get()).a(l())) {
            switch (AnonymousClass10.f456b[fetchResultState.ordinal()]) {
                case 1:
                    this.f129V.a(fetchFeedResult, z);
                    break;
                case 2:
                case 3:
                    this.f129V.c(c);
                    break;
                case 4:
                    this.f129V.a(str, c, l());
                    break;
            }
        }
        this.m.a(z, fetchFeedResult, fetchResultState, str, i, fetchPortion, viewPortShift);
        TracerDetour.a(-1133214530);
    }

    protected final CallerContext m182v() {
        return f108D;
    }

    public final void m169b() {
        super.b();
        ((SponsoredFeedUnitValidator) this.f121N.get()).a();
    }

    public final void iv_() {
        m171d();
    }

    public final void m181t() {
    }
}
