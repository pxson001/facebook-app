package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAlbumsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: jewel_install_messenger_promo_fragment */
public final class GraphQLAlbumsConnection$Serializer extends JsonSerializer<GraphQLAlbumsConnection> {
    public final void m6515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) obj;
        GraphQLAlbumsConnectionDeserializer.m4554a(graphQLAlbumsConnection.w_(), graphQLAlbumsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAlbumsConnection.class, new GraphQLAlbumsConnection$Serializer());
        FbSerializerProvider.a(GraphQLAlbumsConnection.class, new GraphQLAlbumsConnection$Serializer());
    }
}
