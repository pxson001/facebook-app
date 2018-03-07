package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: internetorg_new_users */
public final class GraphQLEmotionalAnalysisItemsEdge__JsonHelper {
    public static GraphQLEmotionalAnalysisItemsEdge m7032a(JsonParser jsonParser) {
        GraphQLEmotionalAnalysisItemsEdge graphQLEmotionalAnalysisItemsEdge = new GraphQLEmotionalAnalysisItemsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLEmotionalAnalysisItem graphQLEmotionalAnalysisItem;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLEmotionalAnalysisItem = null;
                } else {
                    graphQLEmotionalAnalysisItem = GraphQLEmotionalAnalysisItem__JsonHelper.m7014a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLEmotionalAnalysisItemsEdge.f3529d = graphQLEmotionalAnalysisItem;
                FieldAccessQueryTracker.a(jsonParser, graphQLEmotionalAnalysisItemsEdge, "node", graphQLEmotionalAnalysisItemsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEmotionalAnalysisItemsEdge;
    }

    public static void m7033a(JsonGenerator jsonGenerator, GraphQLEmotionalAnalysisItemsEdge graphQLEmotionalAnalysisItemsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEmotionalAnalysisItemsEdge.m7028a() != null) {
            jsonGenerator.a("node");
            GraphQLEmotionalAnalysisItem__JsonHelper.m7015a(jsonGenerator, graphQLEmotionalAnalysisItemsEdge.m7028a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
