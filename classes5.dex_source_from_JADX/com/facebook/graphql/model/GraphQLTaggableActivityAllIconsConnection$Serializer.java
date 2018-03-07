package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityAllIconsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSUB */
public final class GraphQLTaggableActivityAllIconsConnection$Serializer extends JsonSerializer<GraphQLTaggableActivityAllIconsConnection> {
    public final void m22043a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivityAllIconsConnection graphQLTaggableActivityAllIconsConnection = (GraphQLTaggableActivityAllIconsConnection) obj;
        GraphQLTaggableActivityAllIconsConnectionDeserializer.m6031a(graphQLTaggableActivityAllIconsConnection.w_(), graphQLTaggableActivityAllIconsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivityAllIconsConnection.class, new GraphQLTaggableActivityAllIconsConnection$Serializer());
        FbSerializerProvider.a(GraphQLTaggableActivityAllIconsConnection.class, new GraphQLTaggableActivityAllIconsConnection$Serializer());
    }
}
