package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_permalink */
public class GraphQLFundraiserCampaignDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserCampaign.class, new GraphQLFundraiserCampaignDeserializer());
    }

    public GraphQLFundraiserCampaignDeserializer() {
        a(GraphQLFundraiserCampaign.class);
    }

    public Object m7666a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFundraiserCampaign__JsonHelper.m7668a(jsonParser);
    }
}
