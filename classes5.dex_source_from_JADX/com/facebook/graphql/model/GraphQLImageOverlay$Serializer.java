package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLImageOverlayDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: focus */
public final class GraphQLImageOverlay$Serializer extends JsonSerializer<GraphQLImageOverlay> {
    public final void m8627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImageOverlay graphQLImageOverlay = (GraphQLImageOverlay) obj;
        GraphQLImageOverlayDeserializer.m5230b(graphQLImageOverlay.w_(), graphQLImageOverlay.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLImageOverlay.class, new GraphQLImageOverlay$Serializer());
        FbSerializerProvider.a(GraphQLImageOverlay.class, new GraphQLImageOverlay$Serializer());
    }
}
