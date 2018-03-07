package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEditHistoryConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_nearby_friends_self_view_unknown_region */
public final class GraphQLEditHistoryConnection$Serializer extends JsonSerializer<GraphQLEditHistoryConnection> {
    public final void m6965a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEditHistoryConnection graphQLEditHistoryConnection = (GraphQLEditHistoryConnection) obj;
        GraphQLEditHistoryConnectionDeserializer.m4723a(graphQLEditHistoryConnection.w_(), graphQLEditHistoryConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEditHistoryConnection.class, new GraphQLEditHistoryConnection$Serializer());
        FbSerializerProvider.a(GraphQLEditHistoryConnection.class, new GraphQLEditHistoryConnection$Serializer());
    }
}
