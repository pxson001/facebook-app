package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WINDOWS_STORE */
public final class GraphQLPhotoEncoding__JsonHelper {
    public static GraphQLPhotoEncoding m20723a(JsonParser jsonParser) {
        GraphQLPhotoEncoding graphQLPhotoEncoding = new GraphQLPhotoEncoding();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("cdn_uri".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhotoEncoding.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoEncoding, "cdn_uri", graphQLPhotoEncoding.a_, 0, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhotoEncoding.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoEncoding, "id", graphQLPhotoEncoding.a_, 1, false);
            } else if ("projection_type".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhotoEncoding.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoEncoding, "projection_type", graphQLPhotoEncoding.a_, 2, false);
            } else if ("spherical_metadata".equals(i)) {
                GraphQLPhotosphereMetadata graphQLPhotosphereMetadata;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhotosphereMetadata = null;
                } else {
                    graphQLPhotosphereMetadata = GraphQLPhotosphereMetadata__JsonHelper.m20784a(FieldAccessQueryTracker.a(jsonParser, "spherical_metadata"));
                }
                graphQLPhotoEncoding.g = graphQLPhotosphereMetadata;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoEncoding, "spherical_metadata", graphQLPhotoEncoding.a_, 3, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhotoEncoding.h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoEncoding, "url", graphQLPhotoEncoding.a_, 4, false);
            } else if ("width".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhotoEncoding.i = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoEncoding, "width", graphQLPhotoEncoding.a_, 5, false);
            }
            jsonParser.f();
        }
        return graphQLPhotoEncoding;
    }

    public static void m20724a(JsonGenerator jsonGenerator, GraphQLPhotoEncoding graphQLPhotoEncoding, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPhotoEncoding.j() != null) {
            jsonGenerator.a("cdn_uri", graphQLPhotoEncoding.j());
        }
        if (graphQLPhotoEncoding.k() != null) {
            jsonGenerator.a("id", graphQLPhotoEncoding.k());
        }
        if (graphQLPhotoEncoding.l() != null) {
            jsonGenerator.a("projection_type", graphQLPhotoEncoding.l());
        }
        if (graphQLPhotoEncoding.m() != null) {
            jsonGenerator.a("spherical_metadata");
            GraphQLPhotosphereMetadata__JsonHelper.m20785a(jsonGenerator, graphQLPhotoEncoding.m(), true);
        }
        if (graphQLPhotoEncoding.n() != null) {
            jsonGenerator.a("url", graphQLPhotoEncoding.n());
        }
        jsonGenerator.a("width", graphQLPhotoEncoding.o());
        if (z) {
            jsonGenerator.g();
        }
    }
}
