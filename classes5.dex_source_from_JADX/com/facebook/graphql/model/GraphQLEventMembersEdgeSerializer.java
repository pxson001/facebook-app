package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: importance */
public class GraphQLEventMembersEdgeSerializer extends JsonSerializer<GraphQLEventMembersEdge> {
    public final void m7257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventMembersEdge__JsonHelper.m7259a(jsonGenerator, (GraphQLEventMembersEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventMembersEdge.class, new GraphQLEventMembersEdgeSerializer());
    }
}
