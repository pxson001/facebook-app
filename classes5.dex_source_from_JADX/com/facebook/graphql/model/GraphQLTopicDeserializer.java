package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: minimal_base_hash */
public class GraphQLTopicDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopic.class, new GraphQLTopicDeserializer());
    }

    public GraphQLTopicDeserializer() {
        a(GraphQLTopic.class);
    }

    public Object m22264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTopic__JsonHelper.m22278a(jsonParser);
    }
}
