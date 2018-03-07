package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offsetY */
public class GraphQLNodeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNode.class, new GraphQLNodeDeserializer());
    }

    public GraphQLNodeDeserializer() {
        a(GraphQLNode.class);
    }

    public Object m9290a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNode__JsonHelper.m9292a(jsonParser);
    }
}
