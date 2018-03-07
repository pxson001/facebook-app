package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ios_post_checkin_upload_photo_flow */
public final class GraphQLCurrencyQuantity__JsonHelper {
    public static GraphQLCurrencyQuantity m6924a(JsonParser jsonParser) {
        GraphQLCurrencyQuantity graphQLCurrencyQuantity = new GraphQLCurrencyQuantity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("amount".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLCurrencyQuantity.d = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLCurrencyQuantity, "amount", graphQLCurrencyQuantity.a_, 0, false);
            } else if ("amount_with_offset".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLCurrencyQuantity.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCurrencyQuantity, "amount_with_offset", graphQLCurrencyQuantity.a_, 1, false);
            } else if ("currency".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCurrencyQuantity.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCurrencyQuantity, "currency", graphQLCurrencyQuantity.a_, 2, false);
            } else if ("formatted".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCurrencyQuantity.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCurrencyQuantity, "formatted", graphQLCurrencyQuantity.a_, 3, false);
            } else if ("offset".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLCurrencyQuantity.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCurrencyQuantity, "offset", graphQLCurrencyQuantity.a_, 4, false);
            } else if ("offset_amount".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCurrencyQuantity.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCurrencyQuantity, "offset_amount", graphQLCurrencyQuantity.a_, 5, false);
            }
            jsonParser.f();
        }
        return graphQLCurrencyQuantity;
    }

    public static void m6925a(JsonGenerator jsonGenerator, GraphQLCurrencyQuantity graphQLCurrencyQuantity, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("amount", graphQLCurrencyQuantity.a());
        jsonGenerator.a("amount_with_offset", graphQLCurrencyQuantity.j());
        if (graphQLCurrencyQuantity.k() != null) {
            jsonGenerator.a("currency", graphQLCurrencyQuantity.k());
        }
        if (graphQLCurrencyQuantity.l() != null) {
            jsonGenerator.a("formatted", graphQLCurrencyQuantity.l());
        }
        jsonGenerator.a("offset", graphQLCurrencyQuantity.m());
        if (graphQLCurrencyQuantity.n() != null) {
            jsonGenerator.a("offset_amount", graphQLCurrencyQuantity.n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
