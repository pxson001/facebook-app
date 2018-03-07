package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLOwnedEventsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: error_text */
public final class GraphQLOwnedEventsConnection$Serializer extends JsonSerializer<GraphQLOwnedEventsConnection> {
    public final void m9432a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOwnedEventsConnection graphQLOwnedEventsConnection = (GraphQLOwnedEventsConnection) obj;
        GraphQLOwnedEventsConnectionDeserializer.m5478a(graphQLOwnedEventsConnection.w_(), graphQLOwnedEventsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLOwnedEventsConnection.class, new GraphQLOwnedEventsConnection$Serializer());
        FbSerializerProvider.a(GraphQLOwnedEventsConnection.class, new GraphQLOwnedEventsConnection$Serializer());
    }
}
