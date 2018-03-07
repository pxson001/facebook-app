package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pageId */
public class GraphQLGreetingCardPromotionFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8327a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit = new GraphQLGreetingCardPromotionFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGreetingCardPromotionFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGreetingCardPromotionFeedUnit__JsonHelper.m8329a(graphQLGreetingCardPromotionFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGreetingCardPromotionFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardPromotionFeedUnit.class, new GraphQLGreetingCardPromotionFeedUnitDeserializer());
    }

    public GraphQLGreetingCardPromotionFeedUnitDeserializer() {
        a(GraphQLGreetingCardPromotionFeedUnit.class);
    }
}
