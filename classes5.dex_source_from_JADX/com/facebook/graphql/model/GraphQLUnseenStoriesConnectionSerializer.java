package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Total Idle usage  */
public class GraphQLUnseenStoriesConnectionSerializer extends JsonSerializer<GraphQLUnseenStoriesConnection> {
    public final void m22355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUnseenStoriesConnection__JsonHelper.m22357a(jsonGenerator, (GraphQLUnseenStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLUnseenStoriesConnection.class, new GraphQLUnseenStoriesConnectionSerializer());
    }
}
