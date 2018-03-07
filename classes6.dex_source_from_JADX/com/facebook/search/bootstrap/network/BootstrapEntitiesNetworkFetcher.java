package com.facebook.search.bootstrap.network;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
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
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQL.FetchBootstrapEntitiesString;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQL.FetchBootstrapSnippetsString;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.BootstrapEntitiesDeltaEdgeFragmentModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.BootstrapEntitiesEdgeFragmentModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.BootstrapEntitiesSnippetFragmentModel.EdgesModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.FetchBootstrapEntitiesModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.FetchBootstrapSnippetsModel;
import com.facebook.search.bootstrap.converter.BootstrapEntityConverter;
import com.facebook.search.bootstrap.model.BootstrapEntities;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import javax.inject.Inject;

/* compiled from: exception_class */
public class BootstrapEntitiesNetworkFetcher {
    public final int f15794a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BootstrapEntityConverter> f15795b = UltralightRuntime.b;
    public final GraphQLQueryExecutor f15796c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GraphSearchErrorReporter> f15797d = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<EdgeRoutingConfig> f15798e = UltralightRuntime.b;
    public final GatekeeperStoreImpl f15799f;

    /* compiled from: exception_class */
    public class C11141 implements Function<GraphQLResult<FetchBootstrapSnippetsModel>, BootstrapEntities> {
        final /* synthetic */ BootstrapEntitiesNetworkFetcher f15792a;

        public C11141(BootstrapEntitiesNetworkFetcher bootstrapEntitiesNetworkFetcher) {
            this.f15792a = bootstrapEntitiesNetworkFetcher;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Builder builder = new Builder();
            if (((FetchBootstrapSnippetsModel) graphQLResult.d()).m23283a() != null) {
                ImmutableList a = ((FetchBootstrapSnippetsModel) graphQLResult.d()).m23283a().m23272a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    if (!(edgesModel == null || edgesModel.m23268a() == null)) {
                        try {
                            builder.c(((BootstrapEntityConverter) this.f15792a.f15795b.get()).m23343a(edgesModel.m23268a()));
                        } catch (GraphSearchException e) {
                            ((GraphSearchErrorReporter) this.f15792a.f15797d.get()).a(e);
                        }
                    }
                }
            }
            return new BootstrapEntities(0, false, builder.b(), ImmutableList.of());
        }
    }

    /* compiled from: exception_class */
    public class C11152 implements Function<GraphQLResult<FetchBootstrapEntitiesModel>, BootstrapEntities> {
        final /* synthetic */ BootstrapEntitiesNetworkFetcher f15793a;

        public C11152(BootstrapEntitiesNetworkFetcher bootstrapEntitiesNetworkFetcher) {
            this.f15793a = bootstrapEntitiesNetworkFetcher;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            boolean z = false;
            long j = 0;
            Builder builder = new Builder();
            Builder builder2 = new Builder();
            int i;
            if (((FetchBootstrapEntitiesModel) graphQLResult.d()).m23277a() != null) {
                BootstrapEntitiesEdgeFragmentModel a = ((FetchBootstrapEntitiesModel) graphQLResult.d()).m23277a();
                j = ((long) a.m23262j()) * 1000;
                ImmutableList a2 = a.m23260a();
                int size = a2.size();
                i = 0;
                while (i < size) {
                    BootstrapEntitiesEdgeFragmentModel.EdgesModel edgesModel = (BootstrapEntitiesEdgeFragmentModel.EdgesModel) a2.get(i);
                    if (edgesModel != null) {
                        try {
                            if (edgesModel.m23256a() != null) {
                                builder.c(((BootstrapEntityConverter) this.f15793a.f15795b.get()).m23343a(edgesModel.m23256a()));
                                i++;
                            }
                        } catch (GraphSearchException e) {
                            ((GraphSearchErrorReporter) this.f15793a.f15797d.get()).a(e);
                        }
                    }
                    throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "null edge or node");
                }
            } else if (((FetchBootstrapEntitiesModel) graphQLResult.d()).m23278j() != null) {
                BootstrapEntitiesDeltaEdgeFragmentModel j2 = ((FetchBootstrapEntitiesModel) graphQLResult.d()).m23278j();
                long k = 1000 * ((long) j2.m23250k());
                boolean j3 = j2.m23249j();
                ImmutableList a3 = j2.m23247a();
                i = a3.size();
                int i2;
                while (i2 < i) {
                    BootstrapEntitiesDeltaEdgeFragmentModel.EdgesModel edgesModel2 = (BootstrapEntitiesDeltaEdgeFragmentModel.EdgesModel) a3.get(i2);
                    if (edgesModel2 != null) {
                        try {
                            if (edgesModel2.m23243a() != null) {
                                if (edgesModel2.m23243a().m23238j() != null) {
                                    builder.c(((BootstrapEntityConverter) this.f15793a.f15795b.get()).m23343a(edgesModel2.m23243a()));
                                } else if (!(edgesModel2.m23243a() == null || edgesModel2.m23243a().m23239k() == null)) {
                                    builder2.c(edgesModel2.m23243a().m23239k());
                                }
                                i2++;
                            }
                        } catch (GraphSearchException e2) {
                            ((GraphSearchErrorReporter) this.f15793a.f15797d.get()).a(e2);
                        }
                    }
                    throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "null edge or node");
                }
                z = j3;
                j = k;
            }
            return new BootstrapEntities(j, z, builder.b(), builder2.b());
        }
    }

    public static BootstrapEntitiesNetworkFetcher m23444b(InjectorLike injectorLike) {
        BootstrapEntitiesNetworkFetcher bootstrapEntitiesNetworkFetcher = new BootstrapEntitiesNetworkFetcher(ResourcesMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 10459);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 3374);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 3372);
        bootstrapEntitiesNetworkFetcher.f15795b = a;
        bootstrapEntitiesNetworkFetcher.f15797d = b;
        bootstrapEntitiesNetworkFetcher.f15798e = a2;
        return bootstrapEntitiesNetworkFetcher;
    }

    @Inject
    public BootstrapEntitiesNetworkFetcher(Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f15794a = resources.getDimensionPixelSize(gatekeeperStoreImpl.a(SearchAbTestGatekeepers.g, false) ? 2131427457 : 2131427458);
        this.f15796c = graphQLQueryExecutor;
        this.f15799f = gatekeeperStoreImpl;
    }

    public final ListenableFuture<BootstrapEntities> m23445a(long j) {
        List list = RegularImmutableList.a;
        RequestPriority requestPriority = RequestPriority.DEFAULT_PRIORITY;
        FetchBootstrapEntitiesString fetchBootstrapEntitiesString = new FetchBootstrapEntitiesString();
        fetchBootstrapEntitiesString.a("thumbnail_size", String.valueOf(this.f15794a));
        if (list.isEmpty()) {
            fetchBootstrapEntitiesString.a("enable_delta_update", Boolean.valueOf(this.f15799f.a(SearchAbTestGatekeepers.a).asBoolean(false)));
            fetchBootstrapEntitiesString.a("timestamp", String.valueOf(j / 1000));
        } else {
            fetchBootstrapEntitiesString.a("ids", list).a("enable_delta_update", Boolean.valueOf(false));
        }
        GraphQLRequest a = GraphQLRequest.a(new FetchBootstrapEntitiesString()).a(GraphQLCachePolicy.c).a(fetchBootstrapEntitiesString.a).a(requestPriority);
        ((EdgeRoutingConfig) this.f15798e.get()).a(Caller.BOOTSTRAP, a);
        return Futures.a(this.f15796c.a(a), new C11152(this), MoreExecutors.b());
    }

    public final ListenableFuture<BootstrapEntities> m23446a(List<String> list) {
        GraphQLRequest a = GraphQLRequest.a((FetchBootstrapSnippetsString) new FetchBootstrapSnippetsString().a("ids", list)).a(GraphQLCachePolicy.c).a(RequestPriority.CAN_WAIT);
        ((EdgeRoutingConfig) this.f15798e.get()).a(Caller.BOOTSTRAP, a);
        return Futures.a(this.f15796c.a(a), new C11141(this), MoreExecutors.b());
    }
}
