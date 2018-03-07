package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fundraisers_native */
public final class GraphQLGraphSearchQueryTitle__JsonHelper {
    public static GraphQLGraphSearchQueryTitle m8263a(JsonParser jsonParser) {
        GraphQLGraphSearchQueryTitle graphQLGraphSearchQueryTitle = new GraphQLGraphSearchQueryTitle();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("text".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGraphSearchQueryTitle.d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryTitle, "text", graphQLGraphSearchQueryTitle.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLGraphSearchQueryTitle;
    }

    public static void m8264a(JsonGenerator jsonGenerator, GraphQLGraphSearchQueryTitle graphQLGraphSearchQueryTitle, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchQueryTitle.a() != null) {
            jsonGenerator.a("text", graphQLGraphSearchQueryTitle.a());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
