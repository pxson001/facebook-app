package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStickerDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unexpected HTTP code  */
public final class GraphQLSticker$Serializer extends JsonSerializer<GraphQLSticker> {
    public final void m21833a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSticker graphQLSticker = (GraphQLSticker) obj;
        GraphQLStickerDeserializer.m5947a(graphQLSticker.w_(), graphQLSticker.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSticker.class, new GraphQLSticker$Serializer());
        FbSerializerProvider.a(GraphQLSticker.class, new GraphQLSticker$Serializer());
    }
}
