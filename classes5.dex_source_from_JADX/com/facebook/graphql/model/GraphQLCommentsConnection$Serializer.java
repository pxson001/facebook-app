package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCommentsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_album_attachment */
public final class GraphQLCommentsConnection$Serializer extends JsonSerializer<GraphQLCommentsConnection> {
    public final void m6816a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCommentsConnection graphQLCommentsConnection = (GraphQLCommentsConnection) obj;
        GraphQLCommentsConnectionDeserializer.m4667a(graphQLCommentsConnection.w_(), graphQLCommentsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLCommentsConnection.class, new GraphQLCommentsConnection$Serializer());
        FbSerializerProvider.a(GraphQLCommentsConnection.class, new GraphQLCommentsConnection$Serializer());
    }
}
