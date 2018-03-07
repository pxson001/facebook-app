package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: error_message_detail */
public class GraphQLOwnedEventsConnectionSerializer extends JsonSerializer<GraphQLOwnedEventsConnection> {
    public final void m9434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOwnedEventsConnection__JsonHelper.m9436a(jsonGenerator, (GraphQLOwnedEventsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLOwnedEventsConnection.class, new GraphQLOwnedEventsConnectionSerializer());
    }
}
