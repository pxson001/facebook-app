package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: has */
public final class GraphQLFriendsWhoLikeConnection__JsonHelper {
    public static GraphQLFriendsWhoLikeConnection m7641a(JsonParser jsonParser) {
        GraphQLFriendsWhoLikeConnection graphQLFriendsWhoLikeConnection = new GraphQLFriendsWhoLikeConnection();
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
                graphQLFriendsWhoLikeConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsWhoLikeConnection, "count", graphQLFriendsWhoLikeConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUser a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLFriendsWhoLikeConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsWhoLikeConnection, "nodes", graphQLFriendsWhoLikeConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLFriendsWhoLikeConnection;
    }

    public static void m7642a(JsonGenerator jsonGenerator, GraphQLFriendsWhoLikeConnection graphQLFriendsWhoLikeConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLFriendsWhoLikeConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLFriendsWhoLikeConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLFriendsWhoLikeConnection.j()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
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
