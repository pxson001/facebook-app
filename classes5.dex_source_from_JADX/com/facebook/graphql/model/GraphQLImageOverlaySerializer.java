package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: flight_terminal_label */
public class GraphQLImageOverlaySerializer extends JsonSerializer<GraphQLImageOverlay> {
    public final void m8629a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImageOverlay__JsonHelper.m8631a(jsonGenerator, (GraphQLImageOverlay) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLImageOverlay.class, new GraphQLImageOverlaySerializer());
    }
}
