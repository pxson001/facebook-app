package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLDateGranularity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_owned */
public final class GraphQLBackdatedTime__JsonHelper {
    public static GraphQLBackdatedTime m6633a(JsonParser jsonParser) {
        GraphQLBackdatedTime graphQLBackdatedTime = new GraphQLBackdatedTime();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("granularity".equals(i)) {
                graphQLBackdatedTime.d = GraphQLDateGranularity.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLBackdatedTime, "granularity", graphQLBackdatedTime.a_, 0, false);
            } else if ("time".equals(i)) {
                long j;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    j = 0;
                } else {
                    j = jsonParser.F();
                }
                graphQLBackdatedTime.e = j;
                FieldAccessQueryTracker.a(jsonParser, graphQLBackdatedTime, "time", graphQLBackdatedTime.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLBackdatedTime;
    }

    public static void m6634a(JsonGenerator jsonGenerator, GraphQLBackdatedTime graphQLBackdatedTime, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLBackdatedTime.a() != null) {
            jsonGenerator.a("granularity", graphQLBackdatedTime.a().toString());
        }
        jsonGenerator.a("time", graphQLBackdatedTime.j());
        if (z) {
            jsonGenerator.g();
        }
    }
}
