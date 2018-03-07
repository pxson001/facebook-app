package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: facebox_size */
public final class GraphQLMobileStoreObject__JsonHelper {
    public static GraphQLMobileStoreObject m9138a(JsonParser jsonParser) {
        GraphQLMobileStoreObject graphQLMobileStoreObject = new GraphQLMobileStoreObject();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMobileStoreObject.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMobileStoreObject, "id", graphQLMobileStoreObject.a_, 0, false);
            } else if ("native_store_id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMobileStoreObject.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMobileStoreObject, "native_store_id", graphQLMobileStoreObject.a_, 1, false);
            } else if ("native_store_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMobileStoreObject.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMobileStoreObject, "native_store_url", graphQLMobileStoreObject.a_, 2, false);
            } else if ("overall_star_rating".equals(i)) {
                GraphQLRating graphQLRating;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLRating = null;
                } else {
                    graphQLRating = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "overall_star_rating"));
                }
                graphQLMobileStoreObject.g = graphQLRating;
                FieldAccessQueryTracker.a(jsonParser, graphQLMobileStoreObject, "overall_star_rating", graphQLMobileStoreObject.a_, 3, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMobileStoreObject.h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMobileStoreObject, "url", graphQLMobileStoreObject.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLMobileStoreObject;
    }

    public static void m9139a(JsonGenerator jsonGenerator, GraphQLMobileStoreObject graphQLMobileStoreObject, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMobileStoreObject.j() != null) {
            jsonGenerator.a("id", graphQLMobileStoreObject.j());
        }
        if (graphQLMobileStoreObject.k() != null) {
            jsonGenerator.a("native_store_id", graphQLMobileStoreObject.k());
        }
        if (graphQLMobileStoreObject.l() != null) {
            jsonGenerator.a("native_store_url", graphQLMobileStoreObject.l());
        }
        if (graphQLMobileStoreObject.m() != null) {
            jsonGenerator.a("overall_star_rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLMobileStoreObject.m(), true);
        }
        if (graphQLMobileStoreObject.n() != null) {
            jsonGenerator.a("url", graphQLMobileStoreObject.n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
