package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getDuration is not supported for SpringAnimator */
public class GraphQLGraphSearchConnectedFriendsEdgeSerializer extends JsonSerializer<GraphQLGraphSearchConnectedFriendsEdge> {
    public final void m8154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchConnectedFriendsEdge__JsonHelper.m8156a(jsonGenerator, (GraphQLGraphSearchConnectedFriendsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchConnectedFriendsEdge.class, new GraphQLGraphSearchConnectedFriendsEdgeSerializer());
    }
}
