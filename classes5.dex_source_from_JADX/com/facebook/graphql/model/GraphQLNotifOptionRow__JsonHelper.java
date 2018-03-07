package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLNotifOptionRenderType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: event_dashboard_celebrations */
public final class GraphQLNotifOptionRow__JsonHelper {
    public static GraphQLNotifOptionRow m9358a(JsonParser jsonParser) {
        GraphQLNotifOptionRow graphQLNotifOptionRow = new GraphQLNotifOptionRow();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9360a(graphQLNotifOptionRow, i, jsonParser);
            jsonParser.f();
        }
        return graphQLNotifOptionRow;
    }

    private static boolean m9360a(GraphQLNotifOptionRow graphQLNotifOptionRow, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        String o;
        if ("client_action".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLNotifOptionRow.f4640d = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRow, "client_action", graphQLNotifOptionRow.a_, 0, false);
            return true;
        } else if ("render_type".equals(str)) {
            graphQLNotifOptionRow.f4641e = GraphQLNotifOptionRenderType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRow, "render_type", graphQLNotifOptionRow.B_(), 2, false);
            return true;
        } else if ("server_action".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLNotifOptionRow.f4642f = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRow, "server_action", graphQLNotifOptionRow.B_(), 3, false);
            return true;
        } else if ("text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "text"));
            }
            graphQLNotifOptionRow.f4643g = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRow, "text", graphQLNotifOptionRow.B_(), 4, true);
            return true;
        } else if ("undo_server_action".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLNotifOptionRow.f4644h = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRow, "undo_server_action", graphQLNotifOptionRow.B_(), 5, false);
            return true;
        } else if (!"undo_text".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "undo_text"));
            }
            graphQLNotifOptionRow.f4645i = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRow, "undo_text", graphQLNotifOptionRow.B_(), 6, true);
            return true;
        }
    }

    public static void m9359a(JsonGenerator jsonGenerator, GraphQLNotifOptionRow graphQLNotifOptionRow, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLNotifOptionRow.m9334a() != null) {
            jsonGenerator.a("client_action", graphQLNotifOptionRow.m9334a());
        }
        if (graphQLNotifOptionRow.m9335j() != null) {
            jsonGenerator.a("render_type", graphQLNotifOptionRow.m9335j().toString());
        }
        if (graphQLNotifOptionRow.m9336k() != null) {
            jsonGenerator.a("server_action", graphQLNotifOptionRow.m9336k());
        }
        if (graphQLNotifOptionRow.m9337l() != null) {
            jsonGenerator.a("text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNotifOptionRow.m9337l(), true);
        }
        if (graphQLNotifOptionRow.m9338m() != null) {
            jsonGenerator.a("undo_server_action", graphQLNotifOptionRow.m9338m());
        }
        if (graphQLNotifOptionRow.m9339n() != null) {
            jsonGenerator.a("undo_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNotifOptionRow.m9339n(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
