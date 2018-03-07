package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TYPEAHEAD */
public final class GraphQLWorkExperience__JsonHelper {
    public static GraphQLWorkExperience m22533a(JsonParser jsonParser) {
        GraphQLWorkExperience graphQLWorkExperience = new GraphQLWorkExperience();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22535a(graphQLWorkExperience, i, jsonParser);
            jsonParser.f();
        }
        return graphQLWorkExperience;
    }

    private static boolean m22535a(GraphQLWorkExperience graphQLWorkExperience, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLPage a;
        if ("employer".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "employer"));
            }
            graphQLWorkExperience.f13460d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "employer", graphQLWorkExperience.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLWorkExperience.f13461e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "id", graphQLWorkExperience.B_(), 1, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLWorkExperience.f13462f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "image", graphQLWorkExperience.B_(), 2, true);
            return true;
        } else if ("message".equals(str)) {
            GraphQLTextWithEntities a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLWorkExperience.f13463g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "message", graphQLWorkExperience.B_(), 3, true);
            return true;
        } else if ("position".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "position"));
            }
            graphQLWorkExperience.f13464h = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "position", graphQLWorkExperience.B_(), 4, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLWorkExperience.f13465i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "profileImageLarge", graphQLWorkExperience.B_(), 5, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLWorkExperience.f13466j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "profileImageSmall", graphQLWorkExperience.B_(), 6, true);
            return true;
        } else if ("time_range".equals(str)) {
            GraphQLEventTimeRange a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLEventTimeRange__JsonHelper.m7303a(FieldAccessQueryTracker.a(jsonParser, "time_range"));
            }
            graphQLWorkExperience.f13467k = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "time_range", graphQLWorkExperience.B_(), 7, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLWorkExperience.f13468l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkExperience, "url", graphQLWorkExperience.B_(), 8, false);
            return true;
        }
    }

    public static void m22534a(JsonGenerator jsonGenerator, GraphQLWorkExperience graphQLWorkExperience, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLWorkExperience.m22522j() != null) {
            jsonGenerator.a("employer");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLWorkExperience.m22522j(), true);
        }
        if (graphQLWorkExperience.m22523k() != null) {
            jsonGenerator.a("id", graphQLWorkExperience.m22523k());
        }
        if (graphQLWorkExperience.m22524l() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLWorkExperience.m22524l(), true);
        }
        if (graphQLWorkExperience.m22525m() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLWorkExperience.m22525m(), true);
        }
        if (graphQLWorkExperience.m22526n() != null) {
            jsonGenerator.a("position");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLWorkExperience.m22526n(), true);
        }
        if (graphQLWorkExperience.m22527o() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLWorkExperience.m22527o(), true);
        }
        if (graphQLWorkExperience.m22528p() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLWorkExperience.m22528p(), true);
        }
        if (graphQLWorkExperience.m22529q() != null) {
            jsonGenerator.a("time_range");
            GraphQLEventTimeRange__JsonHelper.m7304a(jsonGenerator, graphQLWorkExperience.m22529q(), true);
        }
        if (graphQLWorkExperience.m22530r() != null) {
            jsonGenerator.a("url", graphQLWorkExperience.m22530r());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
