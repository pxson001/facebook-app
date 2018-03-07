package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: everyone */
public final class GraphQLNegativeFeedbackActionsConnection__JsonHelper {
    public static GraphQLNegativeFeedbackActionsConnection m9243a(JsonParser jsonParser) {
        GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = new GraphQLNegativeFeedbackActionsConnection();
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
                        GraphQLNegativeFeedbackActionsEdge a = GraphQLNegativeFeedbackActionsEdge__JsonHelper.m9249a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLNegativeFeedbackActionsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackActionsConnection, "edges", graphQLNegativeFeedbackActionsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLNegativeFeedbackActionsConnection;
    }

    public static void m9244a(JsonGenerator jsonGenerator, GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLNegativeFeedbackActionsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge : graphQLNegativeFeedbackActionsConnection.a()) {
                if (graphQLNegativeFeedbackActionsEdge != null) {
                    GraphQLNegativeFeedbackActionsEdge__JsonHelper.m9250a(jsonGenerator, graphQLNegativeFeedbackActionsEdge, true);
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
