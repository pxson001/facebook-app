package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_composer_card */
public class GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotedCampaignsConnection.class, new GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer());
    }

    public GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer() {
        a(GraphQLGoodwillThrowbackPromotedCampaignsConnection.class);
    }

    public Object m8075a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackPromotedCampaignsConnection__JsonHelper.m8077a(jsonParser);
    }
}
