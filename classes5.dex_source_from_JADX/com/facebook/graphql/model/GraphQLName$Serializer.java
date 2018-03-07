package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNameDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: extras */
public final class GraphQLName$Serializer extends JsonSerializer<GraphQLName> {
    public final void m9149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLName graphQLName = (GraphQLName) obj;
        GraphQLNameDeserializer.m5387b(graphQLName.w_(), graphQLName.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLName.class, new GraphQLName$Serializer());
        FbSerializerProvider.a(GraphQLName.class, new GraphQLName$Serializer());
    }
}
