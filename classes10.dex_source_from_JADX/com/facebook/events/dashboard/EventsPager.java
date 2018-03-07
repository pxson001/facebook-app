package com.facebook.events.dashboard;

import android.content.ContentResolver;
import android.database.Cursor;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.events.dashboard.EventsDashboardSequenceLogger.LoadingState;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.FetchAllUpcomingEventsQueryString;
import com.facebook.events.graphql.EventsGraphQL.FetchPastEventsQueryString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchAllUpcomingEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchAllUpcomingEventsQueryModel.EventsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchPastEventsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchPastEventsQueryModel.AllEventsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchPastEventsQueryModel.AllEventsModel.PageInfoModel;
import com.facebook.events.model.Event;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: commerce/collectionview/{#%s} */
public class EventsPager {
    private final Clock f16914a;
    public final ContentResolver f16915b;
    public final EventsCommonContract f16916c;
    public final EventsDashboardSequenceLogger f16917d;
    public final GraphQLQueryExecutor f16918e;
    public final ListeningExecutorService f16919f;
    public final ScreenUtil f16920g;
    public final TasksManager f16921h;
    public final int f16922i;
    public String f16923j;
    public boolean f16924k = false;
    public boolean f16925l = true;
    public String f16926m;
    public boolean f16927n = false;
    public boolean f16928o = true;
    public ImmutableList<EventCommonFragmentModel> f16929p = RegularImmutableList.a;

    /* compiled from: commerce/collectionview/{#%s} */
    public interface EventsPagerCallback {
        void mo786a();

        void mo787a(boolean z, int i, Long l);
    }

    /* compiled from: commerce/collectionview/{#%s} */
    public class C23715 implements Callable<ListenableFuture<GraphQLResult<FetchPastEventsQueryModel>>> {
        final /* synthetic */ int f16901a;
        final /* synthetic */ EventsPager f16902b;

        public C23715(EventsPager eventsPager, int i) {
            this.f16902b = eventsPager;
            this.f16901a = i;
        }

        public Object call() {
            GraphQLRequest a = GraphQLRequest.a(EventsGraphQL.g());
            a.a(new FetchPastEventsQueryString().a("profile_image_size", String.valueOf(this.f16901a)).a("cover_image_portrait_size", Integer.valueOf(this.f16902b.f16920g.f())).a("cover_image_landscape_size", Integer.valueOf(this.f16902b.f16920g.g())).a("after_cursor", this.f16902b.f16926m).a("first_count", String.valueOf(this.f16902b.f16922i)).a);
            return this.f16902b.f16918e.a(a);
        }
    }

    /* compiled from: commerce/collectionview/{#%s} */
    public class C23726 extends AbstractDisposableFutureCallback<GraphQLResult<FetchPastEventsQueryModel>> {
        final /* synthetic */ EventsPagerCallback f16903a;
        final /* synthetic */ EventsPager f16904b;

        public C23726(EventsPager eventsPager, EventsPagerCallback eventsPagerCallback) {
            this.f16904b = eventsPager;
            this.f16903a = eventsPagerCallback;
        }

        protected final void m17269a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            String str = null;
            if (graphQLResult.e != null) {
                AllEventsModel a = ((FetchPastEventsQueryModel) graphQLResult.e).a();
                if (a != null) {
                    Long l;
                    boolean z;
                    EventsPager.m17273a(this.f16904b, a.a());
                    if (a.a().isEmpty()) {
                        l = null;
                    } else {
                        l = Long.valueOf(EventGraphQLModelHelper.m19277b((EventCommonFragment) a.a().get(a.a().size() - 1)).K());
                    }
                    PageInfoModel j = a.j();
                    EventsPager eventsPager = this.f16904b;
                    if (j != null) {
                        str = j.a();
                    }
                    eventsPager.f16926m = str;
                    eventsPager = this.f16904b;
                    if (j == null || !j.j()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    eventsPager.f16928o = z;
                    if (this.f16903a != null) {
                        this.f16903a.mo787a(this.f16904b.f16928o, a.a().size(), l);
                    }
                }
            } else if (this.f16903a != null) {
                this.f16903a.mo786a();
            }
        }

        protected final void m17270a(Throwable th) {
            if (this.f16903a != null) {
                this.f16903a.mo786a();
            }
        }
    }

    /* compiled from: commerce/collectionview/{#%s} */
    public enum EventsDashboardPagerTaskType {
        FETCH_UPCOMING_EVENTS,
        FETCH_PAST_EVENTS
    }

    /* compiled from: commerce/collectionview/{#%s} */
    public class EventsPagerEarlyFetchFutureHolder {
        @Nullable
        public final ListenableFuture<Cursor> f16908a;
        public final EventsPager f16909b;
        public final int f16910c;
        public final ListenableFuture<GraphQLResult<FetchAllUpcomingEventsQueryModel>> f16911d;
        public final long f16912e;
        public final ListeningExecutorService f16913f;

        /* compiled from: commerce/collectionview/{#%s} */
        public class C23741 implements Runnable {
            final /* synthetic */ EventsPagerEarlyFetchFutureHolder f16907a;

            public C23741(EventsPagerEarlyFetchFutureHolder eventsPagerEarlyFetchFutureHolder) {
                this.f16907a = eventsPagerEarlyFetchFutureHolder;
            }

            public void run() {
                Cursor cursor = (Cursor) FutureUtils.a(this.f16907a.f16908a);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }

        public EventsPagerEarlyFetchFutureHolder(ListeningExecutorService listeningExecutorService, ListenableFuture<Cursor> listenableFuture, EventsPager eventsPager, int i, ListenableFuture<GraphQLResult<FetchAllUpcomingEventsQueryModel>> listenableFuture2, long j) {
            this.f16913f = listeningExecutorService;
            this.f16908a = listenableFuture;
            this.f16909b = eventsPager;
            this.f16910c = i;
            this.f16911d = listenableFuture2;
            this.f16912e = j;
        }
    }

    public static EventsPager m17274b(InjectorLike injectorLike) {
        return new EventsPager((Clock) SystemClockMethodAutoProvider.a(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), EventsCommonContract.b(injectorLike), EventsDashboardSequenceLogger.m17147a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ScreenUtil.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public EventsPager(Clock clock, ContentResolver contentResolver, EventsCommonContract eventsCommonContract, EventsDashboardSequenceLogger eventsDashboardSequenceLogger, GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, ScreenUtil screenUtil, TasksManager tasksManager) {
        this.f16914a = clock;
        this.f16915b = contentResolver;
        this.f16916c = eventsCommonContract;
        this.f16917d = eventsDashboardSequenceLogger;
        this.f16918e = graphQLQueryExecutor;
        this.f16919f = listeningExecutorService;
        this.f16920g = screenUtil;
        this.f16921h = tasksManager;
        this.f16922i = 12;
    }

    public final void m17278a() {
        this.f16921h.c(EventsDashboardPagerTaskType.FETCH_UPCOMING_EVENTS);
        this.f16921h.c(EventsDashboardPagerTaskType.FETCH_PAST_EVENTS);
        this.f16923j = null;
        this.f16924k = false;
        this.f16925l = true;
        this.f16926m = null;
        this.f16927n = false;
        this.f16928o = true;
        this.f16929p = RegularImmutableList.a;
    }

    public final Runnable m17276a(int i, @Nullable EventsPagerCallback eventsPagerCallback) {
        Preconditions.checkArgument(!this.f16924k, "query session exists before first fetch");
        long a = this.f16914a.a();
        this.f16924k = true;
        this.f16923j = null;
        this.f16925l = true;
        final ListenableFuture a2 = m17272a(this, i);
        this.f16917d.m17151a(LoadingState.NETWORK_FETCH);
        final AbstractDisposableFutureCallback a3 = m17271a(i, eventsPagerCallback, a);
        return new Runnable(this) {
            final /* synthetic */ EventsPager f16891c;

            public void run() {
                if (this.f16891c.f16924k) {
                    this.f16891c.f16921h.a(EventsDashboardPagerTaskType.FETCH_UPCOMING_EVENTS, a2, a3);
                }
            }
        };
    }

    public final EventsPagerEarlyFetchFutureHolder m17275a(ListenableFuture<Cursor> listenableFuture, int i) {
        long a = this.f16914a.a();
        return new EventsPagerEarlyFetchFutureHolder(this.f16919f, listenableFuture, this, i, m17272a(this, i), a);
    }

    public final Runnable m17277a(EventsPagerEarlyFetchFutureHolder eventsPagerEarlyFetchFutureHolder, @Nullable EventsPagerCallback eventsPagerCallback) {
        Preconditions.checkArgument(!this.f16924k, "query session exists before first fetch");
        long j = eventsPagerEarlyFetchFutureHolder.f16912e;
        int i = eventsPagerEarlyFetchFutureHolder.f16910c;
        this.f16924k = true;
        this.f16923j = null;
        this.f16925l = true;
        final ListenableFuture listenableFuture = eventsPagerEarlyFetchFutureHolder.f16911d;
        this.f16917d.m17151a(LoadingState.NETWORK_FETCH);
        final AbstractDisposableFutureCallback a = m17271a(i, eventsPagerCallback, j);
        return new Runnable(this) {
            final /* synthetic */ EventsPager f16894c;

            public void run() {
                if (this.f16894c.f16924k) {
                    this.f16894c.f16921h.a(EventsDashboardPagerTaskType.FETCH_UPCOMING_EVENTS, listenableFuture, a);
                }
            }
        };
    }

    public final void m17279b(final int i, @Nullable EventsPagerCallback eventsPagerCallback) {
        if (!this.f16921h.a(EventsDashboardPagerTaskType.FETCH_UPCOMING_EVENTS)) {
            long a = this.f16914a.a();
            if (!this.f16924k) {
                this.f16924k = true;
                this.f16923j = null;
                this.f16925l = true;
            } else if (!this.f16925l) {
                if (eventsPagerCallback != null) {
                    eventsPagerCallback.mo787a(this.f16925l, 0, null);
                    return;
                }
                return;
            }
            this.f16921h.a(EventsDashboardPagerTaskType.FETCH_UPCOMING_EVENTS, new Callable<ListenableFuture<GraphQLResult<FetchAllUpcomingEventsQueryModel>>>(this) {
                final /* synthetic */ EventsPager f16896b;

                public Object call() {
                    return EventsPager.m17272a(this.f16896b, i);
                }
            }, m17271a(i, eventsPagerCallback, a));
        }
    }

    private AbstractDisposableFutureCallback<GraphQLResult<FetchAllUpcomingEventsQueryModel>> m17271a(int i, EventsPagerCallback eventsPagerCallback, long j) {
        final EventsPagerCallback eventsPagerCallback2 = eventsPagerCallback;
        final long j2 = j;
        final int i2 = i;
        return new AbstractDisposableFutureCallback<GraphQLResult<FetchAllUpcomingEventsQueryModel>>(this) {
            final /* synthetic */ EventsPager f16900d;

            protected final void m17267a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f16900d.f16917d.m17153b(LoadingState.NETWORK_FETCH);
                if (graphQLResult.e == null) {
                    eventsPagerCallback2.mo786a();
                    return;
                }
                EventsModel a = ((FetchAllUpcomingEventsQueryModel) graphQLResult.e).a();
                if (a != null) {
                    Long l;
                    EventsPager.m17273a(this.f16900d, a.a());
                    if (a.a().isEmpty()) {
                        l = null;
                    } else {
                        l = Long.valueOf(EventGraphQLModelHelper.m19277b((EventCommonFragment) a.a().get(a.a().size() - 1)).K());
                    }
                    if (a.j() != null) {
                        this.f16900d.f16923j = a.j().a();
                        this.f16900d.f16925l = a.j().j();
                    } else {
                        this.f16900d.f16923j = null;
                        this.f16900d.f16925l = false;
                    }
                    if (l != null && l.longValue() < j2) {
                        this.f16900d.m17279b(i2, eventsPagerCallback2);
                    } else if (eventsPagerCallback2 != null) {
                        eventsPagerCallback2.mo787a(this.f16900d.f16925l, a.a().size(), l);
                    }
                }
            }

            protected final void m17268a(Throwable th) {
                eventsPagerCallback2.mo786a();
            }
        };
    }

    public static ListenableFuture m17272a(EventsPager eventsPager, int i) {
        return eventsPager.f16918e.a(GraphQLRequest.a(new FetchAllUpcomingEventsQueryString()).a(new FetchAllUpcomingEventsQueryString().a("profile_image_size", String.valueOf(i)).a("cover_image_portrait_size", Integer.valueOf(eventsPager.f16920g.f())).a("cover_image_landscape_size", Integer.valueOf(eventsPager.f16920g.g())).a("after_cursor", eventsPager.f16923j).a("first_count", String.valueOf(eventsPager.f16922i)).a));
    }

    public static void m17273a(EventsPager eventsPager, final ImmutableList immutableList) {
        ExecutorDetour.a(eventsPager.f16919f, new Runnable(eventsPager) {
            final /* synthetic */ EventsPager f16906b;

            public void run() {
                long j = Long.MAX_VALUE;
                long j2 = 0;
                List a = Lists.a();
                int size = immutableList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    int size2;
                    Event b = EventGraphQLModelHelper.m19277b((EventCommonFragment) immutableList.get(i));
                    long K = b.K();
                    if (K < j) {
                        j = K;
                    }
                    if (K > j2) {
                        size2 = a.size();
                        j2 = K;
                    } else {
                        size2 = i2;
                    }
                    a.add(b.a);
                    if (a.size() == 1) {
                        this.f16906b.f16917d.m17151a(LoadingState.DB_UPDATE);
                        EventsProvider.a(this.f16906b.f16915b, this.f16906b.f16916c, b);
                        this.f16906b.f16917d.m17153b(LoadingState.DB_UPDATE);
                    } else {
                        EventsProvider.a(this.f16906b.f16915b, this.f16906b.f16916c, b);
                    }
                    i++;
                    i2 = size2;
                }
                this.f16906b.f16929p = immutableList.subList(i2, immutableList.size());
                EventsProvider.a(this.f16906b.f16915b, this.f16906b.f16916c, j, j2, a);
            }
        }, 506338038);
    }
}
