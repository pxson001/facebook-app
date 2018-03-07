package com.facebook.feed.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FeedOnTopCache;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feed.data.FetchRequestState;
import com.facebook.api.feed.data.ViewPortShift;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feed.xconfig.FreshFeedConfig;
import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.api.feed.xconfig.NewsFeedXConfig;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedcache.memory.FeedUnitCache.FeedUnitCacheSubscriber;
import com.facebook.api.feedcache.memory.FeedUnitCache.MutationType;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.NewsFeedLoadingSlowLogger;
import com.facebook.feed.broadcaster.NewsFeedBroadcaster;
import com.facebook.feed.data.FeedDataLoadedCallbacks.ErrorType;
import com.facebook.feed.data.FeedDataLoadedCallbacks.Location;
import com.facebook.feed.data.FeedDataLoader;
import com.facebook.feed.data.FeedDataLoaderFactory;
import com.facebook.feed.data.FeedDataLoaderReranker;
import com.facebook.feed.data.FeedUnitSubscriber;
import com.facebook.feed.data.freshfeed.FreshFeedDataLoader;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.feed.feedtype.FeedTypeDataItem;
import com.facebook.feed.feedtype.STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem;
import com.facebook.feed.fragment.controllercallbacks.ErrorViewController.Callback;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedControllerCallbacksDispatcher;
import com.facebook.feed.fragment.controllercallbacks.SwipeRefreshController;
import com.facebook.feed.fragment.controllercallbacks.TailLoaderController;
import com.facebook.feed.fragment.controllercallbacks.ViewportMonitorFragmentController;
import com.facebook.feed.loader.FeedDataLoaderInitializationParams;
import com.facebook.feed.loader.FeedDataLoaderInitializationParams.Builder;
import com.facebook.feed.loader.FeedDataLoaderListener;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.feed.loader.LoadIntentHint;
import com.facebook.feed.loader.StoryRankingTimeTracker;
import com.facebook.feed.loader.StoryRankingTimeTracker.HitPreviouslyRankedStoriesListener;
import com.facebook.feed.logging.RerankingEventsLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.model.FetchResultState;
import com.facebook.feed.nux.FeedNuxBubbleManager.BlockingCause;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.pulltorefresh.PullToRefreshLogger;
import com.facebook.feed.pulltorefresh.ScrollStateManager.ScrollMode;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feed.ui.DebugScissorsEvent;
import com.facebook.feed.ui.NewsFeedListViewAnimations;
import com.facebook.feed.ui.NewsFeedListViewPruner;
import com.facebook.feed.ui.NewsFeedListViewScrollFetcher;
import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.feed.ui.NewsFeedRecyclerViewProxy;
import com.facebook.feed.ui.feedprefetch.FeedPrefetchLoader;
import com.facebook.feed.util.ConnectivityChangedCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.annotations.IsZeroRatingCampaignEnabled;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.counters.PullToRefreshCounter;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ssl.ui.SSLDialogHelper;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.refreshableview.ConnectionRetrySnackbarView;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
public class NewsFeedFragmentDataController implements FeedUnitCacheSubscriber, Callback, SwipeRefreshController.Callback, TailLoaderController.Callback, FeedDataLoaderListener, ConnectivityChangedCallback {
    public static final PrefKey f11477a;
    public static final String f11478f = NewsFeedFragmentDataController.class.getSimpleName();
    public static final PrefKey f11479g;
    private static final String f11480h = "0";
    private final NewsFeedAnalyticsEventBuilder f11481A;
    private final PullToRefreshLogger f11482B;
    private final FeedDataLoaderReranker f11483C;
    private final PullToRefreshCounter f11484D;
    private final RerankingEventsLogger f11485E;
    @IsZeroRatingCampaignEnabled
    private final Provider<Boolean> f11486F;
    @CrossFbProcessBroadcast
    private final BaseFbBroadcastManager f11487G;
    public final DefaultBlueServiceOperationFactory f11488H;
    public final PerformanceLogger f11489I;
    public final Lazy<Set<FeedTypeDataItem>> f11490J;
    public final NewsFeedXConfigReader f11491K;
    public final FbSharedPreferences f11492L;
    private final Clock f11493M;
    private final AsyncFeedXConfigReader f11494N;
    private final ListeningScheduledExecutorService f11495O;
    private final FreshFeedConfigReader f11496P;
    private final NewsFeedFragmentOfflineController f11497Q;
    private final DefaultProcessIdleExecutor f11498R;
    public Context f11499S;
    private NewsFeedFragment f11500T;
    public NewsFeedFragment f11501U;
    public FeedUnitSubscriber f11502V;
    private FeedEventBus f11503W;
    public FeedType f11504X;
    private NewsFeedControllerCallbacksDispatcher f11505Y;
    public StoryRankingTimeTracker f11506Z;
    public View aa;
    public OnScrollListener ab;
    public NewsFeedRecyclerViewAdapterWrapper ac;
    public NewsFeedRecyclerViewProxy ad;
    public ClickableToast ae;
    public NewsFeedListViewAnimations af;
    private int ag = 0;
    private CreateScissorsSubscriber ah;
    public boolean ai = true;
    public boolean aj = true;
    private ListViewState ak;
    public FeedDataLoaderInitializationParams al;
    private ListenableScheduledFuture am;
    public IFeedDataLoader f11507b;
    public FeedUnitCollection f11508c;
    protected boolean f11509d = false;
    @Nullable
    protected GraphQLFeedUnitEdge f11510e;
    public final NewsFeedListViewPruner f11511i;
    public final NewsFeedListViewScrollFetcher f11512j;
    public final FeedDataLoaderFactory f11513k;
    private final Provider<FeedDataLoader> f11514l;
    public final NewsFeedEventLogger f11515m;
    private final QeAccessor f11516n;
    private final NewsFeedLoadingSlowLogger f11517o;
    public final FeedUnitCache f11518p;
    private final FbNetworkManager f11519q;
    private final AnalyticsLogger f11520r;
    private final PerfTestConfig f11521s;
    private final Lazy<ClickableToastBuilder> f11522t;
    public final FeedPerfLogger f11523u;
    private final SeeFirstStateManager f11524v;
    private final FeedPrefetchLoader f11525w;
    public final Lazy<ViewAccessibilityHelper> f11526x;
    private final NewsFeedBroadcaster f11527y;
    private final Lazy<SSLDialogHelper> f11528z;

    /* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    public class CreateScissorsSubscriber extends FeedEventSubscriber<DebugScissorsEvent> {
        final /* synthetic */ NewsFeedFragmentDataController f11613a;

        protected CreateScissorsSubscriber(NewsFeedFragmentDataController newsFeedFragmentDataController) {
            this.f11613a = newsFeedFragmentDataController;
        }

        public final void mo650b(FbEvent fbEvent) {
            DebugScissorsEvent debugScissorsEvent = (DebugScissorsEvent) fbEvent;
            if (this.f11613a.f11507b != null && this.f11613a.f11507b.mo1320n()) {
                if (this.f11613a.f11507b.mo1315c().mo1374a() <= debugScissorsEvent.f11614a + 4) {
                    Toast.makeText(this.f11613a.f11499S, "Too few stories. Load more tail stories.", 1).show();
                    return;
                }
                int a = this.f11613a.f11507b.mo1315c().mo1374a();
                FeedUnitCollection feedUnitCollection = this.f11613a.f11508c;
                int i = debugScissorsEvent.f11614a;
                if (i > 0) {
                    if (i >= feedUnitCollection.mo1374a()) {
                        feedUnitCollection.m9696m();
                    } else {
                        Iterator it = feedUnitCollection.f5631g.iterator();
                        for (int i2 = 0; i2 < i; i2++) {
                            FeedOnTopCache feedOnTopCache = feedUnitCollection.f5634j;
                            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
                            if (feedOnTopCache.f5672c.size() < FeedOnTopCache.f5670a) {
                                feedOnTopCache.f5672c.add(graphQLFeedUnitEdge);
                            }
                            feedUnitCollection.m9685c((GraphQLFeedUnitEdge) it.next());
                        }
                        if (feedUnitCollection.m9701t() > 0) {
                            feedUnitCollection.f5638n = true;
                        } else {
                            feedUnitCollection.m9696m();
                        }
                    }
                }
                NewsFeedFragmentDataController.m16795I(this.f11613a);
                BlueServiceOperationFactoryDetour.a(this.f11613a.f11488H, "feed_clear_cache", new Bundle(), -44204961).mo3451a(true).mo3452a();
                this.f11613a.ad.mo2378d(4, 0);
                Toast.makeText(this.f11613a.f11499S, "Cleared " + (a - this.f11613a.f11507b.mo1315c().mo1374a()) + " stories", 1).show();
                this.f11613a.f11507b.mo1298d();
            }
        }

        public final Class<DebugScissorsEvent> mo648a() {
            return DebugScissorsEvent.class;
        }
    }

    /* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    public class C05694 implements OnClickListener {
        final /* synthetic */ NewsFeedFragmentDataController f13837a;

        public C05694(NewsFeedFragmentDataController newsFeedFragmentDataController) {
            this.f13837a = newsFeedFragmentDataController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1793860403);
            this.f13837a.m16833a("fresh_feed_new_story_pill_tapped");
            this.f13837a.af.m20217b(false);
            if (this.f13837a.f11510e != null) {
                int a2 = this.f13837a.f11508c.m9666a(this.f13837a.f11510e);
                if (a2 >= 0) {
                    this.f13837a.ad.mo2373c(this.f13837a.ac.t_(a2), 0);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 458156060, a);
        }
    }

    /* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    enum LoadType {
        CHECK_CONNECTION,
        ALWAYS,
        CACHED_ONLY
    }

    /* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    /* synthetic */ class C06318 {
        static final /* synthetic */ int[] f14730a = new int[LoadIntentHint.values().length];
        static final /* synthetic */ int[] f14731b = new int[FetchResultState.values().length];
        static final /* synthetic */ int[] f14732c = new int[FetchRequestState.values().length];

        static {
            try {
                f14732c[FetchRequestState.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14732c[FetchRequestState.END_OF_FEED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14732c[FetchRequestState.END_OF_CACHED_FEED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14732c[FetchRequestState.ALREADY_SCHEDULED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14731b[FetchResultState.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14731b[FetchResultState.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f14731b[FetchResultState.SERVICE_EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f14731b[FetchResultState.CANCELLATION.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f14730a[LoadIntentHint.HideLoadingIndicator.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f14730a[LoadIntentHint.ShowMoreStoryPill.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f14730a[LoadIntentHint.AvoidNewStoryPill.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f14730a[LoadIntentHint.ShowNewStoryPill.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    class C07621 implements Runnable {
        final /* synthetic */ NewsFeedFragmentDataController f19210a;

        C07621(NewsFeedFragmentDataController newsFeedFragmentDataController) {
            this.f19210a = newsFeedFragmentDataController;
        }

        public void run() {
            FeedUnitCollection feedUnitCollection = this.f19210a.f11508c;
            NewsFeedXConfigReader newsFeedXConfigReader = this.f19210a.f11491K;
            if (newsFeedXConfigReader.f4507q == -1) {
                newsFeedXConfigReader.f4507q = newsFeedXConfigReader.f4491a.m2683a(NewsFeedXConfig.f5020z, 100);
            }
            int i = newsFeedXConfigReader.f4507q;
            NewsFeedXConfigReader newsFeedXConfigReader2 = this.f19210a.f11491K;
            if (newsFeedXConfigReader2.f4508r == -1) {
                newsFeedXConfigReader2.f4508r = newsFeedXConfigReader2.f4491a.m2683a(NewsFeedXConfig.f4993A, 40);
            }
            int i2 = newsFeedXConfigReader2.f4508r;
            NewsFeedXConfigReader newsFeedXConfigReader3 = this.f19210a.f11491K;
            if (newsFeedXConfigReader3.f4506p == -1) {
                newsFeedXConfigReader3.f4506p = newsFeedXConfigReader3.f4491a.m2683a(NewsFeedXConfig.f5019y, 10);
            }
            if (feedUnitCollection.m9674a(i, i2, newsFeedXConfigReader3.f4506p)) {
                NewsFeedFragmentDataController.m16795I(this.f19210a);
            }
        }
    }

    /* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
    public class C08963 implements OnClickListener {
        final /* synthetic */ NewsFeedFragmentDataController f22198a;

        public C08963(NewsFeedFragmentDataController newsFeedFragmentDataController) {
            this.f22198a = newsFeedFragmentDataController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1514782645);
            this.f22198a.m16845r();
            Logger.a(2, EntryType.UI_INPUT_END, -1571147940, a);
        }
    }

    public static NewsFeedFragmentDataController m16812b(InjectorLike injectorLike) {
        return new NewsFeedFragmentDataController(NewsFeedListViewPruner.m16849a(injectorLike), NewsFeedListViewScrollFetcher.m16859a(injectorLike), FeedDataLoaderFactory.m8944a(injectorLike), IdBasedProvider.m1811a(injectorLike, 1305), NewsFeedEventLogger.m4405a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), NewsFeedLoadingSlowLogger.m16867a(injectorLike), FeedUnitCache.m10541a(injectorLike), FbNetworkManager.m3811a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), PerfTestConfig.m2936a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3585), FeedPerfLogger.m3326a(injectorLike), SeeFirstStateManager.m16868a(injectorLike), FeedPrefetchLoader.m16874a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 101), NewsFeedBroadcaster.m8781a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3438), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), PullToRefreshLogger.m16882a(injectorLike), FeedDataLoaderReranker.m16898a(injectorLike), PullToRefreshCounter.m16910a(injectorLike), RerankingEventsLogger.m15253a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4034), CrossProcessFbBroadcastManager.m3644a(injectorLike), DefaultBlueServiceOperationFactory.m3780a(injectorLike), DelegatingPerformanceLogger.m2803a(injectorLike), STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem.m9856a(injectorLike), NewsFeedXConfigReader.m8187a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), AsyncFeedXConfigReader.m9332a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), FreshFeedConfigReader.m9080a(injectorLike), NewsFeedFragmentOfflineController.m15125a(injectorLike), IdleExecutor_ForUiThreadMethodAutoProvider.m10032a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f991e.m2011a("WARM_START_RERANK");
        f11477a = prefKey;
        f11479g = (PrefKey) prefKey.m2011a("RESET_TIME");
    }

    @Inject
    public NewsFeedFragmentDataController(NewsFeedListViewPruner newsFeedListViewPruner, NewsFeedListViewScrollFetcher newsFeedListViewScrollFetcher, FeedDataLoaderFactory feedDataLoaderFactory, Provider<FeedDataLoader> provider, NewsFeedEventLogger newsFeedEventLogger, QeAccessor qeAccessor, NewsFeedLoadingSlowLogger newsFeedLoadingSlowLogger, FeedUnitCache feedUnitCache, FbNetworkManager fbNetworkManager, AnalyticsLogger analyticsLogger, PerfTestConfig perfTestConfig, Lazy<ClickableToastBuilder> lazy, FeedPerfLogger feedPerfLogger, SeeFirstStateManager seeFirstStateManager, FeedPrefetchLoader feedPrefetchLoader, Lazy<ViewAccessibilityHelper> lazy2, NewsFeedBroadcaster newsFeedBroadcaster, Lazy<SSLDialogHelper> lazy3, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, PullToRefreshLogger pullToRefreshLogger, FeedDataLoaderReranker feedDataLoaderReranker, PullToRefreshCounter pullToRefreshCounter, RerankingEventsLogger rerankingEventsLogger, Provider<Boolean> provider2, FbBroadcastManager fbBroadcastManager, BlueServiceOperationFactory blueServiceOperationFactory, PerformanceLogger performanceLogger, Lazy<Set<FeedTypeDataItem>> lazy4, NewsFeedXConfigReader newsFeedXConfigReader, FbSharedPreferences fbSharedPreferences, Clock clock, AsyncFeedXConfigReader asyncFeedXConfigReader, ListeningScheduledExecutorService listeningScheduledExecutorService, FreshFeedConfigReader freshFeedConfigReader, NewsFeedFragmentOfflineDataController newsFeedFragmentOfflineDataController, IdleExecutor idleExecutor) {
        this.f11511i = newsFeedListViewPruner;
        this.f11512j = newsFeedListViewScrollFetcher;
        this.f11513k = feedDataLoaderFactory;
        this.f11514l = provider;
        this.f11515m = newsFeedEventLogger;
        this.f11516n = qeAccessor;
        this.f11517o = newsFeedLoadingSlowLogger;
        this.f11518p = feedUnitCache;
        this.f11519q = fbNetworkManager;
        this.f11520r = analyticsLogger;
        this.f11521s = perfTestConfig;
        this.f11522t = lazy;
        this.f11523u = feedPerfLogger;
        this.f11524v = seeFirstStateManager;
        this.f11525w = feedPrefetchLoader;
        this.f11526x = lazy2;
        this.f11527y = newsFeedBroadcaster;
        this.f11528z = lazy3;
        this.f11481A = newsFeedAnalyticsEventBuilder;
        this.f11482B = pullToRefreshLogger;
        this.f11483C = feedDataLoaderReranker;
        this.f11484D = pullToRefreshCounter;
        this.f11485E = rerankingEventsLogger;
        this.f11486F = provider2;
        this.f11487G = fbBroadcastManager;
        this.f11488H = blueServiceOperationFactory;
        this.f11489I = performanceLogger;
        this.f11490J = lazy4;
        this.f11491K = newsFeedXConfigReader;
        this.f11492L = fbSharedPreferences;
        this.f11493M = clock;
        this.f11494N = asyncFeedXConfigReader;
        this.f11497Q = newsFeedFragmentOfflineDataController;
        this.f11495O = listeningScheduledExecutorService;
        this.f11496P = freshFeedConfigReader;
        this.f11498R = idleExecutor;
    }

    public final void mo1890a(FeedUnit feedUnit) {
        this.f11508c.f5627a.mo1379a(feedUnit);
    }

    public final void mo1887a(MutationType mutationType, Throwable th) {
    }

    public final void av() {
        m16794H(this);
    }

    public final void m16834a(boolean z, int i) {
        m16809a(z, i, LoadType.CACHED_ONLY);
    }

    public final void mo1373c() {
        if (this.ak != null) {
            this.f11501U.m13869a(this.ak);
        }
    }

    public final void mo1368a() {
        if (this.f11501U.aE()) {
            this.ak = this.f11501U.aA();
        }
    }

    public final void mo1371a(boolean z, FetchFeedResult fetchFeedResult, FetchResultState fetchResultState, String str, int i, FetchPortion fetchPortion, ViewPortShift viewPortShift) {
        TracerDetour.a("NewsfeedFragment.onLoadingComplete", 1164755694);
        if (i > 0) {
            try {
                if (this.f11504X.m8963c().equals(Name.f5046a)) {
                    this.ag += i;
                }
            } catch (Throwable th) {
                TracerDetour.a(330646312);
            }
        }
        this.f11524v.m16872a(z, fetchPortion, i, fetchFeedResult, this.f11508c);
        this.f11525w.m16877a(fetchFeedResult);
        if (this.f11501U.aE()) {
            m16810a(z, fetchResultState, str, i, fetchFeedResult);
        }
        if (!z) {
            ExecutorDetour.a(this.f11498R, new C07621(this), 1432753091);
        }
        TracerDetour.a(796710146);
    }

    public final void mo1369a(int i, LoadIntentHint loadIntentHint) {
        TracerDetour.a("NewsfeedFragmentDataController.onHeadLoadComplete", 1293680549);
        this.f11505Y.m16502a(true, !LoadIntentHint.ShowMoreStoryPill.equals(loadIntentHint));
        try {
            switch (C06318.f14730a[loadIntentHint.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    m16803a(i);
                    break;
                default:
                    m16813b(i, loadIntentHint);
                    break;
            }
            TracerDetour.a(1752534869);
        } catch (Throwable th) {
            TracerDetour.a(1065703160);
        }
    }

    public final boolean mo1372b() {
        return this.f11501U.aD();
    }

    private void m16813b(int i, LoadIntentHint loadIntentHint) {
        boolean z = false;
        if (m16819c(i, loadIntentHint)) {
            if (m16791D()) {
                this.f11509d = true;
            } else {
                this.f11509d = false;
                m16820d(i);
                z = true;
            }
        }
        if (this.f11501U.aD() && loadIntentHint.avoidNewStoryPill()) {
            this.f11508c.m9693i();
            m16847u();
        }
        if (i > 0 && this.f11504X.f5044g.equals(Name.f5046a) && r0) {
            this.f11527y.m8784a(i);
        }
    }

    private void m16803a(int i) {
        if (i > 0 && this.f11496P.m9089a(FreshFeedConfig.f5216r, 0, false) && !this.f11501U.aD()) {
            m16806a(this, true);
            this.f11510e = m16790C();
            if (this.f11510e != null) {
                this.am = this.f11495O.mo310a((Runnable) new 2(this), (long) this.f11496P.m9087a(FreshFeedConfig.f5205g, 2, 30), TimeUnit.SECONDS);
            }
        }
    }

    public static boolean m16815b(NewsFeedFragmentDataController newsFeedFragmentDataController, int i) {
        if (i < 0 || i <= newsFeedFragmentDataController.ac.s_(newsFeedFragmentDataController.m16811b(newsFeedFragmentDataController.ad)) || !m16816b(newsFeedFragmentDataController.f11508c.m9677b(i).mo2540c())) {
            return false;
        }
        newsFeedFragmentDataController.af.m20217b(true);
        newsFeedFragmentDataController.m16833a("fresh_feed_new_story_pill_shown");
        return true;
    }

    public static void m16806a(NewsFeedFragmentDataController newsFeedFragmentDataController, boolean z) {
        if (newsFeedFragmentDataController.am != null) {
            newsFeedFragmentDataController.am.cancel(true);
            newsFeedFragmentDataController.am = null;
        }
        if (z) {
            newsFeedFragmentDataController.f11510e = null;
        }
    }

    public final void mo1370a(FetchFeedCause fetchFeedCause) {
        this.f11505Y.m16484a(fetchFeedCause, Location.HEAD);
    }

    public final void m16840g() {
        this.f11503W.m4569b(this.ah);
        this.f11485E.m15258c();
        if (this.ad != null) {
            this.ad = null;
        }
        m16806a(this, true);
    }

    public final void m16841h() {
        m16822z();
    }

    public final void m16842i() {
        boolean z = this.f11507b.mo1305o() || this.f11507b.mo1299e();
        FeedPerfLogger feedPerfLogger = this.f11523u;
        feedPerfLogger.f1666F = z;
        if (feedPerfLogger.f1685t && !z) {
            feedPerfLogger.f1673h.mo374a(655380, "NNFFreshContentStart");
        }
        if (this.f11508c.m9703v()) {
            m16806a(this, true);
            this.af.m20217b(false);
            if (BuildConstants.i && this.f11492L.mo286a(FeedPrefKeys.f5760x, false)) {
                Toast.makeText(this.f11499S, "Beta only: warm start re-ranking", 0).show();
            }
        }
        if (PerfTestConfigBase.m2938a() && PerfTestConfigBase.f1507b) {
            this.f11507b.mo1300f();
        }
        m16821y();
        this.f11482B.m16888d();
    }

    private void m16821y() {
        if (m16789B() && this.f11507b.mo1302h()) {
            this.ad.mo2391h(0);
        }
        m16822z();
    }

    public final void m16836b(FetchFeedCause fetchFeedCause) {
        NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f11505Y;
        if (newsFeedControllerCallbacksDispatcher.f11187o != null) {
            newsFeedControllerCallbacksDispatcher.f11187o.f9751a.m14780a(BlockingCause.IS_LOADING);
        }
        if (newsFeedControllerCallbacksDispatcher.f11153G != null) {
            ViewportMonitorFragmentController viewportMonitorFragmentController = newsFeedControllerCallbacksDispatcher.f11153G;
            if (!fetchFeedCause.isAutoRefresh()) {
                ViewportMonitor viewportMonitor = viewportMonitorFragmentController.f10052a;
                int size = viewportMonitor.f10060c.size();
                for (int i = 0; i < size; i++) {
                    ((ViewportEventListener) viewportMonitor.f10060c.get(i)).mo1966a(viewportMonitor.f10064g);
                }
            }
        }
        if (fetchFeedCause.isManual()) {
            this.f11484D.m16913a();
            this.f11523u.m3376t();
            if (this.ad != null) {
                this.ad.mo2367b((OnDrawListener) new 7(this));
            }
        }
        this.f11507b.mo1293a(fetchFeedCause);
    }

    public final void m16828a(NewsFeedFragment newsFeedFragment, NewsFeedFragment newsFeedFragment2, FeedType feedType, FeedUnitSubscriber feedUnitSubscriber, FeedEventBus feedEventBus, StoryRankingTimeTracker storyRankingTimeTracker, Context context, @Nullable Bundle bundle, NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher) {
        this.f11500T = newsFeedFragment;
        this.f11501U = newsFeedFragment2;
        this.f11502V = feedUnitSubscriber;
        this.f11504X = feedType;
        this.f11503W = feedEventBus;
        this.f11499S = context;
        this.f11505Y = newsFeedControllerCallbacksDispatcher;
        this.f11506Z = storyRankingTimeTracker;
        if (bundle != null) {
            this.al = (FeedDataLoaderInitializationParams) bundle.getParcelable("data_loader_init_params");
        }
        this.f11518p.m10555a((FeedUnitCacheSubscriber) this);
        m16792F();
        this.ab = this.f11501U.m13864a(this.f11512j);
        this.f11482B.m16888d();
    }

    public final void m16832a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (this.f11508c != null && this.ac != null) {
            this.f11482B.f11581o.m16897a(i, scrollingViewProxy.mo2402q());
            if (i == 0) {
                boolean gC_;
                if (this.f11483C.m16908i()) {
                    gC_ = this.f11501U.gC_();
                } else {
                    gC_ = this.f11501U.aD();
                }
                if (gC_) {
                    this.f11515m.m4410a(f11478f.toString(), Event.REACHED_TOP);
                    PullToRefreshLogger pullToRefreshLogger = this.f11482B;
                    if (pullToRefreshLogger.f11579m.mo211a() - pullToRefreshLogger.f11574h >= 5000 && pullToRefreshLogger.f11579m.mo211a() - pullToRefreshLogger.f11575i >= 10000) {
                        ScrollMode a = pullToRefreshLogger.f11581o.m16896a();
                        if (a != ScrollMode.UNKNOWN) {
                            PullToRefreshLogger.m16883a(pullToRefreshLogger, a == ScrollMode.MANUAL ? "ptr_scroll_to_top" : "ptr_jump_to_top");
                            pullToRefreshLogger.f11574h = pullToRefreshLogger.f11579m.mo211a();
                            if (a == ScrollMode.MANUAL) {
                                HandlerDetour.b(pullToRefreshLogger.f11582p, pullToRefreshLogger.f11583q, 5000, 562569023);
                                pullToRefreshLogger.f11586t = true;
                            } else {
                                HandlerDetour.b(pullToRefreshLogger.f11582p, pullToRefreshLogger.f11584r, 5000, 1070692623);
                                pullToRefreshLogger.f11587u = true;
                            }
                        }
                    }
                    if (this.f11508c.m9686d()) {
                        this.f11508c.m9693i();
                    }
                    m16847u();
                } else if (m16797N()) {
                    this.f11509d = false;
                    int f = this.f11508c.f5633i.m9782f();
                    m16820d(f);
                    if (f > 0 && this.f11504X.f5044g.equals(Name.f5046a)) {
                        this.f11527y.m8784a(f);
                    }
                }
            }
        }
    }

    public final void m16829a(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
        this.ac = newsFeedRecyclerViewAdapterWrapper;
        this.f11511i.f11530b = this.ac;
        this.f11512j.f11542b = this.ac;
    }

    public final void m16831a(ScrollingViewProxy scrollingViewProxy) {
        if (this.f11508c.m9700s() && this.f11519q.m3828d() && !this.f11507b.mo1306p()) {
            int b = m16811b(scrollingViewProxy);
            int S = m16802S();
            b = this.ac.s_(b);
            if (this.f11508c.f5631g.m9769a(b)) {
                mo1368a();
                int b2 = this.f11508c.f5631g.m9772b(b);
                int e = this.f11508c.m9688e(b2);
                if (e > 0) {
                    m16804a(S, b, b2, e);
                    this.f11502V.m14620b();
                    m16795I(this);
                }
                mo1373c();
            }
        }
    }

    private int m16811b(ScrollingViewProxy scrollingViewProxy) {
        return Math.max(this.ac.m20017b(), Math.min(scrollingViewProxy.mo2403r(), this.ac.m20022d()));
    }

    @Nullable
    private GraphQLFeedUnitEdge m16790C() {
        FeedUnitCollection feedUnitCollection = this.f11508c;
        if (feedUnitCollection != null) {
            for (int max = Math.max(0, this.ac.s_(m16811b(this.ad))) + 1; max < feedUnitCollection.m9701t(); max++) {
                GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(max);
                if (b instanceof ClientFeedUnitEdge) {
                    ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) b;
                    FeedUnit c = feedUnitCollection.m9677b(max).mo2540c();
                    if (!clientFeedUnitEdge.f14817A && m16816b(c)) {
                        return clientFeedUnitEdge;
                    }
                }
            }
        }
        return null;
    }

    public final void m16843n() {
        this.ah = new CreateScissorsSubscriber(this);
        this.f11503W.m4568a(this.ah);
    }

    public final void m16844p() {
        this.f11507b.mo1304k();
        m16822z();
    }

    private void m16822z() {
        if (this.f11483C.m16906f() && this.f11492L != null) {
            this.f11492L.edit().mo1275a(f11479g, this.f11493M.mo211a()).commit();
        }
    }

    private boolean m16789B() {
        if (this.aj || !this.f11483C.m16906f() || !this.f11507b.mo1320n()) {
            return false;
        }
        long j = 0;
        if (this.f11492L != null) {
            j = this.f11492L.mo277a(f11479g, 0);
        }
        long j2 = j;
        long a = this.f11493M.mo211a() - j2;
        long toMillis = TimeUnit.MINUTES.toMillis((long) this.f11494N.m9351f(9));
        if (j2 <= 0 || a < toMillis) {
            return false;
        }
        return true;
    }

    private static boolean m16816b(FeedUnit feedUnit) {
        return PropertyHelper.m21289b(feedUnit) == null || StringUtil.m3590a(PropertyHelper.m21289b(feedUnit), f11480h);
    }

    public final void m16845r() {
        int S = m16802S();
        ArrayNode Q = m16800Q();
        if (this.f11507b instanceof FreshFeedDataLoader) {
            this.f11507b.mo1309t();
        } else {
            this.f11508c.m9693i();
        }
        m16805a(S, Q);
        m16847u();
        this.f11527y.f4901a.mo406a(new Intent().setAction("com.facebook.feed.util.NEW_STORY_BUTTON_PRESSED"));
        this.ad.mo2391h(0);
        this.f11501U.gB_();
    }

    public final boolean m16846t() {
        return this.ag > 0 && this.f11508c.m9686d() && !m16791D();
    }

    private boolean m16791D() {
        if (this.f11494N.m9354g(false) && 1 != 0 && this.f11501U.aD()) {
            return true;
        }
        return false;
    }

    public final void m16847u() {
        boolean a = this.af.m20216a(false);
        if (this.ag != 0 && a) {
            m16799P();
        }
        this.ag = 0;
        this.f11527y.m8784a(this.ag);
    }

    public final void m16825a(Bundle bundle) {
        if (Name.f5056k.equals(this.f11504X.f5044g)) {
            Builder builder = new Builder();
            builder.a = this.f11508c.mo1374a();
            this.al = new FeedDataLoaderInitializationParams(builder);
        }
        if (bundle != null && this.al != null) {
            bundle.putParcelable("data_loader_init_params", this.al);
        }
    }

    private void m16810a(boolean z, FetchResultState fetchResultState, @Nullable String str, int i, FetchFeedResult fetchFeedResult) {
        boolean z2 = true;
        TracerDetour.a("NewsFeedFragment.handleDataLoaded", 1147827023);
        if (fetchFeedResult != null) {
            try {
                this.f11502V.m14619a(fetchFeedResult.m22439d());
            } catch (Throwable th) {
                TracerDetour.a(897237526);
            }
        }
        boolean d = this.f11519q.m3828d();
        FetchFeedCause fetchFeedCause = FetchFeedCause.UNKNOWN;
        switch (C06318.f14731b[fetchResultState.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f11505Y;
                if (!z || this.f11508c.m9686d()) {
                    z2 = false;
                }
                newsFeedControllerCallbacksDispatcher.m16502a(z, z2);
                if (this.aj) {
                    this.aj = false;
                }
                if (!(fetchFeedResult == null || fetchFeedResult.m22442g() == null)) {
                    fetchFeedCause = fetchFeedResult.m22442g().m9914h();
                }
                if (i > 0) {
                    m16817c(fetchFeedCause);
                }
                if (fetchFeedResult != null && fetchFeedResult.m22442g().m9916j() == FetchTypeForLogging.TAIL && fetchFeedResult.m22442g().m9912e() == DataFreshnessParam.DO_NOT_CHECK_SERVER && fetchFeedResult.m22439d().isEmpty()) {
                    m16809a(true, this.f11508c.mo1374a(), LoadType.ALWAYS);
                }
                this.f11512j.m16866c();
                break;
            case 3:
                this.f11505Y.m16487a(this.f11508c.m9703v() ? ErrorType.EMPTY_DATASET : ErrorType.HAS_STORIES);
                if (m16796J() && d) {
                    m16793G();
                }
                m16814b(str);
                this.ai = d;
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.f11505Y.m16487a(ErrorType.CANCELED);
                break;
        }
        TracerDetour.a(-903989640);
    }

    private void m16792F() {
        TracerDetour.a("NewsfeedFragment.updateDataLoader", -1893494972);
        try {
            if (this.f11507b == null) {
                if (this.f11504X.m8963c().equals(Name.f5053h)) {
                    this.f11507b = FeedDataLoaderFactory.m8943a(this.f11504X, this.f11514l);
                } else {
                    this.f11507b = this.f11513k.m8949a(this.f11504X);
                }
                this.f11515m.m4411a(f11478f.toString(), this.f11507b.mo1321q() ? Event.GOT_PERSISTED_DATA_LOADER : Event.GOT_TRANSIENT_DATA_LOADER, this.f11507b.mo1312a());
                this.f11508c = this.f11507b.mo1315c();
                this.f11511i.m16853a(this.f11507b);
                this.f11512j.m16864a(this.f11507b);
            }
            if (this.f11507b instanceof HitPreviouslyRankedStoriesListener) {
                this.f11506Z.m15520a((HitPreviouslyRankedStoriesListener) this.f11507b);
                this.f11507b.mo1292a(this.f11506Z);
            }
            this.f11507b.mo1291a((FeedDataLoaderListener) this);
            this.f11502V.m14618a(this.f11508c, (FeedOnDataChangeListener) this);
            this.f11502V.m14620b();
        } finally {
            TracerDetour.a(420630583);
        }
    }

    private void m16814b(String str) {
        if (str != null && this.f11499S != null && !((SSLDialogHelper) this.f11528z.get()).b(this.f11499S, str) && BuildConstants.i) {
            Toast.makeText(this.f11499S, "Beta only: " + str, 1).show();
        }
    }

    public final void mo1900b(boolean z) {
        if (this.f11501U.aE()) {
            boolean d = this.f11519q.m3828d();
            this.ai = d;
            if (d && this.f11500T.f137y) {
                this.f11507b.mo1298d();
                this.f11512j.m16866c();
            }
        }
    }

    private void m16793G() {
        ConnectionRetrySnackbarView connectionRetrySnackbarView = new ConnectionRetrySnackbarView(this.f11499S);
        connectionRetrySnackbarView.setRetryClickListener(new 5(this, connectionRetrySnackbarView));
        this.ae = ((ClickableToastBuilder) this.f11522t.get()).a(connectionRetrySnackbarView, 10000);
        this.ae.i = this.aa;
        this.ae.a();
    }

    public static void m16794H(NewsFeedFragmentDataController newsFeedFragmentDataController) {
        if (newsFeedFragmentDataController.ae != null) {
            newsFeedFragmentDataController.ae.b();
        }
        newsFeedFragmentDataController.f11508c.m9693i();
        newsFeedFragmentDataController.m16847u();
        if (newsFeedFragmentDataController.f11519q.m3828d()) {
            newsFeedFragmentDataController.m16836b(FetchFeedCause.PULL_TO_REFRESH);
            HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("manual_refresh");
            honeyClientEvent.f3099c = "native_newsfeed";
            HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
            if (honeyAnalyticsEvent != null) {
                newsFeedFragmentDataController.f11520r.mo526a(honeyAnalyticsEvent);
            }
        } else if (newsFeedFragmentDataController.f11483C.m16904d()) {
            newsFeedFragmentDataController.m16836b(FetchFeedCause.RERANK);
        } else {
            newsFeedFragmentDataController.m16793G();
            newsFeedFragmentDataController.f11505Y.m16487a(ErrorType.HAS_STORIES);
        }
        if (((Boolean) newsFeedFragmentDataController.f11486F.get()).booleanValue()) {
            newsFeedFragmentDataController.f11487G.mo406a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.FEED_PULL_TO_REFRESH));
        }
    }

    public static void m16795I(NewsFeedFragmentDataController newsFeedFragmentDataController) {
        if (!newsFeedFragmentDataController.f11507b.mo1306p()) {
            ArrayList arrayList = new ArrayList(newsFeedFragmentDataController.f11508c.m9695k());
            Iterator it = newsFeedFragmentDataController.f11508c.iterator();
            while (it.hasNext()) {
                arrayList.add(((GraphQLFeedUnitEdge) it.next()).mo2540c().mo2507g());
            }
            it = newsFeedFragmentDataController.f11508c.f5633i.iterator();
            while (it.hasNext()) {
                arrayList.add(((GraphQLFeedUnitEdge) it.next()).mo2540c().mo2507g());
            }
            newsFeedFragmentDataController.f11518p.m10564a(arrayList);
        }
    }

    private void m16809a(boolean z, int i, LoadType loadType) {
        boolean z2 = true;
        boolean d = this.f11519q.m3828d();
        DataFreshnessParam dataFreshnessParam = DataFreshnessParam.STALE_DATA_OKAY;
        if (loadType == LoadType.CACHED_ONLY || (loadType == LoadType.CHECK_CONNECTION && !d)) {
            dataFreshnessParam = DataFreshnessParam.DO_NOT_CHECK_SERVER;
        }
        if (this.f11516n.mo596a(ExperimentsForNewsFeedAbTestModule.f5107h, false) && !this.f11491K.m8203r()) {
            loadType = LoadType.ALWAYS;
            dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        }
        FetchFeedCause fetchFeedCause = FetchFeedCause.SCROLLING;
        FetchRequestState a = this.f11507b.mo1290a(dataFreshnessParam, fetchFeedCause, loadType == LoadType.ALWAYS);
        switch (C06318.f14732c[a.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f11505Y.m16484a(fetchFeedCause, Location.TAIL);
                if (!this.f11489I.mo400h(655422, "NNFTailFetchTime")) {
                    this.f11523u.m3367g(z);
                    this.f11501U.mo1909n().mo2367b((OnDrawListener) new 6(this, i));
                }
                break;
            case 3:
                m16809a(z, i, LoadType.ALWAYS);
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.f11505Y.m16484a(fetchFeedCause, Location.TAIL);
                break;
        }
        if ((a == FetchRequestState.SUCCESS || a == FetchRequestState.ALREADY_SCHEDULED) && z) {
            IFeedDataLoader iFeedDataLoader = this.f11507b;
            fetchFeedCause = FetchFeedCause.SCROLLING;
            if (loadType != LoadType.ALWAYS) {
                z2 = false;
            }
            iFeedDataLoader.mo1296b(dataFreshnessParam, fetchFeedCause, z2);
        }
    }

    private void m16817c(FetchFeedCause fetchFeedCause) {
        TracerDetour.a("NewsFeedFragment.selectRowIfRerank", 526856678);
        try {
            if (this.ad == null || fetchFeedCause != FetchFeedCause.RERANK) {
                TracerDetour.a(-1884373764);
                return;
            }
            this.ad.mo2378d(0, 0);
            TracerDetour.a(1820864383);
        } catch (Throwable th) {
            TracerDetour.a(1367099946);
        }
    }

    private boolean m16796J() {
        return this.f11508c.mo1374a() > 0 && this.ad.mo2402q() == 0;
    }

    private boolean m16819c(int i, LoadIntentHint loadIntentHint) {
        if (i > 0 && (!this.f11501U.aD() || loadIntentHint.showNewStoryPill())) {
            boolean z;
            for (AbstractFeedTypeDataItem abstractFeedTypeDataItem : (Set) this.f11490J.get()) {
                if (abstractFeedTypeDataItem.f5763a.equals(this.f11504X.f5044g)) {
                    break;
                }
            }
            AbstractFeedTypeDataItem abstractFeedTypeDataItem2 = null;
            AbstractFeedTypeDataItem abstractFeedTypeDataItem3 = abstractFeedTypeDataItem2;
            if (abstractFeedTypeDataItem3 != null) {
                z = abstractFeedTypeDataItem3.f5765c;
            } else {
                z = false;
            }
            if (z && !this.f11500T.f108L) {
                return true;
            }
        }
        return false;
    }

    private boolean m16797N() {
        return this.f11509d && !this.f11507b.mo1305o() && this.f11508c.m9686d() && m16819c(this.f11508c.f5633i.m9782f(), LoadIntentHint.AvoidNewStoryPill);
    }

    public final void m16833a(String str) {
        HoneyClientEventFast a = this.f11520r.mo535a(str, false);
        if (a.m17388a()) {
            a.m17390b();
        }
        this.f11515m.m4415a(f11478f, str, null);
    }

    private void m16820d(int i) {
        if (i >= this.f11516n.mo572a(ExperimentsForNewsFeedAbTestModule.f5088O, 0)) {
            boolean a = this.af.m20216a(true);
            if (this.ag == i && a) {
                m16798O();
            }
        }
    }

    private void m16807a(Event event) {
        this.f11515m.m4411a(f11478f.toString(), event, ", Stories:" + this.ag);
    }

    private void m16798O() {
        m16818c("feed_new_story_pill_shown");
        m16807a(Event.NEW_STORY_PILL_SHOWN);
    }

    private void m16805a(int i, ArrayNode arrayNode) {
        m16808a("feed_new_story_pill_tapped", i, arrayNode);
        m16807a(Event.NEW_STORY_PILL_TAPPED);
    }

    private void m16799P() {
        m16818c("feed_new_story_pill_hidden");
        m16807a(Event.NEW_STORY_PILL_HIDDEN);
    }

    private void m16818c(String str) {
        m16808a(str, m16802S(), m16800Q());
    }

    private void m16808a(String str, int i, ArrayNode arrayNode) {
        HoneyAnalyticsEvent a = new HoneyClientEvent(str).m5083a("position", i).m5085a("tracking", (JsonNode) arrayNode).m5083a("num_stories_fetched_in_last_result", this.ag);
        a.f3099c = "android_pull_to_refresh";
        this.f11520r.mo526a(a);
    }

    private void m16804a(int i, int i2, int i3, int i4) {
        HoneyClientEventFast a = this.f11520r.mo535a("feed_gap_drop_on_scroll", false);
        if (a.m17388a()) {
            a.m17381a("first", i);
            a.m17381a("last", i2);
            a.m17381a("gap", i3);
            a.m17381a("dropped", i4);
            a.m17383a("tracking", m16800Q());
            a.m17390b();
        }
    }

    @Nullable
    private ArrayNode m16800Q() {
        if (!this.f11501U.aE() || this.f11508c == null) {
            return null;
        }
        int R = m16801R();
        if (R < 0 || R >= this.f11508c.mo1374a()) {
            return null;
        }
        GraphQLFeedUnitEdge b = this.f11508c.m9677b(R);
        if (b == null || b.mo2540c() == null) {
            return null;
        }
        return FeedTrackableUtil.m27148a(b.mo2540c());
    }

    private int m16801R() {
        if (!this.f11501U.aE() || this.f11508c == null || this.ac.mo2512e() == 0) {
            return -1;
        }
        int q = this.ad.mo2402q();
        if (q < this.ac.m20017b() || q > this.ac.m20022d()) {
            return -1;
        }
        return this.ac.s_(q);
    }

    private int m16802S() {
        if (this.ad == null || this.ad.mo2402q() != -1) {
            return m16801R();
        }
        return -1;
    }

    public final void au() {
        this.f11507b.mo1293a(FetchFeedCause.ERROR_RETRY);
    }

    public final void aw() {
        if (this.ad.mo2404s() != 0) {
            int s = this.ad.mo2404s();
            m16809a(this.ad.mo2403r() >= s, s, LoadType.ALWAYS);
        }
    }
}
