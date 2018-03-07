package com.facebook.graphql.protocol;

import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.interfaces.RequestState;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DefaultRequestStateHolder;
import com.facebook.http.protocol.GraphQlPersistedApiMethod;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import org.apache.http.Header;

/* compiled from: screen */
public abstract class AbstractPersistedGraphQlApiMethod<PARAMS, RESULT> implements GraphQlPersistedApiMethod<PARAMS, RESULT> {
    private static final Class<?> f6002c = AbstractPersistedGraphQlApiMethod.class;
    public int f6003a = -42;
    protected final GraphQLProtocolHelper f6004b;

    public abstract RESULT mo1424a(PARAMS params, ApiResponse apiResponse, JsonParser jsonParser);

    public abstract int mo1428b(PARAMS params, ApiResponse apiResponse);

    public abstract GraphQlQueryString mo1433f(PARAMS params);

    public AbstractPersistedGraphQlApiMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        this.f6004b = (GraphQLProtocolHelper) Preconditions.checkNotNull(graphQLProtocolHelper);
    }

    public GraphQlQueryParamSet mo2688e(@Nullable PARAMS params) {
        return null;
    }

    public String mo2689g(@Nullable PARAMS params) {
        return "get";
    }

    public RequestIdempotency mo2690h(@Nullable PARAMS params) {
        return RequestIdempotency.RETRY_SAFE;
    }

    protected boolean mo2687a() {
        return false;
    }

    protected boolean mo2691i(@Nullable PARAMS params) {
        return false;
    }

    public final ApiRequest m10127d(@Nullable PARAMS params) {
        GraphQlQueryString f = mo1433f(params);
        GraphQlQueryParamSet e = mo2688e(params);
        if (e == null) {
            e = f.f6529a;
        }
        String c = f.m11324c();
        return this.f6004b.m9436a(c, f.m11327f(), mo2686a(f), e, mo2689g(params), mo2690h(params), mo2685a(c, mo1435j(params), (Object) params), f.m11325d(), f.m11326e(), mo2692k(params), mo2687a(), mo2691i(params));
    }

    public ApiResponseType mo2686a(GraphQlQueryString graphQlQueryString) {
        return ApiResponseType.JSONPARSER;
    }

    public final ApiRequest m10121a(PARAMS params) {
        return m10127d(params);
    }

    public RESULT mo1423a(@Nullable PARAMS params, ApiResponse apiResponse) {
        JsonParser a = this.f6004b.m9437a(apiResponse.f15570a.f7496a, mo1428b(params, apiResponse), apiResponse.m22206d());
        if (this.f6004b.f5542i != null) {
            GraphQlQueryString f = mo1433f(params);
            this.f6004b.f5542i.m9547a(f.f6530b, f.f6532d, a);
        }
        return mo1424a((Object) params, apiResponse, a);
    }

    public RequestPriority mo1435j(@Nullable PARAMS params) {
        return RequestPriority.INTERACTIVE;
    }

    @Nullable
    public ImmutableList<Header> mo2692k(@Nullable PARAMS params) {
        return null;
    }

    protected RequestState mo2685a(String str, RequestPriority requestPriority, @Nullable PARAMS params) {
        return DefaultRequestStateHolder.m12143a(str, requestPriority);
    }
}
