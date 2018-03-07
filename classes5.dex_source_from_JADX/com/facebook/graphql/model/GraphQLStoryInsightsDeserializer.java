package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_post_claim_message */
public class GraphQLStoryInsightsDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryInsights.class, new GraphQLStoryInsightsDeserializer());
    }

    public GraphQLStoryInsightsDeserializer() {
        a(GraphQLStoryInsights.class);
    }

    public Object m21877a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStoryInsights__JsonHelper.m21879a(jsonParser);
    }
}
