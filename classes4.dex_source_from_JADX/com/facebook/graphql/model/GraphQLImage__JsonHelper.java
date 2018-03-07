package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: smallPictureUrl */
public final class GraphQLImage__JsonHelper {
    public static GraphQLImage m2260a(JsonParser jsonParser) {
        GraphQLImage graphQLImage = new GraphQLImage();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("height".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLImage.d = i2;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLImage, "height", graphQLImage.a_, 0, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLImage.e = r3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLImage, "name", graphQLImage.a_, 1, false);
            } else if ("scale".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLImage.f = d;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLImage, "scale", graphQLImage.a_, 2, false);
            } else if ("uri".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLImage.g = r3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLImage, "uri", graphQLImage.a_, 3, false);
            } else if ("width".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLImage.h = i2;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLImage, "width", graphQLImage.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLImage;
    }

    public static void m2261a(JsonGenerator jsonGenerator, GraphQLImage graphQLImage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("height", graphQLImage.a());
        if (graphQLImage.d() != null) {
            jsonGenerator.a("name", graphQLImage.d());
        }
        jsonGenerator.a("scale", graphQLImage.j());
        if (graphQLImage.b() != null) {
            jsonGenerator.a("uri", graphQLImage.b());
        }
        jsonGenerator.a("width", graphQLImage.c());
        if (z) {
            jsonGenerator.g();
        }
    }
}
