package com.facebook.messaging.business.ride.helper;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.ImmutableLocation;
import com.facebook.messaging.business.ride.graphql.RideQueryFragments.RideProvidersQueryString;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideProvidersQueryModel;
import com.facebook.messaging.business.ride.helper.RideOauthHelper.C10601;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: moments_app */
public class RideProviderLoader {
    public static final String f9254a = RideProviderLoader.class.getSimpleName();
    private static final FbLocationOperationParams f9255b;
    private static final CallerContext f9256c = CallerContext.b(RideProviderLoader.class, "ride_requests");
    public final AbstractFbErrorReporter f9257d;
    private final GraphQLQueryExecutor f9258e;
    private final Provider<FbLocationOperation> f9259f;
    public final TasksManager<RideProviderTask> f9260g;
    private final Resources f9261h;

    /* compiled from: moments_app */
    enum RideProviderTask {
        GET_CURRENT_LOCATION,
        GET_RIDE_PROVIDER
    }

    public static RideProviderLoader m9747b(InjectorLike injectorLike) {
        return new RideProviderLoader((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 2481), TasksManager.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    static {
        Builder a = FbLocationOperationParams.a(Priority.HIGH_ACCURACY);
        a.b = 300000;
        a = a;
        a.c = 1200.0f;
        a = a;
        a.d = 300;
        f9255b = a.a();
    }

    public final void m9748a(@Nullable ImmutableLocation immutableLocation, final C10601 c10601) {
        GraphQlQueryString rideProvidersQueryString = new RideProvidersQueryString();
        if (immutableLocation != null) {
            rideProvidersQueryString.a("source_longitude", Float.valueOf((float) immutableLocation.b()));
            rideProvidersQueryString.a("source_latitude", Float.valueOf((float) immutableLocation.a()));
        }
        rideProvidersQueryString.a("profile_image_width", Integer.valueOf(this.f9261h.getDimensionPixelOffset(2131430981)));
        rideProvidersQueryString.a("profile_image_height", Integer.valueOf(this.f9261h.getDimensionPixelOffset(2131430981)));
        this.f9260g.a(RideProviderTask.GET_RIDE_PROVIDER, this.f9258e.a(GraphQLRequest.a(rideProvidersQueryString)), new AbstractDisposableFutureCallback<GraphQLResult<RideProvidersQueryModel>>(this) {
            final /* synthetic */ RideProviderLoader f9253b;

            protected final void m9745a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (c10601 == null) {
                    return;
                }
                if (graphQLResult == null || graphQLResult.e == null || ((RideProvidersQueryModel) graphQLResult.e).m9596a() == null || ((RideProvidersQueryModel) graphQLResult.e).m9596a().m9591a().isEmpty()) {
                    this.f9253b.f9257d.a(RideProviderLoader.f9254a, "GraphQL return invalid results");
                    c10601.m9722a(RegularImmutableList.a);
                    return;
                }
                c10601.m9722a(((RideProvidersQueryModel) graphQLResult.e).m9596a().m9591a());
            }

            protected final void m9746a(Throwable th) {
                if (c10601 != null) {
                    C10601 c10601 = c10601;
                    c10601.f9213d.f9229h.m9365a(c10601.f9210a, "failure", c10601.f9213d.f9233l.now() - c10601.f9211b);
                    RideOauthHelper.m9734c(c10601.f9213d);
                    c10601.f9213d.f9224c.a("RideOauthHelper", th);
                    if (c10601.f9212c != null) {
                        c10601.f9212c.a();
                    }
                }
                this.f9253b.f9257d.a(RideProviderLoader.f9254a, th);
            }
        });
    }

    @Inject
    public RideProviderLoader(FbErrorReporter fbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, Provider<FbLocationOperation> provider, TasksManager tasksManager, Resources resources) {
        this.f9257d = fbErrorReporter;
        this.f9258e = graphQLQueryExecutor;
        this.f9259f = provider;
        this.f9260g = tasksManager;
        this.f9261h = resources;
    }

    public final void m9749a(final C10601 c10601) {
        FbLocationOperation fbLocationOperation = (FbLocationOperation) this.f9259f.get();
        fbLocationOperation.a(f9255b, f9256c);
        this.f9260g.c();
        this.f9260g.a(RideProviderTask.GET_CURRENT_LOCATION, fbLocationOperation, new AbstractDisposableFutureCallback<ImmutableLocation>(this) {
            final /* synthetic */ RideProviderLoader f9251b;

            protected final void m9743a(Object obj) {
                this.f9251b.m9748a((ImmutableLocation) obj, c10601);
            }

            protected final void m9744a(Throwable th) {
                this.f9251b.m9748a(null, c10601);
                this.f9251b.f9257d.a(RideProviderLoader.f9254a, th);
            }
        });
    }
}
