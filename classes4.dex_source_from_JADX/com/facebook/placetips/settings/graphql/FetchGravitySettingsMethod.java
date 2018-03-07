package com.facebook.placetips.settings.graphql;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentInterfaces.GravitySettingsGraphQlFragment;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: rootca_sampling */
public class FetchGravitySettingsMethod extends AbstractPersistedGraphQlApiMethod<Void, GravitySettingsGraphQlFragment> {
    @Inject
    public FetchGravitySettingsMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final GraphQlQueryString m3555f(Object obj) {
        return GravitySettingsQuery.m3560a();
    }

    public final int m3554b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final Object m3553a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return ((GravitySettingsQueryModels$GravitySettingsQueryModel) jsonParser.a(GravitySettingsQueryModels$GravitySettingsQueryModel.class)).m3563a();
    }
}
