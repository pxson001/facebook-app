package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStreamingImageDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_DISABLED */
public final class GraphQLStreamingImage$Serializer extends JsonSerializer<GraphQLStreamingImage> {
    public final void m21926a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) obj;
        GraphQLStreamingImageDeserializer.m5993a(graphQLStreamingImage.w_(), graphQLStreamingImage.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLStreamingImage.class, new GraphQLStreamingImage$Serializer());
        FbSerializerProvider.a(GraphQLStreamingImage.class, new GraphQLStreamingImage$Serializer());
    }
}
