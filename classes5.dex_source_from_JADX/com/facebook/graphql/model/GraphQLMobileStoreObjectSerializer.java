package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: facecastCameraIndex */
public class GraphQLMobileStoreObjectSerializer extends JsonSerializer<GraphQLMobileStoreObject> {
    public final void m9137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMobileStoreObject__JsonHelper.m9139a(jsonGenerator, (GraphQLMobileStoreObject) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMobileStoreObject.class, new GraphQLMobileStoreObjectSerializer());
    }
}
