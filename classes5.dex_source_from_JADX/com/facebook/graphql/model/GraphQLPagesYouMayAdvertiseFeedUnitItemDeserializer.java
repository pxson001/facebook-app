package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: num_failures */
public class GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayAdvertiseFeedUnitItem.class, new GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer());
    }

    public GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer() {
        a(GraphQLPagesYouMayAdvertiseFeedUnitItem.class);
    }

    public Object m9568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPagesYouMayAdvertiseFeedUnitItem__JsonHelper.m9570a(jsonParser);
    }
}
