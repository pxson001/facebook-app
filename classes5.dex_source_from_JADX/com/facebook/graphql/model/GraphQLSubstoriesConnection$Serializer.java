package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSubstoriesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UPSELL_FAILURE */
public final class GraphQLSubstoriesConnection$Serializer extends JsonSerializer<GraphQLSubstoriesConnection> {
    public final void m22004a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSubstoriesConnection graphQLSubstoriesConnection = (GraphQLSubstoriesConnection) obj;
        GraphQLSubstoriesConnectionDeserializer.m6016a(graphQLSubstoriesConnection.w_(), graphQLSubstoriesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSubstoriesConnection.class, new GraphQLSubstoriesConnection$Serializer());
        FbSerializerProvider.a(GraphQLSubstoriesConnection.class, new GraphQLSubstoriesConnection$Serializer());
    }
}
