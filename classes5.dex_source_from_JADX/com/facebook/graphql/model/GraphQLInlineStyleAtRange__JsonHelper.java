package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLInlineStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: filtered_query */
public final class GraphQLInlineStyleAtRange__JsonHelper {
    public static GraphQLInlineStyleAtRange m8703a(JsonParser jsonParser) {
        GraphQLInlineStyleAtRange graphQLInlineStyleAtRange = new GraphQLInlineStyleAtRange();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("inline_style".equals(i)) {
                graphQLInlineStyleAtRange.d = GraphQLInlineStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLInlineStyleAtRange, "inline_style", graphQLInlineStyleAtRange.a_, 0, false);
            } else if ("length".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLInlineStyleAtRange.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLInlineStyleAtRange, "length", graphQLInlineStyleAtRange.a_, 1, false);
            } else if ("offset".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLInlineStyleAtRange.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLInlineStyleAtRange, "offset", graphQLInlineStyleAtRange.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLInlineStyleAtRange;
    }

    public static void m8704a(JsonGenerator jsonGenerator, GraphQLInlineStyleAtRange graphQLInlineStyleAtRange, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLInlineStyleAtRange.a() != null) {
            jsonGenerator.a("inline_style", graphQLInlineStyleAtRange.a().toString());
        }
        jsonGenerator.a("length", graphQLInlineStyleAtRange.j());
        jsonGenerator.a("offset", graphQLInlineStyleAtRange.k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
