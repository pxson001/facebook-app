package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: global_sync */
public final class GraphQLGoodwillThrowbackFriendListConnection__JsonHelper {
    public static GraphQLGoodwillThrowbackFriendListConnection m8001a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackFriendListConnection graphQLGoodwillThrowbackFriendListConnection = new GraphQLGoodwillThrowbackFriendListConnection();
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
                        GraphQLGoodwillThrowbackFriendListEdge a = GraphQLGoodwillThrowbackFriendListEdge__JsonHelper.m8011a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLGoodwillThrowbackFriendListConnection.f3989d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendListConnection, "edges", graphQLGoodwillThrowbackFriendListConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackFriendListConnection;
    }

    public static void m8002a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackFriendListConnection graphQLGoodwillThrowbackFriendListConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLGoodwillThrowbackFriendListConnection.m7998a() != null) {
            jsonGenerator.d();
            for (GraphQLGoodwillThrowbackFriendListEdge graphQLGoodwillThrowbackFriendListEdge : graphQLGoodwillThrowbackFriendListConnection.m7998a()) {
                if (graphQLGoodwillThrowbackFriendListEdge != null) {
                    GraphQLGoodwillThrowbackFriendListEdge__JsonHelper.m8012a(jsonGenerator, graphQLGoodwillThrowbackFriendListEdge, true);
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
