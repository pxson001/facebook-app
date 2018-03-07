package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ios_feather_post_compose */
public final class GraphQLEducationExperience__JsonHelper {
    public static GraphQLEducationExperience m6983a(JsonParser jsonParser) {
        GraphQLEducationExperience graphQLEducationExperience = new GraphQLEducationExperience();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6985a(graphQLEducationExperience, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEducationExperience;
    }

    private static boolean m6985a(GraphQLEducationExperience graphQLEducationExperience, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEducationExperience.f3516d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "id", graphQLEducationExperience.a_, 0, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLEducationExperience.f3517e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "image", graphQLEducationExperience.B_(), 1, true);
            return true;
        } else if ("message".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLEducationExperience.f3518f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "message", graphQLEducationExperience.B_(), 2, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLEducationExperience.f3519g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "profileImageLarge", graphQLEducationExperience.B_(), 3, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLEducationExperience.f3520h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "profileImageSmall", graphQLEducationExperience.B_(), 4, true);
            return true;
        } else if ("school".equals(str)) {
            GraphQLPage a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "school"));
            }
            graphQLEducationExperience.f3521i = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "school", graphQLEducationExperience.B_(), 5, true);
            return true;
        } else if ("time_range".equals(str)) {
            GraphQLEventTimeRange a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLEventTimeRange__JsonHelper.m7303a(FieldAccessQueryTracker.a(jsonParser, "time_range"));
            }
            graphQLEducationExperience.f3522j = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "time_range", graphQLEducationExperience.B_(), 6, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEducationExperience.f3523k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEducationExperience, "url", graphQLEducationExperience.B_(), 7, false);
            return true;
        }
    }

    public static void m6984a(JsonGenerator jsonGenerator, GraphQLEducationExperience graphQLEducationExperience, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEducationExperience.m6973j() != null) {
            jsonGenerator.a("id", graphQLEducationExperience.m6973j());
        }
        if (graphQLEducationExperience.m6974k() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEducationExperience.m6974k(), true);
        }
        if (graphQLEducationExperience.m6975l() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEducationExperience.m6975l(), true);
        }
        if (graphQLEducationExperience.m6976m() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEducationExperience.m6976m(), true);
        }
        if (graphQLEducationExperience.m6977n() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEducationExperience.m6977n(), true);
        }
        if (graphQLEducationExperience.m6978o() != null) {
            jsonGenerator.a("school");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLEducationExperience.m6978o(), true);
        }
        if (graphQLEducationExperience.m6979p() != null) {
            jsonGenerator.a("time_range");
            GraphQLEventTimeRange__JsonHelper.m7304a(jsonGenerator, graphQLEducationExperience.m6979p(), true);
        }
        if (graphQLEducationExperience.m6980q() != null) {
            jsonGenerator.a("url", graphQLEducationExperience.m6980q());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
