package com.facebook.privacy.protocol;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.protocol.FetchAudienceInfo.FetchAudienceInfoString;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: rows_updated_count */
public final class FetchAudienceInfoMethod extends AbstractPersistedGraphQlApiMethod<Void, FetchAudienceInfoModels$FetchAudienceInfoModel> {
    public static FetchAudienceInfoMethod m3537b(InjectorLike injectorLike) {
        return new FetchAudienceInfoMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    @Inject
    public FetchAudienceInfoMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final GraphQlQueryString m3540f(Object obj) {
        return new FetchAudienceInfoString();
    }

    public final Object m3538a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        apiResponse.i();
        return (FetchAudienceInfoModels$FetchAudienceInfoModel) jsonParser.a(FetchAudienceInfoModels$FetchAudienceInfoModel.class);
    }

    public final int m3539b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
