package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: null operation id */
public class GraphQLPagesYouMayLikeFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayLikeFeedUnitItem.class, new GraphQLPagesYouMayLikeFeedUnitItemDeserializer());
    }

    public GraphQLPagesYouMayLikeFeedUnitItemDeserializer() {
        a(GraphQLPagesYouMayLikeFeedUnitItem.class);
    }

    public Object m20577a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPagesYouMayLikeFeedUnitItem__JsonHelper.m20579a(jsonParser);
    }
}
