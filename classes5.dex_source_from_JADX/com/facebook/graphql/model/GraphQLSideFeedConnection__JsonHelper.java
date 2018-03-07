package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VERSION.txt */
public final class GraphQLSideFeedConnection__JsonHelper {
    public static GraphQLSideFeedConnection m21637a(JsonParser jsonParser) {
        GraphQLSideFeedConnection graphQLSideFeedConnection = new GraphQLSideFeedConnection();
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
                        GraphQLSideFeedEdge a = GraphQLSideFeedEdge__JsonHelper.m21646a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLSideFeedConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSideFeedConnection, "edges", graphQLSideFeedConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSideFeedConnection;
    }

    public static void m21638a(JsonGenerator jsonGenerator, GraphQLSideFeedConnection graphQLSideFeedConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLSideFeedConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLSideFeedEdge graphQLSideFeedEdge : graphQLSideFeedConnection.a()) {
                if (graphQLSideFeedEdge != null) {
                    GraphQLSideFeedEdge__JsonHelper.m21647a(jsonGenerator, graphQLSideFeedEdge, true);
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
