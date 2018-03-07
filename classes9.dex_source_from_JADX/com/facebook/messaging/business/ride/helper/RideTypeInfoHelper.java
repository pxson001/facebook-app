package com.facebook.messaging.business.ride.helper;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.ride.graphql.RideQueryFragments.RideTypesInfoQueryString;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideTypesInfoQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideTypesInfoQueryModel.MessengerCommerceModel.RideProvidersModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideTypesInfoQueryModel.MessengerCommerceModel.RideProvidersModel.RideTypesModel.EdgesModel;
import com.facebook.messaging.business.ride.view.RideRequestFragment.C10921;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: modifyStoryPromotionCampaign */
public class RideTypeInfoHelper {
    public final AbstractFbErrorReporter f9276a;
    private final GraphQLQueryExecutor f9277b;
    public final TasksManager<String> f9278c;

    public static RideTypeInfoHelper m9752b(InjectorLike injectorLike) {
        return new RideTypeInfoHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public RideTypeInfoHelper(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f9276a = abstractFbErrorReporter;
        this.f9277b = graphQLQueryExecutor;
        this.f9278c = tasksManager;
    }

    public final void m9753a(String str, double d, double d2, final C10921 c10921) {
        if (c10921 != null) {
            c10921.f9394a.az.m9885a();
            this.f9278c.a("task_key_fetch_ride_type", this.f9277b.a(GraphQLRequest.a((RideTypesInfoQueryString) new RideTypesInfoQueryString().a("provider", str).a("latitude", Double.valueOf(d)).a("longitude", Double.valueOf(d2)))), new AbstractDisposableFutureCallback<GraphQLResult<RideTypesInfoQueryModel>>(this) {
                final /* synthetic */ RideTypeInfoHelper f9275b;

                protected final void m9750a(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || graphQLResult.e == null || ((RideTypesInfoQueryModel) graphQLResult.e).m9632a() == null || ((RideTypesInfoQueryModel) graphQLResult.e).m9632a().m9627a().isEmpty()) {
                        this.f9275b.f9276a.a("RideService", "GraphQL return invalid results");
                        return;
                    }
                    ImmutableList immutableList;
                    C10921 c10921 = c10921;
                    RideProvidersModel rideProvidersModel = (RideProvidersModel) ((RideTypesInfoQueryModel) graphQLResult.e).m9632a().m9627a().get(0);
                    if (rideProvidersModel.m9623a() == null || rideProvidersModel.m9623a().m9619a().isEmpty()) {
                        immutableList = null;
                    } else {
                        Builder builder = new Builder();
                        ImmutableList a = rideProvidersModel.m9623a().m9619a();
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            EdgesModel edgesModel = (EdgesModel) a.get(i);
                            if (edgesModel.m9615a() != null) {
                                builder.c(edgesModel.m9615a());
                            }
                        }
                        immutableList = builder.b();
                    }
                    c10921.f9394a.az.m9887a(immutableList);
                }

                protected final void m9751a(Throwable th) {
                    this.f9275b.f9276a.a("RideTypeInfoHelper", th);
                    C10921 c10921 = c10921;
                    c10921.f9394a.az.m9888a(c10921.f9394a.b(2131230758));
                }
            });
        }
    }
}
