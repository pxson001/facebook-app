package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: global_brand_v2_migration */
public final class GraphQLGoodwillThrowbackFriendListEdge__JsonHelper {
    public static GraphQLGoodwillThrowbackFriendListEdge m8011a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackFriendListEdge graphQLGoodwillThrowbackFriendListEdge = new GraphQLGoodwillThrowbackFriendListEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            if ("node".equals(i)) {
                GraphQLUser a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLGoodwillThrowbackFriendListEdge.f3990d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendListEdge, "node", graphQLGoodwillThrowbackFriendListEdge.a_, 0, true);
            } else if ("friend_description".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "friend_description"));
                }
                graphQLGoodwillThrowbackFriendListEdge.f3991e = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendListEdge, "friend_description", graphQLGoodwillThrowbackFriendListEdge.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackFriendListEdge;
    }

    public static void m8012a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackFriendListEdge graphQLGoodwillThrowbackFriendListEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackFriendListEdge.m8006a() != null) {
            jsonGenerator.a("node");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFriendListEdge.m8006a(), true);
        }
        if (graphQLGoodwillThrowbackFriendListEdge.m8008j() != null) {
            jsonGenerator.a("friend_description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFriendListEdge.m8008j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
