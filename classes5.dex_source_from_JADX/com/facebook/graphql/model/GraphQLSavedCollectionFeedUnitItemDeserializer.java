package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: multiShareVideoUrl */
public class GraphQLSavedCollectionFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSavedCollectionFeedUnitItem.class, new GraphQLSavedCollectionFeedUnitItemDeserializer());
    }

    public GraphQLSavedCollectionFeedUnitItemDeserializer() {
        a(GraphQLSavedCollectionFeedUnitItem.class);
    }

    public Object m21546a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSavedCollectionFeedUnitItem__JsonHelper.m21548a(jsonParser);
    }
}
