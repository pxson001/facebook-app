package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLImportantReactorsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: flight_gate_label */
public final class GraphQLImportantReactorsConnection$Serializer extends JsonSerializer<GraphQLImportantReactorsConnection> {
    public final void m8636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImportantReactorsConnection graphQLImportantReactorsConnection = (GraphQLImportantReactorsConnection) obj;
        GraphQLImportantReactorsConnectionDeserializer.m5233a(graphQLImportantReactorsConnection.w_(), graphQLImportantReactorsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLImportantReactorsConnection.class, new GraphQLImportantReactorsConnection$Serializer());
        FbSerializerProvider.a(GraphQLImportantReactorsConnection.class, new GraphQLImportantReactorsConnection$Serializer());
    }
}
