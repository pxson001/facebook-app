package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_browser_tiled */
public class GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotionColorPalette.class, new GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer());
    }

    public GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer() {
        a(GraphQLGoodwillThrowbackPromotionColorPalette.class);
    }

    public Object m8094a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackPromotionColorPalette__JsonHelper.m8096a(jsonParser);
    }
}
