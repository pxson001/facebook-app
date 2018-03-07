package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: is_highlighted */
public final class GraphQLBudgetRecommendationsConnection__JsonHelper {
    public static GraphQLBudgetRecommendationsConnection m6688a(JsonParser jsonParser) {
        GraphQLBudgetRecommendationsConnection graphQLBudgetRecommendationsConnection = new GraphQLBudgetRecommendationsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLBudgetRecommendationsConnection.f3405d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLBudgetRecommendationsConnection, "count", graphQLBudgetRecommendationsConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLBudgetRecommendationsEdge a = GraphQLBudgetRecommendationsEdge__JsonHelper.m6699a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLBudgetRecommendationsConnection.f3406e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLBudgetRecommendationsConnection, "edges", graphQLBudgetRecommendationsConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLBudgetRecommendationsConnection;
    }

    public static void m6689a(JsonGenerator jsonGenerator, GraphQLBudgetRecommendationsConnection graphQLBudgetRecommendationsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLBudgetRecommendationsConnection.m6681a());
        jsonGenerator.a("edges");
        if (graphQLBudgetRecommendationsConnection.m6685j() != null) {
            jsonGenerator.d();
            for (GraphQLBudgetRecommendationsEdge graphQLBudgetRecommendationsEdge : graphQLBudgetRecommendationsConnection.m6685j()) {
                if (graphQLBudgetRecommendationsEdge != null) {
                    GraphQLBudgetRecommendationsEdge__JsonHelper.m6700a(jsonGenerator, graphQLBudgetRecommendationsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
