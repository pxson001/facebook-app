package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLDebugFeedEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_place_picker_report_swipe_button */
public final class GraphQLDebugFeedEdge$Serializer extends JsonSerializer<GraphQLDebugFeedEdge> {
    public final void m6937a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLDebugFeedEdge graphQLDebugFeedEdge = (GraphQLDebugFeedEdge) obj;
        GraphQLDebugFeedEdgeDeserializer.m4711b(graphQLDebugFeedEdge.w_(), graphQLDebugFeedEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLDebugFeedEdge.class, new GraphQLDebugFeedEdge$Serializer());
        FbSerializerProvider.a(GraphQLDebugFeedEdge.class, new GraphQLDebugFeedEdge$Serializer());
    }
}
