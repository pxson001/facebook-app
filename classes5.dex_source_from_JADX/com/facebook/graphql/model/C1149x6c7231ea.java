package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_HEADER */
public class C1149x6c7231ea extends JsonSerializer<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection> {
    public final void m20593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        C1150x757fdcee.m20595a(jsonGenerator, (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.class, new C1149x6c7231ea());
    }
}
