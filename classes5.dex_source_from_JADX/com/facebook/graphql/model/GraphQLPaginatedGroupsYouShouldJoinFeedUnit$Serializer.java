package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_ON_TIMELINE */
public final class GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Serializer extends JsonSerializer<GraphQLPaginatedGroupsYouShouldJoinFeedUnit> {
    public final void m20586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) obj;
        GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer.m5556a(graphQLPaginatedGroupsYouShouldJoinFeedUnit.w_(), graphQLPaginatedGroupsYouShouldJoinFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class, new GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class, new GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Serializer());
    }
}
