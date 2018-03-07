package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: has_inner_borders */
public final class GraphQLFriendsEdge__JsonHelper {
    public static GraphQLFriendsEdge m7619a(JsonParser jsonParser) {
        GraphQLFriendsEdge graphQLFriendsEdge = new GraphQLFriendsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLUser graphQLUser = null;
            int i2;
            if ("cursor".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLFriendsEdge.f3794d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsEdge, "cursor", graphQLFriendsEdge.a_, 0, false);
                i2 = 1;
            } else if ("node".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLUser = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLFriendsEdge.f3795e = graphQLUser;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsEdge, "node", graphQLFriendsEdge.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLFriendsEdge;
    }

    public static void m7620a(JsonGenerator jsonGenerator, GraphQLFriendsEdge graphQLFriendsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFriendsEdge.m7615a() != null) {
            jsonGenerator.a("cursor", graphQLFriendsEdge.m7615a());
        }
        if (graphQLFriendsEdge.m7616j() != null) {
            jsonGenerator.a("node");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLFriendsEdge.m7616j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
