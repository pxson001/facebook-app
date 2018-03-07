package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: home_team_primary_color */
public final class GraphQLFeedUnitEdge__JsonHelper {
    public static GraphQLFeedUnitEdge m7471a(JsonParser jsonParser) {
        GraphQLFeedUnitEdge graphQLFeedUnitEdge = new GraphQLFeedUnitEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("bump_reason".equals(i)) {
                graphQLFeedUnitEdge.d = GraphQLBumpReason.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "bump_reason", graphQLFeedUnitEdge.a_, 0, false);
            } else if ("cursor".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedUnitEdge.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "cursor", graphQLFeedUnitEdge.a_, 1, false);
            } else if ("deduplication_key".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedUnitEdge.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "deduplication_key", graphQLFeedUnitEdge.a_, 2, false);
            } else if ("disallow_first_position".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLFeedUnitEdge.g = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "disallow_first_position", graphQLFeedUnitEdge.a_, 3, false);
            } else if ("features_meta".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedUnitEdge.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "features_meta", graphQLFeedUnitEdge.a_, 4, false);
            } else if ("node".equals(i)) {
                FeedUnit feedUnit;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    feedUnit = null;
                } else {
                    feedUnit = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLFeedUnitEdge.i = feedUnit;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "node", graphQLFeedUnitEdge.a_, 5, true);
            } else if ("ranking_weight".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLFeedUnitEdge.j = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "ranking_weight", graphQLFeedUnitEdge.a_, 6, false);
            } else if ("sort_key".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedUnitEdge.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedUnitEdge, "sort_key", graphQLFeedUnitEdge.a_, 7, false);
            }
            jsonParser.f();
        }
        return graphQLFeedUnitEdge;
    }

    public static void m7472a(JsonGenerator jsonGenerator, GraphQLFeedUnitEdge graphQLFeedUnitEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFeedUnitEdge.m() != null) {
            jsonGenerator.a("bump_reason", graphQLFeedUnitEdge.m().toString());
        }
        if (graphQLFeedUnitEdge.g() != null) {
            jsonGenerator.a("cursor", graphQLFeedUnitEdge.g());
        }
        if (graphQLFeedUnitEdge.b() != null) {
            jsonGenerator.a("deduplication_key", graphQLFeedUnitEdge.b());
        }
        jsonGenerator.a("disallow_first_position", graphQLFeedUnitEdge.l());
        if (graphQLFeedUnitEdge.k() != null) {
            jsonGenerator.a("features_meta", graphQLFeedUnitEdge.k());
        }
        if (graphQLFeedUnitEdge.n() != null) {
            jsonGenerator.a("node");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLFeedUnitEdge.n());
        }
        jsonGenerator.a("ranking_weight", graphQLFeedUnitEdge.X_());
        if (graphQLFeedUnitEdge.d() != null) {
            jsonGenerator.a("sort_key", graphQLFeedUnitEdge.d());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
