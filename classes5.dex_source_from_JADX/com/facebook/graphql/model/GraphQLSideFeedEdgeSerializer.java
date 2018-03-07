package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VENUE_GROUP */
public class GraphQLSideFeedEdgeSerializer extends JsonSerializer<GraphQLSideFeedEdge> {
    public final void m21645a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSideFeedEdge__JsonHelper.m21647a(jsonGenerator, (GraphQLSideFeedEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSideFeedEdge.class, new GraphQLSideFeedEdgeSerializer());
    }
}
