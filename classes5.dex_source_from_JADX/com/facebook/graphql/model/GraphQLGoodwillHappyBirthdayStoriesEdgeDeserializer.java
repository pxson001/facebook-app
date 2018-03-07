package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_icon */
public class GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillHappyBirthdayStoriesEdge.class, new GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer());
    }

    public GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer() {
        a(GraphQLGoodwillHappyBirthdayStoriesEdge.class);
    }

    public Object m7905a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillHappyBirthdayStoriesEdge__JsonHelper.m7907a(jsonParser);
    }
}
