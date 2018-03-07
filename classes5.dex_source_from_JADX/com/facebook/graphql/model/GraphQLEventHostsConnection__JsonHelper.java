package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: initial_view_heading_degrees */
public final class GraphQLEventHostsConnection__JsonHelper {
    public static GraphQLEventHostsConnection m7191a(JsonParser jsonParser) {
        GraphQLEventHostsConnection graphQLEventHostsConnection = new GraphQLEventHostsConnection();
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
                        GraphQLEventHostsEdge a = GraphQLEventHostsEdge__JsonHelper.m7200a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLEventHostsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventHostsConnection, "edges", graphQLEventHostsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEventHostsConnection;
    }

    public static void m7192a(JsonGenerator jsonGenerator, GraphQLEventHostsConnection graphQLEventHostsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLEventHostsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLEventHostsEdge graphQLEventHostsEdge : graphQLEventHostsConnection.a()) {
                if (graphQLEventHostsEdge != null) {
                    GraphQLEventHostsEdge__JsonHelper.m7201a(jsonGenerator, graphQLEventHostsEdge, true);
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
