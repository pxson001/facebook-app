package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAttachmentPropertyDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_selected */
public final class GraphQLAttachmentProperty$Serializer extends JsonSerializer<GraphQLAttachmentProperty> {
    public final void m6606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAttachmentProperty graphQLAttachmentProperty = (GraphQLAttachmentProperty) obj;
        GraphQLAttachmentPropertyDeserializer.m4591b(graphQLAttachmentProperty.w_(), graphQLAttachmentProperty.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAttachmentProperty.class, new GraphQLAttachmentProperty$Serializer());
        FbSerializerProvider.a(GraphQLAttachmentProperty.class, new GraphQLAttachmentProperty$Serializer());
    }
}
