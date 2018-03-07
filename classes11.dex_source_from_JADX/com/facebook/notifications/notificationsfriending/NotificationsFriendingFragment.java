package com.facebook.notifications.notificationsfriending;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.apptab.state.TabTag;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.friending.common.list.model.FriendListUserCommonModel;
import com.facebook.friends.FriendingCacheHandler;
import com.facebook.friends.FriendingCacheHandler.2;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.UserBlockedEvent;
import com.facebook.friends.events.FriendingEvents.UserBlockedEventSubscriber;
import com.facebook.friends.logging.FriendRequestLogger;
import com.facebook.friends.logging.PYMKImpressionLogger;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.friends.util.FriendRequestUtil.1;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.notifications.GraphQLNotificationsContract;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.common.JewelCounters.OnJewelCountChangeListener;
import com.facebook.notifications.event.NotificationsEventBus;
import com.facebook.notifications.event.NotificationsEvents.NotificationsClickedEvent;
import com.facebook.notifications.loader.NotificationsLoader;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.notificationsfriending.abtest.ExperimentsForNotificationsFriendingAbTestModule;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.notifications.notificationsfriending.adapter.FriendRequestsAdapterSection;
import com.facebook.notifications.notificationsfriending.adapter.NotificationsAdapterSection;
import com.facebook.notifications.notificationsfriending.adapter.NotificationsAdapterSection.LoadResult;
import com.facebook.notifications.notificationsfriending.adapter.PeopleYouMayKnowAdapterSection;
import com.facebook.notifications.notificationsfriending.adapter.PeopleYouMayKnowAdapterSection.LoadingState;
import com.facebook.notifications.notificationsfriending.logging.NotificationsFriendingAnalyticsLogger;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncHelper.NotificationAsyncRequestCompletionListener;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.notifications.util.DefaultNotificationStoryLauncher;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.notifications.util.NotificationStoryLauncher;
import com.facebook.notifications.util.NotificationsFragmentTouchUtil;
import com.facebook.notifications.util.NotificationsHighlightHelper.HighlightType;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.notifications.widget.DefaultNotificationsView;
import com.facebook.notifications.widget.PostFeedbackView;
import com.facebook.notifications.widget.SwitchableNotificationView;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.facebook.widget.listview.ListScrollStateSnapshot;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemLongClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.facebook.widget.listview.ScrollingViewUtils;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.refreshableview.ConnectionRetrySnackbarView;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tile_id */
public class NotificationsFriendingFragment extends FbListFragment implements LoaderCallbacks<List<NotificationsEdgeFields>>, AnalyticsFragmentWithExtraData, FragmentWithDebugInfo, OnDrawListener, ScrollableListContainer, ScrollingViewProxyContainer {
    public static final Class<?> bb = NotificationsFriendingFragment.class;
    private static final InterstitialTrigger bc = new InterstitialTrigger(Action.NOTIFICATIONS_TAB_FULLY_SHOWN);
    public static final CallerContext f980i = CallerContext.a(NotificationsFriendingFragment.class, "notifications_friending");
    @Inject
    InteractionTTILogger aA;
    @Inject
    InterstitialManager aB;
    @Inject
    public JewelCounters aC;
    @Inject
    DefaultNotificationStoryLauncher aD;
    @Inject
    NavigationLogger aE;
    @Inject
    NetworkMonitor aF;
    @Inject
    public NotificationsFriendingAdapter aG;
    @Inject
    NotificationsFriendingAnalyticsLogger aH;
    @Inject
    NotificationsLastUpdatedUtil aI;
    @Inject
    NotificationsSyncManager aJ;
    @Inject
    NotificationsUtils aK;
    @Inject
    NotificationsFragmentTouchUtil aL;
    @Inject
    NotificationsFriendingExperimentController aM;
    @Inject
    NotificationsEventBus aN;
    @Inject
    NotificationsFunnelLogger aO;
    @Inject
    NotificationsInlineActionsHelper aP;
    @Inject
    NotificationsRowWithActionHelper aQ;
    @Inject
    NotificationsLogger aR;
    @Inject
    NotificationStoryHelper aS;
    @Inject
    PerformanceLogger aT;
    @Inject
    PYMKImpressionLogger aU;
    @Inject
    QuickPerformanceLogger aV;
    @Inject
    TasksManager aW;
    @Inject
    ViewerContextManager aX;
    @Inject
    ViewportMonitor aY;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager aZ;
    @Inject
    DefaultAndroidThreadUtil al;
    @Inject
    public AnalyticsLogger am;
    @Inject
    AnalyticsTagger an;
    @Inject
    AppStateManager ao;
    @Inject
    ClickableToastBuilder ap;
    @Inject
    Clock aq;
    @Inject
    AbstractFbErrorReporter ar;
    @Inject
    public FbUriIntentHandler as;
    @Inject
    FbSharedPreferences at;
    @Inject
    FriendingCacheHandlerProvider au;
    @Inject
    FriendingClient av;
    @Inject
    FriendingEventBus aw;
    @Inject
    FriendRequestLogger ax;
    @Inject
    GraphQLNotificationsContentProviderHelper ay;
    @Inject
    GraphQLNotificationsContract az;
    private int bA = 0;
    private long bB = 0;
    private boolean bC = false;
    private boolean bD = false;
    public int bE = 0;
    public boolean bF = false;
    private int bG = 0;
    public int bH = -1;
    public boolean bI;
    public boolean bJ = false;
    public String bK;
    public int bL = 0;
    public int bM = 0;
    @Inject
    @LoggedInUserId
    Provider<String> ba;
    public SelfRegistrableReceiverImpl bd;
    public SelfRegistrableReceiverImpl be;
    public FriendingCacheHandler bf;
    private SelfRegistrableReceiverImpl bg;
    private NotificationsFragmentOnScrollListener bh;
    public ClickableToast bi;
    public TextView bj;
    public LoadingIndicatorView bk;
    public DefaultNotificationsView bl;
    private FriendshipStatusChangedEventSubscriber bm;
    private PYMKBlacklistedEventSubscriber bn;
    private UserBlockedEventSubscriber bo;
    private OnSharedPreferenceChangeListener bp;
    private OnJewelCountChangeListener bq;
    public final List<NotificationsEdgeFields> br = new ArrayList();
    public Optional<Long> bs = Absent.INSTANCE;
    private Animation bt;
    public Animation bu;
    private boolean bv;
    private boolean bw = true;
    public int bx = -1;
    private boolean by;
    private boolean bz;

    /* compiled from: tile_id */
    class C01291 implements Runnable {
        final /* synthetic */ NotificationsFriendingFragment f958a;

        C01291(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f958a = notificationsFriendingFragment;
        }

        public void run() {
            NotificationsFriendingFragment.m1280a(this.f958a, SyncSource.CONNECTIVITY);
        }
    }

    /* compiled from: tile_id */
    class C01302 implements Runnable {
        final /* synthetic */ NotificationsFriendingFragment f968a;

        C01302(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f968a = notificationsFriendingFragment;
        }

        public void run() {
            AdapterDetour.a(this.f968a.aG, -61237937);
        }
    }

    /* compiled from: tile_id */
    class C01324 extends BaseAnimationListener {
        final /* synthetic */ NotificationsFriendingFragment f972a;

        C01324(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f972a = notificationsFriendingFragment;
        }

        public void onAnimationStart(Animation animation) {
            this.f972a.bj.setVisibility(0);
        }
    }

    /* compiled from: tile_id */
    class C01335 extends BaseAnimationListener {
        final /* synthetic */ NotificationsFriendingFragment f973a;

        C01335(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f973a = notificationsFriendingFragment;
        }

        public void onAnimationEnd(Animation animation) {
            this.f973a.bj.setVisibility(8);
        }
    }

    /* compiled from: tile_id */
    class C01346 implements OnClickListener {
        final /* synthetic */ NotificationsFriendingFragment f974a;

        C01346(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f974a = notificationsFriendingFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 593344805);
            ScrollingViewProxy scrollingViewProxy = this.f974a.bl.getScrollingViewProxy();
            if (scrollingViewProxy != null) {
                scrollingViewProxy.c((this.f974a.aG.m1252h() + scrollingViewProxy.u()) - 1, 0);
            }
            this.f974a.bj.startAnimation(this.f974a.bu);
            Logger.a(2, EntryType.UI_INPUT_END, -1940630179, a);
        }
    }

    /* compiled from: tile_id */
    class C01357 implements OnRefreshListener {
        final /* synthetic */ NotificationsFriendingFragment f975a;

        C01357(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f975a = notificationsFriendingFragment;
        }

        public final void m1270a() {
            if (this.f975a.aF.a()) {
                NotificationsFriendingFragment.m1280a(this.f975a, SyncSource.PULL_TO_REFRESH);
                return;
            }
            NotificationsFriendingFragment.ar(this.f975a).setRefreshing(false);
            NotificationsFriendingFragment.aS(this.f975a);
        }
    }

    /* compiled from: tile_id */
    class C01368 implements OnItemLongClickListener {
        final /* synthetic */ NotificationsFriendingFragment f976a;

        C01368(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f976a = notificationsFriendingFragment;
        }

        public final boolean m1271a(View view, int i) {
            if (this.f976a.m1299n() == null) {
                return true;
            }
            Object g = this.f976a.m1299n().g(i);
            if (g instanceof FriendListUserCommonModel) {
                return false;
            }
            if (!(view instanceof BetterTextView)) {
                NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) g;
                if (notificationsEdgeFields == null || notificationsEdgeFields.k() == null) {
                    this.f976a.ar.a(NotificationsFriendingFragment.bb + "_long_click", "Null story edge in long click");
                    return true;
                }
                this.f976a.aP.a(notificationsEdgeFields, this.f976a.getContext(), view, this.f976a.aQ.a(notificationsEdgeFields.k().g(), notificationsEdgeFields.k().c()), i);
            }
            return true;
        }
    }

    /* compiled from: tile_id */
    class NotificationsFragmentOnScrollListener implements OnScrollListener {
        final /* synthetic */ NotificationsFriendingFragment f978a;
        private int f979b = 0;

        public NotificationsFragmentOnScrollListener(NotificationsFriendingFragment notificationsFriendingFragment) {
            this.f978a = notificationsFriendingFragment;
        }

        public final void m1273a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f978a.aL.a(scrollingViewProxy, i);
            this.f979b = i;
        }

        public final void m1274a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            int max;
            this.f978a.bx = i;
            this.f978a.bH = i2;
            NotificationsFriendingFragment notificationsFriendingFragment = this.f978a;
            if (i + i2 == i3) {
                max = Math.max((i + i2) - 1, this.f978a.bE);
            } else {
                max = Math.max(i + i2, this.f978a.bE);
            }
            notificationsFriendingFragment.bE = max;
            if (this.f979b != 0) {
                this.f978a.bF = true;
            }
            if ((i + i2) + 3 >= i3) {
                NotificationsFriendingFragment.m1285b(this.f978a, false);
            }
        }
    }

    public static void m1281a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NotificationsFriendingFragment) obj).m1276a(DefaultAndroidThreadUtil.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AnalyticsTagger.a(injectorLike), AppStateManager.a(injectorLike), ClickableToastBuilder.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbUriIntentHandler.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (FriendingCacheHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendingCacheHandlerProvider.class), FriendingClient.a(injectorLike), FriendingEventBus.a(injectorLike), FriendRequestLogger.a(injectorLike), GraphQLNotificationsContentProviderHelper.a(injectorLike), GraphQLNotificationsContract.a(injectorLike), InteractionTTILogger.a(injectorLike), InterstitialManager.a(injectorLike), JewelCounters.a(injectorLike), DefaultNotificationStoryLauncher.a(injectorLike), NavigationLogger.a(injectorLike), NetworkMonitor.a(injectorLike), NotificationsFriendingAdapter.m1232a(injectorLike), NotificationsFriendingAnalyticsLogger.m1384a(injectorLike), NotificationsLastUpdatedUtil.a(injectorLike), NotificationsSyncManager.a(injectorLike), NotificationsUtils.a(injectorLike), NotificationsFragmentTouchUtil.a(injectorLike), NotificationsFriendingExperimentController.a(injectorLike), NotificationsEventBus.a(injectorLike), NotificationsFunnelLogger.a(injectorLike), NotificationsInlineActionsHelper.a(injectorLike), NotificationsRowWithActionHelper.a(injectorLike), NotificationsLogger.a(injectorLike), NotificationStoryHelper.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), PYMKImpressionLogger.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), TasksManager.a(injectorLike), ViewerContextManagerProvider.a(injectorLike), ViewportMonitor.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    private void m1276a(AndroidThreadUtil androidThreadUtil, AnalyticsLogger analyticsLogger, AnalyticsTagger analyticsTagger, AppStateManager appStateManager, ClickableToastBuilder clickableToastBuilder, Clock clock, FbErrorReporter fbErrorReporter, FbUriIntentHandler fbUriIntentHandler, FbSharedPreferences fbSharedPreferences, FriendingCacheHandlerProvider friendingCacheHandlerProvider, FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendRequestLogger friendRequestLogger, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, GraphQLNotificationsContract graphQLNotificationsContract, InteractionTTILogger interactionTTILogger, InterstitialManager interstitialManager, JewelCounters jewelCounters, NotificationStoryLauncher notificationStoryLauncher, NavigationLogger navigationLogger, NetworkMonitor networkMonitor, NotificationsFriendingAdapter notificationsFriendingAdapter, NotificationsFriendingAnalyticsLogger notificationsFriendingAnalyticsLogger, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil, NotificationsSyncManager notificationsSyncManager, NotificationsUtils notificationsUtils, NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, NotificationsFriendingExperimentController notificationsFriendingExperimentController, NotificationsEventBus notificationsEventBus, NotificationsFunnelLogger notificationsFunnelLogger, NotificationsInlineActionsHelper notificationsInlineActionsHelper, NotificationsRowWithActionHelper notificationsRowWithActionHelper, NotificationsLogger notificationsLogger, NotificationStoryHelper notificationStoryHelper, PerformanceLogger performanceLogger, PYMKImpressionLogger pYMKImpressionLogger, QuickPerformanceLogger quickPerformanceLogger, TasksManager tasksManager, ViewerContextManager viewerContextManager, ViewportMonitor viewportMonitor, FbBroadcastManager fbBroadcastManager, Provider<String> provider) {
        this.al = androidThreadUtil;
        this.am = analyticsLogger;
        this.an = analyticsTagger;
        this.ao = appStateManager;
        this.ap = clickableToastBuilder;
        this.aq = clock;
        this.ar = fbErrorReporter;
        this.as = fbUriIntentHandler;
        this.at = fbSharedPreferences;
        this.au = friendingCacheHandlerProvider;
        this.av = friendingClient;
        this.aw = friendingEventBus;
        this.ax = friendRequestLogger;
        this.ay = graphQLNotificationsContentProviderHelper;
        this.az = graphQLNotificationsContract;
        this.aA = interactionTTILogger;
        this.aB = interstitialManager;
        this.aC = jewelCounters;
        this.aD = notificationStoryLauncher;
        this.aE = navigationLogger;
        this.aF = networkMonitor;
        this.aG = notificationsFriendingAdapter;
        this.aH = notificationsFriendingAnalyticsLogger;
        this.aI = notificationsLastUpdatedUtil;
        this.aJ = notificationsSyncManager;
        this.aK = notificationsUtils;
        this.aL = notificationsFragmentTouchUtil;
        this.aM = notificationsFriendingExperimentController;
        this.aN = notificationsEventBus;
        this.aO = notificationsFunnelLogger;
        this.aP = notificationsInlineActionsHelper;
        this.aQ = notificationsRowWithActionHelper;
        this.aR = notificationsLogger;
        this.aS = notificationStoryHelper;
        this.aT = performanceLogger;
        this.aU = pYMKImpressionLogger;
        this.aV = quickPerformanceLogger;
        this.aW = tasksManager;
        this.aX = viewerContextManager;
        this.aY = viewportMonitor;
        this.aZ = fbBroadcastManager;
        this.ba = provider;
    }

    public final void m1294a(Loader loader, Object obj) {
        List<NotificationsEdgeFields> list = (List) obj;
        this.bC = true;
        if ((list == null || list.isEmpty()) && this.bw) {
            this.bw = false;
            m1286b(SyncSource.FRAGMENT_LOADED);
            return;
        }
        this.br.clear();
        if (list != null) {
            for (NotificationsEdgeFields notificationsEdgeFields : list) {
                if (notificationsEdgeFields.k() != null) {
                    this.br.add(notificationsEdgeFields);
                }
            }
        }
        int i = 0;
        for (NotificationsEdgeFields k : this.br) {
            int i2;
            if (k.k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.bG = i;
        if (this.bG > 0) {
            this.aP.a();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("notification_auto_update_list_update");
            honeyClientEvent.c = "notifications_friending";
            this.am.c(honeyClientEvent.b("reason", "new_notifications_notif_fragment"));
        }
        as();
    }

    public final void m1293a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2086882477);
        super.a(bundle);
        Class cls = NotificationsFriendingFragment.class;
        m1281a((Object) this, getContext());
        this.bf = this.au.a(this.aW);
        E().a(100, null, this);
        this.bd = this.aZ.a().a(AppStateManager.b, new ActionReceiver(this) {
            final /* synthetic */ NotificationsFriendingFragment f965a;

            {
                this.f965a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -827895360);
                Object obj = (!this.f965a.bs.isPresent() || this.f965a.aq.a() - ((Long) this.f965a.bs.get()).longValue() <= 1000 * this.f965a.aM.i()) ? null : 1;
                if (obj != null) {
                    this.f965a.aG.m1242a(this.f965a.br, NotificationsFriendingFragment.aL(this.f965a));
                }
                this.f965a.bs = Absent.INSTANCE;
                LogUtils.e(-2023067709, a);
            }
        }).a();
        this.bd.b();
        this.be = this.aZ.a().a(AppStateManager.c, new ActionReceiver(this) {
            final /* synthetic */ NotificationsFriendingFragment f966a;

            {
                this.f966a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 447266236);
                this.f966a.bs = Optional.of(Long.valueOf(this.f966a.aq.a()));
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 708844988, a);
            }
        }).a();
        this.be.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1135504935, a);
    }

    public final View m1292a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1611583142);
        this.bl = new DefaultNotificationsView(getContext());
        this.bl.a(false);
        this.bl.c(false);
        this.an.a(this.bl, "jewel_popup_notifications", this);
        if (this.aM.a.a(ExperimentsForNotificationsFriendingAbTestModule.a, false)) {
            ao();
        }
        ap();
        if (this.aP.b()) {
            aq();
        }
        this.bh = new NotificationsFragmentOnScrollListener(this);
        this.aY.a(new BaseViewportEventListener(this) {
            final /* synthetic */ NotificationsFriendingFragment f967a;

            {
                this.f967a = r1;
            }

            public final void m1269a(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i, int i2) {
                int u = (i + i2) - scrollingViewProxy.u();
                if (obj instanceof FriendRequest) {
                    NotificationsFriendingAdapter notificationsFriendingAdapter = this.f967a.aG;
                    boolean z = false;
                    int[] d = notificationsFriendingAdapter.d(u);
                    if (notificationsFriendingAdapter.f947h.get(d[0]) == notificationsFriendingAdapter.f945f) {
                        z = true;
                    }
                    Preconditions.checkArgument(z, "The given position is not within the Friend Requests section");
                    u = d[1];
                    this.f967a.bL = Math.max(this.f967a.bL, u + 1);
                    FriendRequest friendRequest = (FriendRequest) obj;
                    if (!friendRequest.h) {
                        NotificationsFriendingFragment.aI(this.f967a);
                        NotificationsFriendingFragment.az(this.f967a);
                    }
                    if (this.f967a.ax.a() && !friendRequest.k) {
                        this.f967a.ax.a(friendRequest.a(), FriendRequestResponseRef.MOBILE_JEWEL, this.f967a.bK);
                        friendRequest.n();
                    }
                } else if (obj instanceof PersonYouMayKnow) {
                    u = this.f967a.aG.m1254i(u);
                    this.f967a.bM = Math.max(this.f967a.bM, u + 1);
                    PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) obj;
                    if (!personYouMayKnow.h) {
                        this.f967a.aU.a(personYouMayKnow.a(), PeopleYouMayKnowLocation.JEWEL, this.f967a.bK);
                        personYouMayKnow.i();
                    }
                }
            }
        });
        if (m1299n() != null) {
            m1299n().b(this.bh);
            m1299n().b(this.aY);
            m1299n().a(this);
            this.aL.a(m1299n());
            this.bk = (LoadingIndicatorView) layoutInflater.inflate(2130907191, m1299n().b(), false);
            m1299n().e(this.bk);
        }
        this.bz = true;
        this.bK = String.valueOf(this.aq.a());
        String str = this.ay.d() ? "cold" : "warm";
        this.aT.a(TabTag.NotificationsFriending.loadTabTabPerfMarkerId, TabTag.NotificationsFriending.loadTabTabPerfMarkerName, "load_type", str, true);
        this.aT.a(TabTag.NotificationsFriending.loadTabTabPerfMarkerIdNoAnim, TabTag.NotificationsFriending.loadTabTabPerfMarkerNameNoAnim, "load_type", str, true);
        if (D()) {
            PerformanceLogger performanceLogger;
            MarkerConfig a2;
            if (this.ay.d()) {
                performanceLogger = this.aT;
                a2 = new MarkerConfig(9502729, "NotifListLoadTimeCold").a(new String[]{TabTag.NotificationsFriending.analyticsTag});
                a2.n = true;
                performanceLogger.c(a2);
            } else {
                performanceLogger = this.aT;
                a2 = new MarkerConfig(9502730, "NotifListLoadTimeWarm").a(new String[]{TabTag.NotificationsFriending.analyticsTag});
                a2.n = true;
                performanceLogger.c(a2);
            }
            this.aV.a(9502731, ImmutableList.of(TabTag.NotificationsFriending.analyticsTag));
            this.aV.a(9502725, ImmutableList.of(TabTag.NotificationsFriending.analyticsTag));
            this.bD = true;
        }
        this.bm = new FriendshipStatusChangedEventSubscriber(this) {
            public final /* synthetic */ NotificationsFriendingFragment f948a;

            {
                this.f948a = r1;
            }

            public final void m1259b(FbEvent fbEvent) {
                FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
                if (friendshipStatusChangedEvent != null) {
                    NotificationsFriendingAdapter notificationsFriendingAdapter = this.f948a.aG;
                    if (notificationsFriendingAdapter.f945f.m1327b(friendshipStatusChangedEvent.a)) {
                        long j = friendshipStatusChangedEvent.a;
                        GraphQLFriendshipStatus graphQLFriendshipStatus = friendshipStatusChangedEvent.b;
                        boolean c = this.f948a.aG.f945f.m1329c(j);
                        FriendRequestState friendRequestState = null;
                        switch (1.c[graphQLFriendshipStatus.ordinal()]) {
                            case 1:
                                if (!c) {
                                    friendRequestState = FriendRequestState.ACCEPTED;
                                    break;
                                }
                                break;
                            case 2:
                                if (!c) {
                                    friendRequestState = FriendRequestState.NEEDS_RESPONSE;
                                    break;
                                }
                                break;
                            case 3:
                                if (c) {
                                    friendRequestState = FriendRequestState.ACCEPTED;
                                    break;
                                }
                                break;
                            case 4:
                                friendRequestState = FriendRequestState.REJECTED;
                                break;
                        }
                        FriendRequestState friendRequestState2 = friendRequestState;
                        if (friendRequestState2 != null) {
                            this.f948a.aG.m1241a(String.valueOf(j), friendRequestState2, true);
                        } else {
                            NotificationsFriendingFragment notificationsFriendingFragment = this.f948a;
                            notificationsFriendingFragment.bf.b(new FutureCallback(notificationsFriendingFragment) {
                                final /* synthetic */ NotificationsFriendingFragment f953a;

                                {
                                    this.f953a = r1;
                                }

                                public void onSuccess(@Nullable Object obj) {
                                    NotificationsFriendingFragment.aH(this.f953a);
                                }

                                public void onFailure(Throwable th) {
                                }
                            });
                        }
                        return;
                    }
                    notificationsFriendingAdapter = this.f948a.aG;
                    notificationsFriendingAdapter.f946g.m1370a(friendshipStatusChangedEvent.a, friendshipStatusChangedEvent.b);
                }
            }
        };
        this.bn = new PYMKBlacklistedEventSubscriber(this) {
            final /* synthetic */ NotificationsFriendingFragment f949a;

            {
                this.f949a = r1;
            }

            public final void m1260b(FbEvent fbEvent) {
                PYMKBlacklistedEvent pYMKBlacklistedEvent = (PYMKBlacklistedEvent) fbEvent;
                if (pYMKBlacklistedEvent != null) {
                    this.f949a.aG.m1249c(pYMKBlacklistedEvent.a);
                }
            }
        };
        this.bo = new UserBlockedEventSubscriber(this) {
            final /* synthetic */ NotificationsFriendingFragment f950a;

            {
                this.f950a = r1;
            }

            public final void m1261b(FbEvent fbEvent) {
                UserBlockedEvent userBlockedEvent = (UserBlockedEvent) fbEvent;
                if (userBlockedEvent != null) {
                    this.f950a.aG.m1240a(String.valueOf(userBlockedEvent.a));
                    this.f950a.aG.m1249c(userBlockedEvent.a);
                }
            }
        };
        this.aw.a(this.bm);
        this.aw.a(this.bn);
        this.aw.a(this.bo);
        if (!StringUtil.a((CharSequence) this.ba.get()) && this.aM.p()) {
            this.bp = new OnSharedPreferenceChangeListener(this) {
                final /* synthetic */ NotificationsFriendingFragment f964a;

                {
                    this.f964a = r1;
                }

                public final void m1268a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
                    if (this.f964a.aG.m1257l() && this.f964a.aG.m1253i() == 0 && fbSharedPreferences.a(prefKey, false)) {
                        AdapterDetour.a(this.f964a.aG, -880515963);
                        NotificationsFriendingFragment notificationsFriendingFragment = this.f964a;
                        FriendingCacheHandler friendingCacheHandler = notificationsFriendingFragment.bf;
                        friendingCacheHandler.e.a("CLEAR_PYMK_CACHE_TASK", new FriendingCacheHandler.1(friendingCacheHandler), new 2(friendingCacheHandler, new FutureCallback(notificationsFriendingFragment) {
                            final /* synthetic */ NotificationsFriendingFragment f954a;

                            {
                                this.f954a = r1;
                            }

                            public void onSuccess(@Nullable Object obj) {
                                NotificationsFriendingFragment.aH(this.f954a);
                            }

                            public void onFailure(Throwable th) {
                            }
                        }));
                    }
                }
            };
            this.at.a(GrowthPrefKeys.a((String) this.ba.get()), this.bp);
        }
        DefaultNotificationsView defaultNotificationsView = this.bl;
        LogUtils.f(572414270, a);
        return defaultNotificationsView;
    }

    public final void m1297d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1149789760);
        super.d(bundle);
        this.bg = this.aF.a(State.CONNECTED, new C01291(this));
        this.aG.f946g.f1022c.a();
        a(this.aG);
        this.bq = new OnJewelCountChangeListener(this) {
            final /* synthetic */ NotificationsFriendingFragment f951a;

            {
                this.f951a = r1;
            }

            public final void m1262a(Jewel jewel, int i) {
                if (jewel == Jewel.FRIEND_REQUESTS && i > 0) {
                    NotificationsFriendingFragment.aE(this.f951a);
                    if (NotificationsFriendingFragment.aM(this.f951a)) {
                        this.f951a.aG.m1242a(this.f951a.br, true);
                    }
                }
            }
        };
        this.aC.a(this.bq);
        if (this.aC.a(Jewel.FRIEND_REQUESTS) > 0) {
            aE(this);
        } else {
            aH(this);
        }
        LogUtils.f(-911019739, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1595354728);
        super.mi_();
        this.bE = 0;
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131233663);
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1520038385, a);
    }

    public final void m1289G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1700236035);
        super.G();
        this.aT.b(655408, "NNF_PermalinkNotificationLoad");
        av();
        m1282a(true);
        aI(this);
        this.aQ.i = new C01302(this);
        if (D()) {
            this.aK.g = true;
        }
        this.aO.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1489090043, a);
    }

    public final void m1290H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 178465780);
        super.H();
        aR();
        this.aQ.i = null;
        this.aK.g = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1508547377, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1575157235);
        super.mj_();
        this.aQ.a(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1516429494, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 501620283);
        super.mY_();
        this.aw.b(this.bm);
        this.aw.b(this.bn);
        this.aw.b(this.bo);
        if (!(StringUtil.a((CharSequence) this.ba.get()) || this.bp == null)) {
            this.at.b(GrowthPrefKeys.a((String) this.ba.get()), this.bp);
        }
        if (!(this.aC == null || this.bq == null)) {
            this.aC.b(this.bq);
        }
        if (this.bg != null) {
            this.bg.c();
        }
        aK();
        this.aG.f946g.f1022c.b();
        if (m1299n() != null) {
            m1299n().c(this.bh);
            m1299n().c(this.aY);
            m1299n().x();
        }
        if (ar(this) != null) {
            ar(this).e = null;
        }
        if (this.bj != null) {
            this.bj.clearAnimation();
            if (this.bt != null) {
                this.bt.cancel();
            }
            if (this.bu != null) {
                this.bu.cancel();
            }
        }
        this.bl = null;
        this.aT.b(9502729, "NotifListLoadTimeCold");
        this.aT.b(9502730, "NotifListLoadTimeWarm");
        this.aW.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -594931345, a);
    }

    public final void m1291I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1479704198);
        super.I();
        if (this.bd != null) {
            this.bd.c();
        }
        if (this.be != null) {
            this.be.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1934493268, a);
    }

    public final Loader<List<NotificationsEdgeFields>> n_(int i) {
        ViewerContext d = this.aX.d();
        if (d != null && i == 100) {
            return new NotificationsLoader(getContext(), this.ay, getContext().getContentResolver(), this.az.b, d, this.aM.a.a(ExperimentsForNotificationsFriendingAbTestModule.e, 10), false, this.aI);
        }
        BLog.b(bb, "Unexpected onCreateLoader: %d", new Object[]{Integer.valueOf(i)});
        return null;
    }

    public final void gA_() {
        if (ar(this) != null) {
            ar(this).setRefreshing(false);
        }
        this.aG.m1244b(null, false);
        m1282a(false);
    }

    public final void m1298g(boolean z) {
        boolean D = D();
        super.g(z);
        if (mx_() && D != z) {
            au();
            if (D()) {
                av();
                this.bA = this.aC.a(Jewel.NOTIFICATIONS);
                if (this.bA > 0 && m1299n() != null) {
                    m1299n().w();
                }
            } else {
                aR();
            }
        } else if (this.aQ != null) {
            this.aQ.a(null);
        }
        aI(this);
        this.bD = z;
        if (this.aK != null) {
            this.aK.g = z;
        }
        if (this.bi != null) {
            this.bi.b();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ScrollingViewUtils.a(m1299n());
        if (this.bl != null) {
            this.bl.a();
        }
    }

    @Nullable
    public final ScrollingViewProxy m1299n() {
        return (this.bl == null || this.bl.getScrollingViewProxy() == null) ? null : this.bl.getScrollingViewProxy();
    }

    public final void m1295a(View view, int i) {
        if (view != this.bk && !this.L && this.bl != null) {
            Object item = this.aG.getItem(i);
            if (item instanceof FriendListUserCommonModel) {
                Serializable serializable = item instanceof PersonYouMayKnow ? FriendRequestMakeRef.PYMK_JEWEL : FriendRequestMakeRef.JEWEL;
                FriendListUserCommonModel friendListUserCommonModel = (FriendListUserCommonModel) item;
                Bundle bundle = new Bundle();
                bundle.putSerializable("timeline_friend_request_ref", serializable);
                ModelBundle.a(bundle, String.valueOf(friendListUserCommonModel.a()), friendListUserCommonModel.d(), friendListUserCommonModel.b(), null, null);
                this.as.a(getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(friendListUserCommonModel.a())), bundle);
            } else if (view != this.bk && !this.L && this.bl != null && !(view instanceof PostFeedbackView)) {
                if (!(view instanceof SwitchableNotificationView) || ((SwitchableNotificationView) view).f == SwitchableNotificationView.State.NOTIFICATION) {
                    this.aA.a(getClass().getSimpleName());
                    this.aT.d(655408, "NNF_PermalinkNotificationLoad");
                    item = m1299n().g(i);
                    if (item instanceof NotificationsEdgeFields) {
                        NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) item;
                        GraphQLStory k = notificationsEdgeFields.k();
                        GraphQLStory c = this.ay.c(k.g());
                        final int g = this.aG.m1251g(m1287f(i));
                        if (g != -1) {
                            final String name = notificationsEdgeFields.c().name();
                            if (c == null) {
                                this.al.a(this.aK.a(k.c(), k.g()), new FutureCallback<GraphQLStory>(this) {
                                    final /* synthetic */ NotificationsFriendingFragment f971c;

                                    public void onSuccess(Object obj) {
                                        GraphQLStory graphQLStory = (GraphQLStory) obj;
                                        NotificationsFriendingFragment.m1279a(this.f971c, graphQLStory == null ? null : FeedProps.c(graphQLStory), g, name);
                                    }

                                    public void onFailure(Throwable th) {
                                        this.f971c.aT.f(655408, "NNF_PermalinkNotificationLoad");
                                        this.f971c.aA.a();
                                    }
                                });
                            } else {
                                m1279a(this, FeedProps.c(c), g, name);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void gB_() {
        if (m1299n() != null) {
            m1299n().e(0);
        }
    }

    public final boolean gC_() {
        return m1299n() != null && m1299n().q() == 0;
    }

    public Map<String, String> getDebugInfo() {
        if (!this.bz) {
            return RegularImmutableBiMap.a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int g = this.aG.f944e.mo21g();
        stringBuilder.append("\nLoaded Notifications: ").append(g);
        stringBuilder.append("\nLast Load Time: ").append(this.bB);
        if (this.bH >= 0 && this.bx >= 0) {
            stringBuilder.append("\nVisible Notification Ids: [\n");
            int i = this.bx + this.bH;
            if (i > g) {
                i = g;
            }
            for (int i2 = this.bx; i2 < i; i2++) {
                Object item = this.aG.getItem(i2);
                if (item instanceof NotificationsEdgeFields) {
                    NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) item;
                    if (notificationsEdgeFields == null || notificationsEdgeFields.k() == null) {
                        stringBuilder.append("null");
                    } else {
                        stringBuilder.append(notificationsEdgeFields.k().g());
                    }
                    stringBuilder.append("\n");
                }
            }
            stringBuilder.append("]\n");
        }
        if (this.aI != null) {
            stringBuilder.append("Last Updated Time: ").append(this.aI.a()).append("\n");
        }
        return ImmutableBiMap.b("NotificationsFriendingFragment", stringBuilder.toString());
    }

    public final boolean gD_() {
        if (this.bD && this.bC) {
            this.aT.c(9502729, "NotifListLoadTimeCold");
            this.aT.c(9502730, "NotifListLoadTimeWarm");
            this.aT.a(TabTag.NotificationsFriending.loadTabTabPerfMarkerId, TabTag.NotificationsFriending.loadTabTabPerfMarkerName, "load_type", "hot", false);
            this.aT.c(TabTag.NotificationsFriending.loadTabTabPerfMarkerId, TabTag.NotificationsFriending.loadTabTabPerfMarkerName);
            this.aT.a(TabTag.NotificationsFriending.loadTabTabPerfMarkerIdNoAnim, TabTag.NotificationsFriending.loadTabTabPerfMarkerNameNoAnim, "load_type", "hot", false);
            this.aT.c(TabTag.NotificationsFriending.loadTabTabPerfMarkerIdNoAnim, TabTag.NotificationsFriending.loadTabTabPerfMarkerNameNoAnim);
            this.bD = false;
        }
        return false;
    }

    public final String am_() {
        return TabTag.NotificationsFriending.analyticsTag;
    }

    public final Map<String, Object> m1296c() {
        return ImmutableMap.of("notifications_count", Integer.valueOf(this.aC.a(Jewel.NOTIFICATIONS)), "friend_requests_count", Integer.valueOf(this.aC.a(Jewel.FRIEND_REQUESTS)));
    }

    private void ao() {
        ViewGroup viewGroup = (ViewGroup) this.bl.findViewById(2131564289);
        this.bj = (TextView) LayoutInflater.from(getContext()).inflate(2130905441, viewGroup, false);
        viewGroup.addView(this.bj);
        this.bt = AnimationUtils.loadAnimation(getContext(), 2130968607);
        this.bu = AnimationUtils.loadAnimation(getContext(), 2130968608);
        this.bt.setAnimationListener(new C01324(this));
        this.bu.setAnimationListener(new C01335(this));
        this.bj.setOnClickListener(new C01346(this));
    }

    private void ap() {
        if (ar(this) != null) {
            ar(this).e = new C01357(this);
        }
    }

    private void aq() {
        if (m1299n() != null) {
            m1299n().a(new C01368(this));
        }
    }

    @Nullable
    public static FbSwipeRefreshLayout ar(NotificationsFriendingFragment notificationsFriendingFragment) {
        return (notificationsFriendingFragment.bl == null || notificationsFriendingFragment.bl.getSwipeRefreshLayout() == null) ? null : notificationsFriendingFragment.bl.getSwipeRefreshLayout();
    }

    private void as() {
        this.bG = 0;
        ScrollingViewProxy n = m1299n();
        ListScrollStateSnapshot listScrollStateSnapshot = new ListScrollStateSnapshot();
        if (n != null) {
            n.a(listScrollStateSnapshot);
        }
        this.aG.m1244b(this.br, aL(this));
        if (!this.aW.a()) {
            aP(this);
        }
        if (n != null) {
            n.b(listScrollStateSnapshot);
        }
        if (ar(this) != null) {
            ar(this).setRefreshing(false);
        }
        this.aV.b(9502725, (short) 2);
        m1282a(false);
        au();
        this.bB = this.aq.a();
        if (this.av.d()) {
            ay(this);
        }
    }

    private void au() {
        if (D()) {
            this.aK.a(this.aX.d());
        }
    }

    public static void m1280a(NotificationsFriendingFragment notificationsFriendingFragment, SyncSource syncSource) {
        notificationsFriendingFragment.m1286b(syncSource);
        aE(notificationsFriendingFragment);
    }

    private void av() {
        if (this.bv) {
            AdapterDetour.a(this.aG, 1172547255);
            this.bv = false;
        }
    }

    private void m1286b(SyncSource syncSource) {
        if (this.bi != null) {
            this.bi.b();
        }
        if (this.aX.d() != null) {
            if (syncSource == SyncSource.PULL_TO_REFRESH) {
                this.aV.b(9502725);
            }
            this.aQ.a(null);
            this.al.a(this.aJ.a(this.aX.d(), syncSource), new NotificationAsyncRequestCompletionListener(this, Long.valueOf(Long.parseLong(this.aX.d().mUserId))) {
                final /* synthetic */ NotificationsFriendingFragment f977a;

                public /* synthetic */ void onSuccess(Object obj) {
                    m1272a((OperationResult) obj);
                }

                public final void m1272a(OperationResult operationResult) {
                    super.a(operationResult);
                    if (operationResult.b) {
                        NotificationsFriendingFragment.m1278a(this.f977a, operationResult);
                        return;
                    }
                    NotificationsFriendingFragment.m1283b(this.f977a, operationResult);
                    NotificationsFriendingFragment.aw(this.f977a);
                }

                public void onFailure(Throwable th) {
                    super.onFailure(th);
                    NotificationsFriendingFragment.aw(this.f977a);
                }
            });
            m1282a(true);
        }
    }

    public static void m1278a(NotificationsFriendingFragment notificationsFriendingFragment, OperationResult operationResult) {
        FetchGraphQLNotificationsResult fetchGraphQLNotificationsResult = (FetchGraphQLNotificationsResult) operationResult.k();
        if (fetchGraphQLNotificationsResult != null && fetchGraphQLNotificationsResult.a != null && fetchGraphQLNotificationsResult.a.deltaStories == null && fetchGraphQLNotificationsResult.a.newStories == null) {
            NotificationsAdapterSection notificationsAdapterSection = notificationsFriendingFragment.aG.f944e;
            notificationsAdapterSection.f1016m = Optional.of(LoadResult.SUCCESS);
            notificationsAdapterSection.f1012i.mo13e();
            notificationsFriendingFragment.m1282a(false);
        }
        notificationsFriendingFragment.ax();
    }

    public static void aw(NotificationsFriendingFragment notificationsFriendingFragment) {
        NotificationsAdapterSection notificationsAdapterSection = notificationsFriendingFragment.aG.f944e;
        notificationsAdapterSection.f1016m = Optional.of(LoadResult.FAILURE);
        notificationsAdapterSection.f1012i.mo13e();
        notificationsFriendingFragment.m1282a(false);
        notificationsFriendingFragment.ax();
        notificationsFriendingFragment.aV.b(9502725, (short) 3);
    }

    public static void m1283b(NotificationsFriendingFragment notificationsFriendingFragment, OperationResult operationResult) {
        String a = notificationsFriendingFragment.m1275a(notificationsFriendingFragment.getContext().getString(2131230811), operationResult.e.ordinal(), operationResult.f);
        BLog.b(bb, a);
        notificationsFriendingFragment.ar.a(bb.getSimpleName() + "_sync_failed", a);
    }

    private String m1275a(String str, int i, String str2) {
        if (i == 0) {
            return str;
        }
        return getContext().getString(2131233664, new Object[]{str, Integer.valueOf(i), str2});
    }

    private void ax() {
        if (this.bl != null) {
            if (this.bl.getSwipeRefreshLayout() != null) {
                this.bl.getSwipeRefreshLayout().setRefreshing(false);
            }
            if (this.bl.getRefreshableContainerLike() != null) {
                this.bl.getRefreshableContainerLike().f();
            }
        }
    }

    private void m1282a(boolean z) {
        boolean z2 = false;
        ViewerContext d = this.aX.d();
        if (mx_() && this.bl != null && d != null) {
            boolean z3 = z && E() != null && E().a();
            if (z3 || this.aJ.a(Long.parseLong(d.mUserId))) {
                z2 = true;
            }
            this.by = z2;
            this.bl.b(z2);
        }
    }

    public static void ay(NotificationsFriendingFragment notificationsFriendingFragment) {
        ScrollingViewProxy scrollingViewProxy = notificationsFriendingFragment.bl.getScrollingViewProxy();
        if (notificationsFriendingFragment.bj != null && scrollingViewProxy != null) {
            int a = notificationsFriendingFragment.aC.a(Jewel.FRIEND_REQUESTS);
            if (a == 0 || !notificationsFriendingFragment.bJ || !notificationsFriendingFragment.aG.m1258n()) {
                az(notificationsFriendingFragment);
            } else if (notificationsFriendingFragment.aG.m1252h() + scrollingViewProxy.u() > scrollingViewProxy.r()) {
                notificationsFriendingFragment.bj.setText(notificationsFriendingFragment.jW_().getQuantityString(2131689804, a, new Object[]{Integer.valueOf(a)}));
                if (notificationsFriendingFragment.bj.getVisibility() != 0) {
                    notificationsFriendingFragment.bj.startAnimation(notificationsFriendingFragment.bt);
                }
            }
        }
    }

    public static void az(NotificationsFriendingFragment notificationsFriendingFragment) {
        if (notificationsFriendingFragment.bj != null && notificationsFriendingFragment.bj.getVisibility() == 0) {
            if (!notificationsFriendingFragment.bu.hasStarted() || notificationsFriendingFragment.bu.hasEnded()) {
                notificationsFriendingFragment.bj.startAnimation(notificationsFriendingFragment.bu);
            }
        }
    }

    public static void m1279a(NotificationsFriendingFragment notificationsFriendingFragment, FeedProps feedProps, int i, String str) {
        if (feedProps == null) {
            notificationsFriendingFragment.aT.f(655408, "NNF_PermalinkNotificationLoad");
            notificationsFriendingFragment.aA.a();
            notificationsFriendingFragment.ar.a(bb.getSimpleName() + "_null_notif_story", "Null notif story in adapter");
            return;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        notificationsFriendingFragment.at.edit().a(NotificationsPreferenceConstants.c, graphQLStory.g()).commit();
        notificationsFriendingFragment.aE.a("tap_notification_jewel");
        boolean z = !GraphQLStorySeenState.SEEN_AND_READ.equals(graphQLStory.au());
        NotificationLogObject notificationLogObject = new NotificationLogObject();
        notificationLogObject.i = graphQLStory.k();
        notificationLogObject = notificationLogObject;
        notificationLogObject.j = true;
        notificationLogObject = notificationLogObject.a(graphQLStory.au());
        notificationLogObject.k = z;
        notificationLogObject = notificationLogObject;
        notificationLogObject.v = i;
        notificationLogObject = notificationLogObject;
        notificationLogObject.w = false;
        notificationLogObject = notificationLogObject;
        notificationLogObject.x = HighlightType.DEFAULT.name();
        notificationLogObject = notificationLogObject;
        notificationLogObject.y = str;
        notificationLogObject = notificationLogObject;
        notificationLogObject.z = 0;
        notificationsFriendingFragment.aR.a(notificationLogObject);
        if (z) {
            notificationsFriendingFragment.bv = true;
            notificationsFriendingFragment.aK.a(ImmutableList.of(graphQLStory.c()), GraphQLStorySeenState.SEEN_AND_READ, notificationsFriendingFragment.aX.d());
            notificationsFriendingFragment.aG.f944e.m1353c(i);
            notificationsFriendingFragment.aN.a(new NotificationsClickedEvent(graphQLStory.g()));
            if (i < 30) {
                notificationsFriendingFragment.ay.b(graphQLStory.g(), GraphQLStorySeenState.SEEN_AND_READ);
            } else {
                notificationsFriendingFragment.ay.a(graphQLStory.g(), GraphQLStorySeenState.SEEN_AND_READ);
            }
        }
        notificationsFriendingFragment.m1277a(feedProps);
    }

    private void m1277a(FeedProps<GraphQLStory> feedProps) {
        Context context = getContext();
        if (context != null) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            String a = NotificationStoryHelper.a(graphQLStory);
            if (!(a != null ? this.as.a(context, a) : this.aD.a(context, feedProps))) {
                this.aT.f(655408, "NNF_PermalinkNotificationLoad");
                this.aA.a();
                this.ar.a(bb.getSimpleName() + "_launch_failed", "Could not launch notification story " + graphQLStory.c());
            }
        }
    }

    private int m1287f(int i) {
        ScrollingViewProxy n = m1299n();
        return n == null ? i : i - n.u();
    }

    public static void aE(NotificationsFriendingFragment notificationsFriendingFragment) {
        notificationsFriendingFragment.bf.c(new FutureCallback(notificationsFriendingFragment) {
            final /* synthetic */ NotificationsFriendingFragment f952a;

            {
                this.f952a = r1;
            }

            public void onSuccess(@Nullable Object obj) {
                NotificationsFriendingFragment.aH(this.f952a);
            }

            public void onFailure(Throwable th) {
            }
        });
    }

    public static void aH(NotificationsFriendingFragment notificationsFriendingFragment) {
        notificationsFriendingFragment.aW.c();
        notificationsFriendingFragment.av.h();
        m1285b(notificationsFriendingFragment, true);
    }

    public static void m1285b(NotificationsFriendingFragment notificationsFriendingFragment, boolean z) {
        Object obj = 1;
        if (!notificationsFriendingFragment.aW.a()) {
            Object obj2;
            boolean o = notificationsFriendingFragment.aM.o();
            Object obj3;
            if (notificationsFriendingFragment.aG.m1256k() || (o && !notificationsFriendingFragment.aG.f946g.m1382l())) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (!notificationsFriendingFragment.av.e() || notificationsFriendingFragment.aG.m1255j() <= 0) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            Object obj4;
            if (!notificationsFriendingFragment.av.d() || notificationsFriendingFragment.aG.m1257l()) {
                obj4 = null;
            } else {
                obj4 = 1;
            }
            if (!notificationsFriendingFragment.av.c() || notificationsFriendingFragment.aG.f946g.f1027h.equals(LoadingState.FAILURE)) {
                obj = null;
            }
            if (!o && (z || r4 != null)) {
                notificationsFriendingFragment.aJ();
            } else if (z || (r1 != null && r0 == null && obj2 == null)) {
                m1288h(notificationsFriendingFragment, z);
            } else if (obj2 != null) {
                aP(notificationsFriendingFragment);
            }
        }
    }

    public static void aI(NotificationsFriendingFragment notificationsFriendingFragment) {
        if (notificationsFriendingFragment.bl != null && notificationsFriendingFragment.aG != null && notificationsFriendingFragment.aC != null && notificationsFriendingFragment.ao != null && !notificationsFriendingFragment.bI && notificationsFriendingFragment.aG.m1258n() && !notificationsFriendingFragment.ao.j() && notificationsFriendingFragment.D() && notificationsFriendingFragment.aC.a(Jewel.FRIEND_REQUESTS) != 0) {
            ScrollingViewProxy scrollingViewProxy = notificationsFriendingFragment.bl.getScrollingViewProxy();
            if (notificationsFriendingFragment.aG.m1252h() + scrollingViewProxy.u() <= scrollingViewProxy.r()) {
                notificationsFriendingFragment.bI = true;
                notificationsFriendingFragment.al.a(notificationsFriendingFragment.av.a(), new FutureCallback<Void>(notificationsFriendingFragment) {
                    final /* synthetic */ NotificationsFriendingFragment f955a;

                    {
                        this.f955a = r1;
                    }

                    public void onSuccess(@Nullable Object obj) {
                        this.f955a.bI = false;
                        this.f955a.aC.a(Jewel.FRIEND_REQUESTS, 0);
                    }

                    public void onFailure(Throwable th) {
                        this.f955a.bI = false;
                    }
                });
            }
        }
    }

    private void aJ() {
        aO();
        this.aW.a("FETCH_FRIEND_REQUESTS_TASK", new Callable<ListenableFuture<List<FriendRequest>>>(this) {
            final /* synthetic */ NotificationsFriendingFragment f956a;

            {
                this.f956a = r1;
            }

            public Object call() {
                return this.f956a.av.a(Math.min(Math.max(this.f956a.aC.a(Jewel.FRIEND_REQUESTS), 3), 6), NotificationsFriendingFragment.f980i);
            }
        }, new AbstractDisposableFutureCallback<List<FriendRequest>>(this) {
            final /* synthetic */ NotificationsFriendingFragment f957a;

            {
                this.f957a = r1;
            }

            protected final void m1263a(Object obj) {
                boolean z;
                List list = (List) obj;
                NotificationsFriendingFragment.m1284b(this.f957a, list);
                NotificationsFriendingFragment notificationsFriendingFragment = this.f957a;
                if (list.isEmpty() || ((FriendRequest) list.get(0)).h) {
                    z = false;
                } else {
                    z = true;
                }
                notificationsFriendingFragment.bJ = z;
                NotificationsFriendingFragment.ay(this.f957a);
                if (this.f957a.aG.m1256k()) {
                    NotificationsFriendingFragment.aP(this.f957a);
                }
            }

            protected final void m1264a(Throwable th) {
                FriendRequestsAdapterSection friendRequestsAdapterSection = this.f957a.aG.f945f;
                friendRequestsAdapterSection.f1000l = FriendRequestsAdapterSection.LoadingState.FAILURE;
                friendRequestsAdapterSection.f997i.mo13e();
            }
        });
    }

    public static void m1288h(NotificationsFriendingFragment notificationsFriendingFragment, final boolean z) {
        notificationsFriendingFragment.aO();
        notificationsFriendingFragment.aW.a("FETCH_PYMK_TASK", new Callable<ListenableFuture<List<PersonYouMayKnow>>>(notificationsFriendingFragment) {
            final /* synthetic */ NotificationsFriendingFragment f959a;

            {
                this.f959a = r1;
            }

            public Object call() {
                return this.f959a.av.a(10, FriendingLocation.JEWEL.peopleYouMayKnowLocation, NotificationsFriendingFragment.f980i);
            }
        }, new AbstractDisposableFutureCallback<List<PersonYouMayKnow>>(notificationsFriendingFragment) {
            final /* synthetic */ NotificationsFriendingFragment f961b;

            protected final void m1265a(Object obj) {
                List<PersonYouMayKnow> list = (List) obj;
                if (z) {
                    NotificationsFriendingFragment.m1284b(this.f961b, Collections.emptyList());
                }
                PeopleYouMayKnowAdapterSection peopleYouMayKnowAdapterSection = this.f961b.aG.f946g;
                peopleYouMayKnowAdapterSection.f1027h = LoadingState.SUCCESS;
                for (PersonYouMayKnow personYouMayKnow : list) {
                    if (!peopleYouMayKnowAdapterSection.f1026g.contains(Long.valueOf(personYouMayKnow.a()))) {
                        peopleYouMayKnowAdapterSection.f1025f.add(personYouMayKnow);
                        peopleYouMayKnowAdapterSection.f1026g.add(Long.valueOf(personYouMayKnow.a()));
                    }
                }
                peopleYouMayKnowAdapterSection.f1024e.mo13e();
                if (this.f961b.aG.m1256k()) {
                    NotificationsFriendingFragment.aP(this.f961b);
                }
            }

            protected final void m1266a(Throwable th) {
                Object obj;
                NotificationsFriendingFragment notificationsFriendingFragment = this.f961b;
                if (notificationsFriendingFragment.aG.f946g.mo21g() > 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    NotificationsFriendingFragment.aP(notificationsFriendingFragment);
                } else {
                    notificationsFriendingFragment.bk.a(notificationsFriendingFragment.b(2131230811), new RetryClickedListener(notificationsFriendingFragment) {
                        final /* synthetic */ NotificationsFriendingFragment f962a;

                        {
                            this.f962a = r1;
                        }

                        public final void m1267a() {
                            if (this.f962a.av.c()) {
                                NotificationsFriendingFragment.m1288h(this.f962a, false);
                            }
                        }
                    });
                }
                PeopleYouMayKnowAdapterSection peopleYouMayKnowAdapterSection = this.f961b.aG.f946g;
                peopleYouMayKnowAdapterSection.f1027h = LoadingState.FAILURE;
                peopleYouMayKnowAdapterSection.f1024e.mo13e();
            }
        });
    }

    public static void m1284b(NotificationsFriendingFragment notificationsFriendingFragment, List list) {
        notificationsFriendingFragment.aK();
        notificationsFriendingFragment.bK = String.valueOf(notificationsFriendingFragment.aq.a());
        notificationsFriendingFragment.bL = 0;
        notificationsFriendingFragment.bM = 0;
        FriendRequestsAdapterSection friendRequestsAdapterSection = notificationsFriendingFragment.aG.f945f;
        friendRequestsAdapterSection.f1000l = FriendRequestsAdapterSection.LoadingState.LOADING;
        friendRequestsAdapterSection.f998j.clear();
        friendRequestsAdapterSection.f999k.clear();
        friendRequestsAdapterSection.f997i.mo13e();
        friendRequestsAdapterSection = notificationsFriendingFragment.aG.f945f;
        friendRequestsAdapterSection.f1000l = FriendRequestsAdapterSection.LoadingState.SUCCESS;
        for (FriendRequest friendRequest : list) {
            if (!friendRequestsAdapterSection.f999k.contains(Long.valueOf(friendRequest.a()))) {
                friendRequestsAdapterSection.f998j.add(friendRequest);
                friendRequestsAdapterSection.f999k.add(Long.valueOf(friendRequest.a()));
            }
        }
        friendRequestsAdapterSection.f997i.mo13e();
        PeopleYouMayKnowAdapterSection peopleYouMayKnowAdapterSection = notificationsFriendingFragment.aG.f946g;
        peopleYouMayKnowAdapterSection.f1027h = LoadingState.LOADING;
        peopleYouMayKnowAdapterSection.f1025f.clear();
        peopleYouMayKnowAdapterSection.f1026g.clear();
        peopleYouMayKnowAdapterSection.f1024e.mo13e();
    }

    private void aK() {
        Object obj;
        if (this.aG.m1253i() > 0 || this.aG.f945f.m1338n()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(obj == null || this.aM.o())) {
            this.aH.m1389a(this.aG.m1253i(), this.bL);
        }
        if (this.aG.f946g.f1027h.equals(LoadingState.SUCCESS) || this.aG.m1255j() > 0) {
            this.aH.m1391b(this.aG.m1255j(), this.bM);
        }
    }

    public static boolean aL(NotificationsFriendingFragment notificationsFriendingFragment) {
        if (aM(notificationsFriendingFragment)) {
            if ((notificationsFriendingFragment.aC.a(Jewel.FRIEND_REQUESTS) > 0 ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean aM(NotificationsFriendingFragment notificationsFriendingFragment) {
        return !notificationsFriendingFragment.D() && notificationsFriendingFragment.aM.a.a(ExperimentsForNotificationsFriendingAbTestModule.f, false);
    }

    private void aO() {
        if (!this.bk.f()) {
            this.bk.a();
        }
    }

    public static void aP(NotificationsFriendingFragment notificationsFriendingFragment) {
        notificationsFriendingFragment.bk.b();
    }

    private void aR() {
        if (this.bE != 0 && this.bF) {
            boolean z = this.bE > this.bH;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("notification_scroll_depth_v2");
            honeyClientEvent.c = "notifications_friending";
            this.am.a(honeyClientEvent.a("scroll_depth", this.bE).a("jewel_count", this.bA).a("visible_item_count", this.bH).a("passed_scroll_threshold", z));
            this.bF = false;
        }
    }

    public static void aS(NotificationsFriendingFragment notificationsFriendingFragment) {
        ConnectionRetrySnackbarView connectionRetrySnackbarView = new ConnectionRetrySnackbarView(notificationsFriendingFragment.getContext());
        connectionRetrySnackbarView.setRetryClickListener(new OnClickListener(notificationsFriendingFragment) {
            final /* synthetic */ NotificationsFriendingFragment f963a;

            {
                this.f963a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 111784182);
                this.f963a.bi.b();
                if (this.f963a.aF.a()) {
                    NotificationsFriendingFragment.m1280a(this.f963a, SyncSource.PULL_TO_REFRESH);
                } else {
                    NotificationsFriendingFragment.ar(this.f963a).setRefreshing(false);
                    NotificationsFriendingFragment.aS(this.f963a);
                }
                LogUtils.a(-696873843, a);
            }
        });
        notificationsFriendingFragment.bi = notificationsFriendingFragment.ap.a(connectionRetrySnackbarView, 10000);
        if (ar(notificationsFriendingFragment) != null) {
            notificationsFriendingFragment.bi.i = ar(notificationsFriendingFragment);
        }
        notificationsFriendingFragment.bi.a();
    }
}
