package com.facebook.graphql.executor;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: feed_negative_feedback_story */
public class PureJsonGraphQLMethod extends AbstractPersistedGraphQlApiMethod<GraphQLRequest, JsonNode> {
    public static PureJsonGraphQLMethod m12459a(InjectorLike injectorLike) {
        return new PureJsonGraphQLMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    public final GraphQlQueryParamSet m12463e(Object obj) {
        GraphQLRequest graphQLRequest = (GraphQLRequest) obj;
        Preconditions.checkNotNull(graphQLRequest.d());
        return graphQLRequest.d();
    }

    public final GraphQlQueryString m12464f(Object obj) {
        return ((GraphQLRequest) obj).o;
    }

    public final String m12465g(Object obj) {
        return ((GraphQLRequest) obj).i() ? "post" : "get";
    }

    public final RequestIdempotency m12466h(Object obj) {
        return ((GraphQLRequest) obj).i() ? RequestIdempotency.CONSERVATIVE : RequestIdempotency.RETRY_SAFE;
    }

    @Inject
    public PureJsonGraphQLMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m12460a(Object obj, ApiResponse apiResponse) {
        return (JsonNode) apiResponse.d().J();
    }

    public final Object m12461a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        throw new RuntimeException("Should never be called");
    }

    public final int m12462b(Object obj, ApiResponse apiResponse) {
        throw new RuntimeException("Should never be called");
    }
}
