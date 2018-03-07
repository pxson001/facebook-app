package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventHostsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: initial_view_roll_degrees */
public final class GraphQLEventHostsConnection$Serializer extends JsonSerializer<GraphQLEventHostsConnection> {
    public final void m7188a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventHostsConnection graphQLEventHostsConnection = (GraphQLEventHostsConnection) obj;
        GraphQLEventHostsConnectionDeserializer.m4799a(graphQLEventHostsConnection.w_(), graphQLEventHostsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventHostsConnection.class, new GraphQLEventHostsConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventHostsConnection.class, new GraphQLEventHostsConnection$Serializer());
    }
}
