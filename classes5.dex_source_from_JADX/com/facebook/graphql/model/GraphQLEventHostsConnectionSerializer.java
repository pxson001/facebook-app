package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: initial_view_pitch_degrees */
public class GraphQLEventHostsConnectionSerializer extends JsonSerializer<GraphQLEventHostsConnection> {
    public final void m7190a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventHostsConnection__JsonHelper.m7192a(jsonGenerator, (GraphQLEventHostsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventHostsConnection.class, new GraphQLEventHostsConnectionSerializer());
    }
}
