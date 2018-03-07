package com.facebook.events.dashboard.subscriptions;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.device.ScreenUtil;
import com.facebook.events.carousel.EventsCarouselPagerAdapter;
import com.facebook.events.graphql.EventsGraphQL.FetchSubscribedEventsString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedCalendarProfilesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.PageInfoModel;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: commerce/products/{#%s} */
public class EventsSubscriptionsPager {
    public final GraphQLQueryExecutor f17183a;
    public final ScreenUtil f17184b;
    private final TasksManager<String> f17185c;
    private final GraphQLSubscriptionHolder f17186d;
    private final FutureCallback<GraphQLResult<NodesModel>> f17187e = new C24071(this);
    public EventsCarouselPagerAdapter f17188f;

    /* compiled from: commerce/products/{#%s} */
    public interface EventsSubscriptionsCallback {
        void mo785a(@Nonnull List<NodesModel> list, int i, String str, boolean z);
    }

    /* compiled from: commerce/products/{#%s} */
    class C24071 implements FutureCallback<GraphQLResult<NodesModel>> {
        final /* synthetic */ EventsSubscriptionsPager f17176a;

        C24071(EventsSubscriptionsPager eventsSubscriptionsPager) {
            this.f17176a = eventsSubscriptionsPager;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                EventCommonFragment eventCommonFragment = (NodesModel) graphQLResult.e;
                if (this.f17176a.f17188f != null) {
                    this.f17176a.f17188f.m16432a(eventCommonFragment);
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    public static EventsSubscriptionsPager m17508b(InjectorLike injectorLike) {
        return new EventsSubscriptionsPager(GraphQLQueryExecutor.a(injectorLike), ScreenUtil.a(injectorLike), TasksManager.b(injectorLike), GraphQLSubscriptionHolder.b(injectorLike));
    }

    @Inject
    public EventsSubscriptionsPager(GraphQLQueryExecutor graphQLQueryExecutor, ScreenUtil screenUtil, TasksManager tasksManager, GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        this.f17183a = graphQLQueryExecutor;
        this.f17184b = screenUtil;
        this.f17185c = tasksManager;
        this.f17186d = graphQLSubscriptionHolder;
    }

    public final void m17510a(final int i, final int i2, final String str, @Nonnull final EventsSubscriptionsCallback eventsSubscriptionsCallback) {
        this.f17185c.a("FetchSubscriptions", new Callable<ListenableFuture<GraphQLResult<FetchSubscribedEventsModel>>>(this) {
            final /* synthetic */ EventsSubscriptionsPager f17180d;

            public Object call() {
                return this.f17180d.f17183a.a(GraphQLRequest.a((FetchSubscribedEventsString) new FetchSubscribedEventsString().a("end_cursor", str).a("count", String.valueOf(i2)).a("profile_image_size", String.valueOf(i)).a("cover_image_portrait_size", Integer.valueOf(this.f17180d.f17184b.f())).a("cover_image_landscape_size", Integer.valueOf(this.f17180d.f17184b.g()))));
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchSubscribedEventsModel>>(this) {
            final /* synthetic */ EventsSubscriptionsPager f17182b;

            protected final void m17505a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                boolean z = false;
                if (graphQLResult.e != null && ((FetchSubscribedEventsModel) graphQLResult.e).j() != null) {
                    SubscribedProfileCalendarEventsModel j = ((FetchSubscribedEventsModel) graphQLResult.e).j();
                    ImmutableList a = j.a();
                    List arrayList = new ArrayList(a.size());
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        NodesModel nodesModel = (NodesModel) a.get(i);
                        GraphQLEventGuestStatus o = nodesModel.o();
                        if ((o == GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || o == GraphQLEventGuestStatus.SUBSCRIBED_ADMIN_CALENDAR || o == GraphQLEventGuestStatus.NOT_GOING) && nodesModel.R() != GraphQLSavedState.SAVED) {
                            arrayList.add(nodesModel);
                        }
                    }
                    SubscribedCalendarProfilesModel a2 = ((FetchSubscribedEventsModel) graphQLResult.e).a();
                    int a3 = a2 == null ? 0 : a2.a();
                    PageInfoModel j2 = j.j();
                    EventsSubscriptionsCallback eventsSubscriptionsCallback = eventsSubscriptionsCallback;
                    String a4 = j2 == null ? null : j2.a();
                    if (j2 != null && j2.j()) {
                        z = true;
                    }
                    eventsSubscriptionsCallback.mo785a(arrayList, a3, a4, z);
                    EventsSubscriptionsPager.m17507a(this.f17182b, arrayList, graphQLResult);
                }
            }

            protected final void m17506a(Throwable th) {
                eventsSubscriptionsCallback.mo785a(Collections.emptyList(), 0, null, false);
            }
        });
    }

    public final void m17509a() {
        this.f17185c.c();
    }

    public static void m17507a(EventsSubscriptionsPager eventsSubscriptionsPager, List list, GraphQLResult graphQLResult) {
        for (NodesModel nodesModel : list) {
            Set hashSet = new HashSet();
            hashSet.add(nodesModel.dL_());
            eventsSubscriptionsPager.f17186d.a(eventsSubscriptionsPager.f17187e, nodesModel.dL_(), new GraphQLResult(nodesModel, graphQLResult.freshness, graphQLResult.clientTimeMs, hashSet));
        }
    }
}
