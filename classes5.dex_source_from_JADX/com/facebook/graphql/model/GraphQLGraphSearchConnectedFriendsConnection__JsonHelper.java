package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: getFileDescriptor */
public final class GraphQLGraphSearchConnectedFriendsConnection__JsonHelper {
    public static GraphQLGraphSearchConnectedFriendsConnection m8146a(JsonParser jsonParser) {
        GraphQLGraphSearchConnectedFriendsConnection graphQLGraphSearchConnectedFriendsConnection = new GraphQLGraphSearchConnectedFriendsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLGraphSearchConnectedFriendsConnection.f4047d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchConnectedFriendsConnection, "count", graphQLGraphSearchConnectedFriendsConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLGraphSearchConnectedFriendsEdge a = GraphQLGraphSearchConnectedFriendsEdge__JsonHelper.m8155a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLGraphSearchConnectedFriendsConnection.f4048e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchConnectedFriendsConnection, "edges", graphQLGraphSearchConnectedFriendsConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLGraphSearchConnectedFriendsConnection;
    }

    public static void m8147a(JsonGenerator jsonGenerator, GraphQLGraphSearchConnectedFriendsConnection graphQLGraphSearchConnectedFriendsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLGraphSearchConnectedFriendsConnection.m8139a());
        jsonGenerator.a("edges");
        if (graphQLGraphSearchConnectedFriendsConnection.m8143j() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchConnectedFriendsEdge graphQLGraphSearchConnectedFriendsEdge : graphQLGraphSearchConnectedFriendsConnection.m8143j()) {
                if (graphQLGraphSearchConnectedFriendsEdge != null) {
                    GraphQLGraphSearchConnectedFriendsEdge__JsonHelper.m8156a(jsonGenerator, graphQLGraphSearchConnectedFriendsEdge, true);
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
