package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: inject_status */
public class GraphQLEventDeclinesConnectionSerializer extends JsonSerializer<GraphQLEventDeclinesConnection> {
    public final void m7168a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventDeclinesConnection__JsonHelper.m7170a(jsonGenerator, (GraphQLEventDeclinesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventDeclinesConnection.class, new GraphQLEventDeclinesConnectionSerializer());
    }
}
