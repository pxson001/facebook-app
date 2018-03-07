package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_center_requests */
public class GraphQLGroupMembersEdgeSerializer extends JsonSerializer<GraphQLGroupMembersEdge> {
    public final void m8468a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMembersEdge__JsonHelper.m8470a(jsonGenerator, (GraphQLGroupMembersEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMembersEdge.class, new GraphQLGroupMembersEdgeSerializer());
    }
}
