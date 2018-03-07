package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Undefined content fragment factory identifier %s */
public class GraphQLStickerSerializer extends JsonSerializer<GraphQLSticker> {
    public final void m21835a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSticker__JsonHelper.m21837a(jsonGenerator, (GraphQLSticker) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSticker.class, new GraphQLStickerSerializer());
    }
}
