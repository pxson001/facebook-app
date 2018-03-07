package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: limit must be non-negative */
public class GraphQLErrorSerializer extends JsonSerializer<GraphQLError> {
    public final void m7113a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLError__JsonHelper.m7115a(jsonGenerator, (GraphQLError) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLError.class, new GraphQLErrorSerializer());
    }
}
