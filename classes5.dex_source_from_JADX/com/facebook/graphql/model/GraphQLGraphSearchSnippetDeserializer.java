package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_action_bar */
public class GraphQLGraphSearchSnippetDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchSnippet.class, new GraphQLGraphSearchSnippetDeserializer());
    }

    public GraphQLGraphSearchSnippetDeserializer() {
        a(GraphQLGraphSearchSnippet.class);
    }

    public Object m8318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchSnippet__JsonHelper.m8320a(jsonParser);
    }
}
