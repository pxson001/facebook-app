package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: gyscTitle */
public final class GraphQLFriendsWhoVisitedEdge__JsonHelper {
    public static GraphQLFriendsWhoVisitedEdge m7656a(JsonParser jsonParser) {
        GraphQLFriendsWhoVisitedEdge graphQLFriendsWhoVisitedEdge = new GraphQLFriendsWhoVisitedEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLUser graphQLUser;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLUser = null;
                } else {
                    graphQLUser = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLFriendsWhoVisitedEdge.f3798d = graphQLUser;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsWhoVisitedEdge, "node", graphQLFriendsWhoVisitedEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFriendsWhoVisitedEdge;
    }

    public static void m7657a(JsonGenerator jsonGenerator, GraphQLFriendsWhoVisitedEdge graphQLFriendsWhoVisitedEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFriendsWhoVisitedEdge.m7652a() != null) {
            jsonGenerator.a("node");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLFriendsWhoVisitedEdge.m7652a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
