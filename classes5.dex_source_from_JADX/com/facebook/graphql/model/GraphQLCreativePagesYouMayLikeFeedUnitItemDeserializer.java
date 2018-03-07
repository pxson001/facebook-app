package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo cap result fetch failed */
public class GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCreativePagesYouMayLikeFeedUnitItem.class, new GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer());
    }

    public GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer() {
        a(GraphQLCreativePagesYouMayLikeFeedUnitItem.class);
    }

    public Object m6898a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLCreativePagesYouMayLikeFeedUnitItem__JsonHelper.m6900a(jsonParser);
    }
}
