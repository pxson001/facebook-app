package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: friends_profile_picture_urls */
public final class GraphQLGreetingCardTemplateTheme__JsonHelper {
    public static GraphQLGreetingCardTemplateTheme m8371a(JsonParser jsonParser) {
        GraphQLGreetingCardTemplateTheme graphQLGreetingCardTemplateTheme = new GraphQLGreetingCardTemplateTheme();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("color".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGreetingCardTemplateTheme.f4137d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardTemplateTheme, "color", graphQLGreetingCardTemplateTheme.a_, 0, false);
            } else if ("name".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGreetingCardTemplateTheme.f4138e = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardTemplateTheme, "name", graphQLGreetingCardTemplateTheme.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGreetingCardTemplateTheme;
    }

    public static void m8372a(JsonGenerator jsonGenerator, GraphQLGreetingCardTemplateTheme graphQLGreetingCardTemplateTheme, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGreetingCardTemplateTheme.m8367a() != null) {
            jsonGenerator.a("color", graphQLGreetingCardTemplateTheme.m8367a());
        }
        if (graphQLGreetingCardTemplateTheme.m8368j() != null) {
            jsonGenerator.a("name", graphQLGreetingCardTemplateTheme.m8368j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
