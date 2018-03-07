package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Task was cancelled. */
public class GraphQLViewerVisitsConnectionSerializer extends JsonSerializer<GraphQLViewerVisitsConnection> {
    public final void m22491a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLViewerVisitsConnection__JsonHelper.m22493a(jsonGenerator, (GraphQLViewerVisitsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLViewerVisitsConnection.class, new GraphQLViewerVisitsConnectionSerializer());
    }
}
