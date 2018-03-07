package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_items */
public class GraphQLCommentsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCommentsConnection.class, new GraphQLCommentsConnectionDeserializer());
    }

    public GraphQLCommentsConnectionDeserializer() {
        a(GraphQLCommentsConnection.class);
    }

    public Object m6817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLCommentsConnection__JsonHelper.m6819a(jsonParser);
    }
}
