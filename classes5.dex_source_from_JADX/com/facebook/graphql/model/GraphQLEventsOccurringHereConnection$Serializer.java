package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventsOccurringHereConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageLarge */
public final class GraphQLEventsOccurringHereConnection$Serializer extends JsonSerializer<GraphQLEventsOccurringHereConnection> {
    public final void m7354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventsOccurringHereConnection graphQLEventsOccurringHereConnection = (GraphQLEventsOccurringHereConnection) obj;
        GraphQLEventsOccurringHereConnectionDeserializer.m4857a(graphQLEventsOccurringHereConnection.w_(), graphQLEventsOccurringHereConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventsOccurringHereConnection.class, new GraphQLEventsOccurringHereConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventsOccurringHereConnection.class, new GraphQLEventsOccurringHereConnection$Serializer());
    }
}
