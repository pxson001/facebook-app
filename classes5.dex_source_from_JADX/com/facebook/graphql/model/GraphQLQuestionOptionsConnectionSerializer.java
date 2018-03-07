package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_POST_BUTTON */
public class GraphQLQuestionOptionsConnectionSerializer extends JsonSerializer<GraphQLQuestionOptionsConnection> {
    public final void m21190a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuestionOptionsConnection__JsonHelper.m21192a(jsonGenerator, (GraphQLQuestionOptionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuestionOptionsConnection.class, new GraphQLQuestionOptionsConnectionSerializer());
    }
}
