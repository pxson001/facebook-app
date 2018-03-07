package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_feed_simulation */
public class GraphQLAllShareStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAllShareStoriesConnection.class, new GraphQLAllShareStoriesConnectionDeserializer());
    }

    public GraphQLAllShareStoriesConnectionDeserializer() {
        a(GraphQLAllShareStoriesConnection.class);
    }

    public Object m6532a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAllShareStoriesConnection__JsonHelper.m6534a(jsonParser);
    }
}
