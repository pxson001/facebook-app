package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNKNOWN_UNIT_TYPE */
public final class GraphQLTimeRange__JsonHelper {
    public static GraphQLTimeRange m22114a(JsonParser jsonParser) {
        GraphQLTimeRange graphQLTimeRange = new GraphQLTimeRange();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            long j = 0;
            if ("end".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    j = jsonParser.F();
                }
                graphQLTimeRange.d = j;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimeRange, "end", graphQLTimeRange.a_, 0, false);
            } else if ("start".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    j = jsonParser.F();
                }
                graphQLTimeRange.e = j;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimeRange, "start", graphQLTimeRange.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLTimeRange;
    }

    public static void m22115a(JsonGenerator jsonGenerator, GraphQLTimeRange graphQLTimeRange, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("end", graphQLTimeRange.a());
        jsonGenerator.a("start", graphQLTimeRange.j());
        if (z) {
            jsonGenerator.g();
        }
    }
}
