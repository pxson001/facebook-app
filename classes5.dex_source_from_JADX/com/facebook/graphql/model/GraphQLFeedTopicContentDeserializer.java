package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_uri */
public class GraphQLFeedTopicContentDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedTopicContent.class, new GraphQLFeedTopicContentDeserializer());
    }

    public GraphQLFeedTopicContentDeserializer() {
        a(GraphQLFeedTopicContent.class);
    }

    public Object m7463a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedTopicContent__JsonHelper.m7465a(jsonParser);
    }
}
