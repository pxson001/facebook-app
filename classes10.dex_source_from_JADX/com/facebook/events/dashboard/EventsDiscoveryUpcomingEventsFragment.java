package com.facebook.events.dashboard;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventDeletedEvent;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUpcomingEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUpcomingEventsQueryModel.AllEventsModel;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.graphql.calls.AllowedStatesInputAllowedStates;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.google.android.apps.photos.content */
public class EventsDiscoveryUpcomingEventsFragment extends FbFragment {
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f16880a;
    public EventsDiscoveryDashboardViewAdapter al;
    private EventAnalyticsParams am;
    private int an;
    public boolean ao;
    private boolean ap;
    private List<AllowedStatesInputAllowedStates> aq;
    public ListenableFuture<Cursor> ar;
    private ListenableFuture<GraphQLResult<FetchUpcomingEventsQueryModel>> as;
    private final EventDeletedEventSubscriber at = new EventDeletedEventSubscriber(this);
    private final EventUpdatedEventSubscriber au = new EventUpdatedEventSubscriber(this);
    private final FutureCallback<GraphQLResult<EventCommonFragmentModel>> av = new C23611(this);
    public final AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> aw = new C23622(this);
    @Inject
    EventsDiscoveryDashboardEventsLoader f16881b;
    @Inject
    EventsDiscoveryDashboardViewAdapterProvider f16882c;
    @Inject
    EventsDiscoveryDashboardPager f16883d;
    @Inject
    EventsEventBus f16884e;
    @Inject
    FbTitleBarSupplier f16885f;
    @Inject
    TasksManager f16886g;
    @Inject
    QeAccessor f16887h;
    private BetterRecyclerView f16888i;

    /* compiled from: com.google.android.apps.photos.content */
    class C23611 implements FutureCallback<GraphQLResult<EventCommonFragmentModel>> {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16872a;

        C23611(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16872a = eventsDiscoveryUpcomingEventsFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                EventCommonFragment eventCommonFragment = (EventCommonFragmentModel) graphQLResult.e;
                if (this.f16872a.al != null && eventCommonFragment != null) {
                    this.f16872a.al.m17235a(EventGraphQLModelHelper.m19277b(eventCommonFragment));
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    class C23622 extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventPermalinkFragmentModel>> {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16873a;

        C23622(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16873a = eventsDiscoveryUpcomingEventsFragment;
        }

        protected final void m17248a(Object obj) {
            FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) ((GraphQLResult) obj).e;
            if (fetchEventPermalinkFragmentModel != null) {
                this.f16873a.al.m17235a(EventGraphQLModelHelper.m19260a(fetchEventPermalinkFragmentModel));
            }
        }

        protected final void m17249a(Throwable th) {
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    class C23633 extends AbstractDisposableFutureCallback<Cursor> {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16874a;

        C23633(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16874a = eventsDiscoveryUpcomingEventsFragment;
        }

        protected final void m17250a(Object obj) {
            EventsDiscoveryUpcomingEventsFragment.m17257a(this.f16874a, (Cursor) obj);
        }

        protected final void m17251a(Throwable th) {
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    class C23644 extends AbstractDisposableFutureCallback<GraphQLResult<FetchUpcomingEventsQueryModel>> {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16875a;

        C23644(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16875a = eventsDiscoveryUpcomingEventsFragment;
        }

        protected final void m17252a(Object obj) {
            EventsDiscoveryUpcomingEventsFragment.m17258a(this.f16875a, (GraphQLResult) obj);
        }

        protected final void m17253a(Throwable th) {
            this.f16875a.al.m17242b(false);
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    class C23655 implements Runnable {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16876a;

        C23655(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16876a = eventsDiscoveryUpcomingEventsFragment;
        }

        public void run() {
            Cursor cursor = this.f16876a.ar == null ? null : (Cursor) FutureUtils.a(this.f16876a.ar);
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    public class C23666 extends OnScrollListener {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16877a;

        public C23666(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16877a = eventsDiscoveryUpcomingEventsFragment;
        }

        public final void m17254a(RecyclerView recyclerView, int i, int i2) {
            if (this.f16877a.ao) {
                EventsDiscoveryUpcomingEventsFragment.at(this.f16877a);
            }
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    class EventDeletedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventDeletedEventSubscriber {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16878a;

        public EventDeletedEventSubscriber(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16878a = eventsDiscoveryUpcomingEventsFragment;
        }

        public final void m17255b(FbEvent fbEvent) {
            this.f16878a.al.m17237a(((EventDeletedEvent) fbEvent).a);
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    class EventUpdatedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventUpdatedEventSubscriber {
        final /* synthetic */ EventsDiscoveryUpcomingEventsFragment f16879a;

        public EventUpdatedEventSubscriber(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
            this.f16879a = eventsDiscoveryUpcomingEventsFragment;
        }

        public final void m17256b(FbEvent fbEvent) {
            EventUpdatedEvent eventUpdatedEvent = (EventUpdatedEvent) fbEvent;
            if (eventUpdatedEvent.a != null) {
                this.f16879a.f16886g.a(Tasks.FETCH_SINGLE_EVENT, this.f16879a.f16883d.m17220a(this.f16879a.getContext(), eventUpdatedEvent.a), this.f16879a.aw);
            }
        }
    }

    /* compiled from: com.google.android.apps.photos.content */
    enum Tasks {
        DB_FETCH,
        FETCH_SINGLE_EVENT,
        FETCH_EVENT_COUNTS
    }

    public static void m17260a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsDiscoveryUpcomingEventsFragment) obj).m17259a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), EventsDiscoveryDashboardEventsLoader.m17163b(fbInjector), (EventsDiscoveryDashboardViewAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventsDiscoveryDashboardViewAdapterProvider.class), EventsDiscoveryDashboardPager.m17218b(fbInjector), EventsEventBus.a(fbInjector), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), TasksManager.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public final void m17265c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventsDiscoveryUpcomingEventsFragment.class;
        m17260a((Object) this, getContext());
        String string = this.s.getString("extra_ref_module");
        this.am = new EventAnalyticsParams(EventActionContext.a, string, "event_dashboard_all_upcoming", null);
        this.an = jW_().getDimensionPixelSize(2131431107);
        if (this.f16887h.a(ExperimentsForEventsGatingModule.u, false)) {
            this.aq = Arrays.asList(new AllowedStatesInputAllowedStates[]{AllowedStatesInputAllowedStates.PUBLISHED, AllowedStatesInputAllowedStates.CANCELED});
        } else {
            this.aq = Arrays.asList(new AllowedStatesInputAllowedStates[]{AllowedStatesInputAllowedStates.PUBLISHED});
        }
        this.ar = this.f16881b.m17165a(DashboardFilterType.UPCOMING);
        ar();
        this.f16883d.f16827c = this.av;
        this.al = this.f16882c.m17247a(DashboardFilterType.UPCOMING, Boolean.valueOf(false), getContext(), this.am, null, null, string, null);
        this.f16884e.a(this.at);
        this.f16884e.a(this.au);
    }

    public final View m17263a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1964353234);
        View inflate = layoutInflater.inflate(2130904152, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 610800589, a);
        return inflate;
    }

    public final void m17264a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f16888i = (BetterRecyclerView) e(2131561545);
        this.f16888i.setLayoutManager(new BetterLinearLayoutManager(getContext()));
        this.f16888i.setAdapter(this.al);
        this.f16888i.a(new C23666(this));
        this.ap = true;
        m17261b();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 551019179);
        super.mi_();
        ((FbTitleBar) this.f16885f.get()).setTitle(jW_().getString(2131237123));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -140761889, a);
    }

    private void m17261b() {
        m17262e();
        if (this.ap) {
            if (this.ar != null && this.ar.isDone()) {
                m17257a(this, (Cursor) FutureUtils.a(this.ar));
            } else if (!(this.ar == null || this.ar.isCancelled())) {
                this.f16886g.a(Tasks.DB_FETCH, this.ar, new C23633(this));
            }
            this.ar = null;
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1206700659);
        this.f16884e.b(this.at);
        this.f16884e.b(this.au);
        if (this.al != null) {
            this.al.m17246f();
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -125244387, a);
    }

    private void m17262e() {
        if (this.as.isDone()) {
            m17258a(this, (GraphQLResult) FutureUtils.a(this.as));
            aq();
            this.as = null;
        } else if (!this.as.isCancelled()) {
            this.f16886g.a(EventsDashboardPagerTaskType.FETCH_EVENTS_FOR_DISCOVERY_SURFACE, this.as, new C23644(this));
            this.as = null;
        }
    }

    public static void m17257a(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment, Cursor cursor) {
        if ((cursor == null ? 0 : cursor.getCount()) > 0) {
            eventsDiscoveryUpcomingEventsFragment.al.m17236a(eventsDiscoveryUpcomingEventsFragment.f16881b.m17164a(cursor, 14));
        } else {
            eventsDiscoveryUpcomingEventsFragment.aq();
        }
    }

    private void m17259a(ListeningExecutorService listeningExecutorService, EventsDiscoveryDashboardEventsLoader eventsDiscoveryDashboardEventsLoader, EventsDiscoveryDashboardViewAdapterProvider eventsDiscoveryDashboardViewAdapterProvider, EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager, EventsEventBus eventsEventBus, FbTitleBarSupplier fbTitleBarSupplier, TasksManager tasksManager, QeAccessor qeAccessor) {
        this.f16880a = listeningExecutorService;
        this.f16881b = eventsDiscoveryDashboardEventsLoader;
        this.f16882c = eventsDiscoveryDashboardViewAdapterProvider;
        this.f16883d = eventsDiscoveryDashboardPager;
        this.f16884e = eventsEventBus;
        this.f16885f = fbTitleBarSupplier;
        this.f16886g = tasksManager;
        this.f16887h = qeAccessor;
    }

    private void aq() {
        if (this.ar != null) {
            this.ar.a(new C23655(this), this.f16880a);
        }
    }

    private void ar() {
        this.as = this.f16883d.m17221a(DashboardFilterType.UPCOMING, this.ao, this.an, this.aq);
    }

    public static void m17258a(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment, GraphQLResult graphQLResult) {
        if (graphQLResult.e != null) {
            AllEventsModel a = ((FetchUpcomingEventsQueryModel) graphQLResult.e).a();
            if (a != null) {
                ImmutableList a2 = eventsDiscoveryUpcomingEventsFragment.f16883d.m17219a(a.a(), graphQLResult);
                if (eventsDiscoveryUpcomingEventsFragment.ap) {
                    eventsDiscoveryUpcomingEventsFragment.al.m17236a(a2);
                } else {
                    eventsDiscoveryUpcomingEventsFragment.al.m17242b(false);
                    eventsDiscoveryUpcomingEventsFragment.al.m17240b(a2);
                }
                if (a.j() != null) {
                    eventsDiscoveryUpcomingEventsFragment.f16883d.f16825a = a.j().a();
                    eventsDiscoveryUpcomingEventsFragment.ao = a.j().j();
                } else {
                    eventsDiscoveryUpcomingEventsFragment.ao = false;
                }
                eventsDiscoveryUpcomingEventsFragment.f16883d.m17223a(a2);
            }
        }
    }

    public static void at(EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment) {
        eventsDiscoveryUpcomingEventsFragment.ap = false;
        eventsDiscoveryUpcomingEventsFragment.al.m17242b(true);
        eventsDiscoveryUpcomingEventsFragment.ar();
        eventsDiscoveryUpcomingEventsFragment.m17262e();
    }
}
