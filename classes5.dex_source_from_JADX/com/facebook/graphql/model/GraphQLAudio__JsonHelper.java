package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_photo_container */
public final class GraphQLAudio__JsonHelper {
    public static GraphQLAudio m6627a(JsonParser jsonParser) {
        GraphQLAudio graphQLAudio = new GraphQLAudio();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("url".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLAudio.d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLAudio, "url", graphQLAudio.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLAudio;
    }

    public static void m6628a(JsonGenerator jsonGenerator, GraphQLAudio graphQLAudio, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAudio.a() != null) {
            jsonGenerator.a("url", graphQLAudio.a());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
