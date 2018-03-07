package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_sidebar */
public class GraphQLStoryDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStory.class, new GraphQLStoryDeserializer());
    }

    public GraphQLStoryDeserializer() {
        a(GraphQLStory.class);
    }

    public Object m21865a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStory__JsonHelper.m21922a(jsonParser);
    }
}
