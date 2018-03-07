package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_WELCOME */
public final class GraphQLReactionUnit__JsonHelper {
    public static GraphQLReactionUnit m21341a(JsonParser jsonParser) {
        GraphQLReactionUnit graphQLReactionUnit = new GraphQLReactionUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLReactionUnit.f12888d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "__type__", graphQLReactionUnit.a_, 0, false);
            } else if ("collapse_state".equals(i)) {
                graphQLReactionUnit.f12889e = GraphQLReactionUnitCollapseState.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "collapse_state", graphQLReactionUnit.a_, 1, false);
            } else if ("has_inner_borders".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLReactionUnit.f12890f = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "has_inner_borders", graphQLReactionUnit.a_, 2, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLReactionUnit.f12891g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "id", graphQLReactionUnit.a_, 3, false);
            } else if ("page".equals(i)) {
                GraphQLPage graphQLPage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPage = null;
                } else {
                    graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
                }
                graphQLReactionUnit.f12892h = graphQLPage;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "page", graphQLReactionUnit.a_, 5, true);
            } else if ("settings_token".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLReactionUnit.f12893i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "settings_token", graphQLReactionUnit.a_, 6, false);
            } else if ("unit_score".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLReactionUnit.f12894j = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "unit_score", graphQLReactionUnit.a_, 7, false);
            } else if ("unit_style".equals(i)) {
                graphQLReactionUnit.f12895k = GraphQLReactionUnitStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "unit_style", graphQLReactionUnit.a_, 8, false);
            } else if ("unit_type_token".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLReactionUnit.f12896l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "unit_type_token", graphQLReactionUnit.a_, 9, false);
            } else if ("welcome_note_message".equals(i)) {
                GraphQLTextWithEntities graphQLTextWithEntities;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = null;
                } else {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "welcome_note_message"));
                }
                graphQLReactionUnit.f12897m = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "welcome_note_message", graphQLReactionUnit.a_, 10, true);
            } else if ("welcome_note_photo".equals(i)) {
                GraphQLMedia graphQLMedia;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLMedia = null;
                } else {
                    graphQLMedia = GraphQLMedia__JsonHelper.m9078a(FieldAccessQueryTracker.a(jsonParser, "welcome_note_photo"));
                }
                graphQLReactionUnit.f12898n = graphQLMedia;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactionUnit, "welcome_note_photo", graphQLReactionUnit.a_, 11, true);
            }
            jsonParser.f();
        }
        return graphQLReactionUnit;
    }

    public static void m21342a(JsonGenerator jsonGenerator, GraphQLReactionUnit graphQLReactionUnit, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLReactionUnit.m21328j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLReactionUnit.m21328j().e());
            jsonGenerator.g();
        }
        if (graphQLReactionUnit.m21329k() != null) {
            jsonGenerator.a("collapse_state", graphQLReactionUnit.m21329k().toString());
        }
        jsonGenerator.a("has_inner_borders", graphQLReactionUnit.m21330l());
        if (graphQLReactionUnit.m21331m() != null) {
            jsonGenerator.a("id", graphQLReactionUnit.m21331m());
        }
        if (graphQLReactionUnit.m21332n() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLReactionUnit.m21332n(), true);
        }
        if (graphQLReactionUnit.m21333o() != null) {
            jsonGenerator.a("settings_token", graphQLReactionUnit.m21333o());
        }
        jsonGenerator.a("unit_score", graphQLReactionUnit.m21334p());
        if (graphQLReactionUnit.m21335q() != null) {
            jsonGenerator.a("unit_style", graphQLReactionUnit.m21335q().toString());
        }
        if (graphQLReactionUnit.m21336r() != null) {
            jsonGenerator.a("unit_type_token", graphQLReactionUnit.m21336r());
        }
        if (graphQLReactionUnit.m21337s() != null) {
            jsonGenerator.a("welcome_note_message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLReactionUnit.m21337s(), true);
        }
        if (graphQLReactionUnit.m21338t() != null) {
            jsonGenerator.a("welcome_note_photo");
            GraphQLMedia__JsonHelper.m9079a(jsonGenerator, graphQLReactionUnit.m21338t(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
