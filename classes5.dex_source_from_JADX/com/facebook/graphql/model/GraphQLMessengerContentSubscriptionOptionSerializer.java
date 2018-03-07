package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fact_message */
public class GraphQLMessengerContentSubscriptionOptionSerializer extends JsonSerializer<GraphQLMessengerContentSubscriptionOption> {
    public final void m9111a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMessengerContentSubscriptionOption__JsonHelper.m9113a(jsonGenerator, (GraphQLMessengerContentSubscriptionOption) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMessengerContentSubscriptionOption.class, new GraphQLMessengerContentSubscriptionOptionSerializer());
    }
}
