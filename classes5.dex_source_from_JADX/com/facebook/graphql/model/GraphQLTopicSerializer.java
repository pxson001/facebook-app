package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Type mismatch. Expected  */
public class GraphQLTopicSerializer extends JsonSerializer<GraphQLTopic> {
    public final void m22277a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopic__JsonHelper.m22279a(jsonGenerator, (GraphQLTopic) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTopic.class, new GraphQLTopicSerializer());
    }
}
