package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UPDATE_APP */
public class GraphQLSuggestedContentConnectionSerializer extends JsonSerializer<GraphQLSuggestedContentConnection> {
    public final void m22016a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSuggestedContentConnection__JsonHelper.m22018a(jsonGenerator, (GraphQLSuggestedContentConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSuggestedContentConnection.class, new GraphQLSuggestedContentConnectionSerializer());
    }
}
