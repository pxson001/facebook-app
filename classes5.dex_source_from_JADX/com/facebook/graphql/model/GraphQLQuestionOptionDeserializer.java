package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: needle_filters */
public class GraphQLQuestionOptionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuestionOption.class, new GraphQLQuestionOptionDeserializer());
    }

    public GraphQLQuestionOptionDeserializer() {
        a(GraphQLQuestionOption.class);
    }

    public Object m21165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuestionOption__JsonHelper.m21182a(jsonParser);
    }
}
