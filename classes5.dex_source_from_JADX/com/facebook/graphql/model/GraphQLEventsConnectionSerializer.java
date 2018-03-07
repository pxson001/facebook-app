package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageLargeSquare */
public class GraphQLEventsConnectionSerializer extends JsonSerializer<GraphQLEventsConnection> {
    public final void m7350a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventsConnection__JsonHelper.m7352a(jsonGenerator, (GraphQLEventsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventsConnection.class, new GraphQLEventsConnectionSerializer());
    }
}
