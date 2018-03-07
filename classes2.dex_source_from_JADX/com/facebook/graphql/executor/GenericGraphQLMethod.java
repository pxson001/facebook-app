package com.facebook.graphql.executor;

import com.facebook.common.util.TriState;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_global_delete */
public class GenericGraphQLMethod extends AbstractPersistedGraphQlApiMethod<GraphQLRequest, GraphQLResult> {
    private final Lazy<GraphQLResponseParser> f13989c;
    private final boolean f13990d;
    private final boolean f13991e;

    public static GenericGraphQLMethod m20310b(InjectorLike injectorLike) {
        return new GenericGraphQLMethod(GraphQLProtocolHelper.m9427a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2168), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    protected final FbRequestState mo2685a(String str, RequestPriority requestPriority, Object obj) {
        obj = (GraphQLRequest) obj;
        FbRequestState g = obj.m11609g();
        return g != null ? g : super.mo2685a(str, requestPriority, obj);
    }

    public final Object mo1423a(Object obj, ApiResponse apiResponse) {
        GraphQLRequest graphQLRequest = (GraphQLRequest) obj;
        TracerDetour.a("GenericGraphQLMethod.getResponse", -8491111);
        try {
            Object f = apiResponse.m22208f();
            if (f instanceof JsonParser) {
                f = m20309a(graphQLRequest, apiResponse.m22206d());
            } else if (f instanceof InputStream) {
                f = ((GraphQLResponseParser) this.f13989c.get()).m11714a(apiResponse.m22207e(), graphQLRequest);
                TracerDetour.a(-1849719938);
            } else {
                throw new RuntimeException("responseObject should either be JsonParser or InputStream");
            }
            return f;
        } finally {
            TracerDetour.a(1522323731);
        }
    }

    public final GraphQlQueryParamSet mo2688e(Object obj) {
        GraphQLRequest graphQLRequest = (GraphQLRequest) obj;
        if (graphQLRequest.m11607d() == null) {
            return GraphQlQueryParamSet.f6570a;
        }
        return graphQLRequest.m11607d();
    }

    public final GraphQlQueryString mo1433f(Object obj) {
        return ((GraphQLRequest) obj).f7096o;
    }

    public final String mo2689g(Object obj) {
        return ((GraphQLRequest) obj).m11611i() ? "post" : "get";
    }

    public final RequestIdempotency mo2690h(Object obj) {
        return ((GraphQLRequest) obj).m11611i() ? RequestIdempotency.CONSERVATIVE : RequestIdempotency.RETRY_SAFE;
    }

    protected final boolean mo2691i(@Nullable Object obj) {
        GraphQLRequest graphQLRequest = (GraphQLRequest) obj;
        return graphQLRequest != null && graphQLRequest.f7091i;
    }

    public final RequestPriority mo1435j(Object obj) {
        return ((GraphQLRequest) obj).m11609g().m11633a();
    }

    @Nullable
    public final ImmutableList mo2692k(Object obj) {
        return ((GraphQLRequest) obj).f7089g;
    }

    @Inject
    public GenericGraphQLMethod(GraphQLProtocolHelper graphQLProtocolHelper, Lazy<GraphQLResponseParser> lazy, GatekeeperStore gatekeeperStore) {
        boolean z;
        boolean z2 = true;
        super(graphQLProtocolHelper);
        this.f13989c = lazy;
        if (gatekeeperStore.m2185a(84) == TriState.YES) {
            z = true;
        } else {
            z = false;
        }
        this.f13990d = z;
        if (gatekeeperStore.m2185a(85) != TriState.YES) {
            z2 = false;
        }
        this.f13991e = z2;
    }

    public static GenericGraphQLMethod m20308a(InjectorLike injectorLike) {
        return m20310b(injectorLike);
    }

    public final ApiResponseType mo2686a(GraphQlQueryString graphQlQueryString) {
        return (!(this.f13990d && graphQlQueryString.mo1607g() == TriState.YES) && (!this.f13991e || graphQlQueryString.mo1607g() == TriState.NO)) ? ApiResponseType.JSONPARSER : ApiResponseType.FLATBUFFER;
    }

    private GraphQLResult m20309a(GraphQLRequest graphQLRequest, JsonParser jsonParser) {
        return ((GraphQLResponseParser) this.f13989c.get()).m11713a(jsonParser, graphQLRequest, DataFreshnessResult.FROM_SERVER);
    }

    public final int mo1428b(Object obj, ApiResponse apiResponse) {
        throw new RuntimeException("Should never be called");
    }

    protected final boolean mo2687a() {
        return true;
    }
}
