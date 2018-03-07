package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNodeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_privacy_type */
public final class GraphQLNode$Serializer extends JsonSerializer<GraphQLNode> {
    public final void m9289a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        GraphQLNodeDeserializer.m5440b(graphQLNode.w_(), graphQLNode.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLNode.class, new GraphQLNode$Serializer());
        FbSerializerProvider.a(GraphQLNode.class, new GraphQLNode$Serializer());
    }
}
