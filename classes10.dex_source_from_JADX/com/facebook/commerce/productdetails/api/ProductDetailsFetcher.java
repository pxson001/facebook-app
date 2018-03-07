package com.facebook.commerce.productdetails.api;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: delete_invite */
public class ProductDetailsFetcher {
    public final Provider<BlueServiceOperationFactory> f15134a;
    public final ViewerContextManager f15135b;
    public final GraphQLQueryExecutor f15136c;

    public static ProductDetailsFetcher m15663b(InjectorLike injectorLike) {
        return new ProductDetailsFetcher(IdBasedProvider.a(injectorLike, 1144), ViewerContextManagerProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public ProductDetailsFetcher(Provider<BlueServiceOperationFactory> provider, ViewerContextManager viewerContextManager, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f15134a = provider;
        this.f15135b = viewerContextManager;
        this.f15136c = graphQLQueryExecutor;
    }

    public static ProductDetailsFetcher m15662a(InjectorLike injectorLike) {
        return m15663b(injectorLike);
    }
}
