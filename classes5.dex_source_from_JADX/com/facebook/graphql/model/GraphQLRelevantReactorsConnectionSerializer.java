package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_HORIZONTAL_SCROLL */
public class GraphQLRelevantReactorsConnectionSerializer extends JsonSerializer<GraphQLRelevantReactorsConnection> {
    public final void m21387a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRelevantReactorsConnection__JsonHelper.m21389a(jsonGenerator, (GraphQLRelevantReactorsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLRelevantReactorsConnection.class, new GraphQLRelevantReactorsConnectionSerializer());
    }
}
