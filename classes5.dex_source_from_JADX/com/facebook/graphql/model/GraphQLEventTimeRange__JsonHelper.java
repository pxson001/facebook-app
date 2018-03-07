package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: image_hash */
public final class GraphQLEventTimeRange__JsonHelper {
    public static GraphQLEventTimeRange m7303a(JsonParser jsonParser) {
        GraphQLEventTimeRange graphQLEventTimeRange = new GraphQLEventTimeRange();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("end".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTimeRange.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTimeRange, "end", graphQLEventTimeRange.a_, 0, false);
            } else if ("start".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTimeRange.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTimeRange, "start", graphQLEventTimeRange.a_, 1, false);
            } else if ("timezone".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEventTimeRange.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventTimeRange, "timezone", graphQLEventTimeRange.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLEventTimeRange;
    }

    public static void m7304a(JsonGenerator jsonGenerator, GraphQLEventTimeRange graphQLEventTimeRange, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventTimeRange.a() != null) {
            jsonGenerator.a("end", graphQLEventTimeRange.a());
        }
        if (graphQLEventTimeRange.j() != null) {
            jsonGenerator.a("start", graphQLEventTimeRange.j());
        }
        if (graphQLEventTimeRange.k() != null) {
            jsonGenerator.a("timezone", graphQLEventTimeRange.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
