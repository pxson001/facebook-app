package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WIZARD */
public final class GraphQLPeopleYouShouldFollowFeedUnitItem__JsonHelper {
    public static GraphQLPeopleYouShouldFollowFeedUnitItem m20705a(JsonParser jsonParser) {
        GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem = new GraphQLPeopleYouShouldFollowFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20707a(graphQLPeopleYouShouldFollowFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPeopleYouShouldFollowFeedUnitItem;
    }

    private static boolean m20707a(GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem, String str, JsonParser jsonParser) {
        GraphQLUser graphQLUser = null;
        GraphQLTextWithEntities a;
        if ("employer_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "employer_context"));
            }
            graphQLPeopleYouShouldFollowFeedUnitItem.f12499d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnitItem, "employer_context", graphQLPeopleYouShouldFollowFeedUnitItem.a_, 0, true);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLPeopleYouShouldFollowFeedUnitItem.f12500e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnitItem, "social_context", graphQLPeopleYouShouldFollowFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("tracking".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPeopleYouShouldFollowFeedUnitItem.f12501f = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnitItem, "tracking", graphQLPeopleYouShouldFollowFeedUnitItem.B_(), 2, false);
            return true;
        } else if (!"user".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLUser = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "user"));
            }
            graphQLPeopleYouShouldFollowFeedUnitItem.f12502g = graphQLUser;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnitItem, "user", graphQLPeopleYouShouldFollowFeedUnitItem.B_(), 3, true);
            return true;
        }
    }

    public static void m20706a(JsonGenerator jsonGenerator, GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPeopleYouShouldFollowFeedUnitItem.m20699j() != null) {
            jsonGenerator.a("employer_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouShouldFollowFeedUnitItem.m20699j(), true);
        }
        if (graphQLPeopleYouShouldFollowFeedUnitItem.m20701l() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouShouldFollowFeedUnitItem.m20701l(), true);
        }
        if (graphQLPeopleYouShouldFollowFeedUnitItem.m20700k() != null) {
            jsonGenerator.a("tracking", graphQLPeopleYouShouldFollowFeedUnitItem.m20700k());
        }
        if (graphQLPeopleYouShouldFollowFeedUnitItem.m20702m() != null) {
            jsonGenerator.a("user");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLPeopleYouShouldFollowFeedUnitItem.m20702m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
