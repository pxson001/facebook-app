package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo cap result is null */
public class GraphQLCreativePagesYouMayLikeFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m6895a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit = new GraphQLCreativePagesYouMayLikeFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLCreativePagesYouMayLikeFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLCreativePagesYouMayLikeFeedUnit__JsonHelper.m6904a(graphQLCreativePagesYouMayLikeFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLCreativePagesYouMayLikeFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCreativePagesYouMayLikeFeedUnit.class, new GraphQLCreativePagesYouMayLikeFeedUnitDeserializer());
    }

    public GraphQLCreativePagesYouMayLikeFeedUnitDeserializer() {
        a(GraphQLCreativePagesYouMayLikeFeedUnit.class);
    }
}
