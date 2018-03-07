package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: friend_browser_s */
public final class GraphQLGroupMessageChattableMembersConnection__JsonHelper {
    public static GraphQLGroupMessageChattableMembersConnection m8475a(JsonParser jsonParser) {
        GraphQLGroupMessageChattableMembersConnection graphQLGroupMessageChattableMembersConnection = new GraphQLGroupMessageChattableMembersConnection();
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
                        GraphQLGroupMessageChattableMembersEdge a = GraphQLGroupMessageChattableMembersEdge__JsonHelper.m8484a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLGroupMessageChattableMembersConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMessageChattableMembersConnection, "edges", graphQLGroupMessageChattableMembersConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGroupMessageChattableMembersConnection;
    }

    public static void m8476a(JsonGenerator jsonGenerator, GraphQLGroupMessageChattableMembersConnection graphQLGroupMessageChattableMembersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLGroupMessageChattableMembersConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLGroupMessageChattableMembersEdge graphQLGroupMessageChattableMembersEdge : graphQLGroupMessageChattableMembersConnection.a()) {
                if (graphQLGroupMessageChattableMembersEdge != null) {
                    GraphQLGroupMessageChattableMembersEdge__JsonHelper.m8485a(jsonGenerator, graphQLGroupMessageChattableMembersEdge, true);
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
