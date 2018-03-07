package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: initializeRecorder/reconnect failed */
public class GraphQLEventDeclinesEdgeSerializer extends JsonSerializer<GraphQLEventDeclinesEdge> {
    public final void m7182a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventDeclinesEdge__JsonHelper.m7184a(jsonGenerator, (GraphQLEventDeclinesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventDeclinesEdge.class, new GraphQLEventDeclinesEdgeSerializer());
    }
}
