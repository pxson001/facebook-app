package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLVideoChannelDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Tigon */
public final class GraphQLVideoChannel$Serializer extends JsonSerializer<GraphQLVideoChannel> {
    public final void m22436a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoChannel graphQLVideoChannel = (GraphQLVideoChannel) obj;
        GraphQLVideoChannelDeserializer.m6178a(graphQLVideoChannel.w_(), graphQLVideoChannel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoChannel.class, new GraphQLVideoChannel$Serializer());
        FbSerializerProvider.a(GraphQLVideoChannel.class, new GraphQLVideoChannel$Serializer());
    }
}
