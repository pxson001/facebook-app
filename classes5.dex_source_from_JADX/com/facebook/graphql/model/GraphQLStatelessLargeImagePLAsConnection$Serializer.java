package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStatelessLargeImagePLAsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unknown */
public final class GraphQLStatelessLargeImagePLAsConnection$Serializer extends JsonSerializer<GraphQLStatelessLargeImagePLAsConnection> {
    public final void m21818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStatelessLargeImagePLAsConnection graphQLStatelessLargeImagePLAsConnection = (GraphQLStatelessLargeImagePLAsConnection) obj;
        GraphQLStatelessLargeImagePLAsConnectionDeserializer.m5941a(graphQLStatelessLargeImagePLAsConnection.w_(), graphQLStatelessLargeImagePLAsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStatelessLargeImagePLAsConnection.class, new GraphQLStatelessLargeImagePLAsConnection$Serializer());
        FbSerializerProvider.a(GraphQLStatelessLargeImagePLAsConnection.class, new GraphQLStatelessLargeImagePLAsConnection$Serializer());
    }
}
