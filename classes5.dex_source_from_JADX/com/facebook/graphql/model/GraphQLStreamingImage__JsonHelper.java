package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: USER_CREATED */
public final class GraphQLStreamingImage__JsonHelper {
    public static GraphQLStreamingImage m21929a(JsonParser jsonParser) {
        GraphQLStreamingImage graphQLStreamingImage = new GraphQLStreamingImage();
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
                graphQLStreamingImage.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreamingImage, "height", graphQLStreamingImage.a_, 0, false);
            } else if ("uri".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStreamingImage.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreamingImage, "uri", graphQLStreamingImage.a_, 1, false);
            } else if ("width".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStreamingImage.f = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStreamingImage, "width", graphQLStreamingImage.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLStreamingImage;
    }

    public static void m21930a(JsonGenerator jsonGenerator, GraphQLStreamingImage graphQLStreamingImage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("height", graphQLStreamingImage.a());
        if (graphQLStreamingImage.j() != null) {
            jsonGenerator.a("uri", graphQLStreamingImage.j());
        }
        jsonGenerator.a("width", graphQLStreamingImage.k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
