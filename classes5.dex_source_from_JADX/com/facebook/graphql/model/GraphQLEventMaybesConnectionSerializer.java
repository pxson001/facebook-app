package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: incompleted */
public class GraphQLEventMaybesConnectionSerializer extends JsonSerializer<GraphQLEventMaybesConnection> {
    public final void m7223a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventMaybesConnection__JsonHelper.m7225a(jsonGenerator, (GraphQLEventMaybesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventMaybesConnection.class, new GraphQLEventMaybesConnectionSerializer());
    }
}
