package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: imagePreview */
public final class GraphQLEventViewerCapability__JsonHelper {
    public static GraphQLEventViewerCapability m7326a(JsonParser jsonParser) {
        GraphQLEventViewerCapability graphQLEventViewerCapability = new GraphQLEventViewerCapability();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            boolean z;
            if ("can_viewer_decline".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_decline", graphQLEventViewerCapability.a_, 0, false);
            } else if ("can_viewer_delete".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.e = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_delete", graphQLEventViewerCapability.a_, 1, false);
            } else if ("can_viewer_edit".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.f = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_edit", graphQLEventViewerCapability.a_, 2, false);
            } else if ("can_viewer_edit_host".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.g = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_edit_host", graphQLEventViewerCapability.a_, 3, false);
            } else if ("can_viewer_invite".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.h = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_invite", graphQLEventViewerCapability.a_, 4, false);
            } else if ("can_viewer_join".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.i = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_join", graphQLEventViewerCapability.a_, 5, false);
            } else if ("can_viewer_maybe".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.j = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_maybe", graphQLEventViewerCapability.a_, 6, false);
            } else if ("can_viewer_remove_self".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.k = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_remove_self", graphQLEventViewerCapability.a_, 7, false);
            } else if ("can_viewer_report".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.l = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_report", graphQLEventViewerCapability.a_, 8, false);
            } else if ("can_viewer_save".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.m = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_save", graphQLEventViewerCapability.a_, 9, false);
            } else if ("can_viewer_send_message_to_guests".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.n = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_send_message_to_guests", graphQLEventViewerCapability.a_, 10, false);
            } else if ("can_viewer_share".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.o = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_share", graphQLEventViewerCapability.a_, 11, false);
            } else if ("is_viewer_admin".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.p = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "is_viewer_admin", graphQLEventViewerCapability.a_, 12, false);
            } else if ("remaining_invites".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLEventViewerCapability.q = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "remaining_invites", graphQLEventViewerCapability.a_, 13, false);
            } else if ("seen_event".equals(i)) {
                graphQLEventViewerCapability.r = GraphQLEventSeenState.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "seen_event", graphQLEventViewerCapability.a_, 14, false);
            } else if ("can_viewer_promote_as_parent".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEventViewerCapability.s = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventViewerCapability, "can_viewer_promote_as_parent", graphQLEventViewerCapability.a_, 16, false);
            }
            jsonParser.f();
        }
        return graphQLEventViewerCapability;
    }

    public static void m7327a(JsonGenerator jsonGenerator, GraphQLEventViewerCapability graphQLEventViewerCapability, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_viewer_decline", graphQLEventViewerCapability.a());
        jsonGenerator.a("can_viewer_delete", graphQLEventViewerCapability.j());
        jsonGenerator.a("can_viewer_edit", graphQLEventViewerCapability.k());
        jsonGenerator.a("can_viewer_edit_host", graphQLEventViewerCapability.l());
        jsonGenerator.a("can_viewer_invite", graphQLEventViewerCapability.m());
        jsonGenerator.a("can_viewer_join", graphQLEventViewerCapability.n());
        jsonGenerator.a("can_viewer_maybe", graphQLEventViewerCapability.o());
        jsonGenerator.a("can_viewer_remove_self", graphQLEventViewerCapability.p());
        jsonGenerator.a("can_viewer_report", graphQLEventViewerCapability.q());
        jsonGenerator.a("can_viewer_save", graphQLEventViewerCapability.r());
        jsonGenerator.a("can_viewer_send_message_to_guests", graphQLEventViewerCapability.s());
        jsonGenerator.a("can_viewer_share", graphQLEventViewerCapability.t());
        jsonGenerator.a("is_viewer_admin", graphQLEventViewerCapability.u());
        jsonGenerator.a("remaining_invites", graphQLEventViewerCapability.v());
        if (graphQLEventViewerCapability.w() != null) {
            jsonGenerator.a("seen_event", graphQLEventViewerCapability.w().toString());
        }
        jsonGenerator.a("can_viewer_promote_as_parent", graphQLEventViewerCapability.x());
        if (z) {
            jsonGenerator.g();
        }
    }
}
