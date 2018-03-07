package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: getScreenBrightnessTime */
public final class GraphQLGoodwillThrowbackPromotionColorPalette__JsonHelper {
    public static GraphQLGoodwillThrowbackPromotionColorPalette m8096a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackPromotionColorPalette graphQLGoodwillThrowbackPromotionColorPalette = new GraphQLGoodwillThrowbackPromotionColorPalette();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("chevron_color".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGoodwillThrowbackPromotionColorPalette.f4032d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionColorPalette, "chevron_color", graphQLGoodwillThrowbackPromotionColorPalette.a_, 0, false);
            } else if ("title_color".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGoodwillThrowbackPromotionColorPalette.f4033e = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionColorPalette, "title_color", graphQLGoodwillThrowbackPromotionColorPalette.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackPromotionColorPalette;
    }

    public static void m8097a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackPromotionColorPalette graphQLGoodwillThrowbackPromotionColorPalette, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackPromotionColorPalette.m8092a() != null) {
            jsonGenerator.a("chevron_color", graphQLGoodwillThrowbackPromotionColorPalette.m8092a());
        }
        if (graphQLGoodwillThrowbackPromotionColorPalette.m8093j() != null) {
            jsonGenerator.a("title_color", graphQLGoodwillThrowbackPromotionColorPalette.m8093j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
