package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEOS_LIVE */
public class GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeSerializer extends JsonSerializer<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> {
    public final void m21526a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsEdge__JsonHelper.m21528a(jsonGenerator, (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class, new GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeSerializer());
    }
}
