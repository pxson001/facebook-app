package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: invite_existing_user */
public final class GraphQLEmotionalAnalysisItemsConnection__JsonHelper {
    public static GraphQLEmotionalAnalysisItemsConnection m7023a(JsonParser jsonParser) {
        GraphQLEmotionalAnalysisItemsConnection graphQLEmotionalAnalysisItemsConnection = new GraphQLEmotionalAnalysisItemsConnection();
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
                        GraphQLEmotionalAnalysisItemsEdge a = GraphQLEmotionalAnalysisItemsEdge__JsonHelper.m7032a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLEmotionalAnalysisItemsConnection.f3528d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLEmotionalAnalysisItemsConnection, "edges", graphQLEmotionalAnalysisItemsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEmotionalAnalysisItemsConnection;
    }

    public static void m7024a(JsonGenerator jsonGenerator, GraphQLEmotionalAnalysisItemsConnection graphQLEmotionalAnalysisItemsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLEmotionalAnalysisItemsConnection.m7020a() != null) {
            jsonGenerator.d();
            for (GraphQLEmotionalAnalysisItemsEdge graphQLEmotionalAnalysisItemsEdge : graphQLEmotionalAnalysisItemsConnection.m7020a()) {
                if (graphQLEmotionalAnalysisItemsEdge != null) {
                    GraphQLEmotionalAnalysisItemsEdge__JsonHelper.m7033a(jsonGenerator, graphQLEmotionalAnalysisItemsEdge, true);
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
