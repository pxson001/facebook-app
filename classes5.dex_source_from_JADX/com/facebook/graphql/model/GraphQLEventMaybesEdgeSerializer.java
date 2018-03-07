package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: inapp_browser_prefetch_vpv_duration_threshold */
public class GraphQLEventMaybesEdgeSerializer extends JsonSerializer<GraphQLEventMaybesEdge> {
    public final void m7236a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventMaybesEdge__JsonHelper.m7238a(jsonGenerator, (GraphQLEventMaybesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventMaybesEdge.class, new GraphQLEventMaybesEdgeSerializer());
    }
}
