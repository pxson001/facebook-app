package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAlbumDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: job_tag */
public final class GraphQLAlbum$Serializer extends JsonSerializer<GraphQLAlbum> {
    public final void m6507a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAlbum graphQLAlbum = (GraphQLAlbum) obj;
        GraphQLAlbumDeserializer.m4551b(graphQLAlbum.w_(), graphQLAlbum.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAlbum.class, new GraphQLAlbum$Serializer());
        FbSerializerProvider.a(GraphQLAlbum.class, new GraphQLAlbum$Serializer());
    }
}
