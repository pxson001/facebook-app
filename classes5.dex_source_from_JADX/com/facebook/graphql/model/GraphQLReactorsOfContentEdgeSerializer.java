package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_SLOW_CONNECTION */
public class GraphQLReactorsOfContentEdgeSerializer extends JsonSerializer<GraphQLReactorsOfContentEdge> {
    public final void m21351a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReactorsOfContentEdge__JsonHelper.m21353a(jsonGenerator, (GraphQLReactorsOfContentEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLReactorsOfContentEdge.class, new GraphQLReactorsOfContentEdgeSerializer());
    }
}
