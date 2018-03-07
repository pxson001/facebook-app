package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: method_name */
public class GraphQLUnseenStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUnseenStoriesConnection.class, new GraphQLUnseenStoriesConnectionDeserializer());
    }

    public GraphQLUnseenStoriesConnectionDeserializer() {
        a(GraphQLUnseenStoriesConnection.class);
    }

    public Object m22354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLUnseenStoriesConnection__JsonHelper.m22356a(jsonParser);
    }
}
