package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: initCameraSettings/setParameters failed */
public class GraphQLEventHostsEdgeSerializer extends JsonSerializer<GraphQLEventHostsEdge> {
    public final void m7199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventHostsEdge__JsonHelper.m7201a(jsonGenerator, (GraphQLEventHostsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventHostsEdge.class, new GraphQLEventHostsEdgeSerializer());
    }
}
