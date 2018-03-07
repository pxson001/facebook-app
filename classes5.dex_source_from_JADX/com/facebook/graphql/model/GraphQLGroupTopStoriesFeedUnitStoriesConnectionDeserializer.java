package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: otherEventMaybes */
public class GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupTopStoriesFeedUnitStoriesConnection.class, new GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer());
    }

    public GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer() {
        a(GraphQLGroupTopStoriesFeedUnitStoriesConnection.class);
    }

    public Object m8504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupTopStoriesFeedUnitStoriesConnection__JsonHelper.m8506a(jsonParser);
    }
}
