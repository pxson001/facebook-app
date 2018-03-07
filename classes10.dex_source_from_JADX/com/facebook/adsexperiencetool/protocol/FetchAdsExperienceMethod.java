package com.facebook.adsexperiencetool.protocol;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: ensure */
public class FetchAdsExperienceMethod {
    public final GraphQLQueryExecutor f14449a;
    public final Executor f14450b;

    public static FetchAdsExperienceMethod m14595a(InjectorLike injectorLike) {
        return new FetchAdsExperienceMethod(GraphQLQueryExecutor.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchAdsExperienceMethod(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor) {
        this.f14449a = graphQLQueryExecutor;
        this.f14450b = executor;
    }
}
