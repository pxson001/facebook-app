package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: friend_browser_ff */
public final class GraphQLGroupMessageChattableMembersEdge__JsonHelper {
    public static GraphQLGroupMessageChattableMembersEdge m8484a(JsonParser jsonParser) {
        GraphQLGroupMessageChattableMembersEdge graphQLGroupMessageChattableMembersEdge = new GraphQLGroupMessageChattableMembersEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLActor graphQLActor;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLActor = null;
                } else {
                    graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLGroupMessageChattableMembersEdge.f4207d = graphQLActor;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMessageChattableMembersEdge, "node", graphQLGroupMessageChattableMembersEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGroupMessageChattableMembersEdge;
    }

    public static void m8485a(JsonGenerator jsonGenerator, GraphQLGroupMessageChattableMembersEdge graphQLGroupMessageChattableMembersEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGroupMessageChattableMembersEdge.m8480a() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLGroupMessageChattableMembersEdge.m8480a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
