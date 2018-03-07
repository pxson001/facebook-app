package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: formatted_tax */
public final class GraphQLGroupsYouShouldJoinFeedUnitItem__JsonHelper {
    public static GraphQLGroupsYouShouldJoinFeedUnitItem m8556a(JsonParser jsonParser) {
        GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem = new GraphQLGroupsYouShouldJoinFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8558a(graphQLGroupsYouShouldJoinFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGroupsYouShouldJoinFeedUnitItem;
    }

    private static boolean m8558a(GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("item_context".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "item_context"));
            }
            graphQLGroupsYouShouldJoinFeedUnitItem.f4241d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnitItem, "item_context", graphQLGroupsYouShouldJoinFeedUnitItem.a_, 0, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLGroup a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGroup__JsonHelper.m8518a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLGroupsYouShouldJoinFeedUnitItem.f4242e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnitItem, "profile", graphQLGroupsYouShouldJoinFeedUnitItem.B_(), 1, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupsYouShouldJoinFeedUnitItem.f4243f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnitItem, "tracking", graphQLGroupsYouShouldJoinFeedUnitItem.B_(), 2, false);
            return true;
        }
    }

    public static void m8557a(JsonGenerator jsonGenerator, GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGroupsYouShouldJoinFeedUnitItem.m8552l() != null) {
            jsonGenerator.a("item_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroupsYouShouldJoinFeedUnitItem.m8552l(), true);
        }
        if (graphQLGroupsYouShouldJoinFeedUnitItem.m8553m() != null) {
            jsonGenerator.a("profile");
            GraphQLGroup__JsonHelper.m8519a(jsonGenerator, graphQLGroupsYouShouldJoinFeedUnitItem.m8553m(), true);
        }
        if (graphQLGroupsYouShouldJoinFeedUnitItem.m8551k() != null) {
            jsonGenerator.a("tracking", graphQLGroupsYouShouldJoinFeedUnitItem.m8551k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
