package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TimeSpan{ */
public final class GraphQLVideoAnnotation__JsonHelper {
    public static GraphQLVideoAnnotation m22429a(JsonParser jsonParser) {
        GraphQLVideoAnnotation graphQLVideoAnnotation = new GraphQLVideoAnnotation();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("end_time_in_sec".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLVideoAnnotation.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoAnnotation, "end_time_in_sec", graphQLVideoAnnotation.a_, 0, false);
            } else if ("image_uri".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLVideoAnnotation.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoAnnotation, "image_uri", graphQLVideoAnnotation.a_, 1, false);
            } else if ("link".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLVideoAnnotation.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoAnnotation, "link", graphQLVideoAnnotation.a_, 2, false);
            } else if ("link_caption".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLVideoAnnotation.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoAnnotation, "link_caption", graphQLVideoAnnotation.a_, 3, false);
            } else if ("link_description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLVideoAnnotation.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoAnnotation, "link_description", graphQLVideoAnnotation.a_, 4, false);
            } else if ("link_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLVideoAnnotation.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoAnnotation, "link_title", graphQLVideoAnnotation.a_, 5, false);
            } else if ("start_time_in_sec".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLVideoAnnotation.j = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoAnnotation, "start_time_in_sec", graphQLVideoAnnotation.a_, 6, false);
            }
            jsonParser.f();
        }
        return graphQLVideoAnnotation;
    }

    public static void m22430a(JsonGenerator jsonGenerator, GraphQLVideoAnnotation graphQLVideoAnnotation, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("end_time_in_sec", graphQLVideoAnnotation.a());
        if (graphQLVideoAnnotation.j() != null) {
            jsonGenerator.a("image_uri", graphQLVideoAnnotation.j());
        }
        if (graphQLVideoAnnotation.k() != null) {
            jsonGenerator.a("link", graphQLVideoAnnotation.k());
        }
        if (graphQLVideoAnnotation.l() != null) {
            jsonGenerator.a("link_caption", graphQLVideoAnnotation.l());
        }
        if (graphQLVideoAnnotation.m() != null) {
            jsonGenerator.a("link_description", graphQLVideoAnnotation.m());
        }
        if (graphQLVideoAnnotation.n() != null) {
            jsonGenerator.a("link_title", graphQLVideoAnnotation.n());
        }
        jsonGenerator.a("start_time_in_sec", graphQLVideoAnnotation.o());
        if (z) {
            jsonGenerator.g();
        }
    }
}
