package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: finch_page_like_toast */
public final class GraphQLInlineActivity__JsonHelper {
    public static GraphQLInlineActivity m8696a(JsonParser jsonParser) {
        GraphQLInlineActivity graphQLInlineActivity = new GraphQLInlineActivity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8698a(graphQLInlineActivity, i, jsonParser);
            jsonParser.f();
        }
        return graphQLInlineActivity;
    }

    private static boolean m8698a(GraphQLInlineActivity graphQLInlineActivity, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLInlineActivity.d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLInlineActivity, "id", graphQLInlineActivity.a_, 0, false);
            return true;
        } else if ("object".equals(str)) {
            GraphQLNode a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "object"));
            }
            graphQLInlineActivity.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLInlineActivity, "object", graphQLInlineActivity.B_(), 1, true);
            return true;
        } else if ("taggable_activity".equals(str)) {
            GraphQLTaggableActivity a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTaggableActivity__JsonHelper.m22082a(FieldAccessQueryTracker.a(jsonParser, "taggable_activity"));
            }
            graphQLInlineActivity.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLInlineActivity, "taggable_activity", graphQLInlineActivity.B_(), 2, true);
            return true;
        } else if ("taggable_activity_icon".equals(str)) {
            GraphQLTaggableActivityIcon a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLTaggableActivityIcon__JsonHelper.m22054a(FieldAccessQueryTracker.a(jsonParser, "taggable_activity_icon"));
            }
            graphQLInlineActivity.g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLInlineActivity, "taggable_activity_icon", graphQLInlineActivity.B_(), 3, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLInlineActivity.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLInlineActivity, "url", graphQLInlineActivity.B_(), 4, false);
            return true;
        }
    }

    public static void m8697a(JsonGenerator jsonGenerator, GraphQLInlineActivity graphQLInlineActivity, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLInlineActivity.j() != null) {
            jsonGenerator.a("id", graphQLInlineActivity.j());
        }
        if (graphQLInlineActivity.k() != null) {
            jsonGenerator.a("object");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLInlineActivity.k(), true);
        }
        if (graphQLInlineActivity.l() != null) {
            jsonGenerator.a("taggable_activity");
            GraphQLTaggableActivity__JsonHelper.m22083a(jsonGenerator, graphQLInlineActivity.l(), true);
        }
        if (graphQLInlineActivity.m() != null) {
            jsonGenerator.a("taggable_activity_icon");
            GraphQLTaggableActivityIcon__JsonHelper.m22055a(jsonGenerator, graphQLInlineActivity.m(), true);
        }
        if (graphQLInlineActivity.n() != null) {
            jsonGenerator.a("url", graphQLInlineActivity.n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
