package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: getDisplayList */
public final class GraphQLGraphSearchConnectedFriendsEdge__JsonHelper {
    public static GraphQLGraphSearchConnectedFriendsEdge m8155a(JsonParser jsonParser) {
        GraphQLGraphSearchConnectedFriendsEdge graphQLGraphSearchConnectedFriendsEdge = new GraphQLGraphSearchConnectedFriendsEdge();
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
                graphQLGraphSearchConnectedFriendsEdge.f4049d = graphQLUser;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchConnectedFriendsEdge, "node", graphQLGraphSearchConnectedFriendsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGraphSearchConnectedFriendsEdge;
    }

    public static void m8156a(JsonGenerator jsonGenerator, GraphQLGraphSearchConnectedFriendsEdge graphQLGraphSearchConnectedFriendsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchConnectedFriendsEdge.m8151a() != null) {
            jsonGenerator.a("node");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLGraphSearchConnectedFriendsEdge.m8151a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
