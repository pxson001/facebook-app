package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLikedProfilesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_ad */
public final class GraphQLLikedProfilesConnection$Serializer extends JsonSerializer<GraphQLLikedProfilesConnection> {
    public final void m8911a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLikedProfilesConnection graphQLLikedProfilesConnection = (GraphQLLikedProfilesConnection) obj;
        GraphQLLikedProfilesConnectionDeserializer.m5317a(graphQLLikedProfilesConnection.w_(), graphQLLikedProfilesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLLikedProfilesConnection.class, new GraphQLLikedProfilesConnection$Serializer());
        FbSerializerProvider.a(GraphQLLikedProfilesConnection.class, new GraphQLLikedProfilesConnection$Serializer());
    }
}
