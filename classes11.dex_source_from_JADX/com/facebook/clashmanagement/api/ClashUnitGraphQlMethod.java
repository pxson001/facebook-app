package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQuery.ClashUnitQueryString;
import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;
import javax.inject.Inject;

/* compiled from: keys_pressed */
public class ClashUnitGraphQlMethod extends AbstractPersistedGraphQlApiMethod<List<String>, ClashUnitQueryModel> {
    public final GraphQlQueryString m7307f(Object obj) {
        List list = (List) obj;
        ClashUnitQueryString a = ClashUnitQuery.a();
        a.a("names", list);
        return a;
    }

    @Inject
    public ClashUnitGraphQlMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m7305a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return (ClashUnitQueryModel) jsonParser.a(ClashUnitQueryModel.class);
    }

    public final int m7306b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
