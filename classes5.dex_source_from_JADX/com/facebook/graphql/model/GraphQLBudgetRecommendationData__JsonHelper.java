package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_indeterminate */
public final class GraphQLBudgetRecommendationData__JsonHelper {
    public static GraphQLBudgetRecommendationData m6676a(JsonParser jsonParser) {
        GraphQLBudgetRecommendationData graphQLBudgetRecommendationData = new GraphQLBudgetRecommendationData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6678a(graphQLBudgetRecommendationData, i, jsonParser);
            jsonParser.f();
        }
        return graphQLBudgetRecommendationData;
    }

    private static boolean m6678a(GraphQLBudgetRecommendationData graphQLBudgetRecommendationData, String str, JsonParser jsonParser) {
        if ("amount_offset".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLBudgetRecommendationData.f3402d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLBudgetRecommendationData, "amount_offset", graphQLBudgetRecommendationData.a_, 0, false);
            return true;
        } else if ("budget".equals(str)) {
            graphQLBudgetRecommendationData.f3403e = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "budget"));
            FieldAccessQueryTracker.a(jsonParser, graphQLBudgetRecommendationData, "budget", graphQLBudgetRecommendationData.B_(), 1, true);
            return true;
        } else if (!"estimated_reach".equals(str)) {
            return false;
        } else {
            graphQLBudgetRecommendationData.f3404f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLBudgetRecommendationData, "estimated_reach", graphQLBudgetRecommendationData.B_(), 2, false);
            return true;
        }
    }

    public static void m6677a(JsonGenerator jsonGenerator, GraphQLBudgetRecommendationData graphQLBudgetRecommendationData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("amount_offset", graphQLBudgetRecommendationData.m6668a());
        if (graphQLBudgetRecommendationData.m6672j() != null) {
            jsonGenerator.a("budget");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLBudgetRecommendationData.m6672j(), true);
        }
        jsonGenerator.a("estimated_reach", graphQLBudgetRecommendationData.m6673k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
