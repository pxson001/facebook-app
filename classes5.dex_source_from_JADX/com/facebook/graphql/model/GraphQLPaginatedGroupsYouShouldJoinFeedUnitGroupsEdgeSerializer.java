package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_CREATE_TEMPFILE */
public class GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdgeSerializer extends JsonSerializer<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> {
    public final void m20605a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        C1153x47fa40cd.m20607a(jsonGenerator, (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.class, new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdgeSerializer());
    }
}
