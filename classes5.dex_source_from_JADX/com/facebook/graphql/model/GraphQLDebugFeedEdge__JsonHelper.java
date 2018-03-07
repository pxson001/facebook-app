package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ios_place_picker_edit_swipe_button */
public final class GraphQLDebugFeedEdge__JsonHelper {
    public static GraphQLDebugFeedEdge m6940a(JsonParser jsonParser) {
        GraphQLDebugFeedEdge graphQLDebugFeedEdge = new GraphQLDebugFeedEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("bump_reason".equals(i)) {
                graphQLDebugFeedEdge.d = GraphQLBumpReason.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "bump_reason", graphQLDebugFeedEdge.a_, 0, false);
            } else if ("cursor".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDebugFeedEdge.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "cursor", graphQLDebugFeedEdge.a_, 1, false);
            } else if ("deduplication_key".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDebugFeedEdge.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "deduplication_key", graphQLDebugFeedEdge.a_, 2, false);
            } else if ("disallow_first_position".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLDebugFeedEdge.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "disallow_first_position", graphQLDebugFeedEdge.a_, 3, false);
            } else if ("features_meta".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDebugFeedEdge.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "features_meta", graphQLDebugFeedEdge.a_, 4, false);
            } else if ("is_in_low_engagement_block".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLDebugFeedEdge.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "is_in_low_engagement_block", graphQLDebugFeedEdge.a_, 5, false);
            } else if ("node".equals(i)) {
                FeedUnit feedUnit;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    feedUnit = null;
                } else {
                    feedUnit = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLDebugFeedEdge.j = feedUnit;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "node", graphQLDebugFeedEdge.a_, 6, true);
            } else if ("ranking_weight".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLDebugFeedEdge.k = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "ranking_weight", graphQLDebugFeedEdge.a_, 7, false);
            } else if ("sort_key".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDebugFeedEdge.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedEdge, "sort_key", graphQLDebugFeedEdge.a_, 8, false);
            }
            jsonParser.f();
        }
        return graphQLDebugFeedEdge;
    }

    public static void m6941a(JsonGenerator jsonGenerator, GraphQLDebugFeedEdge graphQLDebugFeedEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLDebugFeedEdge.a() != null) {
            jsonGenerator.a("bump_reason", graphQLDebugFeedEdge.a().toString());
        }
        if (graphQLDebugFeedEdge.j() != null) {
            jsonGenerator.a("cursor", graphQLDebugFeedEdge.j());
        }
        if (graphQLDebugFeedEdge.k() != null) {
            jsonGenerator.a("deduplication_key", graphQLDebugFeedEdge.k());
        }
        jsonGenerator.a("disallow_first_position", graphQLDebugFeedEdge.l());
        if (graphQLDebugFeedEdge.m() != null) {
            jsonGenerator.a("features_meta", graphQLDebugFeedEdge.m());
        }
        jsonGenerator.a("is_in_low_engagement_block", graphQLDebugFeedEdge.n());
        if (graphQLDebugFeedEdge.o() != null) {
            jsonGenerator.a("node");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLDebugFeedEdge.o());
        }
        jsonGenerator.a("ranking_weight", graphQLDebugFeedEdge.p());
        if (graphQLDebugFeedEdge.q() != null) {
            jsonGenerator.a("sort_key", graphQLDebugFeedEdge.q());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
