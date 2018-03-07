package com.facebook.notifications.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager$LoaderCallbacks;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.apptab.state.TabTag;
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
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateProxyScrollListener;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.fig.sectionheader.FigSectionHeader;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.notifications.GraphQLNotificationsContract;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.action.NotificationsInlineNotificationNuxManager;
import com.facebook.notifications.cache.BaseListenableCache.OnChangeListener;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.event.NotificationsEventBus;
import com.facebook.notifications.event.NotificationsEvents$NotificationsSubscriptionUpdatedEvent;
import com.facebook.notifications.event.NotificationsEvents$NotificationsSubscriptionUpdatedSubscriber;
import com.facebook.notifications.event.NotificationsEvents.NotificationsClickedEvent;
import com.facebook.notifications.loader.NotificationsLoader;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.nux.InlineFeedbackLongTapNuxPopover;
import com.facebook.notifications.nux.NotificationsInlineFeedbackNuxInterstitialController;
import com.facebook.notifications.nux.NotificationsInlineFeedbackNuxInterstitialController.1;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncHelper.NotificationAsyncRequestCompletionListener;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.notifications.util.DefaultNotificationStoryLauncher;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.notifications.util.NotificationStoryLauncher;
import com.facebook.notifications.util.NotificationsFetchCountHelper;
import com.facebook.notifications.util.NotificationsFragmentTouchUtil;
import com.facebook.notifications.util.NotificationsHighlightHelper;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.facebook.notifications.util.NotificationsLikeCountHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsSeeMoreHelper;
import com.facebook.notifications.util.NotificationsSeeMoreHelper.SeeMoreButtonType;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.notifications.widget.NotificationsAdapter.C06091;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListScrollStateSnapshot;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy$OnItemLongClickListener;
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
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra */
public class NotificationsFragment extends FbListFragment implements LoaderManager$LoaderCallbacks<List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields>>, AnalyticsFragmentWithExtraData, FragmentWithDebugInfo, OnChangeListener, OnDrawListener, ScrollableListContainer, ScrollingViewProxyContainer {
    public static final CallerContext al = CallerContext.a(NotificationsFragment.class, "notifications");
    private static final InterstitialTrigger ba = new InterstitialTrigger(Action.NOTIFICATIONS_TAB_FULLY_SHOWN);
    public static final Class<?> f12543i = NotificationsFragment.class;
    @Inject
    QuickPerformanceLogger aA;
    @Inject
    AnalyticsTagger aB;
    @Inject
    ViewerContextManager aC;
    @Inject
    NotificationsEventBus aD;
    @Inject
    public DefaultNotificationStoryLauncher aE;
    @Inject
    NotificationsFetchCountHelper aF;
    @Inject
    NetworkMonitor aG;
    @Inject
    NotificationStoryHelper aH;
    @Inject
    GraphQLNotificationsContentProviderHelper aI;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager aJ;
    @Inject
    public FbUriIntentHandler aK;
    @Inject
    NotificationsSyncManager aL;
    @Inject
    JewelCounters aM;
    @Inject
    public InteractionTTILogger aN;
    @Inject
    ClickableToastBuilder aO;
    @Inject
    NotificationsInlineActionsHelper aP;
    @Inject
    NotificationsRowWithActionHelper aQ;
    @Inject
    InterstitialManager aR;
    @Inject
    NotificationsHighlightHelper aS;
    @Inject
    NotificationsSeeMoreHelper aT;
    @Inject
    NotificationsLikeCountHelper aU;
    @Inject
    NotificationsActionExecutor aV;
    @Inject
    NotificationsFunnelLogger aW;
    @Inject
    public NotificationsJewelExperimentController aX;
    @Inject
    TodayExperimentController aY;
    @Inject
    RapidFeedbackController aZ;
    @Inject
    Lazy<NotificationsAdapter> am;
    @Inject
    NotificationsLastUpdatedUtil an;
    @Inject
    GraphQLNotificationsContract ao;
    @Inject
    public AbstractFbErrorReporter ap;
    @Inject
    FbSharedPreferences aq;
    @Inject
    Clock ar;
    @Inject
    FrameRateLoggerProvider as;
    @Inject
    NotificationsUtils at;
    @Inject
    NotificationsFragmentTouchUtil au;
    @Inject
    DefaultAndroidThreadUtil av;
    @Inject
    public AnalyticsLogger aw;
    @Inject
    NavigationLogger ax;
    @Inject
    NotificationsLogger ay;
    @Inject
    public PerformanceLogger az;
    private boolean bA = false;
    private boolean bB = true;
    private boolean bC = false;
    private boolean bD = false;
    public boolean bE = false;
    public List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> bF = new ArrayList();
    private boolean bG;
    private boolean bH;
    private Optional<Long> bI = Absent.INSTANCE;
    public Optional<Long> bJ = Absent.INSTANCE;
    public Optional<Long> bK = Absent.INSTANCE;
    public SelfRegistrableReceiverImpl bL;
    private int bM = 0;
    public NotificationsAdapter bb;
    public String bc;
    public NotificationsView bd;
    private long be = 0;
    private boolean bf;
    public Context bg;
    private NotificationsEventListener bh;
    public LoadingIndicatorView bi;
    public FrameLayout bj;
    private boolean bk;
    public boolean bl;
    public int bm = -1;
    public final Map<String, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> bn = new HashMap();
    private boolean bo;
    public ClickableToast bp;
    private final NotificationsEvents$NotificationsSubscriptionUpdatedSubscriber bq = new C05951(this);
    public boolean br;
    private FrameRateLogger bs;
    private NotificationsFragmentOnScrollListener bt;
    private SelfRegistrableReceiverImpl bu;
    public int bv = -1;
    public int bw = -1;
    public int bx = 0;
    private int by = 0;
    public boolean bz = false;

    /* compiled from: extra */
    class C05951 extends NotificationsEvents$NotificationsSubscriptionUpdatedSubscriber {
        final /* synthetic */ NotificationsFragment f12555a;

        C05951(NotificationsFragment notificationsFragment) {
            this.f12555a = notificationsFragment;
        }

        public final void m13325b(FbEvent fbEvent) {
            NotificationsEvents$NotificationsSubscriptionUpdatedEvent notificationsEvents$NotificationsSubscriptionUpdatedEvent = (NotificationsEvents$NotificationsSubscriptionUpdatedEvent) fbEvent;
            if (this.f12555a.bb != null) {
                int i = 0;
                while (i < this.f12555a.bb.getCount()) {
                    if (this.f12555a.bb.m13469d(i) == null || this.f12555a.bb.m13469d(i).mo822k() == null || Strings.isNullOrEmpty(this.f12555a.bb.m13469d(i).mo822k().c()) || !this.f12555a.bb.m13469d(i).mo822k().c().equals(notificationsEvents$NotificationsSubscriptionUpdatedEvent.f12779a.c())) {
                        i++;
                    } else {
                        this.f12555a.bb.m13463a(i, notificationsEvents$NotificationsSubscriptionUpdatedEvent.f12780b);
                        NotificationsFragment notificationsFragment = this.f12555a;
                        CharSequence spannableString = new SpannableString(notificationsEvents$NotificationsSubscriptionUpdatedEvent.f12782d);
                        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.b(notificationsFragment.bg, 2131361920)), 0, notificationsEvents$NotificationsSubscriptionUpdatedEvent.f12782d.length(), 17);
                        Snackbar a = Snackbar.a((View) notificationsFragment.bd, spannableString, notificationsFragment.aX.f7750a.a(ExperimentsForNotificationsAbtestModule.f7777p, 5) * 1000);
                        if (!Strings.isNullOrEmpty(notificationsEvents$NotificationsSubscriptionUpdatedEvent.f12781c)) {
                            a.a(ContextCompat.b(notificationsFragment.bg, 2131361917)).a(2131233689, new 14(notificationsFragment, i, notificationsEvents$NotificationsSubscriptionUpdatedEvent));
                        }
                        a.d.setBackgroundResource(2131361953);
                        a.b();
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: extra */
    public interface NotificationsEventListener {
    }

    /* compiled from: extra */
    class C06006 implements OnRefreshListener {
        final /* synthetic */ NotificationsFragment f12749a;

        C06006(NotificationsFragment notificationsFragment) {
            this.f12749a = notificationsFragment;
        }

        public final void m13627a() {
            if (this.f12749a.aG.a()) {
                this.f12749a.m13306a(SyncSource.PULL_TO_REFRESH);
                return;
            }
            NotificationsFragment.aq(this.f12749a);
            NotificationsFragment.aI(this.f12749a);
        }
    }

    /* compiled from: extra */
    class NotificationsFragmentOnScrollListener implements OnScrollListener {
        final /* synthetic */ NotificationsFragment f12750a;
        private int f12751b = 0;

        public NotificationsFragmentOnScrollListener(NotificationsFragment notificationsFragment) {
            this.f12750a = notificationsFragment;
        }

        public final void m13628a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f12750a.au.m13331a(scrollingViewProxy, i);
            if (!(this.f12750a.bj == null || this.f12750a.bj.getVisibility() != 0 || i == 0)) {
                this.f12750a.bj.setVisibility(8);
                this.f12750a.bl = true;
            }
            this.f12751b = i;
        }

        public final void m13629a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            int max;
            this.f12750a.bv = i;
            this.f12750a.bw = i2;
            NotificationsFragment notificationsFragment = this.f12750a;
            if (i + i2 == i3) {
                max = Math.max((i + i2) - 1, this.f12750a.bx);
            } else {
                max = Math.max(i + i2, this.f12750a.bx);
            }
            notificationsFragment.bx = max;
            if (this.f12751b != 0) {
                this.f12750a.bE = true;
            }
            if (i3 > 0 && i + i2 >= i3 && !this.f12750a.br && this.f12750a.bb.m13471e() <= this.f12750a.bb.f12649i && !this.f12750a.bz) {
                NotificationsFragment.aG(this.f12750a);
            }
        }
    }

    /* compiled from: extra */
    class C06019 implements ScrollingViewProxy$OnItemLongClickListener {
        final /* synthetic */ NotificationsFragment f12755a;

        C06019(NotificationsFragment notificationsFragment) {
            this.f12755a = notificationsFragment;
        }

        public final boolean mo926a(View view, int i) {
            if (!(this.f12755a.m13312n() == null || (view instanceof BetterTextView))) {
                FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.f12755a.m13312n().g(i);
                if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null || fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k() == null) {
                    this.f12755a.ap.a(NotificationsFragment.f12543i + "_long_click", "Null story edge in long click");
                } else {
                    this.f12755a.aP.m13394a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, this.f12755a.bg, view, this.f12755a.aQ.m13441a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().g(), fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().c()), i);
                }
            }
            return true;
        }
    }

    /* compiled from: extra */
    public class C06034 implements OnClickListener {
        final /* synthetic */ NotificationsFragment f12759a;

        public C06034(NotificationsFragment notificationsFragment) {
            this.f12759a = notificationsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 755533018);
            this.f12759a.m13306a(SyncSource.PULL_TO_REFRESH);
            Logger.a(2, EntryType.UI_INPUT_END, -1522817990, a);
        }
    }

    /* compiled from: extra */
    public class C06045 implements RetryClickedListener {
        final /* synthetic */ NotificationsFragment f12760a;

        public C06045(NotificationsFragment notificationsFragment) {
            this.f12760a = notificationsFragment;
        }

        public final void m13635a() {
            this.f12760a.m13306a(SyncSource.PULL_TO_REFRESH);
        }
    }

    /* compiled from: extra */
    class C06082 implements Runnable {
        final /* synthetic */ NotificationsFragment f12778a;

        C06082(NotificationsFragment notificationsFragment) {
            this.f12778a = notificationsFragment;
        }

        public void run() {
            if (this.f12778a.bb != null) {
                AdapterDetour.a(this.f12778a.bb, 493647927);
            }
        }
    }

    public static void m13292a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NotificationsFragment) obj).m13289a(IdBasedLazy.a(injectorLike, 2844), NotificationsLastUpdatedUtil.m7922a(injectorLike), GraphQLNotificationsContract.m7920a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), NotificationsUtils.m7841a(injectorLike), NotificationsFragmentTouchUtil.m13327a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NavigationLogger.a(injectorLike), NotificationsLogger.m12207a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), AnalyticsTagger.a(injectorLike), ViewerContextManagerProvider.a(injectorLike), NotificationsEventBus.m13334a(injectorLike), DefaultNotificationStoryLauncher.m13335a(injectorLike), NotificationsFetchCountHelper.m13369a(injectorLike), NetworkMonitor.a(injectorLike), NotificationStoryHelper.m13347a(injectorLike), GraphQLNotificationsContentProviderHelper.m7861a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FbUriIntentHandler.a(injectorLike), NotificationsSyncManager.m7821a(injectorLike), JewelCounters.a(injectorLike), InteractionTTILogger.a(injectorLike), ClickableToastBuilder.m13372a(injectorLike), NotificationsInlineActionsHelper.m13381a(injectorLike), NotificationsRowWithActionHelper.m13438a(injectorLike), InterstitialManager.a(injectorLike), NotificationsHighlightHelper.m13445a(injectorLike), NotificationsSeeMoreHelper.m13450a(injectorLike), NotificationsLikeCountHelper.m7851a(injectorLike), NotificationsActionExecutor.m13401a(injectorLike), NotificationsFunnelLogger.a(injectorLike), NotificationsJewelExperimentController.m8057a(injectorLike), TodayExperimentController.a(injectorLike), RapidFeedbackController.a(injectorLike));
    }

    public final void mo908a(Loader loader, Object obj) {
        obj = (List) obj;
        this.bC = true;
        if ((obj == null || obj.isEmpty()) && this.bB) {
            this.bB = false;
            m13306a(SyncSource.FRAGMENT_LOADED);
            return;
        }
        if (obj == null) {
            obj = new ArrayList();
        }
        this.bF = obj;
        int i = 0;
        for (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields k : this.bF) {
            int i2;
            if (k.mo822k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 0) {
            this.bl = false;
            this.aP.m13393a();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("notification_auto_update_list_update");
            honeyClientEvent.c = "notifications";
            this.aw.c(honeyClientEvent.b("reason", "new_notifications_notif_fragment"));
        }
        ao(this);
    }

    private void m13289a(Lazy<NotificationsAdapter> lazy, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil, GraphQLNotificationsContract graphQLNotificationsContract, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, Clock clock, FrameRateLoggerProvider frameRateLoggerProvider, NotificationsUtils notificationsUtils, NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, AndroidThreadUtil androidThreadUtil, AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, NotificationsLogger notificationsLogger, PerformanceLogger performanceLogger, QuickPerformanceLogger quickPerformanceLogger, AnalyticsTagger analyticsTagger, ViewerContextManager viewerContextManager, NotificationsEventBus notificationsEventBus, NotificationStoryLauncher notificationStoryLauncher, NotificationsFetchCountHelper notificationsFetchCountHelper, NetworkMonitor networkMonitor, NotificationStoryHelper notificationStoryHelper, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, FbBroadcastManager fbBroadcastManager, FbUriIntentHandler fbUriIntentHandler, NotificationsSyncManager notificationsSyncManager, JewelCounters jewelCounters, InteractionTTILogger interactionTTILogger, ClickableToastBuilder clickableToastBuilder, NotificationsInlineActionsHelper notificationsInlineActionsHelper, NotificationsRowWithActionHelper notificationsRowWithActionHelper, InterstitialManager interstitialManager, NotificationsHighlightHelper notificationsHighlightHelper, NotificationsSeeMoreHelper notificationsSeeMoreHelper, NotificationsLikeCountHelper notificationsLikeCountHelper, NotificationsActionExecutor notificationsActionExecutor, NotificationsFunnelLogger notificationsFunnelLogger, NotificationsJewelExperimentController notificationsJewelExperimentController, TodayExperimentController todayExperimentController, RapidFeedbackController rapidFeedbackController) {
        this.am = lazy;
        this.an = notificationsLastUpdatedUtil;
        this.ao = graphQLNotificationsContract;
        this.ap = fbErrorReporter;
        this.aq = fbSharedPreferences;
        this.ar = clock;
        this.as = frameRateLoggerProvider;
        this.at = notificationsUtils;
        this.au = notificationsFragmentTouchUtil;
        this.av = androidThreadUtil;
        this.aw = analyticsLogger;
        this.ax = navigationLogger;
        this.ay = notificationsLogger;
        this.az = performanceLogger;
        this.aA = quickPerformanceLogger;
        this.aB = analyticsTagger;
        this.aC = viewerContextManager;
        this.aD = notificationsEventBus;
        this.aE = notificationStoryLauncher;
        this.aF = notificationsFetchCountHelper;
        this.aG = networkMonitor;
        this.aH = notificationStoryHelper;
        this.aI = graphQLNotificationsContentProviderHelper;
        this.aJ = fbBroadcastManager;
        this.aK = fbUriIntentHandler;
        this.aL = notificationsSyncManager;
        this.aM = jewelCounters;
        this.aN = interactionTTILogger;
        this.aO = clickableToastBuilder;
        this.aP = notificationsInlineActionsHelper;
        this.aQ = notificationsRowWithActionHelper;
        this.aR = interstitialManager;
        this.aS = notificationsHighlightHelper;
        this.aT = notificationsSeeMoreHelper;
        this.aU = notificationsLikeCountHelper;
        this.aV = notificationsActionExecutor;
        this.aW = notificationsFunnelLogger;
        this.aX = notificationsJewelExperimentController;
        this.aY = todayExperimentController;
        this.aZ = rapidFeedbackController;
    }

    public final void a_(Context context) {
        super.a_(context);
        this.bg = context;
        if (context instanceof NotificationsEventListener) {
            this.bh = (NotificationsEventListener) context;
        }
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1607763147);
        super.dE_();
        this.bh = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -508710685, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1436326913);
        super.mi_();
        this.bx = 0;
        HasTitleBar hasTitleBar = (HasTitleBar) m13314a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(this.bc);
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1663120919, a);
    }

    public static void ao(NotificationsFragment notificationsFragment) {
        int i;
        int j;
        for (i = 0; i < notificationsFragment.bF.size(); i++) {
            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsFragment.bF.get(i);
            if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) {
                notificationsFragment.bn.put(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().c(), fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields);
            }
        }
        notificationsFragment.bm = at(notificationsFragment);
        ListScrollStateSnapshot listScrollStateSnapshot = new ListScrollStateSnapshot();
        boolean z = notificationsFragment.m13312n() != null;
        if (z) {
            notificationsFragment.m13312n().a(listScrollStateSnapshot);
        }
        if (notificationsFragment.aB()) {
            ar(notificationsFragment);
        }
        notificationsFragment.bb.m13464a(notificationsFragment.bF);
        for (i = notificationsFragment.bm + 1; i < notificationsFragment.bF.size(); i++) {
            if (((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsFragment.bF.get(i)).mo821j() > 0) {
                j = ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsFragment.bF.get(i)).mo821j();
                break;
            }
        }
        j = 0;
        notificationsFragment.bM = j;
        if (!(notificationsFragment.bD || notificationsFragment.bF.isEmpty() || !notificationsFragment.aY.I())) {
            notificationsFragment.bD = true;
            notificationsFragment.az();
        }
        AdapterDetour.a(notificationsFragment.bb, -1127232413);
        if (z) {
            notificationsFragment.m13312n().b(listScrollStateSnapshot);
        }
        notificationsFragment.ap();
    }

    private void ap() {
        aq(this);
        this.aA.b(3473413, (short) 2);
        m13294a(false);
        aD();
        this.be = this.ar.a();
    }

    public static void aq(NotificationsFragment notificationsFragment) {
        if (notificationsFragment.bd != null) {
            if (notificationsFragment.aJ() != null) {
                notificationsFragment.aJ().setRefreshing(false);
            }
            if (notificationsFragment.bd.getRefreshableContainerLike() != null) {
                notificationsFragment.bd.getRefreshableContainerLike().f();
            }
        }
    }

    public final void mo910a(Collection collection) {
        this.bb.m13467b(collection);
        AdapterDetour.a(this.bb, 2009457057);
    }

    public static void ar(NotificationsFragment notificationsFragment) {
        int i = 1;
        int i2 = 0;
        int i3 = notificationsFragment.bm >= 0 ? 1 : 0;
        if (notificationsFragment.bF == null || notificationsFragment.bm >= notificationsFragment.bF.size() - 1) {
            i = 0;
        }
        NotificationsAdapter notificationsAdapter = notificationsFragment.bb;
        if (i3 == 0) {
            i2 = -1;
        }
        notificationsAdapter.f12652l = i2;
        if (i != 0) {
            NotificationsAdapter notificationsAdapter2 = notificationsFragment.bb;
            if (i3 != 0) {
                i3 = notificationsFragment.bm + 2;
            } else {
                i3 = notificationsFragment.bm + 1;
            }
            notificationsAdapter2.f12651k = i3;
            return;
        }
        notificationsFragment.bb.f12651k = -1;
    }

    private void as() {
        if (!this.bH && !this.br && this.aP.m13400e()) {
            BetterListView listView = this.bd.getListView();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            View childAt = listView.getChildAt(firstVisiblePosition);
            if (childAt != null) {
                if (childAt.getTop() < 0 || aB()) {
                    firstVisiblePosition++;
                }
                View childAt2 = listView.getChildAt(firstVisiblePosition);
                if (childAt2 != null) {
                    NotificationsInlineFeedbackNuxInterstitialController notificationsInlineFeedbackNuxInterstitialController = (NotificationsInlineFeedbackNuxInterstitialController) this.aR.a(ba, NotificationsInlineFeedbackNuxInterstitialController.class);
                    if (notificationsInlineFeedbackNuxInterstitialController != null) {
                        if (this.aP.m13398c() && (childAt2 instanceof SwitchableNotificationView)) {
                            childAt2 = ((SwitchableNotificationView) childAt2).a.r;
                        }
                        Resources resources = notificationsInlineFeedbackNuxInterstitialController.c.getResources();
                        if (((NotificationsInlineActionsHelper) notificationsInlineFeedbackNuxInterstitialController.d.get()).m13397b()) {
                            if (notificationsInlineFeedbackNuxInterstitialController.a == null) {
                                notificationsInlineFeedbackNuxInterstitialController.a = new InlineFeedbackLongTapNuxPopover(notificationsInlineFeedbackNuxInterstitialController.c);
                                notificationsInlineFeedbackNuxInterstitialController.a.a();
                            }
                            InlineFeedbackLongTapNuxPopover inlineFeedbackLongTapNuxPopover = notificationsInlineFeedbackNuxInterstitialController.a;
                            InlineFeedbackLongTapNuxPopover.b(inlineFeedbackLongTapNuxPopover);
                            inlineFeedbackLongTapNuxPopover.m6297f(childAt2);
                            inlineFeedbackLongTapNuxPopover.n.start();
                            int dimensionPixelSize = resources.getDimensionPixelSize(2131429196);
                            if (notificationsInlineFeedbackNuxInterstitialController.b == null) {
                                notificationsInlineFeedbackNuxInterstitialController.b = new Tooltip(notificationsInlineFeedbackNuxInterstitialController.c, 2);
                            }
                            notificationsInlineFeedbackNuxInterstitialController.b.m6276a(dimensionPixelSize, 0, dimensionPixelSize, 0);
                            notificationsInlineFeedbackNuxInterstitialController.b.m6251a(2131233690);
                            notificationsInlineFeedbackNuxInterstitialController.b.mo540a(Position.BELOW);
                            notificationsInlineFeedbackNuxInterstitialController.b.f5777t = -1;
                            notificationsInlineFeedbackNuxInterstitialController.b.f5789H = new 1(notificationsInlineFeedbackNuxInterstitialController);
                            notificationsInlineFeedbackNuxInterstitialController.b.f5775r = resources.getDimensionPixelSize(2131429197);
                            notificationsInlineFeedbackNuxInterstitialController.b.m6297f(childAt2);
                        } else if (((NotificationsInlineActionsHelper) notificationsInlineFeedbackNuxInterstitialController.d.get()).m13398c()) {
                            if (notificationsInlineFeedbackNuxInterstitialController.b == null) {
                                notificationsInlineFeedbackNuxInterstitialController.b = new Tooltip(notificationsInlineFeedbackNuxInterstitialController.c, 2);
                            }
                            notificationsInlineFeedbackNuxInterstitialController.b.m6251a(2131233691);
                            notificationsInlineFeedbackNuxInterstitialController.b.mo540a(Position.BELOW);
                            notificationsInlineFeedbackNuxInterstitialController.b.f5777t = 5000;
                            notificationsInlineFeedbackNuxInterstitialController.b.f5775r = resources.getDimensionPixelSize(2131429197);
                            notificationsInlineFeedbackNuxInterstitialController.b.m6297f(childAt2);
                        }
                        this.aR.a().a(notificationsInlineFeedbackNuxInterstitialController.b());
                    }
                }
            }
        }
    }

    public static int at(NotificationsFragment notificationsFragment) {
        if (notificationsFragment.bn.isEmpty()) {
            return -1;
        }
        for (int size = notificationsFragment.bF.size() - 1; size >= 0; size--) {
            if (notificationsFragment.bn.containsKey(((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsFragment.bF.get(size)).mo822k().c())) {
                return size;
            }
        }
        return -1;
    }

    public static void av(NotificationsFragment notificationsFragment) {
        if (notificationsFragment.bK.isPresent()) {
            Iterator it = notificationsFragment.bn.entrySet().iterator();
            while (it.hasNext()) {
                if (((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) ((Entry) it.next()).getValue()).mo822k().V() <= ((Long) notificationsFragment.bK.get()).longValue()) {
                    it.remove();
                }
            }
        }
    }

    public final void m13311g(boolean z) {
        boolean D = D();
        super.g(z);
        if (mx_() && D != z) {
            aD();
            if (D()) {
                if (this.bb != null) {
                    aC();
                    this.bb.m13466a(true);
                }
                this.by = this.aM.a(Jewel.NOTIFICATIONS);
                if (this.by > 0 && m13312n() != null) {
                    m13312n().w();
                }
                this.bI = Optional.of(Long.valueOf(this.ar.a()));
            } else {
                aH();
                ax();
                if (this.bI.isPresent()) {
                    this.aZ.a("time_user_entered", String.valueOf(this.bI.get()));
                }
                this.aZ.a("time_user_exit", String.valueOf(this.ar.a()));
                this.aZ.a("1744531889109723", getContext());
            }
        } else if (this.aQ != null) {
            this.aQ.m13442a(null);
        }
        this.bA = z;
        if (this.at != null) {
            this.at.f7564g = z;
        }
        if (this.bp != null) {
            this.bp.b();
        }
    }

    private void ax() {
        if (this.aY.a() && this.aT != null) {
            if (this.bj == null || this.bj.getVisibility() != 0) {
                this.bb.f12651k = 0;
                this.bb.f12652l = -1;
                if (this.aY.I()) {
                    aA();
                    AdapterDetour.a(this.bb, 367663680);
                }
                this.bn.clear();
                this.bm = -1;
                this.bG = true;
            }
        }
    }

    private void az() {
        int g = m13297g(this.bM);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        List arrayList4 = new ArrayList();
        int i = this.bm + 1;
        while (i < this.bF.size() && ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.bF.get(i)).mo821j() == 0) {
            GraphQLStory k = ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.bF.get(i)).mo822k();
            arrayList.add(k.g());
            arrayList2.add(k.c());
            arrayList3.add(Integer.valueOf(i));
            arrayList4.add(k.c() + String.valueOf(k.V()));
            i++;
        }
        m13293a(arrayList, arrayList2, arrayList3, arrayList4, g);
    }

    private void aA() {
        int g = m13297g(this.bM);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        List arrayList4 = new ArrayList();
        for (int i = 0; i <= this.bm; i++) {
            GraphQLStory k = ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.bF.get(i)).mo822k();
            arrayList3.add(Integer.valueOf(i));
            arrayList.add(k.g());
            arrayList2.add(k.c());
            arrayList4.add(k.c() + String.valueOf(k.V()));
        }
        m13293a(arrayList, arrayList2, arrayList3, arrayList4, g);
    }

    public static void m13296f(NotificationsFragment notificationsFragment, int i) {
        if (notificationsFragment.bK.isPresent()) {
            int g = m13297g(notificationsFragment.bM);
            long longValue = ((Long) notificationsFragment.bK.get()).longValue();
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            for (int i2 = 0; i2 <= i; i2++) {
                if (((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsFragment.bF.get(i2)).mo822k().V() <= longValue) {
                    GraphQLStory k = ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsFragment.bF.get(i2)).mo822k();
                    arrayList3.add(Integer.valueOf(i2));
                    arrayList.add(k.g());
                    arrayList2.add(k.c());
                    arrayList4.add(k.c() + String.valueOf(k.V()));
                }
            }
            notificationsFragment.m13293a(arrayList, arrayList2, arrayList3, arrayList4, g);
        }
    }

    private void m13293a(List<String> list, List<String> list2, List<Integer> list3, List<String> list4, int i) {
        if (!list.isEmpty() && !list2.isEmpty()) {
            this.bM = i;
            this.bb.m13465a((List) list3, i);
            GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper = this.aI;
            graphQLNotificationsContentProviderHelper.f7579g.m7935a((Iterable) list, i);
            graphQLNotificationsContentProviderHelper.f7580h.f7620b = false;
            graphQLNotificationsContentProviderHelper.f7580h.m7935a((Iterable) list, i);
            graphQLNotificationsContentProviderHelper.f7580h.f7620b = true;
            for (String put : list4) {
                graphQLNotificationsContentProviderHelper.f7585m.put(put, Integer.valueOf(i));
            }
            this.at.m7847a((Iterable) list2, i);
        }
    }

    private static int m13297g(int i) {
        return (i + 1) % Integer.MAX_VALUE;
    }

    private boolean aB() {
        return this.aY.a() || this.aY.b();
    }

    private void aC() {
        if (this.bG) {
            AdapterDetour.a(this.bb, -250223108);
            this.bG = false;
        }
    }

    private void aD() {
        if (this.bb != null && D()) {
            this.at.m7845a(this.aC.d());
        }
    }

    public final Loader<List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields>> n_(int i) {
        ViewerContext d = this.aC.d();
        if (d == null || i != 100) {
            BLog.b(f12543i, "Unexpected onCreateLoader: %d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        int i2;
        if (this.aY.I()) {
            i2 = 30;
        } else {
            i2 = this.aF.m13371a(this.bg, o().getWindowManager().getDefaultDisplay(), this.bb.f12644d);
        }
        return new NotificationsLoader(getContext(), this.aI, getContext().getContentResolver(), this.ao.f7611b, d, i2, this.bk, this.an);
    }

    public final void gA_() {
        aq(this);
        this.bb.m13464a(null);
        AdapterDetour.a(this.bb, 1702567104);
        m13294a(false);
    }

    public final void m13303a(@Nullable Bundle bundle) {
        String str;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2128265869);
        super.a(bundle);
        Class cls = NotificationsFragment.class;
        m13292a((Object) this, getContext());
        if (this.s == null) {
            str = null;
        } else {
            str = this.s.getString("fragment_title");
        }
        this.bc = str;
        if (Strings.isNullOrEmpty(this.bc)) {
            this.bc = jW_().getString(2131233663);
        }
        this.bk = this.aT.m13452a() != SeeMoreButtonType.DEFAULT;
        if (this.bb == null) {
            this.bb = (NotificationsAdapter) this.am.get();
        }
        E().a(100, null, this);
        if (this.aY.b()) {
            this.bL = this.aJ.a().a(AppStateManager.b, new 15(this)).a(AppStateManager.c, new 16(this)).a();
            this.bL.b();
        }
        this.bs = this.as.a(Boolean.valueOf(false), "notification_classic_scroll_perf", Optional.of(String.valueOf(am_())));
        LogUtils.f(1563814826, a);
    }

    public final void m13299G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1175079029);
        super.G();
        this.az.b(655408, "NNF_PermalinkNotificationLoad");
        aC();
        this.bz = false;
        m13294a(true);
        this.aQ.f12632i = new C06082(this);
        this.aD.a(this.bq);
        if (D()) {
            this.at.f7564g = true;
        }
        NotificationsAdapter notificationsAdapter = this.bb;
        notificationsAdapter.f12643c.f12667l = new C06091(notificationsAdapter);
        NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager = notificationsAdapter.f12643c;
        notificationsInlineNotificationNuxManager.f12658c.a(NotificationsPreferenceConstants.f7721J, notificationsInlineNotificationNuxManager.f12659d);
        this.bb.m13466a(D());
        this.aW.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -768129806, a);
    }

    public final void m13300H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 103740710);
        super.H();
        aH();
        this.aQ.f12632i = null;
        this.aD.b(this.bq);
        this.at.f7564g = false;
        NotificationsAdapter notificationsAdapter = this.bb;
        notificationsAdapter.f12643c.f12667l = null;
        NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager = notificationsAdapter.f12643c;
        notificationsInlineNotificationNuxManager.f12658c.b(NotificationsPreferenceConstants.f7721J, notificationsInlineNotificationNuxManager.f12659d);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1471840443, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 541166672);
        super.mj_();
        this.aQ.m13442a(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 606807327, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ScrollingViewUtils.a(m13312n());
        if (this.bd != null) {
            this.bd.mo916a();
        }
        if (this.bk && configuration.orientation == 1) {
            this.bo = true;
        }
    }

    @Nullable
    public final ScrollingViewProxy m13312n() {
        return (this.bd == null || this.bd.getScrollingViewProxy() == null) ? null : this.bd.getScrollingViewProxy();
    }

    protected final void m13306a(SyncSource syncSource) {
        if (this.bp != null) {
            this.bp.b();
        }
        if (this.aC.d() != null) {
            this.bz = false;
            if (syncSource == SyncSource.PULL_TO_REFRESH) {
                this.aA.b(3473413);
            }
            this.aQ.m13442a(null);
            this.av.a(this.aL.m7829a(this.aC.d(), syncSource), new NotificationAsyncRequestCompletionListener(this, Long.valueOf(Long.parseLong(this.aC.d().mUserId))) {
                final /* synthetic */ NotificationsFragment f12790a;

                public /* synthetic */ void onSuccess(Object obj) {
                    mo648a((OperationResult) obj);
                }

                public final void mo648a(OperationResult operationResult) {
                    super.mo648a(operationResult);
                    if (operationResult.b) {
                        NotificationsFragment.m13290a(this.f12790a, operationResult);
                        return;
                    }
                    NotificationsFragment.m13295b(this.f12790a, operationResult);
                    NotificationsFragment.aE(this.f12790a);
                }

                public void onFailure(Throwable th) {
                    super.onFailure(th);
                    NotificationsFragment.aE(this.f12790a);
                }
            });
            m13294a(true);
        }
    }

    public static void m13290a(NotificationsFragment notificationsFragment, OperationResult operationResult) {
        FetchGraphQLNotificationsResult fetchGraphQLNotificationsResult = (FetchGraphQLNotificationsResult) operationResult.k();
        if (fetchGraphQLNotificationsResult != null && fetchGraphQLNotificationsResult.f10826a != null && fetchGraphQLNotificationsResult.f10826a.deltaStories == null && fetchGraphQLNotificationsResult.f10826a.newStories == null) {
            notificationsFragment.m13294a(false);
        }
        aq(notificationsFragment);
    }

    public static void aE(NotificationsFragment notificationsFragment) {
        if (notificationsFragment.bd != null) {
            notificationsFragment.bd.mo920c(true);
        }
        aq(notificationsFragment);
        notificationsFragment.aA.b(3473413, (short) 3);
    }

    private void m13294a(boolean z) {
        boolean z2 = false;
        ViewerContext d = this.aC.d();
        if (mx_() && this.bd != null && d != null) {
            boolean z3 = this.bb == null || this.bb.isEmpty();
            this.bd.mo918a(z3);
            if (z3 && z && E() != null && E().a()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.bb == null || r0 || this.aL.m7832a(Long.parseLong(d.mUserId))) {
                z2 = true;
            }
            this.bH = z2;
            this.bd.mo919b(z2);
        }
    }

    public final View mo907a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -911026098);
        this.bd = new DefaultNotificationsView(getContext());
        this.aB.a((View) this.bd, "jewel_popup_notifications", this);
        if (aJ() != null) {
            aJ().e = new C06006(this);
        }
        if (this.bd.getRefreshableContainerLike() != null) {
            this.bd.getRefreshableContainerLike().setOnRefreshListener(new 7(this));
        }
        this.bt = new NotificationsFragmentOnScrollListener(this);
        if (m13312n() != null) {
            m13312n().b(this.bt);
            m13312n().b(new FrameRateProxyScrollListener(this.bs));
            m13312n().a(this);
            this.au.m13330a(m13312n());
        }
        this.aI.m7897a((OnChangeListener) this);
        this.bf = true;
        if (m13312n() != null) {
            this.bi = (LoadingIndicatorView) layoutInflater.inflate(2130905494, m13312n().b(), false);
            m13312n().e(this.bi);
        }
        if (this.bd != null && this.bk) {
            this.bj = (FrameLayout) ((View) this.bd).findViewById(2131564290);
            layoutInflater.inflate(this.aT.m13452a() == SeeMoreButtonType.BLUE_PILL ? 2130905304 : 2130905303, this.bj, true);
            this.bj.findViewById(2131563924).setOnClickListener(new 8(this));
        }
        aN();
        String str = this.aI.m7918d() ? "cold" : "warm";
        this.az.a(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName, "load_type", str, true);
        this.az.a(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim, "load_type", str, true);
        if (D()) {
            PerformanceLogger performanceLogger;
            MarkerConfig a2;
            if (this.aI.m7918d()) {
                performanceLogger = this.az;
                a2 = new MarkerConfig(3473417, "NotifListLoadTimeCold").a(new String[]{TabTag.Notifications.analyticsTag});
                a2.n = true;
                performanceLogger.c(a2);
            } else {
                performanceLogger = this.az;
                a2 = new MarkerConfig(3473418, "NotifListLoadTimeWarm").a(new String[]{TabTag.Notifications.analyticsTag});
                a2.n = true;
                performanceLogger.c(a2);
            }
            this.aA.a(3473421, ImmutableList.of(TabTag.Notifications.analyticsTag));
            this.aA.a(3473413, ImmutableList.of(TabTag.Notifications.analyticsTag));
            this.bA = true;
        }
        if (m13312n() != null && this.aP.m13397b()) {
            m13312n().a(new C06019(this));
        }
        View view = (View) this.bd;
        LogUtils.f(-648696357, a);
        return view;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -872014632);
        super.mY_();
        if (this.bu != null) {
            this.bu.c();
        }
        if (this.bb != null) {
            this.aI.m7909b((OnChangeListener) this);
        }
        if (m13312n() != null) {
            m13312n().c(this.bt);
            m13312n().x();
        }
        if (aJ() != null) {
            aJ().e = null;
        }
        if (this.bd.getRefreshableContainerLike() != null) {
            this.bd.getRefreshableContainerLike().setOnRefreshListener(null);
        }
        this.bd = null;
        this.az.b(3473417, "NotifListLoadTimeCold");
        this.az.b(3473418, "NotifListLoadTimeWarm");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1705632902, a);
    }

    public final void m13301I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1950451267);
        super.I();
        if (this.bL != null) {
            this.bL.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1664203446, a);
    }

    public final void m13309d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1941517992);
        super.d(bundle);
        this.bu = this.aG.a(State.CONNECTED, new Runnable(this) {
            final /* synthetic */ NotificationsFragment f12758a;

            {
                this.f12758a = r1;
            }

            public void run() {
                this.f12758a.m13306a(SyncSource.CONNECTIVITY);
            }
        });
        this.bd.mo917a(new C06034(this), new C06045(this));
        m13322a(this.bb);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1908580094, a);
    }

    public final void mo909a(View view, int i) {
        if (view != this.bi && !this.L && this.bd != null && !(view instanceof PostFeedbackView)) {
            if (!(view instanceof SwitchableNotificationView) || ((SwitchableNotificationView) view).f == SwitchableNotificationView.State.NOTIFICATION) {
                this.aN.a(getClass().getSimpleName());
                this.az.d(655408, "NNF_PermalinkNotificationLoad");
                FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) m13312n().g(i);
                GraphQLStory k = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k();
                GraphQLStory c = this.aI.m7913c(k.g());
                int h = m13298h(i);
                String name = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo815c().name();
                if (this.aS.m13447a() && fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo815c() == GraphQLNotifHighlightState.HIGHLIGHTED && this.aS.m13449d() && this.aS.f12638b.a(NotificationsPreferenceConstants.f7720I, true)) {
                    this.aS.f12638b.edit().putBoolean(NotificationsPreferenceConstants.f7720I, false).commit();
                    this.bG = true;
                }
                if (c == null) {
                    this.av.a(this.at.m7844a(k.c(), k.g()), new 11(this, h, name));
                    return;
                }
                m13291a(this, FeedProps.c(c), h, name);
            }
        }
    }

    public static void m13291a(NotificationsFragment notificationsFragment, FeedProps feedProps, int i, String str) {
        if (feedProps == null) {
            notificationsFragment.az.f(655408, "NNF_PermalinkNotificationLoad");
            notificationsFragment.aN.a();
            notificationsFragment.ap.a(f12543i.getSimpleName() + "_null_notif_story", "Null notif story in adapter");
            return;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        notificationsFragment.aq.edit().a(NotificationsPreferenceConstants.f7726c, graphQLStory.g()).commit();
        notificationsFragment.ax.a("tap_notification_jewel");
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
        notificationLogObject.w = notificationsFragment.aS.m13447a();
        notificationLogObject = notificationLogObject;
        notificationLogObject.x = notificationsFragment.aS.m13448b().name();
        notificationLogObject = notificationLogObject;
        notificationLogObject.y = str;
        notificationLogObject = notificationLogObject;
        notificationLogObject.z = NotificationsLikeCountHelper.m7850a(graphQLStory);
        notificationsFragment.ay.m12209a(notificationLogObject);
        if (z) {
            notificationsFragment.bG = true;
            notificationsFragment.at.m7849a(ImmutableList.of(graphQLStory.c()), GraphQLStorySeenState.SEEN_AND_READ, notificationsFragment.aC.d());
            notificationsFragment.bb.m13462a(i);
            notificationsFragment.aD.a(new NotificationsClickedEvent(graphQLStory.g()));
            if (i < 30) {
                notificationsFragment.aI.m7910b(graphQLStory.g(), GraphQLStorySeenState.SEEN_AND_READ);
            } else {
                notificationsFragment.aI.m7902a(graphQLStory.g(), GraphQLStorySeenState.SEEN_AND_READ);
            }
        }
        boolean z2 = false;
        GraphQLStory graphQLStory2 = (GraphQLStory) feedProps.a;
        if (notificationsFragment.bg != null) {
            String a = NotificationStoryHelper.m13348a(graphQLStory2);
            z2 = a != null ? notificationsFragment.aK.a(notificationsFragment.getContext(), a) : notificationsFragment.aE.m13345a(notificationsFragment.bg, feedProps);
        }
        if (!z2) {
            notificationsFragment.az.f(655408, "NNF_PermalinkNotificationLoad");
            notificationsFragment.aN.a();
            notificationsFragment.ap.a(f12543i.getSimpleName() + "_launch_failed", "Could not launch notification story " + graphQLStory2.c());
        }
    }

    private int m13298h(int i) {
        ScrollingViewProxy n = m13312n();
        return n == null ? i : i - n.u();
    }

    public final void m13310e() {
        as();
    }

    public final void gB_() {
        if (m13312n() != null) {
            m13312n().e(0);
        }
    }

    public final boolean gC_() {
        return m13312n() != null && m13312n().q() == 0;
    }

    public static void m13295b(NotificationsFragment notificationsFragment, OperationResult operationResult) {
        String a = notificationsFragment.m13288a(notificationsFragment.getContext().getString(2131230811), operationResult.e.ordinal(), operationResult.f);
        BLog.b(f12543i, a);
        notificationsFragment.ap.a(f12543i.getSimpleName() + "_sync_failed", a);
    }

    private String m13288a(String str, int i, String str2) {
        if (i == 0) {
            return str;
        }
        return getContext().getString(2131233664, new Object[]{str, Integer.valueOf(i), str2});
    }

    public Map<String, String> getDebugInfo() {
        if (!this.bf) {
            return RegularImmutableBiMap.a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int e = this.bb != null ? this.bb.m13471e() : 0;
        stringBuilder.append("\nLoaded Notifications: ").append(e);
        stringBuilder.append("\nLast Load Time: ").append(this.be);
        if (this.bb != null && this.bw >= 0 && this.bv >= 0) {
            stringBuilder.append("\nVisible Notification Ids: [\n");
            int i = this.bv + this.bw;
            if (i > e) {
                i = e;
            }
            for (int i2 = this.bv; i2 < i; i2++) {
                FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.bb.getItem(i2);
                if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null || fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k() == null) {
                    stringBuilder.append("null");
                } else {
                    stringBuilder.append(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().g());
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append("]\n");
        }
        if (this.an != null) {
            stringBuilder.append("Last Updated Time: ").append(this.an.m7924a()).append("\n");
        }
        return ImmutableBiMap.b("NotificationsFragment", stringBuilder.toString());
    }

    public final boolean gD_() {
        if (this.bA && this.bC) {
            this.az.c(3473417, "NotifListLoadTimeCold");
            this.az.c(3473418, "NotifListLoadTimeWarm");
            this.az.a(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName, "load_type", "hot", false);
            this.az.c(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName);
            this.az.a(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim, "load_type", "hot", false);
            this.az.c(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim);
            this.bA = false;
        }
        if (!(!this.bk || this.bb == null || this.bb.isEmpty())) {
            if (!this.bl && this.bj.getVisibility() != 0 && m13312n().r() < this.bm) {
                this.bj.setVisibility(0);
            } else if (this.bo && m13312n().r() >= this.bm) {
                this.bo = false;
                this.bj.setVisibility(8);
                this.bl = true;
            }
        }
        return false;
    }

    public static void aG(NotificationsFragment notificationsFragment) {
        NotificationsAdapter notificationsAdapter = notificationsFragment.bb;
        String str = null;
        int e = notificationsAdapter.m13471e();
        if (e != 0) {
            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a = notificationsAdapter.f12650j.m13498a(e - 1);
            if (a != null) {
                str = a.mo813a();
            }
        }
        String str2 = str;
        if (str2 != null) {
            notificationsFragment.aA.b(3473421);
            if (notificationsFragment.bd.getListView().getFooterViewsCount() == 0) {
                notificationsFragment.m13312n().e(notificationsFragment.bi);
            }
            if (!notificationsFragment.bi.f()) {
                notificationsFragment.bi.a();
            }
            notificationsFragment.br = true;
            notificationsFragment.av.a(notificationsFragment.aL.m7830a(notificationsFragment.aC.d(), str2, al, notificationsFragment.bb.m13471e()), new 12(notificationsFragment));
        }
    }

    private void aH() {
        if (this.bx != 0 && this.bE) {
            boolean z = this.bx > this.bw;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("notification_scroll_depth_v2");
            honeyClientEvent.c = "notifications";
            this.aw.a(honeyClientEvent.a("scroll_depth", this.bx).a("jewel_count", this.by).a("visible_item_count", this.bw).a("passed_scroll_threshold", z));
            this.bE = false;
        }
    }

    public final String am_() {
        return TabTag.Notifications.analyticsTag;
    }

    public final Map<String, Object> mo911c() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("jewel_count", Integer.valueOf(this.by));
        return hashMap;
    }

    public static void aI(NotificationsFragment notificationsFragment) {
        ConnectionRetrySnackbarView connectionRetrySnackbarView = new ConnectionRetrySnackbarView(notificationsFragment.getContext());
        connectionRetrySnackbarView.setRetryClickListener(new 13(notificationsFragment));
        notificationsFragment.bp = notificationsFragment.aO.m13374a(connectionRetrySnackbarView, 10000);
        if (notificationsFragment.aJ() != null) {
            notificationsFragment.bp.i = notificationsFragment.aJ();
        }
        notificationsFragment.bp.a();
    }

    @Nullable
    private FbSwipeRefreshLayout aJ() {
        return (this.bd == null || this.bd.getSwipeRefreshLayout() == null) ? null : this.bd.getSwipeRefreshLayout();
    }

    private void aN() {
        if (!aB() && this.aX.f7750a.a(ExperimentsForNotificationsAbtestModule.f7753B, false)) {
            FigSectionHeader figSectionHeader = new FigSectionHeader(this.bg);
            figSectionHeader.setTitleText(this.bg.getString(2131233663));
            if (this.aX.m8061k()) {
                figSectionHeader.setActionText(this.bg.getString(2131233708));
                figSectionHeader.setActionOnClickListener(new 17(this));
            }
            this.bd.getListView().addHeaderView(figSectionHeader);
        }
    }
}
