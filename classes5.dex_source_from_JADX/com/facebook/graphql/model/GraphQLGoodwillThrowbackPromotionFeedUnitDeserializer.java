package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_browser_invite */
public class GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = new GraphQLGoodwillThrowbackPromotionFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillThrowbackPromotionFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillThrowbackPromotionFeedUnit__JsonHelper.m8102a(graphQLGoodwillThrowbackPromotionFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillThrowbackPromotionFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotionFeedUnit.class, new GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer());
    }

    public GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer() {
        a(GraphQLGoodwillThrowbackPromotionFeedUnit.class);
    }
}
