package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_invite_escape_hatch */
public class GraphQLGoodwillFriendversaryCampaignDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillFriendversaryCampaign.class, new GraphQLGoodwillFriendversaryCampaignDeserializer());
    }

    public GraphQLGoodwillFriendversaryCampaignDeserializer() {
        a(GraphQLGoodwillFriendversaryCampaign.class);
    }

    public Object m7879a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillFriendversaryCampaign__JsonHelper.m7881a(jsonParser);
    }
}
