package com.facebook.identitygrowth.protocol;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLInterfaces.ProfileQuestionQuery;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: mHostName */
public class FetchProfileQuestionMethod extends AbstractPersistedGraphQlApiMethod<FetchProfileQuestionParams, ProfileQuestionQuery> {
    public final GraphQlQueryString m17846f(Object obj) {
        FetchProfileQuestionParams fetchProfileQuestionParams = (FetchProfileQuestionParams) obj;
        return ProfileQuestionGraphQL.m17946a().a("scale", GraphQlQueryDefaults.a()).a("ref", fetchProfileQuestionParams.f11099a).a("session", fetchProfileQuestionParams.f11101c == null ? "" : fetchProfileQuestionParams.f11101c).a("surface", fetchProfileQuestionParams.f11100b);
    }

    @Inject
    public FetchProfileQuestionMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final int m17845b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final Object m17844a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return (ProfileQuestionQueryModel) jsonParser.a(ProfileQuestionQueryModel.class);
    }
}
