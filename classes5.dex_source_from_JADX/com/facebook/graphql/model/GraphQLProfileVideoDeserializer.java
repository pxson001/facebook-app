package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: negativeFeedbackActionOnFeedStory */
public class GraphQLProfileVideoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLProfileVideo.class, new GraphQLProfileVideoDeserializer());
    }

    public GraphQLProfileVideoDeserializer() {
        a(GraphQLProfileVideo.class);
    }

    public Object m21109a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLProfileVideo__JsonHelper.m21111a(jsonParser);
    }
}
