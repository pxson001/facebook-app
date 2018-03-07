package com.facebook.tagging.graphql.protocol;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.TagSearchModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.TagSearchModel.ResultsModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: dense_result_page */
public class GraphQLTagSearchMethod extends AbstractPersistedGraphQlApiMethod<GraphQLTagSearchParams, ResultsModel> {
    public final GraphQlQueryString m25369f(Object obj) {
        GraphQLTagSearchParams graphQLTagSearchParams = (GraphQLTagSearchParams) obj;
        return TagSearchGraphQL.m25372a().a("search_key", graphQLTagSearchParams.f17487a).a("result_type", graphQLTagSearchParams.f17488b);
    }

    @Inject
    public GraphQLTagSearchMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m25367a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return ((TagSearchModel) jsonParser.a(TagSearchModel.class)).m25463a();
    }

    public final int m25368b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
