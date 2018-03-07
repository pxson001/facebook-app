package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_snowlift */
public class GraphQLCollectionsRatingFeedUnitItemDeserializer extends FbJsonDeserializer {
    public Object m6796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLCollectionsRatingFeedUnitItem graphQLCollectionsRatingFeedUnitItem = new GraphQLCollectionsRatingFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLCollectionsRatingFeedUnitItem = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLCollectionsRatingFeedUnitItem__JsonHelper.m6798a(graphQLCollectionsRatingFeedUnitItem, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLCollectionsRatingFeedUnitItem;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCollectionsRatingFeedUnitItem.class, new GraphQLCollectionsRatingFeedUnitItemDeserializer());
    }

    public GraphQLCollectionsRatingFeedUnitItemDeserializer() {
        a(GraphQLCollectionsRatingFeedUnitItem.class);
    }
}
