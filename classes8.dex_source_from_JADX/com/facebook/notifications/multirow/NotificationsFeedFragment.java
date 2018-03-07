package com.facebook.notifications.multirow;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.apptab.state.TabTag;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateProxyScrollListener;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.notifications.GraphQLNotificationsContract;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.cache.BaseListenableCache.OnChangeListener;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.impressionlogging.NotificationsFeedViewportEventListener;
import com.facebook.notifications.loader.NotificationsLoader;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.notifications.model.NotificationStories;
import com.facebook.notifications.multirow.NotificationsFeedAdapter.TailLoadingState;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncHelper.NotificationAsyncRequestCompletionListener;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.notifications.util.NotificationsFetchCountHelper;
import com.facebook.notifications.util.NotificationsFragmentTouchUtil;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ListScrollStateSnapshot;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewUtils;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.refreshableview.ConnectionRetrySnackbarView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: custom_cta_switch_to_linkout */
public class NotificationsFeedFragment extends FbFragment implements LoaderCallbacks<List<NotificationsEdgeFields>>, AnalyticsFragmentWithExtraData, OnChangeListener, ReactionCardContainer, OnDrawListener, ScrollableListContainer {
    public static final CallerContext f16084a = CallerContext.a(NotificationsFeedFragment.class, "notifications");
    public static final Class<?> f16085b = NotificationsFeedFragment.class;
    @Inject
    NotificationsSyncManager aA;
    @Inject
    NotificationsUtils aB;
    @Inject
    PerformanceLogger aC;
    @Inject
    QuickPerformanceLogger aD;
    @Inject
    public ReactionSessionManager aE;
    @Inject
    ReactionThemedContextHelper aF;
    @Inject
    ReactionUtil aG;
    @Inject
    DefaultAndroidThreadUtil aH;
    @Inject
    TodayExperimentController aI;
    @Inject
    ViewerContextManager aJ;
    @Inject
    ViewportMonitor aK;
    @Inject
    ReactionFeedActionHandlerProvider aL;
    @Inject
    NotificationsFeedEnvironmentProvider aM;
    public NotificationsFeedAdapter aN;
    private SelfRegistrableReceiverImpl aO;
    private Context aP;
    private LoadingIndicatorView aQ;
    private SelfRegistrableReceiverImpl aR;
    public NotificationsFeedInteractionTracker aS;
    private FrameRateLogger aT;
    private NotificationsFeedFragmentOnScrollListener aU;
    private ReactionAnalyticsParams aV;
    private ReactionSession aW;
    public BetterRecyclerView aX;
    private RecyclerViewProxy aY;
    public RetryClickedListener aZ;
    @Inject
    GraphQLNotificationsContract al;
    @Inject
    JewelCounters am;
    @Inject
    VMMemoryInfo an;
    @Inject
    MonotonicClock ao;
    @Inject
    NetworkMonitor ap;
    @Inject
    NotificationsFeedAdapterProvider aq;
    @Inject
    public NotificationsFeedCollection ar;
    @Inject
    public NotificationsFeedInteractionTrackerProvider as;
    @Inject
    NotificationsFeedViewportEventListener at;
    @Inject
    NotificationsFetchCountHelper au;
    @Inject
    NotificationsFragmentTouchUtil av;
    @Inject
    NotificationsFunnelLogger aw;
    @Inject
    NotificationsLastUpdatedUtil ax;
    @Inject
    DefaultNotificationsRenderer ay;
    @Inject
    NotificationsRowWithActionHelper az;
    public ClickableToast ba;
    public FbSwipeRefreshLayout bb;
    public Optional<Long> bc = Absent.INSTANCE;
    private boolean bd = true;
    public boolean be = false;
    private int bf = 0;
    public long bg;
    private boolean bh = false;
    private int bi = 100;
    private boolean bj = false;
    public int bk = 0;
    public long bl;
    public boolean bm = false;
    public boolean bn = false;
    public int bo = -1;
    @Inject
    public AnalyticsLogger f16086c;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f16087d;
    @Inject
    ClickableToastBuilder f16088e;
    @Inject
    Clock f16089f;
    @Inject
    AbstractFbErrorReporter f16090g;
    @Inject
    FrameRateLoggerProvider f16091h;
    @Inject
    GraphQLNotificationsContentProviderHelper f16092i;

    /* compiled from: custom_cta_switch_to_linkout */
    class C17181 implements Runnable {
        final /* synthetic */ NotificationsFeedFragment f16071a;

        C17181(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16071a = notificationsFeedFragment;
        }

        public void run() {
            if (this.f16071a.aN != null) {
                this.f16071a.aN.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    class C17203 implements Runnable {
        final /* synthetic */ NotificationsFeedFragment f16073a;

        C17203(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16073a = notificationsFeedFragment;
        }

        public void run() {
            if (this.f16073a.aN != null) {
                this.f16073a.aN.m18829e();
            }
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    class C17224 implements Delegate {
        final /* synthetic */ NotificationsFeedFragment f16076a;

        C17224(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16076a = notificationsFeedFragment;
        }

        public final void m18880a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            this.f16076a.aX.a(new OnScrollListener(this) {
                final /* synthetic */ C17224 f16075b;

                public final void m18879a(RecyclerView recyclerView, int i, int i2) {
                    super.a(recyclerView, i, i2);
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    class C17235 implements OnClickListener {
        final /* synthetic */ NotificationsFeedFragment f16077a;

        C17235(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16077a = notificationsFeedFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 160120691);
            NotificationsFeedFragment.au(this.f16077a);
            this.f16077a.aN.f16036i = TailLoadingState.LOADING;
            this.f16077a.aN.m18829e();
            Logger.a(2, EntryType.UI_INPUT_END, -297245778, a);
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    public class C17246 implements RetryClickedListener {
        final /* synthetic */ NotificationsFeedFragment f16078a;

        public C17246(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16078a = notificationsFeedFragment;
        }

        public final void m18881a() {
            NotificationsFeedFragment.m18888a(this.f16078a, SyncSource.PULL_TO_REFRESH);
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    public class C17257 implements OnClickListener {
        final /* synthetic */ NotificationsFeedFragment f16079a;

        public C17257(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16079a = notificationsFeedFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 79323857);
            NotificationsFeedFragment.m18888a(this.f16079a, SyncSource.PULL_TO_REFRESH);
            Logger.a(2, EntryType.UI_INPUT_END, 752335182, a);
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    class C17268 implements OnRefreshListener {
        final /* synthetic */ NotificationsFeedFragment f16080a;

        C17268(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16080a = notificationsFeedFragment;
        }

        public final void m18882a() {
            if (this.f16080a.ap.a()) {
                NotificationsFeedFragment.m18888a(this.f16080a, SyncSource.PULL_TO_REFRESH);
                return;
            }
            this.f16080a.bb.setRefreshing(false);
            NotificationsFeedFragment.aw(this.f16080a);
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    class C17279 implements Runnable {
        final /* synthetic */ NotificationsFeedFragment f16081a;

        C17279(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16081a = notificationsFeedFragment;
        }

        public void run() {
            NotificationsFeedFragment.m18888a(this.f16081a, SyncSource.CONNECTIVITY);
        }
    }

    /* compiled from: custom_cta_switch_to_linkout */
    class NotificationsFeedFragmentOnScrollListener implements ScrollingViewProxy.OnScrollListener {
        final /* synthetic */ NotificationsFeedFragment f16082a;
        private int f16083b = 0;

        public NotificationsFeedFragmentOnScrollListener(NotificationsFeedFragment notificationsFeedFragment) {
            this.f16082a = notificationsFeedFragment;
        }

        public final void m18883a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f16082a.av.a(scrollingViewProxy, i);
            this.f16083b = i;
        }

        public final void m18884a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            int max;
            this.f16082a.bo = i2;
            NotificationsFeedFragment notificationsFeedFragment = this.f16082a;
            if (i + i2 == this.f16082a.aN.aZ_()) {
                max = Math.max((i + i2) - 1, this.f16082a.bk);
            } else {
                max = Math.max(i + i2, this.f16082a.bk);
            }
            notificationsFeedFragment.bk = max;
            if (this.f16083b != 0) {
                this.f16082a.bm = true;
            }
            if (this.f16082a.aN.aZ_() > 0 && i + i2 >= this.f16082a.aN.aZ_() && !this.f16082a.be) {
                if ((this.f16082a.aN.f16036i == TailLoadingState.LOADING ? 1 : null) != null) {
                    NotificationsFeedFragment.au(this.f16082a);
                }
            }
        }
    }

    public static void m18889a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NotificationsFeedFragment) obj).m18886a(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ClickableToastBuilder.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), GraphQLNotificationsContentProviderHelper.a(injectorLike), GraphQLNotificationsContract.a(injectorLike), JewelCounters.a(injectorLike), VMMemoryInfoMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), NetworkMonitor.a(injectorLike), (NotificationsFeedAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationsFeedAdapterProvider.class), NotificationsFeedCollection.m18836a(injectorLike), (NotificationsFeedInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationsFeedInteractionTrackerProvider.class), NotificationsFeedViewportEventListener.a(injectorLike), NotificationsFetchCountHelper.a(injectorLike), NotificationsFragmentTouchUtil.a(injectorLike), NotificationsFunnelLogger.a(injectorLike), NotificationsLastUpdatedUtil.a(injectorLike), DefaultNotificationsRenderer.a(injectorLike), NotificationsRowWithActionHelper.a(injectorLike), NotificationsSyncManager.a(injectorLike), NotificationsUtils.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), ReactionSessionManager.m22590a(injectorLike), ReactionThemedContextHelper.m22628a(injectorLike), ReactionUtil.m22637a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), TodayExperimentController.a(injectorLike), ViewerContextManagerProvider.a(injectorLike), ViewportMonitor.a(injectorLike), (ReactionFeedActionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), (NotificationsFeedEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationsFeedEnvironmentProvider.class));
    }

    private void m18886a(AnalyticsLogger analyticsLogger, BaseFbBroadcastManager baseFbBroadcastManager, ClickableToastBuilder clickableToastBuilder, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter, FrameRateLoggerProvider frameRateLoggerProvider, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, GraphQLNotificationsContract graphQLNotificationsContract, JewelCounters jewelCounters, VMMemoryInfo vMMemoryInfo, MonotonicClock monotonicClock, NetworkMonitor networkMonitor, NotificationsFeedAdapterProvider notificationsFeedAdapterProvider, NotificationsFeedCollection notificationsFeedCollection, NotificationsFeedInteractionTrackerProvider notificationsFeedInteractionTrackerProvider, NotificationsFeedViewportEventListener notificationsFeedViewportEventListener, NotificationsFetchCountHelper notificationsFetchCountHelper, NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, NotificationsFunnelLogger notificationsFunnelLogger, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil, DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsRowWithActionHelper notificationsRowWithActionHelper, NotificationsSyncManager notificationsSyncManager, NotificationsUtils notificationsUtils, PerformanceLogger performanceLogger, QuickPerformanceLogger quickPerformanceLogger, ReactionSessionManager reactionSessionManager, ReactionThemedContextHelper reactionThemedContextHelper, ReactionUtil reactionUtil, DefaultAndroidThreadUtil defaultAndroidThreadUtil, TodayExperimentController todayExperimentController, ViewerContextManager viewerContextManager, ViewportMonitor viewportMonitor, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, NotificationsFeedEnvironmentProvider notificationsFeedEnvironmentProvider) {
        this.f16086c = analyticsLogger;
        this.f16087d = baseFbBroadcastManager;
        this.f16088e = clickableToastBuilder;
        this.f16089f = clock;
        this.f16090g = abstractFbErrorReporter;
        this.f16091h = frameRateLoggerProvider;
        this.f16092i = graphQLNotificationsContentProviderHelper;
        this.al = graphQLNotificationsContract;
        this.am = jewelCounters;
        this.an = vMMemoryInfo;
        this.ao = monotonicClock;
        this.ap = networkMonitor;
        this.aq = notificationsFeedAdapterProvider;
        this.ar = notificationsFeedCollection;
        this.as = notificationsFeedInteractionTrackerProvider;
        this.at = notificationsFeedViewportEventListener;
        this.au = notificationsFetchCountHelper;
        this.av = notificationsFragmentTouchUtil;
        this.aw = notificationsFunnelLogger;
        this.ax = notificationsLastUpdatedUtil;
        this.ay = defaultNotificationsRenderer;
        this.az = notificationsRowWithActionHelper;
        this.aA = notificationsSyncManager;
        this.aB = notificationsUtils;
        this.aC = performanceLogger;
        this.aD = quickPerformanceLogger;
        this.aE = reactionSessionManager;
        this.aF = reactionThemedContextHelper;
        this.aG = reactionUtil;
        this.aH = defaultAndroidThreadUtil;
        this.aI = todayExperimentController;
        this.aJ = viewerContextManager;
        this.aK = viewportMonitor;
        this.aL = reactionFeedActionHandlerProvider;
        this.aM = notificationsFeedEnvironmentProvider;
    }

    public final void m18901a(Loader loader, Object obj) {
        List list = (List) obj;
        this.bh = true;
        if (CollectionUtil.a(list) && this.bd) {
            this.bd = false;
            m18888a(this, SyncSource.FRAGMENT_LOADED);
            return;
        }
        m18893b(this, list);
        int i = 0;
        for (NotificationsEdgeFields k : this.ar.f16044c.f16039b) {
            int i2;
            if (k.k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 0) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("notification_auto_update_list_update");
            honeyClientEvent.c = "notifications";
            this.f16086c.c(honeyClientEvent.b("reason", "new_notifications_notif_fragment"));
        }
    }

    public final void m18906c(@Nullable Bundle bundle) {
        Class cls = NotificationsFeedFragment.class;
        m18889a((Object) this, getContext());
        super.c(bundle);
        E().a(100, null, this);
        if (this.an.a()) {
            this.bi = 30;
        }
        this.bl = this.aI.s();
        if (this.aI.c()) {
            this.aA.a(this.aG.m22655a(getSurface()));
        }
        String uuid = SafeUUIDGenerator.a().toString();
        ReactionSession a = this.aE.m22603a(uuid, getSurface());
        this.aE.m22616c(uuid);
        this.aS = this.as.m18957a(a, null, this.ar);
        this.aW = a;
        this.aV = new ReactionAnalyticsParams(null, getSurface().name(), "unknown", null);
        this.aT = this.f16091h.a(Boolean.valueOf(false), "notification_multirow_scroll_perf", Optional.of(String.valueOf(am_())));
    }

    @Nullable
    public Surface getSurface() {
        return Surface.ANDROID_NOTIFICATIONS;
    }

    public final void a_(Context context) {
        super.a_(context);
        this.aP = context;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2000366067);
        super.mi_();
        this.bk = 0;
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131233663);
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 836689844, a);
    }

    public final void m18902a(Collection collection) {
        this.ar.m18846b(collection);
        this.aN.m18829e();
        if (this.aI.x() && D()) {
            this.aK.a(this.aY);
        }
    }

    public final void gB_() {
        if (this.aY != null) {
            this.aY.e(0);
        }
    }

    public static void m18892b(NotificationsFeedFragment notificationsFeedFragment, OperationResult operationResult) {
        if (operationResult.e != null && operationResult.f != null) {
            String a = notificationsFeedFragment.m18885a(notificationsFeedFragment.getContext().getString(2131230811), operationResult.e.ordinal(), operationResult.f);
            BLog.b(f16085b, a);
            notificationsFeedFragment.f16090g.a(f16085b.getSimpleName() + "_sync_failed", a);
        }
    }

    public final boolean gC_() {
        return this.aY == null ? true : this.aY.n();
    }

    @Nullable
    public final ScrollingViewProxy m18909n() {
        return this.aY;
    }

    public final void m18908g(boolean z) {
        boolean D = D();
        super.g(z);
        if (mx_() && D != z) {
            m18896e();
            if (D()) {
                this.bf = this.am.a(Jewel.NOTIFICATIONS);
                if (this.bf > 0 && m18909n() != null) {
                    m18909n().w();
                }
                if (this.bn) {
                    aA(this);
                    this.bn = false;
                }
            } else {
                av();
            }
        }
        if (!(this.aI == null || !this.aI.x() || this.aK == null || this.aY == null)) {
            this.aK.a(z, this.aY);
            if (z && D != z) {
                this.aK.a(this.aY, this.aY.q(), (this.aY.r() - this.aY.q()) + 1, this.aY.s());
            }
        }
        this.bj = z;
        if (this.aB != null) {
            this.aB.g = z;
        }
        if (this.ba != null) {
            this.ba.b();
        }
    }

    private void m18896e() {
        if (this.aN != null && D()) {
            this.aB.a(this.aJ.d());
        }
    }

    public final Loader<List<NotificationsEdgeFields>> n_(int i) {
        switch (i) {
            case 100:
                ViewerContext d = this.aJ.d();
                if (d != null) {
                    Loader<List<NotificationsEdgeFields>> notificationsLoader = new NotificationsLoader(getContext(), this.f16092i, getContext().getContentResolver(), this.al.b, d, this.au.a(this.aP, o().getWindowManager().getDefaultDisplay(), this.ay), false, this.ax);
                    if (!this.aI.c()) {
                        return notificationsLoader;
                    }
                    notificationsLoader.f = Optional.of(this.aG.m22655a(getSurface()));
                    return notificationsLoader;
                }
                break;
        }
        BLog.b(f16085b, "Unexpected onCreateLoader: %d", new Object[]{Integer.valueOf(i)});
        return null;
    }

    public final void gA_() {
        if (this.bb != null) {
            this.bb.setRefreshing(false);
        }
        m18895c(null);
        m18890a(false);
    }

    public final void m18897G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1883967345);
        super.G();
        this.aC.b(655408, "NNF_PermalinkNotificationLoad");
        m18890a(true);
        this.aN.f16036i = TailLoadingState.LOADING;
        if (D()) {
            this.aB.g = true;
            if (this.aI.x()) {
                this.aK.a(true, this.aY);
            }
        }
        this.az.i = new C17181(this);
        this.aw.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -969044560, a);
    }

    public final void m18898H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1453083472);
        super.H();
        av();
        this.aB.g = false;
        this.az.i = null;
        if (this.aI.x()) {
            this.aK.a(false, this.aY);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -265670447, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ScrollingViewUtils.a(this.aY);
    }

    public static void m18888a(NotificationsFeedFragment notificationsFeedFragment, SyncSource syncSource) {
        if (notificationsFeedFragment.ba != null) {
            notificationsFeedFragment.ba.b();
        }
        if (notificationsFeedFragment.aJ.d() != null) {
            notificationsFeedFragment.aN.f16036i = TailLoadingState.LOADING;
            if (syncSource == SyncSource.PULL_TO_REFRESH) {
                notificationsFeedFragment.aD.b(3473413);
            }
            notificationsFeedFragment.aH.a(notificationsFeedFragment.aA.a(notificationsFeedFragment.aJ.d(), syncSource), new NotificationAsyncRequestCompletionListener(notificationsFeedFragment, Long.valueOf(Long.parseLong(notificationsFeedFragment.aJ.d().mUserId))) {
                final /* synthetic */ NotificationsFeedFragment f16072a;

                public /* synthetic */ void onSuccess(Object obj) {
                    m18878a((OperationResult) obj);
                }

                public final void m18878a(OperationResult operationResult) {
                    super.a(operationResult);
                    if (operationResult.b) {
                        NotificationsFeedFragment.m18887a(this.f16072a, operationResult);
                        return;
                    }
                    NotificationsFeedFragment.m18892b(this.f16072a, operationResult);
                    NotificationsFeedFragment.aq(this.f16072a);
                }

                public void onFailure(Throwable th) {
                    super.onFailure(th);
                    NotificationsFeedFragment.aq(this.f16072a);
                }
            });
            notificationsFeedFragment.m18890a(true);
        }
    }

    public final boolean mo728a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return false;
    }

    public final boolean mo729a(String str, CardSearchType cardSearchType) {
        return false;
    }

    @Nullable
    public final ReactionUnitFragment mo725a(String str) {
        return null;
    }

    @Nullable
    public ViewGroup getCardViewGroup() {
        return this.aX;
    }

    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.aS;
    }

    public String getSessionId() {
        return this.aW.f18658a;
    }

    public static void m18893b(NotificationsFeedFragment notificationsFeedFragment, List list) {
        ListScrollStateSnapshot listScrollStateSnapshot = new ListScrollStateSnapshot();
        boolean z = (notificationsFeedFragment.aX == null || notificationsFeedFragment.aY == null) ? false : true;
        if (z) {
            notificationsFeedFragment.aY.a(listScrollStateSnapshot);
        }
        notificationsFeedFragment.m18895c(list);
        if (z) {
            notificationsFeedFragment.aY.b(listScrollStateSnapshot);
        }
        if (notificationsFeedFragment.bb != null) {
            notificationsFeedFragment.bb.setRefreshing(false);
        }
        notificationsFeedFragment.aD.b(3473413, (short) 2);
        notificationsFeedFragment.m18890a(false);
        notificationsFeedFragment.m18896e();
    }

    public static void m18887a(NotificationsFeedFragment notificationsFeedFragment, OperationResult operationResult) {
        FetchGraphQLNotificationsResult fetchGraphQLNotificationsResult = (FetchGraphQLNotificationsResult) operationResult.k();
        if (fetchGraphQLNotificationsResult != null && fetchGraphQLNotificationsResult.a != null && fetchGraphQLNotificationsResult.a.deltaStories == null && fetchGraphQLNotificationsResult.a.newStories == null) {
            notificationsFeedFragment.m18890a(false);
        }
        if (notificationsFeedFragment.bb != null) {
            notificationsFeedFragment.bb.setRefreshing(false);
        }
    }

    private void m18890a(boolean z) {
        Object obj = null;
        ViewerContext d = this.aJ.d();
        if (mx_() && this.aQ != null && d != null) {
            Object obj2 = (this.aN == null || this.ar.m18847e()) ? 1 : null;
            this.aQ.setVisibility(obj2 != null ? 0 : 8);
            if (obj2 == null || !z || E() == null || !E().a()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (this.aN == null || r0 != null || this.aA.a(Long.parseLong(d.mUserId))) {
                obj = 1;
            }
            if (obj != null) {
                this.aQ.a();
            } else {
                this.aQ.b();
            }
        }
    }

    public static void aq(NotificationsFeedFragment notificationsFeedFragment) {
        if (notificationsFeedFragment.aQ != null) {
            notificationsFeedFragment.aQ.a(notificationsFeedFragment.aP.getResources().getString(2131230811), notificationsFeedFragment.aZ);
        }
        notificationsFeedFragment.aD.b(3473413, (short) 3);
    }

    public final View m18899a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 955253950);
        Context a2 = ReactionThemedContextHelper.m22627a(getContext(), getSurface());
        View inflate = layoutInflater.cloneInContext(a2).inflate(2130905487, viewGroup, false);
        this.aQ = (LoadingIndicatorView) FindViewUtil.b(inflate, 2131560407);
        this.aX = (BetterRecyclerView) FindViewUtil.b(inflate, 16908298);
        this.bb = (FbSwipeRefreshLayout) FindViewUtil.b(inflate, 2131561342);
        this.aX.setLayoutManager(new BetterLinearLayoutManager(getContext()));
        this.aY = new RecyclerViewProxy(this.aX);
        TypedValue typedValue = new TypedValue();
        a2.getTheme().resolveAttribute(2130772382, typedValue, true);
        this.aY.k();
        this.aQ.setBackgroundResource(typedValue.resourceId);
        this.bb.setBackgroundResource(typedValue.resourceId);
        m18894c(a2);
        this.aS.m18931a(new LayoutManagerWithKeepAttachedHack(this.aX), this.ao.now(), false);
        this.aY.a(this.aN);
        this.f16092i.a(this);
        this.aU = new NotificationsFeedFragmentOnScrollListener(this);
        this.aY.b(this.aU);
        this.aY.b(new FrameRateProxyScrollListener(this.aT));
        this.aY.a(this);
        if (this.aI.x()) {
            this.aK.a(false, this.aY);
            this.aK.a(this.at);
            this.aY.b(this.aK);
        }
        this.av.a(this.aY);
        this.av.a(this.aY, this.aX);
        if (this.aI.b()) {
            ax();
        }
        this.aZ = new C17246(this);
        FindViewUtil.b(inflate, 2131564285).setOnClickListener(new C17257(this));
        as();
        at();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1471076017, a);
        return inflate;
    }

    private NotificationsFeedEnvironment m18891b(Context context) {
        return this.aM.m18877a(context, NotificationsFeedListType.f16125a, null, new C17203(this), this.aV, this.aL.m23162a(context, this), this.aS, this.aW, new C17224(this), this.ar);
    }

    private void m18894c(Context context) {
        if (this.aN == null) {
            this.aN = this.aq.m18830a(m18891b(context), null, this.ar);
            this.aN.f16037j = new C17235(this);
        }
    }

    private void as() {
        this.bb.e = new C17268(this);
        this.bb.setEnabled(true);
    }

    private void at() {
        String str = this.f16092i.d() ? "cold" : "warm";
        this.aC.a(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName, "load_type", str, true);
        this.aC.a(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim, "load_type", str, true);
        if (D()) {
            PerformanceLogger performanceLogger;
            MarkerConfig a;
            if (this.f16092i.d()) {
                performanceLogger = this.aC;
                a = new MarkerConfig(3473417, "NotifListLoadTimeCold").a(new String[]{TabTag.Notifications.analyticsTag});
                a.n = true;
                performanceLogger.c(a);
            } else {
                performanceLogger = this.aC;
                a = new MarkerConfig(3473418, "NotifListLoadTimeWarm").a(new String[]{TabTag.Notifications.analyticsTag});
                a.n = true;
                performanceLogger.c(a);
            }
            this.aD.a(3473421, ImmutableList.of(TabTag.Notifications.analyticsTag));
            this.aD.a(3473413, ImmutableList.of(TabTag.Notifications.analyticsTag));
            this.bj = true;
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1383500360);
        super.mY_();
        if (this.aR != null) {
            this.aR.c();
        }
        if (this.aO != null) {
            this.aO.c();
        }
        if (this.aN != null) {
            this.f16092i.b(this);
        }
        this.bb.e = null;
        this.bb = null;
        if (!(this.aI == null || !this.aI.x() || this.aK == null)) {
            this.aK.b(this.at);
            this.aY.c(this.aK);
        }
        this.aY.c(this.aU);
        this.aY.a(null);
        this.aY.x();
        this.aY = null;
        this.aU = null;
        this.aX = null;
        this.aQ = null;
        this.aC.b(3473417, "NotifListLoadTimeCold");
        this.aC.b(3473418, "NotifListLoadTimeWarm");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2033701892, a);
    }

    public final void m18907d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1411848120);
        super.d(bundle);
        this.aR = this.ap.a(State.CONNECTED, new C17279(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1528071160, a);
    }

    private String m18885a(String str, int i, String str2) {
        if (i == 0) {
            return str;
        }
        return getContext().getString(2131233664, new Object[]{str, Integer.valueOf(i), str2});
    }

    public final boolean gD_() {
        if (this.bj && this.bh) {
            this.aC.c(3473417, "NotifListLoadTimeCold");
            this.aC.c(3473418, "NotifListLoadTimeWarm");
            this.aC.a(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName, "load_type", "hot", false);
            this.aC.c(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName);
            this.aC.a(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim, "load_type", "hot", false);
            this.aC.c(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim);
            this.bj = false;
        }
        return false;
    }

    public static void au(NotificationsFeedFragment notificationsFeedFragment) {
        if (notificationsFeedFragment.ar.m18838a() > notificationsFeedFragment.bi) {
            notificationsFeedFragment.aN.f16036i = TailLoadingState.FINISHED;
            return;
        }
        String str;
        NotificationsFeedCollection notificationsFeedCollection = notificationsFeedFragment.ar;
        if (notificationsFeedCollection.m18847e()) {
            str = null;
        } else {
            NotificationsEdgeFields notificationsEdgeFields;
            if (notificationsFeedCollection.f16043b.m18832a() > 0) {
                notificationsEdgeFields = (NotificationsEdgeFields) notificationsFeedCollection.f16043b.f16039b.get(notificationsFeedCollection.f16043b.m18832a() - 1);
            } else if (notificationsFeedCollection.f16044c.m18832a() > 0) {
                notificationsEdgeFields = (NotificationsEdgeFields) notificationsFeedCollection.f16044c.f16039b.get(notificationsFeedCollection.f16044c.m18832a() - 1);
            } else {
                notificationsEdgeFields = null;
            }
            str = notificationsEdgeFields == null ? null : notificationsEdgeFields.a();
        }
        String str2 = str;
        if (str2 != null) {
            notificationsFeedFragment.aD.b(3473421);
            notificationsFeedFragment.be = true;
            notificationsFeedFragment.aH.a(notificationsFeedFragment.aA.a(notificationsFeedFragment.aJ.d(), str2, f16084a, notificationsFeedFragment.ar.m18838a()), new FutureCallback<OperationResult>(notificationsFeedFragment) {
                final /* synthetic */ NotificationsFeedFragment f16067a;

                {
                    this.f16067a = r1;
                }

                public void onSuccess(Object obj) {
                    short s;
                    OperationResult operationResult = (OperationResult) obj;
                    this.f16067a.be = false;
                    FetchGraphQLNotificationsResult fetchGraphQLNotificationsResult = (FetchGraphQLNotificationsResult) operationResult.k();
                    if (fetchGraphQLNotificationsResult != null) {
                        NotificationStories notificationStories = fetchGraphQLNotificationsResult.a;
                        if (notificationStories != null && CollectionUtil.a(notificationStories.newStories)) {
                            this.f16067a.aN.f16036i = TailLoadingState.FINISHED;
                        }
                        if (fetchGraphQLNotificationsResult.freshness == DataFreshnessResult.FROM_CACHE_UP_TO_DATE) {
                            if (this.f16067a.mx_()) {
                                LoaderManager E = this.f16067a.E();
                                if (E != null) {
                                    ((NotificationsLoader) E.b(100)).y = notificationStories.newStories.size();
                                }
                            }
                            NotificationsFeedFragment.m18893b(this.f16067a, notificationStories.a());
                            s = (short) 26;
                        } else {
                            s = (short) 27;
                        }
                    } else {
                        s = (short) 2;
                    }
                    this.f16067a.aD.b(3473421, s);
                }

                public void onFailure(Throwable th) {
                    this.f16067a.aD.b(3473421, (short) 3);
                    this.f16067a.aN.f16036i = TailLoadingState.FAILED;
                    this.f16067a.be = false;
                }
            });
        }
    }

    private void av() {
        if (this.bk != 0 && this.bm) {
            boolean z = this.bk > this.bo;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("notification_scroll_depth_v2");
            honeyClientEvent.c = "notifications";
            this.f16086c.a(honeyClientEvent.a("scroll_depth", this.bk).a("jewel_count", this.bf).a("visible_item_count", this.bo).a("passed_scroll_threshold", z));
            this.bm = false;
        }
    }

    public final String am_() {
        return TabTag.Notifications.analyticsTag;
    }

    public final Map<String, Object> m18905c() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("jewel_count", Integer.valueOf(this.bf));
        return hashMap;
    }

    public static void aw(NotificationsFeedFragment notificationsFeedFragment) {
        ConnectionRetrySnackbarView connectionRetrySnackbarView = new ConnectionRetrySnackbarView(notificationsFeedFragment.getContext());
        connectionRetrySnackbarView.setRetryClickListener(new OnClickListener(notificationsFeedFragment) {
            final /* synthetic */ NotificationsFeedFragment f16068a;

            {
                this.f16068a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -342654796);
                this.f16068a.ba.b();
                if (this.f16068a.ap.a()) {
                    NotificationsFeedFragment.m18888a(this.f16068a, SyncSource.PULL_TO_REFRESH);
                } else {
                    this.f16068a.bb.setRefreshing(false);
                    NotificationsFeedFragment.aw(this.f16068a);
                }
                LogUtils.a(-546263031, a);
            }
        });
        notificationsFeedFragment.ba = notificationsFeedFragment.f16088e.a(connectionRetrySnackbarView, 10000);
        notificationsFeedFragment.ba.i = notificationsFeedFragment.bb;
        notificationsFeedFragment.ba.a();
    }

    private void m18895c(@Nullable List<NotificationsEdgeFields> list) {
        this.ar.m18843a((Collection) list);
        this.aN.m18829e();
        if (this.aI.x() && D()) {
            this.aK.a(this.aY);
        }
    }

    private void ax() {
        this.aO = this.f16087d.a().a(AppStateManager.b, new ActionReceiver(this) {
            final /* synthetic */ NotificationsFeedFragment f16069a;

            {
                this.f16069a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -308209830);
                boolean z = this.f16069a.bc.isPresent() && this.f16069a.f16089f.a() - ((Long) this.f16069a.bc.get()).longValue() > 1000 * this.f16069a.bl;
                if (z) {
                    if (this.f16069a.D()) {
                        NotificationsFeedFragment.aA(this.f16069a);
                    } else {
                        this.f16069a.bn = true;
                    }
                }
                this.f16069a.bc = Absent.INSTANCE;
                LogUtils.e(-2000112775, a);
            }
        }).a(AppStateManager.c, new ActionReceiver(this) {
            final /* synthetic */ NotificationsFeedFragment f16070a;

            {
                this.f16070a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                long j;
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -826334427);
                this.f16070a.bc = Optional.of(Long.valueOf(this.f16070a.f16089f.a()));
                NotificationsFeedFragment notificationsFeedFragment = this.f16070a;
                NotificationsFeedCollection notificationsFeedCollection = this.f16070a.ar;
                if (notificationsFeedCollection.m18847e()) {
                    j = 0;
                } else {
                    NotificationsEdgeFields notificationsEdgeFields = null;
                    if (notificationsFeedCollection.f16044c.m18832a() > 0) {
                        notificationsEdgeFields = (NotificationsEdgeFields) notificationsFeedCollection.f16044c.f16039b.get(0);
                    } else if (notificationsFeedCollection.f16043b.m18832a() > 0) {
                        notificationsEdgeFields = (NotificationsEdgeFields) notificationsFeedCollection.f16043b.f16039b.get(0);
                    }
                    if (notificationsEdgeFields == null || notificationsEdgeFields.k() == null) {
                        j = 0;
                    } else {
                        j = notificationsEdgeFields.k().V();
                    }
                }
                notificationsFeedFragment.bg = j;
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1304888742, a);
            }
        }).a();
        this.aO.b();
    }

    public static void aA(NotificationsFeedFragment notificationsFeedFragment) {
        notificationsFeedFragment.ar.m18841a(notificationsFeedFragment.bg);
        notificationsFeedFragment.aN.m18829e();
    }
}
