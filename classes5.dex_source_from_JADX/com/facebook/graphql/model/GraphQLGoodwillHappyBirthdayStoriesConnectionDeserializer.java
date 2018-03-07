package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_info_3d_touch */
public class GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillHappyBirthdayStoriesConnection.class, new GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer());
    }

    public GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer() {
        a(GraphQLGoodwillHappyBirthdayStoriesConnection.class);
    }

    public Object m7896a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillHappyBirthdayStoriesConnection__JsonHelper.m7898a(jsonParser);
    }
}
