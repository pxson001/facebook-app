package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: gk_editor_history_v2/ */
public class GraphQLGoodwillThrowbackFriendversaryPromotionStorySerializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendversaryPromotionStory> {
    public final void m8028a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackFriendversaryPromotionStory.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillThrowbackFriendversaryPromotionStory.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("fetchTimeMs", graphQLGoodwillThrowbackFriendversaryPromotionStory.T_());
        if (graphQLGoodwillThrowbackFriendversaryPromotionStory.m8023k() != null) {
            jsonGenerator.a("friend_description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFriendversaryPromotionStory.m8023k(), true);
        }
        if (graphQLGoodwillThrowbackFriendversaryPromotionStory.m8024l() != null) {
            jsonGenerator.a("friendversary_campaign");
            GraphQLGoodwillFriendversaryCampaign__JsonHelper.m7882a(jsonGenerator, graphQLGoodwillThrowbackFriendversaryPromotionStory.m8024l(), true);
        }
        if (graphQLGoodwillThrowbackFriendversaryPromotionStory.m8025m() != null) {
            jsonGenerator.a("section_header");
            GraphQLGoodwillThrowbackSection__JsonHelper.m8117a(jsonGenerator, graphQLGoodwillThrowbackFriendversaryPromotionStory.m8025m(), true);
        }
        if (graphQLGoodwillThrowbackFriendversaryPromotionStory.m8026n() != null) {
            jsonGenerator.a("render_style", graphQLGoodwillThrowbackFriendversaryPromotionStory.m8026n());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendversaryPromotionStory.class, new GraphQLGoodwillThrowbackFriendversaryPromotionStorySerializer());
    }
}
