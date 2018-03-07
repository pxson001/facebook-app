package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WALLPAPER */
public final class GraphQLPlacesTileResultsEdge__JsonHelper {
    public static GraphQLPlacesTileResultsEdge m20942a(JsonParser jsonParser) {
        GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge = new GraphQLPlacesTileResultsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20944a(graphQLPlacesTileResultsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPlacesTileResultsEdge;
    }

    private static boolean m20944a(GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("node".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLPlacesTileResultsEdge.f12671d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlacesTileResultsEdge, "node", graphQLPlacesTileResultsEdge.a_, 0, true);
            return true;
        } else if ("result_decoration".equals(str)) {
            GraphQLGraphSearchResultDecoration a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGraphSearchResultDecoration__JsonHelper.m8283a(FieldAccessQueryTracker.a(jsonParser, "result_decoration"));
            }
            graphQLPlacesTileResultsEdge.f12672e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlacesTileResultsEdge, "result_decoration", graphQLPlacesTileResultsEdge.B_(), 1, true);
            return true;
        } else if ("search_score".equals(str)) {
            graphQLPlacesTileResultsEdge.f12673f = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlacesTileResultsEdge, "search_score", graphQLPlacesTileResultsEdge.B_(), 2, false);
            return true;
        } else if (!"social_context".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLPlacesTileResultsEdge.f12674g = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlacesTileResultsEdge, "social_context", graphQLPlacesTileResultsEdge.B_(), 3, true);
            return true;
        }
    }

    public static void m20943a(JsonGenerator jsonGenerator, GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPlacesTileResultsEdge.m20934a() != null) {
            jsonGenerator.a("node");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPlacesTileResultsEdge.m20934a(), true);
        }
        if (graphQLPlacesTileResultsEdge.m20937j() != null) {
            jsonGenerator.a("result_decoration");
            GraphQLGraphSearchResultDecoration__JsonHelper.m8284a(jsonGenerator, graphQLPlacesTileResultsEdge.m20937j(), true);
        }
        jsonGenerator.a("search_score", graphQLPlacesTileResultsEdge.m20938k());
        if (graphQLPlacesTileResultsEdge.m20939l() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPlacesTileResultsEdge.m20939l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
