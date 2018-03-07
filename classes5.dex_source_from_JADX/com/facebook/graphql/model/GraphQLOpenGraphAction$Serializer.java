package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLOpenGraphActionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_buy_ticket_url */
public final class GraphQLOpenGraphAction$Serializer extends JsonSerializer<GraphQLOpenGraphAction> {
    public final void m9392a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOpenGraphAction graphQLOpenGraphAction = (GraphQLOpenGraphAction) obj;
        GraphQLOpenGraphActionDeserializer.m5461b(graphQLOpenGraphAction.w_(), graphQLOpenGraphAction.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLOpenGraphAction.class, new GraphQLOpenGraphAction$Serializer());
        FbSerializerProvider.a(GraphQLOpenGraphAction.class, new GraphQLOpenGraphAction$Serializer());
    }
}
