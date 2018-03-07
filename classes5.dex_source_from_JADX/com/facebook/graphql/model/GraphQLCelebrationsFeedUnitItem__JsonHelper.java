package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_demo_ad */
public final class GraphQLCelebrationsFeedUnitItem__JsonHelper {
    public static GraphQLCelebrationsFeedUnitItem m6755a(JsonParser jsonParser) {
        GraphQLCelebrationsFeedUnitItem graphQLCelebrationsFeedUnitItem = new GraphQLCelebrationsFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6757a(graphQLCelebrationsFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLCelebrationsFeedUnitItem;
    }

    private static boolean m6757a(GraphQLCelebrationsFeedUnitItem graphQLCelebrationsFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("description".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "description"));
            }
            graphQLCelebrationsFeedUnitItem.f3431d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnitItem, "description", graphQLCelebrationsFeedUnitItem.a_, 0, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLUser a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLCelebrationsFeedUnitItem.f3432e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnitItem, "profile", graphQLCelebrationsFeedUnitItem.B_(), 1, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCelebrationsFeedUnitItem.f3433f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnitItem, "tracking", graphQLCelebrationsFeedUnitItem.B_(), 2, false);
            return true;
        }
    }

    public static void m6756a(JsonGenerator jsonGenerator, GraphQLCelebrationsFeedUnitItem graphQLCelebrationsFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLCelebrationsFeedUnitItem.m6749a() != null) {
            jsonGenerator.a("description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCelebrationsFeedUnitItem.m6749a(), true);
        }
        if (graphQLCelebrationsFeedUnitItem.m6751j() != null) {
            jsonGenerator.a("profile");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLCelebrationsFeedUnitItem.m6751j(), true);
        }
        if (graphQLCelebrationsFeedUnitItem.m6752k() != null) {
            jsonGenerator.a("tracking", graphQLCelebrationsFeedUnitItem.m6752k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
