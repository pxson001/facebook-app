package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photos_of_page */
public class GraphQLBylineFragmentDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBylineFragment.class, new GraphQLBylineFragmentDeserializer());
    }

    public GraphQLBylineFragmentDeserializer() {
        a(GraphQLBylineFragment.class);
    }

    public Object m6709a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBylineFragment__JsonHelper.m6711a(jsonParser);
    }
}
