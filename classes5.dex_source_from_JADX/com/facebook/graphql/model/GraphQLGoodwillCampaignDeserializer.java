package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_invite_escape_hatch_finch */
public class GraphQLGoodwillCampaignDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillCampaign.class, new GraphQLGoodwillCampaignDeserializer());
    }

    public GraphQLGoodwillCampaignDeserializer() {
        a(GraphQLGoodwillCampaign.class);
    }

    public Object m7849a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillCampaign__JsonHelper.m7851a(jsonParser);
    }
}
