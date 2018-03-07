package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPostedPhotosConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewerReactionsMutation */
public final class GraphQLPostedPhotosConnection$Serializer extends JsonSerializer<GraphQLPostedPhotosConnection> {
    public final void m20971a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPostedPhotosConnection graphQLPostedPhotosConnection = (GraphQLPostedPhotosConnection) obj;
        GraphQLPostedPhotosConnectionDeserializer.m5687a(graphQLPostedPhotosConnection.w_(), graphQLPostedPhotosConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPostedPhotosConnection.class, new GraphQLPostedPhotosConnection$Serializer());
        FbSerializerProvider.a(GraphQLPostedPhotosConnection.class, new GraphQLPostedPhotosConnection$Serializer());
    }
}
