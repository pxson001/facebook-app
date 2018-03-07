package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_looping */
public class GraphQLBoostedComponentSerializer extends JsonSerializer<GraphQLBoostedComponent> {
    public final void m6662a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBoostedComponent__JsonHelper.m6664a(jsonGenerator, (GraphQLBoostedComponent) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBoostedComponent.class, new GraphQLBoostedComponentSerializer());
    }
}
