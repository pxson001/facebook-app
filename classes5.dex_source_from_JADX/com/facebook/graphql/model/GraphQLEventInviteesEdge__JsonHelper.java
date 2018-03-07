package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ineligible_message */
public final class GraphQLEventInviteesEdge__JsonHelper {
    public static GraphQLEventInviteesEdge m7217a(JsonParser jsonParser) {
        GraphQLEventInviteesEdge graphQLEventInviteesEdge = new GraphQLEventInviteesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7219a(graphQLEventInviteesEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventInviteesEdge;
    }

    private static boolean m7219a(GraphQLEventInviteesEdge graphQLEventInviteesEdge, String str, JsonParser jsonParser) {
        if ("node".equals(str)) {
            GraphQLActor graphQLActor;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLActor = null;
            } else {
                graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLEventInviteesEdge.f3634d = graphQLActor;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesEdge, "node", graphQLEventInviteesEdge.a_, 0, true);
            return true;
        } else if (!"seen_state".equals(str)) {
            return false;
        } else {
            graphQLEventInviteesEdge.f3635e = GraphQLEventSeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesEdge, "seen_state", graphQLEventInviteesEdge.B_(), 1, false);
            return true;
        }
    }

    public static void m7218a(JsonGenerator jsonGenerator, GraphQLEventInviteesEdge graphQLEventInviteesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventInviteesEdge.m7212a() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLEventInviteesEdge.m7212a(), true);
        }
        if (graphQLEventInviteesEdge.m7214j() != null) {
            jsonGenerator.a("seen_state", graphQLEventInviteesEdge.m7214j().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
