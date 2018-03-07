package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: missing both likeableId and legacyApiPostid */
public class GraphQLTimelineStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineStoriesConnection.class, new GraphQLTimelineStoriesConnectionDeserializer());
    }

    public GraphQLTimelineStoriesConnectionDeserializer() {
        a(GraphQLTimelineStoriesConnection.class);
    }

    public Object m22227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineStoriesConnection__JsonHelper.m22229a(jsonParser);
    }
}
