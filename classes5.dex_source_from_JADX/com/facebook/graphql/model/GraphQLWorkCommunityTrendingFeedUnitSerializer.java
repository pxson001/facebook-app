package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TagExpansionEducationInfo */
public class GraphQLWorkCommunityTrendingFeedUnitSerializer extends JsonSerializer<GraphQLWorkCommunityTrendingFeedUnit> {
    public final void m22516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit = (GraphQLWorkCommunityTrendingFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLWorkCommunityTrendingFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLWorkCommunityTrendingFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLWorkCommunityTrendingFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLWorkCommunityTrendingFeedUnit.g());
        }
        if (graphQLWorkCommunityTrendingFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLWorkCommunityTrendingFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLWorkCommunityTrendingFeedUnit.T_());
        if (graphQLWorkCommunityTrendingFeedUnit.p() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLWorkCommunityTrendingFeedUnit.p());
        }
        if (graphQLWorkCommunityTrendingFeedUnit.q() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLWorkCommunityTrendingFeedUnit.q(), true);
        }
        if (graphQLWorkCommunityTrendingFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLWorkCommunityTrendingFeedUnit.k());
        }
        jsonGenerator.a("trending_stories");
        if (graphQLWorkCommunityTrendingFeedUnit.r() != null) {
            jsonGenerator.d();
            for (GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem : graphQLWorkCommunityTrendingFeedUnit.r()) {
                if (graphQLWorkCommunityTrendingFeedUnitItem != null) {
                    GraphQLWorkCommunityTrendingFeedUnitItem__JsonHelper.m22514a(jsonGenerator, graphQLWorkCommunityTrendingFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLWorkCommunityTrendingFeedUnit.class, new GraphQLWorkCommunityTrendingFeedUnitSerializer());
    }
}
