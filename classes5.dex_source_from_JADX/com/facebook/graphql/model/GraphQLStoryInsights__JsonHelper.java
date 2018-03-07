package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unable to copy traces file */
public final class GraphQLStoryInsights__JsonHelper {
    public static GraphQLStoryInsights m21879a(JsonParser jsonParser) {
        GraphQLStoryInsights graphQLStoryInsights = new GraphQLStoryInsights();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("best_post_reach".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "best_post_reach", graphQLStoryInsights.a_, 0, false);
            } else if ("engaged_user_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "engaged_user_count", graphQLStoryInsights.a_, 1, false);
            } else if ("linkClicks".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.f = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "linkClicks", graphQLStoryInsights.a_, 2, false);
            } else if ("organic_reach".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.g = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "organic_reach", graphQLStoryInsights.a_, 3, false);
            } else if ("otherClicks".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.h = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "otherClicks", graphQLStoryInsights.a_, 4, false);
            } else if ("paid_reach".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.i = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "paid_reach", graphQLStoryInsights.a_, 5, false);
            } else if ("photoViews".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.j = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "photoViews", graphQLStoryInsights.a_, 6, false);
            } else if ("totalClicks".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.k = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "totalClicks", graphQLStoryInsights.a_, 7, false);
            } else if ("total_reach".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.l = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "total_reach", graphQLStoryInsights.a_, 8, false);
            } else if ("videoPlays".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStoryInsights.m = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryInsights, "videoPlays", graphQLStoryInsights.a_, 9, false);
            }
            jsonParser.f();
        }
        return graphQLStoryInsights;
    }

    public static void m21880a(JsonGenerator jsonGenerator, GraphQLStoryInsights graphQLStoryInsights, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("best_post_reach", graphQLStoryInsights.a());
        jsonGenerator.a("engaged_user_count", graphQLStoryInsights.j());
        jsonGenerator.a("linkClicks", graphQLStoryInsights.k());
        jsonGenerator.a("organic_reach", graphQLStoryInsights.l());
        jsonGenerator.a("otherClicks", graphQLStoryInsights.m());
        jsonGenerator.a("paid_reach", graphQLStoryInsights.n());
        jsonGenerator.a("photoViews", graphQLStoryInsights.o());
        jsonGenerator.a("totalClicks", graphQLStoryInsights.p());
        jsonGenerator.a("total_reach", graphQLStoryInsights.q());
        jsonGenerator.a("videoPlays", graphQLStoryInsights.r());
        if (z) {
            jsonGenerator.g();
        }
    }
}
