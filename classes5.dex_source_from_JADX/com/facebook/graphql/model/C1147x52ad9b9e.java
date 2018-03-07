package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.C0243x81539b2b;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_INVALID_ENTRY */
public final class C1147x52ad9b9e extends JsonSerializer<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection> {
    public final void m20591a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) obj;
        C0243x81539b2b.m5559a(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.w_(), graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.class, new C1147x52ad9b9e());
        FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.class, new C1147x52ad9b9e());
    }
}
