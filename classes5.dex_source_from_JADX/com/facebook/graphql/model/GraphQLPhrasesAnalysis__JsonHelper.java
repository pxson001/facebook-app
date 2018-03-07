package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WEB_VIEW */
public final class GraphQLPhrasesAnalysis__JsonHelper {
    public static GraphQLPhrasesAnalysis m20828a(JsonParser jsonParser) {
        GraphQLPhrasesAnalysis graphQLPhrasesAnalysis = new GraphQLPhrasesAnalysis();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("phrases".equals(i)) {
                GraphQLPhrasesAnalysisItemsConnection graphQLPhrasesAnalysisItemsConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhrasesAnalysisItemsConnection = null;
                } else {
                    graphQLPhrasesAnalysisItemsConnection = GraphQLPhrasesAnalysisItemsConnection__JsonHelper.m20816a(FieldAccessQueryTracker.a(jsonParser, "phrases"));
                }
                graphQLPhrasesAnalysis.d = graphQLPhrasesAnalysisItemsConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysis, "phrases", graphQLPhrasesAnalysis.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPhrasesAnalysis;
    }

    public static void m20829a(JsonGenerator jsonGenerator, GraphQLPhrasesAnalysis graphQLPhrasesAnalysis, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPhrasesAnalysis.a() != null) {
            jsonGenerator.a("phrases");
            GraphQLPhrasesAnalysisItemsConnection__JsonHelper.m20817a(jsonGenerator, graphQLPhrasesAnalysis.a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
