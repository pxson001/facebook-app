package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.LocationInputLocation;
import com.facebook.graphql.calls.LocationInputLocation.LocationServiceEnabled;
import com.facebook.graphql.calls.SourcesInputSources;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.EdgeRoutingConfig;
import com.facebook.search.api.EdgeRoutingConfig.Caller;
import com.facebook.search.model.converter.NullStateModuleConverter;
import com.facebook.search.model.nullstate.NullStateModuleData;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQL;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQL.NullStateModuleQueryString;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: interstitials_fetch_replaced */
public class SearchNullStateModuleLoader {
    public final NullStateModuleConverter f19645a;
    private final GraphQLQueryExecutor f19646b;
    private final FbLocationCache f19647c;
    @Inject
    public EdgeRoutingConfig f19648d;
    private final GatekeeperStoreImpl f19649e;
    private final QeAccessor f19650f;

    @Inject
    public SearchNullStateModuleLoader(NullStateModuleConverter nullStateModuleConverter, GraphQLQueryExecutor graphQLQueryExecutor, FbLocationCache fbLocationCache, GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor) {
        this.f19645a = nullStateModuleConverter;
        this.f19646b = graphQLQueryExecutor;
        this.f19647c = fbLocationCache;
        this.f19649e = gatekeeperStoreImpl;
        this.f19650f = qeAccessor;
    }

    public final ListenableFuture<NullStateModuleData> m27376a(List<String> list, int i, @Nullable CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy) {
        RequestPriority requestPriority;
        FetchNullStateModulesGraphQL fetchNullStateModulesGraphQL = new FetchNullStateModulesGraphQL();
        TypedGraphQlQueryString nullStateModuleQueryString = new NullStateModuleQueryString();
        nullStateModuleQueryString.m11316a("source", m27375a(list, i));
        ImmutableLocation a = this.f19647c.m8245a();
        if (a != null) {
            String str = "location";
            LocationInputLocation locationInputLocation = new LocationInputLocation();
            locationInputLocation.a(Double.valueOf(a.m11984a()));
            locationInputLocation.b(Double.valueOf(a.m11985b()));
            if (a.m11986c().isPresent()) {
                locationInputLocation.c(Double.valueOf(((Float) a.m11986c().get()).doubleValue()));
            }
            locationInputLocation.a(LocationServiceEnabled.TRUE);
            nullStateModuleQueryString.m11310a(str, (GraphQlCallInput) locationInputLocation);
        } else {
            nullStateModuleQueryString.m11310a("location", m27374a());
        }
        nullStateModuleQueryString.m11315a("ranking_model", "").m11312a("should_show_live_icon", Boolean.valueOf(this.f19650f.mo596a(ExperimentsForSearchAbTestModule.bm, true)));
        long a2 = this.f19650f.mo596a(ExperimentsForSearchAbTestModule.be, false) ? 31536000 : (long) this.f19650f.mo572a(ExperimentsForSearchAbTestModule.bc, 3600);
        GraphQLRequest a3 = GraphQLRequest.m11587a(nullStateModuleQueryString).m11594a(graphQLCachePolicy);
        a3.f7087e = ImmutableSet.of("null_state_module_cache_tag");
        a3 = a3;
        a3.f7084b = true;
        GraphQLRequest graphQLRequest = a3;
        if (callerContext != null) {
            requestPriority = RequestPriority.INTERACTIVE;
        } else {
            requestPriority = RequestPriority.NON_INTERACTIVE;
        }
        a3 = graphQLRequest.m11596a(requestPriority);
        a3.f7088f = callerContext;
        GraphQLRequest a4 = a3.m11590a(a2);
        this.f19648d.m27382a(Caller.NULLSTATE, a4);
        return Futures.m2449a(this.f19646b.m10446a(a4), new 1(this));
    }

    private ImmutableList<SourcesInputSources> m27375a(List<String> list, int i) {
        Integer valueOf = Integer.valueOf(i);
        if (this.f19649e.m2189a(SearchAbTestGatekeepers.f7149u, false)) {
            return ImmutableList.of(new SourcesInputSources().a("trending").a(valueOf));
        }
        Builder builder = new Builder();
        for (String a : list) {
            builder.m1069c(new SourcesInputSources().a(a).a(valueOf));
        }
        return builder.m1068b();
    }

    private static LocationInputLocation m27374a() {
        return new LocationInputLocation().a(Double.valueOf(0.0d)).b(Double.valueOf(0.0d)).c(Double.valueOf(0.0d)).a(LocationServiceEnabled.FALSE);
    }
}
