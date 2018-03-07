package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_logo */
public class GraphQLGoodwillAnniversaryCampaignDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillAnniversaryCampaign.class, new GraphQLGoodwillAnniversaryCampaignDeserializer());
    }

    public GraphQLGoodwillAnniversaryCampaignDeserializer() {
        a(GraphQLGoodwillAnniversaryCampaign.class);
    }

    public Object m7787a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7794a(jsonParser);
    }
}
