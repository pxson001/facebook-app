package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLOpenGraphObjectDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: eventType= */
public final class GraphQLOpenGraphObject$Serializer extends JsonSerializer<GraphQLOpenGraphObject> {
    public final void m9406a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOpenGraphObject graphQLOpenGraphObject = (GraphQLOpenGraphObject) obj;
        GraphQLOpenGraphObjectDeserializer.m5469b(graphQLOpenGraphObject.w_(), graphQLOpenGraphObject.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLOpenGraphObject.class, new GraphQLOpenGraphObject$Serializer());
        FbSerializerProvider.a(GraphQLOpenGraphObject.class, new GraphQLOpenGraphObject$Serializer());
    }
}
