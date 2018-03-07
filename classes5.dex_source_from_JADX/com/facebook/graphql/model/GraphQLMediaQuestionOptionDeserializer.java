package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: on_this_day_birthday_card */
public class GraphQLMediaQuestionOptionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestionOption.class, new GraphQLMediaQuestionOptionDeserializer());
    }

    public GraphQLMediaQuestionOptionDeserializer() {
        a(GraphQLMediaQuestionOption.class);
    }

    public Object m9041a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMediaQuestionOption__JsonHelper.m9043a(jsonParser);
    }
}
