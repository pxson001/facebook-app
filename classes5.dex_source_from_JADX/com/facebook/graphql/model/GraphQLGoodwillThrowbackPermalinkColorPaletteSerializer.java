package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getTimeAtCpuSpeedStep */
public class GraphQLGoodwillThrowbackPermalinkColorPaletteSerializer extends JsonSerializer<GraphQLGoodwillThrowbackPermalinkColorPalette> {
    public final void m8067a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackPermalinkColorPalette__JsonHelper.m8069a(jsonGenerator, (GraphQLGoodwillThrowbackPermalinkColorPalette) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackPermalinkColorPalette.class, new GraphQLGoodwillThrowbackPermalinkColorPaletteSerializer());
    }
}
