package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventMaybesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: index value outside legal index range [0.. */
public final class GraphQLEventMaybesConnection$Serializer extends JsonSerializer<GraphQLEventMaybesConnection> {
    public final void m7221a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventMaybesConnection graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) obj;
        GraphQLEventMaybesConnectionDeserializer.m4812a(graphQLEventMaybesConnection.w_(), graphQLEventMaybesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventMaybesConnection.class, new GraphQLEventMaybesConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventMaybesConnection.class, new GraphQLEventMaybesConnection$Serializer());
    }
}
