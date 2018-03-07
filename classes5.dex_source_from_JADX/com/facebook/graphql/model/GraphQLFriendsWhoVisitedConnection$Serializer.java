package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFriendsWhoVisitedConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: harmonization_employee_curation */
public final class GraphQLFriendsWhoVisitedConnection$Serializer extends JsonSerializer<GraphQLFriendsWhoVisitedConnection> {
    public final void m7644a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsWhoVisitedConnection graphQLFriendsWhoVisitedConnection = (GraphQLFriendsWhoVisitedConnection) obj;
        GraphQLFriendsWhoVisitedConnectionDeserializer.m4964a(graphQLFriendsWhoVisitedConnection.w_(), graphQLFriendsWhoVisitedConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsWhoVisitedConnection.class, new GraphQLFriendsWhoVisitedConnection$Serializer());
        FbSerializerProvider.a(GraphQLFriendsWhoVisitedConnection.class, new GraphQLFriendsWhoVisitedConnection$Serializer());
    }
}
