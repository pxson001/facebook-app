package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_old_info_card_placeholder */
public class GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserPersonToCharityDonorsConnection.class, new GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer());
    }

    public GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer() {
        a(GraphQLFundraiserPersonToCharityDonorsConnection.class);
    }

    public Object m7727a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFundraiserPersonToCharityDonorsConnection__JsonHelper.m7729a(jsonParser);
    }
}
