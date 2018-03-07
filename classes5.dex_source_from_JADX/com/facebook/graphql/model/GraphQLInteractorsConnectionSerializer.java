package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feedback_to_prefetch */
public class GraphQLInteractorsConnectionSerializer extends JsonSerializer<GraphQLInteractorsConnection> {
    public final void m8744a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInteractorsConnection__JsonHelper.m8746a(jsonGenerator, (GraphQLInteractorsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInteractorsConnection.class, new GraphQLInteractorsConnectionSerializer());
    }
}
