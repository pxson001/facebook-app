package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageLikersConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: end_of_privacy_grace_period */
public final class GraphQLPageLikersConnection$Serializer extends JsonSerializer<GraphQLPageLikersConnection> {
    public final void m9491a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageLikersConnection graphQLPageLikersConnection = (GraphQLPageLikersConnection) obj;
        GraphQLPageLikersConnectionDeserializer.m5511a(graphQLPageLikersConnection.w_(), graphQLPageLikersConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPageLikersConnection.class, new GraphQLPageLikersConnection$Serializer());
        FbSerializerProvider.a(GraphQLPageLikersConnection.class, new GraphQLPageLikersConnection$Serializer());
    }
}
