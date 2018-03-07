package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: follow_up_intent */
public final class GraphQLIcon__JsonHelper {
    public static GraphQLIcon m8613a(JsonParser jsonParser) {
        GraphQLIcon graphQLIcon = new GraphQLIcon();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("height".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLIcon.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLIcon, "height", graphQLIcon.a_, 0, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLIcon.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLIcon, "name", graphQLIcon.a_, 1, false);
            } else if ("uri".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLIcon.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLIcon, "uri", graphQLIcon.a_, 2, false);
            } else if ("width".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLIcon.g = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLIcon, "width", graphQLIcon.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLIcon;
    }

    public static void m8614a(JsonGenerator jsonGenerator, GraphQLIcon graphQLIcon, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("height", graphQLIcon.a());
        if (graphQLIcon.j() != null) {
            jsonGenerator.a("name", graphQLIcon.j());
        }
        if (graphQLIcon.k() != null) {
            jsonGenerator.a("uri", graphQLIcon.k());
        }
        jsonGenerator.a("width", graphQLIcon.l());
        if (z) {
            jsonGenerator.g();
        }
    }
}
