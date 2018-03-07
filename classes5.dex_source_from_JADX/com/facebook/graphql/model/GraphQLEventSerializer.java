package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: implicit_location_disabled_by_user */
public class GraphQLEventSerializer extends JsonSerializer<GraphQLEvent> {
    public final void m7261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEvent__JsonHelper.m7345a(jsonGenerator, (GraphQLEvent) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEvent.class, new GraphQLEventSerializer());
    }
}
