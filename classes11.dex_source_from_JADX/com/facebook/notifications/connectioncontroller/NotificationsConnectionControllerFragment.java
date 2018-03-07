package com.facebook.notifications.connectioncontroller;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.apptab.state.TabTag;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.util.FindViewUtil;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionAdapter;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateProxyScrollListener;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.core.ImmutableListItemComparator;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.notifications.multirow.NotificationsFeedAdapter;
import com.facebook.notifications.multirow.NotificationsFeedAdapter.TailLoadingState;
import com.facebook.notifications.multirow.NotificationsFeedAdapterProvider;
import com.facebook.notifications.multirow.NotificationsFeedListType;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.notifications.server.NotificationsChangeSeenStateParams;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.notifications.util.NotificationsConnectionControllerManager;
import com.facebook.notifications.util.NotificationsFragmentTouchUtil;
import com.facebook.notifications.util.NotificationsSeenStateMutator;
import com.facebook.notifications.util.NotificationsSeenStateMutator.MarkNotificationsSeenVisitor;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewUtils;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.refreshableview.ConnectionRetrySnackbarView;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: timeline context must be set */
public class NotificationsConnectionControllerFragment extends FbFragment implements AnalyticsFragmentWithExtraData, ReactionCardContainer, OnDrawListener, ScrollableListContainer {
    @Inject
    public ClickableToastBuilder f922a;
    public boolean aA = false;
    private int aB = 0;
    private boolean aC = false;
    public LoadingIndicatorView aD;
    private boolean aE = false;
    private SelfRegistrableReceiverImpl aF;
    private OnScrollListener aG;
    public FbSwipeRefreshLayout aH;
    public ClickableToast aI;
    private ReactionAnalyticsParams aJ;
    private ReactionInteractionTracker aK;
    private ReactionSession aL;
    public BetterRecyclerView aM;
    public RecyclerViewProxy aN;
    @Inject
    PerformanceLogger al;
    @Inject
    QuickPerformanceLogger am;
    @Inject
    NotificationsFunnelLogger an;
    @Inject
    NotificationsSeenStateMutator ao;
    @Inject
    ReactionFeedActionHandlerProvider ap;
    @Inject
    ReactionInteractionTrackerProvider aq;
    @Inject
    public ReactionSessionManager ar;
    @Inject
    ReactionThemedContextHelper as;
    @Inject
    ViewerContextManager at;
    @Inject
    NotificationsSyncManager au;
    @Inject
    NotificationsConnectionControllerManager av;
    public NotificationsFeedAdapter aw;
    public ConnectionController<NotificationsEdgeFieldsModel, Void> ax;
    private FrameRateProxyScrollListener ay;
    private RecyclerViewConnectionListener<NotificationsEdgeFieldsModel> az;
    @Inject
    FrameRateLoggerProvider f923b;
    @Inject
    JewelCounters f924c;
    @Inject
    NotificationsConnectionEnvironmentProvider f925d;
    @Inject
    NetworkMonitor f926e;
    @Inject
    NotificationsConnectionCollection f927f;
    @Inject
    NotificationsFeedAdapterProvider f928g;
    @Inject
    NotificationsFragmentTouchUtil f929h;
    @Inject
    NotificationsUtils f930i;

    /* compiled from: timeline context must be set */
    class C01171 implements Runnable {
        final /* synthetic */ NotificationsConnectionControllerFragment f909a;

        C01171(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f909a = notificationsConnectionControllerFragment;
        }

        public void run() {
            NotificationsConnectionControllerFragment.m1198a(this.f909a, false);
        }
    }

    /* compiled from: timeline context must be set */
    class C01182 implements RecyclerViewConnectionAdapter<NotificationsEdgeFieldsModel> {
        final /* synthetic */ NotificationsConnectionControllerFragment f910a;

        C01182(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f910a = notificationsConnectionControllerFragment;
        }

        public final void m1184a(ConnectionState<NotificationsEdgeFieldsModel> connectionState) {
            NotificationsConnectionControllerFragment.m1197a(this.f910a, (ConnectionState) connectionState);
        }

        public final int aZ_() {
            return this.f910a.f927f.m1178a();
        }

        public final void b_(int i, int i2) {
            boolean n = this.f910a.aN.n();
            NotificationsConnectionCollection notificationsConnectionCollection = this.f910a.f927f;
            if (notificationsConnectionCollection.f908b != null) {
                for (int i3 = i; i3 < i + i2; i3++) {
                    notificationsConnectionCollection.f908b.a(i3, notificationsConnectionCollection.m1181b(i3), false);
                }
            }
            if (n) {
                this.f910a.aN.e(0);
            }
        }

        public final void m1183a(int i, int i2) {
            NotificationsConnectionCollection notificationsConnectionCollection = this.f910a.f927f;
            if (notificationsConnectionCollection.f908b != null) {
                for (int i3 = i; i3 < i + i2; i3++) {
                    notificationsConnectionCollection.f908b.a(i3, null, notificationsConnectionCollection.m1181b(i3), false);
                }
            }
        }

        public final void m1185d(int i, int i2) {
            NotificationsConnectionCollection notificationsConnectionCollection = this.f910a.f927f;
            if (notificationsConnectionCollection.f908b != null) {
                for (int i3 = i; i3 < i + i2; i3++) {
                    notificationsConnectionCollection.f908b.b(i, null, false);
                }
            }
        }
    }

    /* compiled from: timeline context must be set */
    public class C01214 implements OnScrollListener {
        final /* synthetic */ NotificationsConnectionControllerFragment f914a;

        public C01214(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f914a = notificationsConnectionControllerFragment;
        }

        public final void m1192a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m1193a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if (((i + i2) + 3 >= i3 ? 1 : null) != null && this.f914a.aA) {
                this.f914a.am.b(3473421);
                this.f914a.ax.b(10, null);
            }
        }
    }

    /* compiled from: timeline context must be set */
    class C01225 implements Runnable {
        final /* synthetic */ NotificationsConnectionControllerFragment f915a;

        C01225(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f915a = notificationsConnectionControllerFragment;
        }

        public void run() {
            if (this.f915a.aw != null) {
                this.f915a.aw.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: timeline context must be set */
    class C01246 implements Delegate {
        final /* synthetic */ NotificationsConnectionControllerFragment f918a;

        C01246(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f918a = notificationsConnectionControllerFragment;
        }

        public final void m1195a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            this.f918a.aM.a(new RecyclerView.OnScrollListener(this) {
                final /* synthetic */ C01246 f917b;

                public final void m1194a(RecyclerView recyclerView, int i, int i2) {
                    super.a(recyclerView, i, i2);
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }

    /* compiled from: timeline context must be set */
    public class C01257 implements OnRefreshListener {
        final /* synthetic */ NotificationsConnectionControllerFragment f919a;

        public C01257(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f919a = notificationsConnectionControllerFragment;
        }

        public final void m1196a() {
            NotificationsConnectionControllerFragment.av(this.f919a);
        }
    }

    /* compiled from: timeline context must be set */
    public class C01268 implements OnClickListener {
        final /* synthetic */ NotificationsConnectionControllerFragment f920a;

        public C01268(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f920a = notificationsConnectionControllerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1289876060);
            NotificationsConnectionControllerFragment.av(this.f920a);
            Logger.a(2, EntryType.UI_INPUT_END, 1416506691, a);
        }
    }

    /* compiled from: timeline context must be set */
    class C01279 implements OnClickListener {
        final /* synthetic */ NotificationsConnectionControllerFragment f921a;

        C01279(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
            this.f921a = notificationsConnectionControllerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -97639059);
            this.f921a.ax.b(10, null);
            this.f921a.aw.i = TailLoadingState.LOADING;
            this.f921a.aw.a(this.f921a.aw.aZ_() - 1, 1);
            Logger.a(2, EntryType.UI_INPUT_END, 1073680565, a);
        }
    }

    public static void m1200a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NotificationsConnectionControllerFragment) obj).m1199a(ClickableToastBuilder.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), JewelCounters.a(injectorLike), (NotificationsConnectionEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationsConnectionEnvironmentProvider.class), NetworkMonitor.a(injectorLike), NotificationsConnectionCollection.m1177a(injectorLike), (NotificationsFeedAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationsFeedAdapterProvider.class), NotificationsFragmentTouchUtil.a(injectorLike), NotificationsUtils.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), NotificationsFunnelLogger.a(injectorLike), NotificationsSeenStateMutator.a(injectorLike), (ReactionFeedActionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), ReactionSessionManager.a(injectorLike), ReactionThemedContextHelper.a(injectorLike), ViewerContextManagerProvider.a(injectorLike), NotificationsSyncManager.a(injectorLike), NotificationsConnectionControllerManager.a(injectorLike));
    }

    private void m1199a(ClickableToastBuilder clickableToastBuilder, FrameRateLoggerProvider frameRateLoggerProvider, JewelCounters jewelCounters, NotificationsConnectionEnvironmentProvider notificationsConnectionEnvironmentProvider, NetworkMonitor networkMonitor, NotificationsConnectionCollection notificationsConnectionCollection, NotificationsFeedAdapterProvider notificationsFeedAdapterProvider, NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, NotificationsUtils notificationsUtils, PerformanceLogger performanceLogger, QuickPerformanceLogger quickPerformanceLogger, NotificationsFunnelLogger notificationsFunnelLogger, NotificationsSeenStateMutator notificationsSeenStateMutator, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, ReactionSessionManager reactionSessionManager, ReactionThemedContextHelper reactionThemedContextHelper, ViewerContextManager viewerContextManager, NotificationsSyncManager notificationsSyncManager, NotificationsConnectionControllerManager notificationsConnectionControllerManager) {
        this.f922a = clickableToastBuilder;
        this.f923b = frameRateLoggerProvider;
        this.f924c = jewelCounters;
        this.f925d = notificationsConnectionEnvironmentProvider;
        this.f926e = networkMonitor;
        this.f927f = notificationsConnectionCollection;
        this.f928g = notificationsFeedAdapterProvider;
        this.f929h = notificationsFragmentTouchUtil;
        this.f930i = notificationsUtils;
        this.al = performanceLogger;
        this.am = quickPerformanceLogger;
        this.an = notificationsFunnelLogger;
        this.ao = notificationsSeenStateMutator;
        this.ap = reactionFeedActionHandlerProvider;
        this.aq = reactionInteractionTrackerProvider;
        this.ar = reactionSessionManager;
        this.as = reactionThemedContextHelper;
        this.at = viewerContextManager;
        this.au = notificationsSyncManager;
        this.av = notificationsConnectionControllerManager;
    }

    public final void m1213c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NotificationsConnectionControllerFragment.class;
        m1200a((Object) this, getContext());
        this.aJ = new ReactionAnalyticsParams(null, getSurface().name(), "unknown", null);
        String uuid = SafeUUIDGenerator.a().toString();
        ReactionSession a = this.ar.a(uuid, getSurface());
        this.ar.c(uuid);
        this.aL = a;
        this.aK = this.aq.a(this.aL, null);
    }

    public final View m1208a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1303898853);
        View inflate = layoutInflater.inflate(2130905487, viewGroup, false);
        this.aM = (BetterRecyclerView) FindViewUtil.b(inflate, 16908298);
        this.aM.setLayoutManager(new BetterLinearLayoutManager(getContext()));
        this.aN = new RecyclerViewProxy(this.aM);
        this.aN.k();
        this.aG = new C01214(this);
        this.aN.b(this.aG);
        this.ay = new FrameRateProxyScrollListener(this.f923b.a(Boolean.valueOf(false), "notification_connection_controller_scroll_perf", Optional.of(am_())));
        this.aN.b(this.ay);
        this.aN.a(this);
        Context a2 = ReactionThemedContextHelper.a(getContext(), getSurface());
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(2130772382, typedValue, true);
        this.aD = (LoadingIndicatorView) FindViewUtil.b(inflate, 2131560407);
        this.aD.setBackgroundResource(typedValue.resourceId);
        this.aD.a();
        int i = typedValue.resourceId;
        this.aH = (FbSwipeRefreshLayout) FindViewUtil.b(inflate, 2131561342);
        this.aH.setBackgroundResource(i);
        this.aH.e = new C01257(this);
        this.aH.setEnabled(true);
        this.f929h.a(this.aN);
        this.f929h.a(this.aN, this.aM);
        as();
        aq();
        m1204c(a2);
        this.aN.a(this.aw);
        m1198a(this, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2142615126, a);
        return inflate;
    }

    public final void m1206G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1295982303);
        super.G();
        if (D()) {
            this.f930i.g = true;
        }
        this.al.b(655408, "NNF_PermalinkNotificationLoad");
        this.aF = this.f926e.a(State.CONNECTED, new C01171(this));
        this.an.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1605150951, a);
    }

    public final void m1207H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 890599770);
        super.H();
        this.f930i.g = false;
        if (this.aF != null) {
            this.aF.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1661256960, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ScrollingViewUtils.a(this.aN);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -768166719);
        super.mY_();
        this.aN.c(this.aG);
        this.aN.c(this.ay);
        this.aN.a(null);
        this.aN = null;
        this.aM = null;
        this.aG = null;
        this.ay = null;
        this.aD = null;
        this.aH.e = null;
        this.aH = null;
        this.aI = null;
        if (this.f927f != null) {
            this.f927f.f907a = null;
        }
        if (this.ax != null) {
            this.ax.b(this.az);
            this.az = null;
            this.ax = null;
        }
        this.al.b(3473418, "NotifListLoadTimeWarm");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1621092731, a);
    }

    public final void m1214g(boolean z) {
        if (this.aI != null) {
            this.aI.b();
        }
        if (this.f930i != null) {
            this.f930i.g = z;
        }
        this.aE = z;
        if (z && !D()) {
            this.aB = this.f924c.a(Jewel.NOTIFICATIONS);
            if (!(this.f924c == null || this.aN == null || this.aB <= 0)) {
                this.aN.w();
            }
            m1205e(this);
        }
        super.g(z);
    }

    public static void m1205e(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
        if (notificationsConnectionControllerFragment.f927f != null && notificationsConnectionControllerFragment.f927f.m1178a() != 0) {
            Builder builder = new Builder();
            for (int i = 0; i < notificationsConnectionControllerFragment.f927f.m1178a(); i++) {
                NotificationsEdgeFieldsModel b = notificationsConnectionControllerFragment.f927f.m1181b(i);
                if (b != null) {
                    GraphQLStory k = b.k();
                    if (!(k == null || k.c() == null)) {
                        GraphQLStorySeenState au = k.au();
                        if (au == null || au == GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || au == GraphQLStorySeenState.UNSEEN_AND_UNREAD) {
                            builder.c(k.c());
                        }
                    }
                }
            }
            NotificationsSeenStateMutator notificationsSeenStateMutator = notificationsConnectionControllerFragment.ao;
            ImmutableList b2 = builder.b();
            if (!b2.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("graphNotifsUpdateSeenStatePrams", new NotificationsChangeSeenStateParams(b2, GraphQLStorySeenState.SEEN_BUT_UNREAD));
                notificationsSeenStateMutator.b.a(BlueServiceOperationFactoryDetour.a(notificationsSeenStateMutator.a, "graphNotifUpdateSeenStateOnlyOnServer", bundle, -487500043).a(), new MarkNotificationsSeenVisitor(b2));
            }
            notificationsConnectionControllerFragment.f924c.a(Jewel.NOTIFICATIONS, 0);
        }
    }

    public final String am_() {
        return TabTag.Notifications.analyticsTag;
    }

    public final Map<String, Object> m1212c() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("jewel_count", Integer.valueOf(this.aB));
        return hashMap;
    }

    @Nullable
    public final ScrollingViewProxy m1215n() {
        return this.aN;
    }

    public final boolean gD_() {
        if (this.aE && this.aC) {
            this.al.c(3473418, "NotifListLoadTimeWarm");
            this.al.a(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName, "load_type", "hot", false);
            this.al.c(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName);
            this.al.a(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim, "load_type", "hot", false);
            this.al.c(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim);
            this.aE = false;
        }
        return false;
    }

    public final void gB_() {
        if (this.aN != null) {
            this.aN.e(0);
        }
    }

    public final boolean gC_() {
        return this.aN == null ? true : this.aN.n();
    }

    public final boolean m1210a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return false;
    }

    public final boolean m1211a(String str, CardSearchType cardSearchType) {
        return false;
    }

    @Nullable
    public final ReactionUnitFragment m1209a(String str) {
        return null;
    }

    @Nullable
    public ViewGroup getCardViewGroup() {
        return this.aM;
    }

    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.aK;
    }

    public String getSessionId() {
        return this.aL.a;
    }

    public Surface getSurface() {
        return Surface.ANDROID_NOTIFICATIONS;
    }

    private void aq() {
        this.ax = this.av.a();
        if (this.ax.d().d() > 0) {
            this.aD.setVisibility(8);
            m1197a(this, this.ax.d());
        }
        final C01182 c01182 = new C01182(this);
        this.az = new RecyclerViewConnectionListener<NotificationsEdgeFieldsModel>(this) {
            final /* synthetic */ NotificationsConnectionControllerFragment f913b;

            /* compiled from: timeline context must be set */
            class C01191 implements RetryClickedListener {
                final /* synthetic */ C01203 f911a;

                C01191(C01203 c01203) {
                    this.f911a = c01203;
                }

                public final void m1186a() {
                    NotificationsConnectionControllerFragment.m1198a(this.f911a.f913b, true);
                }
            }

            protected final RecyclerViewConnectionAdapter<NotificationsEdgeFieldsModel> m1189b() {
                return c01182;
            }

            protected final ConnectionController<NotificationsEdgeFieldsModel, ?> m1191c() {
                return this.f913b.ax;
            }

            public final void m1187a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
                this.f913b.au.e.add(Long.valueOf(Long.parseLong(this.f913b.at.d().mUserId)));
                if (connectionLocation.c == LocationType.AFTER) {
                    this.f913b.aw.i = TailLoadingState.LOADING;
                }
            }

            public final void m1190b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
                this.f913b.au.c(Long.parseLong(this.f913b.at.d().mUserId));
                if (this.f913b.ax.d().d() > 0) {
                    this.f913b.aD.setVisibility(8);
                }
                this.f913b.aD.b();
                if (NotificationsConnectionControllerFragment.m1201a(this.f913b, connectionLocation.c)) {
                    this.f913b.am.b(3473421, (short) 27);
                    this.f913b.aw.i = TailLoadingState.FINISHED;
                } else if (NotificationsConnectionControllerFragment.m1203b(this.f913b, connectionLocation.c)) {
                    this.f913b.am.b(3473413, (short) 2);
                }
                this.f913b.aH.setRefreshing(false);
                if (this.f913b.D()) {
                    NotificationsConnectionControllerFragment.m1205e(this.f913b);
                }
            }

            public final void m1188a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
                Object obj;
                this.f913b.au.c(Long.parseLong(this.f913b.at.d().mUserId));
                NotificationsConnectionControllerFragment notificationsConnectionControllerFragment = this.f913b;
                if (connectionLocation.c == LocationType.INITIAL) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.f913b.aD.a(this.f913b.getContext().getResources().getString(2131230811), new C01191(this));
                } else if (NotificationsConnectionControllerFragment.m1201a(this.f913b, connectionLocation.c)) {
                    this.f913b.am.b(3473421, (short) 3);
                    this.f913b.aw.i = TailLoadingState.FAILED;
                } else if (NotificationsConnectionControllerFragment.m1203b(this.f913b, connectionLocation.c)) {
                    this.f913b.am.b(3473413, (short) 3);
                }
                this.f913b.aH.setRefreshing(false);
                this.f913b.aw.a(this.f913b.aw.aZ_() - 1, 1);
            }
        };
        this.ax.a(this.az);
    }

    static /* synthetic */ boolean m1201a(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment, LocationType locationType) {
        return locationType == LocationType.AFTER;
    }

    static /* synthetic */ boolean m1203b(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment, LocationType locationType) {
        return locationType == LocationType.BEFORE;
    }

    public static void m1197a(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment, ConnectionState connectionState) {
        notificationsConnectionControllerFragment.aC = true;
        notificationsConnectionControllerFragment.f927f.f907a = connectionState;
        notificationsConnectionControllerFragment.aA = connectionState.c().d;
    }

    public static void m1198a(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment, boolean z) {
        if (!notificationsConnectionControllerFragment.au.a(Long.parseLong(notificationsConnectionControllerFragment.at.d().mUserId))) {
            notificationsConnectionControllerFragment.ax.a(10, null);
            if (z) {
                notificationsConnectionControllerFragment.am.b(3473413);
            }
        }
    }

    private void as() {
        this.al.a(TabTag.Notifications.loadTabTabPerfMarkerId, TabTag.Notifications.loadTabTabPerfMarkerName, "load_type", "warm", true);
        this.al.a(TabTag.Notifications.loadTabTabPerfMarkerIdNoAnim, TabTag.Notifications.loadTabTabPerfMarkerNameNoAnim, "load_type", "warm", true);
        if (D()) {
            PerformanceLogger performanceLogger = this.al;
            MarkerConfig a = new MarkerConfig(3473418, "NotifListLoadTimeWarm").a(new String[]{TabTag.Notifications.analyticsTag});
            a.n = true;
            performanceLogger.c(a);
        }
        this.am.a(3473421, ImmutableList.of(TabTag.Notifications.analyticsTag));
        this.am.a(3473413, ImmutableList.of(TabTag.Notifications.analyticsTag));
        this.aE = true;
    }

    private NotificationsConnectionEnvironment m1202b(Context context) {
        return this.f925d.m1224a(context, NotificationsFeedListType.a, null, new C01225(this), this.aJ, this.ap.a(context, this), this.aK, this.aL, new C01246(this));
    }

    public static void av(NotificationsConnectionControllerFragment notificationsConnectionControllerFragment) {
        if (notificationsConnectionControllerFragment.f926e.a()) {
            m1198a(notificationsConnectionControllerFragment, true);
            return;
        }
        notificationsConnectionControllerFragment.aH.setRefreshing(false);
        if (notificationsConnectionControllerFragment.aI != null) {
            notificationsConnectionControllerFragment.aI.b();
        }
        ConnectionRetrySnackbarView connectionRetrySnackbarView = new ConnectionRetrySnackbarView(notificationsConnectionControllerFragment.getContext());
        connectionRetrySnackbarView.setRetryClickListener(new C01268(notificationsConnectionControllerFragment));
        notificationsConnectionControllerFragment.aI = notificationsConnectionControllerFragment.f922a.a(connectionRetrySnackbarView, 10000);
        notificationsConnectionControllerFragment.aI.a();
    }

    private void m1204c(Context context) {
        if (this.aw == null) {
            this.aw = this.f928g.a(m1202b(context), new ImmutableListItemComparator(), this.f927f);
        }
        this.aw.j = new C01279(this);
        this.aw.i = TailLoadingState.FINISHED;
    }
}
