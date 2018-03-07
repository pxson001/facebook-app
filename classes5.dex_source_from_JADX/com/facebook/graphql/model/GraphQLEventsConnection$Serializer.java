package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageLow */
public final class GraphQLEventsConnection$Serializer extends JsonSerializer<GraphQLEventsConnection> {
    public final void m7348a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventsConnection graphQLEventsConnection = (GraphQLEventsConnection) obj;
        GraphQLEventsConnectionDeserializer.m4854a(graphQLEventsConnection.w_(), graphQLEventsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventsConnection.class, new GraphQLEventsConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventsConnection.class, new GraphQLEventsConnection$Serializer());
    }
}
