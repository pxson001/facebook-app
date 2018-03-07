package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: merchant_logo */
public class GraphQLWorkCommunityTrendingFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLWorkCommunityTrendingFeedUnitItem.class, new GraphQLWorkCommunityTrendingFeedUnitItemDeserializer());
    }

    public GraphQLWorkCommunityTrendingFeedUnitItemDeserializer() {
        a(GraphQLWorkCommunityTrendingFeedUnitItem.class);
    }

    public Object m22511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLWorkCommunityTrendingFeedUnitItem__JsonHelper.m22513a(jsonParser);
    }
}
