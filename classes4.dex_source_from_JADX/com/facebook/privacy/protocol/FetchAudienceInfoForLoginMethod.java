package com.facebook.privacy.protocol;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.privacy.protocol.FetchAudienceInfo.FetchAudienceInfoForLoginString;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: sms_nux_v2_seen */
public final class FetchAudienceInfoForLoginMethod extends AbstractPersistedGraphQlApiMethod<Void, FetchAudienceInfoModels$FetchAudienceInfoModel> {
    @Inject
    public FetchAudienceInfoForLoginMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m2131a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        apiResponse.i();
        return (FetchAudienceInfoModels$FetchAudienceInfoModel) jsonParser.a(FetchAudienceInfoModels$FetchAudienceInfoModel.class);
    }

    public final int m2132b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final GraphQlQueryString m2133f(Object obj) {
        return new FetchAudienceInfoForLoginString();
    }
}
