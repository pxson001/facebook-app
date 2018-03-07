package com.facebook.dialtone;

import com.facebook.dialtone.protocol.DialtoneGraphQL;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: sms_permanent_contact_null_state_loaded_today */
public class DialtoneFetchQuotaMethod extends AbstractPersistedGraphQlApiMethod<Void, FetchDialtonePhotoQuotaModel> {
    @Inject
    public DialtoneFetchQuotaMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final GraphQlQueryString m2127f(Object obj) {
        return DialtoneGraphQL.a();
    }

    public final Object m2125a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        apiResponse.i();
        return (FetchDialtonePhotoQuotaModel) jsonParser.a(FetchDialtonePhotoQuotaModel.class);
    }

    public final int m2126b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
