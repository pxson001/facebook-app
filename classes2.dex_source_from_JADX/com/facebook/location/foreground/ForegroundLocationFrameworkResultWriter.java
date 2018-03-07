package com.facebook.location.foreground;

import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.location.C0664xc4defe1d;
import com.facebook.location.write.LocationMutationModelCreator;
import com.facebook.location.write.LocationMutationModelCreatorParams;
import com.facebook.location.write.LocationMutationModelCreatorParams.Builder;
import com.facebook.location.write.LocationMutationModelCreatorProvider;
import com.facebook.location.write.graphql.LocationMutationsModels.LocationUpdateMutationModel;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: log_out */
public class ForegroundLocationFrameworkResultWriter {
    private static final Class<?> f16259a = ForegroundLocationFrameworkResultWriter.class;
    public final GraphQLQueryExecutor f16260b;
    public final ForegroundLocationFrameworkConfig f16261c;
    public final ForegroundLocationFrameworkAnalyticsLogger f16262d;
    public final LocationMutationModelCreator f16263e;
    public final ExecutorService f16264f;
    public FutureAndCallbackHolder<GraphQLResult<LocationUpdateMutationModel>> f16265g;

    public static ForegroundLocationFrameworkResultWriter m23081b(InjectorLike injectorLike) {
        return new ForegroundLocationFrameworkResultWriter(C0664xc4defe1d.m21716a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), ForegroundLocationFrameworkConfig.m22169a(injectorLike), ForegroundLocationFrameworkAnalyticsLogger.m21719a(injectorLike), (LocationMutationModelCreatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LocationMutationModelCreatorProvider.class));
    }

    @Inject
    public ForegroundLocationFrameworkResultWriter(ListeningScheduledExecutorService listeningScheduledExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, ForegroundLocationFrameworkConfig foregroundLocationFrameworkConfig, ForegroundLocationFrameworkAnalyticsLogger foregroundLocationFrameworkAnalyticsLogger, LocationMutationModelCreatorProvider locationMutationModelCreatorProvider) {
        this.f16260b = graphQLQueryExecutor;
        this.f16261c = foregroundLocationFrameworkConfig;
        this.f16262d = foregroundLocationFrameworkAnalyticsLogger;
        Builder builder = new Builder();
        builder.f16288a = this.f16261c.m22180h();
        builder = builder;
        builder.f16289b = this.f16261c.m22179g();
        builder = builder;
        builder.f16290c = this.f16261c.m22178f();
        builder = builder;
        this.f16263e = locationMutationModelCreatorProvider.m23083a(new LocationMutationModelCreatorParams(builder.f16288a, builder.f16289b, builder.f16290c));
        this.f16264f = listeningScheduledExecutorService;
    }

    public final void m23082a() {
        if (this.f16265g != null) {
            this.f16265g.m20346a(false);
            this.f16265g = null;
            ForegroundLocationFrameworkAnalyticsLogger foregroundLocationFrameworkAnalyticsLogger = this.f16262d;
            foregroundLocationFrameworkAnalyticsLogger.f15203h = Long.MIN_VALUE;
            foregroundLocationFrameworkAnalyticsLogger.f15201f = Long.MIN_VALUE;
        }
    }
}
