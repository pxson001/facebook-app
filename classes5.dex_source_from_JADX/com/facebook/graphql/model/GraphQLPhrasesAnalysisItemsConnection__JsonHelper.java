package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WELCOME_HOME */
public final class GraphQLPhrasesAnalysisItemsConnection__JsonHelper {
    public static GraphQLPhrasesAnalysisItemsConnection m20816a(JsonParser jsonParser) {
        GraphQLPhrasesAnalysisItemsConnection graphQLPhrasesAnalysisItemsConnection = new GraphQLPhrasesAnalysisItemsConnection();
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
                        GraphQLPhrasesAnalysisItemsEdge a = GraphQLPhrasesAnalysisItemsEdge__JsonHelper.m20825a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLPhrasesAnalysisItemsConnection.f12589d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItemsConnection, "edges", graphQLPhrasesAnalysisItemsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPhrasesAnalysisItemsConnection;
    }

    public static void m20817a(JsonGenerator jsonGenerator, GraphQLPhrasesAnalysisItemsConnection graphQLPhrasesAnalysisItemsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPhrasesAnalysisItemsConnection.m20813a() != null) {
            jsonGenerator.d();
            for (GraphQLPhrasesAnalysisItemsEdge graphQLPhrasesAnalysisItemsEdge : graphQLPhrasesAnalysisItemsConnection.m20813a()) {
                if (graphQLPhrasesAnalysisItemsEdge != null) {
                    GraphQLPhrasesAnalysisItemsEdge__JsonHelper.m20826a(jsonGenerator, graphQLPhrasesAnalysisItemsEdge, true);
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
