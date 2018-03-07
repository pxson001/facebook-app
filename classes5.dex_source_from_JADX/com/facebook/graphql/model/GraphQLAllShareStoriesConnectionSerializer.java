package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: java.io.ObjectOuputStream */
public class GraphQLAllShareStoriesConnectionSerializer extends JsonSerializer<GraphQLAllShareStoriesConnection> {
    public final void m6533a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAllShareStoriesConnection__JsonHelper.m6535a(jsonGenerator, (GraphQLAllShareStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAllShareStoriesConnection.class, new GraphQLAllShareStoriesConnectionSerializer());
    }
}
