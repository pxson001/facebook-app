package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: on_this_day_feed */
public class GraphQLMediaQuestionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestion.class, new GraphQLMediaQuestionDeserializer());
    }

    public GraphQLMediaQuestionDeserializer() {
        a(GraphQLMediaQuestion.class);
    }

    public Object m9027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMediaQuestion__JsonHelper.m9061a(jsonParser);
    }
}
