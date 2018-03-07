package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_group_admin */
public final class GraphQLBudgetRecommendationsEdge__JsonHelper {
    public static GraphQLBudgetRecommendationsEdge m6699a(JsonParser jsonParser) {
        GraphQLBudgetRecommendationsEdge graphQLBudgetRecommendationsEdge = new GraphQLBudgetRecommendationsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("is_default".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLBudgetRecommendationsEdge.f3407d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLBudgetRecommendationsEdge, "is_default", graphQLBudgetRecommendationsEdge.a_, 0, false);
                i2 = 1;
            } else if ("node".equals(i)) {
                GraphQLBudgetRecommendationData graphQLBudgetRecommendationData;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLBudgetRecommendationData = null;
                } else {
                    graphQLBudgetRecommendationData = GraphQLBudgetRecommendationData__JsonHelper.m6676a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLBudgetRecommendationsEdge.f3408e = graphQLBudgetRecommendationData;
                FieldAccessQueryTracker.a(jsonParser, graphQLBudgetRecommendationsEdge, "node", graphQLBudgetRecommendationsEdge.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLBudgetRecommendationsEdge;
    }

    public static void m6700a(JsonGenerator jsonGenerator, GraphQLBudgetRecommendationsEdge graphQLBudgetRecommendationsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("is_default", graphQLBudgetRecommendationsEdge.m6695a());
        if (graphQLBudgetRecommendationsEdge.m6696j() != null) {
            jsonGenerator.a("node");
            GraphQLBudgetRecommendationData__JsonHelper.m6677a(jsonGenerator, graphQLBudgetRecommendationsEdge.m6696j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
