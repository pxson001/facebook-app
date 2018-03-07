package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEOS_WEB */
public class GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionSerializer extends JsonSerializer<GraphQLSaleGroupsNearYouFeedUnitGroupsConnection> {
    public final void m21516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection__JsonHelper.m21518a(jsonGenerator, (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class, new GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionSerializer());
    }
}
