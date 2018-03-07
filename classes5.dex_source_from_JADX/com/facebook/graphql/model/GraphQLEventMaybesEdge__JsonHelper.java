package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: inapp_browser_prefetch_type */
public final class GraphQLEventMaybesEdge__JsonHelper {
    public static GraphQLEventMaybesEdge m7237a(JsonParser jsonParser) {
        GraphQLEventMaybesEdge graphQLEventMaybesEdge = new GraphQLEventMaybesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7239a(graphQLEventMaybesEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventMaybesEdge;
    }

    private static boolean m7239a(GraphQLEventMaybesEdge graphQLEventMaybesEdge, String str, JsonParser jsonParser) {
        if ("node".equals(str)) {
            GraphQLActor graphQLActor;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLActor = null;
            } else {
                graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLEventMaybesEdge.f3644d = graphQLActor;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesEdge, "node", graphQLEventMaybesEdge.a_, 0, true);
            return true;
        } else if ("rsvp_time".equals(str)) {
            graphQLEventMaybesEdge.f3645e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesEdge, "rsvp_time", graphQLEventMaybesEdge.B_(), 1, false);
            return true;
        } else if (!"seen_state".equals(str)) {
            return false;
        } else {
            graphQLEventMaybesEdge.f3646f = GraphQLEventSeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesEdge, "seen_state", graphQLEventMaybesEdge.B_(), 2, false);
            return true;
        }
    }

    public static void m7238a(JsonGenerator jsonGenerator, GraphQLEventMaybesEdge graphQLEventMaybesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventMaybesEdge.m7230a() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLEventMaybesEdge.m7230a(), true);
        }
        jsonGenerator.a("rsvp_time", graphQLEventMaybesEdge.m7233j());
        if (graphQLEventMaybesEdge.m7234k() != null) {
            jsonGenerator.a("seen_state", graphQLEventMaybesEdge.m7234k().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
