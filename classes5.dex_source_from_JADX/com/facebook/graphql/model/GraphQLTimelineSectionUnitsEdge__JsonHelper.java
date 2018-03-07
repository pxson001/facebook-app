package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNDO_LINK */
public final class GraphQLTimelineSectionUnitsEdge__JsonHelper {
    public static GraphQLTimelineSectionUnitsEdge m22214a(JsonParser jsonParser) {
        GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge = new GraphQLTimelineSectionUnitsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22216a(graphQLTimelineSectionUnitsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTimelineSectionUnitsEdge;
    }

    private static boolean m22216a(GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("cursor".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineSectionUnitsEdge.f13347d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSectionUnitsEdge, "cursor", graphQLTimelineSectionUnitsEdge.a_, 0, false);
            return true;
        } else if ("node".equals(str)) {
            FeedUnit a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLTimelineSectionUnitsEdge.f13348e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSectionUnitsEdge, "node", graphQLTimelineSectionUnitsEdge.B_(), 1, true);
            return true;
        } else if (!"sort_key".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineSectionUnitsEdge.f13349f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSectionUnitsEdge, "sort_key", graphQLTimelineSectionUnitsEdge.B_(), 2, false);
            return true;
        }
    }

    public static void m22215a(JsonGenerator jsonGenerator, GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTimelineSectionUnitsEdge.m22209a() != null) {
            jsonGenerator.a("cursor", graphQLTimelineSectionUnitsEdge.m22209a());
        }
        if (graphQLTimelineSectionUnitsEdge.m22210j() != null) {
            jsonGenerator.a("node");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLTimelineSectionUnitsEdge.m22210j());
        }
        if (graphQLTimelineSectionUnitsEdge.m22211k() != null) {
            jsonGenerator.a("sort_key", graphQLTimelineSectionUnitsEdge.m22211k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
