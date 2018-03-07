package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMessengerContentSubscriptionOptionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fact_time */
public final class GraphQLMessengerContentSubscriptionOption$Serializer extends JsonSerializer<GraphQLMessengerContentSubscriptionOption> {
    public final void m9109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMessengerContentSubscriptionOption graphQLMessengerContentSubscriptionOption = (GraphQLMessengerContentSubscriptionOption) obj;
        GraphQLMessengerContentSubscriptionOptionDeserializer.m5369a(graphQLMessengerContentSubscriptionOption.w_(), graphQLMessengerContentSubscriptionOption.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMessengerContentSubscriptionOption.class, new GraphQLMessengerContentSubscriptionOption$Serializer());
        FbSerializerProvider.a(GraphQLMessengerContentSubscriptionOption.class, new GraphQLMessengerContentSubscriptionOption$Serializer());
    }
}
