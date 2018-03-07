package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fix_inconsistent_like */
public final class GraphQLIncomingFriendRequestFeedUnitItem__JsonHelper {
    public static GraphQLIncomingFriendRequestFeedUnitItem m8670a(JsonParser jsonParser) {
        GraphQLIncomingFriendRequestFeedUnitItem graphQLIncomingFriendRequestFeedUnitItem = new GraphQLIncomingFriendRequestFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8672a(graphQLIncomingFriendRequestFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLIncomingFriendRequestFeedUnitItem;
    }

    private static boolean m8672a(GraphQLIncomingFriendRequestFeedUnitItem graphQLIncomingFriendRequestFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("profile".equals(str)) {
            GraphQLUser a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLIncomingFriendRequestFeedUnitItem.f4298d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnitItem, "profile", graphQLIncomingFriendRequestFeedUnitItem.a_, 0, true);
            return true;
        } else if ("social_context".equals(str)) {
            GraphQLTextWithEntities a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLIncomingFriendRequestFeedUnitItem.f4299e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnitItem, "social_context", graphQLIncomingFriendRequestFeedUnitItem.B_(), 1, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLIncomingFriendRequestFeedUnitItem.f4300f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnitItem, "tracking", graphQLIncomingFriendRequestFeedUnitItem.B_(), 2, false);
            return true;
        }
    }

    public static void m8671a(JsonGenerator jsonGenerator, GraphQLIncomingFriendRequestFeedUnitItem graphQLIncomingFriendRequestFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLIncomingFriendRequestFeedUnitItem.m8664a() != null) {
            jsonGenerator.a("profile");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLIncomingFriendRequestFeedUnitItem.m8664a(), true);
        }
        if (graphQLIncomingFriendRequestFeedUnitItem.m8666j() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLIncomingFriendRequestFeedUnitItem.m8666j(), true);
        }
        if (graphQLIncomingFriendRequestFeedUnitItem.m8667k() != null) {
            jsonGenerator.a("tracking", graphQLIncomingFriendRequestFeedUnitItem.m8667k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
