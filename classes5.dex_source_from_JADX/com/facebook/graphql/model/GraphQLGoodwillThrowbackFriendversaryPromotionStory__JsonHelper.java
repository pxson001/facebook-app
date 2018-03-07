package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: gifts_commerce_details_page */
public final class GraphQLGoodwillThrowbackFriendversaryPromotionStory__JsonHelper {
    public static boolean m8029a(GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLGoodwillThrowbackFriendversaryPromotionStory.f3998d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            long j;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                j = 0;
            } else {
                j = jsonParser.F();
            }
            graphQLGoodwillThrowbackFriendversaryPromotionStory.f3999e = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryPromotionStory, "fetchTimeMs", graphQLGoodwillThrowbackFriendversaryPromotionStory.a_, 0, false);
            return true;
        } else if ("friend_description".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "friend_description"));
            }
            graphQLGoodwillThrowbackFriendversaryPromotionStory.f4000f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryPromotionStory, "friend_description", graphQLGoodwillThrowbackFriendversaryPromotionStory.B_(), 1, true);
            return true;
        } else if ("friendversary_campaign".equals(str)) {
            GraphQLGoodwillFriendversaryCampaign a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGoodwillFriendversaryCampaign__JsonHelper.m7881a(FieldAccessQueryTracker.a(jsonParser, "friendversary_campaign"));
            }
            graphQLGoodwillThrowbackFriendversaryPromotionStory.f4001g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryPromotionStory, "friendversary_campaign", graphQLGoodwillThrowbackFriendversaryPromotionStory.B_(), 2, true);
            return true;
        } else if ("section_header".equals(str)) {
            GraphQLGoodwillThrowbackSection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGoodwillThrowbackSection__JsonHelper.m8116a(FieldAccessQueryTracker.a(jsonParser, "section_header"));
            }
            graphQLGoodwillThrowbackFriendversaryPromotionStory.f4002h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryPromotionStory, "section_header", graphQLGoodwillThrowbackFriendversaryPromotionStory.B_(), 3, true);
            return true;
        } else if (!"render_style".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFriendversaryPromotionStory.f4003i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFriendversaryPromotionStory, "render_style", graphQLGoodwillThrowbackFriendversaryPromotionStory.B_(), 4, false);
            return true;
        }
    }
}
