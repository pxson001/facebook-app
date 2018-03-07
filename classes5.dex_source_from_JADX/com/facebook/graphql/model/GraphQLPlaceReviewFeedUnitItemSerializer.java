package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WATCH_NOW */
public class GraphQLPlaceReviewFeedUnitItemSerializer extends JsonSerializer<GraphQLPlaceReviewFeedUnitItem> {
    public final void m20908a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceReviewFeedUnitItem__JsonHelper.m20910a(jsonGenerator, (GraphQLPlaceReviewFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceReviewFeedUnitItem.class, new GraphQLPlaceReviewFeedUnitItemSerializer());
    }
}
