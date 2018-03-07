package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackTargetType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: exitStateMachine */
public final class GraphQLNegativeFeedbackAction__JsonHelper {
    public static GraphQLNegativeFeedbackAction m9236a(JsonParser jsonParser) {
        GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction = new GraphQLNegativeFeedbackAction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9238a(graphQLNegativeFeedbackAction, i, jsonParser);
            jsonParser.f();
        }
        return graphQLNegativeFeedbackAction;
    }

    private static boolean m9238a(GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("already_completed".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLNegativeFeedbackAction.d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "already_completed", graphQLNegativeFeedbackAction.a_, 0, false);
            return true;
        } else if ("completed_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "completed_subtitle"));
            }
            graphQLNegativeFeedbackAction.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "completed_subtitle", graphQLNegativeFeedbackAction.B_(), 1, true);
            return true;
        } else if ("completed_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "completed_title"));
            }
            graphQLNegativeFeedbackAction.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "completed_title", graphQLNegativeFeedbackAction.B_(), 2, true);
            return true;
        } else if ("confirmation_header".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "confirmation_header"));
            }
            graphQLNegativeFeedbackAction.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "confirmation_header", graphQLNegativeFeedbackAction.B_(), 3, true);
            return true;
        } else if ("confirmation_message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "confirmation_message"));
            }
            graphQLNegativeFeedbackAction.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "confirmation_message", graphQLNegativeFeedbackAction.B_(), 4, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLNegativeFeedbackAction.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "id", graphQLNegativeFeedbackAction.B_(), 5, false);
            return true;
        } else if ("negative_feedback_action_type".equals(str)) {
            graphQLNegativeFeedbackAction.j = GraphQLNegativeFeedbackActionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "negative_feedback_action_type", graphQLNegativeFeedbackAction.B_(), 6, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLNegativeFeedbackAction.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "subtitle", graphQLNegativeFeedbackAction.B_(), 8, true);
            return true;
        } else if ("target_entity".equals(str)) {
            GraphQLProfile a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "target_entity"));
            }
            graphQLNegativeFeedbackAction.l = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "target_entity", graphQLNegativeFeedbackAction.B_(), 9, true);
            return true;
        } else if ("target_entity_type".equals(str)) {
            graphQLNegativeFeedbackAction.m = GraphQLNegativeFeedbackTargetType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "target_entity_type", graphQLNegativeFeedbackAction.B_(), 10, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLNegativeFeedbackAction.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "title", graphQLNegativeFeedbackAction.B_(), 11, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLNegativeFeedbackAction.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "titleForSummary", graphQLNegativeFeedbackAction.B_(), 12, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLNegativeFeedbackAction.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackAction, "url", graphQLNegativeFeedbackAction.B_(), 13, false);
            return true;
        }
    }

    public static void m9237a(JsonGenerator jsonGenerator, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("already_completed", graphQLNegativeFeedbackAction.j());
        if (graphQLNegativeFeedbackAction.k() != null) {
            jsonGenerator.a("completed_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNegativeFeedbackAction.k(), true);
        }
        if (graphQLNegativeFeedbackAction.l() != null) {
            jsonGenerator.a("completed_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNegativeFeedbackAction.l(), true);
        }
        if (graphQLNegativeFeedbackAction.m() != null) {
            jsonGenerator.a("confirmation_header");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNegativeFeedbackAction.m(), true);
        }
        if (graphQLNegativeFeedbackAction.n() != null) {
            jsonGenerator.a("confirmation_message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNegativeFeedbackAction.n(), true);
        }
        if (graphQLNegativeFeedbackAction.o() != null) {
            jsonGenerator.a("id", graphQLNegativeFeedbackAction.o());
        }
        if (graphQLNegativeFeedbackAction.b() != null) {
            jsonGenerator.a("negative_feedback_action_type", graphQLNegativeFeedbackAction.b().toString());
        }
        if (graphQLNegativeFeedbackAction.p() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNegativeFeedbackAction.p(), true);
        }
        if (graphQLNegativeFeedbackAction.q() != null) {
            jsonGenerator.a("target_entity");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLNegativeFeedbackAction.q(), true);
        }
        if (graphQLNegativeFeedbackAction.r() != null) {
            jsonGenerator.a("target_entity_type", graphQLNegativeFeedbackAction.r().toString());
        }
        if (graphQLNegativeFeedbackAction.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNegativeFeedbackAction.s(), true);
        }
        if (graphQLNegativeFeedbackAction.t() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNegativeFeedbackAction.t(), true);
        }
        if (graphQLNegativeFeedbackAction.u() != null) {
            jsonGenerator.a("url", graphQLNegativeFeedbackAction.u());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
