package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEW_UPCOMING_BIRTHDAYS_DASHBOARD */
public final class GraphQLQuantity__JsonHelper {
    public static GraphQLQuantity m21149a(JsonParser jsonParser) {
        GraphQLQuantity graphQLQuantity = new GraphQLQuantity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("unit".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLQuantity.f12824d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuantity, "unit", graphQLQuantity.a_, 0, false);
            } else if ("value".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLQuantity.f12825e = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuantity, "value", graphQLQuantity.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLQuantity;
    }
}
