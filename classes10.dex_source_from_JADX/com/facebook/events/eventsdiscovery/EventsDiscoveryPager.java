package com.facebook.events.eventsdiscovery;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.eventsdiscovery.EventsDiscoveryFragment.C24271;
import com.facebook.events.eventsdiscovery.EventsDiscoveryFragment.C24282;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQL.FetchEventDiscoveryCategoryListString;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQL.FetchEventsDiscoveryFiltersString;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventDiscoveryCategoryListModel;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: com.facebook.internal.APP_SETTINGS.%s */
public class EventsDiscoveryPager {
    public final GraphQLQueryExecutor f17314a;
    private final TasksManager f17315b;

    /* compiled from: com.facebook.internal.APP_SETTINGS.%s */
    class C24431 implements Callable<ListenableFuture<GraphQLResult<FetchEventsDiscoveryFiltersModel>>> {
        final /* synthetic */ EventsDiscoveryPager f17308a;

        public Object call() {
            return this.f17308a.f17314a.a(GraphQLRequest.a(new FetchEventsDiscoveryFiltersString()));
        }

        C24431(EventsDiscoveryPager eventsDiscoveryPager) {
            this.f17308a = eventsDiscoveryPager;
        }
    }

    /* compiled from: com.facebook.internal.APP_SETTINGS.%s */
    class C24453 implements Callable<ListenableFuture<GraphQLResult<FetchEventDiscoveryCategoryListModel>>> {
        final /* synthetic */ EventsDiscoveryPager f17311a;

        public Object call() {
            return this.f17311a.f17314a.a(GraphQLRequest.a(new FetchEventDiscoveryCategoryListString()));
        }

        C24453(EventsDiscoveryPager eventsDiscoveryPager) {
            this.f17311a = eventsDiscoveryPager;
        }
    }

    @Inject
    public EventsDiscoveryPager(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f17314a = graphQLQueryExecutor;
        this.f17315b = tasksManager;
    }

    public final void m17600a(final C24271 c24271) {
        this.f17315b.a("fetchEventsDiscoveryTimeFilters", new C24431(this), new AbstractDisposableFutureCallback<GraphQLResult<FetchEventsDiscoveryFiltersModel>>(this) {
            final /* synthetic */ EventsDiscoveryPager f17310b;

            protected final void m17596a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult.e != null && ((FetchEventsDiscoveryFiltersModel) graphQLResult.e).m17651a() != null) {
                    c24271.m17557a(((FetchEventsDiscoveryFiltersModel) graphQLResult.e).m17651a());
                }
            }

            protected final void m17597a(Throwable th) {
                c24271.m17557a(Collections.EMPTY_LIST);
            }
        });
    }

    public final void m17601a(final C24282 c24282) {
        this.f17315b.a("fetchEventsDiscoveryCategoryFilters", new C24453(this), new AbstractDisposableFutureCallback<GraphQLResult<FetchEventDiscoveryCategoryListModel>>(this) {
            final /* synthetic */ EventsDiscoveryPager f17313b;

            protected final void m17598a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult.e == null || ((FetchEventDiscoveryCategoryListModel) graphQLResult.e).m17633a() == null) {
                    c24282.m17558a(Collections.EMPTY_LIST);
                } else {
                    c24282.m17558a(((FetchEventDiscoveryCategoryListModel) graphQLResult.e).m17633a());
                }
            }

            protected final void m17599a(Throwable th) {
                c24282.m17558a(Collections.EMPTY_LIST);
            }
        });
    }
}
