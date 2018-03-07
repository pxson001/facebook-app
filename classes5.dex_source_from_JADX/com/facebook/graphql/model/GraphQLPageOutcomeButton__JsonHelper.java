package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.enums.GraphQLPageOutcomeButtonRenderType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: enable_reactions */
public final class GraphQLPageOutcomeButton__JsonHelper {
    public static GraphQLPageOutcomeButton m9506a(JsonParser jsonParser) {
        GraphQLPageOutcomeButton graphQLPageOutcomeButton = new GraphQLPageOutcomeButton();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9508a(graphQLPageOutcomeButton, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPageOutcomeButton;
    }

    private static boolean m9508a(GraphQLPageOutcomeButton graphQLPageOutcomeButton, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("button_icon_image".equals(str)) {
            GraphQLEntityCardContextItemIcon a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLEntityCardContextItemIcon__JsonHelper.m7068a(FieldAccessQueryTracker.a(jsonParser, "button_icon_image"));
            }
            graphQLPageOutcomeButton.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageOutcomeButton, "button_icon_image", graphQLPageOutcomeButton.a_, 0, true);
            return true;
        } else if ("button_type".equals(str)) {
            graphQLPageOutcomeButton.e = GraphQLPageCallToActionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPageOutcomeButton, "button_type", graphQLPageOutcomeButton.B_(), 1, false);
            return true;
        } else if ("button_uri".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPageOutcomeButton.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageOutcomeButton, "button_uri", graphQLPageOutcomeButton.B_(), 2, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPageOutcomeButton.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageOutcomeButton, "id", graphQLPageOutcomeButton.B_(), 3, false);
            return true;
        } else if ("render_type".equals(str)) {
            graphQLPageOutcomeButton.h = GraphQLPageOutcomeButtonRenderType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPageOutcomeButton, "render_type", graphQLPageOutcomeButton.B_(), 4, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPageOutcomeButton.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageOutcomeButton, "url", graphQLPageOutcomeButton.B_(), 5, false);
            return true;
        }
    }

    public static void m9507a(JsonGenerator jsonGenerator, GraphQLPageOutcomeButton graphQLPageOutcomeButton, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPageOutcomeButton.j() != null) {
            jsonGenerator.a("button_icon_image");
            GraphQLEntityCardContextItemIcon__JsonHelper.m7069a(jsonGenerator, graphQLPageOutcomeButton.j(), true);
        }
        if (graphQLPageOutcomeButton.k() != null) {
            jsonGenerator.a("button_type", graphQLPageOutcomeButton.k().toString());
        }
        if (graphQLPageOutcomeButton.l() != null) {
            jsonGenerator.a("button_uri", graphQLPageOutcomeButton.l());
        }
        if (graphQLPageOutcomeButton.m() != null) {
            jsonGenerator.a("id", graphQLPageOutcomeButton.m());
        }
        if (graphQLPageOutcomeButton.n() != null) {
            jsonGenerator.a("render_type", graphQLPageOutcomeButton.n().toString());
        }
        if (graphQLPageOutcomeButton.o() != null) {
            jsonGenerator.a("url", graphQLPageOutcomeButton.o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
