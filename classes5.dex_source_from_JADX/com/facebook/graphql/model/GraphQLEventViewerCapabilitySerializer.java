package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageSmallCover */
public class GraphQLEventViewerCapabilitySerializer extends JsonSerializer<GraphQLEventViewerCapability> {
    public final void m7325a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventViewerCapability__JsonHelper.m7327a(jsonGenerator, (GraphQLEventViewerCapability) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventViewerCapability.class, new GraphQLEventViewerCapabilitySerializer());
    }
}
