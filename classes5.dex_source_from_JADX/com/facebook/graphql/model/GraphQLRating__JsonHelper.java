package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEWER_NEWLY_ADDED */
public final class GraphQLRating__JsonHelper {
    public static GraphQLRating m21310a(JsonParser jsonParser) {
        GraphQLRating graphQLRating = new GraphQLRating();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("rating_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLRating.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLRating, "rating_count", graphQLRating.a_, 0, false);
            } else if ("scale".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLRating.e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLRating, "scale", graphQLRating.a_, 1, false);
            } else if ("value".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLRating.f = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLRating, "value", graphQLRating.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLRating;
    }

    public static void m21311a(JsonGenerator jsonGenerator, GraphQLRating graphQLRating, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("rating_count", graphQLRating.a());
        jsonGenerator.a("scale", graphQLRating.j());
        jsonGenerator.a("value", graphQLRating.k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
