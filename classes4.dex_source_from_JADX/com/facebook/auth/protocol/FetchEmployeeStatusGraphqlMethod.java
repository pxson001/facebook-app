package com.facebook.auth.protocol;

import com.facebook.auth.protocol.FetchFacebookEmployeeStatusGraphQL.FetchFacebookEmployeeStatusQueryString;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: rtc_bitrate_logging */
public class FetchEmployeeStatusGraphqlMethod extends AbstractPersistedGraphQlApiMethod<Void, Boolean> {
    public static FetchEmployeeStatusGraphqlMethod m3493b(InjectorLike injectorLike) {
        return new FetchEmployeeStatusGraphqlMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    @Inject
    public FetchEmployeeStatusGraphqlMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m3494a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return Boolean.valueOf(((C0152x416c0b10) jsonParser.a(C0152x416c0b10.class)).m3559a());
    }

    public final GraphQlQueryString m3496f(Object obj) {
        return new FetchFacebookEmployeeStatusQueryString();
    }

    public final int m3495b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
