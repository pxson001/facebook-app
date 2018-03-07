package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: implicit_place */
public final class GraphQLEventMembersEdge__JsonHelper {
    public static GraphQLEventMembersEdge m7258a(JsonParser jsonParser) {
        GraphQLEventMembersEdge graphQLEventMembersEdge = new GraphQLEventMembersEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7260a(graphQLEventMembersEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventMembersEdge;
    }

    private static boolean m7260a(GraphQLEventMembersEdge graphQLEventMembersEdge, String str, JsonParser jsonParser) {
        if ("node".equals(str)) {
            GraphQLActor graphQLActor;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLActor = null;
            } else {
                graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLEventMembersEdge.f3656d = graphQLActor;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersEdge, "node", graphQLEventMembersEdge.a_, 0, true);
            return true;
        } else if ("rsvp_time".equals(str)) {
            graphQLEventMembersEdge.f3657e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersEdge, "rsvp_time", graphQLEventMembersEdge.B_(), 1, false);
            return true;
        } else if (!"seen_state".equals(str)) {
            return false;
        } else {
            graphQLEventMembersEdge.f3658f = GraphQLEventSeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersEdge, "seen_state", graphQLEventMembersEdge.B_(), 2, false);
            return true;
        }
    }

    public static void m7259a(JsonGenerator jsonGenerator, GraphQLEventMembersEdge graphQLEventMembersEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventMembersEdge.m7251a() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLEventMembersEdge.m7251a(), true);
        }
        jsonGenerator.a("rsvp_time", graphQLEventMembersEdge.m7254j());
        if (graphQLEventMembersEdge.m7255k() != null) {
            jsonGenerator.a("seen_state", graphQLEventMembersEdge.m7255k().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
