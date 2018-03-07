package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: getTcpBytesSent */
public final class GraphQLGoodwillThrowbackPermalinkColorPalette__JsonHelper {
    public static GraphQLGoodwillThrowbackPermalinkColorPalette m8068a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackPermalinkColorPalette graphQLGoodwillThrowbackPermalinkColorPalette = new GraphQLGoodwillThrowbackPermalinkColorPalette();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("title_color".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGoodwillThrowbackPermalinkColorPalette.f4029d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPermalinkColorPalette, "title_color", graphQLGoodwillThrowbackPermalinkColorPalette.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackPermalinkColorPalette;
    }

    public static void m8069a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackPermalinkColorPalette graphQLGoodwillThrowbackPermalinkColorPalette, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackPermalinkColorPalette.m8065a() != null) {
            jsonGenerator.a("title_color", graphQLGoodwillThrowbackPermalinkColorPalette.m8065a());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
