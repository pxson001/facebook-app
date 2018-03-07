package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: eventTime= */
public class GraphQLOpenGraphObjectSerializer extends JsonSerializer<GraphQLOpenGraphObject> {
    public final void m9408a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOpenGraphObject__JsonHelper.m9410a(jsonGenerator, (GraphQLOpenGraphObject) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLOpenGraphObject.class, new GraphQLOpenGraphObjectSerializer());
    }
}
