package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPhotoEncodingDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WINERY_VINEYARD */
public final class GraphQLPhotoEncoding$Serializer extends JsonSerializer<GraphQLPhotoEncoding> {
    public final void m20720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoEncoding graphQLPhotoEncoding = (GraphQLPhotoEncoding) obj;
        GraphQLPhotoEncodingDeserializer.m5610b(graphQLPhotoEncoding.w_(), graphQLPhotoEncoding.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoEncoding.class, new GraphQLPhotoEncoding$Serializer());
        FbSerializerProvider.a(GraphQLPhotoEncoding.class, new GraphQLPhotoEncoding$Serializer());
    }
}
