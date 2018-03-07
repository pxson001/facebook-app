package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getScreenOnTime */
public class GraphQLGoodwillThrowbackPromotionColorPaletteSerializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotionColorPalette> {
    public final void m8095a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackPromotionColorPalette__JsonHelper.m8097a(jsonGenerator, (GraphQLGoodwillThrowbackPromotionColorPalette) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotionColorPalette.class, new GraphQLGoodwillThrowbackPromotionColorPaletteSerializer());
    }
}
