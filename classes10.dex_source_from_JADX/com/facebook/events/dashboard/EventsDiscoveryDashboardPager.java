package com.facebook.events.dashboard;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.dashboard.EventsDashboardSequenceLogger.LoadingState;
import com.facebook.events.dashboard.EventsDiscoveryDashboardFragment.AnonymousClass13;
import com.facebook.events.dashboard.EventsDiscoveryDashboardFragment.C23464;
import com.facebook.events.dashboard.birthdays.BirthdaysPager;
import com.facebook.events.dashboard.birthdays.BirthdaysPager.BirthdaysPagerCallback;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable.Columns;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.FetchEventPermalinkQueryString;
import com.facebook.events.graphql.EventsGraphQL.FetchUpcomingEventsQueryString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUpcomingEventsQueryModel;
import com.facebook.events.model.Event;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.graphql.calls.AllowedStatesInputAllowedStates;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.wearable.BIND_LISTENER */
public class EventsDiscoveryDashboardPager {
    public String f16825a;
    public String f16826b;
    public FutureCallback<GraphQLResult<EventCommonFragmentModel>> f16827c;
    public boolean f16828d = true;
    public String f16829e;
    public String f16830f;
    public final BirthdaysPager f16831g;
    public final Clock f16832h;
    public final ContentResolver f16833i;
    public final EventsCommonContract f16834j;
    public final EventsDashboardSequenceLogger f16835k;
    public final GraphQLQueryExecutor f16836l;
    public final GraphQLSubscriptionHolder f16837m;
    public final ListeningExecutorService f16838n;
    public final QeAccessor f16839o;
    public final ScreenUtil f16840p;
    public final TasksManager f16841q;

    /* compiled from: com.google.android.gms.wearable.BIND_LISTENER */
    public class C23521 implements Runnable {
        final /* synthetic */ EventCommonFragmentModel f16814a;
        final /* synthetic */ EventsDiscoveryDashboardPager f16815b;

        public C23521(EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager, EventCommonFragmentModel eventCommonFragmentModel) {
            this.f16815b = eventsDiscoveryDashboardPager;
            this.f16814a = eventCommonFragmentModel;
        }

        public void run() {
            Event b = EventGraphQLModelHelper.m19277b(this.f16814a);
            this.f16815b.f16835k.m17151a(LoadingState.DB_UPDATE);
            EventsProvider.a(this.f16815b.f16833i, this.f16815b.f16834j, b);
            this.f16815b.f16835k.m17153b(LoadingState.DB_UPDATE);
        }
    }

    /* compiled from: com.google.android.gms.wearable.BIND_LISTENER */
    public class C23532 implements Runnable {
        final /* synthetic */ EventCommonFragmentModel f16816a;
        final /* synthetic */ EventsDiscoveryDashboardPager f16817b;

        public C23532(EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager, EventCommonFragmentModel eventCommonFragmentModel) {
            this.f16817b = eventsDiscoveryDashboardPager;
            this.f16816a = eventCommonFragmentModel;
        }

        public void run() {
            this.f16817b.f16835k.m17151a(LoadingState.DB_UPDATE);
            ContentResolver contentResolver = this.f16817b.f16833i;
            Uri c = this.f16817b.f16834j.c(this.f16816a.dL_());
            EventCommonFragmentModel eventCommonFragmentModel = this.f16816a;
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.c.toString(), eventCommonFragmentModel.dM_());
            if (EventsDateUtil.a(eventCommonFragmentModel.dN_())) {
                contentValues.put(Columns.H.toString(), Long.valueOf(eventCommonFragmentModel.dN_() * 1000));
                if (EventsDateUtil.a(eventCommonFragmentModel.b())) {
                    contentValues.put(Columns.I.toString(), Long.valueOf(eventCommonFragmentModel.b() * 1000));
                } else {
                    contentValues.putNull(Columns.I.toString());
                }
                if (eventCommonFragmentModel.n() != null) {
                    contentValues.put(Columns.J.toString(), eventCommonFragmentModel.n());
                } else {
                    contentValues.putNull(Columns.J.toString());
                }
            }
            if (eventCommonFragmentModel.o() != null) {
                contentValues.put(Columns.A.toString(), eventCommonFragmentModel.o().name());
            }
            if (eventCommonFragmentModel.q() != null) {
                contentValues.put(Columns.B.toString(), eventCommonFragmentModel.q().name());
            }
            contentValues.put(Columns.F.toString(), Boolean.valueOf(eventCommonFragmentModel.p()));
            if (eventCommonFragmentModel.ab() != null) {
                contentValues.put(Columns.P.toString(), eventCommonFragmentModel.ab().dU_());
                if (eventCommonFragmentModel.ab().j() != null) {
                    contentValues.put(Columns.L.toString(), eventCommonFragmentModel.ab().j().a());
                }
            }
            contentResolver.update(c, contentValues, null, null);
            this.f16817b.f16835k.m17153b(LoadingState.DB_UPDATE);
        }
    }

    /* compiled from: com.google.android.gms.wearable.BIND_LISTENER */
    public class C23554 implements BirthdaysPagerCallback {
        final /* synthetic */ C23464 f16820a;
        final /* synthetic */ EventsDiscoveryDashboardPager f16821b;

        public C23554(EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager, C23464 c23464) {
            this.f16821b = eventsDiscoveryDashboardPager;
            this.f16820a = c23464;
        }

        public final void mo788a(boolean z, String str, String str2, List<EventUserWithBirthdayFragmentModel> list) {
            this.f16821b.f16828d = z;
            this.f16821b.f16830f = str;
            this.f16821b.f16829e = str2;
            C23464 c23464 = this.f16820a;
            c23464.f16794a.aO = true;
            if (c23464.f16794a.aQ) {
                c23464.f16794a.aQ = false;
                c23464.f16794a.aF.m17241b(list, c23464.f16794a.aH);
                c23464.f16794a.aF.m17242b(false);
                return;
            }
            c23464.f16794a.aF.m17239a((List) list, c23464.f16794a.aH);
            c23464.f16794a.aG.setRefreshing(false);
        }
    }

    /* compiled from: com.google.android.gms.wearable.BIND_LISTENER */
    public class C23565 extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventPromptsModel>> {
        final /* synthetic */ AnonymousClass13 f16822a;
        final /* synthetic */ EventsDiscoveryDashboardPager f16823b;

        public C23565(EventsDiscoveryDashboardPager eventsDiscoveryDashboardPager, AnonymousClass13 anonymousClass13) {
            this.f16823b = eventsDiscoveryDashboardPager;
            this.f16822a = anonymousClass13;
        }

        protected final void m17215a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                FetchEventPromptsModel fetchEventPromptsModel = (FetchEventPromptsModel) graphQLResult.e;
                if (fetchEventPromptsModel != null && fetchEventPromptsModel.a() != null && !fetchEventPromptsModel.a().a().isEmpty()) {
                    AnonymousClass13 anonymousClass13 = this.f16822a;
                    anonymousClass13.f16783a.aF.m17234a(anonymousClass13.f16783a.aD, fetchEventPromptsModel.a().a());
                }
            }
        }

        protected final void m17216a(Throwable th) {
        }
    }

    public static EventsDiscoveryDashboardPager m17218b(InjectorLike injectorLike) {
        return new EventsDiscoveryDashboardPager(BirthdaysPager.m17292b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), EventsCommonContract.b(injectorLike), EventsDashboardSequenceLogger.m17147a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GraphQLSubscriptionHolder.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ScreenUtil.a(injectorLike), TasksManager.b(injectorLike));
    }

    public static EventsDiscoveryDashboardPager m17217a(InjectorLike injectorLike) {
        return m17218b(injectorLike);
    }

    @Inject
    public EventsDiscoveryDashboardPager(BirthdaysPager birthdaysPager, Clock clock, ContentResolver contentResolver, EventsCommonContract eventsCommonContract, EventsDashboardSequenceLogger eventsDashboardSequenceLogger, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLSubscriptionHolder graphQLSubscriptionHolder, ListeningExecutorService listeningExecutorService, QeAccessor qeAccessor, ScreenUtil screenUtil, TasksManager tasksManager) {
        this.f16831g = birthdaysPager;
        this.f16832h = clock;
        this.f16833i = contentResolver;
        this.f16834j = eventsCommonContract;
        this.f16835k = eventsDashboardSequenceLogger;
        this.f16836l = graphQLQueryExecutor;
        this.f16837m = graphQLSubscriptionHolder;
        this.f16838n = listeningExecutorService;
        this.f16839o = qeAccessor;
        this.f16840p = screenUtil;
        this.f16841q = tasksManager;
    }

    public final ListenableFuture<GraphQLResult<FetchEventPermalinkFragmentModel>> m17220a(Context context, String str) {
        FetchEventPermalinkQueryString fetchEventPermalinkQueryString = new FetchEventPermalinkQueryString();
        fetchEventPermalinkQueryString.a("event_id", str);
        fetchEventPermalinkQueryString.a("profile_image_size", String.valueOf(context.getResources().getDimensionPixelSize(2131431132)));
        fetchEventPermalinkQueryString.a("cover_image_portrait_size", Integer.valueOf(this.f16840p.f()));
        fetchEventPermalinkQueryString.a("cover_image_landscape_size", Integer.valueOf(this.f16840p.g()));
        fetchEventPermalinkQueryString.a("fetch_attending_activity", Boolean.valueOf(this.f16839o.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForEventsGatingModule.k, false)));
        fetchEventPermalinkQueryString.a("should_fetch_ticket_tiers", Boolean.valueOf(this.f16839o.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForEventsGatingModule.i, false)));
        return this.f16836l.a(GraphQLRequest.a(EventsGraphQL.b()).a(GraphQLCachePolicy.d).a(fetchEventPermalinkQueryString.a));
    }

    public final ListenableFuture<GraphQLResult<FetchUpcomingEventsQueryModel>> m17221a(DashboardFilterType dashboardFilterType, boolean z, int i, List<AllowedStatesInputAllowedStates> list) {
        String str;
        GraphQlQueryString a = new FetchUpcomingEventsQueryString().a("profile_image_size", String.valueOf(i)).a("cover_image_portrait_size", Integer.valueOf(this.f16840p.f())).a("cover_image_landscape_size", Integer.valueOf(this.f16840p.g())).a("first_count", "14");
        if (!(list == null || list.isEmpty())) {
            a.a("event_state", list);
        }
        switch (dashboardFilterType) {
            case HOSTING:
                str = "HOST";
                break;
            case INVITED:
                str = "INVITED";
                break;
            default:
                str = null;
                break;
        }
        String str2 = str;
        if (!Strings.isNullOrEmpty(str2)) {
            a.a("filter", str2);
        }
        if (z) {
            a.a("after_cursor", this.f16825a);
        }
        GraphQLRequest a2 = GraphQLRequest.a(EventsGraphQL.f()).a(a.a).a(GraphQLCachePolicy.d);
        a2.b = true;
        return this.f16836l.a(a2);
    }

    public final void m17222a() {
        this.f16825a = null;
        this.f16826b = null;
        this.f16830f = null;
        this.f16828d = true;
        this.f16829e = null;
    }

    public final ImmutableList<Event> m17219a(ImmutableList<EventCommonFragmentModel> immutableList, GraphQLResult graphQLResult) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            EventCommonFragment eventCommonFragment = (EventCommonFragment) immutableList.get(i);
            Set hashSet = new HashSet();
            hashSet.add(eventCommonFragment.dL_());
            this.f16837m.a(this.f16827c, eventCommonFragment.dL_(), new GraphQLResult(eventCommonFragment, graphQLResult.freshness, graphQLResult.clientTimeMs, hashSet));
            builder.c(EventGraphQLModelHelper.m19277b(eventCommonFragment));
        }
        return builder.b();
    }

    public final void m17223a(final ImmutableList<Event> immutableList) {
        ExecutorDetour.a(this.f16838n, new Runnable(this) {
            final /* synthetic */ EventsDiscoveryDashboardPager f16819b;

            public void run() {
                long j = Long.MAX_VALUE;
                long j2 = 0;
                List arrayList = new ArrayList(immutableList.size());
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    Event event = (Event) immutableList.get(i);
                    long K = event.K();
                    if (K < j) {
                        j = K;
                    }
                    if (K > j2) {
                        j2 = K;
                    }
                    arrayList.add(event.a);
                    if (arrayList.size() == 1) {
                        this.f16819b.f16835k.m17151a(LoadingState.DB_UPDATE);
                        EventsProvider.a(this.f16819b.f16833i, this.f16819b.f16834j, event);
                        this.f16819b.f16835k.m17153b(LoadingState.DB_UPDATE);
                    } else {
                        EventsProvider.a(this.f16819b.f16833i, this.f16819b.f16834j, event);
                    }
                }
                EventsProvider.a(this.f16819b.f16833i, this.f16819b.f16834j, j, j2, arrayList);
            }
        }, -101684347);
    }
}
