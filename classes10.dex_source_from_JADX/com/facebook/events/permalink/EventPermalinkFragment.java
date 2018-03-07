package com.facebook.events.permalink;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEventBus;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEvents.BoostedPostStatusChangedEvent;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEvents.BoostedPostStatusChangedEventSubscriber;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.common.TtiVia;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.create.CreateEventPerformanceLogger;
import com.facebook.events.data.EventAdminStatusRecord;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventCanceledEvent;
import com.facebook.events.eventsevents.EventsEvents.EventDeletedEvent;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.PostEvent;
import com.facebook.events.eventsevents.EventsEvents.RsvpChangeEvent;
import com.facebook.events.feed.data.EventFeedPager;
import com.facebook.events.feed.data.EventFeedPager.EventLoggerWithCount;
import com.facebook.events.feed.data.EventFeedPagerProtocol;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQL.EventPinnedPostAndRecentStoryQueryString;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.EventCreatorModel;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.EventCreatorModel.AdminInfoModel;
import com.facebook.events.feed.ui.EventPermalinkStoriesExtractor;
import com.facebook.events.feed.ui.EventStoriesQueryParamHelper;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel.Builder;
import com.facebook.events.graphql.EventsMutations;
import com.facebook.events.graphql.EventsMutations.EventRsvpSubscriptionString;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.actionbar.ActionItemPost.C25464;
import com.facebook.events.permalink.adapters.EventPermalinkAdapter;
import com.facebook.events.permalink.adapters.EventPermalinkListAdapterProvider;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonActivityResultHandler;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonActivityResultHandler.C25881;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonActivityResultHandler.CheckPublishLogger;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonController;
import com.facebook.events.permalink.pagevc.PageViewerContextForAnEvent;
import com.facebook.events.permalink.perf.EventPermalinkPerformanceLogger;
import com.facebook.events.permalink.perf.EventPermalinkSequenceLogger;
import com.facebook.events.permalink.perf.EventPermalinkSequenceLogger.LoadingState;
import com.facebook.events.permalink.protocol.EventPermalinkModelFetcher;
import com.facebook.events.permalink.protocol.EventPermalinkModelFetcher.C26701;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.events.tickets.BuyTicketPayViewController;
import com.facebook.events.tickets.EventBuyTicketsActivityResultHandler;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.annotations.ForNewsfeed;
import com.facebook.feed.data.FeedUnitSubscriber;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.ui.FeedLifecycleSubscribers;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feedcontrollers.FeedDeletePostController;
import com.facebook.feedcontrollers.FeedLikeController;
import com.facebook.feedcontrollers.FeedSetNotifyMeController;
import com.facebook.feedcontrollers.FeedStoryVisibilityController;
import com.facebook.feedcontrollers.FeedUnitMutationController;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.EventRsvpSubscribeInputData;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.pages.common.pageviewercontext.BaseViewerContextWaiter;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.resources.ui.FbTextView;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.IsTablet;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.titlebar.FadingContentFragmentController;
import com.facebook.widget.titlebar.FadingContentView;
import com.facebook.widget.titlebar.FadingContentViewProvider;
import com.facebook.widget.titlebar.FadingFbTitleBar;
import com.facebook.widget.titlebar.FadingTitlebarContent;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: canvas_dwell_time */
public class EventPermalinkFragment extends FbFragment implements AnalyticsFragmentWithExtraData, DialtoneStateChangedListener, GraphSearchQueryProvider, FadingContentViewProvider {
    public static final String am = String.valueOf(null);
    private ViewGroup f17835a;
    @Inject
    public EventFeedPager aA;
    @Inject
    EventFeedPagerProtocol aB;
    @Inject
    EventGraphQLModelHelper aC;
    @Inject
    EventPermalinkBazingaHelper aD;
    @Inject
    EventPermalinkEarlyFetcher aE;
    @Inject
    EventPermalinkListAdapterProvider aF;
    @Inject
    EventPermalinkModelFetcher aG;
    @Inject
    EventPermalinkPerformanceLogger aH;
    @Inject
    EventPermalinkSequenceLogger aI;
    @Inject
    public EventStoriesQueryParamHelper aJ;
    @Inject
    public EventsCommonContract aK;
    @Inject
    EventsConnectionExperimentController aL;
    @Inject
    EventsEventBus aM;
    @Inject
    FbNetworkManager aN;
    @Inject
    FbTitleBarSupplier aO;
    @Inject
    public FeedDeletePostController aP;
    @Inject
    public FeedLikeController aQ;
    @Inject
    FeedLikeController aR;
    @Inject
    public FeedSetNotifyMeController aS;
    @Inject
    FeedSetNotifyMeController aT;
    @Inject
    public FeedStoryVisibilityController aU;
    @Inject
    public FeedUnitCollection aV;
    @Inject
    public FeedUnitMutationController aW;
    @Inject
    public FeedUnitSubscriber aX;
    @Inject
    FrameRateLoggerProvider aY;
    @Inject
    GatekeeperStoreImpl aZ;
    public boolean al;
    @Inject
    @ForNewsfeed
    FeedLifecycleSubscribers an;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService ao;
    @Inject
    @IsTablet
    Boolean ap;
    @Inject
    ActionItemInvite aq;
    @Inject
    ActionItemPost ar;
    @Inject
    BuyTicketPayViewController as;
    @Inject
    CreateEventPerformanceLogger at;
    @Inject
    DialtoneController au;
    @Inject
    EventAdminStatusRecord av;
    @Inject
    EventCheckinButtonActivityResultHandler aw;
    @Inject
    EventBuyTicketsActivityResultHandler ax;
    @Inject
    EventCheckinButtonController ay;
    @Inject
    EventEventLogger az;
    @Nullable
    private View f17836b;
    public String bA;
    public BoostableStoryModel bB;
    private TtiVia bC;
    public ListenableFuture<Event> bD;
    private ListenableFuture<GraphQLResult<FetchEventPermalinkFragmentModel>> bE;
    public Event bF;
    public Event bG;
    public DataFreshnessResult bH;
    private FadingContentFragmentController bI;
    public boolean bJ;
    private BoostedPostStatusChangedEventSubscriber bK;
    @Inject
    GraphQLNotificationsContentProviderHelper ba;
    @Inject
    GraphQLSubscriptionConnector bb;
    @Inject
    public GraphQLSubscriptionHolder bc;
    @Inject
    Lazy<EventPermalinkStoriesExtractor> bd;
    @Inject
    Lazy<FbErrorReporter> be;
    @Inject
    Lazy<PlacePickerResultHandler> bf;
    @Inject
    @LoggedInUserId
    public Provider<String> bg;
    @Inject
    NotificationStoryHelper bh;
    @Inject
    PageViewerContextForAnEvent bi;
    @Inject
    Provider<ComposerPublishServiceHelper> bj;
    @Inject
    QeAccessor bk;
    @Inject
    QuickPerformanceLogger bl;
    @Inject
    public TasksManager bm;
    @Inject
    AdInterfacesExternalEventBus bn;
    public FetchEventPermalinkFragmentModel bo;
    protected EventAnalyticsParams bp;
    private boolean bq;
    private GraphQLSubscriptionHandle br;
    public int bs;
    public EventPermalinkAdapter bt;
    private final EventUpdatedEventSubscriber bu = new EventUpdatedEventSubscriber(this);
    private final PostEventSubscriber bv = new PostEventSubscriber(this);
    private EventDeletedEventSubscriber bw = new EventDeletedEventSubscriber(this);
    private final RsvpChangeEventSubscriber bx = new RsvpChangeEventSubscriber(this);
    private final EventCanceledEventSubscriber by = new EventCanceledEventSubscriber(this);
    public final EventPermalinkFutureCallback bz = new EventPermalinkFutureCallback(this);
    public ScrollingViewProxy f17837c;
    public SwipeRefreshLayout f17838d;
    @Nullable
    private GenericNotificationBanner f17839e;
    @Nullable
    private FbTextView f17840f;
    private SelfRegistrableReceiverImpl f17841g;
    public FrameRateLogger f17842h;
    public int f17843i;

    /* compiled from: canvas_dwell_time */
    class C25271 implements ActionReceiver {
        final /* synthetic */ EventPermalinkFragment f17868a;

        C25271(EventPermalinkFragment eventPermalinkFragment) {
            this.f17868a = eventPermalinkFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1049877137);
            EventPermalinkFragment.aN(this.f17868a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1336196752, a);
        }
    }

    /* compiled from: canvas_dwell_time */
    public class C25282 {
        final /* synthetic */ EventPermalinkFragment f17869a;

        C25282(EventPermalinkFragment eventPermalinkFragment) {
            this.f17869a = eventPermalinkFragment;
        }

        public final void m18283a() {
            this.f17869a.aX.a(this.f17869a.aA.f17349c);
            this.f17869a.bt.mo829b();
        }
    }

    /* compiled from: canvas_dwell_time */
    class C25293 implements FeedOnDataChangeListener {
        final /* synthetic */ EventPermalinkFragment f17870a;

        C25293(EventPermalinkFragment eventPermalinkFragment) {
            this.f17870a = eventPermalinkFragment;
        }

        public final void m18284c() {
            this.f17870a.bt.mo829b();
        }
    }

    /* compiled from: canvas_dwell_time */
    class C25304 implements FeedOnDataChangeListener {
        final /* synthetic */ EventPermalinkFragment f17871a;

        C25304(EventPermalinkFragment eventPermalinkFragment) {
            this.f17871a = eventPermalinkFragment;
        }

        public final void m18285c() {
            this.f17871a.bt.mo823a(this.f17871a.aV);
            this.f17871a.bt.notifyDataSetChanged();
        }
    }

    /* compiled from: canvas_dwell_time */
    class C25315 extends BoostedPostStatusChangedEventSubscriber {
        final /* synthetic */ EventPermalinkFragment f17872a;

        C25315(EventPermalinkFragment eventPermalinkFragment) {
            this.f17872a = eventPermalinkFragment;
        }

        public final void m18286b(FbEvent fbEvent) {
            BoostedPostStatusChangedEvent boostedPostStatusChangedEvent = (BoostedPostStatusChangedEvent) fbEvent;
            if (this.f17872a.bB != null && boostedPostStatusChangedEvent.a.equals(this.f17872a.bB.m17688b())) {
                EventPermalinkFragment eventPermalinkFragment = this.f17872a;
                Builder builder = new Builder();
                FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = this.f17872a.bo;
                Builder builder2 = new Builder();
                builder2.a = fetchEventPermalinkFragmentModel.r();
                builder2.b = fetchEventPermalinkFragmentModel.ad();
                builder2.c = fetchEventPermalinkFragmentModel.ae();
                builder2.d = fetchEventPermalinkFragmentModel.s();
                builder2.e = fetchEventPermalinkFragmentModel.t();
                builder2.f = fetchEventPermalinkFragmentModel.af();
                builder2.g = fetchEventPermalinkFragmentModel.j();
                builder2.h = fetchEventPermalinkFragmentModel.u();
                builder2.i = fetchEventPermalinkFragmentModel.T();
                builder2.j = fetchEventPermalinkFragmentModel.k();
                builder2.k = fetchEventPermalinkFragmentModel.ag();
                builder2.l = fetchEventPermalinkFragmentModel.ah();
                builder2.m = fetchEventPermalinkFragmentModel.ai();
                builder2.n = fetchEventPermalinkFragmentModel.b();
                builder2.o = fetchEventPermalinkFragmentModel.aj();
                builder2.p = fetchEventPermalinkFragmentModel.ak();
                builder2.q = fetchEventPermalinkFragmentModel.x();
                builder2.r = fetchEventPermalinkFragmentModel.U();
                builder2.s = fetchEventPermalinkFragmentModel.al();
                builder2.t = fetchEventPermalinkFragmentModel.am();
                builder2.u = fetchEventPermalinkFragmentModel.an();
                builder2.v = fetchEventPermalinkFragmentModel.ao();
                builder2.w = fetchEventPermalinkFragmentModel.ap();
                builder2.x = fetchEventPermalinkFragmentModel.aq();
                builder2.y = fetchEventPermalinkFragmentModel.ar();
                builder2.z = fetchEventPermalinkFragmentModel.as();
                builder2.A = fetchEventPermalinkFragmentModel.at();
                builder2.B = fetchEventPermalinkFragmentModel.au();
                builder2.C = fetchEventPermalinkFragmentModel.av();
                builder2.D = fetchEventPermalinkFragmentModel.B();
                builder2.E = fetchEventPermalinkFragmentModel.aw();
                builder2.F = fetchEventPermalinkFragmentModel.ax();
                builder2.G = fetchEventPermalinkFragmentModel.ay();
                builder2.H = fetchEventPermalinkFragmentModel.az();
                builder2.I = fetchEventPermalinkFragmentModel.C();
                builder2.J = fetchEventPermalinkFragmentModel.aA();
                builder2.K = fetchEventPermalinkFragmentModel.aB();
                builder2.L = fetchEventPermalinkFragmentModel.aC();
                builder2.M = fetchEventPermalinkFragmentModel.aD();
                builder2.N = fetchEventPermalinkFragmentModel.aE();
                builder2.O = fetchEventPermalinkFragmentModel.W();
                builder2.P = fetchEventPermalinkFragmentModel.D();
                builder2.Q = fetchEventPermalinkFragmentModel.X();
                builder2.R = fetchEventPermalinkFragmentModel.Y();
                builder2.S = fetchEventPermalinkFragmentModel.aF();
                builder2.T = fetchEventPermalinkFragmentModel.F();
                builder2.U = fetchEventPermalinkFragmentModel.aG();
                builder2.V = fetchEventPermalinkFragmentModel.aH();
                builder2.W = fetchEventPermalinkFragmentModel.aI();
                builder2.X = fetchEventPermalinkFragmentModel.aJ();
                builder2.Y = fetchEventPermalinkFragmentModel.aK();
                builder2.Z = fetchEventPermalinkFragmentModel.dL_();
                builder2.aa = fetchEventPermalinkFragmentModel.g();
                builder2.ab = fetchEventPermalinkFragmentModel.J();
                builder2.ac = fetchEventPermalinkFragmentModel.m();
                builder2.ad = fetchEventPermalinkFragmentModel.Z();
                builder2.ae = fetchEventPermalinkFragmentModel.K();
                builder2.af = fetchEventPermalinkFragmentModel.aL();
                builder2.ag = fetchEventPermalinkFragmentModel.dM_();
                builder2.ah = fetchEventPermalinkFragmentModel.aM();
                builder2.ai = fetchEventPermalinkFragmentModel.aN();
                builder2.aj = fetchEventPermalinkFragmentModel.M();
                builder2.ak = fetchEventPermalinkFragmentModel.aO();
                builder2.al = fetchEventPermalinkFragmentModel.aP();
                builder2.am = fetchEventPermalinkFragmentModel.O();
                builder2.an = fetchEventPermalinkFragmentModel.dN_();
                builder2.ao = fetchEventPermalinkFragmentModel.aQ();
                builder2.ap = fetchEventPermalinkFragmentModel.ab();
                builder2.aq = fetchEventPermalinkFragmentModel.aR();
                builder2.ar = fetchEventPermalinkFragmentModel.n();
                builder2.as = fetchEventPermalinkFragmentModel.o();
                builder2.at = fetchEventPermalinkFragmentModel.p();
                builder2.au = fetchEventPermalinkFragmentModel.Q();
                builder2.av = fetchEventPermalinkFragmentModel.R();
                builder2.aw = fetchEventPermalinkFragmentModel.q();
                builder = builder2;
                builder.I = boostedPostStatusChangedEvent.b;
                eventPermalinkFragment.bo = builder.a();
                this.f17872a.bF = EventGraphQLModelHelper.m19260a(this.f17872a.bo);
                EventPermalinkFragment.m18229h(this.f17872a, false);
            }
        }
    }

    /* compiled from: canvas_dwell_time */
    class C25326 implements OnScrollListener {
        final /* synthetic */ EventPermalinkFragment f17873a;

        C25326(EventPermalinkFragment eventPermalinkFragment) {
            this.f17873a = eventPermalinkFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f17873a.bs == 0 && i > this.f17873a.bs) {
                int paramValue;
                int paramValue2;
                if (this.f17873a.bp == null) {
                    paramValue = ActionSource.UNKNOWN.getParamValue();
                } else {
                    paramValue = this.f17873a.bp.b.e.getParamValue();
                }
                if (this.f17873a.bp == null) {
                    paramValue2 = ActionSource.UNKNOWN.getParamValue();
                } else {
                    paramValue2 = this.f17873a.bp.b.f.getParamValue();
                }
                this.f17873a.az.m18142c(this.f17873a.bA, paramValue, paramValue2);
                this.f17873a.bs = i;
            }
        }
    }

    /* compiled from: canvas_dwell_time */
    public class C25337 implements OnRefreshListener {
        final /* synthetic */ EventPermalinkFragment f17874a;

        public C25337(EventPermalinkFragment eventPermalinkFragment) {
            this.f17874a = eventPermalinkFragment;
        }

        public final void m18287a() {
            this.f17874a.bJ = true;
            EventPermalinkFragment.aG(this.f17874a);
        }
    }

    /* compiled from: canvas_dwell_time */
    public class C25348 implements OnDrawListener {
        final /* synthetic */ EventPermalinkFragment f17875a;

        public C25348(EventPermalinkFragment eventPermalinkFragment) {
            this.f17875a = eventPermalinkFragment;
        }

        public final boolean gD_() {
            boolean z = false;
            if (this.f17875a.bt.isEmpty()) {
                return false;
            }
            if (this.f17875a.bH != null) {
                z = true;
            }
            if (this.f17875a.bG != null) {
                this.f17875a.aH.f18767a.a(393237, "EventPermalinkFragment", null, "EventPermalinkLoadSourceType", "notification_prefetch");
            } else if (z) {
                this.f17875a.aH.f18767a.a(393237, "EventPermalinkFragment", null, "EventPermalinkLoadSourceType", "graphql");
            } else {
                this.f17875a.aH.f18767a.a(393237, "EventPermalinkFragment", null, "EventPermalinkLoadSourceType", "db");
            }
            CreateEventPerformanceLogger createEventPerformanceLogger = this.f17875a.at;
            createEventPerformanceLogger.f16042b.b(createEventPerformanceLogger.f16041a);
            this.f17875a.aI.m19084d(LoadingState.RENDERING);
            this.f17875a.aI.f18772d.b("LoadEventPermalink");
            EventPermalinkFragment.aA(this.f17875a);
            return true;
        }
    }

    /* compiled from: canvas_dwell_time */
    public class C25359 implements ScrollingViewProxy.OnScrollListener {
        final /* synthetic */ EventPermalinkFragment f17876a;

        public C25359(EventPermalinkFragment eventPermalinkFragment) {
            this.f17876a = eventPermalinkFragment;
        }

        public final void m18288a(ScrollingViewProxy scrollingViewProxy, int i) {
            if (this.f17876a.al) {
                if (this.f17876a.f17843i == 0) {
                    this.f17876a.f17842h.a();
                } else if (i == 0 && this.f17876a.f17842h.q) {
                    this.f17876a.f17842h.b();
                }
            }
            this.f17876a.f17843i = i;
        }

        public final void m18289a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            this.f17876a.bt.mo822a(i, i2, i3);
        }
    }

    /* compiled from: canvas_dwell_time */
    class EventCanceledEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventCanceledEventSubscriber {
        final /* synthetic */ EventPermalinkFragment f17877a;

        public EventCanceledEventSubscriber(EventPermalinkFragment eventPermalinkFragment) {
            this.f17877a = eventPermalinkFragment;
        }

        public final void m18290b(FbEvent fbEvent) {
            EventCanceledEvent eventCanceledEvent = (EventCanceledEvent) fbEvent;
            if (!EventPermalinkFragment.aJ(this.f17877a) && eventCanceledEvent.a == EventStatus.SUCCESS) {
                this.f17877a.as();
            }
        }
    }

    /* compiled from: canvas_dwell_time */
    class EventDeletedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventDeletedEventSubscriber {
        final /* synthetic */ EventPermalinkFragment f17878a;

        public EventDeletedEventSubscriber(EventPermalinkFragment eventPermalinkFragment) {
            this.f17878a = eventPermalinkFragment;
        }

        public final void m18291b(FbEvent fbEvent) {
            this.f17878a.o().onBackPressed();
        }
    }

    /* compiled from: canvas_dwell_time */
    class EventPermalinkFutureCallback extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> {
        final /* synthetic */ EventPermalinkFragment f17879a;

        public EventPermalinkFutureCallback(EventPermalinkFragment eventPermalinkFragment) {
            this.f17879a = eventPermalinkFragment;
        }

        protected final void m18292a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (!EventPermalinkFragment.aJ(this.f17879a)) {
                this.f17879a.f17838d.setRefreshing(false);
                EventPermalinkFragment.m18227g(this.f17879a, 8);
                EventPermalinkFragment.m18222a(this.f17879a, graphQLResult, false);
            }
        }

        public final void m18293a(Throwable th) {
            if (!EventPermalinkFragment.aJ(this.f17879a)) {
                EventPermalinkFragment.m18227g(this.f17879a, 8);
                this.f17879a.f17838d.setRefreshing(false);
                this.f17879a.aI.m19081b(LoadingState.NETWORK_FETCH);
                this.f17879a.aI.m19082c();
                if (this.f17879a.bF == null) {
                    this.f17879a.aH.m19069a();
                }
                this.f17879a.m18225b(false);
            }
        }
    }

    /* compiled from: canvas_dwell_time */
    class EventPermalinkGraphQLSubscriptionFutureCallback extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> {
        final /* synthetic */ EventPermalinkFragment f17880a;

        public EventPermalinkGraphQLSubscriptionFutureCallback(EventPermalinkFragment eventPermalinkFragment) {
            this.f17880a = eventPermalinkFragment;
        }

        public final void m18294a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (!EventPermalinkFragment.aJ(this.f17880a)) {
                EventPermalinkFragment.m18222a(this.f17880a, graphQLResult, true);
            }
        }

        public final void m18295a(Throwable th) {
            this.f17880a.bz.m18293a(th);
        }
    }

    /* compiled from: canvas_dwell_time */
    class EventUpdatedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventUpdatedEventSubscriber {
        final /* synthetic */ EventPermalinkFragment f17881a;

        public EventUpdatedEventSubscriber(EventPermalinkFragment eventPermalinkFragment) {
            this.f17881a = eventPermalinkFragment;
        }

        public final void m18296b(FbEvent fbEvent) {
            if (!EventPermalinkFragment.aJ(this.f17881a)) {
                EventPermalinkFragment.aG(this.f17881a);
            }
        }
    }

    /* compiled from: canvas_dwell_time */
    class PostEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.PostEventSubscriber {
        final /* synthetic */ EventPermalinkFragment f17882a;

        public PostEventSubscriber(EventPermalinkFragment eventPermalinkFragment) {
            this.f17882a = eventPermalinkFragment;
        }

        public final void m18297b(FbEvent fbEvent) {
            PostEvent postEvent = (PostEvent) fbEvent;
            if (!EventPermalinkFragment.aJ(this.f17882a)) {
                if (postEvent.a == EventStatus.SENDING) {
                    this.f17882a.bt.mo836g();
                } else if (postEvent.a == EventStatus.SUCCESS) {
                    this.f17882a.as();
                } else if (postEvent.a == EventStatus.FAILURE) {
                    this.f17882a.bt.mo834e();
                    EventPermalinkFragment.m18221a(this.f17882a, NotificationBannerType.COMMENT_POST_FAILED);
                }
            }
        }
    }

    /* compiled from: canvas_dwell_time */
    class RsvpChangeEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.RsvpChangeEventSubscriber {
        final /* synthetic */ EventPermalinkFragment f17883a;

        public RsvpChangeEventSubscriber(EventPermalinkFragment eventPermalinkFragment) {
            this.f17883a = eventPermalinkFragment;
        }

        public final void m18298b(FbEvent fbEvent) {
            RsvpChangeEvent rsvpChangeEvent = (RsvpChangeEvent) fbEvent;
            if (!EventPermalinkFragment.aJ(this.f17883a)) {
                if (rsvpChangeEvent.a == EventStatus.SENDING) {
                    this.f17883a.bt.mo828a(false, true);
                } else if (rsvpChangeEvent.a == EventStatus.SUCCESS) {
                    EventPermalinkFragment.aG(this.f17883a);
                } else if (rsvpChangeEvent.a == EventStatus.FAILURE) {
                    this.f17883a.bt.mo828a(true, false);
                }
            }
        }
    }

    /* compiled from: canvas_dwell_time */
    public enum Tasks {
        FETCH_PERMALINK_GRAPHQL,
        FETCH_EVENT_FROM_DB,
        FETCH_PERMALINK_STORIES_GRAPHQL
    }

    public static void m18224a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventPermalinkFragment) obj).m18223a((FeedLifecycleSubscribers) MultiRowFeedLifecycleSubscribers.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), Boolean_IsTabletMethodAutoProvider.a(injectorLike), ActionItemInvite.m18355a(injectorLike), ActionItemPost.m18372a(injectorLike), BuyTicketPayViewController.m19301a(injectorLike), CreateEventPerformanceLogger.m16442a(injectorLike), (DialtoneController) DialtoneControllerImpl.a(injectorLike), EventAdminStatusRecord.a(injectorLike), EventCheckinButtonActivityResultHandler.m18640a(injectorLike), EventBuyTicketsActivityResultHandler.m19305a(injectorLike), EventCheckinButtonController.m18641a(injectorLike), EventEventLogger.m18116a(injectorLike), EventFeedPager.m17667a(injectorLike), EventFeedPagerProtocol.m17677a(injectorLike), EventGraphQLModelHelper.m19271a(injectorLike), EventPermalinkBazingaHelper.a(injectorLike), EventPermalinkEarlyFetcher.m18274a(injectorLike), (EventPermalinkListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventPermalinkListAdapterProvider.class), EventPermalinkModelFetcher.m19101a(injectorLike), EventPermalinkPerformanceLogger.m19067a(injectorLike), EventPermalinkSequenceLogger.m19070a(injectorLike), EventStoriesQueryParamHelper.m17799a(injectorLike), EventsCommonContract.a(injectorLike), EventsConnectionExperimentController.a(injectorLike), EventsEventBus.a(injectorLike), FbNetworkManager.a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), FeedDeletePostController.a(injectorLike), FeedLikeController.a(injectorLike), FeedLikeController.a(injectorLike), FeedSetNotifyMeController.a(injectorLike), FeedSetNotifyMeController.a(injectorLike), FeedStoryVisibilityController.a(injectorLike), FeedUnitCollection.a(injectorLike), FeedUnitMutationController.a(injectorLike), FeedUnitSubscriber.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphQLNotificationsContentProviderHelper.a(injectorLike), GraphQLSubscriptionConnector.a(injectorLike), GraphQLSubscriptionHolder.a(injectorLike), IdBasedLazy.a(injectorLike, 5602), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 2998), IdBasedProvider.a(injectorLike, 4442), NotificationStoryHelper.a(injectorLike), PageViewerContextForAnEvent.m19058a(injectorLike), IdBasedProvider.a(injectorLike, 5272), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), TasksManager.a(injectorLike), AdInterfacesExternalEventBus.a(injectorLike));
    }

    private void m18223a(FeedLifecycleSubscribers feedLifecycleSubscribers, ListeningExecutorService listeningExecutorService, Boolean bool, ActionItemInvite actionItemInvite, ActionItemPost actionItemPost, BuyTicketPayViewController buyTicketPayViewController, CreateEventPerformanceLogger createEventPerformanceLogger, DialtoneController dialtoneController, EventAdminStatusRecord eventAdminStatusRecord, EventCheckinButtonActivityResultHandler eventCheckinButtonActivityResultHandler, EventBuyTicketsActivityResultHandler eventBuyTicketsActivityResultHandler, EventCheckinButtonController eventCheckinButtonController, EventEventLogger eventEventLogger, EventFeedPager eventFeedPager, EventFeedPagerProtocol eventFeedPagerProtocol, EventGraphQLModelHelper eventGraphQLModelHelper, EventPermalinkBazingaHelper eventPermalinkBazingaHelper, EventPermalinkEarlyFetcher eventPermalinkEarlyFetcher, EventPermalinkListAdapterProvider eventPermalinkListAdapterProvider, EventPermalinkModelFetcher eventPermalinkModelFetcher, EventPermalinkPerformanceLogger eventPermalinkPerformanceLogger, EventPermalinkSequenceLogger eventPermalinkSequenceLogger, EventStoriesQueryParamHelper eventStoriesQueryParamHelper, EventsCommonContract eventsCommonContract, EventsConnectionExperimentController eventsConnectionExperimentController, EventsEventBus eventsEventBus, FbNetworkManager fbNetworkManager, FbTitleBarSupplier fbTitleBarSupplier, FeedDeletePostController feedDeletePostController, FeedLikeController feedLikeController, FeedLikeController feedLikeController2, FeedSetNotifyMeController feedSetNotifyMeController, FeedSetNotifyMeController feedSetNotifyMeController2, FeedStoryVisibilityController feedStoryVisibilityController, FeedUnitCollection feedUnitCollection, FeedUnitMutationController feedUnitMutationController, FeedUnitSubscriber feedUnitSubscriber, FrameRateLoggerProvider frameRateLoggerProvider, GatekeeperStore gatekeeperStore, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, GraphQLSubscriptionConnector graphQLSubscriptionConnector, GraphQLSubscriptionHolder graphQLSubscriptionHolder, Lazy<EventPermalinkStoriesExtractor> lazy, Lazy<FbErrorReporter> lazy2, Lazy<PlacePickerResultHandler> lazy3, Provider<String> provider, NotificationStoryHelper notificationStoryHelper, PageViewerContextForAnEvent pageViewerContextForAnEvent, Provider<ComposerPublishServiceHelper> provider2, QeAccessor qeAccessor, QuickPerformanceLogger quickPerformanceLogger, TasksManager tasksManager, AdInterfacesExternalEventBus adInterfacesExternalEventBus) {
        this.an = feedLifecycleSubscribers;
        this.ao = listeningExecutorService;
        this.ap = bool;
        this.aq = actionItemInvite;
        this.ar = actionItemPost;
        this.as = buyTicketPayViewController;
        this.at = createEventPerformanceLogger;
        this.au = dialtoneController;
        this.av = eventAdminStatusRecord;
        this.aw = eventCheckinButtonActivityResultHandler;
        this.ax = eventBuyTicketsActivityResultHandler;
        this.ay = eventCheckinButtonController;
        this.az = eventEventLogger;
        this.aA = eventFeedPager;
        this.aB = eventFeedPagerProtocol;
        this.aC = eventGraphQLModelHelper;
        this.aD = eventPermalinkBazingaHelper;
        this.aE = eventPermalinkEarlyFetcher;
        this.aF = eventPermalinkListAdapterProvider;
        this.aG = eventPermalinkModelFetcher;
        this.aH = eventPermalinkPerformanceLogger;
        this.aI = eventPermalinkSequenceLogger;
        this.aJ = eventStoriesQueryParamHelper;
        this.aK = eventsCommonContract;
        this.aL = eventsConnectionExperimentController;
        this.aM = eventsEventBus;
        this.aN = fbNetworkManager;
        this.aO = fbTitleBarSupplier;
        this.aP = feedDeletePostController;
        this.aQ = feedLikeController;
        this.aR = feedLikeController2;
        this.aS = feedSetNotifyMeController;
        this.aT = feedSetNotifyMeController2;
        this.aU = feedStoryVisibilityController;
        this.aV = feedUnitCollection;
        this.aW = feedUnitMutationController;
        this.aX = feedUnitSubscriber;
        this.aY = frameRateLoggerProvider;
        this.aZ = gatekeeperStore;
        this.ba = graphQLNotificationsContentProviderHelper;
        this.bb = graphQLSubscriptionConnector;
        this.bc = graphQLSubscriptionHolder;
        this.bd = lazy;
        this.be = lazy2;
        this.bf = lazy3;
        this.bg = provider;
        this.bh = notificationStoryHelper;
        this.bi = pageViewerContextForAnEvent;
        this.bj = provider2;
        this.bk = qeAccessor;
        this.bl = quickPerformanceLogger;
        this.bm = tasksManager;
        this.bn = adInterfacesExternalEventBus;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        if (!z) {
            this.bt.notifyDataSetChanged();
        }
    }

    public void mo814c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = EventPermalinkFragment.class;
        m18224a((Object) this, getContext());
        EventPermalinkPerformanceLogger eventPermalinkPerformanceLogger = this.aH;
        String ay = ay();
        MarkerConfig markerConfig = new MarkerConfig(393237, "EventPermalinkFragment");
        markerConfig.l = ImmutableBiMap.b("navigation_source", ay);
        markerConfig = markerConfig.a(new String[]{"event_permalink"});
        markerConfig.n = true;
        eventPermalinkPerformanceLogger.f18767a.c(markerConfig);
        this.bl.b(393238);
        this.aI.m19080a(ay());
        this.al = this.aZ.a(643, false);
        this.f17842h = this.aY.a(Boolean.valueOf(false), "events_permalink_scroll", Absent.INSTANCE);
        Bundle bundle2 = this.s;
        this.bA = bundle2.getString("event_id");
        this.au.a(this);
        Event n = m18230n(bundle2);
        if (n != null) {
            this.bG = n;
        } else {
            this.bD = m18217a(this.aK.c(this.bA));
        }
        this.bE = (ListenableFuture) this.aE.b(this.bA);
        if (this.bE == null) {
            this.bE = mo809a(this.bA);
        } else {
            this.aI.m19078a(LoadingState.EARLY_FETCH, this.aI.m19076a(LoadingState.EARLY_FETCH) + this.aE.d());
            this.aI.m19076a(LoadingState.NETWORK_FETCH);
        }
        this.bp = new EventAnalyticsParams(aS(), ay(), az(), am_(), bundle2.getString("tracking_codes"));
        this.aq.f17957a = this.bp;
        this.as.f19081b = this.bp;
        this.ar.f17977a = this;
        this.bt = mo815e();
        if (this.bA != null) {
            this.ar.m18374d();
        }
        this.f17841g = new LocalFbBroadcastManager(ao()).a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C25271(this)).a();
        this.f17841g.b();
        av();
        aw();
    }

    private void au() {
        if (this.aZ.a(568, false)) {
            EventRsvpSubscribeInputData a = new EventRsvpSubscribeInputData().a(at());
            EventRsvpSubscriptionString p = EventsMutations.p();
            p.a("input", a);
            try {
                this.br = this.bb.a(p);
            } catch (GraphQLSubscriptionConnectorException e) {
            }
        }
    }

    protected EventPermalinkAdapter mo815e() {
        return this.aF.m18574a(this.aA, this.ar, this.aq, this.bp, this, getContext(), this.ay);
    }

    private void av() {
        FeedType feedType = new FeedType(this.bA, Name.n);
        EventFeedPagerProtocol eventFeedPagerProtocol = this.aB;
        eventFeedPagerProtocol.f17369e = feedType;
        eventFeedPagerProtocol.f17368d = 10;
        eventFeedPagerProtocol.f17370f = new FeedFetchContext((String) feedType.f, null);
        EventFeedPager eventFeedPager = this.aA;
        eventFeedPagerProtocol = this.aB;
        C25282 c25282 = new C25282(this);
        eventFeedPager.f17358l = (EventFeedPagerProtocol) Preconditions.checkNotNull(eventFeedPagerProtocol);
        eventFeedPager.f17359m = (C25282) Preconditions.checkNotNull(c25282);
        eventFeedPager.f17360n = new EventLoggerWithCount(eventFeedPager.f17348b, LoadingState.CACHED_STORIES_INITIAL_FETCH);
        eventFeedPager.f17361o = new EventLoggerWithCount(eventFeedPager.f17348b, LoadingState.FRESH_STORIES_INITIAL_FETCH);
    }

    private void aw() {
        FeedUnitCollection feedUnitCollection = this.aA.f17349c;
        C25293 c25293 = new C25293(this);
        this.aQ.a(feedUnitCollection.a, c25293);
        this.aS.a(feedUnitCollection.a, c25293);
        this.aP.a(feedUnitCollection.a, c25293);
        this.aU.a(feedUnitCollection.a, c25293);
        this.aW.a(feedUnitCollection.a, c25293);
        this.aX.a(feedUnitCollection, c25293);
    }

    private Event m18230n(Bundle bundle) {
        if (!bundle.containsKey("story_cache_id")) {
            return null;
        }
        GraphQLStory c = this.ba.c(bundle.getString("story_cache_id"));
        if (c == null) {
            return null;
        }
        GraphQLNode z;
        NotificationStoryHelper notificationStoryHelper = this.bh;
        Preconditions.checkNotNull(c);
        GraphQLStoryAttachment e = NotificationStoryHelper.e(c);
        if (e != null) {
            z = e.z();
        } else {
            z = null;
        }
        GraphQLNode graphQLNode = z;
        if (graphQLNode == null || graphQLNode.cg() == null || graphQLNode.cp() == null) {
            return null;
        }
        return EventGraphQLModelHelper.m19278b(graphQLNode);
    }

    public View mo808a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -399280166);
        this.aI.m19076a(LoadingState.CREATE_VIEW);
        View inflate = layoutInflater.inflate(2130904073, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -585360300, a);
        return inflate;
    }

    public final void m18236a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f17835a = (ViewGroup) e(2131561341);
        this.f17837c = aq();
        this.f17838d = (SwipeRefreshLayout) e(2131561342);
        this.bt.mo827a(this.f17837c);
        this.f17837c.d(true);
        this.f17837c.k();
        this.f17838d.e = new C25337(this);
        this.f17837c.b(new C25348(this));
        this.f17843i = 0;
        this.f17837c.b(new C25359(this));
        C25304 c25304 = new C25304(this);
        this.aR.a(this.aV.a, c25304);
        this.aT.a(this.aV.a, c25304);
        this.aM.a(this.bu);
        this.aM.a(this.bv);
        this.aM.a(this.bw);
        this.aM.a(this.bx);
        this.aM.a(this.by);
        this.aI.m19084d(LoadingState.CREATE_VIEW);
        this.aI.m19076a(LoadingState.RENDERING);
        if (this.bG != null) {
            m18219a(TtiVia.NOTIFICATION_PREFETCH);
            this.bF = this.bG;
            m18229h(this, true);
        } else if (this.bD != null) {
            if (this.bD.isDone() || this.bD.isCancelled()) {
                m18220a(this, (Event) FutureUtils.a(this.bD));
            } else {
                this.bm.a(Tasks.FETCH_EVENT_FROM_DB, this.bD, new AbstractDisposableFutureCallback<Event>(this) {
                    final /* synthetic */ EventPermalinkFragment f17862a;

                    {
                        this.f17862a = r1;
                    }

                    protected final void m18279a(Object obj) {
                        EventPermalinkFragment.m18220a(this.f17862a, (Event) obj);
                    }

                    protected final void m18280a(Throwable th) {
                        this.f17862a.aI.m19084d(LoadingState.DB_FETCH);
                        EventPermalinkFragment.aA(this.f17862a);
                    }
                });
            }
            if (this.bF == null) {
                m18227g(this, 0);
            }
            this.bD = null;
        }
        this.bt.mo831b(this.f17837c);
        if (!(this.aO.get() == null || this.ap.booleanValue() || this.bq)) {
            ax();
        }
        if (!(this.bk.a(ExperimentsForEventsGatingModule.g, false) || this.bk.a(ExperimentsForEventsGatingModule.f, false) || this.bk.a(ExperimentsForEventsGatingModule.h, false))) {
            this.aA.m17673b();
        }
        this.bK = new C25315(this);
        this.bn.a(this.bK);
    }

    private boolean aT() {
        if (!this.s.containsKey("extra_launch_uri")) {
            return false;
        }
        return "notifications_view".equals(Uri.parse(this.s.getString("extra_launch_uri")).getQueryParameter("ref"));
    }

    private String ay() {
        ReactionAnalyticsParams reactionAnalyticsParams = (ReactionAnalyticsParams) this.s.getParcelable("extra_reaction_analytics_params");
        if (reactionAnalyticsParams != null && !StringUtil.a(reactionAnalyticsParams.c)) {
            return reactionAnalyticsParams.c;
        }
        String string = this.s.getString("extra_ref_module");
        String str = "unknown";
        if ((string == null || str.equalsIgnoreCase(string)) && aT()) {
            return "push_notifications_tray";
        }
        return string == null ? str : string;
    }

    private String az() {
        ReactionAnalyticsParams reactionAnalyticsParams = (ReactionAnalyticsParams) this.s.getParcelable("extra_reaction_analytics_params");
        if (reactionAnalyticsParams != null && !StringUtil.a(reactionAnalyticsParams.d)) {
            return reactionAnalyticsParams.d;
        }
        String string = this.s.getString("event_ref_mechanism");
        return StringUtil.a(string) ? "unknown" : string;
    }

    private void ax() {
        FbTitleBar fbTitleBar = (FbTitleBar) this.aO.get();
        if (fbTitleBar instanceof Fb4aTitleBar) {
            ((Fb4aTitleBar) fbTitleBar).setSearchButtonVisible(false);
        }
        FadingTitlebarContent fadingTitlebarContent = (FadingTitlebarContent) a(FadingTitlebarContent.class);
        if (this.bI == null && fadingTitlebarContent != null) {
            this.bI = new FadingContentFragmentController();
            this.bI.a(this, (FadingFbTitleBar) fbTitleBar, this.f17837c, fadingTitlebarContent, true, false);
        }
    }

    protected ScrollingViewProxy aq() {
        BetterListView betterListView = (BetterListView) e(2131559373);
        betterListView.a(new C25326(this));
        return new ListViewProxy(betterListView);
    }

    public static void aA(EventPermalinkFragment eventPermalinkFragment) {
        if (eventPermalinkFragment.bE != null) {
            eventPermalinkFragment.bm.a(Tasks.FETCH_PERMALINK_GRAPHQL, eventPermalinkFragment.bE, eventPermalinkFragment.bz);
            eventPermalinkFragment.bE = null;
        }
    }

    private void m18219a(TtiVia ttiVia) {
        if (this.bC == null) {
            this.bC = ttiVia;
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -792430515);
        super.mi_();
        aE();
        aF();
        au();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -794818663, a);
    }

    private void aE() {
        if (this.aO.get() != null) {
            if (this.bF == null || StringUtil.a(this.bF.b)) {
                ((FbTitleBar) this.aO.get()).setTitle(2131236988);
            } else {
                ((FbTitleBar) this.aO.get()).setTitle(this.bF.b);
            }
        }
    }

    private void aF() {
        if (this.bo != null && !this.bm.a(Tasks.FETCH_PERMALINK_STORIES_GRAPHQL)) {
            GraphQLStory d = this.bt.mo833d();
            if (d == null && this.av.e(this.bA)) {
                aK();
            } else if (d != null && !this.av.b(d.c(), this.bA)) {
                aK();
            }
        }
    }

    public static void m18222a(EventPermalinkFragment eventPermalinkFragment, GraphQLResult graphQLResult, boolean z) {
        FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) graphQLResult.e;
        if (fetchEventPermalinkFragmentModel != null) {
            eventPermalinkFragment.m18219a(TtiVia.GRAPHQL);
            eventPermalinkFragment.aI.m19084d(LoadingState.NETWORK_FETCH);
            eventPermalinkFragment.m18228h(8);
            eventPermalinkFragment.f17837c.a(0);
            String str = eventPermalinkFragment.bA;
            if (!(1 == 0 || eventPermalinkFragment.bc.a(str))) {
                eventPermalinkFragment.bc.a(new EventPermalinkGraphQLSubscriptionFutureCallback(eventPermalinkFragment), str, graphQLResult);
            }
            DataFreshnessResult dataFreshnessResult = graphQLResult.freshness;
            eventPermalinkFragment.bo = fetchEventPermalinkFragmentModel;
            eventPermalinkFragment.bH = dataFreshnessResult;
            eventPermalinkFragment.bF = EventGraphQLModelHelper.m19260a(eventPermalinkFragment.bo);
            EventsProvider.a(eventPermalinkFragment.getContext().getContentResolver(), eventPermalinkFragment.aK, eventPermalinkFragment.bF, eventPermalinkFragment.ao);
            m18229h(eventPermalinkFragment, z);
            if (fetchEventPermalinkFragmentModel.aF() == null) {
                return;
            }
            if (fetchEventPermalinkFragmentModel.aF().o()) {
                eventPermalinkFragment.av.a(fetchEventPermalinkFragmentModel.dL_());
                return;
            } else {
                eventPermalinkFragment.av.b(fetchEventPermalinkFragmentModel.dL_());
                return;
            }
        }
        eventPermalinkFragment.m18225b(true);
        eventPermalinkFragment.aH.m19069a();
        eventPermalinkFragment.aI.m19083c(LoadingState.NETWORK_FETCH);
    }

    public static void m18220a(@Nullable EventPermalinkFragment eventPermalinkFragment, Event event) {
        eventPermalinkFragment.aI.m19084d(LoadingState.DB_FETCH);
        if (event != null) {
            eventPermalinkFragment.m18219a(TtiVia.DB_FETCH);
        }
        if (event == null) {
            aA(eventPermalinkFragment);
            return;
        }
        eventPermalinkFragment.bF = event;
        m18229h(eventPermalinkFragment, true);
    }

    private void aI() {
        if (ar()) {
            this.bt.notifyDataSetChanged();
        }
    }

    protected boolean ar() {
        return (this.f17837c == null || this.f17837c.o() == null) ? false : true;
    }

    private void m18225b(boolean z) {
        if (z) {
            final String str = this.bA;
            if (!this.bA.equals(am)) {
                ExecutorDetour.a(this.ao, new Runnable(this) {
                    final /* synthetic */ EventPermalinkFragment f17864b;

                    public void run() {
                        this.f17864b.getContext().getContentResolver().delete(this.f17864b.aK.c(str), null, null);
                    }
                }, -90550614);
            }
            m18228h(0);
            this.f17837c.a(8);
            if (this.f17840f != null) {
                this.f17840f.setText(2131237120);
            }
        } else if (this.bF != null) {
            if (this.aN.d()) {
                m18221a(this, NotificationBannerType.FETCH_EVENT_FAILED);
            }
            this.bt.mo832c();
            m18228h(8);
            this.f17837c.a(0);
        } else {
            m18228h(0);
            this.f17837c.a(8);
            if (this.f17840f != null) {
                this.f17840f.setText(2131237120);
            }
        }
    }

    private ListenableFuture<GraphQLResult<FetchEventPermalinkFragmentModel>> mo809a(String str) {
        this.aI.m19076a(LoadingState.NETWORK_FETCH);
        return this.aG.m19103a(getContext(), str);
    }

    public static boolean aJ(EventPermalinkFragment eventPermalinkFragment) {
        return eventPermalinkFragment.f17837c == null;
    }

    public static void aG(EventPermalinkFragment eventPermalinkFragment) {
        eventPermalinkFragment.bm.a(Tasks.FETCH_PERMALINK_GRAPHQL, eventPermalinkFragment.mo809a(eventPermalinkFragment.bA), eventPermalinkFragment.bz);
    }

    private void aK() {
        if (!Objects.equal(this.bA, am)) {
            boolean z;
            TypedGraphQlQueryString eventPinnedPostAndRecentStoryQueryString = new EventPinnedPostAndRecentStoryQueryString();
            eventPinnedPostAndRecentStoryQueryString.a("event_id", this.bA);
            String str = "fetch_creation_story";
            if (this.bF == null || !(this.bF.a(EventViewerCapability.PROMOTE) || this.bF.a(EventViewerCapability.EDIT_PROMOTION))) {
                z = false;
            } else {
                z = true;
            }
            eventPinnedPostAndRecentStoryQueryString.a(str, Boolean.valueOf(z));
            this.aJ.m17801a(eventPinnedPostAndRecentStoryQueryString);
            AnonymousClass12 anonymousClass12 = new AbstractDisposableFutureCallback<GraphQLResult<EventPinnedPostAndRecentStoryFragmentModel>>(this) {
                final /* synthetic */ EventPermalinkFragment f17865a;

                {
                    this.f17865a = r1;
                }

                protected final void m18281a(Object obj) {
                    EventPinnedPostAndRecentStoryFragmentModel eventPinnedPostAndRecentStoryFragmentModel = (EventPinnedPostAndRecentStoryFragmentModel) ((GraphQLResult) obj).e;
                    if (eventPinnedPostAndRecentStoryFragmentModel == null) {
                        m18282a(new NullPointerException("GraphQL returned null model for event : " + this.f17865a.bA));
                        return;
                    }
                    GraphQLFeedUnitEdge a = ((EventPermalinkStoriesExtractor) this.f17865a.bd.get()).m17797a(eventPinnedPostAndRecentStoryFragmentModel);
                    GraphQLFeedUnitEdge b = ((EventPermalinkStoriesExtractor) this.f17865a.bd.get()).m17798b(eventPinnedPostAndRecentStoryFragmentModel);
                    EventCreatorModel j = eventPinnedPostAndRecentStoryFragmentModel.m17738j();
                    if (j != null) {
                        AdminInfoModel a2 = j.m17702a();
                        if (a2 != null && a2.m17696a()) {
                            this.f17865a.bB = eventPinnedPostAndRecentStoryFragmentModel.m17734a();
                            if (this.f17865a.bB != null) {
                                this.f17865a.bt.mo824a(this.f17865a.bB);
                            }
                        }
                    }
                    this.f17865a.m18237a(a, b);
                }

                protected final void m18282a(Throwable th) {
                    ((AbstractFbErrorReporter) this.f17865a.be.get()).a(EventPermalinkFragment.class.getSimpleName(), th);
                }
            };
            this.bm.a(Tasks.FETCH_PERMALINK_STORIES_GRAPHQL, this.bc.a(GraphQLRequest.a(eventPinnedPostAndRecentStoryQueryString).a(GraphQLCachePolicy.d), anonymousClass12, "posts"), anonymousClass12);
        }
        if (!this.L) {
            this.aA.m17672a(this.bJ);
            this.bJ = false;
        }
    }

    protected final String at() {
        return this.bA;
    }

    public final Map<String, Object> m18238c() {
        return EventEventLogger.m18117a((Object) this.bA);
    }

    public final void m18237a(@Nullable GraphQLFeedUnitEdge graphQLFeedUnitEdge, @Nullable GraphQLFeedUnitEdge graphQLFeedUnitEdge2) {
        if (graphQLFeedUnitEdge != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLFeedUnitEdge.n();
            Preconditions.checkNotNull(graphQLStory);
            this.bt.mo826a(graphQLStory);
            this.av.a(graphQLStory.c(), this.bA);
        } else {
            this.bt.mo826a(null);
            this.av.d(this.bA);
        }
        if (graphQLFeedUnitEdge2 != null) {
            graphQLStory = (GraphQLStory) graphQLFeedUnitEdge2.n();
            Preconditions.checkNotNull(graphQLStory);
            this.bt.mo830b(graphQLStory);
        } else {
            this.bt.mo830b(null);
        }
        this.aV.m();
        if (graphQLFeedUnitEdge != null) {
            this.aV.b(graphQLFeedUnitEdge);
        }
        if (graphQLFeedUnitEdge2 != null) {
            this.aV.b(graphQLFeedUnitEdge2);
        }
        aI();
    }

    public static void aN(EventPermalinkFragment eventPermalinkFragment) {
        if (!aJ(eventPermalinkFragment)) {
            if (eventPermalinkFragment.aN.d()) {
                eventPermalinkFragment.m18228h(8);
                if (eventPermalinkFragment.bF == null) {
                    m18227g(eventPermalinkFragment, 0);
                }
                if (eventPermalinkFragment.bo == null) {
                    aG(eventPermalinkFragment);
                }
            } else {
                m18227g(eventPermalinkFragment, 8);
                if (eventPermalinkFragment.bF == null) {
                    eventPermalinkFragment.m18228h(0);
                }
            }
            eventPermalinkFragment.aO();
        }
    }

    private void aO() {
        this.bt.mo828a(this.aN.d(), false);
    }

    public final void m18231G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1672398679);
        super.G();
        this.an.a();
        aR();
        this.aX.d();
        this.bt.mo829b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -31819392, a);
    }

    public final void m18232H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1725479963);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1167904249, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1915674884);
        super.mj_();
        for (Object c : Tasks.values()) {
            this.bm.c(c);
        }
        if (this.br != null) {
            this.bb.a(Collections.singleton(this.br));
            this.br = null;
        }
        LogUtils.f(91531009, a);
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 844121084);
        this.aH.f18767a.a(393237, "EventPermalinkFragment");
        this.bl.d(393238);
        CreateEventPerformanceLogger createEventPerformanceLogger = this.at;
        createEventPerformanceLogger.f16042b.f(createEventPerformanceLogger.f16041a);
        this.aI.m19082c();
        this.f17837c = null;
        this.f17836b = null;
        this.f17839e = null;
        this.f17840f = null;
        if (this.f17838d != null) {
            this.f17838d.e = null;
            this.f17838d = null;
        }
        super.mY_();
        this.bn.b(this.bK);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1467985909, a);
    }

    public void mo807I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2013839080);
        this.bc.a();
        if (this.aM != null) {
            this.aM.b(this.bx);
            this.aM.b(this.bw);
            this.aM.b(this.bu);
            this.aM.b(this.bv);
            this.aM.b(this.by);
        }
        if (this.f17841g != null) {
            this.f17841g.c();
        }
        if (this.aR != null) {
            this.aR.a();
        }
        if (this.aT != null) {
            this.aT.a();
        }
        this.aQ.a();
        this.aS.a();
        this.aP.a();
        this.aU.a();
        this.aW.a();
        this.aX.e();
        EventFeedPager eventFeedPager = this.aA;
        EventFeedPager.m17670l(eventFeedPager);
        eventFeedPager.f17351e.a(eventFeedPager.f17353g);
        this.au.b(this);
        this.bt.mo835f();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 494108554, a);
    }

    public void mo810a(int i, int i2, Intent intent) {
        if (i == 501) {
            this.aq.m18366a(i, i2, intent);
        } else if (i == 502 || i == 503) {
            ActionItemPost actionItemPost = this.ar;
            if (i2 == -1 && ((i == 502 || i == 503) && intent != null)) {
                if (intent.getBooleanExtra("is_uploading_media", false)) {
                    actionItemPost.f17981e.c(intent);
                } else {
                    C25464 c25464 = new C25464(actionItemPost, i);
                    if (i == 502) {
                        actionItemPost.f17985i.a(new PostEvent(EventStatus.SENDING));
                    }
                    actionItemPost.f17984h.a("EVENT_POST_TASK", actionItemPost.f17981e.c(intent), c25464);
                }
            }
            if (i == 502 && i2 == -1) {
                if (!(this.bF == null || !this.bF.j || this.bF.a((String) this.bg.get()))) {
                    new FbAlertDialogBuilder(getContext()).a(2131237259).b(2131237260).a(2131230726, new OnClickListener(this) {
                        final /* synthetic */ EventPermalinkFragment f17867a;

                        {
                            this.f17867a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).b();
                }
            }
        } else if (i == 504 && i2 == -1) {
            EventCheckinButtonActivityResultHandler eventCheckinButtonActivityResultHandler = this.aw;
            String str = this.bA;
            if (!(intent == null || intent.getBooleanExtra("is_uploading_media", false))) {
                eventCheckinButtonActivityResultHandler.f18284c.a(new PostEvent(EventStatus.SENDING));
                eventCheckinButtonActivityResultHandler.f18282a.a(eventCheckinButtonActivityResultHandler.f18283b.a(intent, new CheckPublishLogger(str, eventCheckinButtonActivityResultHandler.f18285d)), new C25881(eventCheckinButtonActivityResultHandler));
            }
        } else if (i == 506) {
            EventBuyTicketsActivityResultHandler eventBuyTicketsActivityResultHandler = this.ax;
            Context context = getContext();
            if (i2 == -1) {
                eventBuyTicketsActivityResultHandler.f19084a.a("1108149012540875", context);
            } else if (i2 == 0) {
                eventBuyTicketsActivityResultHandler.f19084a.a("1728416894039899", context);
            }
        } else if ((i == 1756 || i == 1758) && i2 == -1) {
            ((ComposerPublishServiceHelper) this.bj.get()).c(intent);
        } else if (i == 5002 && i2 == -1) {
            ((PlacePickerResultHandler) this.bf.get()).a(intent);
        } else if (i2 == -1 && i == 111) {
            switch (intent.getIntExtra("extra_event_cancel_state", 0)) {
                case 2:
                    this.aM.a(new EventDeletedEvent(this.bF.a));
                    ExecutorDetour.a(this.ao, new Runnable(this) {
                        final /* synthetic */ EventPermalinkFragment f17866a;

                        {
                            this.f17866a = r1;
                        }

                        public void run() {
                            this.f17866a.getContext().getContentResolver().delete(this.f17866a.aK.c(this.f17866a.bF.a), null, null);
                        }
                    }, -1989921550);
                    return;
                default:
                    return;
            }
        } else {
            super.a(i, i2, intent);
        }
    }

    private ListenableFuture<Event> m18217a(Uri uri) {
        this.aI.m19076a(LoadingState.DB_FETCH);
        EventPermalinkModelFetcher eventPermalinkModelFetcher = this.aG;
        return eventPermalinkModelFetcher.f18798b.a(new C26701(eventPermalinkModelFetcher, getContext(), uri));
    }

    public static void m18229h(EventPermalinkFragment eventPermalinkFragment, boolean z) {
        eventPermalinkFragment.aR();
        eventPermalinkFragment.aE();
        eventPermalinkFragment.bt.mo825a(eventPermalinkFragment.bF, eventPermalinkFragment.bo);
        eventPermalinkFragment.aI();
        PageViewerContextForAnEvent pageViewerContextForAnEvent = eventPermalinkFragment.bi;
        Event event = eventPermalinkFragment.bF;
        if (!Objects.equal(event.v, pageViewerContextForAnEvent.f18756d)) {
            pageViewerContextForAnEvent.f18756d = event.v;
            if (!(pageViewerContextForAnEvent.f18756d == null || 1 == 0)) {
                pageViewerContextForAnEvent.f18755c.a(pageViewerContextForAnEvent.f18756d, new BaseViewerContextWaiter(), pageViewerContextForAnEvent.f18753a);
            }
        }
        eventPermalinkFragment.ar.f17987k = eventPermalinkFragment.bF;
        if (!(eventPermalinkFragment.bo == null || z)) {
            eventPermalinkFragment.as();
        }
        eventPermalinkFragment.aO();
    }

    protected void as() {
        if (!this.aA.m17676g()) {
            aK();
        } else if (this.bk.a(ExperimentsForEventsGatingModule.g, false)) {
            this.aA.m17673b();
        } else if (this.bo == null || this.bo.k() == GraphQLConnectionStyle.RSVP) {
            this.aA.m17673b();
        } else if (!(this.bk.a(ExperimentsForEventsGatingModule.f, false) || this.bk.a(ExperimentsForEventsGatingModule.h, false))) {
            this.aA.m17673b();
        }
        this.bt.mo834e();
    }

    private void aR() {
        String str = null;
        if (this.y && this.bF != null) {
            int paramValue;
            String str2;
            if (this.bp == null) {
                paramValue = ActionSource.UNKNOWN.getParamValue();
            } else {
                paramValue = this.bp.b.f.getParamValue();
            }
            if (this.bp != null) {
                str2 = this.bp.e;
                if (StringUtil.a(str2) && this.bp.b.h != null) {
                    str2 = this.bp.b.h.toString();
                }
            } else {
                str2 = null;
            }
            EventEventLogger eventEventLogger = this.az;
            String str3 = this.bA;
            String ay = ay();
            if (this.bp != null) {
                str = this.bp.f;
            }
            eventEventLogger.m18133a(str3, ay, str2, paramValue, str);
        }
    }

    private EventActionContext aS() {
        if (this.s.containsKey("extras_event_action_context")) {
            return ((EventActionContext) this.s.getParcelable("extras_event_action_context")).a(ActionSource.PERMALINK);
        }
        if (this.s.containsKey("action_ref") || this.s.containsKey("event_ref_mechanism")) {
            return new EventActionContext(ActionSource.PERMALINK, null, (ActionSource) this.s.getParcelable("action_ref"), (ActionMechanism) this.s.getParcelable("event_ref_mechanism"), false);
        } else if (aT()) {
            return new EventActionContext(ActionSource.PERMALINK, ActionSource.MOBILE_SYSTEM_NOTIFICATION, false);
        } else {
            return EventActionContext.c;
        }
    }

    public final String am_() {
        return "event_permalink";
    }

    public final FadingContentView m18241j() {
        View f = this.f17837c.f(0);
        return f instanceof FadingContentView ? (FadingContentView) f : null;
    }

    public final boolean mk_() {
        return m18241j() != null;
    }

    public final int ml_() {
        FadingContentView j = m18241j();
        return j instanceof View ? ((View) j).getTop() : 0;
    }

    public final void m18242p() {
        this.bq = true;
    }

    public final GraphSearchQuery m18243q() {
        if (this.bF == null) {
            return GraphSearchQuery.e;
        }
        return GraphSearchQuery.a(ScopedEntityType.EVENT, this.bA, this.bF.b, null, true);
    }

    public static void m18227g(EventPermalinkFragment eventPermalinkFragment, int i) {
        if (eventPermalinkFragment.f17836b == null) {
            if (i != 8) {
                LayoutInflater.from(eventPermalinkFragment.getContext()).inflate(2130904072, eventPermalinkFragment.f17835a, true);
                eventPermalinkFragment.f17836b = eventPermalinkFragment.e(2131561360);
            } else {
                return;
            }
        }
        eventPermalinkFragment.f17836b.setVisibility(i);
    }

    private void m18228h(int i) {
        if (this.f17840f == null) {
            if (i != 8) {
                LayoutInflater.from(getContext()).inflate(2130904071, this.f17835a, true);
                this.f17840f = (FbTextView) e(2131561359);
            } else {
                return;
            }
        }
        this.f17840f.setVisibility(i);
    }

    public static void m18221a(EventPermalinkFragment eventPermalinkFragment, NotificationBannerType notificationBannerType) {
        if (eventPermalinkFragment.f17839e == null) {
            eventPermalinkFragment.f17839e = new GenericNotificationBanner(eventPermalinkFragment.getContext());
            eventPermalinkFragment.f17835a.addView(eventPermalinkFragment.f17839e, new LayoutParams(-1, eventPermalinkFragment.jW_().getDimensionPixelOffset(2131428843)));
        }
        eventPermalinkFragment.f17839e.a(notificationBannerType);
    }
}
