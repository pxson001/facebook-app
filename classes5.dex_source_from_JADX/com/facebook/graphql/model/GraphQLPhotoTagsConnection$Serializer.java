package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPhotoTagsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WILDE_GROUPS_TAB_MENU */
public final class GraphQLPhotoTagsConnection$Serializer extends JsonSerializer<GraphQLPhotoTagsConnection> {
    public final void m20748a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoTagsConnection graphQLPhotoTagsConnection = (GraphQLPhotoTagsConnection) obj;
        GraphQLPhotoTagsConnectionDeserializer.m5619a(graphQLPhotoTagsConnection.w_(), graphQLPhotoTagsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoTagsConnection.class, new GraphQLPhotoTagsConnection$Serializer());
        FbSerializerProvider.a(GraphQLPhotoTagsConnection.class, new GraphQLPhotoTagsConnection$Serializer());
    }
}
