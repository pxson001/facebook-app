package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: firstQuestion */
public final class GraphQLInlineActivitiesConnection__JsonHelper {
    public static GraphQLInlineActivitiesConnection m8689a(JsonParser jsonParser) {
        GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = new GraphQLInlineActivitiesConnection();
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
                        GraphQLInlineActivity a = GraphQLInlineActivity__JsonHelper.m8696a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLInlineActivitiesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLInlineActivitiesConnection, "nodes", graphQLInlineActivitiesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLInlineActivitiesConnection;
    }

    public static void m8690a(JsonGenerator jsonGenerator, GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLInlineActivitiesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLInlineActivity graphQLInlineActivity : graphQLInlineActivitiesConnection.a()) {
                if (graphQLInlineActivity != null) {
                    GraphQLInlineActivity__JsonHelper.m8697a(jsonGenerator, graphQLInlineActivity, true);
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
