package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLDocumentElementDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_place_creation_old_source */
public final class GraphQLDocumentElement$Serializer extends JsonSerializer<GraphQLDocumentElement> {
    public final void m6951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLDocumentElement graphQLDocumentElement = (GraphQLDocumentElement) obj;
        GraphQLDocumentElementDeserializer.m4717a(graphQLDocumentElement.w_(), graphQLDocumentElement.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLDocumentElement.class, new GraphQLDocumentElement$Serializer());
        FbSerializerProvider.a(GraphQLDocumentElement.class, new GraphQLDocumentElement$Serializer());
    }
}
