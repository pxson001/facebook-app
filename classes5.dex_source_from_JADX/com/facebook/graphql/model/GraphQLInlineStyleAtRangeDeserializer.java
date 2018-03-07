package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: orca-crashes@lists.facebook.com */
public class GraphQLInlineStyleAtRangeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInlineStyleAtRange.class, new GraphQLInlineStyleAtRangeDeserializer());
    }

    public GraphQLInlineStyleAtRangeDeserializer() {
        a(GraphQLInlineStyleAtRange.class);
    }

    public Object m8701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInlineStyleAtRange__JsonHelper.m8703a(jsonParser);
    }
}
