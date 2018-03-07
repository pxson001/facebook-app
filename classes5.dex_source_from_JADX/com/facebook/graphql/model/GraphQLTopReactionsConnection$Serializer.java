package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTopReactionsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNARCHIVE_BUTTON */
public final class GraphQLTopReactionsConnection$Serializer extends JsonSerializer<GraphQLTopReactionsConnection> {
    public final void m22249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopReactionsConnection graphQLTopReactionsConnection = (GraphQLTopReactionsConnection) obj;
        GraphQLTopReactionsConnectionDeserializer.m6106a(graphQLTopReactionsConnection.w_(), graphQLTopReactionsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTopReactionsConnection.class, new GraphQLTopReactionsConnection$Serializer());
        FbSerializerProvider.a(GraphQLTopReactionsConnection.class, new GraphQLTopReactionsConnection$Serializer());
    }
}
