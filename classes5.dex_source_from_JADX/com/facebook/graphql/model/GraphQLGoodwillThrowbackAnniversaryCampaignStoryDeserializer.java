package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_header */
public class GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer extends FbJsonDeserializer {
    public Object m7923a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = new GraphQLGoodwillThrowbackAnniversaryCampaignStory();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillThrowbackAnniversaryCampaignStory = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillThrowbackAnniversaryCampaignStory__JsonHelper.m7925a(graphQLGoodwillThrowbackAnniversaryCampaignStory, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillThrowbackAnniversaryCampaignStory;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackAnniversaryCampaignStory.class, new GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer());
    }

    public GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer() {
        a(GraphQLGoodwillThrowbackAnniversaryCampaignStory.class);
    }
}
