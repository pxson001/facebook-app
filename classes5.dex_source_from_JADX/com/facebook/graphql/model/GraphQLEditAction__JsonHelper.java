package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ios_page_edit_action_button */
public final class GraphQLEditAction__JsonHelper {
    public static GraphQLEditAction m6960a(JsonParser jsonParser) {
        GraphQLEditAction graphQLEditAction = new GraphQLEditAction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6962a(graphQLEditAction, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEditAction;
    }

    private static boolean m6962a(GraphQLEditAction graphQLEditAction, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEditAction.d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEditAction, "id", graphQLEditAction.a_, 0, false);
            return true;
        } else if ("message".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLEditAction.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEditAction, "message", graphQLEditAction.B_(), 1, true);
            return true;
        } else if ("time".equals(str)) {
            graphQLEditAction.f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLEditAction, "time", graphQLEditAction.B_(), 2, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEditAction.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEditAction, "url", graphQLEditAction.B_(), 3, false);
            return true;
        }
    }

    public static void m6961a(JsonGenerator jsonGenerator, GraphQLEditAction graphQLEditAction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEditAction.j() != null) {
            jsonGenerator.a("id", graphQLEditAction.j());
        }
        if (graphQLEditAction.k() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEditAction.k(), true);
        }
        jsonGenerator.a("time", graphQLEditAction.l());
        if (graphQLEditAction.m() != null) {
            jsonGenerator.a("url", graphQLEditAction.m());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
