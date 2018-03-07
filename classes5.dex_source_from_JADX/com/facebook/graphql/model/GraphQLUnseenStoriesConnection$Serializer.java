package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLUnseenStoriesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Total bluetooth usage  */
public final class GraphQLUnseenStoriesConnection$Serializer extends JsonSerializer<GraphQLUnseenStoriesConnection> {
    public final void m22353a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUnseenStoriesConnection graphQLUnseenStoriesConnection = (GraphQLUnseenStoriesConnection) obj;
        GraphQLUnseenStoriesConnectionDeserializer.m6144a(graphQLUnseenStoriesConnection.w_(), graphQLUnseenStoriesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLUnseenStoriesConnection.class, new GraphQLUnseenStoriesConnection$Serializer());
        FbSerializerProvider.a(GraphQLUnseenStoriesConnection.class, new GraphQLUnseenStoriesConnection$Serializer());
    }
}
