package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: event_viewer_capability */
public final class GraphQLNewsFeedEdge__JsonHelper {
    public static GraphQLNewsFeedEdge m9262a(JsonParser jsonParser) {
        GraphQLNewsFeedEdge graphQLNewsFeedEdge = new GraphQLNewsFeedEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("bump_reason".equals(i)) {
                graphQLNewsFeedEdge.d = GraphQLBumpReason.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "bump_reason", graphQLNewsFeedEdge.a_, 0, false);
            } else if ("cursor".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLNewsFeedEdge.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "cursor", graphQLNewsFeedEdge.a_, 1, false);
            } else if ("deduplication_key".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLNewsFeedEdge.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "deduplication_key", graphQLNewsFeedEdge.a_, 2, false);
            } else if ("disallow_first_position".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLNewsFeedEdge.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "disallow_first_position", graphQLNewsFeedEdge.a_, 3, false);
            } else if ("features_meta".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLNewsFeedEdge.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "features_meta", graphQLNewsFeedEdge.a_, 4, false);
            } else if ("is_in_low_engagement_block".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLNewsFeedEdge.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "is_in_low_engagement_block", graphQLNewsFeedEdge.a_, 5, false);
            } else if ("node".equals(i)) {
                FeedUnit feedUnit;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    feedUnit = null;
                } else {
                    feedUnit = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLNewsFeedEdge.j = feedUnit;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "node", graphQLNewsFeedEdge.a_, 6, true);
            } else if ("ranking_weight".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLNewsFeedEdge.k = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "ranking_weight", graphQLNewsFeedEdge.a_, 7, false);
            } else if ("sort_key".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLNewsFeedEdge.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedEdge, "sort_key", graphQLNewsFeedEdge.a_, 8, false);
            }
            jsonParser.f();
        }
        return graphQLNewsFeedEdge;
    }

    public static void m9263a(JsonGenerator jsonGenerator, GraphQLNewsFeedEdge graphQLNewsFeedEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLNewsFeedEdge.a() != null) {
            jsonGenerator.a("bump_reason", graphQLNewsFeedEdge.a().toString());
        }
        if (graphQLNewsFeedEdge.j() != null) {
            jsonGenerator.a("cursor", graphQLNewsFeedEdge.j());
        }
        if (graphQLNewsFeedEdge.k() != null) {
            jsonGenerator.a("deduplication_key", graphQLNewsFeedEdge.k());
        }
        jsonGenerator.a("disallow_first_position", graphQLNewsFeedEdge.l());
        if (graphQLNewsFeedEdge.m() != null) {
            jsonGenerator.a("features_meta", graphQLNewsFeedEdge.m());
        }
        jsonGenerator.a("is_in_low_engagement_block", graphQLNewsFeedEdge.n());
        if (graphQLNewsFeedEdge.o() != null) {
            jsonGenerator.a("node");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLNewsFeedEdge.o());
        }
        jsonGenerator.a("ranking_weight", graphQLNewsFeedEdge.p());
        if (graphQLNewsFeedEdge.q() != null) {
            jsonGenerator.a("sort_key", graphQLNewsFeedEdge.q());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
