package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMobileStoreObjectDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: facecastCameraZoomLevel */
public final class GraphQLMobileStoreObject$Serializer extends JsonSerializer<GraphQLMobileStoreObject> {
    public final void m9135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMobileStoreObject graphQLMobileStoreObject = (GraphQLMobileStoreObject) obj;
        GraphQLMobileStoreObjectDeserializer.m5379a(graphQLMobileStoreObject.w_(), graphQLMobileStoreObject.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMobileStoreObject.class, new GraphQLMobileStoreObject$Serializer());
        FbSerializerProvider.a(GraphQLMobileStoreObject.class, new GraphQLMobileStoreObject$Serializer());
    }
}
