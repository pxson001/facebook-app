package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VERTEX_GEAR_REPORT_PAGE */
public final class GraphQLSearchSuggestionsEdge__JsonHelper {
    public static GraphQLSearchSuggestionsEdge m21626a(JsonParser jsonParser) {
        GraphQLSearchSuggestionsEdge graphQLSearchSuggestionsEdge = new GraphQLSearchSuggestionsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21628a(graphQLSearchSuggestionsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSearchSuggestionsEdge;
    }

    private static boolean m21628a(GraphQLSearchSuggestionsEdge graphQLSearchSuggestionsEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("category".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSearchSuggestionsEdge.f13017d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionsEdge, "category", graphQLSearchSuggestionsEdge.a_, 0, false);
            return true;
        } else if ("node".equals(str)) {
            GraphQLSearchSuggestionUnit a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLSearchSuggestionUnit__JsonHelper.m21608a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLSearchSuggestionsEdge.f13018e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionsEdge, "node", graphQLSearchSuggestionsEdge.B_(), 1, true);
            return true;
        } else if (!"subtext".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSearchSuggestionsEdge.f13019f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionsEdge, "subtext", graphQLSearchSuggestionsEdge.B_(), 2, false);
            return true;
        }
    }

    public static void m21627a(JsonGenerator jsonGenerator, GraphQLSearchSuggestionsEdge graphQLSearchSuggestionsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSearchSuggestionsEdge.m21621a() != null) {
            jsonGenerator.a("category", graphQLSearchSuggestionsEdge.m21621a());
        }
        if (graphQLSearchSuggestionsEdge.m21622j() != null) {
            jsonGenerator.a("node");
            GraphQLSearchSuggestionUnit__JsonHelper.m21609a(jsonGenerator, graphQLSearchSuggestionsEdge.m21622j(), true);
        }
        if (graphQLSearchSuggestionsEdge.m21623k() != null) {
            jsonGenerator.a("subtext", graphQLSearchSuggestionsEdge.m21623k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
