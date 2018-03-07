package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fan_favorite */
public class GraphQLMediaQuestionSerializer extends JsonSerializer<GraphQLMediaQuestion> {
    public final void m9060a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaQuestion__JsonHelper.m9062a(jsonGenerator, (GraphQLMediaQuestion) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaQuestion.class, new GraphQLMediaQuestionSerializer());
    }
}
