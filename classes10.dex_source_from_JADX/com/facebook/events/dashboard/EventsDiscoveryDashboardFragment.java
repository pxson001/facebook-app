package com.facebook.events.dashboard;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.dashboard.EventsDashboardCaspianHeaderView.OnFilterClickedListener;
import com.facebook.events.dashboard.EventsDashboardSequenceLogger.LoadingState;
import com.facebook.events.dashboard.EventsDiscoveryDashboardPager.C23521;
import com.facebook.events.dashboard.EventsDiscoveryDashboardPager.C23532;
import com.facebook.events.dashboard.EventsDiscoveryDashboardPager.C23554;
import com.facebook.events.dashboard.EventsDiscoveryDashboardPager.C23565;
import com.facebook.events.dashboard.birthdays.BirthdaysUriIntentBuilder;
import com.facebook.events.dashboard.multirow.EventsDashboardItemCollection;
import com.facebook.events.eventsdiscovery.EventsDiscoveryLocationUtil;
import com.facebook.events.eventsdiscovery.EventsDiscoveryReactionSessionBuilder;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventCreatedEvent;
import com.facebook.events.eventsevents.EventsEvents.EventDeletedEvent;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.events.eventsevents.EventsEvents.PromptDeletedEvent;
import com.facebook.events.eventsevents.EventsEvents.RespondingInviteEvent;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.FetchEventPromptsString;
import com.facebook.events.graphql.EventsGraphQL.FetchPastEventsQueryString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel.EventCountsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchPastEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUpcomingEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUpcomingEventsQueryModel.AllEventsModel;
import com.facebook.events.logging.BirthdayReminderLogger;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.AllowedStatesInputAllowedStates;
import com.facebook.graphql.calls.EventPromptSurfaceInputEventPromptSurface;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.calls.SupportedEventPromptStylesInputSupportedEventPromptStyles;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionSuggestedEventsQueryModel;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
public class EventsDiscoveryDashboardFragment extends FbFragment implements AnalyticsFragment, ReactionCardContainer {
    public static final CallerContext aA = CallerContext.a(EventsDiscoveryDashboardFragment.class);
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f16805a;
    public BetterRecyclerView aB;
    public View aC;
    public DashboardFilterType aD;
    public EventsDashboardCaspianHeaderView aE;
    public EventsDiscoveryDashboardViewAdapter aF;
    public FbSwipeRefreshLayout aG;
    public String aH;
    private GregorianCalendar aI;
    private SimpleDateFormat aJ;
    public boolean aK;
    public boolean aL;
    public boolean aM;
    public ImmutableList<Event> aN;
    public boolean aO;
    public String aP;
    public boolean aQ;
    public boolean aR;
    private Context aS;
    public EventAnalyticsParams aT;
    private int aU;
    private List<AllowedStatesInputAllowedStates> aV;
    public ListenableFuture<Cursor> aW;
    private ListenableFuture<GraphQLResult<FetchUpcomingEventsQueryModel>> aX;
    private ListenableFuture<GraphQLResult<FetchPastEventsQueryModel>> aY;
    public ReactionInteractionTracker aZ;
    @Inject
    EventsEventBus al;
    @Inject
    EventEventLogger am;
    @Inject
    EventsDashboardPerformanceLogger an;
    @Inject
    EventPermalinkController ao;
    @Inject
    EmptyUpcomingEventsState ap;
    @Inject
    AbstractFbErrorReporter aq;
    @Inject
    public FbTitleBarSupplier ar;
    @Inject
    GatekeeperStoreImpl as;
    @Inject
    GraphQLQueryExecutor at;
    @Inject
    RapidFeedbackController au;
    @Inject
    ReactionInteractionTrackerProvider av;
    @Inject
    ReactionThemedContextHelper aw;
    @Inject
    TasksManager ax;
    @Inject
    MonotonicClock ay;
    @Inject
    QeAccessor az;
    @Inject
    ActionItemInvite f16806b;
    private ReactionSession ba;
    public boolean bb;
    private BetterLinearLayoutManager bc;
    private final EventCreatedEventSubscriber bd = new EventCreatedEventSubscriber(this);
    private final EventDeletedEventSubscriber be = new EventDeletedEventSubscriber(this);
    private final EventUpdatedEventSubscriber bf = new EventUpdatedEventSubscriber(this);
    private final RespondingInviteEventSubscriber bg = new RespondingInviteEventSubscriber(this);
    private final PromptDeletedEventSubscriber bh = new PromptDeletedEventSubscriber(this);
    public final ObjectNode bi = new ObjectNode(JsonNodeFactory.a);
    private final FutureCallback<GraphQLResult<EventCommonFragmentModel>> bj = new C23431(this);
    private final FutureCallback<GraphQLResult<EventCommonFragmentModel>> bk = new C23442(this);
    public final AbstractDisposableFutureCallback<GraphQLResult<ReactionSuggestedEventsQueryModel>> bl = new C23453(this);
    private final C23464 bm = new C23464(this);
    public final AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> bn = new C23475(this);
    public final AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> bo = new C23486(this);
    public final AbstractDisposableFutureCallback<ImmutableLocation> bp = new C23497(this);
    @Inject
    BirthdayReminderLogger f16807c;
    @Inject
    public EventsDiscoveryDashboardPager f16808d;
    @Inject
    EventsDiscoveryDashboardViewAdapterProvider f16809e;
    @Inject
    EventsDiscoveryDashboardEventsLoader f16810f;
    @Inject
    EventsDiscoveryLocationUtil f16811g;
    @Inject
    EventsDiscoveryReactionSessionBuilder f16812h;
    @Inject
    EventsDashboardSequenceLogger f16813i;

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class C23431 implements FutureCallback<GraphQLResult<EventCommonFragmentModel>> {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16791a;

        C23431(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16791a = eventsDiscoveryDashboardFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                EventCommonFragment eventCommonFragment = (EventCommonFragmentModel) graphQLResult.e;
                if (this.f16791a.aF != null && eventCommonFragment != null) {
                    EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = this.f16791a.f16808d;
                    ExecutorDetour.a(eventsDiscoveryDashboardPager.f16838n, new C23521(eventsDiscoveryDashboardPager, eventCommonFragment), -1097924221);
                    this.f16791a.aF.m17235a(EventGraphQLModelHelper.m19277b(eventCommonFragment));
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class C23442 implements FutureCallback<GraphQLResult<EventCommonFragmentModel>> {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16792a;

        C23442(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16792a = eventsDiscoveryDashboardFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && this.f16792a.aF != null) {
                EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = this.f16792a.f16808d;
                ExecutorDetour.a(eventsDiscoveryDashboardPager.f16838n, new C23532(eventsDiscoveryDashboardPager, (EventCommonFragmentModel) graphQLResult.e), -397127112);
                EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter = this.f16792a.aF;
                EventCommonFragmentModel eventCommonFragmentModel = (EventCommonFragmentModel) graphQLResult.e;
                if (!(eventCommonFragmentModel == null || eventsDiscoveryDashboardViewAdapter.f16858j == null)) {
                    Event event;
                    EventsDashboardItemCollection eventsDashboardItemCollection = eventsDiscoveryDashboardViewAdapter.f16858j;
                    String dL_ = eventCommonFragmentModel.dL_();
                    if (dL_ == null || !eventsDashboardItemCollection.f17060i.containsKey(dL_)) {
                        event = null;
                    } else {
                        event = (Event) eventsDashboardItemCollection.f17055d.get(((Integer) eventsDashboardItemCollection.f17060i.get(dL_)).intValue());
                    }
                    Event event2 = event;
                    if (event2 != null) {
                        Builder builder = new Builder(event2);
                        builder.b = eventCommonFragmentModel.dM_();
                        if (EventsDateUtil.a(eventCommonFragmentModel.dN_())) {
                            builder.H = EventsDateUtil.b(eventCommonFragmentModel.dN_());
                            builder.I = EventsDateUtil.c(eventCommonFragmentModel.b());
                            if (!Strings.isNullOrEmpty(eventCommonFragmentModel.n())) {
                                builder.J = TimeZone.getTimeZone(eventCommonFragmentModel.n());
                            }
                        }
                        builder.B = eventCommonFragmentModel.o();
                        builder.C = eventCommonFragmentModel.q();
                        builder.G = eventCommonFragmentModel.p();
                        EventPlaceModel ab = eventCommonFragmentModel.ab();
                        if (ab != null) {
                            builder.N = ab.dU_();
                            if (ab.j() != null) {
                                builder.O = ab.j().a();
                            }
                        }
                        eventsDiscoveryDashboardViewAdapter.f16858j.m17371a(eventCommonFragmentModel.dL_(), builder.b());
                        EventsDiscoveryDashboardViewAdapter.m17230m(eventsDiscoveryDashboardViewAdapter);
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class C23453 extends AbstractDisposableFutureCallback<GraphQLResult<ReactionSuggestedEventsQueryModel>> {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16793a;

        C23453(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16793a = eventsDiscoveryDashboardFragment;
        }

        protected final void m17176a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f16793a.aR = true;
            EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment = this.f16793a;
            if (graphQLResult != null && graphQLResult.e != null && ((ReactionSuggestedEventsQueryModel) graphQLResult.e).a() != null && ((ReactionSuggestedEventsQueryModel) graphQLResult.e).a().a() != null) {
                List arrayList = new ArrayList();
                ImmutableList a = ((ReactionSuggestedEventsQueryModel) graphQLResult.e).a().a().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    if (!(edgesModel.a() == null || edgesModel.a().d() == null)) {
                        arrayList.add(edgesModel.a());
                    }
                }
                eventsDiscoveryDashboardFragment.aF.m17242b(false);
                eventsDiscoveryDashboardFragment.aF.m17238a(arrayList);
            }
        }

        protected final void m17177a(Throwable th) {
            this.f16793a.aR = true;
            EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment = this.f16793a;
            if (null != null && null.e != null && ((ReactionSuggestedEventsQueryModel) null.e).a() != null && ((ReactionSuggestedEventsQueryModel) null.e).a().a() != null) {
                List arrayList = new ArrayList();
                ImmutableList a = ((ReactionSuggestedEventsQueryModel) null.e).a().a().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    if (!(edgesModel.a() == null || edgesModel.a().d() == null)) {
                        arrayList.add(edgesModel.a());
                    }
                }
                eventsDiscoveryDashboardFragment.aF.m17242b(false);
                eventsDiscoveryDashboardFragment.aF.m17238a(arrayList);
            }
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    public class C23464 {
        public final /* synthetic */ EventsDiscoveryDashboardFragment f16794a;

        C23464(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16794a = eventsDiscoveryDashboardFragment;
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class C23475 extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16795a;

        C23475(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16795a = eventsDiscoveryDashboardFragment;
        }

        protected final void m17178a(Object obj) {
            FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) ((GraphQLResult) obj).e;
            if (fetchEventPermalinkFragmentModel != null) {
                Event a = EventGraphQLModelHelper.m19260a(fetchEventPermalinkFragmentModel);
                EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter = this.f16795a.aF;
                Preconditions.checkNotNull(eventsDiscoveryDashboardViewAdapter.f16855g);
                eventsDiscoveryDashboardViewAdapter.f16858j.m17368a(a);
                EventsDiscoveryDashboardViewAdapter.m17230m(eventsDiscoveryDashboardViewAdapter);
            }
        }

        protected final void m17179a(Throwable th) {
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class C23486 extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16796a;

        C23486(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16796a = eventsDiscoveryDashboardFragment;
        }

        protected final void m17180a(Object obj) {
            FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) ((GraphQLResult) obj).e;
            if (fetchEventPermalinkFragmentModel != null) {
                this.f16796a.aF.m17235a(EventGraphQLModelHelper.m19260a(fetchEventPermalinkFragmentModel));
            }
        }

        protected final void m17181a(Throwable th) {
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class C23497 extends AbstractDisposableFutureCallback<ImmutableLocation> {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16797a;

        C23497(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16797a = eventsDiscoveryDashboardFragment;
        }

        protected final void m17182a(Object obj) {
            ImmutableLocation immutableLocation = (ImmutableLocation) obj;
            if (immutableLocation != null) {
                Location l = immutableLocation.l();
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                objectNode.a("latitude", l.getLatitude());
                objectNode.a("longitude", l.getLongitude());
                this.f16797a.bi.c("lat_lon", objectNode);
            }
            this.f16797a.f16812h.m17620a(Surface.ANDROID_EVENT_DISCOVER_DASHBOARD, this.f16797a.bl, this.f16797a.bi, "event_discovery_dashboard");
        }

        protected final void m17183a(Throwable th) {
            this.f16797a.f16812h.m17620a(Surface.ANDROID_EVENT_DISCOVER_DASHBOARD, this.f16797a.bl, this.f16797a.bi, "event_discovery_dashboard");
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    public class C23508 implements OnDrawListener {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16798a;

        public C23508(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16798a = eventsDiscoveryDashboardFragment;
        }

        public final boolean gD_() {
            if (!this.f16798a.aO) {
                return false;
            }
            this.f16798a.an.m17096a(this.f16798a.aP);
            this.f16798a.f16813i.m17153b(LoadingState.RENDERING);
            this.f16798a.f16813i.m17152b();
            if (this.f16798a.aK && this.f16798a.aN != null) {
                this.f16798a.aF.m17236a(this.f16798a.aN);
                this.f16798a.aN = null;
            }
            this.f16798a.aK = false;
            this.f16798a.aL = false;
            return true;
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    public class C23519 implements OnRefreshListener {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16799a;

        public C23519(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16799a = eventsDiscoveryDashboardFragment;
        }

        public final void m17184a() {
            this.f16799a.aO = false;
            this.f16799a.f16808d.m17222a();
            this.f16799a.aq();
            if (this.f16799a.aD == DashboardFilterType.BIRTHDAYS) {
                EventsDiscoveryDashboardFragment.m17201h(this.f16799a, false);
                return;
            }
            EventsDiscoveryDashboardFragment.m17193a(this.f16799a, false);
            this.f16799a.m17212e();
            this.f16799a.f16811g.m17594a(this.f16799a.ao(), this.f16799a.bp, EventsDiscoveryDashboardFragment.aA);
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class EventCreatedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventCreatedEventSubscriber {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16800a;

        public EventCreatedEventSubscriber(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16800a = eventsDiscoveryDashboardFragment;
        }

        public final void m17185b(FbEvent fbEvent) {
            EventCreatedEvent eventCreatedEvent = (EventCreatedEvent) fbEvent;
            if (eventCreatedEvent.a != null) {
                this.f16800a.ax.a(Tasks.FETCH_SINGLE_EVENT, this.f16800a.f16808d.m17220a(this.f16800a.getContext(), eventCreatedEvent.a), this.f16800a.bn);
            }
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class EventDeletedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventDeletedEventSubscriber {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16801a;

        public EventDeletedEventSubscriber(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16801a = eventsDiscoveryDashboardFragment;
        }

        public final void m17186b(FbEvent fbEvent) {
            this.f16801a.aF.m17237a(((EventDeletedEvent) fbEvent).a);
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class EventUpdatedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventUpdatedEventSubscriber {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16802a;

        public EventUpdatedEventSubscriber(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16802a = eventsDiscoveryDashboardFragment;
        }

        public final void m17187b(FbEvent fbEvent) {
            EventUpdatedEvent eventUpdatedEvent = (EventUpdatedEvent) fbEvent;
            if (eventUpdatedEvent.a != null) {
                this.f16802a.ax.a(Tasks.FETCH_SINGLE_EVENT, this.f16802a.f16808d.m17220a(this.f16802a.getContext(), eventUpdatedEvent.a), this.f16802a.bo);
            }
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class PromptDeletedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.PromptDeletedEventSubscriber {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16803a;

        public PromptDeletedEventSubscriber(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16803a = eventsDiscoveryDashboardFragment;
        }

        public final void m17188b(FbEvent fbEvent) {
            PromptDeletedEvent promptDeletedEvent = (PromptDeletedEvent) fbEvent;
            EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter = this.f16803a.aF;
            String str = promptDeletedEvent.a;
            Preconditions.checkNotNull(eventsDiscoveryDashboardViewAdapter.f16855g);
            if (str != null) {
                eventsDiscoveryDashboardViewAdapter.f16858j.m17378d(str);
                EventsDiscoveryDashboardViewAdapter.m17230m(eventsDiscoveryDashboardViewAdapter);
            }
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    class RespondingInviteEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.RespondingInviteEventSubscriber {
        final /* synthetic */ EventsDiscoveryDashboardFragment f16804a;

        public RespondingInviteEventSubscriber(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
            this.f16804a = eventsDiscoveryDashboardFragment;
        }

        public final void m17189b(FbEvent fbEvent) {
            RespondingInviteEvent respondingInviteEvent = (RespondingInviteEvent) fbEvent;
            if (this.f16804a.aE != null) {
                int i = this.f16804a.aE.f16560j;
                if (respondingInviteEvent.a == EventStatus.SENDING) {
                    this.f16804a.aE.setBadge(i - 1);
                } else if (respondingInviteEvent.a == EventStatus.FAILURE) {
                    this.f16804a.aE.setBadge(i + 1);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms.wearable.internal.IChannelStreamCallbacks */
    enum Tasks {
        DB_FETCH,
        FETCH_SINGLE_EVENT,
        FETCH_EVENT_COUNTS
    }

    public static void m17196a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsDiscoveryDashboardFragment) obj).m17195a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ActionItemInvite.m18355a(injectorLike), BirthdayReminderLogger.m18107a(injectorLike), EventsDiscoveryDashboardPager.m17217a(injectorLike), (EventsDiscoveryDashboardViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsDiscoveryDashboardViewAdapterProvider.class), EventsDiscoveryDashboardEventsLoader.m17162a(injectorLike), EventsDiscoveryLocationUtil.m17592a(injectorLike), EventsDiscoveryReactionSessionBuilder.m17617a(injectorLike), EventsDashboardSequenceLogger.m17147a(injectorLike), EventsEventBus.a(injectorLike), EventEventLogger.m18116a(injectorLike), EventsDashboardPerformanceLogger.m17093a(injectorLike), EventPermalinkController.m18257a(injectorLike), EmptyUpcomingEventsState.m16925a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), RapidFeedbackController.a(injectorLike), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), ReactionThemedContextHelper.a(injectorLike), TasksManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m17195a(ListeningExecutorService listeningExecutorService, ActionItemInvite actionItemInvite, BirthdayReminderLogger birthdayReminderLogger, EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager, EventsDiscoveryDashboardViewAdapterProvider eventsDiscoveryDashboardViewAdapterProvider, EventsDiscoveryDashboardEventsLoader eventsDiscoveryDashboardEventsLoader, EventsDiscoveryLocationUtil eventsDiscoveryLocationUtil, EventsDiscoveryReactionSessionBuilder eventsDiscoveryReactionSessionBuilder, EventsDashboardSequenceLogger eventsDashboardSequenceLogger, EventsEventBus eventsEventBus, EventEventLogger eventEventLogger, EventsDashboardPerformanceLogger eventsDashboardPerformanceLogger, EventPermalinkController eventPermalinkController, EmptyUpcomingEventsState emptyUpcomingEventsState, AbstractFbErrorReporter abstractFbErrorReporter, FbTitleBarSupplier fbTitleBarSupplier, GatekeeperStoreImpl gatekeeperStoreImpl, GraphQLQueryExecutor graphQLQueryExecutor, RapidFeedbackController rapidFeedbackController, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, ReactionThemedContextHelper reactionThemedContextHelper, TasksManager tasksManager, MonotonicClock monotonicClock, QeAccessor qeAccessor) {
        this.f16805a = listeningExecutorService;
        this.f16806b = actionItemInvite;
        this.f16807c = birthdayReminderLogger;
        this.f16808d = eventsDiscoveryDashboardPager;
        this.f16809e = eventsDiscoveryDashboardViewAdapterProvider;
        this.f16810f = eventsDiscoveryDashboardEventsLoader;
        this.f16811g = eventsDiscoveryLocationUtil;
        this.f16812h = eventsDiscoveryReactionSessionBuilder;
        this.f16813i = eventsDashboardSequenceLogger;
        this.al = eventsEventBus;
        this.am = eventEventLogger;
        this.an = eventsDashboardPerformanceLogger;
        this.ao = eventPermalinkController;
        this.ap = emptyUpcomingEventsState;
        this.aq = abstractFbErrorReporter;
        this.ar = fbTitleBarSupplier;
        this.as = gatekeeperStoreImpl;
        this.at = graphQLQueryExecutor;
        this.au = rapidFeedbackController;
        this.av = reactionInteractionTrackerProvider;
        this.aw = reactionThemedContextHelper;
        this.ax = tasksManager;
        this.ay = monotonicClock;
        this.az = qeAccessor;
    }

    public static EventsDiscoveryDashboardFragment m17190a(Bundle bundle, String str, String str2) {
        EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment = new EventsDiscoveryDashboardFragment();
        bundle.putString("extra_dashboard_filter_type", str);
        if (!StringUtil.a(str2)) {
            bundle.putString("extra_ref_module", str2);
        }
        eventsDiscoveryDashboardFragment.g(bundle);
        return eventsDiscoveryDashboardFragment;
    }

    public final void m17211c(@Nullable Bundle bundle) {
        DashboardFilterType valueOf;
        super.c(bundle);
        Class cls = EventsDiscoveryDashboardFragment.class;
        m17196a((Object) this, getContext());
        Bundle bundle2 = this.s;
        if (bundle != null && !StringUtil.a(bundle2.getString("extra_dashboard_filter_type"))) {
            valueOf = DashboardFilterType.valueOf(bundle.getString("extra_dashboard_filter_type"));
        } else if (bundle2 == null || StringUtil.a(bundle2.getString("extra_dashboard_filter_type"))) {
            valueOf = DashboardFilterType.UPCOMING;
        } else {
            valueOf = DashboardFilterType.valueOf(bundle2.getString("extra_dashboard_filter_type"));
        }
        this.aD = valueOf;
        if (this.aD != DashboardFilterType.BIRTHDAYS) {
            this.an.m17095a();
            this.f16813i.m17150a();
        }
        this.aM = this.as.a(644, false);
        this.aP = "cold";
        this.aT = new EventAnalyticsParams(m17202n(this.s), aA(), am_(), null);
        this.f16808d.f16827c = this.bj;
        this.aU = jW_().getDimensionPixelSize(2131431107);
        if (this.az.a(ExperimentsForEventsGatingModule.u, false)) {
            this.aV = Arrays.asList(new AllowedStatesInputAllowedStates[]{AllowedStatesInputAllowedStates.PUBLISHED, AllowedStatesInputAllowedStates.CANCELED});
        } else {
            this.aV = Arrays.asList(new AllowedStatesInputAllowedStates[]{AllowedStatesInputAllowedStates.PUBLISHED});
        }
        ay(this);
        this.aJ = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        this.aH = m17191a(bundle, o().getIntent());
        this.f16806b.f17957a = this.aT;
        aq();
        this.al.a(this.bd);
        this.al.a(this.be);
        this.al.a(this.bf);
        this.al.a(this.bg);
        this.al.a(this.bh);
        this.aS = ReactionThemedContextHelper.a(getContext(), Surface.ANDROID_EVENT_DISCOVER_DASHBOARD);
        this.f16811g.m17594a(ao(), this.bp, aA);
        this.ba = this.f16812h.m17619a(Surface.ANDROID_EVENT_DISCOVER_DASHBOARD);
        this.aZ = this.av.a(this.ba, null);
        this.aF = this.f16809e.m17247a(this.aD, Boolean.valueOf(true), this.aS, this.aT, this, this.ba, aA(), this.aZ);
    }

    public final View m17205a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1198861003);
        this.f16813i.m17151a(LoadingState.CREATE_VIEW);
        View inflate = LayoutInflater.from(this.aS).inflate(2130904141, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1462081816, a);
        return inflate;
    }

    public final void m17208a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.aB = (BetterRecyclerView) e(2131561529);
        this.bc = new BetterLinearLayoutManager(this.aS);
        this.aB.setLayoutManager(this.bc);
        this.aB.setAdapter(this.aF);
        this.aB.a(new OnScrollListener(this) {
            final /* synthetic */ EventsDiscoveryDashboardFragment f16782a;

            {
                this.f16782a = r1;
            }

            public final void m17167a(RecyclerView recyclerView, int i, int i2) {
                Object obj;
                EventEventLogger eventEventLogger;
                String str;
                String str2;
                HoneyClientEventFast a;
                EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment = this.f16782a;
                if (eventsDiscoveryDashboardFragment.aD == DashboardFilterType.BIRTHDAYS) {
                    Object obj2;
                    EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = eventsDiscoveryDashboardFragment.f16808d;
                    if (eventsDiscoveryDashboardFragment.aD != DashboardFilterType.BIRTHDAYS || eventsDiscoveryDashboardPager.f16829e == null) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null && eventsDiscoveryDashboardFragment.aB.getLastVisiblePosition() + 6 > eventsDiscoveryDashboardFragment.aF.aZ_()) {
                        obj = 1;
                        if (obj == null) {
                            eventsDiscoveryDashboardFragment = this.f16782a;
                            eventsDiscoveryDashboardFragment.aQ = true;
                            eventsDiscoveryDashboardFragment.aO = false;
                            eventsDiscoveryDashboardFragment.aF.m17242b(true);
                            EventsDiscoveryDashboardFragment.m17201h(eventsDiscoveryDashboardFragment, true);
                        }
                        EventsDiscoveryDashboardFragment.aE(this.f16782a);
                        if (i2 > 0 && this.f16782a.aD == DashboardFilterType.UPCOMING && !this.f16782a.bb) {
                            eventEventLogger = this.f16782a.am;
                            str = this.f16782a.aT.c;
                            str2 = this.f16782a.aT.e;
                            a = eventEventLogger.f17787i.a("event_discovery_dashboard_first_scroll", false);
                            if (a.a()) {
                                a.a("event_dashboard");
                                a.d(eventEventLogger.f17788j.b(eventEventLogger.f17785g));
                                a.a("ref_module", str);
                                a.a("ref_mechanism", str2);
                                a.b();
                            }
                            this.f16782a.bb = true;
                        }
                        this.f16782a.aZ.a(this.f16782a.ay.now());
                        return;
                    }
                }
                obj = null;
                if (obj == null) {
                    EventsDiscoveryDashboardFragment.aE(this.f16782a);
                    eventEventLogger = this.f16782a.am;
                    str = this.f16782a.aT.c;
                    str2 = this.f16782a.aT.e;
                    a = eventEventLogger.f17787i.a("event_discovery_dashboard_first_scroll", false);
                    if (a.a()) {
                        a.a("event_dashboard");
                        a.d(eventEventLogger.f17788j.b(eventEventLogger.f17785g));
                        a.a("ref_module", str);
                        a.a("ref_mechanism", str2);
                        a.b();
                    }
                    this.f16782a.bb = true;
                    this.f16782a.aZ.a(this.f16782a.ay.now());
                    return;
                }
                eventsDiscoveryDashboardFragment = this.f16782a;
                eventsDiscoveryDashboardFragment.aQ = true;
                eventsDiscoveryDashboardFragment.aO = false;
                eventsDiscoveryDashboardFragment.aF.m17242b(true);
                EventsDiscoveryDashboardFragment.m17201h(eventsDiscoveryDashboardFragment, true);
            }
        });
        this.aZ.a(this.bc, this.ay.now(), false);
        this.aE = (EventsDashboardCaspianHeaderView) e(2131561528);
        this.aE.setShouldShowBirthdays(true);
        this.aE.f16561k = new OnFilterClickedListener(this) {
            final /* synthetic */ EventsDiscoveryDashboardFragment f16781a;

            {
                this.f16781a = r1;
            }

            public final void mo780a(DashboardFilterType dashboardFilterType) {
                if (dashboardFilterType != null && dashboardFilterType != this.f16781a.aD) {
                    if (this.f16781a.aL) {
                        this.f16781a.f16813i.m17152b();
                        this.f16781a.aK = false;
                        this.f16781a.aL = false;
                    }
                    this.f16781a.an.m17098b(dashboardFilterType.name());
                    this.f16781a.am.m18141c(dashboardFilterType.name());
                    this.f16781a.aD = dashboardFilterType;
                    this.f16781a.aO = false;
                    this.f16781a.aC.setVisibility(this.f16781a.aD == DashboardFilterType.PAST ? 8 : 0);
                    if (this.f16781a.aD == DashboardFilterType.INVITED) {
                        this.f16781a.aq();
                    }
                    this.f16781a.f16808d.m17222a();
                    EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter = this.f16781a.aF;
                    eventsDiscoveryDashboardViewAdapter.f16851c = dashboardFilterType;
                    eventsDiscoveryDashboardViewAdapter.f16855g.mo792a(dashboardFilterType);
                    if (eventsDiscoveryDashboardViewAdapter.f16858j != null) {
                        eventsDiscoveryDashboardViewAdapter.f16858j.f17065n = dashboardFilterType;
                    }
                    eventsDiscoveryDashboardViewAdapter.f16855g.hL_();
                    if (this.f16781a.aD == DashboardFilterType.BIRTHDAYS) {
                        if (this.f16781a.aF.m17243b(dashboardFilterType)) {
                            this.f16781a.aF.m17244c(dashboardFilterType);
                        } else {
                            this.f16781a.aF.m17239a(new ArrayList(), this.f16781a.aH);
                        }
                        EventsDiscoveryDashboardFragment.m17201h(this.f16781a, false);
                    } else {
                        if (this.f16781a.aF.m17243b(dashboardFilterType)) {
                            this.f16781a.aF.m17244c(dashboardFilterType);
                            EventsDiscoveryDashboardFragment.m17193a(this.f16781a, false);
                        } else {
                            EventsDiscoveryDashboardFragment.ay(this.f16781a);
                        }
                        this.f16781a.m17212e();
                    }
                    if (this.f16781a.aM && !this.f16781a.aF.m17245d(dashboardFilterType)) {
                        EventsDiscoveryDashboardFragment.aH(this.f16781a);
                    }
                }
            }
        };
        this.aE.setDashboardFilterType(this.aD);
        this.aG = (FbSwipeRefreshLayout) e(2131561513);
        this.aG.setColorSchemeResources(new int[]{2131361916});
        this.aG.e = new C23519(this);
        this.aC = e(2131560261);
        this.aC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventsDiscoveryDashboardFragment f16780a;

            {
                this.f16780a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1398211411);
                this.f16780a.ao.m18265a(this.f16780a.getContext(), this.f16780a.aT, ActionMechanism.DASHBOARD_FAB);
                Logger.a(2, EntryType.UI_INPUT_END, 809583480, a);
            }
        });
        this.aC.setVisibility(0);
        if (this.aB != null) {
            this.aB.a(new C23508(this));
        }
        this.f16813i.m17153b(LoadingState.CREATE_VIEW);
        if (this.aD == DashboardFilterType.BIRTHDAYS) {
            this.aF.m17242b(true);
            m17201h(this, false);
        } else {
            m17212e();
        }
        if (this.aM && !this.aF.m17245d(this.aD)) {
            aH(this);
        }
    }

    public final void m17203G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1679360481);
        super.G();
        if (this.aF != null) {
            this.aF.f16863o.e();
        }
        if (this.aZ != null) {
            this.aZ.e(this.ay.now());
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2008736506, a);
    }

    public final void m17204H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1819185816);
        super.H();
        if (this.aF != null) {
            this.aF.f16863o.d();
        }
        if (this.aZ != null) {
            this.aZ.d(this.ay.now());
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -918246475, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1385044631);
        super.mi_();
        if (((HasTitleBar) a(HasTitleBar.class)) != null) {
            FbTitleBar fbTitleBar = (FbTitleBar) this.ar.get();
            if (fbTitleBar != null) {
                fbTitleBar.setTitle(jW_().getString(2131237122));
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 689734943, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1186121864);
        this.an.m17097b();
        this.al.b(this.bd);
        this.al.b(this.be);
        this.al.b(this.bf);
        this.al.b(this.bg);
        this.al.b(this.bh);
        if (this.aF != null) {
            this.aF.m17246f();
        }
        if (this.aZ != null) {
            this.aZ.c();
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 55094235, a);
    }

    public final void m17207a(int i, int i2, Intent intent) {
        switch (i) {
            case 106:
                if (i2 == 0) {
                    this.au.a("1556604017999292", getContext());
                    break;
                }
                break;
            case 501:
                this.f16806b.m18366a(i, i2, intent);
                return;
            case 1756:
                if (i2 == -1) {
                    PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
                    if (publishPostParams != null) {
                        EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter = this.aF;
                        String l = Long.toString(publishPostParams.targetId);
                        if (l != null) {
                            EventsDashboardItemCollection eventsDashboardItemCollection = eventsDiscoveryDashboardViewAdapter.f16858j;
                            if (eventsDashboardItemCollection.f17061j.containsKey(l)) {
                                ((EventsDiscoveryDashboardBirthdaysRowModel) eventsDashboardItemCollection.f17057f.get(((Integer) eventsDashboardItemCollection.f17061j.get(l)).intValue())).f16769c = true;
                            }
                            EventsDiscoveryDashboardViewAdapter.m17230m(eventsDiscoveryDashboardViewAdapter);
                        }
                        return;
                    }
                    return;
                }
                return;
        }
        super.a(i, i2, intent);
    }

    private String aA() {
        Object string = this.s.getString("extra_ref_module");
        return !StringUtil.a(string) ? string : "unknown";
    }

    public final boolean m17209a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return false;
    }

    public final boolean m17210a(String str, CardSearchType cardSearchType) {
        return false;
    }

    @Nullable
    public final ReactionUnitFragment m17206a(String str) {
        return null;
    }

    @Nullable
    public ViewGroup getCardViewGroup() {
        return this.aB;
    }

    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.aZ;
    }

    public String getSessionId() {
        return this.ba.a;
    }

    @Nullable
    public Surface getSurface() {
        return Surface.ANDROID_EVENT_DISCOVER_DASHBOARD;
    }

    private String m17191a(Bundle bundle, Intent intent) {
        String stringExtra;
        long time;
        GregorianCalendar gregorianCalendar;
        boolean z;
        Boolean valueOf;
        BirthdayReminderLogger birthdayReminderLogger;
        String str = null;
        Boolean valueOf2 = Boolean.valueOf(false);
        if (intent != null) {
            stringExtra = intent.getStringExtra("birthday_view_referrer_param");
            str = intent.getStringExtra("birthday_view_start_date");
        } else {
            stringExtra = null;
        }
        try {
            if (!Strings.isNullOrEmpty(str)) {
                time = this.aJ.parse(str).getTime();
                gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
                this.aI = new GregorianCalendar(TimeZone.getDefault());
                if (time == -1) {
                    this.aI.setTimeInMillis(time);
                    if (this.aI.get(6) == gregorianCalendar.get(6)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                } else {
                    valueOf = valueOf2;
                }
                if (bundle == null && bundle.getString("birthday_view_waterfall_id_param") != null) {
                    return bundle.getString("birthday_view_waterfall_id_param");
                }
                birthdayReminderLogger = this.f16807c;
                if (stringExtra == null) {
                    stringExtra = "";
                }
                return birthdayReminderLogger.m18112a(stringExtra, valueOf.booleanValue());
            }
        } catch (Throwable e) {
            BLog.b(BirthdaysUriIntentBuilder.class, e, "Invalid date format", new Object[0]);
        }
        time = -1;
        gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
        this.aI = new GregorianCalendar(TimeZone.getDefault());
        if (time == -1) {
            valueOf = valueOf2;
        } else {
            this.aI.setTimeInMillis(time);
            if (this.aI.get(6) == gregorianCalendar.get(6)) {
                z = false;
            } else {
                z = true;
            }
            valueOf = Boolean.valueOf(z);
        }
        if (bundle == null) {
        }
        birthdayReminderLogger = this.f16807c;
        if (stringExtra == null) {
            stringExtra = "";
        }
        return birthdayReminderLogger.m18112a(stringExtra, valueOf.booleanValue());
    }

    public final void m17213e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("extra_dashboard_filter_type", this.aD.name());
        bundle.putString("birthday_view_waterfall_id_param", this.aH);
    }

    public static void ay(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
        if (eventsDiscoveryDashboardFragment.aD != DashboardFilterType.BIRTHDAYS) {
            eventsDiscoveryDashboardFragment.aW = eventsDiscoveryDashboardFragment.f16810f.m17165a(eventsDiscoveryDashboardFragment.aD);
            eventsDiscoveryDashboardFragment.m17199b(false);
        }
    }

    public static void m17193a(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment, boolean z) {
        if (eventsDiscoveryDashboardFragment.aD != DashboardFilterType.BIRTHDAYS) {
            eventsDiscoveryDashboardFragment.m17199b(z);
        }
    }

    private void m17199b(boolean z) {
        if (this.aD == DashboardFilterType.PAST) {
            EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = this.f16808d;
            int i = this.aU;
            List list = this.aV;
            GraphQlQueryString a = new FetchPastEventsQueryString().a("profile_image_size", String.valueOf(i)).a("cover_image_portrait_size", Integer.valueOf(eventsDiscoveryDashboardPager.f16840p.f())).a("cover_image_landscape_size", Integer.valueOf(eventsDiscoveryDashboardPager.f16840p.g())).a("first_count", "14");
            if (!(list == null || list.isEmpty())) {
                a.a("event_state", list);
            }
            if (z) {
                a.a("after_cursor", eventsDiscoveryDashboardPager.f16826b);
            }
            this.aY = eventsDiscoveryDashboardPager.f16836l.a(GraphQLRequest.a(EventsGraphQL.g()).a(a.a));
            return;
        }
        this.aX = this.f16808d.m17221a(this.aD, z, this.aU, this.aV);
        this.f16813i.m17151a(LoadingState.NETWORK_FETCH);
    }

    private static EventActionContext m17202n(Bundle bundle) {
        if (bundle != null) {
            ActionSource actionSource = (ActionSource) bundle.getParcelable("action_ref");
            if (actionSource != null) {
                return new EventActionContext(ActionSource.DASHBOARD, actionSource, false);
            }
        }
        return EventActionContext.b;
    }

    public final String am_() {
        return "event_dashboard";
    }

    public static void aE(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
        if (!eventsDiscoveryDashboardFragment.aQ) {
            Object obj = null;
            if (eventsDiscoveryDashboardFragment.aD != DashboardFilterType.UPCOMING) {
                EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = eventsDiscoveryDashboardFragment.f16808d;
                DashboardFilterType dashboardFilterType = eventsDiscoveryDashboardFragment.aD;
                Object obj2 = ((dashboardFilterType == DashboardFilterType.BIRTHDAYS || dashboardFilterType != DashboardFilterType.PAST || eventsDiscoveryDashboardPager.f16826b == null) && (dashboardFilterType == DashboardFilterType.UPCOMING || dashboardFilterType == DashboardFilterType.PAST || eventsDiscoveryDashboardPager.f16825a == null)) ? null : 1;
                if (obj2 != null && eventsDiscoveryDashboardFragment.aB.getLastVisiblePosition() + 3 > eventsDiscoveryDashboardFragment.aF.aZ_()) {
                    obj = 1;
                }
            }
            if (obj != null) {
                eventsDiscoveryDashboardFragment.aQ = true;
                eventsDiscoveryDashboardFragment.aO = false;
                eventsDiscoveryDashboardFragment.aF.m17242b(true);
                m17193a(eventsDiscoveryDashboardFragment, true);
                eventsDiscoveryDashboardFragment.m17212e();
            }
        }
    }

    public final void m17212e() {
        aI();
        aJ();
        aK();
    }

    public static void aH(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
        EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = eventsDiscoveryDashboardFragment.f16808d;
        DashboardFilterType dashboardFilterType = eventsDiscoveryDashboardFragment.aD;
        AnonymousClass13 anonymousClass13 = new Object(eventsDiscoveryDashboardFragment) {
            public final /* synthetic */ EventsDiscoveryDashboardFragment f16783a;

            {
                this.f16783a = r1;
            }
        };
        if (anonymousClass13 != null && dashboardFilterType == DashboardFilterType.BIRTHDAYS && eventsDiscoveryDashboardPager.f16839o.a(ExperimentsForEventsGatingModule.r, false)) {
            EventPromptSurfaceInputEventPromptSurface eventPromptSurfaceInputEventPromptSurface;
            FetchEventPromptsString i = EventsGraphQL.i();
            i.a("event_prompt_styles", SupportedEventPromptStylesInputSupportedEventPromptStyles.BANNER_IMAGE);
            String str = "event_prompt_surface";
            switch (dashboardFilterType) {
                case BIRTHDAYS:
                    eventPromptSurfaceInputEventPromptSurface = EventPromptSurfaceInputEventPromptSurface.BIRTHDAYS_DASHBOARD;
                    break;
                default:
                    eventPromptSurfaceInputEventPromptSurface = null;
                    break;
            }
            i.a(str, eventPromptSurfaceInputEventPromptSurface);
            i.a("theme_height", Integer.valueOf(1));
            i.a("theme_width", Integer.valueOf(eventsDiscoveryDashboardPager.f16840p.c()));
            i.a("prompt_height", Integer.valueOf(1));
            i.a("prompt_width", Integer.valueOf(eventsDiscoveryDashboardPager.f16840p.c()));
            GraphQLRequest a = GraphQLRequest.a(EventsGraphQL.i());
            a.a(i.a);
            eventsDiscoveryDashboardPager.f16841q.a(EventsDashboardPagerTaskType.FETCH_PROMPTS, eventsDiscoveryDashboardPager.f16836l.a(a), new C23565(eventsDiscoveryDashboardPager, anonymousClass13));
        }
    }

    public static void m17201h(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment, boolean z) {
        if (eventsDiscoveryDashboardFragment.aD == DashboardFilterType.BIRTHDAYS) {
            EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = eventsDiscoveryDashboardFragment.f16808d;
            C23464 c23464 = eventsDiscoveryDashboardFragment.bm;
            if (eventsDiscoveryDashboardPager.f16828d && !eventsDiscoveryDashboardPager.f16831g.m17294a()) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
                gregorianCalendar.set(10, 0);
                gregorianCalendar.set(12, 0);
                gregorianCalendar.set(13, 0);
                gregorianCalendar.set(14, 0);
                gregorianCalendar.roll(6, eventsDiscoveryDashboardPager.f16839o.a(ExperimentsForEventsGatingModule.p, -1));
                eventsDiscoveryDashboardPager.f16831g.m17293a(16, eventsDiscoveryDashboardPager.f16830f, z ? eventsDiscoveryDashboardPager.f16829e : null, gregorianCalendar, new C23554(eventsDiscoveryDashboardPager, c23464));
            }
        }
    }

    private void aI() {
        if (this.aX != null && this.aD != DashboardFilterType.PAST) {
            if (this.aX.isDone()) {
                m17194a((GraphQLResult) FutureUtils.a(this.aX));
                this.f16813i.m17153b(LoadingState.DB_FETCH);
                aL();
                this.aX = null;
            } else if (!this.aX.isCancelled()) {
                this.ax.a(EventsDashboardPagerTaskType.FETCH_EVENTS_FOR_DISCOVERY_SURFACE, this.aX, new AbstractDisposableFutureCallback<GraphQLResult<FetchUpcomingEventsQueryModel>>(this) {
                    final /* synthetic */ EventsDiscoveryDashboardFragment f16784a;

                    {
                        this.f16784a = r1;
                    }

                    protected final void m17168a(Object obj) {
                        GraphQLResult graphQLResult = (GraphQLResult) obj;
                        this.f16784a.aO = true;
                        this.f16784a.aG.setRefreshing(false);
                        this.f16784a.m17194a(graphQLResult);
                        EventsDiscoveryDashboardFragment.aE(this.f16784a);
                    }

                    protected final void m17169a(Throwable th) {
                        this.f16784a.aO = true;
                        this.f16784a.aG.setRefreshing(false);
                    }
                });
                this.aX = null;
            }
        }
    }

    private void aJ() {
        if (this.aY != null && this.aD == DashboardFilterType.PAST) {
            if (this.aY.isDone()) {
                m17198b((GraphQLResult) FutureUtils.a(this.aY));
                aL();
                this.aY = null;
            } else if (!this.aY.isCancelled()) {
                this.ax.a(EventsDashboardPagerTaskType.FETCH_EVENTS_FOR_DISCOVERY_SURFACE, this.aY, new AbstractDisposableFutureCallback<GraphQLResult<FetchPastEventsQueryModel>>(this) {
                    final /* synthetic */ EventsDiscoveryDashboardFragment f16785a;

                    {
                        this.f16785a = r1;
                    }

                    protected final void m17170a(Object obj) {
                        GraphQLResult graphQLResult = (GraphQLResult) obj;
                        this.f16785a.aO = true;
                        this.f16785a.aG.setRefreshing(false);
                        this.f16785a.m17198b(graphQLResult);
                        EventsDiscoveryDashboardFragment.aE(this.f16785a);
                    }

                    protected final void m17171a(Throwable th) {
                        this.f16785a.aO = true;
                        this.f16785a.aG.setRefreshing(false);
                    }
                });
                this.aY = null;
            }
        }
    }

    private void aK() {
        if (this.aW != null && this.aW.isDone()) {
            try {
                m17192a(this, (Cursor) FutureUtils.b(this.aW));
            } catch (Throwable e) {
                this.aq.a(EventsDiscoveryDashboardFragment.class.getSimpleName(), e);
            }
        } else if (!(this.aW == null || this.aW.isCancelled())) {
            this.ax.a(Tasks.DB_FETCH, this.aW, new AbstractDisposableFutureCallback<Cursor>(this) {
                final /* synthetic */ EventsDiscoveryDashboardFragment f16786a;

                {
                    this.f16786a = r1;
                }

                protected final void m17172a(Object obj) {
                    EventsDiscoveryDashboardFragment.m17192a(this.f16786a, (Cursor) obj);
                }

                protected final void m17173a(Throwable th) {
                    this.f16786a.f16813i.m17153b(LoadingState.DB_FETCH);
                }
            });
        }
        this.aW = null;
    }

    public final void aq() {
        this.ax.a(Tasks.FETCH_EVENT_COUNTS, this.at.a(GraphQLRequest.a(EventsGraphQL.a()).a(GraphQLCachePolicy.c)), new AbstractDisposableFutureCallback<GraphQLResult<FetchEventCountsQueryModel>>(this) {
            final /* synthetic */ EventsDiscoveryDashboardFragment f16789a;

            {
                this.f16789a = r1;
            }

            protected final void m17174a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null && ((FetchEventCountsQueryModel) graphQLResult.e).a() != null) {
                    final EventCountsModel a = ((FetchEventCountsQueryModel) graphQLResult.e).a();
                    if (this.f16789a.aE != null) {
                        this.f16789a.aE.setCountsSummarySupplier(new Supplier<EventCountsModel>(this) {
                            final /* synthetic */ AnonymousClass17 f16788b;

                            public Object get() {
                                return a;
                            }
                        });
                    }
                }
            }

            protected final void m17175a(Throwable th) {
            }
        });
    }

    private void m17194a(GraphQLResult<FetchUpcomingEventsQueryModel> graphQLResult) {
        this.f16813i.m17153b(LoadingState.NETWORK_FETCH);
        if (graphQLResult != null && graphQLResult.e != null) {
            AllEventsModel a = ((FetchUpcomingEventsQueryModel) graphQLResult.e).a();
            if (a != null) {
                ImmutableList a2 = this.f16808d.m17219a(a.a(), (GraphQLResult) graphQLResult);
                if (a2.isEmpty()) {
                    this.ap.m16927a();
                }
                if (a.j() != null) {
                    this.f16808d.f16825a = a.j().a();
                }
                if (this.aD != DashboardFilterType.UPCOMING || this.aR) {
                    this.aF.m17242b(false);
                } else {
                    this.aF.m17242b(true);
                }
                if (this.aQ) {
                    this.aQ = false;
                    this.aF.m17242b(false);
                    this.aF.m17240b(a2);
                } else if (this.aK) {
                    this.aN = a2;
                } else {
                    this.aF.m17236a(a2);
                }
                this.f16808d.m17223a(a2);
            }
        }
    }

    private void m17198b(GraphQLResult<FetchPastEventsQueryModel> graphQLResult) {
        if (graphQLResult.e != null) {
            FetchPastEventsQueryModel.AllEventsModel a = ((FetchPastEventsQueryModel) graphQLResult.e).a();
            if (a != null) {
                ImmutableList a2 = this.f16808d.m17219a(a.a(), (GraphQLResult) graphQLResult);
                if (a.j() != null) {
                    this.f16808d.f16826b = a.j().a();
                }
                if (this.aQ) {
                    this.aQ = false;
                    this.aF.m17242b(false);
                    this.aF.m17240b(a2);
                } else {
                    this.aF.m17236a(a2);
                }
                this.f16808d.m17223a(a2);
            }
        }
    }

    public static void m17192a(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment, Cursor cursor) {
        eventsDiscoveryDashboardFragment.f16813i.m17153b(LoadingState.DB_FETCH);
        int count = cursor == null ? 0 : cursor.getCount();
        if (count == 0) {
            eventsDiscoveryDashboardFragment.aO = eventsDiscoveryDashboardFragment.ap.m16929c();
        }
        if (cursor == null || cursor.isClosed() || (count <= 0 && !eventsDiscoveryDashboardFragment.aO)) {
            eventsDiscoveryDashboardFragment.aL();
            return;
        }
        ImmutableList a = eventsDiscoveryDashboardFragment.f16810f.m17164a(cursor, 14);
        if (count > 0) {
            eventsDiscoveryDashboardFragment.ap.m16928b();
        }
        if (eventsDiscoveryDashboardFragment.aL) {
            eventsDiscoveryDashboardFragment.aK = true;
        }
        eventsDiscoveryDashboardFragment.aF.m17236a(a);
        EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager = eventsDiscoveryDashboardFragment.f16808d;
        FutureCallback futureCallback = eventsDiscoveryDashboardFragment.bk;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Event event = (Event) a.get(i);
            eventsDiscoveryDashboardPager.f16837m.a(futureCallback, event.a, new GraphQLResult(EventGraphQLModelHelper.m19259a(event), DataFreshnessResult.FROM_CACHE_STALE, eventsDiscoveryDashboardPager.f16832h.a(), ImmutableSet.of(event.a)));
        }
        eventsDiscoveryDashboardFragment.aO = true;
        eventsDiscoveryDashboardFragment.aP = "warm";
    }

    private void aL() {
        if (this.aW != null) {
            this.aW.a(new Runnable(this) {
                final /* synthetic */ EventsDiscoveryDashboardFragment f16790a;

                {
                    this.f16790a = r1;
                }

                public void run() {
                    Cursor cursor = this.f16790a.aW == null ? null : (Cursor) FutureUtils.a(this.f16790a.aW);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }, this.f16805a);
        }
    }
}
