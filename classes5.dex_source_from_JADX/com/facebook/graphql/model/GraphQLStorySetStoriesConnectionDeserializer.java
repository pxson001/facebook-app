package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_page_suggestions_on_liking */
public class GraphQLStorySetStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStorySetStoriesConnection.class, new GraphQLStorySetStoriesConnectionDeserializer());
    }

    public GraphQLStorySetStoriesConnectionDeserializer() {
        a(GraphQLStorySetStoriesConnection.class);
    }

    public Object m21911a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStorySetStoriesConnection__JsonHelper.m21913a(jsonParser);
    }
}
