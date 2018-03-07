package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: num_friends_on_instagram */
public class GraphQLPagesYouMayAdvertiseFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m9558a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = new GraphQLPagesYouMayAdvertiseFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPagesYouMayAdvertiseFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLPagesYouMayAdvertiseFeedUnit__JsonHelper.m9574a(graphQLPagesYouMayAdvertiseFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLPagesYouMayAdvertiseFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayAdvertiseFeedUnit.class, new GraphQLPagesYouMayAdvertiseFeedUnitDeserializer());
    }

    public GraphQLPagesYouMayAdvertiseFeedUnitDeserializer() {
        a(GraphQLPagesYouMayAdvertiseFeedUnit.class);
    }
}
