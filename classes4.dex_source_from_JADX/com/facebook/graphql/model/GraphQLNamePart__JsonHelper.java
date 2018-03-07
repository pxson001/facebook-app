package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: saved_accounts/ */
public final class GraphQLNamePart__JsonHelper {
    public static GraphQLNamePart m3239a(JsonParser jsonParser) {
        GraphQLNamePart graphQLNamePart = new GraphQLNamePart();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("length".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLNamePart.f2986d = i2;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLNamePart, "length", graphQLNamePart.a_, 0, false);
            } else if ("offset".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLNamePart.f2987e = i2;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLNamePart, "offset", graphQLNamePart.a_, 1, false);
            } else if ("part".equals(i)) {
                graphQLNamePart.f2988f = GraphQLStructuredNamePart.fromString(jsonParser.o());
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLNamePart, "part", graphQLNamePart.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLNamePart;
    }

    public static void m3240a(JsonGenerator jsonGenerator, GraphQLNamePart graphQLNamePart, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("length", graphQLNamePart.mo139a());
        jsonGenerator.a("offset", graphQLNamePart.t_());
        if (graphQLNamePart.mo140c() != null) {
            jsonGenerator.a("part", graphQLNamePart.mo140c().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
