package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_tips */
public class GraphQLGraphSearchQueryDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQuery.class, new GraphQLGraphSearchQueryDeserializer());
    }

    public GraphQLGraphSearchQueryDeserializer() {
        a(GraphQLGraphSearchQuery.class);
    }

    public Object m8198a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchQuery__JsonHelper.m8265a(jsonParser);
    }
}
