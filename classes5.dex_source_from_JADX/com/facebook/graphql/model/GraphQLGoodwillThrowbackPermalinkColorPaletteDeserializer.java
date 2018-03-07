package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_connection_questions */
public class GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPermalinkColorPalette.class, new GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer());
    }

    public GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer() {
        a(GraphQLGoodwillThrowbackPermalinkColorPalette.class);
    }

    public Object m8066a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackPermalinkColorPalette__JsonHelper.m8068a(jsonParser);
    }
}
