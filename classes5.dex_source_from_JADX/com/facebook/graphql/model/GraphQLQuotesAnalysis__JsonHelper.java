package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEWER_VISITATION */
public final class GraphQLQuotesAnalysis__JsonHelper {
    public static GraphQLQuotesAnalysis m21302a(JsonParser jsonParser) {
        GraphQLQuotesAnalysis graphQLQuotesAnalysis = new GraphQLQuotesAnalysis();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("quotes".equals(i)) {
                GraphQLQuotesAnalysisItemsConnection graphQLQuotesAnalysisItemsConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLQuotesAnalysisItemsConnection = null;
                } else {
                    graphQLQuotesAnalysisItemsConnection = GraphQLQuotesAnalysisItemsConnection__JsonHelper.m21290a(FieldAccessQueryTracker.a(jsonParser, "quotes"));
                }
                graphQLQuotesAnalysis.d = graphQLQuotesAnalysisItemsConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuotesAnalysis, "quotes", graphQLQuotesAnalysis.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLQuotesAnalysis;
    }

    public static void m21303a(JsonGenerator jsonGenerator, GraphQLQuotesAnalysis graphQLQuotesAnalysis, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQuotesAnalysis.a() != null) {
            jsonGenerator.a("quotes");
            GraphQLQuotesAnalysisItemsConnection__JsonHelper.m21291a(jsonGenerator, graphQLQuotesAnalysis.a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
