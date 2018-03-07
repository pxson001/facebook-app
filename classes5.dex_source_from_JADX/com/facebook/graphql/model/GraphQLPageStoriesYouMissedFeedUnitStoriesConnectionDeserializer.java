package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: num_rule_breakers */
public class GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class, new GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer());
    }

    public GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer() {
        a(GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class);
    }

    public Object m9533a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageStoriesYouMissedFeedUnitStoriesConnection__JsonHelper.m9535a(jsonParser);
    }
}
