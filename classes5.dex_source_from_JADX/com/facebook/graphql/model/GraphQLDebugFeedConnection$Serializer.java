package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLDebugFeedConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_places_new_suggest_edits */
public final class GraphQLDebugFeedConnection$Serializer extends JsonSerializer<GraphQLDebugFeedConnection> {
    public final void m6931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLDebugFeedConnection graphQLDebugFeedConnection = (GraphQLDebugFeedConnection) obj;
        GraphQLDebugFeedConnectionDeserializer.m4708a(graphQLDebugFeedConnection.w_(), graphQLDebugFeedConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLDebugFeedConnection.class, new GraphQLDebugFeedConnection$Serializer());
        FbSerializerProvider.a(GraphQLDebugFeedConnection.class, new GraphQLDebugFeedConnection$Serializer());
    }
}
