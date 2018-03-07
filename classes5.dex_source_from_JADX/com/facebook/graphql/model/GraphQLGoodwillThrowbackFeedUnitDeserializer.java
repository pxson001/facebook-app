package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_finch_liked_pages */
public class GraphQLGoodwillThrowbackFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m7991a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGoodwillThrowbackFeedUnit graphQLGoodwillThrowbackFeedUnit = new GraphQLGoodwillThrowbackFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGoodwillThrowbackFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGoodwillThrowbackFeedUnit__JsonHelper.m7993a(graphQLGoodwillThrowbackFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGoodwillThrowbackFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFeedUnit.class, new GraphQLGoodwillThrowbackFeedUnitDeserializer());
    }

    public GraphQLGoodwillThrowbackFeedUnitDeserializer() {
        a(GraphQLGoodwillThrowbackFeedUnit.class);
    }
}
