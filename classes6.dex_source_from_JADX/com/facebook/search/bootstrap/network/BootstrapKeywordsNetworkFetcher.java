package com.facebook.search.bootstrap.network;

import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.EdgeRoutingConfig;
import com.facebook.search.api.EdgeRoutingConfig.Caller;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQL.FetchBootstrapKeywordsString;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLModels.BootstrapKeywordsEdgeFragmentModel.EdgesModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLModels.FetchBootstrapKeywordsModel;
import com.facebook.search.bootstrap.converter.BootstrapKeywordConverter;
import com.facebook.search.bootstrap.model.BootstrapKeywords;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;

/* compiled from: ex_type */
public class BootstrapKeywordsNetworkFetcher {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BootstrapKeywordConverter> f15801a = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GraphQLQueryExecutor> f15802b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GraphSearchErrorReporter> f15803c = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EdgeRoutingConfig> f15804d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GatekeeperStore> f15805e = UltralightRuntime.b;

    /* compiled from: ex_type */
    class C11161 implements Function<GraphQLResult<FetchBootstrapKeywordsModel>, BootstrapKeywords> {
        final /* synthetic */ BootstrapKeywordsNetworkFetcher f15800a;

        C11161(BootstrapKeywordsNetworkFetcher bootstrapKeywordsNetworkFetcher) {
            this.f15800a = bootstrapKeywordsNetworkFetcher;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Builder builder = new Builder();
            if (((FetchBootstrapKeywordsModel) graphQLResult.d()).m23335a() != null) {
                ImmutableList a = ((FetchBootstrapKeywordsModel) graphQLResult.d()).m23335a().m23330a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    try {
                        builder.c(((BootstrapKeywordConverter) this.f15800a.f15801a.get()).m23344a((EdgesModel) a.get(i)));
                    } catch (GraphSearchException e) {
                        ((GraphSearchErrorReporter) this.f15800a.f15803c.get()).a(e);
                    }
                }
            }
            return new BootstrapKeywords(builder.b());
        }
    }

    public static BootstrapKeywordsNetworkFetcher m23448b(InjectorLike injectorLike) {
        BootstrapKeywordsNetworkFetcher bootstrapKeywordsNetworkFetcher = new BootstrapKeywordsNetworkFetcher();
        bootstrapKeywordsNetworkFetcher.m23447a(IdBasedLazy.a(injectorLike, 10460), IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 3374), IdBasedLazy.a(injectorLike, 3372), IdBasedSingletonScopeProvider.b(injectorLike, 2128));
        return bootstrapKeywordsNetworkFetcher;
    }

    public final ListenableFuture<BootstrapKeywords> m23449a() {
        GraphQLRequest a = GraphQLRequest.a(new FetchBootstrapKeywordsString()).a(GraphQLCachePolicy.c).a(RequestPriority.NON_INTERACTIVE);
        ((EdgeRoutingConfig) this.f15804d.get()).a(Caller.BOOTSTRAP, a);
        a.o.a("enable_keywords", Boolean.valueOf(((GatekeeperStoreImpl) this.f15805e.get()).a(SearchAbTestGatekeepers.p, false)));
        return Futures.a(((GraphQLQueryExecutor) this.f15802b.get()).a(a), new C11161(this), MoreExecutors.b());
    }

    private void m23447a(com.facebook.inject.Lazy<BootstrapKeywordConverter> lazy, com.facebook.inject.Lazy<GraphQLQueryExecutor> lazy2, com.facebook.inject.Lazy<GraphSearchErrorReporter> lazy3, com.facebook.inject.Lazy<EdgeRoutingConfig> lazy4, com.facebook.inject.Lazy<GatekeeperStore> lazy5) {
        this.f15801a = lazy;
        this.f15802b = lazy2;
        this.f15803c = lazy3;
        this.f15804d = lazy4;
        this.f15805e = lazy5;
    }
}
