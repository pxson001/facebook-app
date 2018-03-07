package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_place */
public class GraphQLNodeSerializer extends JsonSerializer<GraphQLNode> {
    public final void m9291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNode__JsonHelper.m9293a(jsonGenerator, (GraphQLNode) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNode.class, new GraphQLNodeSerializer());
    }
}
