package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pair_search */
public class GraphQLExploreFeedDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLExploreFeed.class, new GraphQLExploreFeedDeserializer());
    }

    public GraphQLExploreFeedDeserializer() {
        a(GraphQLExploreFeed.class);
    }

    public Object m7402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLExploreFeed__JsonHelper.m7404a(jsonParser);
    }
}
