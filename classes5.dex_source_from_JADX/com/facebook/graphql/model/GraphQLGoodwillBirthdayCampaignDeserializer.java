package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_like */
public class GraphQLGoodwillBirthdayCampaignDeserializer extends FbJsonDeserializer {
    public Object m7808a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillBirthdayCampaign graphQLGoodwillBirthdayCampaign = new GraphQLGoodwillBirthdayCampaign();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillBirthdayCampaign = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillBirthdayCampaign__JsonHelper.m7819a(graphQLGoodwillBirthdayCampaign, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillBirthdayCampaign;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillBirthdayCampaign.class, new GraphQLGoodwillBirthdayCampaignDeserializer());
    }

    public GraphQLGoodwillBirthdayCampaignDeserializer() {
        a(GraphQLGoodwillBirthdayCampaign.class);
    }
}
