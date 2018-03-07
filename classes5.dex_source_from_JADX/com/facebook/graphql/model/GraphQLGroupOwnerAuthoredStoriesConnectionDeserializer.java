package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: otherEventWatchers */
public class GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupOwnerAuthoredStoriesConnection.class, new GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer());
    }

    public GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer() {
        a(GraphQLGroupOwnerAuthoredStoriesConnection.class);
    }

    public Object m8488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupOwnerAuthoredStoriesConnection__JsonHelper.m8490a(jsonParser);
    }
}
