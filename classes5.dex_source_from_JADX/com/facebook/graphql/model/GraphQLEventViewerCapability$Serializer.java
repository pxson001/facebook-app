package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventViewerCapabilityDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageSmallSquare */
public final class GraphQLEventViewerCapability$Serializer extends JsonSerializer<GraphQLEventViewerCapability> {
    public final void m7323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventViewerCapability graphQLEventViewerCapability = (GraphQLEventViewerCapability) obj;
        GraphQLEventViewerCapabilityDeserializer.m4844a(graphQLEventViewerCapability.w_(), graphQLEventViewerCapability.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLEventViewerCapability.class, new GraphQLEventViewerCapability$Serializer());
        FbSerializerProvider.a(GraphQLEventViewerCapability.class, new GraphQLEventViewerCapability$Serializer());
    }
}
