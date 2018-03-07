package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: intern_profile */
public final class GraphQLEmotionalAnalysis__JsonHelper {
    public static GraphQLEmotionalAnalysis m7035a(JsonParser jsonParser) {
        GraphQLEmotionalAnalysis graphQLEmotionalAnalysis = new GraphQLEmotionalAnalysis();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("emotions".equals(i)) {
                GraphQLEmotionalAnalysisItemsConnection graphQLEmotionalAnalysisItemsConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLEmotionalAnalysisItemsConnection = null;
                } else {
                    graphQLEmotionalAnalysisItemsConnection = GraphQLEmotionalAnalysisItemsConnection__JsonHelper.m7023a(FieldAccessQueryTracker.a(jsonParser, "emotions"));
                }
                graphQLEmotionalAnalysis.d = graphQLEmotionalAnalysisItemsConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLEmotionalAnalysis, "emotions", graphQLEmotionalAnalysis.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEmotionalAnalysis;
    }

    public static void m7036a(JsonGenerator jsonGenerator, GraphQLEmotionalAnalysis graphQLEmotionalAnalysis, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEmotionalAnalysis.a() != null) {
            jsonGenerator.a("emotions");
            GraphQLEmotionalAnalysisItemsConnection__JsonHelper.m7024a(jsonGenerator, graphQLEmotionalAnalysis.a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
