package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WEEK */
public final class GraphQLPhrasesAnalysisItemsEdge__JsonHelper {
    public static GraphQLPhrasesAnalysisItemsEdge m20825a(JsonParser jsonParser) {
        GraphQLPhrasesAnalysisItemsEdge graphQLPhrasesAnalysisItemsEdge = new GraphQLPhrasesAnalysisItemsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhrasesAnalysisItem = null;
                } else {
                    graphQLPhrasesAnalysisItem = GraphQLPhrasesAnalysisItem__JsonHelper.m20807a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLPhrasesAnalysisItemsEdge.f12590d = graphQLPhrasesAnalysisItem;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItemsEdge, "node", graphQLPhrasesAnalysisItemsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPhrasesAnalysisItemsEdge;
    }

    public static void m20826a(JsonGenerator jsonGenerator, GraphQLPhrasesAnalysisItemsEdge graphQLPhrasesAnalysisItemsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPhrasesAnalysisItemsEdge.m20821a() != null) {
            jsonGenerator.a("node");
            GraphQLPhrasesAnalysisItem__JsonHelper.m20808a(jsonGenerator, graphQLPhrasesAnalysisItemsEdge.m20821a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
