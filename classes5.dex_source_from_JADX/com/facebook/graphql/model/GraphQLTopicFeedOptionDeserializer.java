package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: min_zoom */
public class GraphQLTopicFeedOptionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopicFeedOption.class, new GraphQLTopicFeedOptionDeserializer());
    }

    public GraphQLTopicFeedOptionDeserializer() {
        a(GraphQLTopicFeedOption.class);
    }

    public Object m22273a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTopicFeedOption__JsonHelper.m22275a(jsonParser);
    }
}
