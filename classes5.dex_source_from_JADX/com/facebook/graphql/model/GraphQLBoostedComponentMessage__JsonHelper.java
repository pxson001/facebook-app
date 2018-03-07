package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBoostedComponentMessageType;
import com.facebook.graphql.enums.GraphQLBoostedComponentSpecElement;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_media_local */
public final class GraphQLBoostedComponentMessage__JsonHelper {
    public static GraphQLBoostedComponentMessage m6659a(JsonParser jsonParser) {
        GraphQLBoostedComponentMessage graphQLBoostedComponentMessage = new GraphQLBoostedComponentMessage();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6661a(graphQLBoostedComponentMessage, i, jsonParser);
            jsonParser.f();
        }
        return graphQLBoostedComponentMessage;
    }

    private static boolean m6661a(GraphQLBoostedComponentMessage graphQLBoostedComponentMessage, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("action".equals(str)) {
            GraphQLAYMTNativeMobileAction a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAYMTNativeMobileAction__JsonHelper.m6365a(FieldAccessQueryTracker.a(jsonParser, "action"));
            }
            graphQLBoostedComponentMessage.f3396d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentMessage, "action", graphQLBoostedComponentMessage.a_, 0, true);
            return true;
        } else if ("error_for_logging".equals(str)) {
            GraphQLError a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLError__JsonHelper.m7114a(FieldAccessQueryTracker.a(jsonParser, "error_for_logging"));
            }
            graphQLBoostedComponentMessage.f3397e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentMessage, "error_for_logging", graphQLBoostedComponentMessage.B_(), 1, true);
            return true;
        } else if ("message_type".equals(str)) {
            graphQLBoostedComponentMessage.f3398f = GraphQLBoostedComponentMessageType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentMessage, "message_type", graphQLBoostedComponentMessage.B_(), 2, false);
            return true;
        } else if ("spec_element".equals(str)) {
            graphQLBoostedComponentMessage.f3399g = GraphQLBoostedComponentSpecElement.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentMessage, "spec_element", graphQLBoostedComponentMessage.B_(), 3, false);
            return true;
        } else if ("text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "text"));
            }
            graphQLBoostedComponentMessage.f3400h = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentMessage, "text", graphQLBoostedComponentMessage.B_(), 4, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLBoostedComponentMessage.f3401i = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentMessage, "title", graphQLBoostedComponentMessage.B_(), 5, true);
            return true;
        }
    }

    public static void m6660a(JsonGenerator jsonGenerator, GraphQLBoostedComponentMessage graphQLBoostedComponentMessage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLBoostedComponentMessage.m6650a() != null) {
            jsonGenerator.a("action");
            GraphQLAYMTNativeMobileAction__JsonHelper.m6366a(jsonGenerator, graphQLBoostedComponentMessage.m6650a(), true);
        }
        if (graphQLBoostedComponentMessage.m6652j() != null) {
            jsonGenerator.a("error_for_logging");
            GraphQLError__JsonHelper.m7115a(jsonGenerator, graphQLBoostedComponentMessage.m6652j(), true);
        }
        if (graphQLBoostedComponentMessage.m6653k() != null) {
            jsonGenerator.a("message_type", graphQLBoostedComponentMessage.m6653k().toString());
        }
        if (graphQLBoostedComponentMessage.m6654l() != null) {
            jsonGenerator.a("spec_element", graphQLBoostedComponentMessage.m6654l().toString());
        }
        if (graphQLBoostedComponentMessage.m6655m() != null) {
            jsonGenerator.a("text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLBoostedComponentMessage.m6655m(), true);
        }
        if (graphQLBoostedComponentMessage.m6656n() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLBoostedComponentMessage.m6656n(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
