package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: order does not contain a valid category. */
public class GraphQLInlineActivityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInlineActivity.class, new GraphQLInlineActivityDeserializer());
    }

    public GraphQLInlineActivityDeserializer() {
        a(GraphQLInlineActivity.class);
    }

    public Object m8694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInlineActivity__JsonHelper.m8696a(jsonParser);
    }
}
