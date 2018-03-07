package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_SOCIAL */
public final class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge$Serializer extends JsonSerializer<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> {
    public final void m20626a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) obj;
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer.m5571b(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.w_(), graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge$Serializer());
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge$Serializer());
    }
}
