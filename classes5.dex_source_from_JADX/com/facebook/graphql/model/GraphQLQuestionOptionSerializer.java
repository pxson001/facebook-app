package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_THROWBACK */
public class GraphQLQuestionOptionSerializer extends JsonSerializer<GraphQLQuestionOption> {
    public final void m21166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuestionOption__JsonHelper.m21183a(jsonGenerator, (GraphQLQuestionOption) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuestionOption.class, new GraphQLQuestionOptionSerializer());
    }
}
