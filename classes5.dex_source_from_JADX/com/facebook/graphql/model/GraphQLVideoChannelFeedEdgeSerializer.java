package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ThumbnailMakerSequence */
public class GraphQLVideoChannelFeedEdgeSerializer extends JsonSerializer<GraphQLVideoChannelFeedEdge> {
    public final void m22444a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoChannelFeedEdge graphQLVideoChannelFeedEdge = (GraphQLVideoChannelFeedEdge) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLVideoChannelFeedEdge.m22441a() != null) {
            jsonGenerator.a("node");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLVideoChannelFeedEdge.m22441a());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLVideoChannelFeedEdge.class, new GraphQLVideoChannelFeedEdgeSerializer());
    }
}
