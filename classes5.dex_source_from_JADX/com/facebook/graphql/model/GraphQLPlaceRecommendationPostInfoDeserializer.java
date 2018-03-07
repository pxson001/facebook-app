package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: network_ego */
public class GraphQLPlaceRecommendationPostInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceRecommendationPostInfo.class, new GraphQLPlaceRecommendationPostInfoDeserializer());
    }

    public GraphQLPlaceRecommendationPostInfoDeserializer() {
        a(GraphQLPlaceRecommendationPostInfo.class);
    }

    public Object m20891a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceRecommendationPostInfo__JsonHelper.m20893a(jsonParser);
    }
}
