package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageVisitsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: email_invite_join_dialogue */
public final class GraphQLPageVisitsConnection$Serializer extends JsonSerializer<GraphQLPageVisitsConnection> {
    public final void m9548a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageVisitsConnection graphQLPageVisitsConnection = (GraphQLPageVisitsConnection) obj;
        GraphQLPageVisitsConnectionDeserializer.m5535a(graphQLPageVisitsConnection.w_(), graphQLPageVisitsConnection.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLPageVisitsConnection.class, new GraphQLPageVisitsConnection$Serializer());
        FbSerializerProvider.a(GraphQLPageVisitsConnection.class, new GraphQLPageVisitsConnection$Serializer());
    }
}
