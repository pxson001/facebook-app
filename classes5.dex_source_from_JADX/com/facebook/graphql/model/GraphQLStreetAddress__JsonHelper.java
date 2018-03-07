package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: USERNAME_EDITOR */
public final class GraphQLStreetAddress__JsonHelper {
    public static GraphQLStreetAddress m21936a(JsonParser jsonParser) {
        GraphQLStreetAddress graphQLStreetAddress = new GraphQLStreetAddress();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("addressee".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "addressee", graphQLStreetAddress.a_, 0, false);
            } else if ("building".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "building", graphQLStreetAddress.a_, 1, false);
            } else if ("city".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "city", graphQLStreetAddress.a_, 2, false);
            } else if ("country".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.g = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "country", graphQLStreetAddress.a_, 3, false);
            } else if ("full_address".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "full_address", graphQLStreetAddress.a_, 4, false);
            } else if ("postal_code".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.i = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "postal_code", graphQLStreetAddress.a_, 5, false);
            } else if ("single_line_full_address".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.j = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "single_line_full_address", graphQLStreetAddress.a_, 6, false);
            } else if ("street".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreetAddress.k = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreetAddress, "street", graphQLStreetAddress.a_, 7, false);
            }
            jsonParser.f();
        }
        return graphQLStreetAddress;
    }

    public static void m21937a(JsonGenerator jsonGenerator, GraphQLStreetAddress graphQLStreetAddress, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStreetAddress.a() != null) {
            jsonGenerator.a("addressee", graphQLStreetAddress.a());
        }
        if (graphQLStreetAddress.j() != null) {
            jsonGenerator.a("building", graphQLStreetAddress.j());
        }
        if (graphQLStreetAddress.k() != null) {
            jsonGenerator.a("city", graphQLStreetAddress.k());
        }
        if (graphQLStreetAddress.l() != null) {
            jsonGenerator.a("country", graphQLStreetAddress.l());
        }
        if (graphQLStreetAddress.m() != null) {
            jsonGenerator.a("full_address", graphQLStreetAddress.m());
        }
        if (graphQLStreetAddress.n() != null) {
            jsonGenerator.a("postal_code", graphQLStreetAddress.n());
        }
        if (graphQLStreetAddress.o() != null) {
            jsonGenerator.a("single_line_full_address", graphQLStreetAddress.o());
        }
        if (graphQLStreetAddress.p() != null) {
            jsonGenerator.a("street", graphQLStreetAddress.p());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
