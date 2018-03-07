package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: fb4a.debug.digraph.enabled */
public final class GraphQLMediaQuestionOptionsConnection__JsonHelper {
    public static GraphQLMediaQuestionOptionsConnection m9049a(JsonParser jsonParser) {
        GraphQLMediaQuestionOptionsConnection graphQLMediaQuestionOptionsConnection = new GraphQLMediaQuestionOptionsConnection();
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
                        GraphQLMediaQuestionOptionsEdge a = GraphQLMediaQuestionOptionsEdge__JsonHelper.m9058a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLMediaQuestionOptionsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestionOptionsConnection, "edges", graphQLMediaQuestionOptionsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLMediaQuestionOptionsConnection;
    }

    public static void m9050a(JsonGenerator jsonGenerator, GraphQLMediaQuestionOptionsConnection graphQLMediaQuestionOptionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLMediaQuestionOptionsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLMediaQuestionOptionsEdge graphQLMediaQuestionOptionsEdge : graphQLMediaQuestionOptionsConnection.a()) {
                if (graphQLMediaQuestionOptionsEdge != null) {
                    GraphQLMediaQuestionOptionsEdge__JsonHelper.m9059a(jsonGenerator, graphQLMediaQuestionOptionsEdge, true);
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
