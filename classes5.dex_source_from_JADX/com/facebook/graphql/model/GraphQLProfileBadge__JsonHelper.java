package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VOICE_CLIPS */
public final class GraphQLProfileBadge__JsonHelper {
    public static GraphQLProfileBadge m21102a(JsonParser jsonParser) {
        GraphQLProfileBadge graphQLProfileBadge = new GraphQLProfileBadge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21104a(graphQLProfileBadge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLProfileBadge;
    }

    private static boolean m21104a(GraphQLProfileBadge graphQLProfileBadge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("badge_icon".equals(str)) {
            GraphQLTaggableActivityIcon a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTaggableActivityIcon__JsonHelper.m22054a(FieldAccessQueryTracker.a(jsonParser, "badge_icon"));
            }
            graphQLProfileBadge.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfileBadge, "badge_icon", graphQLProfileBadge.a_, 0, true);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLProfileBadge.e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfileBadge, "creation_time", graphQLProfileBadge.B_(), 1, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLProfileBadge.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfileBadge, "id", graphQLProfileBadge.B_(), 2, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLProfileBadge.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfileBadge, "url", graphQLProfileBadge.B_(), 3, false);
            return true;
        }
    }

    public static void m21103a(JsonGenerator jsonGenerator, GraphQLProfileBadge graphQLProfileBadge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLProfileBadge.j() != null) {
            jsonGenerator.a("badge_icon");
            GraphQLTaggableActivityIcon__JsonHelper.m22055a(jsonGenerator, graphQLProfileBadge.j(), true);
        }
        jsonGenerator.a("creation_time", graphQLProfileBadge.k());
        if (graphQLProfileBadge.l() != null) {
            jsonGenerator.a("id", graphQLProfileBadge.l());
        }
        if (graphQLProfileBadge.m() != null) {
            jsonGenerator.a("url", graphQLProfileBadge.m());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
