package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WOMENS_CLOTHING_STORE */
public final class GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper {
    public static GraphQLPeopleYouMayKnowFeedUnitItem m20686a(JsonParser jsonParser) {
        GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem = new GraphQLPeopleYouMayKnowFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20688a(graphQLPeopleYouMayKnowFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPeopleYouMayKnowFeedUnitItem;
    }

    private static boolean m20688a(GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("profile".equals(str)) {
            GraphQLUser a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLPeopleYouMayKnowFeedUnitItem.f12479d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnitItem, "profile", graphQLPeopleYouMayKnowFeedUnitItem.a_, 0, true);
            return true;
        } else if ("social_context".equals(str)) {
            GraphQLTextWithEntities a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLPeopleYouMayKnowFeedUnitItem.f12480e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnitItem, "social_context", graphQLPeopleYouMayKnowFeedUnitItem.B_(), 1, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnitItem.f12481f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnitItem, "tracking", graphQLPeopleYouMayKnowFeedUnitItem.B_(), 2, false);
            return true;
        }
    }

    public static void m20687a(JsonGenerator jsonGenerator, GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPeopleYouMayKnowFeedUnitItem.m20682m() != null) {
            jsonGenerator.a("profile");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnitItem.m20682m(), true);
        }
        if (graphQLPeopleYouMayKnowFeedUnitItem.m20683n() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnitItem.m20683n(), true);
        }
        if (graphQLPeopleYouMayKnowFeedUnitItem.m20680k() != null) {
            jsonGenerator.a("tracking", graphQLPeopleYouMayKnowFeedUnitItem.m20680k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
