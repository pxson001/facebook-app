package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNewsFeedEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_watchers */
public final class GraphQLNewsFeedEdge$Serializer extends JsonSerializer<GraphQLNewsFeedEdge> {
    public final void m9259a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNewsFeedEdge graphQLNewsFeedEdge = (GraphQLNewsFeedEdge) obj;
        GraphQLNewsFeedEdgeDeserializer.m5426b(graphQLNewsFeedEdge.w_(), graphQLNewsFeedEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLNewsFeedEdge.class, new GraphQLNewsFeedEdge$Serializer());
        FbSerializerProvider.a(GraphQLNewsFeedEdge.class, new GraphQLNewsFeedEdge$Serializer());
    }
}
