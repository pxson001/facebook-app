package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_stopped */
public final class GraphQLApproximateCount__JsonHelper {
    public static GraphQLApproximateCount m6599a(JsonParser jsonParser) {
        GraphQLApproximateCount graphQLApproximateCount = new GraphQLApproximateCount();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("count".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLApproximateCount.f3388d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLApproximateCount, "count", graphQLApproximateCount.a_, 0, false);
            } else if ("may_exceed_count".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLApproximateCount.f3389e = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLApproximateCount, "may_exceed_count", graphQLApproximateCount.a_, 1, false);
            } else {
                int i3 = 0;
            }
            jsonParser.f();
        }
        return graphQLApproximateCount;
    }
}
