package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEW_COMMENT_AND_OPEN_COMPOSER */
public final class GraphQLQuotesAnalysisItemsEdge__JsonHelper {
    public static GraphQLQuotesAnalysisItemsEdge m21299a(JsonParser jsonParser) {
        GraphQLQuotesAnalysisItemsEdge graphQLQuotesAnalysisItemsEdge = new GraphQLQuotesAnalysisItemsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLQuotesAnalysisItem graphQLQuotesAnalysisItem;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLQuotesAnalysisItem = null;
                } else {
                    graphQLQuotesAnalysisItem = GraphQLQuotesAnalysisItem__JsonHelper.m21281a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLQuotesAnalysisItemsEdge.f12880d = graphQLQuotesAnalysisItem;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuotesAnalysisItemsEdge, "node", graphQLQuotesAnalysisItemsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLQuotesAnalysisItemsEdge;
    }

    public static void m21300a(JsonGenerator jsonGenerator, GraphQLQuotesAnalysisItemsEdge graphQLQuotesAnalysisItemsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQuotesAnalysisItemsEdge.m21295a() != null) {
            jsonGenerator.a("node");
            GraphQLQuotesAnalysisItem__JsonHelper.m21282a(jsonGenerator, graphQLQuotesAnalysisItemsEdge.m21295a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
