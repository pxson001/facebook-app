package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_context_row_place_question */
public class GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer extends FbJsonDeserializer {
    public Object m8049a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillThrowbackMissedMemoriesStory graphQLGoodwillThrowbackMissedMemoriesStory = new GraphQLGoodwillThrowbackMissedMemoriesStory();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillThrowbackMissedMemoriesStory = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillThrowbackMissedMemoriesStory__JsonHelper.m8051a(graphQLGoodwillThrowbackMissedMemoriesStory, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillThrowbackMissedMemoriesStory;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackMissedMemoriesStory.class, new GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer());
    }

    public GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer() {
        a(GraphQLGoodwillThrowbackMissedMemoriesStory.class);
    }
}
