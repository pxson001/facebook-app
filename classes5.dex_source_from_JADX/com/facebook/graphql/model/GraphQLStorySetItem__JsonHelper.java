package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: USER_SNOOZED_OR_HIDDEN */
public final class GraphQLStorySetItem__JsonHelper {
    public static GraphQLStorySetItem m21903a(JsonParser jsonParser) {
        GraphQLStorySetItem graphQLStorySetItem = new GraphQLStorySetItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21905a(graphQLStorySetItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStorySetItem;
    }

    private static boolean m21905a(GraphQLStorySetItem graphQLStorySetItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStorySetItem.f13193d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySetItem, "id", graphQLStorySetItem.a_, 0, false);
            return true;
        } else if ("story".equals(str)) {
            GraphQLStory a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "story"));
            }
            graphQLStorySetItem.f13194e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySetItem, "story", graphQLStorySetItem.B_(), 1, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStorySetItem.f13195f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySetItem, "url", graphQLStorySetItem.B_(), 2, false);
            return true;
        }
    }

    public static void m21904a(JsonGenerator jsonGenerator, GraphQLStorySetItem graphQLStorySetItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStorySetItem.m21898j() != null) {
            jsonGenerator.a("id", graphQLStorySetItem.m21898j());
        }
        if (graphQLStorySetItem.m21899k() != null) {
            jsonGenerator.a("story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStorySetItem.m21899k(), true);
        }
        if (graphQLStorySetItem.m21900l() != null) {
            jsonGenerator.a("url", graphQLStorySetItem.m21900l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
