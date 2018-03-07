package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLWorkCommunityTrendingFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TaggableActivityPreviewTemplate */
public final class GraphQLWorkCommunityTrendingFeedUnit$Serializer extends JsonSerializer<GraphQLWorkCommunityTrendingFeedUnit> {
    public final void m22503a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit = (GraphQLWorkCommunityTrendingFeedUnit) obj;
        GraphQLWorkCommunityTrendingFeedUnitDeserializer.m6210a(graphQLWorkCommunityTrendingFeedUnit.w_(), graphQLWorkCommunityTrendingFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLWorkCommunityTrendingFeedUnit.class, new GraphQLWorkCommunityTrendingFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLWorkCommunityTrendingFeedUnit.class, new GraphQLWorkCommunityTrendingFeedUnit$Serializer());
    }
}
