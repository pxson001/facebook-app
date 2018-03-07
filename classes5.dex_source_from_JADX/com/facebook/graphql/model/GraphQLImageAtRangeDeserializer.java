package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: originalDoFrame */
public class GraphQLImageAtRangeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImageAtRange.class, new GraphQLImageAtRangeDeserializer());
    }

    public GraphQLImageAtRangeDeserializer() {
        a(GraphQLImageAtRange.class);
    }

    public Object m8620a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLImageAtRange__JsonHelper.m8622a(jsonParser);
    }
}
