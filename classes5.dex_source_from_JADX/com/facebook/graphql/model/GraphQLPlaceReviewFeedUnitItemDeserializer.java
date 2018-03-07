package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_timeline */
public class GraphQLPlaceReviewFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceReviewFeedUnitItem.class, new GraphQLPlaceReviewFeedUnitItemDeserializer());
    }

    public GraphQLPlaceReviewFeedUnitItemDeserializer() {
        a(GraphQLPlaceReviewFeedUnitItem.class);
    }

    public Object m20907a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceReviewFeedUnitItem__JsonHelper.m20909a(jsonParser);
    }
}
