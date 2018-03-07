package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEditActionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_page_header */
public final class GraphQLEditAction$Serializer extends JsonSerializer<GraphQLEditAction> {
    public final void m6957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEditAction graphQLEditAction = (GraphQLEditAction) obj;
        GraphQLEditActionDeserializer.m4720b(graphQLEditAction.w_(), graphQLEditAction.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEditAction.class, new GraphQLEditAction$Serializer());
        FbSerializerProvider.a(GraphQLEditAction.class, new GraphQLEditAction$Serializer());
    }
}
