package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_create_dialog */
public class GraphQLGoodwillThrowbackFriendversaryStoryDeserializer extends FbJsonDeserializer {
    public Object m8032a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = new GraphQLGoodwillThrowbackFriendversaryStory();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillThrowbackFriendversaryStory = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillThrowbackFriendversaryStory__JsonHelper.m8034a(graphQLGoodwillThrowbackFriendversaryStory, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillThrowbackFriendversaryStory;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendversaryStory.class, new GraphQLGoodwillThrowbackFriendversaryStoryDeserializer());
    }

    public GraphQLGoodwillThrowbackFriendversaryStoryDeserializer() {
        a(GraphQLGoodwillThrowbackFriendversaryStory.class);
    }
}
