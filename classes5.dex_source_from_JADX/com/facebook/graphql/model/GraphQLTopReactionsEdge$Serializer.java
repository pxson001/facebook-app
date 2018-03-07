package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTopReactionsEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UI_EXPLORER */
public final class GraphQLTopReactionsEdge$Serializer extends JsonSerializer<GraphQLTopReactionsEdge> {
    public final void m22254a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopReactionsEdge graphQLTopReactionsEdge = (GraphQLTopReactionsEdge) obj;
        GraphQLTopReactionsEdgeDeserializer.m6109b(graphQLTopReactionsEdge.w_(), graphQLTopReactionsEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTopReactionsEdge.class, new GraphQLTopReactionsEdge$Serializer());
        FbSerializerProvider.a(GraphQLTopReactionsEdge.class, new GraphQLTopReactionsEdge$Serializer());
    }
}
