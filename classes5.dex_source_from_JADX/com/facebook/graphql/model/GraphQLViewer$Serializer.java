package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLViewerDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TemporalEventInfo */
public final class GraphQLViewer$Serializer extends JsonSerializer<GraphQLViewer> {
    public final void m22487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLViewer graphQLViewer = (GraphQLViewer) obj;
        GraphQLViewerDeserializer.m6201a(graphQLViewer.w_(), graphQLViewer.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLViewer.class, new GraphQLViewer$Serializer());
        FbSerializerProvider.a(GraphQLViewer.class, new GraphQLViewer$Serializer());
    }
}
