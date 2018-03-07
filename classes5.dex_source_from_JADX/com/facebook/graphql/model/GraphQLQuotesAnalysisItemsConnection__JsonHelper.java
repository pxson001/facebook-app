package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIEW_EVENT_POSTS */
public final class GraphQLQuotesAnalysisItemsConnection__JsonHelper {
    public static GraphQLQuotesAnalysisItemsConnection m21290a(JsonParser jsonParser) {
        GraphQLQuotesAnalysisItemsConnection graphQLQuotesAnalysisItemsConnection = new GraphQLQuotesAnalysisItemsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLQuotesAnalysisItemsEdge a = GraphQLQuotesAnalysisItemsEdge__JsonHelper.m21299a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLQuotesAnalysisItemsConnection.f12879d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuotesAnalysisItemsConnection, "edges", graphQLQuotesAnalysisItemsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLQuotesAnalysisItemsConnection;
    }

    public static void m21291a(JsonGenerator jsonGenerator, GraphQLQuotesAnalysisItemsConnection graphQLQuotesAnalysisItemsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLQuotesAnalysisItemsConnection.m21287a() != null) {
            jsonGenerator.d();
            for (GraphQLQuotesAnalysisItemsEdge graphQLQuotesAnalysisItemsEdge : graphQLQuotesAnalysisItemsConnection.m21287a()) {
                if (graphQLQuotesAnalysisItemsEdge != null) {
                    GraphQLQuotesAnalysisItemsEdge__JsonHelper.m21300a(jsonGenerator, graphQLQuotesAnalysisItemsEdge, true);
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
