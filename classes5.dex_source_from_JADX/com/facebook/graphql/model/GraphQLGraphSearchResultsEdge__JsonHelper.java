package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: full_price */
public final class GraphQLGraphSearchResultsEdge__JsonHelper {
    public static GraphQLGraphSearchResultsEdge m8309a(JsonParser jsonParser) {
        GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge = new GraphQLGraphSearchResultsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8311a(graphQLGraphSearchResultsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGraphSearchResultsEdge;
    }

    private static boolean m8311a(GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("cursor".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchResultsEdge.f4118d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsEdge, "cursor", graphQLGraphSearchResultsEdge.a_, 0, false);
            return true;
        } else if ("node".equals(str)) {
            GraphQLNode a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLGraphSearchResultsEdge.f4119e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsEdge, "node", graphQLGraphSearchResultsEdge.B_(), 1, true);
            return true;
        } else if ("result_decoration".equals(str)) {
            GraphQLGraphSearchResultDecoration a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGraphSearchResultDecoration__JsonHelper.m8283a(FieldAccessQueryTracker.a(jsonParser, "result_decoration"));
            }
            graphQLGraphSearchResultsEdge.f4120f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsEdge, "result_decoration", graphQLGraphSearchResultsEdge.B_(), 2, true);
            return true;
        } else if (!"sort_key".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchResultsEdge.f4121g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsEdge, "sort_key", graphQLGraphSearchResultsEdge.B_(), 3, false);
            return true;
        }
    }

    public static void m8310a(JsonGenerator jsonGenerator, GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchResultsEdge.m8303a() != null) {
            jsonGenerator.a("cursor", graphQLGraphSearchResultsEdge.m8303a());
        }
        if (graphQLGraphSearchResultsEdge.m8304j() != null) {
            jsonGenerator.a("node");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLGraphSearchResultsEdge.m8304j(), true);
        }
        if (graphQLGraphSearchResultsEdge.m8305k() != null) {
            jsonGenerator.a("result_decoration");
            GraphQLGraphSearchResultDecoration__JsonHelper.m8284a(jsonGenerator, graphQLGraphSearchResultsEdge.m8305k(), true);
        }
        if (graphQLGraphSearchResultsEdge.m8306l() != null) {
            jsonGenerator.a("sort_key", graphQLGraphSearchResultsEdge.m8306l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
