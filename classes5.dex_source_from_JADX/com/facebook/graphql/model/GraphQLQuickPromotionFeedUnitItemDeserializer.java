package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nectarModule */
public class GraphQLQuickPromotionFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionFeedUnitItem.class, new GraphQLQuickPromotionFeedUnitItemDeserializer());
    }

    public GraphQLQuickPromotionFeedUnitItemDeserializer() {
        a(GraphQLQuickPromotionFeedUnitItem.class);
    }

    public Object m21245a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuickPromotionFeedUnitItem__JsonHelper.m21247a(jsonParser);
    }
}
