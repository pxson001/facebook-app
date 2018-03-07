package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: goodwill_campaign */
public final class GraphQLGoodwillThrowbackDataPointsConnection__JsonHelper {
    public static GraphQLGoodwillThrowbackDataPointsConnection m7940a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackDataPointsConnection graphQLGoodwillThrowbackDataPointsConnection = new GraphQLGoodwillThrowbackDataPointsConnection();
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
                        GraphQLGoodwillThrowbackDataPoint a = GraphQLGoodwillThrowbackDataPoint__JsonHelper.m7934a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLGoodwillThrowbackDataPointsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackDataPointsConnection, "nodes", graphQLGoodwillThrowbackDataPointsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackDataPointsConnection;
    }

    public static void m7941a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackDataPointsConnection graphQLGoodwillThrowbackDataPointsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGoodwillThrowbackDataPointsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint : graphQLGoodwillThrowbackDataPointsConnection.a()) {
                if (graphQLGoodwillThrowbackDataPoint != null) {
                    GraphQLGoodwillThrowbackDataPoint__JsonHelper.m7935a(jsonGenerator, graphQLGoodwillThrowbackDataPoint, true);
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
