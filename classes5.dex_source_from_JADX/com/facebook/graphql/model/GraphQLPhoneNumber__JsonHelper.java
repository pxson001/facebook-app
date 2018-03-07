package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBlockStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WINE_SPIRITS */
public final class GraphQLPhoneNumber__JsonHelper {
    public static GraphQLPhoneNumber m20713a(JsonParser jsonParser) {
        GraphQLPhoneNumber graphQLPhoneNumber = new GraphQLPhoneNumber();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("block_status".equals(i)) {
                graphQLPhoneNumber.d = GraphQLBlockStatus.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLPhoneNumber, "block_status", graphQLPhoneNumber.a_, 0, false);
            } else if ("country_code".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhoneNumber.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhoneNumber, "country_code", graphQLPhoneNumber.a_, 1, false);
            } else if ("display_number".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhoneNumber.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhoneNumber, "display_number", graphQLPhoneNumber.a_, 2, false);
            } else if ("national_number".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhoneNumber.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhoneNumber, "national_number", graphQLPhoneNumber.a_, 3, false);
            } else if ("universal_number".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhoneNumber.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhoneNumber, "universal_number", graphQLPhoneNumber.a_, 4, false);
            } else if ("__typename".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhoneNumber.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhoneNumber, "__typename", graphQLPhoneNumber.a_, 5, false);
            }
            jsonParser.f();
        }
        return graphQLPhoneNumber;
    }

    public static void m20714a(JsonGenerator jsonGenerator, GraphQLPhoneNumber graphQLPhoneNumber, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPhoneNumber.a() != null) {
            jsonGenerator.a("block_status", graphQLPhoneNumber.a().toString());
        }
        if (graphQLPhoneNumber.j() != null) {
            jsonGenerator.a("country_code", graphQLPhoneNumber.j());
        }
        if (graphQLPhoneNumber.k() != null) {
            jsonGenerator.a("display_number", graphQLPhoneNumber.k());
        }
        if (graphQLPhoneNumber.l() != null) {
            jsonGenerator.a("national_number", graphQLPhoneNumber.l());
        }
        if (graphQLPhoneNumber.m() != null) {
            jsonGenerator.a("universal_number", graphQLPhoneNumber.m());
        }
        if (graphQLPhoneNumber.n() != null) {
            jsonGenerator.a("__typename", graphQLPhoneNumber.n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
