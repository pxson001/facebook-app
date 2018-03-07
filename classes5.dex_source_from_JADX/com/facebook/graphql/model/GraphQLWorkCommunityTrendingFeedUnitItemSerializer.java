package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TaggableActivityAllIconsConnection */
public class GraphQLWorkCommunityTrendingFeedUnitItemSerializer extends JsonSerializer<GraphQLWorkCommunityTrendingFeedUnitItem> {
    public final void m22512a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLWorkCommunityTrendingFeedUnitItem__JsonHelper.m22514a(jsonGenerator, (GraphQLWorkCommunityTrendingFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLWorkCommunityTrendingFeedUnitItem.class, new GraphQLWorkCommunityTrendingFeedUnitItemSerializer());
    }
}
