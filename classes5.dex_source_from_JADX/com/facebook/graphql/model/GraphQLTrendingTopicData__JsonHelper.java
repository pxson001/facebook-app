package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TransformedResultImpl */
public final class GraphQLTrendingTopicData__JsonHelper {
    public static GraphQLTrendingTopicData m22301a(JsonParser jsonParser) {
        GraphQLTrendingTopicData graphQLTrendingTopicData = new GraphQLTrendingTopicData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("attribution_uri".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrendingTopicData.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "attribution_uri", graphQLTrendingTopicData.a_, 0, false);
            } else if ("context_description".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrendingTopicData.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "context_description", graphQLTrendingTopicData.a_, 1, false);
            } else if ("context_photo".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "context_photo"));
                }
                graphQLTrendingTopicData.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "context_photo", graphQLTrendingTopicData.a_, 2, true);
            } else if ("headline_source".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrendingTopicData.g = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "headline_source", graphQLTrendingTopicData.a_, 3, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrendingTopicData.h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "id", graphQLTrendingTopicData.a_, 4, false);
            } else if ("topic_description".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrendingTopicData.i = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "topic_description", graphQLTrendingTopicData.a_, 5, false);
            } else if ("unique_keyword".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrendingTopicData.j = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "unique_keyword", graphQLTrendingTopicData.a_, 6, false);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrendingTopicData.k = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "url", graphQLTrendingTopicData.a_, 7, false);
            } else if ("context_photo_fullscreen_landscape".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "context_photo_fullscreen_landscape"));
                }
                graphQLTrendingTopicData.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "context_photo_fullscreen_landscape", graphQLTrendingTopicData.a_, 8, true);
            } else if ("context_photo_fullscreen_portrait".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "context_photo_fullscreen_portrait"));
                }
                graphQLTrendingTopicData.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrendingTopicData, "context_photo_fullscreen_portrait", graphQLTrendingTopicData.a_, 9, true);
            }
            jsonParser.f();
        }
        return graphQLTrendingTopicData;
    }

    public static void m22302a(JsonGenerator jsonGenerator, GraphQLTrendingTopicData graphQLTrendingTopicData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTrendingTopicData.j() != null) {
            jsonGenerator.a("attribution_uri", graphQLTrendingTopicData.j());
        }
        if (graphQLTrendingTopicData.k() != null) {
            jsonGenerator.a("context_description", graphQLTrendingTopicData.k());
        }
        if (graphQLTrendingTopicData.l() != null) {
            jsonGenerator.a("context_photo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTrendingTopicData.l(), true);
        }
        if (graphQLTrendingTopicData.m() != null) {
            jsonGenerator.a("headline_source", graphQLTrendingTopicData.m());
        }
        if (graphQLTrendingTopicData.n() != null) {
            jsonGenerator.a("id", graphQLTrendingTopicData.n());
        }
        if (graphQLTrendingTopicData.o() != null) {
            jsonGenerator.a("topic_description", graphQLTrendingTopicData.o());
        }
        if (graphQLTrendingTopicData.p() != null) {
            jsonGenerator.a("unique_keyword", graphQLTrendingTopicData.p());
        }
        if (graphQLTrendingTopicData.q() != null) {
            jsonGenerator.a("url", graphQLTrendingTopicData.q());
        }
        if (graphQLTrendingTopicData.r() != null) {
            jsonGenerator.a("context_photo_fullscreen_landscape");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTrendingTopicData.r(), true);
        }
        if (graphQLTrendingTopicData.s() != null) {
            jsonGenerator.a("context_photo_fullscreen_portrait");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTrendingTopicData.s(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
