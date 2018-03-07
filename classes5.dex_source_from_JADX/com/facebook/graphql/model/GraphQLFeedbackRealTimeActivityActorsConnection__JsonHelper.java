package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: hide_attachment */
public final class GraphQLFeedbackRealTimeActivityActorsConnection__JsonHelper {
    public static GraphQLFeedbackRealTimeActivityActorsConnection m7499a(JsonParser jsonParser) {
        GraphQLFeedbackRealTimeActivityActorsConnection graphQLFeedbackRealTimeActivityActorsConnection = new GraphQLFeedbackRealTimeActivityActorsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLActor a = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLFeedbackRealTimeActivityActorsConnection.f3768d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackRealTimeActivityActorsConnection, "nodes", graphQLFeedbackRealTimeActivityActorsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFeedbackRealTimeActivityActorsConnection;
    }

    public static void m7500a(JsonGenerator jsonGenerator, GraphQLFeedbackRealTimeActivityActorsConnection graphQLFeedbackRealTimeActivityActorsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLFeedbackRealTimeActivityActorsConnection.m7496a() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLFeedbackRealTimeActivityActorsConnection.m7496a()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
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
