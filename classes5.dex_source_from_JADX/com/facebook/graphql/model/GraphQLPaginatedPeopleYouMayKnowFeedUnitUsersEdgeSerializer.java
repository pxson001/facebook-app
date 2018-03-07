package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_SIGNUP_FLOW */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeSerializer extends JsonSerializer<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> {
    public final void m20628a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge__JsonHelper.m20630a(jsonGenerator, (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeSerializer());
    }
}
