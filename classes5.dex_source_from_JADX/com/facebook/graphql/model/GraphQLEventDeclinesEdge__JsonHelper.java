package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: initial_view_vertical_fov_degrees */
public final class GraphQLEventDeclinesEdge__JsonHelper {
    public static GraphQLEventDeclinesEdge m7183a(JsonParser jsonParser) {
        GraphQLEventDeclinesEdge graphQLEventDeclinesEdge = new GraphQLEventDeclinesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7185a(graphQLEventDeclinesEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventDeclinesEdge;
    }

    private static boolean m7185a(GraphQLEventDeclinesEdge graphQLEventDeclinesEdge, String str, JsonParser jsonParser) {
        if ("can_user_edit_rsvp_status_of_guest".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLEventDeclinesEdge.f3629d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesEdge, "can_user_edit_rsvp_status_of_guest", graphQLEventDeclinesEdge.a_, 0, false);
            return true;
        } else if ("node".equals(str)) {
            graphQLEventDeclinesEdge.f3630e = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesEdge, "node", graphQLEventDeclinesEdge.B_(), 1, true);
            return true;
        } else if ("rsvp_time".equals(str)) {
            graphQLEventDeclinesEdge.f3631f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesEdge, "rsvp_time", graphQLEventDeclinesEdge.B_(), 2, false);
            return true;
        } else if (!"seen_state".equals(str)) {
            return false;
        } else {
            graphQLEventDeclinesEdge.f3632g = GraphQLEventSeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesEdge, "seen_state", graphQLEventDeclinesEdge.B_(), 3, false);
            return true;
        }
    }

    public static void m7184a(JsonGenerator jsonGenerator, GraphQLEventDeclinesEdge graphQLEventDeclinesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_user_edit_rsvp_status_of_guest", graphQLEventDeclinesEdge.m7177a());
        if (graphQLEventDeclinesEdge.m7178j() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLEventDeclinesEdge.m7178j(), true);
        }
        jsonGenerator.a("rsvp_time", graphQLEventDeclinesEdge.m7179k());
        if (graphQLEventDeclinesEdge.m7180l() != null) {
            jsonGenerator.a("seen_state", graphQLEventDeclinesEdge.m7180l().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
