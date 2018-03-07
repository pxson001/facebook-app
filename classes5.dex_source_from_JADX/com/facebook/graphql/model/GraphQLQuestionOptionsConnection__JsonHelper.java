package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIEW_PLACE_LIST */
public final class GraphQLQuestionOptionsConnection__JsonHelper {
    public static GraphQLQuestionOptionsConnection m21191a(JsonParser jsonParser) {
        GraphQLQuestionOptionsConnection graphQLQuestionOptionsConnection = new GraphQLQuestionOptionsConnection();
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
                        GraphQLQuestionOption a = GraphQLQuestionOption__JsonHelper.m21182a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLQuestionOptionsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOptionsConnection, "nodes", graphQLQuestionOptionsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLQuestionOptionsConnection;
    }

    public static void m21192a(JsonGenerator jsonGenerator, GraphQLQuestionOptionsConnection graphQLQuestionOptionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLQuestionOptionsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLQuestionOption graphQLQuestionOption : graphQLQuestionOptionsConnection.a()) {
                if (graphQLQuestionOption != null) {
                    GraphQLQuestionOption__JsonHelper.m21183a(jsonGenerator, graphQLQuestionOption, true);
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
