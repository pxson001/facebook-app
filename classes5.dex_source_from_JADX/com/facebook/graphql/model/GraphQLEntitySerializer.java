package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: instructions_url */
public class GraphQLEntitySerializer extends JsonSerializer<GraphQLEntity> {
    public final void m7094a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntity__JsonHelper.m7103a(jsonGenerator, (GraphQLEntity) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEntity.class, new GraphQLEntitySerializer());
    }
}
