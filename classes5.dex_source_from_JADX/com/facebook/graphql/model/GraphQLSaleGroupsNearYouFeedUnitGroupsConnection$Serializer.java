package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_ADS_FOR_COMMERCIAL_BREAK */
public final class GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Serializer extends JsonSerializer<GraphQLSaleGroupsNearYouFeedUnitGroupsConnection> {
    public final void m21514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection graphQLSaleGroupsNearYouFeedUnitGroupsConnection = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) obj;
        GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer.m5847a(graphQLSaleGroupsNearYouFeedUnitGroupsConnection.w_(), graphQLSaleGroupsNearYouFeedUnitGroupsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class, new GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Serializer());
        FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class, new GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Serializer());
    }
}
