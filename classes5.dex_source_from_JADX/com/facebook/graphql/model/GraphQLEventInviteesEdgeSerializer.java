package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: infinity */
public class GraphQLEventInviteesEdgeSerializer extends JsonSerializer<GraphQLEventInviteesEdge> {
    public final void m7216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventInviteesEdge__JsonHelper.m7218a(jsonGenerator, (GraphQLEventInviteesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventInviteesEdge.class, new GraphQLEventInviteesEdgeSerializer());
    }
}
