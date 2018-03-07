package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UPCOMING_EVENTS */
public class GraphQLSuggestedVideoConnectionSerializer extends JsonSerializer<GraphQLSuggestedVideoConnection> {
    public final void m22025a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSuggestedVideoConnection__JsonHelper.m22027a(jsonGenerator, (GraphQLSuggestedVideoConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSuggestedVideoConnection.class, new GraphQLSuggestedVideoConnectionSerializer());
    }
}
