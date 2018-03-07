package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_browser */
public class GraphQLGoodwillVideoCampaignDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillVideoCampaign.class, new GraphQLGoodwillVideoCampaignDeserializer());
    }

    public GraphQLGoodwillVideoCampaignDeserializer() {
        a(GraphQLGoodwillVideoCampaign.class);
    }

    public Object m8133a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillVideoCampaign__JsonHelper.m8135a(jsonParser);
    }
}
