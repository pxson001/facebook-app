package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: first_metaline */
public class GraphQLInlineActivitiesConnectionSerializer extends JsonSerializer<GraphQLInlineActivitiesConnection> {
    public final void m8688a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, (GraphQLInlineActivitiesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInlineActivitiesConnection.class, new GraphQLInlineActivitiesConnectionSerializer());
    }
}
