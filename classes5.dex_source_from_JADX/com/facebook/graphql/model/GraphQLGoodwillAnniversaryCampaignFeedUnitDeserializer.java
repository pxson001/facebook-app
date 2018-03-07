package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_like_invite_card */
public class GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m7790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = new GraphQLGoodwillAnniversaryCampaignFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillAnniversaryCampaignFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillAnniversaryCampaignFeedUnit__JsonHelper.m7792a(graphQLGoodwillAnniversaryCampaignFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillAnniversaryCampaignFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillAnniversaryCampaignFeedUnit.class, new GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer());
    }

    public GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer() {
        a(GraphQLGoodwillAnniversaryCampaignFeedUnit.class);
    }
}
