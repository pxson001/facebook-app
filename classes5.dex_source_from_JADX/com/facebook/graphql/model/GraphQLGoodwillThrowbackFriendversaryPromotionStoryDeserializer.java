package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_creation */
public class GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer extends FbJsonDeserializer {
    public Object m8027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory = new GraphQLGoodwillThrowbackFriendversaryPromotionStory();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillThrowbackFriendversaryPromotionStory = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillThrowbackFriendversaryPromotionStory__JsonHelper.m8029a(graphQLGoodwillThrowbackFriendversaryPromotionStory, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillThrowbackFriendversaryPromotionStory;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendversaryPromotionStory.class, new GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer());
    }

    public GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer() {
        a(GraphQLGoodwillThrowbackFriendversaryPromotionStory.class);
    }
}
